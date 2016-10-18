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
package org.jrebirth.af.presentation.javafx.ui.slides.intro;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.base.AbstractSlideView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>IntroView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class IntroView extends AbstractSlideView<IntroModel, StackPane, IntroController> {

    /** The typewriter animation. */
    private Timeline typeWriter;

    /** The label shown. */
    private Label label;

    /**
     * Default Constructor.
     * 
     * @param model the IntroModel view model
     * 
     * @throws CoreException if build fails
     */
    public IntroView(final IntroModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        this.label = LabelBuilder
                                 .create()
                                 // .text(model().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t"))
                                 // .styleClass("label", "introTitle")
                                 // .font(PrezFonts.TYPEWRITER.get())
                                 // .textFill(Color.BLACK) // web("7F0055")
                                 .textFill(Color.WHITE)
                                 .alignment(Pos.CENTER_LEFT)
                                 .minWidth(800)
                                 .minHeight(500)
                                 .build();

        this.label.getStyleClass().add("introTitle");

        // label.scaleXProperty().bind(Bindings.divide(model().getLocalFacade().getGlobalFacade().getApplication().getStage().widthProperty(), 1024));
        // label.scaleYProperty().bind(Bindings.divide(model().getLocalFacade().getGlobalFacade().getApplication().getStage().heightProperty(), 768));

        node().getStyleClass().clear();
        node().getStyleClass().add(model().getSlide().getStyle());

        node().getChildren().add(this.label);
        StackPane.setAlignment(this.label, Pos.CENTER);

        this.typeWriter = new Timeline();
        this.typeWriter.setDelay(Duration.millis(500));
        String content = "";
        Duration d = Duration.ZERO;
        final Random r = new Random();
        for (final char c : model().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t").toCharArray()) {

            d = d.add(Duration.millis(r.nextInt(Integer.MAX_VALUE) % 90 + 130));
            this.typeWriter.getKeyFrames().add(new KeyFrame(d, new KeyValue(this.label.textProperty(), new String(content + c))));
            content += c;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        reload();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        this.typeWriter.play();
    }

}
