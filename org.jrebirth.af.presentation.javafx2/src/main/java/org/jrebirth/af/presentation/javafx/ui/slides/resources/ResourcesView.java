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
package org.jrebirth.af.presentation.javafx.ui.slides.resources;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.javafx.resources.JfxColors;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>ResourcesView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class ResourcesView extends AbstractTemplateView<ResourcesModel, AnchorPane, ResourcesController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public ResourcesView(final ResourcesModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return buildDefaultContent(model().getDefaultContent());
    }

    /**
     * TODO To complete.
     */
    public void showColor() {
        final VBox vb = buildDefaultContent(model().getContent(ResourcesSlideStep.Color));

        final RadialGradient rg = new RadialGradient(
                0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
                new Stop(0, JfxColors.GRADIENT_2.get()),
                new Stop(1, JfxColors.GRADIENT_1.get())
        );

        final LinearGradient lg = new LinearGradient(
                0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, JfxColors.GRADIENT_3.get()),
                new Stop(1, JfxColors.GRADIENT_1.get())
        );

        final Rectangle rectLg = new Rectangle(400, 150);
        rectLg.setFill(lg);
        final Rectangle rectRg = new Rectangle(400, 150);
        rectRg.setFill(rg);

        vb.getChildren().add(new FlowPane(rectLg, rectRg));

        showCustomSlideStep(vb);
    }

}