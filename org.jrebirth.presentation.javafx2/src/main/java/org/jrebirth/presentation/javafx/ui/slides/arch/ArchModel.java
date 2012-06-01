package org.jrebirth.presentation.javafx.ui.slides.arch;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ArchModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
