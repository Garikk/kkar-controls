/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters.rpi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.HashMap;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public class RPIControlAdapter implements IHWAdapter {

    HashMap<String, ACtrl> Controls;
    final GpioController gpio = GpioFactory.getInstance();

    @Override
    public void SetActive() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetInactive() {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class ACtrl {

        IHWAdapterCallback Callback;
        Control Ctrl;
        GpioPinDigitalInput HWInput;
    }

    public RPIControlAdapter() {
        Controls = new HashMap<>();
    }

    @Override
    public void RegisterControl(Control Ctrl, IHWAdapterCallback Callback) {

        ACtrl Add = new ACtrl();
        Add.Callback = Callback;
        Add.Ctrl = Ctrl;
        Add.HWInput=gpio.provisionDigitalInputPin(GetRASPPin(Ctrl.AdapterSource), 
                                                  PinPullResistance.PULL_DOWN);
        Add.HWInput.addListener(GPIOListener);
        Add.HWInput.setTag(Ctrl.ID);

        Controls.put(Ctrl.ID, Add);
        RegisterEvent(Ctrl.AdapterSource, Ctrl.AdapterSource);
    }
    private GpioPinListenerDigital GPIOListener = new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
              if (event.getState()==PinState.HIGH)
              {
                  FireEvent((String)event.getPin().getTag());
              }
            }
    };
    
    
    
    private void RegisterEvent(String DevPath, String Source) {
    }

    private void FireEvent(String FiredControl) {
        ACtrl A = Controls.get(FiredControl);
        A.Callback.Control_Triggered(FiredControl, A.Ctrl.Global);

    }
    
    private Pin GetRASPPin(String Addr)
    {
        switch (Addr) {
            case "1":
                return RaspiPin.GPIO_01;
            case "2":
                return RaspiPin.GPIO_02;
            case "3":
                return RaspiPin.GPIO_03;
            case "4":
                return RaspiPin.GPIO_04;
            case "5":
                return RaspiPin.GPIO_05;
            case "6":
                return RaspiPin.GPIO_06;
            case "7":
                return RaspiPin.GPIO_07;
            case "8":
                return RaspiPin.GPIO_08;
            case "9":
                return RaspiPin.GPIO_09;
            case "10":
                return RaspiPin.GPIO_10;
            case "11":
                return RaspiPin.GPIO_11;
            case "12":
                return RaspiPin.GPIO_12;
            case "13":
                return RaspiPin.GPIO_13;
            case "14":
                return RaspiPin.GPIO_14;
            case "15":
                return RaspiPin.GPIO_15;
            case "16":
                return RaspiPin.GPIO_16;
            case "17":
                return RaspiPin.GPIO_17;
        }
        return RaspiPin.GPIO_00;
    }
}
