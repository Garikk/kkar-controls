/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters.unilinux;

import java.util.HashMap;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.configuration.Adapter;
import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author sayma_000
 */
public class UNIL_RS232Adapter implements IHWAdapter  {

    HashMap<String, DevCtrl> Devices;
    Adapter Configuration;
    boolean NotWork=true;

    private static String OS = System.getProperty("os.name").toLowerCase();

      public UNIL_RS232Adapter(Adapter Conf) {
        Devices = new HashMap<>();
        Configuration=Conf;
    
    }
    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
    
    @Override
    public void SetActive() {
       //   System.out.println("[HID][DBGA] UNI Linux Control adapter ENABLED");
        if (NotWork)
            StartBusReading();
    }

    @Override
    public void SetInactive() {

    }

     class DevCtrl {
        String AdapterID;
        HashMap<String,Control> MappedControls; //SrcID,CtrlID
      //  I2CDevice HWDev;
        Thread Reader;
        IHWAdapterCallback Callback;
        public DevCtrl()
        {
           
        }
        
    }

    @Override
    public void RegisterControl(Control Ctrl, IHWAdapterCallback Callback) {
        if (NotWork)
            return;
            
            RegisterEvent(Ctrl,Callback);
    }
    
    private void RegisterEvent(Control Ctrl,IHWAdapterCallback Callback) {
        if (!Devices.containsKey(Ctrl.AdapterID))
        {
            Devices.put(Ctrl.AdapterID, ConnectI2CDevice(Ctrl.AdapterID));
        }
        //
        Devices.get(Ctrl.AdapterID).MappedControls.put(Ctrl.AdapterSource,Ctrl);
        Devices.get(Ctrl.AdapterID).Callback=Callback;
        
    }

    private void FireEvent(String DevID,byte EventType, byte Val) {
        if (EventType==49) //49 = ASCII  -> 1
        {
           //System.out.println("BUTTON " + EventType + " " + Val);
           Devices.get(DevID).Callback.Control_Triggered(Devices.get(DevID).MappedControls.get(String.valueOf((char)Val)));
       }
    }
    
    private DevCtrl ConnectI2CDevice(String DeviceID)
    {
        if (NotWork)
            return null;
          
        /*
        try {
            return new DevCtrl(DeviceID,BusI2C.getDevice(Configuration.DeviceID));
        } catch (IOException ex) {
            Logger.getLogger(UNIL_RS232Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        return null;
    }
    
    private void StartBusReading()
    {
      
    }
}
