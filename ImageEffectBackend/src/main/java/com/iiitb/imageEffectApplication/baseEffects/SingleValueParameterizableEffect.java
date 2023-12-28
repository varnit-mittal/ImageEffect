package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;


public interface SingleValueParameterizableEffect extends PhotoEffect {
    void setParameterValue(float parameterValue) throws IllegalParameterException;
}
