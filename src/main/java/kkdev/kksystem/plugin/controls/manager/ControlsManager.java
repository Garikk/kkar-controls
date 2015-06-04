package kkdev.kksystem.plugin.controls.manager;

import java.util.HashMap;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerControls;
import kkdev.kksystem.base.constants.PluginConsts;
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

    HashMap<String, IHWAdapter> HWAdapters;

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
                HWAdapters.get(CTR.AdapterID).RegisterHIDControl(CTR.AdapterSource, CTR.AdapterSource,CTR.ID, new IHWAdapterCallback(){});
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
                //PinOdb2Command CMD;
            //CMD = (PinOdb2Command) PinData;
            // ProcessCommand(CMD);
        }

    }

}
