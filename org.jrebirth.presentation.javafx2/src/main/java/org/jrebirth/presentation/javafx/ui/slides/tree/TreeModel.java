package org.jrebirth.presentation.javafx.ui.slides.tree;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>TreeModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class TreeModel extends AbstractTemplateModel<TreeModel, TreeView, TreeSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected TreeSlideStep[] initializeSlideStep() {
        return TreeSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final TreeSlideStep slideStep) {

        switch (slideStep) {

            case WoodNode:
                getView().showWoodNode();
                break;
            case ThinkNode:
                getView().showThinkNode();
                break;
            case Tree:
                getView().showTree();
                break;
            case ThinkTree:
                getView().showThinkTree();
                break;
            default:
                getView().showSlideStep(slideStep);
        }
    }
}
