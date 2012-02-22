package org.jrebirth.presentation.ui.slides.intro;

import org.jrebirth.presentation.ui.base.AbstractSlideModel;
import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>BrowserModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class IntroModel extends AbstractSlideModel<IntroModel, IntroView, SlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected SlideStep[] initializeSlideStep() {
        return new SlideStep[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final SlideStep slideStep) {
        // Nothing to do yet
    }

}
