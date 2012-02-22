package org.jrebirth.presentation.ui.slides.pattern;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>PatternModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
