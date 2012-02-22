package org.jrebirth.presentation.ui.slides.property;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.PrezColors;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>PropertyView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class PropertyView extends AbstractTemplateView<PropertyModel, BorderPane, PropertyController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public PropertyView(final PropertyModel model) throws CoreException {
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
     * Show the stack pane sample.
     */
    public void showBinding() {

        VBox vb = buildDefaultContent(getModel().getContent(PropertySlideStep.Binding));

        final NumberFormat nf = new DecimalFormat("0.0");
        final Circle c = CircleBuilder.create().fill(PrezColors.SHAPE_BLUE.get()).radius(50).build();
        final Slider s = SliderBuilder.create().min(0.1).max(5).value(1.0).majorTickUnit(1.0).maxWidth(200).build();
        final Label l = LabelBuilder.create().text("1.0").build();

        FlowPane fp = FlowPaneBuilder.create().children(s, l).build();
        StackPane sp = StackPaneBuilder.create()
                .children(fp, c)
                .build();

        StackPane.setAlignment(fp, Pos.CENTER_LEFT);
        StackPane.setAlignment(c, Pos.CENTER);

        vb.getChildren().add(sp);

        c.scaleXProperty().bind(s.valueProperty());
        c.scaleYProperty().bind(s.valueProperty());

        s.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                l.setText(nf.format(newValue));
            }
        });

        getRootNode().setCenter(vb);
    }
}
