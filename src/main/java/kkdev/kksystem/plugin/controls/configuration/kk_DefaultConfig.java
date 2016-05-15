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
        //RPI
        DefConf.Controls[0].ID=DEF_BTN_UP;
        DefConf.Controls[1].ID=DEF_BTN_DOWN;
        DefConf.Controls[2].ID=DEF_BTN_ENTER;
        DefConf.Controls[3].ID=DEF_BTN_BACK;
        
        // Custom chrysler head REMOVE THIS IN PRODUCTION
        DefConf.Controls[4].ID="DUMMY1";
        DefConf.Controls[5].ID="DUMMY2";
        DefConf.Controls[6].ID=DEF_BTN_BACK;
        DefConf.Controls[7].ID=DEF_BTN_ENTER;
        DefConf.Controls[8].ID="CUSTOM_CHR_CLOCK_H";
        DefConf.Controls[9].ID="CUSTOM_CHR_CLOCK_M";
        DefConf.Controls[10].ID="CUSTOM_CHR_TUNE_FF";
        DefConf.Controls[11].ID="CUSTOM_CHR_TUNE_RW";
        DefConf.Controls[12].ID="CUSTOM_CHR_TRK_1";
        DefConf.Controls[13].ID=DEF_BTN_BACK;
        DefConf.Controls[14].ID=DEF_BTN_UP;
        DefConf.Controls[15].ID=DEF_BTN_DOWN;
        DefConf.Controls[16].ID="CUSTOM_CHR_TRK_5";
        DefConf.Controls[17].ID="CUSTOM_CHR_CLOCK_TIME";
        DefConf.Controls[18].ID="CUSTOM_CHR_MODE";
        DefConf.Controls[19].ID=DEF_BTN_ENTER;
        DefConf.Controls[20].ID="CUSTOM_CHR_POWER";
        DefConf.Controls[21].ID="CUSTOM_CHR_VOLUME";
        DefConf.Controls[22].ID="CUSTOM_CHR_BAL_L";
        DefConf.Controls[23].ID="CUSTOM_CHR_BAL_R";
        DefConf.Controls[24].ID="CUSTOM_CHR_FADER_L";
        DefConf.Controls[25].ID="CUSTOM_CHR_FADER_R";
        DefConf.Controls[26].ID="CUSTOM_CHR_BASS";
        DefConf.Controls[27].ID="CUSTOM_CHR_TREBLE";

        
        DefConf.Controls[0].Name="SelectUP";
        DefConf.Controls[1].Name="SelectDown";
        DefConf.Controls[2].Name="Enter";
        DefConf.Controls[3].Name="Back";
        
        DefConf.Controls[4].Name="CUSTOM_CHR_SEEKUP";
        DefConf.Controls[5].Name="CUSTOM_CHR_SEEKDOWN";
        DefConf.Controls[6].Name="CUSTOM_CHR_AMFM";
        DefConf.Controls[7].Name="CUSTOM_CHR_SET";
        DefConf.Controls[8].Name="F";
        DefConf.Controls[9].Name="CUSTOM_CHR_CLOCK_M";
        DefConf.Controls[10].Name="CUSTOM_CHR_TUNE_FF";
        DefConf.Controls[11].Name="CUSTOM_CHR_TUNE_RW";
        DefConf.Controls[12].Name="CUSTOM_CHR_TRK_1";
        DefConf.Controls[13].Name="CUSTOM_CHR_TRK_2";
        DefConf.Controls[14].Name="CUSTOM_CHR_TRK_3";
        DefConf.Controls[15].Name="CUSTOM_CHR_TRK_4";
        DefConf.Controls[16].Name="CUSTOM_CHR_TRK_5";
        DefConf.Controls[17].Name="CUSTOM_CHR_CLOCK_TIME";
        DefConf.Controls[18].Name="CUSTOM_CHR_MODE";
        DefConf.Controls[19].Name="CUSTOM_CHR_EJECT";
        DefConf.Controls[20].Name="CUSTOM_CHR_POWER";
        DefConf.Controls[21].Name="CUSTOM_CHR_VOLUME";
        DefConf.Controls[22].Name="CUSTOM_CHR_BAL_L";
        DefConf.Controls[23].Name="CUSTOM_CHR_BAL_R";
        DefConf.Controls[24].Name="CUSTOM_CHR_FADER_L";
        DefConf.Controls[25].Name="CUSTOM_CHR_FADER_R";
        DefConf.Controls[26].Name="CUSTOM_CHR_BASS";
        DefConf.Controls[27].Name="CUSTOM_CHR_TREBLE";
        
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
    
