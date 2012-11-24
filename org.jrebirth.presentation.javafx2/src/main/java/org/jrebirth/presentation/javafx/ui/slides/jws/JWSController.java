package org.jrebirth.presentation.javafx.ui.slides.jws;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>JWSController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class JWSController extends AbstractTemplateController<JWSModel, JWSView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public JWSController(final JWSView view) throws CoreException {
        super(view);
    }

}
