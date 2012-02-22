package org.jrebirth.presentation.ui.slides.handler;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>HandlerModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class HandlerModel extends AbstractTemplateModel<HandlerModel, HandlerView, HandlerSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected HandlerSlideStep[] initializeSlideStep() {
        return HandlerSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final HandlerSlideStep slideStep) {

        switch (slideStep) {

            case Text:
                getView().showText();
                break;
            case HandlerStage:
                getView().showHandlerStage();
                break;
            default:
                getView().showSlideStep(slideStep);
        }
    }
}
