package org.jrebirth.presentation.javafx.ui.slides.node;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>WhyUseModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class NodeModel extends AbstractTemplateModel<NodeModel, NodeView, NodeSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected NodeSlideStep[] initializeSlideStep() {
        return NodeSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final NodeSlideStep slideStep) {
        getView().showSlideStep(slideStep);
    }

}
