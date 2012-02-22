package org.jrebirth.presentation.ui.slides.hello;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>HelloModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class HelloModel extends AbstractTemplateModel<HelloModel, HelloView, HelloSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected HelloSlideStep[] initializeSlideStep() {
        return HelloSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final HelloSlideStep slideStep) {
        switch (slideStep) {
            case Code:
                getView().showCode();
                break;
            case Application:
                getView().showApplication();
                break;

        }

    }

}
