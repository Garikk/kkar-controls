package kkdev.kksystem.plugin.controls.manager;

import kkdev.kksystem.base.classes.odb2.ODBConstants.KK_ODB_DATAPACKET;
import kkdev.kksystem.base.classes.odb2.PinOdb2Command;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerHID;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerODB;
import kkdev.kksystem.base.constants.PluginConsts;
import static kkdev.kksystem.base.constants.SystemConsts.KK_BASE_FEATURES_ODB_DIAG_UID;
import kkdev.kksystem.plugins.controls.KKPlugin;

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
        System.out.println("[DEBUG][ODB2][PROCREC] " + PinName);
        switch (PinName) {
            case PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND:
                PinOdb2Command CMD;
                CMD = (PinOdb2Command) PinData;
                ProcessCommand(CMD);
                break;
        }

    }

    private void ProcessCommand(PinOdb2Command CMD) {
        System.out.println("[DEBUG][ODB2][PROCCMD] " + CMD.Command);
        switch (CMD.Command) {
            case ODB_KKSYS_ADAPTER_CONNECT:    //connect to car diag system
                //ODB_ConnectToCarState(CurrentFeature,CMD,true); //temp
                break;
            case ODB_KKSYS_ADAPTER_DISCONNECT:    //connect to car diag system
                break;
            case ODB_KKSYS_CAR_GETINFO:   //request pid info
                RequestInfo(CMD);
                break;
            case ODB_KKSYS_CAR_EXEC_COMMAND:   //Exec ODB command
                break;
        }

    }
    private void RequestInfo(PinOdb2Command CMD) {
        if (CMD.CommandData==KK_ODB_DATAPACKET.ODB_SIMPLEDATA)
        {
        
        }
    }
}
