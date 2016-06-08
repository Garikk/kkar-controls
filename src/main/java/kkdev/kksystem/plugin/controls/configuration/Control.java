/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import java.util.Set;

/**
 *
 * @author blinov_is
 */
public class Control {

    public String Name;
    public Set<String> buttonID;
    public String AdapterID;
    public String AdapterSource;
    //
    public boolean Global;
    public boolean FixedFeature;
    public String FixedFeatureTarget;
    public boolean FixedContext;
    public String FixedContextTarget;
    //
    public String CurrentUIContext;

}
