package org.jrebirth.presentation.ui.slides.hello;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.MoveToBuilder;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.QuadCurveToBuilder;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>HelloView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class HelloView extends AbstractTemplateView<HelloModel, BorderPane, HelloController> {

    /** The app carousel transition. */
    private ParallelTransition appCarousselTransition;

    /** The code carousel transition. */
    private ParallelTransition codeCarousselTransition;

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
    public void animate() {
        getAppImageView().toBack();
        getCodeImageView().toFront();
    }

    /**
     * @return Returns the carousselTransition.
     */
    ParallelTransition getAppCarousselTransition() {
        if (this.appCarousselTransition == null) {

            // Rotating
            final MoveTo mt = MoveToBuilder.create().x(0).y(200).build();
            final QuadCurveTo qct = QuadCurveToBuilder.create().controlX(500).controlY(100).x(0).y(0).build();
            final Path p = PathBuilder.create().elements(mt, qct).build();
            final PathTransition pt = PathTransitionBuilder.create().path(p).duration(Duration.seconds(4)).interpolator(Interpolator.EASE_BOTH).build();

            // Scaling
            final ScaleTransition st = ScaleTransitionBuilder.create().fromX(0.4).fromY(0.4).toX(1.4).toY(1.4).duration(Duration.seconds(4))
                    .interpolator(Interpolator.EASE_BOTH).build();

            // Global
            this.appCarousselTransition = new ParallelTransition();
            this.appCarousselTransition.getChildren().addAll(pt, st);
            this.appCarousselTransition.setCycleCount(1);

            this.appCarousselTransition.setAutoReverse(true);
            this.appCarousselTransition.setNode(getAppImageView());
        }
        return this.appCarousselTransition;
    }

    /**
     * @return Returns the carousselTransition.
     */
    ParallelTransition getCodeCarousselTransition() {
        if (this.codeCarousselTransition == null) {
            // Rotating
            final MoveTo mt = MoveToBuilder.create().x(0).y(0).build();
            final QuadCurveTo qct = QuadCurveToBuilder.create().controlX(-500).controlY(100).x(0).y(300).build();
            final Path p = PathBuilder.create().elements(mt, qct).build();
            final PathTransition pt = PathTransitionBuilder.create().path(p).duration(Duration.seconds(4)).interpolator(Interpolator.EASE_BOTH).build();

            // Scaling
            final ScaleTransition st = ScaleTransitionBuilder.create().fromX(1).fromY(1).toX(0.3).toY(0.3).duration(Duration.seconds(4))
                    .interpolator(Interpolator.EASE_BOTH).build();

            // Global
            this.codeCarousselTransition = new ParallelTransition();
            this.codeCarousselTransition.getChildren().addAll(pt, st);
            this.codeCarousselTransition.setCycleCount(1);

            this.codeCarousselTransition.setAutoReverse(true);
            this.codeCarousselTransition.setNode(getCodeImageView());
        }
        return this.codeCarousselTransition;
    }

    /**
     * @return Returns the codeImageView.
     */
    public ImageView getCodeImageView() {
        return this.codeImageView;
    }

    /**
     * @return Returns the appImageView.
     */
    public ImageView getAppImageView() {
        return this.appImageView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {
        super.customInitializeComponents();

        this.codeImageView.requestFocus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {

        final Image code = loadImage("images/hello/HelloToulouse Code.png");
        this.codeImageView = new ImageView(code);

        final DropShadow ds = new DropShadow();
        ds.setOffsetY(5.0);
        ds.setOffsetX(5.0);
        ds.setColor(Color.WHITESMOKE);

        final Reflection r = new Reflection();
        r.setTopOffset(10);
        r.setTopOpacity(0.4);
        r.setFraction(0.3);
        r.setInput(ds);
        // ds.setInput(r);
        this.codeImageView.setEffect(r);

        final Image app = loadImage("images/hello/HelloToulouse App.png");
        this.appImageView = new ImageView(app);

        final StackPane sp = new StackPane();

        final Group group = GroupBuilder.create()
                .children(this.appImageView, this.codeImageView)
                .build();

        sp.getChildren().add(group);
        // sp.getChildren().addAll(group);
        // StackPane.setAlignment(group, Pos.CENTER);

        // StackPane.setAlignment(this.appImageView, Pos.CENTER);
        // StackPane.setAlignment(this.codeImageView, Pos.CENTER);

        return sp;
    }

    /**
     * TODO To complete.
     */
    public void showCode() {
        this.codeImageView.setLayoutX(0);
        this.codeImageView.setLayoutX(0);
        this.codeImageView.setScaleX(0.8);
        this.codeImageView.setScaleY(0.8);

        this.appImageView.setLayoutX(0);
        this.appImageView.setLayoutY(200);
        this.appImageView.setScaleX(0.4);
        this.appImageView.setScaleY(0.4);
    }

    /**
     * TODO To complete.
     */
    public void showApplication() {
        final AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(final long now) {
                if (now > getAppCarousselTransition().getTotalDuration().toMillis()) {
                    getAppImageView().toFront();
                    getCodeImageView().toBack();
                }

            }

        };
        timer.start();
        getAppCarousselTransition().playFromStart();
        getCodeCarousselTransition().playFromStart();
    }
}
