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
package org.jrebirth.presentation.javafx.ui.slides.shape;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

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
                getView().showArc();
                break;
            case Circle:
                getView().showCircle();
                break;
            case CubicCurve:
                getView().showCubicCurve();
                break;
            case Ellipse:
                getView().showEllipse();
                break;
            case Line:
                getView().showLine();
                break;
            case Path:
                getView().showPath();
                break;
            case Polygon:
                getView().showPolygon();
                break;
            case Polyline:
                getView().showPolyline();
                break;
            case QuadCurve:
                getView().showQuadCurve();
                break;
            case Rectangle:
                getView().showRectangle();
                break;
            case SVGPath:
                getView().showSVGPath();
                break;
            case Text:
                getView().showText();
                break;
            default:
                getView().showSlideStep(slideStep);
        }
    }

}
