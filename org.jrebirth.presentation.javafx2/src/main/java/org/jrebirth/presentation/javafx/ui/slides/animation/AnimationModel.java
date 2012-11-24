package org.jrebirth.presentation.javafx.ui.slides.animation;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>PatternModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class AnimationModel extends AbstractTemplateModel<AnimationModel, AnimationView, AnimationSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected AnimationSlideStep[] initializeSlideStep() {
        return AnimationSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final AnimationSlideStep slideStep) {

        if (slideStep != AnimationSlideStep.Text && slideStep != AnimationSlideStep.Timeline) {
            getView().buildDemoRectangle(slideStep);
        }

        switch (slideStep) {

            case FadeTransition:
                getView().showFade();
                break;
            case FillTransition:
                getView().showFill();
                break;
            case PathTransition:
                getView().showPath();
                break;
            case PauseTransition:
                getView().showPause();
                break;
            case RotateTransition:
                getView().showRotate();
                break;
            case ScaleTransition:
                getView().showScale();
                break;
            case StrokeTransition:
                getView().showStroke();
                break;
            case TranslateTransition:
                getView().showTranslate();
                break;
            default:
                getView().showSlideStep(slideStep);
        }
    }

}
