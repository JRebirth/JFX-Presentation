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
package org.jrebirth.af.presentation.javafx.ui.slides.animation;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.shape.SVGPathBuilder;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.javafx.resources.JfxColors;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>PatternView</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class AnimationView extends AbstractTemplateView<AnimationModel, AnchorPane, AnimationController> {

    /** The demo rectangle. */
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
        return buildDefaultContent(model().getDefaultContent());
    }

    /**
     * .
     * 
     * @param slideStep the slide step
     */
    public void buildDemoRectangle(final AnimationSlideStep slideStep) {

        final VBox vb = buildDefaultContent(model().getContent(slideStep));

        this.demoRectangle = RectangleBuilder.create()
                .width(200)
                .height(200)
                .strokeWidth(10)
                .fill(JfxColors.GRADIENT_3.get())
                .build();
        vb.getChildren().add(0, this.demoRectangle);
        StackPane.setAlignment(this.demoRectangle, Pos.TOP_CENTER);

        showCustomSlideStep(vb);
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
