package org.jrebirth.presentation.javafx.ui.slides.jws;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>JWSModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class JWSModel extends AbstractTemplateModel<JWSModel, JWSView, JWSSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected JWSSlideStep[] initializeSlideStep() {
        return JWSSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final JWSSlideStep slideStep) {
        getView().showSlideStep(slideStep);
    }

}
