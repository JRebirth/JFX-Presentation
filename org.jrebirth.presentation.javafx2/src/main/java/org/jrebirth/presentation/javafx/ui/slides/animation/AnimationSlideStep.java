package org.jrebirth.presentation.javafx.ui.slides.animation;

import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>PatternSlideStep</strong>.
 * 
 * @author Sébastien Bordes
 */
public enum AnimationSlideStep implements SlideStep {

    Text,
    FillTransition,
    StrokeTransition,
    FadeTransition,
    RotateTransition,
    PauseTransition,
    ScaleTransition,
    TranslateTransition,
    PathTransition,
    Timeline;

}
