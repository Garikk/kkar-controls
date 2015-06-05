package kkdev.kksystem.plugin.controls.manager;

import java.util.HashMap;
import kkdev.kksystem.base.classes.base.PinBaseCommand;
import kkdev.kksystem.base.classes.controls.PinControlData;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerControls;
import kkdev.kksystem.base.constants.PluginConsts;
import static kkdev.kksystem.base.constants.SystemConsts.KK_BASE_FEATURES_ODB_DIAG_UID;
import static kkdev.kksystem.base.constants.SystemConsts.KK_BASE_FEATURES_SYSTEM_BROADCAST_UID;
import static kkdev.kksystem.base.constants.SystemConsts.KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID;
import kkdev.kksystem.plugin.controls.KKPlugin;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.adapters.debug.DebugAdapter;
import kkdev.kksystem.plugin.controls.adapters.rpi.RPIControlAdapter;
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
    
    private String CurrentFeature;
    private final IHWAdapterCallback AdapterCallback;
    HashMap<String, IHWAdapter> HWAdapters;

    public ControlsManager() {
        
        this.AdapterCallback = new IHWAdapterCallback() {
            
            @Override
            public void Control_Triggered(String ControlID, boolean Global) {
                if (Global)
                    CONTROL_SendPluginMessageData(KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_TRIGGERED, 1);
                else
                    CONTROL_SendPluginMessageData(CurrentFeature, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_TRIGGERED, 1);
            }
            
            @Override
            public void Control_SwitchOn(String ControlID, boolean Global) {
                if (Global)
                    CONTROL_SendPluginMessageData(KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_ACTIVATE, 1);
                else
                    CONTROL_SendPluginMessageData(CurrentFeature, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_ACTIVATE, 1);
            }
            
            @Override
            public void Control_SwitchOff(String ControlID, boolean Global) {
                if (Global)
                    CONTROL_SendPluginMessageData(KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_DEACTIVATE, 0);
                else
                    CONTROL_SendPluginMessageData(CurrentFeature, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_DEACTIVATE, 0);
            }
            
            @Override
            public void Control_ChangeState(String ControlID, boolean Global, int State) {
                if (Global)
                    CONTROL_SendPluginMessageData(KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_CHANGEVALUE, State);
                else
                    CONTROL_SendPluginMessageData(CurrentFeature, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_CHANGEVALUE, State);
            }
             @Override
            public void Control_LongPress(String ControlID, boolean Global, int State) {
                if (Global)
                    CONTROL_SendPluginMessageData(KK_BASE_FEATURES_SYSTEM_MULTIFEATURE_UID, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_LONGPRESS, State);
                else
                    CONTROL_SendPluginMessageData(CurrentFeature, ControlID, PinControlData.KK_CONTROL_DATA.CONTROL_LONGPRESS, State);
            }
        };
    }

    public void InitControls(KKPlugin PConnector) {
        Connector = PConnector;
        //
        System.out.println("[Controls][INIT] ODB adapter initialising");
        System.out.println("[Controls][CONFIG] Load configuration");
        PluginSettings.InitConfig();
        System.out.println("[Controls][CONFIG] Connect adapters");
        InitAdapters();
    }

    private void InitAdapters() {
        HWAdapters = new HashMap<>();

        for (Control CTR : PluginSettings.MainConfiguration.Controls) {
            if (!HWAdapters.containsKey(CTR.AdapterID)) {
                HWAdapters.put(CTR.AdapterID, CreateAdapter(CTR.AdapterID));
            }
           //
                HWAdapters.get(CTR.AdapterID).RegisterControl(CTR.AdapterSource, CTR.AdapterSource,CTR,AdapterCallback);
        }
    }
    
    private IHWAdapter CreateAdapter(String AdapterID) {
        for (Adapter ADP : PluginSettings.MainConfiguration.Adapters) {
            if (ADP.ID.equals(AdapterID)) {
                if (ADP.Type == ControlsConfig.AdapterType.RaspberryPI_B) {
                    return new RPIControlAdapter();
                }
            }
        }
        return new DebugAdapter();
    }

    
    public void ReceivePin(String PinName, Object PinData) {
        System.out.println("[DEBUG][HID] " + PinName);
        switch (PinName) {
            case PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND:
                ProcessBaseCommand((PinBaseCommand)PinData);
        }

    }
      private void ProcessBaseCommand(PinBaseCommand Command) {
        switch (Command.BaseCommand) {
            case CHANGE_FEATURE:
                System.out.println("[Controls][MANAGER] Feature changed >> " + CurrentFeature + " >> " + Command.ChangeFeatureID);
                CurrentFeature=Command.ChangeFeatureID;
                break;
            case PLUGIN:
                break;
        }
    }

}
