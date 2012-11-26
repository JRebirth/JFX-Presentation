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
package org.jrebirth.presentation.javafx.ui.slides.audio;

import javafx.scene.layout.BorderPane;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.base.AbstractSlideView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>AudioView</strong>.
 * 
 * The custom slide to demonstrate audi playback.
 * 
 * @author Sébastien Bordes
 */
public final class AudioView extends AbstractSlideView<AudioModel, BorderPane, AudioController> {

    /**
     * The player stage.
     * 
     * @param model the model
     * @throws CoreException the core exception
     */
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
    public void doStart() {
        // Nothing to do yet
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
