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
package org.jrebirth.af.presentation.javafx.ui.slides.shape;

import org.jrebirth.af.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>ShapeModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ShapeModel extends AbstractTemplateModel<ShapeModel, ShapeView, ShapeSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected ShapeSlideStep[] initializeSlideStep() {
        return ShapeSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final ShapeSlideStep slideStep) {
        switch (slideStep) {
            case Arc:
                view().showArc();
                break;
            case Circle:
                view().showCircle();
                break;
            case CubicCurve:
                view().showCubicCurve();
                break;
            case Ellipse:
                view().showEllipse();
                break;
            case Line:
                view().showLine();
                break;
            case Path:
                view().showPath();
                break;
            case Polygon:
                view().showPolygon();
                break;
            case Polyline:
                view().showPolyline();
                break;
            case QuadCurve:
                view().showQuadCurve();
                break;
            case Rectangle:
                view().showRectangle();
                break;
            case SVGPath:
                view().showSVGPath();
                break;
            case Text:
                view().showText();
                break;
            default:
                view().showSlideStep(slideStep);
        }
    }

}
