package org.jrebirth.presentation.ui.slides.media;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>MediaModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class MediaModel extends AbstractTemplateModel<MediaModel, MediaView, MediaSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected MediaSlideStep[] initializeSlideStep() {
        return MediaSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final MediaSlideStep slideStep) {
        switch (slideStep) {
            case Text:
            case Audio:
                getView().showSlideStep(slideStep);
                break;
            case Video:
                getView().showVideo();
                break;
            case MoveOut:
                getView().showMoveOut();
                break;
            default:

        }
    }

}
