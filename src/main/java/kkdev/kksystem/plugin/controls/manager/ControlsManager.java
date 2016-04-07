package kkdev.kksystem.plugin.controls.manager;

import java.util.HashMap;
import kkdev.kksystem.base.classes.base.PinBaseCommand;
import kkdev.kksystem.base.classes.controls.PinControlData;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerControls;
import kkdev.kksystem.base.constants.PluginConsts;
import static kkdev.kksystem.base.constants.SystemConsts.KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID;
import static kkdev.kksystem.base.constants.SystemConsts.KK_BASE_UICONTEXT_DEFAULT_MULTI;
import kkdev.kksystem.plugin.controls.KKPlugin;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.adapters.debug.DebugAdapterConsole;
import kkdev.kksystem.plugin.controls.adapters.rpi.RPIControlAdapter;
import kkdev.kksystem.plugin.controls.adapters.rpi.RPII2CAdapter;
import kkdev.kksystem.plugin.controls.adapters.unilinux.UNIL_RS232Adapter;
import kkdev.kksystem.plugin.controls.configuration.Adapter;
import kkdev.kksystem.plugin.controls.configuration.Control;
import kkdev.kksystem.plugin.controls.configuration.ControlsConfig;
import kkdev.kksystem.plugin.controls.configuration.PluginSettings;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author blinov_is
 */
public class ControlsManager extends PluginManagerControls {

    private final IHWAdapterCallback AdapterCallback;
    HashMap<String, IHWAdapter> HWAdapters;

    public ControlsManager() {
        CurrentFeature = new HashMap<>();
        this.AdapterCallback = new IHWAdapterCallback() {
            @Override
            public void Control_Triggered(Control Ctrl) {

                CONTROL_SendPluginMessageData(GetTargetFeature(Ctrl),GetTargetUIContext(Ctrl), Ctrl.ID, PinControlData.KK_CONTROL_DATA.CONTROL_TRIGGERED, 1);
            }

            @Override
            public void Control_SwitchOn(Control Ctrl) {

                CONTROL_SendPluginMessageData(GetTargetFeature(Ctrl),GetTargetUIContext(Ctrl), Ctrl.ID, PinControlData.KK_CONTROL_DATA.CONTROL_ACTIVATE, 1);
            }

            @Override
            public void Control_SwitchOff(Control Ctrl) {

                CONTROL_SendPluginMessageData(GetTargetFeature(Ctrl),GetTargetUIContext(Ctrl), Ctrl.ID, PinControlData.KK_CONTROL_DATA.CONTROL_DEACTIVATE, 0);
            }

            @Override
            public void Control_ChangeState(Control Ctrl, int State) {

                CONTROL_SendPluginMessageData(GetTargetFeature(Ctrl),GetTargetUIContext(Ctrl), Ctrl.ID, PinControlData.KK_CONTROL_DATA.CONTROL_CHANGEVALUE, State);
            }

            @Override
            public void Control_LongPress(Control Ctrl, int State) {
                CONTROL_SendPluginMessageData(GetTargetFeature(Ctrl),GetTargetUIContext(Ctrl), Ctrl.ID, PinControlData.KK_CONTROL_DATA.CONTROL_LONGPRESS, State);
            }   

            private String GetTargetFeature(Control Ctrl) {
                if (Ctrl.FixedFeature) {
                    return Ctrl.FixedFeatureTarget;
                } else if (Ctrl.Global) {
                    return KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID;
                } else {
                    return CurrentFeature.get(Ctrl.CurrentUIContext);
                }
            }
              private String GetTargetUIContext(Control Ctrl) {
                if (Ctrl.FixedContext) {
                    return Ctrl.FixedContextTarget;
                } else if (Ctrl.Global) {
                    return KK_BASE_UICONTEXT_DEFAULT_MULTI;
                } else {
                    return Ctrl.CurrentUIContext;
                }
            }
        };
    }

    public void InitControls(KKPlugin PConnector) {
        Connector = PConnector;
        //
        //Only one feature supported by now
        //
        PluginSettings.InitConfig(PConnector.GlobalConfID, PConnector.PluginInfo.GetPluginInfo().PluginUUID);
        InitAdapters();
    }

    private void InitAdapters() {
        HWAdapters = new HashMap<>();

        for (Control CTR : PluginSettings.MainConfiguration.Controls) {
            if (!HWAdapters.containsKey(CTR.AdapterID)) {
                HWAdapters.put(CTR.AdapterID, CreateAdapter(CTR.AdapterID));
            }
            //
            HWAdapters.get(CTR.AdapterID).RegisterControl(CTR, AdapterCallback);
        }
    }

    private IHWAdapter CreateAdapter(String AdapterID) {
        for (Adapter ADP : PluginSettings.MainConfiguration.Adapters) {
            if (ADP.ID.equals(AdapterID)) {
                if (null != ADP.Type) switch (ADP.Type) {
                    case RaspberryPI_B: //Base RPI GPIO
                        return new RPIControlAdapter();
                    case Debug:         //Debug
                        return new DebugAdapterConsole();
                    case RaspberryPI_B_PI4J_I2C: // RPI i2c Bus
                        return new RPII2CAdapter(ADP);
                    case UniversalLinux_RS232:   // Universal rs232 bus
                        return new UNIL_RS232Adapter(ADP);
                    default:
                        break;
                }
            }
        }
        return new DebugAdapterConsole();
    }

    public void PluginStart() {
        for (String K : HWAdapters.keySet()) {
            HWAdapters.get(K).SetActive();
        }
    }

    public void PluginStop() {
        for (String K : HWAdapters.keySet()) {
            HWAdapters.get(K).SetInactive();
        }
    }

    public void ReceivePin(String PinName, Object PinData) {
        switch (PinName) {
            case PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND:
                ProcessBaseCommand((PinBaseCommand) PinData);
        }

    }

    private void ProcessBaseCommand(PinBaseCommand Command) {
        switch (Command.BaseCommand) {
            case CHANGE_FEATURE:
                if (!CurrentFeature.containsKey(Command.ChangeUIContextID))
                    CurrentFeature.put(Command.ChangeUIContextID, Command.ChangeFeatureID);
                
                if (CurrentFeature.get(Command.ChangeUIContextID).equals(Command.ChangeFeatureID))
                    return;
                else
                    CurrentFeature.put(Command.ChangeUIContextID,Command.ChangeFeatureID);
                break;
            case PLUGIN:
                break;
        }
    }

}
