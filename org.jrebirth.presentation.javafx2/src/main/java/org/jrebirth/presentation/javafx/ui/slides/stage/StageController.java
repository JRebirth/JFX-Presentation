package org.jrebirth.presentation.javafx.ui.slides.stage;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>StageController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class StageController extends AbstractTemplateController<StageModel, StageView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public StageController(final StageView view) throws CoreException {
        super(view);
    }

}
