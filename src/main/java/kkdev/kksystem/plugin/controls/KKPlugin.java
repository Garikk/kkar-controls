package kkdev.kksystem.plugin.controls;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import kkdev.kksystem.base.classes.base.PinData;
import kkdev.kksystem.base.classes.base.PluginMessageData;
import kkdev.kksystem.base.classes.plugins.PluginConfiguration;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.KKPluginBase;
import kkdev.kksystem.plugin.controls.manager.ControlsManager;
import kkdev.kksystem.plugin.controls.configuration.PluginSettings;
import kkdev.kksystem.base.interfaces.IBaseConnection;

/**
 *
 * @author blinov_is
 */
public final class KKPlugin extends KKPluginBase {

    public KKPlugin() {
        super(new ControlsPluginInfo());
        Global.PM = new ControlsManager();
    }

    @Override
    public void pluginInit(IBaseConnection BaseConnector, String GlobalConfUID) {
        super.pluginInit(BaseConnector, GlobalConfUID); //To change body of generated methods, choose Tools | Templates.
        Global.PM.InitControls(this);
    }

    @Override
    public void executePin(PluginMessage Pin) {
        super.executePin(Pin);
        Global.PM.ReceivePin(Pin.pinName, (PinData) Pin.getPinData());
        return;
    }

    @Override
    public void pluginStart() {
        Global.PM.PluginStart();
    }

    @Override
    public void pluginStop() {
        Global.PM.PluginStop();
    }

    @Override
    public PluginConfiguration getPluginSettings() {
        return PluginSettings.MainConfiguration;
    }
}
