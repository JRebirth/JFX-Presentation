package org.jrebirth.presentation.javafx.ui.slides.property;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>PropertyModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class PropertyModel extends AbstractTemplateModel<PropertyModel, PropertyView, PropertySlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected PropertySlideStep[] initializeSlideStep() {
        return PropertySlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final PropertySlideStep slideStep) {
        switch (slideStep) {

            case Binding:
                getView().showBinding();
                break;
            default:
                getView().showSlideStep(slideStep);
        }
    }

}
