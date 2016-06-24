package kkdev.kksystem.plugin.controls.manager;

import java.util.HashMap;
import kkdev.kksystem.base.classes.base.PinData;
import kkdev.kksystem.base.classes.base.PinDataFtrCtx;
import kkdev.kksystem.base.classes.base.PinDataTaggedObj;
import kkdev.kksystem.base.classes.controls.PinDataControl;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerControls;
import kkdev.kksystem.base.constants.PluginConsts;
import static kkdev.kksystem.base.constants.SystemConsts.KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID;
import kkdev.kksystem.plugin.controls.KKPlugin;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.adapters.debug.DebugAdapterConsole;
import kkdev.kksystem.plugin.controls.adapters.rpi.RPIControlAdapter;
import kkdev.kksystem.plugin.controls.adapters.rpi.RPII2CAdapter;
import kkdev.kksystem.plugin.controls.adapters.smarthead.Smarthead;
import kkdev.kksystem.plugin.controls.adapters.unilinux.UNIL_RS232Adapter;
import kkdev.kksystem.plugin.controls.configuration.Adapter;
import kkdev.kksystem.plugin.controls.configuration.Control;
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
    IHWAdapter SmartheadAdapter;

    private String ___CurrentUIContext;

    public ControlsManager() {
        currentFeature = new HashMap<>();
        this.AdapterCallback = new IHWAdapterCallback() {
            @Override
            public void Control_Triggered(Control Ctrl) {
                String[] Target = GetTargetFeature(Ctrl);

                for (String TR : Target) {
                    CONTROL_SendPluginMessageData(TR, GetTargetUIContext(Ctrl), Ctrl.buttonID, PinDataControl.KK_CONTROL_DATA.CONTROL_TRIGGERED, 1);
                }
            }

            @Override
            public void Control_SwitchOn(Control Ctrl) {
                String[] Target = GetTargetFeature(Ctrl);

                for (String TR : Target) {
                    CONTROL_SendPluginMessageData(TR, GetTargetUIContext(Ctrl), Ctrl.buttonID, PinDataControl.KK_CONTROL_DATA.CONTROL_ACTIVATE, 1);
                }
            }

            @Override
            public void Control_SwitchOff(Control Ctrl) {
                String[] Target = GetTargetFeature(Ctrl);

                for (String TR : Target) {
                    CONTROL_SendPluginMessageData(TR, GetTargetUIContext(Ctrl), Ctrl.buttonID, PinDataControl.KK_CONTROL_DATA.CONTROL_DEACTIVATE, 0);
                }
            }

            @Override
            public void Control_ChangeState(Control Ctrl, int State) {
                String[] Target = GetTargetFeature(Ctrl);

                for (String TR : Target) {
                    CONTROL_SendPluginMessageData(TR, GetTargetUIContext(Ctrl), Ctrl.buttonID, PinDataControl.KK_CONTROL_DATA.CONTROL_CHANGEVALUE, State);
                }
            }

            @Override
            public void Control_LongPress(Control Ctrl, int State) {
                String[] Target = GetTargetFeature(Ctrl);

                for (String TR : Target) {
                    CONTROL_SendPluginMessageData(TR, GetTargetUIContext(Ctrl), Ctrl.buttonID, PinDataControl.KK_CONTROL_DATA.CONTROL_LONGPRESS, State);
                }
            }

            private String[] GetTargetFeature(Control Ctrl) {
                String Ret[];

                if (Ctrl.FixedFeature) {
                    Ret = new String[1];
                    Ret[0] = Ctrl.FixedFeatureTarget;
                } else if (Ctrl.Global) {
                    Ret = new String[2];
                    Ret[0] = KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID;
                    Ret[1] = currentFeature.get(___CurrentUIContext);
                } else {
                    Ret = new String[1];
                    Ret[0] = currentFeature.get(___CurrentUIContext);
                }

                return Ret;
            }

            private String GetTargetUIContext(Control Ctrl) {
                if (Ctrl.FixedContext) {
                    return Ctrl.FixedContextTarget;
               // } else if (Ctrl.Global) {
                //    return KK_BASE_UICONTEXT_DEFAULT_MULTI;
                } else {
                    return ___CurrentUIContext;//Ctrl.CurrentUIContext;
                }
            }
        };
    }

    public void InitControls(KKPlugin PConnector) {
        connector = PConnector;
        //
        //Only one feature supported by now
        //
        PluginSettings.InitConfig(PConnector.globalConfID, PConnector.pluginInfo.getPluginInfo().PluginUUID);
        InitAdapters();
    }

    private void InitAdapters() {
        HWAdapters = new HashMap<>();

        for (Control CTR : PluginSettings.MainConfiguration.Controls) {
            //System.out.println("[CTL] " +CTR.Name + " " + CTR.AdapterID);
            if (!HWAdapters.containsKey(CTR.AdapterID)) {
                HWAdapters.put(CTR.AdapterID, CreateAdapter(CTR.AdapterID));
            }
            //
            HWAdapters.get(CTR.AdapterID).registerControl(CTR, AdapterCallback);
        }
    }

    private IHWAdapter CreateAdapter(String AdapterID) {
        for (Adapter ADP : PluginSettings.MainConfiguration.Adapters) {
            if (ADP.ID.equals(AdapterID)) {
                if (null != ADP.Type) {
                    switch (ADP.Type) {
                        case RaspberryPI_B: //Base RPI GPIO
                            return new RPIControlAdapter();
                        case Debug:         //Debug
                            return new DebugAdapterConsole();
                        case RaspberryPI_B_PI4J_I2C: // RPI i2c Bus
                            return new RPII2CAdapter(ADP);
                        case UniversalLinux_RS232:   // Universal rs232 bus
                            return new UNIL_RS232Adapter(ADP);
                        case KKSmarthead:   // Smarthead source
                            SmartheadAdapter = new Smarthead(ADP);
                            return SmartheadAdapter;
                        default:
                            break;
                    }
                }
            }
        }
        return new DebugAdapterConsole();
    }

    public void PluginStart() {
        for (String K : HWAdapters.keySet()) {
            HWAdapters.get(K).setActive();
        }
    }

    public void PluginStop() {
        for (String K : HWAdapters.keySet()) {
            HWAdapters.get(K).setInactive();
        }
    }

    public void ReceivePin(String PinName, PinData pinData) {
        switch (PinName) {
            case PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND:
                ProcessBaseCommand((PinDataFtrCtx)pinData);
                break;
            case PluginConsts.KK_PLUGIN_BASE_BASIC_TAGGEDOBJ_DATA:
                ProcessObjPinData((PinDataTaggedObj)pinData);
                break;
        }

    }

    private void ProcessObjPinData(PinDataTaggedObj Obj) {
        if (Obj.tag.equals("SMARTHEAD")) {
            if (SmartheadAdapter != null) {
                SmartheadAdapter.receiveObjPin(Obj);
            }
        }
    }

    private void ProcessBaseCommand(PinDataFtrCtx Command) {
        switch (Command.managementCommand) {
            case ChangeFeature:
                ___CurrentUIContext = Command.changeUIContextID;
                if (!currentFeature.containsKey(Command.changeUIContextID)) {
                    currentFeature.put(Command.changeUIContextID, Command.changeFeatureID);
                }

                if (currentFeature.get(Command.changeUIContextID).equals(Command.changeFeatureID)) {
                    return;
                } else {
                    currentFeature.put(Command.changeUIContextID, Command.changeFeatureID);
                }
                break;
        }
    }

}
