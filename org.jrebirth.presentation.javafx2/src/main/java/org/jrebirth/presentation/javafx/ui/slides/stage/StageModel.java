/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jrebirth.presentation.javafx.ui.slides.stage;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
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
