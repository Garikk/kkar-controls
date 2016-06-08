package kkdev.kksystem.plugin.controls;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import kkdev.kksystem.base.classes.plugins.PluginInfo;
import kkdev.kksystem.base.classes.plugins.simple.IPluginInfoRequest;
import kkdev.kksystem.base.constants.PluginConsts;

/**
 *
 * @author blinov_is e
 */
public class ControlsPluginInfo  implements IPluginInfoRequest {
    @Override
    public PluginInfo getPluginInfo()
    {
        PluginInfo Ret=new PluginInfo();
        
        Ret.PluginName="KKControlsPlugin";
        Ret.PluginDescription="Basic HW Controls plugin (Buttons etc..)";
        Ret.PluginVersion=1;
        Ret.Enabled=true;
        Ret.ReceivePins = GetMyReceivePinInfo();
        Ret.TransmitPins = GetMyTransmitPinInfo();
        Ret.PluginUUID="62d1026f-5297-4951-890d-61d75ae67d02";
        return Ret;
    }
    
    
    private String[] GetMyReceivePinInfo(){
    
        String[] Ret=new String[1];
    

        Ret[0]=PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND;
        
        return Ret;
    }
    private String[] GetMyTransmitPinInfo(){
    
        String[] Ret=new String[1];

//        Ret[0]=PluginConsts.KK_PLUGIN_BASE_HID_DATA;
        
        return Ret;
    }
}
