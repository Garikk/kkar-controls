/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters.debug;

import java.util.HashMap;
import java.util.Map;
import kkdev.kksystem.base.classes.base.PinBaseDataTaggedObj;
import static kkdev.kksystem.base.classes.controls.PinControlData.*;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public class DebugAdapterConsole implements IHWAdapter {

    IHWAdapterCallback CB;
    Map<String, Control> Controls;
    boolean Active = false;

    public DebugAdapterConsole() {
        Controls = new HashMap<>();
    }

    @Override
    public void registerControl(Control Ctrl, IHWAdapterCallback Callback) {

        CB = Callback;
      //  System.out.println("[HID][DBGA] Reg Control " + Ctrl.Name);
      for (String btnID:Ctrl.buttonID)
      {
          Controls.put(btnID, Ctrl);
      }

    }

    @Override
    public void setActive() {
         //       System.out.println("[HID][DBGA] Debug Adapter ENABLED");
        Active = true;
        Thread tmr;
        tmr = new Thread(new Runnable() {
            public void run() {
                Boolean Stop = false;
                String Check;

                while (!Stop) {
                    if (System.console() == null) {
                        Stop = true;
                        continue;
                    }

                    Check = System.console().readLine();
                //    System.out.println(Controls.size()+ " " +Controls.get(DEF_BTN_DOWN));

                    switch (Check) {
                        case "1":
                            CB.Control_Triggered(Controls.get(DEF_BTN_UP));
                            break;
                        case "2":
                            CB.Control_Triggered(Controls.get(DEF_BTN_DOWN));
                            break;
                        case "3":
                            CB.Control_Triggered(Controls.get(DEF_BTN_ENTER));
                            break;
                        case "4":
                            CB.Control_Triggered(Controls.get(DEF_BTN_BACK));
                            break;
                        case "44":
                            CB.Control_LongPress(Controls.get(DEF_BTN_BACK), 1);
                            break;
                    }
                }
            }
        });

        tmr.start();
    }

    @Override
    public void setInactive() {
        Active = false;
    }

    @Override
    public void receiveObjPin(PinBaseDataTaggedObj PM) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
