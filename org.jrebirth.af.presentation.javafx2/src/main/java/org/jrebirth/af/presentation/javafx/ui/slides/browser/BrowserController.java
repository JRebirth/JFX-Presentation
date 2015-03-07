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
package org.jrebirth.af.presentation.javafx.ui.slides.browser;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.adapter.DefaultMouseAdapter;
import org.jrebirth.af.presentation.command.ShowNextSlideCommand;
import org.jrebirth.af.presentation.command.ShowPreviousSlideCommand;
import org.jrebirth.af.presentation.command.ShowSlideMenuCommand;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateController;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>ControlsController</strong>.
 * 
 * @author Sébastien Bordes
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
    protected void initEventAdapters() throws CoreException {
        super.initEventAdapters();

        // Use the inner class
        addAdapter(new BrowserMouseAdapter());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventHandlers() throws CoreException {
        super.initEventHandlers();

        // Listen mouse event on the root node
        getView().getBrowser().setOnMouseClicked(getHandler(MouseEvent.MOUSE_CLICKED));
    }

    /**
     * 
     * The class <strong>BrowserMouseAdapter</strong>.
     * 
     * @author Sébastien Bordes
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
