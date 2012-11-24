package org.jrebirth.presentation.javafx.ui.slides.fxml;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>JWSModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class FXMLModel extends AbstractTemplateModel<FXMLModel, FXMLView, FXMLSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected FXMLSlideStep[] initializeSlideStep() {
        return FXMLSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final FXMLSlideStep slideStep) {
        getView().showSlideStep(slideStep);
    }

}
