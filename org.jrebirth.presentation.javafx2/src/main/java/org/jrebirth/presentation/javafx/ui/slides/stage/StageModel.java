package org.jrebirth.presentation.javafx.ui.slides.stage;

import javafx.stage.StageStyle;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>StageModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
            case Decorated:
                getView().showStage(StageStyle.DECORATED, "StageStyle.DECORATED");
                break;
            case Transparent:
                getView().showStage(StageStyle.TRANSPARENT, "StageStyle.TRANSPARENT");
                break;
            case Undecorated:
                getView().showStage(StageStyle.UNDECORATED, "StageStyle.UNDECORATED");
                break;
            case Utility:
                getView().showStage(StageStyle.UTILITY, "StageStyle.UTILITY");
                break;
            default:
        }
    }

}
