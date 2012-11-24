package org.jrebirth.presentation.javafx.ui.slides.resources;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ResourcesModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ResourcesModel extends AbstractTemplateModel<ResourcesModel, ResourcesView, ResourcesSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected ResourcesSlideStep[] initializeSlideStep() {
        return ResourcesSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final ResourcesSlideStep slideStep) {

        switch (slideStep) {
            case Color:
                getView().showColor();
                break;

            default:
                getView().showSlideStep(slideStep);

        }

    }

}
