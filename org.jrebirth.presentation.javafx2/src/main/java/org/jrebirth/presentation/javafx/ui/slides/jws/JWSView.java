package org.jrebirth.presentation.javafx.ui.slides.jws;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>JWSView</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class JWSView extends AbstractTemplateView<JWSModel, AnchorPane, JWSController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public JWSView(final JWSModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return buildDefaultContent(getModel().getDefaultContent());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doReload() {
        // Nothing to do yet

    }

}
