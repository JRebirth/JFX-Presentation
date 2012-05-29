package org.jrebirth.presentation.javafx.ui.slides.layout;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>LayoutModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 */
public final class LayoutModel extends AbstractTemplateModel<LayoutModel, LayoutView, LayoutSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected LayoutSlideStep[] initializeSlideStep() {
        return LayoutSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final LayoutSlideStep slideStep) {
        switch (slideStep) {
            case Text:
            case BorderConstraint:
            case BoxConstraint:
            case TileConstraint:
            case GridConstaint:
            case StackConstraint:
                getView().showSlideStep(slideStep);
                break;
            case Pane:
                getView().showPane();
                break;
            case BorderPane:
                getView().showBorderPane();
                break;
            case HBox:
                getView().showHBox();
                break;
            case VBox:
                getView().showVBox();
                break;
            case StackPane:
                getView().showStackPane();
                break;
            case FlowPane:
                getView().showFlowPane();
                break;
            case GridPane:
                getView().showGridPane();
                break;
            case TilePane:
                getView().showTilePane();
                break;
            case AnchorPane:
                getView().showAnchorPane();
                break;
            case Accordion:
                getView().showAccordion();
                break;
            case ScrollPane:
                getView().showScrollPane();
                break;
            case SplitPane:
                getView().showSplitPane();
                break;
            case TabPane:
                getView().showTabPane();
                break;
            default:
        }
    }

}
