package com.iiitb.imageEffectApplication.effectImplementation;

import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class Contrast implements SingleValueParameterizableEffect{
    private float amount;
    public void setParameterValue(float amt) throws IllegalParameterException{
        if (amt < 0 || amt > 100) throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 100");
        this.amount = amt;
    }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Contrast", Float.toString(amount));
        return ContrastInterface.applyContrast(image, amount);
    }
}