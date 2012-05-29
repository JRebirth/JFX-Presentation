package org.jrebirth.presentation.javafx.ui.slides.jws;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>JWSModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class JWSModel extends AbstractTemplateModel<JWSModel, JWSView, JWSSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected JWSSlideStep[] initializeSlideStep() {
        return JWSSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final JWSSlideStep slideStep) {
        getView().showSlideStep(slideStep);
    }

}
