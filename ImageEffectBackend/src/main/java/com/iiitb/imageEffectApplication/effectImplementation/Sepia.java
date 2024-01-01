// Package declaration for the Sepia effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SepiaInterface;

// Class definition for the Sepia effect implementing the PhotoEffect interface.
public class Sepia implements PhotoEffect {

    // Implementation of the apply method from the PhotoEffect interface.
    // Applies the Sepia effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the Sepia effect action.
        loggingService.addLog(fileName, "Sepia", "N/A");

        // Call the static applySepia method from the SepiaInterface to apply the effect.
        return SepiaInterface.applySepia(image);
    }
}
