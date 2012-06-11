package org.jrebirth.presentation.javafx.ui.slides.node;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>NodeModel</strong>.
 * 
 * @author Sébastien Bordes
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
        switch (slideStep) {
            case Bounds1:
                getView().showBounds1();
                break;
            default:
                getView().showSlideStep(slideStep);
        }

    }

}
