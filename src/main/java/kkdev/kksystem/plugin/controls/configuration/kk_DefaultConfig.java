/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_BACK;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_DOWN;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_ENTER;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_UP;
import kkdev.kksystem.plugin.controls.configuration.ControlsConfig.AdapterType;


/**
 *
 * @author blinov_is
 *

 */
public abstract class kk_DefaultConfig {
    public static ControlsConfig MakeDefaultConfig() {
        
        ControlsConfig DefConf = new ControlsConfig();
        
        DefConf.Adapters=new Adapter[2];
        
        DefConf.Adapters[0] = new Adapter();
        DefConf.Adapters[0].ID="KK_RPI_Adapter";
        DefConf.Adapters[0].Name="Raspberry";
        DefConf.Adapters[0].Type=AdapterType.RaspberryPI_B;
        DefConf.Adapters[1] = new Adapter();
        DefConf.Adapters[1].ID="DBG_Adapter";
        DefConf.Adapters[1].Name="Debug";
        DefConf.Adapters[1].Type=AdapterType.Debug;
        //
        DefConf.Controls=new Control[4];
        DefConf.Controls[0] = new Control();
        DefConf.Controls[1] = new Control();
        DefConf.Controls[2] = new Control();
        DefConf.Controls[3] = new Control();
        
        DefConf.Controls[0].ID=DEF_BTN_UP;
        DefConf.Controls[1].ID=DEF_BTN_DOWN;
        DefConf.Controls[2].ID=DEF_BTN_ENTER;
        DefConf.Controls[3].ID=DEF_BTN_BACK;
        
        DefConf.Controls[0].Name="SelectUP";
        DefConf.Controls[1].Name="SelectDown";
        DefConf.Controls[2].Name="Enter";
        DefConf.Controls[3].Name="Back";
        
        DefConf.Controls[0].AdapterID="Debug";
        DefConf.Controls[1].AdapterID="Debug";
        DefConf.Controls[2].AdapterID="Debug";
        DefConf.Controls[3].AdapterID="Debug";
        
        DefConf.Controls[0].AdapterSource="3"; //Change this to real rpi pin numbers
        DefConf.Controls[1].AdapterSource="12";
        DefConf.Controls[2].AdapterSource="13";
        DefConf.Controls[3].AdapterSource="14";
        
        DefConf.Controls[0].Global=false;
        DefConf.Controls[1].Global=false;
        DefConf.Controls[2].Global=false;
        DefConf.Controls[3].Global=true;
        
        return DefConf;
    }
}
    
