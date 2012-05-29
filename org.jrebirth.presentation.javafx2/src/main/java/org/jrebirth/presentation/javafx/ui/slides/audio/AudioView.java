package org.jrebirth.presentation.javafx.ui.slides.audio;

import javafx.scene.layout.BorderPane;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.base.AbstractSlideView;

/**
 * 
 * The class <strong>AudioView</strong>.
 * 
 * The custom slide to demonstrate audi playback.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class AudioView extends AbstractSlideView<AudioModel, BorderPane, AudioController> {

    /** The player stage. */
    // private FxExperiencePlayer player;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public AudioView(final AudioModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {

        // this.player = new FxExperiencePlayer();
        //
        // final Stage stage = StageBuilder.create()
        // .height(763)
        // .width(1203)
        // .build();
        //
        // this.player.start(stage);
        // stage.show();
    }

    // /**
    // * @return the player stage
    // */
    // public FxExperiencePlayer getPlayer() {
    // return this.player;
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        // Nothing to do yet
    }

}
