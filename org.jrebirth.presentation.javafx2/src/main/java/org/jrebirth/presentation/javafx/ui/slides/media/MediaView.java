package org.jrebirth.presentation.javafx.ui.slides.media;

import java.net.URL;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>MediaView</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class MediaView extends AbstractTemplateView<MediaModel, AnchorPane, MediaController> {

    private MediaPlayer mediaPlayer;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public MediaView(final MediaModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return buildDefaultContent(getModel().getDefaultContent());
    }

    /**
     * TODO To complete.
     */
    public void showVideo() {
        final URL mediaURL = Thread.currentThread().getContextClassLoader().getResource("media/Strobo.flv");
        this.mediaPlayer = new MediaPlayer(new Media(mediaURL.toString()));
        final javafx.scene.media.MediaView mv = new javafx.scene.media.MediaView(this.mediaPlayer);
        this.mediaPlayer.setCycleCount(-1);

        this.mediaPlayer.play();
        // getRootNode().setCenter(mv);

        showCustomSlideStep(mv);

    }

    /**
     * TODO To complete.
     */
    public void showAudio() {
        this.mediaPlayer.stop();
    }

    /**
     * TODO To complete.
     */
    public void showMoveOut() {

        ParallelTransitionBuilder.create()
                .interpolator(Interpolator.EASE_BOTH)
                .node(getSlideContent()) // getRootNode().getCenter()
                .children(
                        RotateTransitionBuilder.create()
                                .byAngle(7200)
                                .cycleCount(1)
                                .duration(Duration.seconds(4))
                                .build(),
                        SequentialTransitionBuilder.create()
                                .children(
                                        ScaleTransitionBuilder.create()
                                                .cycleCount(1)
                                                .fromX(1.0)
                                                .fromY(1.0)
                                                .toX(0.1)
                                                .toY(0.1)
                                                .duration(Duration.seconds(2))
                                                .build(),
                                        ScaleTransitionBuilder.create()
                                                .cycleCount(1)
                                                .fromX(0.1)
                                                .fromY(0.1)
                                                .toX(1.0)
                                                .toY(1.0)
                                                .duration(Duration.seconds(2))
                                                .build()
                                ).build()

                )
                .build().play();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doReload() {
        // Nothing to do yet

    }
}
