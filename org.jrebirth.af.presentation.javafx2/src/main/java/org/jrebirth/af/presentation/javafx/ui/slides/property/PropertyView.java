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
package org.jrebirth.af.presentation.javafx.ui.slides.property;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.javafx.resources.JfxColors;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>PropertyView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class PropertyView extends AbstractTemplateView<PropertyModel, AnchorPane, PropertyController> {

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
        return buildDefaultContent(model().getDefaultContent());
    }

    /**
     * Show the stack pane sample.
     */
    public void showBinding() {

        final VBox vb = buildDefaultContent(model().getContent(PropertySlideStep.Binding));

        final NumberFormat nf = new DecimalFormat("0.0");
        final Circle c = new Circle(50, JfxColors.SHAPE_BLUE.get());

        final Slider s = new Slider(0.1, 5, 1.0);
        s.setMajorTickUnit(1.0);
        s.setMaxWidth(200);

        final Label l = new Label("1.0");

        final FlowPane fp = new FlowPane(s, l);
        final StackPane sp = new StackPane(fp, c);

        StackPane.setAlignment(fp, Pos.CENTER_LEFT);
        StackPane.setAlignment(c, Pos.CENTER);

        vb.getChildren().add(sp);

        c.scaleXProperty().bind(s.valueProperty());
        c.scaleYProperty().bind(s.valueProperty());

        s.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(final ObservableValue<? extends Number> observable, final Number oldValue, final Number newValue) {
                l.setText(nf.format(newValue));
            }
        });

        showCustomSlideStep(vb);
    }

}
