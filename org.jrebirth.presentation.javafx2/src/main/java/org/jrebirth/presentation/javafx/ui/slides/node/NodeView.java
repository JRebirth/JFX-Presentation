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
package org.jrebirth.presentation.javafx.ui.slides.node;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;
import javafx.scene.transform.TranslateBuilder;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>NodeView</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class NodeView extends AbstractTemplateView<NodeModel, AnchorPane, NodeController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public NodeView(final NodeModel model) throws CoreException {
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
    public void showBounds1() {
        final StackPane customStackPane = new StackPane();

        final Rectangle rectangle = RectangleBuilder.create()
                .width(500)
                .height(300)
                .fill(Color.ANTIQUEWHITE)
                .stroke(Color.GOLDENROD)
                .strokeWidth(4)
                .strokeDashArray(10.0, 5.0, 2.0)
                .build();

        final Rectangle local = buildRectangle(rectangle.getBoundsInLocal(), Color.DODGERBLUE, 2.0, 10.0);
        final Rectangle parent = buildRectangle(rectangle.getBoundsInParent(), Color.DARKGRAY, 2.0, 15.0);
        final Rectangle layout = buildRectangle(rectangle.getLayoutBounds(), Color.DARKMAGENTA, 2.0, 20.0);

        final ChangeListener<Bounds> listener = new ChangeListener<Bounds>() {

            @Override
            public void changed(final ObservableValue<? extends Bounds> arg0, final Bounds arg1, final Bounds arg2) {
                updateBounds(local, rectangle.getBoundsInLocal());
                updateBounds(parent, rectangle.getBoundsInParent());
                updateBounds(layout, rectangle.getLayoutBounds());

            }

            private void updateBounds(final Rectangle rect, final Bounds bounds) {
                rect.setX(bounds.getMaxX());
                rect.setY(bounds.getMaxY());
                rect.setWidth(bounds.getWidth());
                rect.setHeight(bounds.getHeight());
            }
        };

        rectangle.boundsInLocalProperty().addListener(listener);
        rectangle.boundsInParentProperty().addListener(listener);
        rectangle.layoutBoundsProperty().addListener(listener);

        customStackPane.getChildren().addAll(layout, parent, local, rectangle);

        final VBox vb = new VBox();

        final CheckBox cb1 = CheckBoxBuilder.create().text("BoundsInLocal").build();
        final CheckBox cb2 = CheckBoxBuilder.create().text("BoundsInParent").build();
        final CheckBox cb3 = CheckBoxBuilder.create().text("LayoutBounds").build();

        final CheckBox cb4 = CheckBoxBuilder.create().text("Effect").build();
        final CheckBox cb5 = CheckBoxBuilder.create().text("Rotate").build();
        final CheckBox cb6 = CheckBoxBuilder.create().text("Rotate and Translate").build();

        cb4.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(final ObservableValue<? extends Boolean> arg0, final Boolean arg1, final Boolean update) {
                if (update) {
                    rectangle.setEffect(ReflectionBuilder.create().fraction(0.4).topOpacity(0.8).bottomOpacity(0.3).topOffset(10.0).build());
                } else {
                    rectangle.setEffect(null);
                }

            }
        });

        cb5.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(final ObservableValue<? extends Boolean> arg0, final Boolean arg1, final Boolean update) {
                if (update) {
                    final Rotate rotate = RotateBuilder.create().angle(30.0).build();
                    rectangle.getTransforms().add(rotate);
                } else {
                    rectangle.getTransforms().clear();
                }

            }
        });

        cb6.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(final ObservableValue<? extends Boolean> arg0, final Boolean arg1, final Boolean update) {
                if (update) {
                    rectangle.getTransforms().add(RotateBuilder.create().angle(30.0).build());
                    rectangle.getTransforms().add(TranslateBuilder.create().x(40).y(-147).build());
                } else {
                    rectangle.getTransforms().clear();
                }

            }
        });

        local.visibleProperty().bindBidirectional(cb1.selectedProperty());
        parent.visibleProperty().bindBidirectional(cb2.selectedProperty());
        layout.visibleProperty().bindBidirectional(cb3.selectedProperty());

        vb.getChildren().addAll(cb1, cb2, cb3, cb4, cb5, cb6);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER_LEFT);

        final BorderPane bp = new BorderPane();
        bp.setCenter(customStackPane);
        bp.setRight(vb);

        BorderPane.setAlignment(vb, Pos.CENTER_RIGHT);
        showCustomSlideStep(bp);
    }

    /**
     * TODO To complete.
     * 
     * @param bounds the bounds
     * @param stroke the stroke
     * @param dash the dash
     * @return the rectangle
     */
    private Rectangle buildRectangle(final Bounds bounds, final Color stroke, final Double... dash) {

        final Rectangle r = RectangleBuilder.create()
                .x(bounds.getMaxX())
                .y(bounds.getMaxY())
                .width(bounds.getWidth())
                .height(bounds.getHeight())
                .fill(null)
                .stroke(stroke)
                .strokeWidth(4.0)
                .strokeDashArray(dash)
                .build();

        return r;
    }

}
