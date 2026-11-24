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
package org.jrebirth.af.presentation.javafx.ui.slides.node;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

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
        return buildDefaultContent(model().getDefaultContent());
    }

    /**
     * TODO To complete.
     */
    public void showBounds1() {
        final StackPane customStackPane = new StackPane();

        final Rectangle rectangle = new Rectangle();
        rectangle.setWidth(500);
        rectangle.setHeight(300);
        rectangle.setFill(Color.ANTIQUEWHITE);
        rectangle.setStroke(Color.GOLDENROD);
        rectangle.setStrokeWidth(4);
        rectangle.getStrokeDashArray().addAll(10.0, 5.0, 2.0);

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

        final CheckBox cb1 = new CheckBox("BoundsInLocal");
        final CheckBox cb2 = new CheckBox("BoundsInParent");
        final CheckBox cb3 = new CheckBox("LayoutBounds");

        final CheckBox cb4 = new CheckBox("Effect");
        final CheckBox cb5 = new CheckBox("Rotate");
        final CheckBox cb6 = new CheckBox("Rotate and Translate");

        cb4.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(final ObservableValue<? extends Boolean> arg0, final Boolean arg1, final Boolean update) {
                if (update) {
                    final Reflection refl = new Reflection();
                    refl.setFraction(0.4);
                    refl.setTopOpacity(0.8);
                    refl.setBottomOpacity(0.3);
                    refl.setTopOffset(10.0);
                    rectangle.setEffect(refl);
                } else {
                    rectangle.setEffect(null);
                }

            }
        });

        cb5.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(final ObservableValue<? extends Boolean> arg0, final Boolean arg1, final Boolean update) {
                if (update) {
                    final Rotate rotate = new Rotate(30.0);
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
                    rectangle.getTransforms().add(new Rotate(30.0));
                    rectangle.getTransforms().add(new Translate(40, -147));
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

        final Rectangle r = new Rectangle();
        r.setX(bounds.getMaxX());
        r.setY(bounds.getMaxY());
        r.setWidth(bounds.getWidth());
        r.setHeight(bounds.getHeight());
        r.setFill(null);
        r.setStroke(stroke);
        r.setStrokeWidth(4.0);
        r.getStrokeDashArray().addAll(dash);

        return r;
    }

}
