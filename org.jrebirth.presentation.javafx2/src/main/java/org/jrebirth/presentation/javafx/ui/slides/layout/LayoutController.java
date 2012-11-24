package org.jrebirth.presentation.javafx.ui.slides.layout;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>LayoutController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class LayoutController extends AbstractTemplateController<LayoutModel, LayoutView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public LayoutController(final LayoutView view) throws CoreException {
        super(view);
    }

}
