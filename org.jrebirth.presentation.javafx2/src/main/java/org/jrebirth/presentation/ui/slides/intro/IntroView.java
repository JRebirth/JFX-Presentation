package org.jrebirth.presentation.ui.slides.intro;

import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.base.AbstractSlideView;

/**
 * 
 * The class <strong>IntroView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class IntroView extends AbstractSlideView<IntroModel, StackPane, IntroController> {

    /** The intro name transition. */
    private FadeTransition fadeTransition;

    /** The typewriter animation. */
    private Timeline typeWriter;

    /** The label shown. */
    private Label label;

    /** The label shown. */
    private ImageView background;

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
    protected void customInitializeComponents() {

        this.background = ImageViewBuilder.create()
                .image(loadImage("images/intro/Intro_ToulouseJug_Toulouse_Capitole.jpg"))
                .build();

        getRootNode().getChildren().add(this.background);
        StackPane.setAlignment(this.background, Pos.CENTER);

        this.label = LabelBuilder
                .create()
                // .text(getModel().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t"))
                // .styleClass("label", "introTitle")
                // .font(PrezFonts.TYPEWRITER.get())
                // .textFill(Color.BLACK) // web("#7F0055")
                .alignment(Pos.CENTER_LEFT)
                .minWidth(800)
                .minHeight(500)
                .build();

        label.getStyleClass().add("introTitle");

        // label.scaleXProperty().bind(Bindings.divide(getModel().getLocalFacade().getGlobalFacade().getApplication().getStage().widthProperty(), 1024));
        // label.scaleYProperty().bind(Bindings.divide(getModel().getLocalFacade().getGlobalFacade().getApplication().getStage().heightProperty(), 768));

        getRootNode().getStyleClass().clear();
        getRootNode().getStyleClass().add(getModel().getSlide().getStyle());

        getRootNode().getChildren().add(this.label);
        StackPane.setAlignment(this.label, Pos.CENTER);

        this.fadeTransition = new FadeTransition(Duration.seconds(2), this.background);
        this.fadeTransition.setFromValue(1.0f);
        this.fadeTransition.setToValue(0.0f);
        this.fadeTransition.setCycleCount(1);
        this.fadeTransition.setAutoReverse(false);

        this.typeWriter = new Timeline();
        String content = "";
        Duration d = Duration.ZERO;
        final Random r = new Random();
        for (final char c : getModel().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t").toCharArray()) {

            d = d.add(Duration.millis(r.nextInt() % 90 + 90));
            this.typeWriter.getKeyFrames().add(new KeyFrame(d, new KeyValue(this.label.textProperty(), new String(content + c))));
            content += c;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void animate() {
        getFadeTransition().playFromStart();
        this.typeWriter.play();
    }

    /**
     * @return Returns the fadeTransition.
     */
    FadeTransition getFadeTransition() {
        return this.fadeTransition;
    }

}
