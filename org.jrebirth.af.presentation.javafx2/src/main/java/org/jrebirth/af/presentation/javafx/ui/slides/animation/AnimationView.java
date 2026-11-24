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
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
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

        this.demoRectangle = new Rectangle(200, 200);
        this.demoRectangle.setStrokeWidth(10);
        this.demoRectangle.setFill(JfxColors.GRADIENT_3.get());
        vb.getChildren().add(0, this.demoRectangle);
        StackPane.setAlignment(this.demoRectangle, Pos.TOP_CENTER);

        showCustomSlideStep(vb);
    }

    /**
     * TODO To complete.
     */
    public void showFade() {

        final FadeTransition fade = new FadeTransition(Duration.seconds(1), this.demoRectangle);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setAutoReverse(true);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.setInterpolator(Interpolator.EASE_IN);
        fade.play();
    }

    /**
     * TODO To complete.
     */
    public void showFill() {
        final FillTransition fill = new FillTransition(Duration.seconds(1), this.demoRectangle);
        fill.setFromValue(JfxColors.GRADIENT_1.get());
        fill.setToValue(JfxColors.GRADIENT_2.get());
        fill.setAutoReverse(true);
        fill.setCycleCount(Animation.INDEFINITE);
        fill.setInterpolator(Interpolator.EASE_IN);
        fill.play();

    }

    /**
     * TODO To complete.
     */
    public void showPath() {
        final String path = "M0 230.717C0 230.717 206.085 48.7446 313.587 86.8569 421.089 124.969 407.816 319.824 506.692 298.352 605.567 276.881 704.442 -39.8258 800 4.19133";
        final SVGPath svgPath = new SVGPath();
        svgPath.setContent(path);
        final PathTransition pathTrans = new PathTransition(Duration.seconds(1), svgPath, this.demoRectangle);
        pathTrans.setAutoReverse(true);
        pathTrans.setCycleCount(Animation.INDEFINITE);
        pathTrans.setInterpolator(Interpolator.EASE_IN);
        pathTrans.play();

    }

    /**
     * TODO To complete.
     */
    public void showPause() {

        final RotateTransition rotatePause = new RotateTransition(Duration.millis(400), this.demoRectangle);
        rotatePause.setFromAngle(0);
        rotatePause.setToAngle(180);
        rotatePause.setInterpolator(Interpolator.EASE_IN);

        final PauseTransition pause = new PauseTransition(Duration.millis(600));

        final SequentialTransition seq = new SequentialTransition(rotatePause, pause);
        seq.setAutoReverse(true);
        seq.setCycleCount(Animation.INDEFINITE);
        seq.play();
    }

    /**
     * TODO To complete.
     */
    public void showRotate() {
        final RotateTransition rotate = new RotateTransition(Duration.seconds(1), this.demoRectangle);
        rotate.setAutoReverse(true);
        rotate.setFromAngle(0);
        rotate.setToAngle(540);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.EASE_IN);
        rotate.play();

    }

    /**
     * TODO To complete.
     */
    public void showScale() {
        final ScaleTransition scale = new ScaleTransition(Duration.seconds(1), this.demoRectangle);
        scale.setFromX(1.0);
        scale.setByX(0.1);
        scale.setToX(2.0);
        scale.setFromY(1.0);
        scale.setByY(0.1);
        scale.setToY(2.0);
        scale.setAutoReverse(true);
        scale.setCycleCount(Animation.INDEFINITE);
        scale.setInterpolator(Interpolator.EASE_IN);
        scale.play();

    }

    /**
     * TODO To complete.
     */
    public void showStroke() {
        final StrokeTransition stroke = new StrokeTransition(Duration.seconds(1), this.demoRectangle);
        stroke.setFromValue(JfxColors.GRADIENT_1.get());
        stroke.setToValue(JfxColors.GRADIENT_2.get());
        stroke.setAutoReverse(true);
        stroke.setCycleCount(Animation.INDEFINITE);
        stroke.setInterpolator(Interpolator.EASE_IN);
        stroke.play();
    }

    /**
     * TODO To complete.
     */
    public void showTranslate() {

        final TranslateTransition translate = new TranslateTransition(Duration.seconds(1), this.demoRectangle);
        translate.setFromX(0.0);
        translate.setToX(400.0);
        translate.setFromY(0.0);
        translate.setToY(200);
        translate.setAutoReverse(true);
        translate.setCycleCount(Animation.INDEFINITE);
        translate.setInterpolator(Interpolator.EASE_BOTH);
        translate.play();
    }

}
