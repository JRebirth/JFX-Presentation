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

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>MediaView</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class MediaView extends AbstractTemplateView<MediaModel, AnchorPane, MediaController> {

    /** The media player. */
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

        showEmptySlide();
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
    public void hide() {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        // Nothing to do yet
    }

}
