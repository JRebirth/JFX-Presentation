package org.jrebirth.presentation.javafx.ui.slides.fxml;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>JWSController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class FXMLController extends AbstractTemplateController<FXMLModel, FXMLView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public FXMLController(final FXMLView view) throws CoreException {
        super(view);
    }

}
