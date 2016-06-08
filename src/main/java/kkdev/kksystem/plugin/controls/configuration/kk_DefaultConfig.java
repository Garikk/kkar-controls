/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import java.util.HashSet;
import java.util.Set;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_BACK;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_DOWN;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_ENTER;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_UP;
import kkdev.kksystem.base.constants.SystemConsts;
import kkdev.kksystem.plugin.controls.configuration.ControlsConfig.AdapterType;


/**
 *
 * @author blinov_is
 *

 */
public abstract class kk_DefaultConfig {
    public static ControlsConfig MakeDefaultConfig() {
        
        ControlsConfig DefConf = new ControlsConfig();
        
        DefConf.Adapters=new Adapter[4];
        
        DefConf.Adapters[0] = new Adapter();
        DefConf.Adapters[0].ID="KK_RPI_Adapter";
        DefConf.Adapters[0].Name="Raspberry";
        DefConf.Adapters[0].Type=AdapterType.RaspberryPI_B;
        
        DefConf.Adapters[1] = new Adapter();
        DefConf.Adapters[1].ID="DBG_Adapter";
        DefConf.Adapters[1].Name="Debug";
        DefConf.Adapters[1].Type=AdapterType.Debug;
        //
        DefConf.Adapters[2] = new Adapter();
        DefConf.Adapters[2].ID="RPI_I2C";
        DefConf.Adapters[2].Name="I2C_Buttons";
        DefConf.Adapters[2].Type=AdapterType.RaspberryPI_B_PI4J_I2C;
        DefConf.Adapters[2].BusID=1;
        DefConf.Adapters[2].DeviceID=0x2b;
        //
         //
        DefConf.Adapters[3] = new Adapter();
        DefConf.Adapters[3].ID="UNI_COM";
        DefConf.Adapters[3].Name="COM_Buttons";
        DefConf.Adapters[3].Type=AdapterType.UniversalLinux_RS232;
        DefConf.Adapters[3].BusID=1;
        DefConf.Adapters[3].DeviceID=0x2b;
        //
               //
        DefConf.Adapters[3] = new Adapter();
        DefConf.Adapters[3].ID="SMARTHEAD";
        DefConf.Adapters[3].Name="SMARTHEAD_Buttons";
        DefConf.Adapters[3].Type=AdapterType.KKSmarthead;
        DefConf.Adapters[3].UNILPort="SMARTHEAD";
        //
        // 
        DefConf.Controls=new Control[28];
        // RPI controls, for debug
        DefConf.Controls[0] = new Control();
        DefConf.Controls[1] = new Control();
        DefConf.Controls[2] = new Control();
        DefConf.Controls[3] = new Control();
        
        // Custom chrysler head REMOVE THIS IN PRODUCTION
        for (int i=4;i<4+24;i++)
        {
            DefConf.Controls[i] = new Control();
        }
        for (int i=0;i<DefConf.Controls.length;i++)
        {
            DefConf.Controls[i].buttonID=new HashSet<>();
        }
        //RPI, debug pri gpio buttons
        DefConf.Controls[0].buttonID.add(DEF_BTN_UP);
        DefConf.Controls[1].buttonID.add(DEF_BTN_DOWN);
        DefConf.Controls[2].buttonID.add(DEF_BTN_ENTER);
        DefConf.Controls[3].buttonID.add(DEF_BTN_BACK);
        
        // Custom chrysler head REMOVE THIS IN PRODUCTION
        DefConf.Controls[4].buttonID.add("DUMMY1");
        DefConf.Controls[5].buttonID.add("DUMMY2");
        
        DefConf.Controls[6].buttonID.add(DEF_BTN_BACK);
        DefConf.Controls[6].buttonID.add("CUSTOM_CHRY_BTN_SET");
        
        DefConf.Controls[7].buttonID.add(DEF_BTN_ENTER);
        DefConf.Controls[7].buttonID.add("CUSTOM_CHRY_BTN_AMFM");
        
        DefConf.Controls[8].buttonID.add("CUSTOM_CHRY_CLOCK_H");
        DefConf.Controls[9].buttonID.add("CUSTOM_CHRY_CLOCK_M");
        DefConf.Controls[10].buttonID.add("CUSTOM_CHRY_TUNE_FF");
        DefConf.Controls[11].buttonID.add("CUSTOM_CHRY_TUNE_RW");
        DefConf.Controls[12].buttonID.add("CUSTOM_CHRY_TRK_1");
        DefConf.Controls[13].buttonID.add(DEF_BTN_BACK);
        
        DefConf.Controls[14].buttonID.add(DEF_BTN_UP);
        DefConf.Controls[14].buttonID.add("CUSTOM_CHRY_BTN_SEEKUP");
        
        DefConf.Controls[15].buttonID.add(DEF_BTN_DOWN);
        DefConf.Controls[15].buttonID.add("CUSTOM_CHRY_BTN_SEEKDOWN");
        DefConf.Controls[16].buttonID.add("CUSTOM_CHRY_TRK_5");
        DefConf.Controls[17].buttonID.add("CUSTOM_CHRY_CLOCK_TIME");
        DefConf.Controls[18].buttonID.add("CUSTOM_CHRY_MODE");
        DefConf.Controls[19].buttonID.add(DEF_BTN_ENTER);
        DefConf.Controls[20].buttonID.add("CUSTOM_CHRY_POWER");
        DefConf.Controls[21].buttonID.add("CUSTOM_CHRY_VOLUME");
        DefConf.Controls[22].buttonID.add("CUSTOM_CHRY_BAL_L");
        DefConf.Controls[23].buttonID.add("CUSTOM_CHRY_BAL_R");
        DefConf.Controls[24].buttonID.add("CUSTOM_CHRY_FADER_L");
        DefConf.Controls[25].buttonID.add("CUSTOM_CHRY_FADER_R");
        DefConf.Controls[26].buttonID.add("CUSTOM_CHRY_BASS");
        DefConf.Controls[27].buttonID.add("CUSTOM_CHRY_TREBLE");

        
        DefConf.Controls[0].Name="SelectUP";
        DefConf.Controls[1].Name="SelectDown";
        DefConf.Controls[2].Name="Enter";
        DefConf.Controls[3].Name="Back";
        
        DefConf.Controls[4].Name="CUSTOM_CHRY_SEEKUP";
        DefConf.Controls[5].Name="CUSTOM_CHRY_SEEKDOWN";
        DefConf.Controls[6].Name="CUSTOM_CHRY_AMFM";
        DefConf.Controls[7].Name="CUSTOM_CHRY_SET";
        DefConf.Controls[8].Name="F";
        DefConf.Controls[9].Name="CUSTOM_CHRY_CLOCK_M";
        DefConf.Controls[10].Name="CUSTOM_CHRY_TUNE_FF";
        DefConf.Controls[11].Name="CUSTOM_CHRY_TUNE_RW";
        DefConf.Controls[12].Name="CUSTOM_CHRY_TRK_1";
        DefConf.Controls[13].Name="CUSTOM_CHRY_TRK_2";
        DefConf.Controls[14].Name="CUSTOM_CHRY_TRK_3";
        DefConf.Controls[15].Name="CUSTOM_CHRY_TRK_4";
        DefConf.Controls[16].Name="CUSTOM_CHRY_TRK_5";
        DefConf.Controls[17].Name="CUSTOM_CHRY_CLOCK_TIME";
        DefConf.Controls[18].Name="CUSTOM_CHRY_MODE";
        DefConf.Controls[19].Name="CUSTOM_CHRY_EJECT";
        DefConf.Controls[20].Name="CUSTOM_CHRY_POWER";
        DefConf.Controls[21].Name="CUSTOM_CHRY_VOLUME";
        DefConf.Controls[22].Name="CUSTOM_CHRY_BAL_L";
        DefConf.Controls[23].Name="CUSTOM_CHRY_BAL_R";
        DefConf.Controls[24].Name="CUSTOM_CHRY_FADER_L";
        DefConf.Controls[25].Name="CUSTOM_CHRY_FADER_R";
        DefConf.Controls[26].Name="CUSTOM_CHRY_BASS";
        DefConf.Controls[27].Name="CUSTOM_CHRY_TREBLE";
        
        DefConf.Controls[0].AdapterID="DBG_Adapter";
        DefConf.Controls[1].AdapterID="DBG_Adapter";
        DefConf.Controls[2].AdapterID="DBG_Adapter";
        DefConf.Controls[3].AdapterID="DBG_Adapter";
        
        for (int i=4;i<4+24;i++)
        {
             DefConf.Controls[i].AdapterID="SMARTHEAD";
        }
        
        DefConf.Controls[0].AdapterSource="3"; //change to your rpi pin numbers
        DefConf.Controls[1].AdapterSource="12";
        DefConf.Controls[2].AdapterSource="13";
        DefConf.Controls[3].AdapterSource="14";
        
        DefConf.Controls[4].AdapterSource="1";
        DefConf.Controls[5].AdapterSource="2";
        DefConf.Controls[6].AdapterSource="3";
        DefConf.Controls[7].AdapterSource="4";
        DefConf.Controls[8].AdapterSource="F";
        DefConf.Controls[9].AdapterSource="R";
        DefConf.Controls[10].AdapterSource="B";
        DefConf.Controls[11].AdapterSource="C";
        DefConf.Controls[12].AdapterSource="H";
        DefConf.Controls[13].AdapterSource="A";
        DefConf.Controls[14].AdapterSource="U";
        DefConf.Controls[15].AdapterSource="D";
        DefConf.Controls[16].AdapterSource="5";
        DefConf.Controls[17].AdapterSource="M";
        DefConf.Controls[18].AdapterSource="O";
        DefConf.Controls[19].AdapterSource="S";
        DefConf.Controls[20].AdapterSource="0";
        DefConf.Controls[21].AdapterSource="N";
        DefConf.Controls[22].AdapterSource="Z";
        DefConf.Controls[23].AdapterSource="X";
        DefConf.Controls[24].AdapterSource="W";
        DefConf.Controls[25].AdapterSource="Y";
        DefConf.Controls[26].AdapterSource="T";
        DefConf.Controls[27].AdapterSource="E";
        
        
        
        DefConf.Controls[0].Global=false;
        DefConf.Controls[1].Global=false;
        DefConf.Controls[2].Global=false;
        DefConf.Controls[3].Global=true; //back button is global
        DefConf.Controls[8].Global=true; //F button is global for test
      
        for (int i=4;i<4+24;i++)
        {
            DefConf.Controls[i].Global=false;
        }
          DefConf.Controls[13].Global=true; //back button is global
        return DefConf;
    }
}
    
