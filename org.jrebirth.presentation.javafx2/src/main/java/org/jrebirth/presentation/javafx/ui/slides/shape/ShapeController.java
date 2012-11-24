package org.jrebirth.presentation.javafx.ui.slides.shape;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>ShapeController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ShapeController extends AbstractTemplateController<ShapeModel, ShapeView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public ShapeController(final ShapeView view) throws CoreException {
        super(view);
    }

}
