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

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.javafx.JfxColors;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>ShapeView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class ShapeView extends AbstractTemplateView<ShapeModel, AnchorPane, ShapeController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public ShapeView(final ShapeModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return buildDefaultContent(getModel().getDefaultContent());
    }

    /**
     * Show the pane sample.
     */
    public void showArc() {

        getSubTitle().setText("Arc");

        // Arc arc = ArcBuilder.create().centerX(300).centerY(300).fill(Color.DARKGOLDENROD).build();
        final Arc roundArc = new Arc();
        roundArc.setCenterX(50.0f);
        roundArc.setCenterY(50.0f);
        roundArc.setRadiusX(100.0f);
        roundArc.setRadiusY(100.0f);
        roundArc.setStartAngle(45.0f);
        roundArc.setLength(270.0f);
        roundArc.setType(ArcType.ROUND);
        roundArc.setFill(JfxColors.GRADIENT_1.get());

        final Arc chordArc = new Arc();
        chordArc.setCenterX(50.0f);
        chordArc.setCenterY(50.0f);
        chordArc.setRadiusX(100.0f);
        chordArc.setRadiusY(100.0f);
        chordArc.setStartAngle(45.0f);
        chordArc.setLength(270.0f);
        chordArc.setType(ArcType.CHORD);
        chordArc.setFill(JfxColors.GRADIENT_2.get());

        final Arc openArc = new Arc();
        openArc.setCenterX(50.0f);
        openArc.setCenterY(50.0f);
        openArc.setRadiusX(100.0f);
        openArc.setRadiusY(100.0f);
        openArc.setStartAngle(45.0f);
        openArc.setLength(270.0f);
        openArc.setType(ArcType.OPEN);
        openArc.setFill(JfxColors.GRADIENT_3.get());

        final Arc roundArc2 = new Arc();
        roundArc2.setCenterX(50.0f);
        roundArc2.setCenterY(50.0f);
        roundArc2.setRadiusX(100.0f);
        roundArc2.setRadiusY(100.0f);
        roundArc2.setStartAngle(45.0f);
        roundArc2.setLength(60.0f);
        roundArc2.setType(ArcType.ROUND);
        roundArc2.setFill(JfxColors.GRADIENT_1.get());

        final Arc chordArc2 = new Arc();
        chordArc2.setCenterX(50.0f);
        chordArc2.setCenterY(50.0f);
        chordArc2.setRadiusX(100.0f);
        chordArc2.setRadiusY(100.0f);
        chordArc2.setStartAngle(45.0f);
        chordArc2.setLength(60.0f);
        chordArc2.setType(ArcType.CHORD);
        chordArc2.setFill(JfxColors.GRADIENT_2.get());

        final Arc openArc2 = new Arc();
        openArc2.setCenterX(50.0f);
        openArc2.setCenterY(50.0f);
        openArc2.setRadiusX(100.0f);
        openArc2.setRadiusY(100.0f);
        openArc2.setStartAngle(45.0f);
        openArc2.setLength(60.0f);
        openArc2.setType(ArcType.OPEN);
        openArc2.setFill(JfxColors.GRADIENT_3.get());

        final FlowPane fp = FlowPaneBuilder.create().children(roundArc, chordArc, openArc, roundArc2, chordArc2, openArc2).build();

        // getRootNode().setCenter(fp);
        showCustomSlideStep(fp);

        StackPane.setAlignment(fp, Pos.CENTER);
        StackPane.setMargin(fp, new Insets(40));
    }

    /**
     * Show the border pane sample.
     */
    public void showCircle() {

        getSubTitle().setText("Circle");

        final Circle plainCircle = new Circle();
        plainCircle.setCenterX(100.0f);
        plainCircle.setCenterY(100.0f);
        plainCircle.setRadius(50.0f);
        plainCircle.setFill(JfxColors.GRADIENT_1.get());
        // plainCircle.setBlendMode(BlendMode.MULTIPLY);

        final Circle strokeCircle = new Circle();
        strokeCircle.setCenterX(100.0f);
        strokeCircle.setCenterY(100.0f);
        strokeCircle.setRadius(50.0f);
        strokeCircle.setFill(null);
        strokeCircle.setStroke(JfxColors.GRADIENT_2.get());
        strokeCircle.setStrokeWidth(4);
        // strokeCircle.setBlendMode(BlendMode.LIGHTEN);

        final Circle fullCircle = new Circle();
        fullCircle.setCenterX(100.0f);
        fullCircle.setCenterY(100.0f);
        fullCircle.setRadius(50.0f);
        fullCircle.setStroke(JfxColors.GRADIENT_3.get());
        fullCircle.setStrokeWidth(4);
        fullCircle.setFill(JfxColors.GRADIENT_1.get());
        // fullCircle.setBlendMode(BlendMode.LIGHTEN);

        final FlowPane fp = FlowPaneBuilder.create().children(plainCircle, strokeCircle, fullCircle).build();

        // getRootNode().setCenter(fp);
        showCustomSlideStep(fp);

        StackPane.setAlignment(fp, Pos.CENTER);
        StackPane.setMargin(fp, new Insets(40));
    }

    /**
     * Show the stack pane sample.
     */
    public void showLine() {

        getSubTitle().setText("Line");

        final StackPane sp = new StackPane();

        final Line line = new Line();
        line.setFill(JfxColors.SHAPE_BLUE.get());
        line.setStroke(JfxColors.SLIDE_TITLE.get());
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(400.0f);
        line.setEndY(400.0f);

        sp.getChildren().addAll(line);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * Build the H Box sample.
     */
    public void showCubicCurve() {

        getSubTitle().setText("CubicCurve");

        final Pane sp = new Pane();

        // control point
        final Circle c1 = CircleBuilder.create()
                .radius(10)
                .layoutX(300.0)
                .layoutY(0.0)
                .fill(Color.LIGHTGRAY)
                .cursor(Cursor.HAND)
                .build();

        final NodeDragHandler dh1 = new NodeDragHandler();
        c1.setOnMousePressed(dh1);
        c1.setOnMouseDragged(dh1);

        // control point
        final Circle c2 = CircleBuilder.create()
                .radius(10)
                .layoutX(400.0)
                .layoutY(500.0)
                .fill(Color.LIGHTGRAY)
                .cursor(Cursor.HAND)
                .build();

        final NodeDragHandler dh2 = new NodeDragHandler();
        c2.setOnMousePressed(dh2);
        c2.setOnMouseDragged(dh2);

        final CubicCurve cubic = new CubicCurve();
        cubic.setFill(JfxColors.GRADIENT_2.get());
        cubic.setStroke(JfxColors.GRADIENT_3.get());
        cubic.setStartX(200.0f);
        cubic.setStartY(200.0f);
        cubic.setControlX1(300.0f);
        cubic.setControlY1(0.0f);
        cubic.setControlX2(400.0f);
        cubic.setControlY2(500.0f);
        cubic.setEndX(600.0f);
        cubic.setEndY(300.0f);

        final Line line1 = LineBuilder.create().stroke(Color.LIGHTGREY).strokeDashArray(10.0, 5.0)
                .startX(c1.getLayoutX()).startY(c1.getLayoutY())
                .endX(cubic.getStartX()).endY(cubic.getStartY())
                .build();

        final Line line2 = LineBuilder.create().stroke(Color.LIGHTGREY).strokeDashArray(10.0, 5.0)
                .startX(c2.getLayoutX()).startY(c2.getLayoutY())
                .endX(cubic.getEndX()).endY(cubic.getEndY())
                .build();

        line1.startXProperty().bind(c1.layoutXProperty());
        line1.startYProperty().bind(c1.layoutYProperty());
        line1.endXProperty().bind(cubic.startXProperty());
        line1.endYProperty().bind(cubic.startYProperty());

        line2.startXProperty().bind(c2.layoutXProperty());
        line2.startYProperty().bind(c2.layoutYProperty());
        line2.endXProperty().bind(cubic.endXProperty());
        line2.endYProperty().bind(cubic.endYProperty());

        //
        cubic.controlX1Property().bind(c1.layoutXProperty());
        cubic.controlY1Property().bind(c1.layoutYProperty());

        cubic.controlX2Property().bind(c2.layoutXProperty());
        cubic.controlY2Property().bind(c2.layoutYProperty());

        sp.getChildren().addAll(line1, line2, cubic, c1, c2);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * Build the Vertical Box sample.
     */
    public void showEllipse() {

        getSubTitle().setText("Ellipse");

        final StackPane sp = new StackPane();

        final Ellipse ellipse = new Ellipse();
        ellipse.setFill(JfxColors.SHAPE_BLUE.get());
        ellipse.setStroke(JfxColors.SLIDE_TITLE.get());
        ellipse.setCenterX(50.0f);
        ellipse.setCenterY(50.0f);
        ellipse.setRadiusX(100.0f);
        ellipse.setRadiusY(50.0f);

        sp.getChildren().addAll(ellipse);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));

    }

    /**
     * Show a path.
     */
    public void showPath() {

        getSubTitle().setText("Path");

        final StackPane sp = new StackPane();

        final Path path = new Path();
        path.setFill(JfxColors.GRADIENT_2.get());

        final MoveTo moveTo = new MoveTo();
        moveTo.setX(0.0f);
        moveTo.setY(0.0f);

        final HLineTo hLineTo = new HLineTo();
        hLineTo.setX(70.0f);

        final QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(120.0f);
        quadCurveTo.setY(60.0f);
        quadCurveTo.setControlX(100.0f);
        quadCurveTo.setControlY(0.0f);

        final LineTo lineTo = new LineTo();
        lineTo.setX(175.0f);
        lineTo.setY(55.0f);

        final ArcTo arcTo = new ArcTo();
        arcTo.setX(50.0f);
        arcTo.setY(50.0f);
        arcTo.setRadiusX(50.0f);
        arcTo.setRadiusY(50.0f);

        path.getElements().add(moveTo);
        path.getElements().add(hLineTo);
        path.getElements().add(quadCurveTo);
        path.getElements().add(lineTo);
        path.getElements().add(arcTo);

        sp.getChildren().addAll(path);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * Show a polygon.
     */
    public void showPolygon() {

        getSubTitle().setText("Polygon");

        final StackPane sp = new StackPane();

        final Polygon polygon = new Polygon();
        polygon.setFill(JfxColors.GRADIENT_1.get());
        polygon.getPoints().addAll(new Double[] {
                0.0, 0.0,
                200.0, 100.0,
                100.0, 200.0,
                50.0, 50.0
        });

        sp.getChildren().addAll(polygon);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * Show a polyline.
     */
    public void showPolyline() {

        getSubTitle().setText("Polyline");

        final StackPane sp = new StackPane();

        final Polyline polyline = new Polyline();
        polyline.setFill(JfxColors.GRADIENT_3.get());
        polyline.getPoints().addAll(new Double[] {
                0.0, 0.0,
                200.0, 100.0,
                100.0, 200.0,
                50.0, 50.0 });

        sp.getChildren().addAll(polyline);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * Show a quadratic curve.
     */
    public void showQuadCurve() {

        getSubTitle().setText("QuadCurve");

        final Pane sp = new Pane();

        // X AND Y position of mouse

        // control point
        final Circle c = CircleBuilder.create()
                .radius(10)
                .layoutX(300.0)
                .layoutY(100.0)
                .fill(Color.LIGHTGRAY)
                .cursor(Cursor.HAND)
                .build();

        final NodeDragHandler dh = new NodeDragHandler();
        c.setOnMousePressed(dh);
        c.setOnMouseDragged(dh);

        final QuadCurve quad = new QuadCurve();
        quad.setFill(JfxColors.GRADIENT_2.get());
        quad.setStroke(JfxColors.GRADIENT_3.get());
        quad.setStartX(200.0f);
        quad.setStartY(200.0f);
        quad.setEndX(600.0f);
        quad.setEndY(300.0f);

        quad.setControlX(300.0f);
        quad.setControlY(100.0f);

        final Line line1 = LineBuilder.create().stroke(Color.LIGHTGREY).strokeDashArray(10.0, 5.0)
                .startX(c.getLayoutX()).startY(c.getLayoutY())
                .endX(quad.getStartX()).endY(quad.getStartY())
                .build();
        final Line line2 = LineBuilder.create().stroke(Color.LIGHTGREY).strokeDashArray(10.0, 5.0)
                .startX(c.getLayoutX()).startY(c.getLayoutY())
                .endX(quad.getEndX()).endY(quad.getEndY())
                .build();

        c.layoutXProperty().bindBidirectional(line1.startXProperty());
        c.layoutYProperty().bindBidirectional(line1.startYProperty());
        quad.startXProperty().bindBidirectional(line1.endXProperty());
        quad.startYProperty().bindBidirectional(line1.endYProperty());

        c.layoutXProperty().bindBidirectional(line2.startXProperty());
        c.layoutYProperty().bindBidirectional(line2.startYProperty());
        quad.endXProperty().bindBidirectional(line2.endXProperty());
        quad.endYProperty().bindBidirectional(line2.endYProperty());

        c.layoutYProperty().bindBidirectional(quad.controlYProperty());
        c.layoutXProperty().bindBidirectional(quad.controlXProperty());

        sp.getChildren().addAll(line1, line2, quad, c);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * The Class NodeDragHandler.
     */
    private class NodeDragHandler implements EventHandler<MouseEvent> {

        /** The c x. */
        double cX = 0.0;
        
        /** The c y. */
        double cY = 0.0;

        /** The mousex. */
        double mousex = 0;
        
        /** The mousey. */
        double mousey = 0;

        /**
         * {@inheritDoc}
         */
        @Override
        public void handle(final MouseEvent me) {

            final Node node = (Node) me.getSource();

            if (me.getEventType() == MouseEvent.MOUSE_PRESSED) {

                // record the current mouse X and Y position on Node
                this.mousex = me.getSceneX();
                this.mousey = me.getSceneY();
                // get the x and y position measure from Left-Top
                this.cX = node.getLayoutX();
                this.cY = node.getLayoutY();

                me.consume();

            } else if (me.getEventType() == MouseEvent.MOUSE_DRAGGED) {

                // Get the exact moved X and Y
                this.cX += me.getSceneX() - this.mousex;
                this.cY += me.getSceneY() - this.mousey;

                // set the positon of Node after calculation
                node.setLayoutX(this.cX);
                node.setLayoutY(this.cY);

                // again set current Mouse x AND y position
                this.mousex = me.getSceneX();
                this.mousey = me.getSceneY();

                // me.consume();

            }

        }
    }

    /**
     * Show a Rectangle.
     */
    public void showRectangle() {

        getSubTitle().setText("Rectangle");

        final StackPane sp = new StackPane();

        final Rectangle r = new Rectangle();
        r.setFill(JfxColors.GRADIENT_1.get());
        r.setX(50);
        r.setY(50);
        r.setWidth(400);
        r.setHeight(200);
        r.setArcWidth(20);
        r.setArcHeight(10);

        sp.getChildren().addAll(r);

        // getRootNode().setCenter(sp);
        showCustomSlideStep(sp);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * Show a SVG Path.
     */
    public void showSVGPath() {

        getSubTitle().setText("SVGPath");

        final StackPane sp = new StackPane();

        final SVGPath svg = new SVGPath();
        svg.setFill(JfxColors.GRADIENT_1.get());
        svg.setStroke(JfxColors.GRADIENT_2.get());
        svg.setContent("M40,60 C42,48 44,30 25,32");

        svg.setScaleX(4.0);
        svg.setScaleY(4.0);

        // getRootNode().setCenter(svg);
        showCustomSlideStep(svg);

        StackPane.setAlignment(sp, Pos.CENTER);
        StackPane.setMargin(sp, new Insets(40));
    }

    /**
     * Show a text.
     */
    public void showText() {

        getSubTitle().setText("Text");

        final TilePane tp = new TilePane();
        tp.setHgap(20);
        tp.setVgap(20);
        tp.setPrefColumns(3);

        final Text t1 = new Text(10, 50, "This is a test");
        t1.setFont(new Font(20));

        final Text t2 = new Text();
        t2.setFont(new Font(20));
        t2.setText("First row\nSecond row");

        final Text t3 = new Text();
        t3.setFont(new Font(20));
        t3.setWrappingWidth(200);
        t3.setTextAlignment(TextAlignment.JUSTIFY);
        t3.setText("The quick brown fox jumps over the lazy dog");

        tp.getChildren().addAll(t1, t2, t3);

        // getRootNode().setCenter(tp);
        showCustomSlideStep(tp);

        StackPane.setAlignment(tp, Pos.CENTER);
        StackPane.setMargin(tp, new Insets(40));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doHide() {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart() {
        // Nothing to do yet
    }

}
