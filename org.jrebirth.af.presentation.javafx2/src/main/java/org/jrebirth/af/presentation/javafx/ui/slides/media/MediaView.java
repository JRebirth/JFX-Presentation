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
package org.jrebirth.af.presentation.javafx.ui.slides.media;

import java.net.URL;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

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
        return buildDefaultContent(model().getDefaultContent());
    }

    /**
     * TODO To complete.
     */
    public void showVideo() {
        // resources.base.path relocates media under the module package tree
        final URL mediaURL = MediaView.class.getResource("/org/jrebirth/af/presentation/javafx/media/Strobo.flv");
        this.mediaPlayer = new MediaPlayer(new Media(mediaURL.toString()));
        final javafx.scene.media.MediaView mv = new javafx.scene.media.MediaView(this.mediaPlayer);
        this.mediaPlayer.setCycleCount(-1);

        this.mediaPlayer.play();
        // node().setCenter(mv);

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

        final RotateTransition rotate = new RotateTransition(Duration.seconds(4));
        rotate.setByAngle(7200);
        rotate.setCycleCount(1);

        final ScaleTransition scaleDown = new ScaleTransition(Duration.seconds(2));
        scaleDown.setCycleCount(1);
        scaleDown.setFromX(1.0);
        scaleDown.setFromY(1.0);
        scaleDown.setToX(0.1);
        scaleDown.setToY(0.1);

        final ScaleTransition scaleUp = new ScaleTransition(Duration.seconds(2));
        scaleUp.setCycleCount(1);
        scaleUp.setFromX(0.1);
        scaleUp.setFromY(0.1);
        scaleUp.setToX(1.0);
        scaleUp.setToY(1.0);

        final SequentialTransition seq = new SequentialTransition(scaleDown, scaleUp);

        final ParallelTransition parallel = new ParallelTransition(getSlideContent(), rotate, seq); // node().getCenter()
        parallel.setInterpolator(Interpolator.EASE_BOTH);
        parallel.play();

    }

}
