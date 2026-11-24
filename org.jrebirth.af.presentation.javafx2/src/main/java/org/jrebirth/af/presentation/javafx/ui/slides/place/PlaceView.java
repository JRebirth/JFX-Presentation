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
package org.jrebirth.af.presentation.javafx.ui.slides.place;

import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.javafx.resources.JFXImages;
import org.jrebirth.af.presentation.ui.base.AbstractSlideView;

/**
 * 
 * The class <strong>IntroView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class PlaceView extends AbstractSlideView<PlaceModel, Pane, PlaceController> {

    /** The r. */
    private final Random r = new Random();

    /** The bubble animation. */
    private ParallelTransition bubbleAnimation;

    /**
     * Default Constructor.
     * 
     * @param model the IntroModel view model
     * 
     * @throws CoreException if build fails
     */
    public PlaceView(final PlaceModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        final ImageView toulouse = new ImageView(JFXImages.BZH.get());
        // .fitHeight(Double.MAX_VALUE)
        // .fitWidth(Double.MAX_VALUE)

        node().getChildren().add(toulouse);

        node().getStyleClass().add(model().getSlide().getStyle());

        // bulle jaune (52x52px) x:909 y:358 #FBE43D
        final Circle yellowCircle = createCircle(26, 935, 384, "-fx-fill:#FBE43D");
        // bulle verte (76x76px) x:752 y:251 #65AF23
        final Circle greenCircle = createCircle(38, 790, 289, "-fx-fill:#65AF23");
        // bulle rose (52x52px) x:863 y:225 #C13C8B
        final Circle pinkCircle = createCircle(26, 889, 251, "-fx-fill:#C13C8B");
        // bulle bleue (70x70px) x:777 y:125 #1C9A9A
        final Circle blueCircle = createCircle(35, 812, 160, "-fx-fill:#1C9A9A");
        // bulle orange clair (70x70px) x:889 y:130 #EA661D
        final Circle lightOrangeCircle = createCircle(35, 924, 165, "-fx-fill:#EA661D");
        // bulle orange fonce (50x50px) x:848 y: 36 #E53B20
        final Circle darkOrangeCircle = createCircle(25, 873, 61, "-fx-fill:#E53B20");

        node().getChildren().addAll(yellowCircle, greenCircle, pinkCircle, blueCircle, lightOrangeCircle, darkOrangeCircle);

        this.bubbleAnimation = new ParallelTransition(
                createFadeTransition(yellowCircle),
                createFadeTransition(greenCircle),
                createFadeTransition(pinkCircle),
                createFadeTransition(blueCircle),
                createFadeTransition(lightOrangeCircle),
                createFadeTransition(darkOrangeCircle)
        );
    }

    /**
     * Creates a Circle with the given radius, position, and inline style.
     *
     * @param radius   the circle radius
     * @param layoutX  the x position
     * @param layoutY  the y position
     * @param style    the inline CSS style
     * @return the configured Circle
     */
    private Circle createCircle(final double radius, final double layoutX, final double layoutY, final String style) {
        final Circle c = new Circle(radius);
        c.setLayoutX(layoutX);
        c.setLayoutY(layoutY);
        c.setStyle(style);
        return c;
    }

    /**
     * Creates a FadeTransition with randomised duration and delay for the given node.
     *
     * @param node the node to animate
     * @return the configured FadeTransition
     */
    private FadeTransition createFadeTransition(final Node node) {
        final FadeTransition ft = new FadeTransition(
                Duration.millis(this.r.nextInt(Integer.MAX_VALUE) % 2000 + 1000), node);
        ft.setFromValue(0);
        ft.setToValue(1.0);
        // ft.setCycleCount(Animation.INDEFINITE)
        ft.setAutoReverse(true);
        ft.setDelay(Duration.millis(this.r.nextInt(Integer.MAX_VALUE) % 400 + 400));
        return ft;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        this.bubbleAnimation.play(); // final TO CHECK
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        this.bubbleAnimation.playFromStart();
    }

}
