package org.jrebirth.presentation.javafx.ui.slides.property;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>PropertyController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class PropertyController extends AbstractTemplateController<PropertyModel, PropertyView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public PropertyController(final PropertyView view) throws CoreException {
        super(view);
    }

}
