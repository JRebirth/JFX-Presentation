package org.jrebirth.presentation.javafx.ui.slides.animation;

import javafx.animation.Animation;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.FillTransitionBuilder;
import javafx.animation.Interpolator;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.PauseTransitionBuilder;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.StrokeTransitionBuilder;
import javafx.animation.TranslateTransitionBuilder;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.shape.SVGPathBuilder;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.javafx.JfxColors;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>PatternView</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class AnimationView extends AbstractTemplateView<AnimationModel, BorderPane, AnimationController> {

    private Rectangle demoRectangle;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public AnimationView(final AnimationModel model) throws CoreException {
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
     * .
     * 
     * @param slideStep
     */
    public void buildDemoRectangle(final AnimationSlideStep slideStep) {

        final VBox vb = buildDefaultContent(getModel().getContent(slideStep));

        this.demoRectangle = RectangleBuilder.create()
                .width(200)
                .height(200)
                .strokeWidth(10)
                .fill(JfxColors.GRADIENT_3.get())
                .build();
        vb.getChildren().add(0, this.demoRectangle);
        StackPane.setAlignment(this.demoRectangle, Pos.TOP_CENTER);

        getRootNode().setCenter(vb);
    }

    /**
     * TODO To complete.
     */
    public void showFade() {

        FadeTransitionBuilder.create()
                .node(this.demoRectangle)
                .fromValue(0.0)
                .toValue(1.0)
                .autoReverse(true)
                .cycleCount(Animation.INDEFINITE)
                .interpolator(Interpolator.EASE_IN)
                .duration(Duration.seconds(1))
                .build().play();
    }

    /**
     * TODO To complete.
     */
    public void showFill() {
        FillTransitionBuilder.create()
                .shape(this.demoRectangle)
                .fromValue(JfxColors.GRADIENT_1.get())
                .toValue(JfxColors.GRADIENT_2.get())
                .autoReverse(true)
                .cycleCount(Animation.INDEFINITE)
                .interpolator(Interpolator.EASE_IN)
                .duration(Duration.seconds(1))
                .build().play();

    }

    /**
     * TODO To complete.
     */
    public void showPath() {
        final String path = "M0 230.717C0 230.717 206.085 48.7446 313.587 86.8569 421.089 124.969 407.816 319.824 506.692 298.352 605.567 276.881 704.442 -39.8258 800 4.19133";
        PathTransitionBuilder.create()
                .node(this.demoRectangle)
                .path(SVGPathBuilder.create().content(path).build())
                .autoReverse(true)
                .cycleCount(Animation.INDEFINITE)
                .interpolator(Interpolator.EASE_IN)
                .duration(Duration.seconds(1))
                .build().play();

    }

    /**
     * TODO To complete.
     */
    public void showPause() {

        SequentialTransitionBuilder.create()
                .autoReverse(true)
                .cycleCount(Animation.INDEFINITE)
                .children(
                        RotateTransitionBuilder.create()
                                .node(this.demoRectangle)
                                .fromAngle(0)
                                .toAngle(180)
                                .interpolator(Interpolator.EASE_IN)
                                .duration(Duration.millis(400))
                                .build(),
                        PauseTransitionBuilder.create().duration(Duration.millis(600)).build())
                .build().play();
    }

    /**
     * TODO To complete.
     */
    public void showRotate() {
        RotateTransitionBuilder.create()
                .node(this.demoRectangle)
                .autoReverse(true)
                .fromAngle(0)
                .toAngle(540)
                .cycleCount(Animation.INDEFINITE)
                .interpolator(Interpolator.EASE_IN)
                .duration(Duration.seconds(1))
                .build().play();

    }

    /**
     * TODO To complete.
     */
    public void showScale() {
        ScaleTransitionBuilder.create()
                .node(this.demoRectangle)
                .fromX(1.0)
                .byX(0.1)
                .toX(2.0)
                .fromY(1.0)
                .byY(0.1)
                .toY(2.0)
                .autoReverse(true)
                .cycleCount(Animation.INDEFINITE)
                .interpolator(Interpolator.EASE_IN)
                .duration(Duration.seconds(1))
                .build().play();

    }

    /**
     * TODO To complete.
     */
    public void showStroke() {
        StrokeTransitionBuilder.create()
                .shape(this.demoRectangle)
                .fromValue(JfxColors.GRADIENT_1.get())
                .toValue(JfxColors.GRADIENT_2.get())
                .autoReverse(true)
                .cycleCount(Animation.INDEFINITE)
                .interpolator(Interpolator.EASE_IN)
                .duration(Duration.seconds(1))
                .build().play();
    }

    /**
     * TODO To complete.
     */
    public void showTranslate() {

        TranslateTransitionBuilder.create()
                .node(this.demoRectangle)
                .fromX(0.0)
                .toX(400.0)
                .fromY(0.0)
                .toY(200)
                .autoReverse(true)
                .cycleCount(Animation.INDEFINITE)
                .interpolator(Interpolator.EASE_BOTH)
                .duration(Duration.seconds(1))
                .build().play();
    }

}
