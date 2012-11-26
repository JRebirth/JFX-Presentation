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
package org.jrebirth.presentation.javafx.ui.slides.resources;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.RadialGradientBuilder;
import javafx.scene.paint.StopBuilder;
import javafx.scene.shape.RectangleBuilder;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.javafx.JfxColors;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
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
        return buildDefaultContent(getModel().getDefaultContent());
    }

    /**
     * TODO To complete.
     */
    public void showColor() {
        final VBox vb = buildDefaultContent(getModel().getContent(ResourcesSlideStep.Color));

        final RadialGradient rg = RadialGradientBuilder.create()
                .centerX(0.5)
                .centerY(0.5).radius(0.5)
                .stops(
                        StopBuilder.create().color(JfxColors.GRADIENT_2.get()).offset(0).build(),
                        StopBuilder.create().color(JfxColors.GRADIENT_1.get()).offset(1).build()
                )
                .build();

        final LinearGradient lg = LinearGradientBuilder.create()
                .stops(
                        StopBuilder.create().color(JfxColors.GRADIENT_3.get()).offset(0).build(),
                        StopBuilder.create().color(JfxColors.GRADIENT_1.get()).offset(1).build()
                )
                .build();

        vb.getChildren().add(FlowPaneBuilder.create().children(
                RectangleBuilder.create().width(400).height(150).fill(lg).build(),
                RectangleBuilder.create().width(400).height(150).fill(rg).build()
                )
                .build());

        showCustomSlideStep(vb);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doHide() {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart() {
        // Nothing to do yet
    }

}