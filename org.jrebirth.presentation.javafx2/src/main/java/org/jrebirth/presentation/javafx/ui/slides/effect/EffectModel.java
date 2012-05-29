package org.jrebirth.presentation.javafx.ui.slides.effect;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>PatternModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class EffectModel extends AbstractTemplateModel<EffectModel, EffectView, EffectSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected EffectSlideStep[] initializeSlideStep() {
        return EffectSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final EffectSlideStep slideStep) {

        switch (slideStep) {

            case Reflection:
                getView().showReflection();
                break;
            case SepiaTone:
                getView().showSepiaTone();
                break;
            case DropShadow:
                getView().showDropShadow();
                break;
            case InnerShadow:
                getView().showInnerShadow();
                break;
            // case Shadow:
            // getView().showShadow();
            // break;
            case Bloom:
                getView().showBloom();
                break;
            case Glow:
                getView().showGlow();
                break;
            case Lighting:
                getView().showLighting();
                break;
            case BoxBlur:
                getView().showBoxBlur();
                break;
            case MotionBlur:
                getView().showMotionBlur();
                break;
            case GaussianBlur:
                getView().showGaussianBlur();
                break;
            case PerspectiveTransform:
                getView().showPerspectiveTransform();
                break;
            case Blend:
                getView().showBlend();
                break;
            case ColorAdjust:
                getView().showColorAdjust();
                break;
            case DisplacementMap:
                getView().showDisplacementMap();
                break;

            default:
                getView().showSlideStep(slideStep);
        }
    }
}
