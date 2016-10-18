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
package org.jrebirth.af.presentation.javafx.ui.slides.tree;

import org.jrebirth.af.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
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
                view().showWoodNode();
                break;
            case ThinkNode:
                view().showThinkNode();
                break;
            case Tree:
                view().showTree();
                break;
            case ThinkTree:
                view().showThinkTree();
                break;
            default:
                view().showSlideStep(slideStep);
        }
    }
}
