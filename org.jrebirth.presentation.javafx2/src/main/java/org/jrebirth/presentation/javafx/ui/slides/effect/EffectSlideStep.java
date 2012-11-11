package org.jrebirth.presentation.javafx.ui.slides.effect;

import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>EffectSlideStep</strong>.
 * 
 * @author Sébastien Bordes
 */
public enum EffectSlideStep implements SlideStep {

    Text,
    Reflection,
    SepiaTone,

    DropShadow,
    InnerShadow,
    // Shadow,

    Bloom,
    Glow,
    Lighting,

    BoxBlur,
    MotionBlur,
    GaussianBlur,

    PerspectiveTransform,

    Blend,
    ColorAdjust,
    DisplacementMap;

}
