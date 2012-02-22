package org.jrebirth.presentation.ui.slides.why;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>WhyUseController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class WhyUseController extends AbstractTemplateController<WhyUseModel, WhyUseView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public WhyUseController(final WhyUseView view) throws CoreException {
        super(view);
    }

}
