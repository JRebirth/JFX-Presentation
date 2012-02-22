package org.jrebirth.presentation.ui.slides.shape;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ShapeModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
