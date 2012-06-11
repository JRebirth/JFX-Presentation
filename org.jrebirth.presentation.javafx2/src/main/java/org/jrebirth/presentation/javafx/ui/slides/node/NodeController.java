package org.jrebirth.presentation.javafx.ui.slides.node;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>NodeController</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class NodeController extends AbstractTemplateController<NodeModel, NodeView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public NodeController(final NodeView view) throws CoreException {
        super(view);
    }

}
