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
package org.jrebirth.presentation.javafx.ui.slides.handler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>HandlerController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class HandlerController extends AbstractTemplateController<HandlerModel, HandlerView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public HandlerController(final HandlerView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventAdapters() throws CoreException {
        super.customInitializeEventAdapters();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeEventHandlers() throws CoreException {

        super.customInitializeEventHandlers();

        final FilterMouseAdapter filter = new FilterMouseAdapter();
        final HandlerMouseAdapter handler = new HandlerMouseAdapter();

        // Listen mouse event on the root node
        getView().getStage().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        getView().getScene().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        getView().getBorderPane().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        getView().getTop().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        getView().getCenter().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        getView().getButton().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);

        getView().getStage().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        getView().getScene().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        getView().getBorderPane().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        getView().getTop().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        getView().getCenter().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        getView().getButton().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);

    }

    /**
     * The class <strong>HandlerMouseAdapter</strong>.
     * 
     * @author Sébastien Bordes
     */
    private class HandlerMouseAdapter implements EventHandler<MouseEvent> {

        /**
         * {@inheritDoc}
         */
        @Override
        public void handle(final MouseEvent mouseEvent) {
            final String console = getView().getCenter().getText();

            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                getView().getCenter().setText(
                        console + "\n Bubble (handler) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");

                if (mouseEvent.getSource().equals(getView().getButton())) {
                    getView().getCenter().clear();
                }

            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {

                getView().getCenter().setText(
                        console + "\n Bubble (handler) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");
                if (mouseEvent.getSource().equals(getView().getBorderPane())) {
                    mouseEvent.consume();
                    getView().getCenter().setText(console + "\n Consumed by border pane handler");
                }

            } else if (mouseEvent.getButton() == MouseButton.MIDDLE) {
                getView().getStage().close();
            }
        }
    }

    /**
     * The class <strong>FilterMouseAdapter</strong>.
     * 
     * @author Sébastien Bordes
     */
    private class FilterMouseAdapter implements EventHandler<MouseEvent> {

        /**
         * {@inheritDoc}
         */
        @Override
        public void handle(final MouseEvent mouseEvent) {
            final String console = getView().getCenter().getText();

            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                getView().getCenter().setText(
                        console + "\n Capture (filter) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");

            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                getView().getCenter().setText(
                        console + "\n Capture (filter) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");
            }

        }
    }

}
