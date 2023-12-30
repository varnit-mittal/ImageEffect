package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.HueSaturationInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class HueSaturation implements ParameterizableEffect{
    private float hue;
    private float sat;

    public void setParameter( String str ,float val) throws  IllegalParameterException{
        if(val<0 || val>100) throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 100");
        if(str.equals("H"))this.hue=val;
        else this.sat=val;
    }

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Hue Saturation", "Hue =" + Float.toString(hue)+" Saturation = "+Float.toString(sat));
        return HueSaturationInterface.applyHueSaturation(image, hue, sat);
    }
}