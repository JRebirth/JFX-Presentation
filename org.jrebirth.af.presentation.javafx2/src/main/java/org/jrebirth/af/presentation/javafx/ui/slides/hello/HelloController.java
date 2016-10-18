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
package org.jrebirth.af.presentation.javafx.ui.slides.hello;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateController;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>HelloController</strong>.
 * 
 * @author Sébastien Bordes
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
    protected void initEventAdapters() throws CoreException {
        super.initEventAdapters();

        // Use the inner class
        // buildMouseHandler(new ClickAdapter());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventHandlers() throws CoreException {

        super.initEventHandlers();

        // Listen mouse event on the source code node
        // view().getCodeImageView().setOnMouseClicked(getMouseHandler());
    }

    // /**
    // *
    // * The class <strong>ClickAdapter</strong>.
    // *
    // * @author Sébastien Bordes
    // */
    // private class ClickAdapter extends DefaultMouseAdapter<HelloController> {
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public void mouseClicked(final MouseEvent mouseEvent) {
    //
    // ((Pane) view().node().getCenter()).getChildren().clear();
    // ((Pane) view().node().getCenter()).getChildren().addAll(view().getAppImageView(), view().getCodeImageView());
    //
    // view().getAppCarousselTransition().play();
    // view().getCodeCarousselTransition().play();
    //
    // }
    //
    // }

}
