package org.jrebirth.presentation.javafx.ui.slides.intro;

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

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.base.AbstractSlideView;

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
    protected void customInitializeComponents() {

        this.label = LabelBuilder
                .create()
                // .text(getModel().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t"))
                // .styleClass("label", "introTitle")
                // .font(PrezFonts.TYPEWRITER.get())
                // .textFill(Color.BLACK) // web("7F0055")
                .textFill(Color.WHITE)
                .alignment(Pos.CENTER_LEFT)
                .minWidth(800)
                .minHeight(500)
                .build();

        this.label.getStyleClass().add("introTitle");

        // label.scaleXProperty().bind(Bindings.divide(getModel().getLocalFacade().getGlobalFacade().getApplication().getStage().widthProperty(), 1024));
        // label.scaleYProperty().bind(Bindings.divide(getModel().getLocalFacade().getGlobalFacade().getApplication().getStage().heightProperty(), 768));

        getRootNode().getStyleClass().clear();
        getRootNode().getStyleClass().add(getModel().getSlide().getStyle());

        getRootNode().getChildren().add(this.label);
        StackPane.setAlignment(this.label, Pos.CENTER);

        this.typeWriter = new Timeline();
        this.typeWriter.setDelay(Duration.millis(500));
        String content = "";
        Duration d = Duration.ZERO;
        final Random r = new Random();
        for (final char c : getModel().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t").toCharArray()) {

            d = d.add(Duration.millis(r.nextInt() % 90 + 130));
            this.typeWriter.getKeyFrames().add(new KeyFrame(d, new KeyValue(this.label.textProperty(), new String(content + c))));
            content += c;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart() {
        this.typeWriter.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doReload() {
        // Nothing to do yet

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doHide() {
        // Nothing to do yet
    }

}
