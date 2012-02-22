package org.jrebirth.presentation.ui.slides.arch;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransitionBuilder;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.impl.FXMLComponent;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>HandlerView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class ArchView extends AbstractTemplateView<ArchModel, BorderPane, ArchController> {

    /** The Archi FXML Controller */
    private FXMLComponent<ArchNodeController> archComponent;

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
    public void animate() {
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
     * @return Returns the archiPane.
     */
    Node getArchiPane() {
        return this.archComponent.getNode();
    }

    /**
     * @return Returns the archiPane.
     */
    ArchNodeController getArchiController() {
        return this.archComponent.getController();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {

        this.archComponent = loadFXML("org/jrebirth/presentation/ui/slides/arch/ArchNode.fxml");

        this.archComponent.getNode().setScaleX(4);
        this.archComponent.getNode().setScaleY(4);
        this.archComponent.getNode().setScaleZ(4);

        return this.archComponent.getNode();
    }

    /**
     * TODO To complete.
     */
    void showMediaAndWebEngine() {
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
    void showJava2D() {
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

}
