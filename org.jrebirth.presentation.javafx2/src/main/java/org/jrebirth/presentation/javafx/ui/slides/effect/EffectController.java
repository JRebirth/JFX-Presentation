package org.jrebirth.presentation.javafx.ui.slides.effect;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>PatternController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class EffectController extends AbstractTemplateController<EffectModel, EffectView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public EffectController(final EffectView view) throws CoreException {
        super(view);
    }

}
