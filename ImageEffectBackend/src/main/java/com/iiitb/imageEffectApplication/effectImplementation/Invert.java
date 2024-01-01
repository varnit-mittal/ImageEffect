// Package declaration for the Invert effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.InvertInterface;

// Class definition for the Invert effect implementing the PhotoEffect interface.
public class Invert implements PhotoEffect {

    // Implementation of the apply method from the PhotoEffect interface.
    // Applies the Invert effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the Invert effect action.
        loggingService.addLog(fileName, "Invert", "N/A");

        // Call the static applyInvert method from the InvertInterface to apply the effect.
        return InvertInterface.applyInvert(image);
    }
}
