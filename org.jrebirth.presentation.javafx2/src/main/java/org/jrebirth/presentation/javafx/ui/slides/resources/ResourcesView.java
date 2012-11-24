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

}