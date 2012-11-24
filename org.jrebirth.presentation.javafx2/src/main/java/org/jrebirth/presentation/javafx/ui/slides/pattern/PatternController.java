package org.jrebirth.presentation.javafx.ui.slides.pattern;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>PatternController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class PatternController extends AbstractTemplateController<PatternModel, PatternView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public PatternController(final PatternView view) throws CoreException {
        super(view);
    }

}
