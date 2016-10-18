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
package org.jrebirth.af.presentation.javafx.ui.slides.control;

import org.jrebirth.af.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
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
                view().showChoiceBox();
                break;
            case HTMLEditor:
                view().showHtmlEditor();
                break;
            // case Labeled:
            // view().showLabeled();
            // break;
            case ListView:
                view().showListView();
                break;
            case MenuBar:
                view().showMenuBar();
                break;
            case ProgressIndicator:
                view().showProgressIndicator();
                break;
            // case Separator:
            // view().showSeparator();
            // break;
            case Slider:
                view().showSlider();
                break;
            case TableView:
                view().showTableView();
                break;
            // case TextInputControl:
            // view().showTextInputControl();
            // break;
            case ToolBar:
                view().showToolBar();
                break;
            case TreeView:
                view().showTreeView();
                break;
            default:
                view().showSlideStep(slideStep);
        }
    }

}
