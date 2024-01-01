// Package declaration for the Hue Saturation effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.HueSaturationInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

// Class definition for the Hue Saturation effect implementing the ParameterizableEffect interface.
public class HueSaturation implements ParameterizableEffect {

    // Private fields to store the hue and saturation values.
    private float hue;
    private float sat;

    // Getter method to retrieve the current hue value.
    public float getHue() {
        return this.hue;
    }

    // Getter method to retrieve the current saturation value.
    public float getSat() {
        return this.sat;
    }

    // Setter method to set the hue and saturation values with validation.
    // Throws IllegalParameterException if the value is outside the valid range [0, 100].
    public void setParameter(String str, float val) throws IllegalParameterException {
        if (val < 0 || val > 100) {
            throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 100");
        }
        if (str.equals("H")) {
            this.hue = val;
        } else {
            this.sat = val;
        }
    }

    // Implementation of the apply method from the ParameterizableEffect interface.
    // Applies the Hue Saturation effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Generate a string representation of the hue and saturation values for logging purposes.
        String parameterString = "Hue = " + hue + " Saturation = " + sat;

        // Log the Hue Saturation effect action.
        loggingService.addLog(fileName, "Hue Saturation", parameterString);

        // Call the static applyHueSaturation method from the HueSaturationInterface to apply the effect.
        return HueSaturationInterface.applyHueSaturation(image, hue, sat);
    }
}
