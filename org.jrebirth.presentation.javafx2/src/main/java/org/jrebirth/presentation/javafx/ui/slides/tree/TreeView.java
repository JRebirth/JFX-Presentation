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
package org.jrebirth.presentation.javafx.ui.slides.tree;

import javafx.animation.FadeTransitionBuilder;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.TimelineBuilder;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.BoxBlurBuilder;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.PrezFonts;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
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

        this.woodNode = ImageViewBuilder.create()
                .image(loadImage("images/tree/think_node.jpg")).scaleX(0.9).scaleY(0.9)
                .build();

        this.tree = ImageViewBuilder.create()
                .image(loadImage("images/tree/think_tree.jpg"))
                .opacity(0.0)
                .build();

        // getRootNode().setCenter(this.sp);
    }

    /**
     * TODO To complete.
     */
    public void showWoodNode() {
        this.sp = StackPaneBuilder.create().build();
        showCustomSlideStep(this.sp);

        this.sp.getChildren().add(this.woodNode);
        StackPane.setAlignment(this.woodNode, Pos.CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showThinkNode() {

        this.thinkNode = LabelBuilder.create()
                .text("composée de nœuds")
                .font(PrezFonts.SPLASH.get())
                .textFill(Color.WHITE)
                .scaleX(500)
                .scaleY(500)
                .build();

        this.sp.getChildren().add(this.thinkNode);
        StackPane.setAlignment(this.thinkNode, Pos.CENTER);

        ScaleTransitionBuilder.create().toX(2.5).toY(2.5).node(this.thinkNode).duration(Duration.millis(400)).interpolator(Interpolator.LINEAR).build().play();

    }

    /**
     * TODO To complete.
     */
    public void showTree() {

        this.tree.setScaleX(1000);
        this.tree.setScaleY(1000);

        final BoxBlur fx = BoxBlurBuilder.create()
                .width(1)
                .height(1)
                .iterations(3)
                .build();
        this.tree.setEffect(fx);

        this.sp.getChildren().add(0, this.tree);
        StackPane.setAlignment(this.tree, Pos.CENTER);

        SequentialTransitionBuilder.create().children(

                FadeTransitionBuilder.create().node(this.thinkNode).duration(Duration.seconds(1)).toValue(0).build(),

                ParallelTransitionBuilder.create().children(
                        ScaleTransitionBuilder.create().toX(0.001).toY(0.001).node(this.woodNode).duration(Duration.seconds(2)).interpolator(Interpolator.LINEAR).build(),
                        TimelineBuilder.create().keyFrames(
                                new KeyFrame(Duration.seconds(0), new KeyValue(fx.widthProperty(), 15.0), new KeyValue(fx.heightProperty(), 15.0)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(fx.widthProperty(), 1), new KeyValue(fx.heightProperty(), 1))
                                ).build(),
                        FadeTransitionBuilder.create().node(this.tree).fromValue(0.1).toValue(1.0).duration(Duration.millis(1300)).build(),
                        ScaleTransitionBuilder.create().toX(1).toY(1).node(this.tree).duration(Duration.seconds(2)).build()).interpolator(Interpolator.LINEAR).build()
                )
                .build().play();

    }

    /**
     * TODO To complete.
     */
    public void showThinkTree() {

        this.thinkTree = LabelBuilder.create()
                .text("dans un arbre")
                .font(PrezFonts.SPLASH.get())
                .textFill(Color.WHITE)
                .scaleX(500)
                .scaleY(500)
                .build();

        this.sp.getChildren().add(this.thinkTree);
        StackPane.setAlignment(this.thinkTree, Pos.CENTER);

        ScaleTransitionBuilder.create().toX(2.5).toY(2.5).node(this.thinkTree).duration(Duration.millis(400)).interpolator(Interpolator.LINEAR).build().play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        this.sp = StackPaneBuilder.create().build();
        return this.sp;
    }

}
