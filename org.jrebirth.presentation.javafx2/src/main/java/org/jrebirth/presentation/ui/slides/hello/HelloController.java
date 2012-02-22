package org.jrebirth.presentation.ui.slides.hello;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.adapter.DefaultMouseAdapter;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>HelloController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class HelloController extends AbstractTemplateController<HelloModel, HelloView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public HelloController(final HelloView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventAdapters() throws CoreException {
        super.customInitializeEventAdapters();

        // Use the inner class
        // buildMouseHandler(new ClickAdapter());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventHandlers() throws CoreException {

        super.customInitializeEventHandlers();

        // Listen mouse event on the source code node
        // getView().getCodeImageView().setOnMouseClicked(getMouseHandler());
    }

    /**
     * 
     * The class <strong>ClickAdapter</strong>.
     * 
     * @author Sébastien Bordes
     * 
     * @version $Revision$ $Author$
     * @since $Date$
     */
    private class ClickAdapter extends DefaultMouseAdapter<HelloController> {

        /**
         * {@inheritDoc}
         */
        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {

            ((Pane) getView().getRootNode().getCenter()).getChildren().clear();
            ((Pane) getView().getRootNode().getCenter()).getChildren().addAll(getView().getAppImageView(), getView().getCodeImageView());

            getView().getAppCarousselTransition().play();
            getView().getCodeCarousselTransition().play();

        }

    }

}
