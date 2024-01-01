// Package declaration for the Grayscale effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.GrayscaleInterface;

// Class definition for the Grayscale effect implementing the PhotoEffect interface.
public class GrayScale implements PhotoEffect {

    // Implementation of the apply method from the PhotoEffect interface.
    // Applies the Grayscale effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the Grayscale effect action.
        loggingService.addLog(fileName, "Grayscale", "N/A");

        // Call the static applyGrayscale method from the GrayscaleInterface to apply the effect.
        return GrayscaleInterface.applyGrayscale(image);
    }
}
