package org.jrebirth.presentation.javafx.ui.slides.pattern;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>PatternModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class PatternModel extends AbstractTemplateModel<PatternModel, PatternView, PatternSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected PatternSlideStep[] initializeSlideStep() {
        return PatternSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final PatternSlideStep slideStep) {
        getView().showSlideStep(slideStep);
    }

}
