package org.jrebirth.presentation.ui.slides.property;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>PropertyModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
