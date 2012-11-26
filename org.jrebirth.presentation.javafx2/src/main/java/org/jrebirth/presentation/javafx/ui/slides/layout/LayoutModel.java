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
package org.jrebirth.presentation.javafx.ui.slides.layout;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>LayoutModel</strong>.
 * 
 * @author Sébastien Bordes
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
