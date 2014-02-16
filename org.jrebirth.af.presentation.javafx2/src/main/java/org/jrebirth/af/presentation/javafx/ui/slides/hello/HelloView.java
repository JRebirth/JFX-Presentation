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
package org.jrebirth.af.presentation.javafx.ui.slides.hello;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import org.jrebirth.af.core.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>HelloView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class HelloView extends AbstractTemplateView<HelloModel, AnchorPane, HelloController> {

    /** The app carousel transition. */
    private ParallelTransition appCarousselTransition;

    /** The code carousel transition. */
    private Animation codeCarousselTransition;

    /** The image view of the code. */
    private ImageView codeImageView;

    /** The image view of the app. */
    private ImageView appImageView;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public HelloView(final HelloModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return buildDefaultContent(getModel().getDefaultContent());
    }

    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // protected Node getContentPanel() {
    //
    // final Image code = loadImage("images/hello/HelloToulouse Code.png");
    // this.codeImageView = new ImageView(code);
    //
    // final DropShadow ds = new DropShadow();
    // ds.setOffsetY(5.0);
    // ds.setOffsetX(5.0);
    // ds.setColor(Color.WHITESMOKE);
    //
    // final Reflection r = new Reflection();
    // r.setTopOffset(10);
    // r.setTopOpacity(0.4);
    // r.setFraction(0.3);
    // r.setInput(ds);
    // // ds.setInput(r);
    // this.codeImageView.setEffect(r);
    //
    // final Image app = loadImage("images/hello/HelloToulouse App.png");
    // this.appImageView = new ImageView(app);
    //
    // final StackPane sp = new StackPane();
    // sp.setPrefSize(800, 600);
    // sp.setStyle("-fx-background-color:#000000");
    //
    // final Group group = GroupBuilder.create()
    // .children(/* this.appImageView, */this.codeImageView)
    // .build();
    //
    // sp.getChildren().add(group);
    // // sp.getChildren().addAll(group);
    // // StackPane.setAlignment(group, Pos.CENTER);
    //
    // // StackPane.setAlignment(this.appImageView, Pos.CENTER);
    // // StackPane.setAlignment(this.codeImageView, Pos.CENTER);
    //
    // return sp;
    // }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public void start() {
    // super.doStart();
    // // getAppImageView().toBack();
    // // getCodeImageView().toFront();
    // }
    //
    // /**
    // * @return Returns the carousselTransition.
    // */
    // ParallelTransition getAppCarousselTransition() {
    // if (this.appCarousselTransition == null) {
    //
    // // // Rotating
    // // final MoveTo mt = MoveToBuilder.create()
    // // .x(0)
    // // .y(200)
    // // .build();
    // // final QuadCurveTo qct = QuadCurveToBuilder.create()
    // // .controlX(500)
    // // .controlY(100)
    // // .x(0)
    // // .y(0)
    // // .build();
    // // final Path p = PathBuilder.create()
    // // .elements(mt, qct)
    // // .build();
    // // final PathTransition pt = PathTransitionBuilder.create()
    // // .path(p)
    // // .duration(Duration.seconds(4))
    // // .interpolator(Interpolator.EASE_BOTH)
    // // .build();
    // //
    // // // Scaling
    // // final ScaleTransition st = ScaleTransitionBuilder.create()
    // // .fromX(0.25)
    // // .fromY(0.25)
    // // .toX(1.4)
    // // .toY(1.4)
    // // .duration(Duration.seconds(4))
    // // .interpolator(Interpolator.EASE_BOTH)
    // // .build();
    // //
    // // // Global
    // // this.appCarousselTransition = ParallelTransitionBuilder.create()
    // // .children(pt, st)
    // // .cycleCount(1)
    // // .autoReverse(true)
    // // .node(getAppImageView())
    // // .build();
    //
    // }
    // return this.appCarousselTransition;
    // }
    //
    // /**
    // * @return Returns the carousselTransition.
    // */
    // Animation getCodeCarousselTransition() {
    // if (this.codeCarousselTransition == null) {
    //
    // // Rotating
    // final MoveTo mt = MoveToBuilder.create()
    // .x(0)
    // .y(0)
    // .build();
    //
    // final QuadCurveTo qct = QuadCurveToBuilder.create()
    // .controlX(800)
    // .controlY(100)
    // .x(0)
    // .y(300)
    // .build();
    // final QuadCurveTo qct1 = QuadCurveToBuilder.create()
    // .controlX(-800)
    // .controlY(100)
    // .x(0)
    // .y(0)
    // .build();
    //
    // final Path p = PathBuilder.create()
    // .elements(mt, qct, qct1)
    // .build();
    //
    // final PathTransition pt = PathTransitionBuilder.create()
    // .path(p)
    // .duration(Duration.seconds(4))
    // // .interpolator(Interpolator.EASE_BOTH)
    // .build();
    //
    // // Scaling
    // final ScaleTransition st = ScaleTransitionBuilder.create()
    // .fromX(1.0)
    // .fromY(1.0)
    // .toX(0.6)
    // .toY(0.6)
    // .duration(Duration.seconds(4))
    // // .interpolator(Interpolator.EASE_BOTH)
    // .build();
    //
    // // Global
    // this.codeCarousselTransition = ParallelTransitionBuilder.create()
    // .children(
    //
    // )
    // .build();
    //
    // this.codeCarousselTransition = TranslateTransitionBuilder.create()
    // .node(getCodeImageView())
    // .fromX(0)
    // .fromY(0)
    // .byY(300)
    // .byY(300)
    // .toX(300)
    // .toY(300)
    // .build();
    // }
    // return this.codeCarousselTransition;
    // }
    //
    // /**
    // * @return Returns the codeImageView.
    // */
    // public ImageView getCodeImageView() {
    // return this.codeImageView;
    // }
    //
    // /**
    // * @return Returns the appImageView.
    // */
    // public ImageView getAppImageView() {
    // return this.appImageView;
    // }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // protected void initView() {
    // super.initView();
    //
    // // this.codeImageView.requestFocus();
    // }
    //
    // /**
    // * TODO To complete.
    // */
    // public void showCode() {
    // // this.codeImageView.setLayoutX(0);
    // // this.codeImageView.setLayoutX(0);
    // // this.codeImageView.setScaleX(1);
    // // this.codeImageView.setScaleY(1);
    // //
    // // // this.appImageView.setLayoutX(0);
    // // // this.appImageView.setLayoutY(200);
    // // this.appImageView.setScaleX(0.25);
    // // this.appImageView.setScaleY(0.25);
    // }
    //
    // /**
    // * TODO To complete.
    // */
    // public void showApplication() {
    // final AnimationTimer timer = new AnimationTimer() {
    //
    // @Override
    // public void handle(final long now) {
    // // if (now > getAppCarousselTransition().getTotalDuration().toMillis()) {
    // // getAppImageView().toFront();
    // // getCodeImageView().toBack();
    // // }
    //
    // }
    //
    // };
    // timer.start();
    //
    // // getAppCarousselTransition().play();
    // getCodeCarousselTransition().play();
    // }

}
