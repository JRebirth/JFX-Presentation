package org.jrebirth.presentation.javafx.ui.slides.handler;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>HandlerModel</strong>.
 * 
 * @author Sébastien Bordes
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
