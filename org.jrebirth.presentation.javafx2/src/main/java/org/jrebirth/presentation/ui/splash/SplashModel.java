package org.jrebirth.presentation.ui.splash;

import org.jrebirth.presentation.ui.base.AbstractSlideModel;
import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>SplashModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class SplashModel extends AbstractSlideModel<SplashModel, SplashView, SlideStep> {

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

    /**
     * Return the splash title.
     * 
     * @return the title
     */
    public String getTitle() {
        return getSlide().getTitle() == null ? "" : getSlide().getTitle().replaceAll("\\\\n", "\n");
    }

    /**
     * Return the style class.
     * 
     * @return the style class
     */
    public String getStyleClass() {
        return getSlide().getStyle();
    }

}
