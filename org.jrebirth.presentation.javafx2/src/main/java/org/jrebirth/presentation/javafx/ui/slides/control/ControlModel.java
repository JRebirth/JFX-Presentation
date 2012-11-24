package org.jrebirth.presentation.javafx.ui.slides.control;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ControlModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ControlModel extends AbstractTemplateModel<ControlModel, ControlView, ControlSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected ControlSlideStep[] initializeSlideStep() {
        return ControlSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final ControlSlideStep slideStep) {
        switch (slideStep) {
            case ChoiceBox:
                getView().showChoiceBox();
                break;
            case HTMLEditor:
                getView().showHtmlEditor();
                break;
            // case Labeled:
            // getView().showLabeled();
            // break;
            case ListView:
                getView().showListView();
                break;
            case MenuBar:
                getView().showMenuBar();
                break;
            case ProgressIndicator:
                getView().showProgressIndicator();
                break;
            // case Separator:
            // getView().showSeparator();
            // break;
            case Slider:
                getView().showSlider();
                break;
            case TableView:
                getView().showTableView();
                break;
            // case TextInputControl:
            // getView().showTextInputControl();
            // break;
            case ToolBar:
                getView().showToolBar();
                break;
            case TreeView:
                getView().showTreeView();
                break;
            default:
                getView().showSlideStep(slideStep);
        }
    }

}
