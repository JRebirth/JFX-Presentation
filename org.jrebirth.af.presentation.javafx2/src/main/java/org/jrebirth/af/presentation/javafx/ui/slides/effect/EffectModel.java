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
                view().showReflection();
                break;
            case SepiaTone:
                view().showSepiaTone();
                break;
            case DropShadow:
                view().showDropShadow();
                break;
            case InnerShadow:
                view().showInnerShadow();
                break;
            // case Shadow:
            // view().showShadow();
            // break;
            case Bloom:
                view().showBloom();
                break;
            case Glow:
                view().showGlow();
                break;
            case Lighting:
                view().showLighting();
                break;
            case BoxBlur:
                view().showBoxBlur();
                break;
            case MotionBlur:
                view().showMotionBlur();
                break;
            case GaussianBlur:
                view().showGaussianBlur();
                break;
            case PerspectiveTransform:
                view().showPerspectiveTransform();
                break;
            case Blend:
                view().showBlend();
                break;
            case ColorAdjust:
                view().showColorAdjust();
                break;
            case DisplacementMap:
                view().showDisplacementMap();
                break;

            default:
                view().showSlideStep(slideStep);
        }
    }
}
