package org.jrebirth.presentation.javafx.ui.slides.stage;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>StageModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class StageModel extends AbstractTemplateModel<StageModel, StageView, StageSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected StageSlideStep[] initializeSlideStep() {
        return StageSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final StageSlideStep slideStep) {

        switch (slideStep) {

            case Text:
                getView().showSlideStep(slideStep);
                break;
            case Show:
                getView().showStages();
                break;
            case Release:
                getView().releaseStages();
                break;
            // case Decorated:
            // getView().showStage(StageStyle.DECORATED, "StageStyle.DECORATED");
            // break;
            // case Transparent:
            // getView().showStage(StageStyle.TRANSPARENT, "StageStyle.TRANSPARENT");
            // break;
            // case Undecorated:
            // getView().showStage(StageStyle.UNDECORATED, "StageStyle.UNDECORATED");
            // break;
            // case Utility:
            // getView().showStage(StageStyle.UTILITY, "StageStyle.UTILITY");
            // break;
            default:
        }
    }

}
