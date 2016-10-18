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
package org.jrebirth.af.presentation.javafx.ui.slides.browser;

import org.jrebirth.af.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>BrowserModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class BrowserModel extends AbstractTemplateModel<BrowserModel, BrowserView, BrowserSlideStep> {

    /**
     * Default Constructor.
     */
    public BrowserModel() {
        super();
        this.createViewIntoJAT = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BrowserSlideStep[] initializeSlideStep() {
        return BrowserSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final BrowserSlideStep slideStep) {

        switch (slideStep) {
            case Text:
                view().showSlideStep(slideStep);
                break;
            case Browser:
                view().showBrowser();
                break;
            case Gradient:
                view().showGradient();
                break;
            case Perspective:
                view().showPerspective();
                break;
        }

    }
}
