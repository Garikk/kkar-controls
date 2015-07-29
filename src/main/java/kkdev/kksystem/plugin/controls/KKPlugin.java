package kkdev.kksystem.plugin.controls;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.KKPluginBase;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.plugin.controls.manager.ControlsManager;

/**
 *
 * @author blinov_is
 */
public final class KKPlugin extends KKPluginBase {
    public KKPlugin() {
        super(new ControlsPluginInfo());
        Global.PM=new ControlsManager();
    }

    @Override
    public void PluginInit(IPluginBaseInterface BaseConnector, String GlobalConfUID, String[] FeaturesUID) {
        super.PluginInit(BaseConnector, GlobalConfUID, FeaturesUID); //To change body of generated methods, choose Tools | Templates.
         Global.PM.InitControls(this);
    }

   
    @Override
    public PluginMessage ExecutePin(PluginMessage Pin) {
        super.ExecutePin(Pin);
       Global.PM.ReceivePin(Pin.PinName, Pin.PinData);
        return null;
    }
     @Override
    public void PluginStart() {
      Global.PM.PluginStart();
    }
     @Override
    public void PluginStop() {
      Global.PM.PluginStop();
    }
}
