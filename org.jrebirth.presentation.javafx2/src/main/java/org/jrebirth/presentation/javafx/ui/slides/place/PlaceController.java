package org.jrebirth.presentation.javafx.ui.slides.place;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.base.AbstractSlideController;

/**
 * The class <strong>ControlsController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class PlaceController extends AbstractSlideController<PlaceModel, PlaceView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public PlaceController(final PlaceView view) throws CoreException {
        super(view);
    }

}
