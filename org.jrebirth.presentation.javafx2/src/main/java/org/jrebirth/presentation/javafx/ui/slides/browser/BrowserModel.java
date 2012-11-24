package org.jrebirth.presentation.javafx.ui.slides.browser;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>BrowserModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class BrowserModel extends AbstractTemplateModel<BrowserModel, BrowserView, BrowserSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected BrowserSlideStep[] initializeSlideStep() {
        return BrowserSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final BrowserSlideStep slideStep) {

        switch (slideStep) {
            case Text:
                getView().showSlideStep(slideStep);
                break;
            case Browser:
                getView().showBrowser();
                break;
            case Gradient:
                getView().showGradient();
                break;
            case Perspective:
                getView().showPerspective();
                break;
        }

    }
}
