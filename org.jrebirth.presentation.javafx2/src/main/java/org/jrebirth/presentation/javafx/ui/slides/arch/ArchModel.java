package org.jrebirth.presentation.javafx.ui.slides.arch;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ArchModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ArchModel extends AbstractTemplateModel<ArchModel, ArchView, ArchSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected ArchSlideStep[] initializeSlideStep() {
        return ArchSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final ArchSlideStep slideStep) {

        switch (slideStep) {
            case Background:
                break;
            case JVM:
                getView().showJvm();
                break;
            case JavaFXApi:
                getView().showJavaFXApi();
                break;
            case QuantumTookit:
                getView().showQuantumTookit();
                break;
            case Prism:
                getView().showPrism();
                break;
            case HardwareAcceleration:
                getView().showHardwareAcceleration();
                break;
            case GlassWindowingToolkit:
                getView().showGlassWindowingToolit();
                break;
            case MediaEngine:
                getView().showMediaEngine();
                break;
            case WebEngine:
                getView().showWebEngine();
                break;
            default:
        }
    }

}
