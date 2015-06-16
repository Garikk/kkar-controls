/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin1.controls.adapters;

import kkdev.kksystem.plugin1.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public interface IHWAdapter {
    public void RegisterControl(String DevicePath, String Source, Control Ctrl,IHWAdapterCallback Callback);
    public void SetActive();
    public void SetInactive();
}
