// Package declaration for the Dominant Color effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import libraryInterfaces.Pixel;
import libraryInterfaces.DominantColourInterface;

// Class definition for the DominantColor effect implementing the PhotoEffect interface.
public class DominantColor implements PhotoEffect {

    // Implementation of the apply method from the PhotoEffect interface.
    // Applies the Dominant Color effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the Dominant Color effect action.
        loggingService.addLog(fileName, "Dominant Colour", "N/A");

        // Call the static applyDominantColour method from the DominantColourInterface to apply the effect.
        return DominantColourInterface.applyDominantColour(image);
    }
}
