package org.jrebirth.presentation.javafx.ui.slides.future;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>ControlsController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class FutureController extends AbstractTemplateController<FutureModel, FutureView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public FutureController(final FutureView view) throws CoreException {
        super(view);
    }

}
