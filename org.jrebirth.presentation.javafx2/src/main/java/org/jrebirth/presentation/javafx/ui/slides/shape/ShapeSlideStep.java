package org.jrebirth.presentation.javafx.ui.slides.shape;

import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>ShapeSlideStep</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public enum ShapeSlideStep implements SlideStep {

    /** The Speech step. */
    Speech,
    /** The Text step. */
    Text,
    /** The Line step. */
    Line,
    /** The Polygon step. */
    Polygon,
    /** The Polyline step. */
    Polyline,
    /** The Rectangle step. */
    Rectangle,

    /** The Arc step. */
    Arc,
    /** The Circle step. */
    Circle,
    /** The Ellipse step. */
    Ellipse,
    /** The QuadCurve step. */
    QuadCurve,
    /** The CubicCurve step. */
    CubicCurve,
    /** The Path step. */
    Path,
    /** The SVGPath step. */
    SVGPath;
}
