package org.jrebirth.presentation.javafx.ui.slides.control;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>ControlController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ControlController extends AbstractTemplateController<ControlModel, ControlView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public ControlController(final ControlView view) throws CoreException {
        super(view);
    }

}
