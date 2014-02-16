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
package org.jrebirth.af.presentation.javafx.ui.slides.handler;

import org.jrebirth.af.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>HandlerModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class HandlerModel extends AbstractTemplateModel<HandlerModel, HandlerView, HandlerSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected HandlerSlideStep[] initializeSlideStep() {
        return HandlerSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final HandlerSlideStep slideStep) {

        switch (slideStep) {

            case Text:
                getView().showText();
                break;
            case HandlerStage:
                getView().showHandlerStage();
                break;
            default:
                getView().showSlideStep(slideStep);
        }
    }
}
