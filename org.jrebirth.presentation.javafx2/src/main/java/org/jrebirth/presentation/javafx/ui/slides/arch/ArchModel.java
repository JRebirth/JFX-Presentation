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
package org.jrebirth.presentation.javafx.ui.slides.arch;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>ArchModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ArchModel extends AbstractTemplateModel<ArchModel, ArchView, ArchSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected ArchSlideStep[] initializeSlideStep() {
        return ArchSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final ArchSlideStep slideStep) {

        switch (slideStep) {
            case Background:
                break;
            case JVM:
                getView().showJvm();
                break;
            case JavaFXApi:
                getView().showJavaFXApi();
                break;
            case QuantumTookit:
                getView().showQuantumTookit();
                break;
            case Prism:
                getView().showPrism();
                break;
            case HardwareAcceleration:
                getView().showHardwareAcceleration();
                break;
            case GlassWindowingToolkit:
                getView().showGlassWindowingToolit();
                break;
            case MediaEngine:
                getView().showMediaEngine();
                break;
            case WebEngine:
                getView().showWebEngine();
                break;
            default:
        }
    }

}
