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
package org.jrebirth.af.presentation.javafx.ui.slides.effect;

import org.jrebirth.af.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>PatternModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class EffectModel extends AbstractTemplateModel<EffectModel, EffectView, EffectSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected EffectSlideStep[] initializeSlideStep() {
        return EffectSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final EffectSlideStep slideStep) {

        switch (slideStep) {

            case Reflection:
                getView().showReflection();
                break;
            case SepiaTone:
                getView().showSepiaTone();
                break;
            case DropShadow:
                getView().showDropShadow();
                break;
            case InnerShadow:
                getView().showInnerShadow();
                break;
            // case Shadow:
            // getView().showShadow();
            // break;
            case Bloom:
                getView().showBloom();
                break;
            case Glow:
                getView().showGlow();
                break;
            case Lighting:
                getView().showLighting();
                break;
            case BoxBlur:
                getView().showBoxBlur();
                break;
            case MotionBlur:
                getView().showMotionBlur();
                break;
            case GaussianBlur:
                getView().showGaussianBlur();
                break;
            case PerspectiveTransform:
                getView().showPerspectiveTransform();
                break;
            case Blend:
                getView().showBlend();
                break;
            case ColorAdjust:
                getView().showColorAdjust();
                break;
            case DisplacementMap:
                getView().showDisplacementMap();
                break;

            default:
                getView().showSlideStep(slideStep);
        }
    }
}
