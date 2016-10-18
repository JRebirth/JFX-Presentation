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
package org.jrebirth.af.presentation.javafx.ui.slides.handler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateController;

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
    protected void initEventAdapters() throws CoreException {
        super.initEventAdapters();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventHandlers() throws CoreException {

        super.initEventHandlers();

        final FilterMouseAdapter filter = new FilterMouseAdapter();
        final HandlerMouseAdapter handler = new HandlerMouseAdapter();

        // Listen mouse event on the root node
        view().getStage().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        view().scene().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        view().getBorderPane().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        view().getTop().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        view().getCenter().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        view().getButton().addEventFilter(MouseEvent.MOUSE_CLICKED, filter);

        view().getStage().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        view().scene().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        view().getBorderPane().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        view().getTop().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        view().getCenter().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        view().getButton().addEventHandler(MouseEvent.MOUSE_CLICKED, handler);

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
            final String console = view().getCenter().getText();

            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                view().getCenter().setText(
                        console + "\n Bubble (handler) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");

                if (mouseEvent.getSource().equals(view().getButton())) {
                    view().getCenter().clear();
                }

            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {

                view().getCenter().setText(
                        console + "\n Bubble (handler) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");
                if (mouseEvent.getSource().equals(view().getBorderPane())) {
                    mouseEvent.consume();
                    view().getCenter().setText(console + "\n Consumed by border pane handler");
                }

            } else if (mouseEvent.getButton() == MouseButton.MIDDLE) {
                view().getStage().close();
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
            final String console = view().getCenter().getText();

            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                view().getCenter().setText(
                        console + "\n Capture (filter) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");

            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                view().getCenter().setText(
                        console + "\n Capture (filter) : " + mouseEvent.getSource().getClass().getSimpleName() + " (from " + mouseEvent.getTarget().getClass().getSimpleName() + ")");
            }

        }
    }

}
