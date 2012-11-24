package org.jrebirth.presentation.javafx.ui.slides.resources;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>ResourcesController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ResourcesController extends AbstractTemplateController<ResourcesModel, ResourcesView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public ResourcesController(final ResourcesView view) throws CoreException {
        super(view);
    }

}
