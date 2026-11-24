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
package org.jrebirth.af.presentation.javafx.ui.slides.tree;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.javafx.resources.JFXImages;
import org.jrebirth.af.presentation.resources.PrezFonts;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>TreeView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class TreeView extends AbstractTemplateView<TreeModel, AnchorPane, TreeController> {

    /** The wood node. */
    private ImageView woodNode;

    /** The tree. */
    private ImageView tree;

    /** The sp. */
    private StackPane sp;

    /** The think node. */
    private Label thinkNode;

    /** The think tree. */
    private Label thinkTree;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public TreeView(final TreeModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {
        super.initView();

        this.woodNode = new ImageView(JFXImages.NODE.get());
        this.woodNode.setScaleX(0.9);
        this.woodNode.setScaleY(0.9);

        this.tree = new ImageView(JFXImages.TREE.get());
        this.tree.setOpacity(0.0);
    }

    /**
     * TODO To complete.
     */
    public void showWoodNode() {
        this.sp = new StackPane();
        showCustomSlideStep(this.sp);

        this.sp.getChildren().add(this.woodNode);
        StackPane.setAlignment(this.woodNode, Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showThinkNode() {

        this.thinkNode = new Label("composée de nœuds");
        this.thinkNode.setFont(PrezFonts.SPLASH.get());
        this.thinkNode.setTextFill(Color.WHITE);
        this.thinkNode.setScaleX(500);
        this.thinkNode.setScaleY(500);

        this.sp.getChildren().add(this.thinkNode);
        StackPane.setAlignment(this.thinkNode, Pos.CENTER);

        final ScaleTransition st = new ScaleTransition(Duration.millis(400), this.thinkNode);
        st.setToX(2.5);
        st.setToY(2.5);
        st.setInterpolator(Interpolator.LINEAR);
        st.play();
    }

    /**
     * TODO To complete.
     */
    public void showTree() {

        this.tree.setScaleX(1000);
        this.tree.setScaleY(1000);

        final BoxBlur fx = new BoxBlur();
        fx.setWidth(1);
        fx.setHeight(1);
        fx.setIterations(3);
        this.tree.setEffect(fx);

        this.sp.getChildren().add(0, this.tree);
        StackPane.setAlignment(this.tree, Pos.CENTER);

        final FadeTransition fadeThinkNode = new FadeTransition(Duration.seconds(1), this.thinkNode);
        fadeThinkNode.setToValue(0);

        final ScaleTransition scaleWoodNode = new ScaleTransition(Duration.seconds(2), this.woodNode);
        scaleWoodNode.setToX(0.001);
        scaleWoodNode.setToY(0.001);
        scaleWoodNode.setInterpolator(Interpolator.LINEAR);

        final Timeline blurTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0), new KeyValue(fx.widthProperty(), 15.0), new KeyValue(fx.heightProperty(), 15.0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(fx.widthProperty(), 1), new KeyValue(fx.heightProperty(), 1)));

        final FadeTransition fadeTree = new FadeTransition(Duration.millis(1300), this.tree);
        fadeTree.setFromValue(0.1);
        fadeTree.setToValue(1.0);

        final ScaleTransition scaleTree = new ScaleTransition(Duration.seconds(2), this.tree);
        scaleTree.setToX(1);
        scaleTree.setToY(1);

        final ParallelTransition parallel = new ParallelTransition(scaleWoodNode, blurTimeline, fadeTree, scaleTree);
        parallel.setInterpolator(Interpolator.LINEAR);

        final SequentialTransition seq = new SequentialTransition(fadeThinkNode, parallel);
        seq.play();
    }

    /**
     * TODO To complete.
     */
    public void showThinkTree() {

        this.thinkTree = new Label("dans un arbre");
        this.thinkTree.setFont(PrezFonts.SPLASH.get());
        this.thinkTree.setTextFill(Color.WHITE);
        this.thinkTree.setScaleX(500);
        this.thinkTree.setScaleY(500);

        this.sp.getChildren().add(this.thinkTree);
        StackPane.setAlignment(this.thinkTree, Pos.CENTER);

        final ScaleTransition st = new ScaleTransition(Duration.millis(400), this.thinkTree);
        st.setToX(2.5);
        st.setToY(2.5);
        st.setInterpolator(Interpolator.LINEAR);
        st.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        this.sp = new StackPane();
        return this.sp;
    }

}
