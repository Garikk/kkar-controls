package kkdev.kksystem.plugin.controls.manager;

import kkdev.kksystem.base.classes.odb2.ODBConstants.KK_ODB_DATAPACKET;
import kkdev.kksystem.base.classes.odb2.PinOdb2Command;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerHID;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.plugin.KKPlugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author blinov_is
 */
public class ControlsManager extends PluginManagerHID {

    public void InitHID(KKPlugin PConnector) {
        Connector=PConnector;
        System.out.println("[HID][INIT] ODB adapter initialising");
        System.out.println("[HID][CONFIG] Load configuration");
       // PluginSettings.InitConfig();
        System.out.println("[HID][CONFIG] Connect adapters");
        InitAdapters();
    }
    
    private void InitAdapters() {
       
    }

    public void ReceivePin(String PinName, Object PinData) {
        System.out.println("[DEBUG][HID] " + PinName);
        switch (PinName) {
            case PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND:
                //PinOdb2Command CMD;
                //CMD = (PinOdb2Command) PinData;
               // ProcessCommand(CMD);
                break;
        }

    }

}
