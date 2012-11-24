package org.jrebirth.presentation.javafx.ui.slides.animation;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>PatternController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class AnimationController extends AbstractTemplateController<AnimationModel, AnimationView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public AnimationController(final AnimationView view) throws CoreException {
        super(view);
    }

}
