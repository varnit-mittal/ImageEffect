package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import libraryInterfaces.Pixel;
import libraryInterfaces.DominantColourInterface;

public class DominantColor implements PhotoEffect {
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Dominant Colour", "N/A");
        return DominantColourInterface.applyDominantColour(image);
    }
}