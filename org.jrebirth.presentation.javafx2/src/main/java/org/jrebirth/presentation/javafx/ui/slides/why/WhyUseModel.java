package org.jrebirth.presentation.javafx.ui.slides.why;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>WhyUseModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class WhyUseModel extends AbstractTemplateModel<WhyUseModel, WhyUseView, WhyUseSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected WhyUseSlideStep[] initializeSlideStep() {
        return WhyUseSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final WhyUseSlideStep slideStep) {
        getView().showSlideStep(slideStep);
    }

}
