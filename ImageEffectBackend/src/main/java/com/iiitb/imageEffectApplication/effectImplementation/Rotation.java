// Package declaration for the Rotation effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import libraryInterfaces.Pixel;
import libraryInterfaces.RotationInterface;

// Class definition for the Rotation effect implementing SingleValueDiscreteEffect.
public class Rotation implements SingleValueDiscreteEffect {

    // Private field to store the rotation value.
    private int val;

    // Getter method to retrieve the current rotation value.
    public int getParameterValue() {
        return (this.val) * 90;
    }

    // Setter method to set the rotation value with validation.
    // Throws IllegalParameterException if the value is outside the valid range [0, 3].
    public void setParameterValue(int v) throws IllegalParameterException {
        if (v < 0 || v > 3) {
            throw new IllegalParameterException("Not allowed");
        }
        this.val = v;
    }

    // Implementation of the apply method from the SingleValueDiscreteEffect interface.
    // Applies the rotation effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Generate a string representation of the rotation angle for logging purposes.
        String s = (val) * 90 + "°";

        // Log the rotation action.
        loggingService.addLog(fileName, "Rotation", s);

        // Call the static applyRotation method from the RotationInterface to apply the effect.
        return RotationInterface.applyRotation(image, val);
    }
}
