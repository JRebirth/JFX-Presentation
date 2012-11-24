package org.jrebirth.presentation.javafx.ui.slides.media;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>MediaController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class MediaController extends AbstractTemplateController<MediaModel, MediaView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public MediaController(final MediaView view) throws CoreException {
        super(view);
    }

}
