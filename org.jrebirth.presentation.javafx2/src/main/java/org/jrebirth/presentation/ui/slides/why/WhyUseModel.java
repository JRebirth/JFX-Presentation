package org.jrebirth.presentation.ui.slides.why;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>WhyUseModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
