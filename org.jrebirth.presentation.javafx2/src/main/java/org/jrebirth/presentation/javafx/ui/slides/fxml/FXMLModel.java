package org.jrebirth.presentation.javafx.ui.slides.fxml;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>JWSModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
