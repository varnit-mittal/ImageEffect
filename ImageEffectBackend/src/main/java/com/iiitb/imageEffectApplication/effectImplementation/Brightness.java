package com.iiitb.imageEffectApplication.effectImplementation;

import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class Brightness implements SingleValueParameterizableEffect{
    private float amount;
    public void setParameterValue(float amount) throws IllegalParameterException{
        if (amount < 0 || amount > 200) throw new IllegalParameterException("Illegal parameters");
        this.amount = amount;
    }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Brightness", Float.toString(amount-100));
        return BrightnessInterface.applyBrightness(image, amount);
    }
}