package org.jrebirth.presentation.javafx.ui.slides.tree;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateController;

/**
 * The class <strong>TreeController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 */
public final class TreeController extends AbstractTemplateController<TreeModel, TreeView> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public TreeController(final TreeView view) throws CoreException {
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
    }
}
