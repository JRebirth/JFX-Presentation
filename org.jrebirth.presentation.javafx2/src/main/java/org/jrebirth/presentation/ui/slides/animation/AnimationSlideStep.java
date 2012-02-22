package org.jrebirth.presentation.ui.slides.animation;

import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>PatternSlideStep</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public enum AnimationSlideStep implements SlideStep {

    Text,
    FillTransition,
    StrokeTransition,
    FadeTransition,
    PauseTransition,
    RotateTransition,
    ScaleTransition,
    TranslateTransition,
    PathTransition,
    Timeline;

}
