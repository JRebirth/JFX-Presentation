package org.jrebirth.presentation.javafx.ui.slides.media;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>MediaModel</strong>.
 * 
 * @author Sébastien Bordes
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
