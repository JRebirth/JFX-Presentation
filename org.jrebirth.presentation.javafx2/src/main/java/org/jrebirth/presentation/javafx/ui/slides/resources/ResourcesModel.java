package org.jrebirth.presentation.javafx.ui.slides.resources;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ResourcesModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
