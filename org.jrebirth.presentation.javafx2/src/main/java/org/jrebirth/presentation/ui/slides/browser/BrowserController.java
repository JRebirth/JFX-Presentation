package org.jrebirth.presentation.ui.slides.browser;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.adapter.DefaultMouseAdapter;
import org.jrebirth.presentation.command.ShowNextSlideCommand;
import org.jrebirth.presentation.command.ShowPreviousSlideCommand;
import org.jrebirth.presentation.command.ShowSlideMenuCommand;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>ControlsController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class BrowserController extends AbstractTemplateController<BrowserModel, BrowserView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public BrowserController(final BrowserView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventAdapters() throws CoreException {
        super.customInitializeEventAdapters();

        // Use the inner class
        buildMouseHandler(new BrowserMouseAdapter());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventHandlers() throws CoreException {
        super.customInitializeEventHandlers();

        // Listen mouse event on the root node
        getView().getBrowser().setOnMouseClicked(getMouseHandler());
    }

    /**
     * 
     * The class <strong>BrowserMouseAdapter</strong>.
     * 
     * @author Sébastien Bordes
     * 
     * @version $Revision$ $Author$
     * @since $Date$
     */
    private class BrowserMouseAdapter extends DefaultMouseAdapter<BrowserController> {

        /**
         * {@inheritDoc}
         */
        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {
            if (mouseEvent.getSource().equals(getView().getBrowser())) {
                mouseEvent.consume();
            } else {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    getModel().callCommand(ShowNextSlideCommand.class);
                } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    getModel().callCommand(ShowPreviousSlideCommand.class);
                } else if (mouseEvent.getButton() == MouseButton.MIDDLE) {
                    getModel().callCommand(ShowSlideMenuCommand.class);
                }
            }
        }
    }

}
