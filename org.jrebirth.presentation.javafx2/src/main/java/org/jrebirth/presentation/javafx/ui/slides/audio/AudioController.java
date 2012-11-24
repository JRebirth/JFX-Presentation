package org.jrebirth.presentation.javafx.ui.slides.audio;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.base.AbstractSlideController;

/**
 * The class <strong>AudioController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class AudioController extends AbstractSlideController<AudioModel, AudioView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public AudioController(final AudioView view) throws CoreException {
        super(view);
    }

}
