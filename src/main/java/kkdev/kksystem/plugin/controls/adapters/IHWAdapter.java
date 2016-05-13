/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters;

import kkdev.kksystem.base.classes.base.PinBaseDataTaggedObj;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public interface IHWAdapter {
    public void RegisterControl(Control Ctrl,IHWAdapterCallback Callback);
    public void SetActive();
    public void SetInactive();
    public void ReceiveObjPin(PinBaseDataTaggedObj PM);
}
