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
package org.jrebirth.af.presentation.javafx.ui.slides.arch;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransitionBuilder;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import org.jrebirth.af.core.exception.CoreException;
import org.jrebirth.af.core.ui.fxml.FXMLComponent;
import org.jrebirth.af.core.ui.fxml.FXMLUtils;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>HandlerView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class ArchView extends AbstractTemplateView<ArchModel, AnchorPane, ArchController> {

    /** The Archi FXML Controller. */
    private FXMLComponent archComponent;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public ArchView(final ArchModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        ScaleTransitionBuilder.create()
                .node(getArchiPane())
                .duration(Duration.millis(600))
                .interpolator(Interpolator.EASE_IN)
                .fromX(4)
                .fromY(4)
                .fromZ(4)
                .toX(2)
                .toY(2)
                .toZ(2)
                .build().play();
    }

    /**
     * Gets the archi pane.
     * 
     * @return Returns the archiPane.
     */
    Node getArchiPane() {
        return this.archComponent.getNode();
    }

    /**
     * Gets the archi controller.
     * 
     * @return Returns the archiPane.
     */
    ArchNodeController getArchiController() {
        return (ArchNodeController) this.archComponent.getController();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {

        this.archComponent = FXMLUtils.loadFXML(getModel(), "org/jrebirth/presentation/ui/slides/arch/ArchNode.fxml");

        this.archComponent.getNode().setScaleX(4);
        this.archComponent.getNode().setScaleY(4);
        this.archComponent.getNode().setScaleZ(4);

        return this.archComponent.getNode();
    }

    /**
     * TODO To complete.
     */
    void showMediaEngine() {
        // Nothing to do yet

    }

    /**
     * TODO To complete.
     */
    void showWebEngine() {
        // Nothing to do yet

    }

    /**
     * TODO To complete.
     */
    void showGlassWindowingToolit() {
        // Nothing to do yet

    }

    /**
     * TODO To complete.
     */
    void showOpenGLAndD3D() {
        // Nothing to do yet

    }

    /**
     * TODO To complete.
     */
    void showHardwareAcceleration() {
        // Nothing to do yet

    }

    /**
     * TODO To complete.
     */
    void showPrism() {
        // Nothing to do yet

    }

    /**
     * TODO To complete.
     */
    void showQuantumTookit() {
        // Nothing to do yet

    }

    /**
     * TODO To complete.
     */
    void showJavaFXApi() {
        // getArchiController().showNodes(true);
    }

    /**
     * TODO To complete.
     */
    void showJvm() {
        // getArchiController().showNodes(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        // Nothing to do yet
    }

}
