package org.jrebirth.presentation.javafx.ui.slides.hello;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>HelloModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class HelloModel extends AbstractTemplateModel<HelloModel, HelloView, HelloSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected HelloSlideStep[] initializeSlideStep() {
        return HelloSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final HelloSlideStep slideStep) {
        getView().showSlideStep(slideStep);
        // switch (slideStep) {
        // case Code:
        // getView().showCode();
        // break;
        // case Application:
        // getView().showApplication();
        // break;
        //
        // }

    }

}
