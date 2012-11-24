package org.jrebirth.presentation.javafx.ui.slides.arch;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>HandlerController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ArchController extends AbstractTemplateController<ArchModel, ArchView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public ArchController(final ArchView view) throws CoreException {
        super(view);
    }

}
