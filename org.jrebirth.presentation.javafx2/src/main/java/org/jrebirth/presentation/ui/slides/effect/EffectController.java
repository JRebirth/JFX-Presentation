package org.jrebirth.presentation.ui.slides.effect;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>PatternController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
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
