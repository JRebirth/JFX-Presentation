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
package org.jrebirth.af.presentation.javafx.ui.slides.handler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>HandlerView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class HandlerView extends AbstractTemplateView<HandlerModel, AnchorPane, HandlerController> {

    /** The stage used for demo. */
    private Stage stage;

    /** The scene used for demo. */
    private Scene scene;

    /** The layout used for demo. */
    private BorderPane borderPane;

    /** The button used for demo. */
    private Button button;

    /** The text area used for demo. */
    private TextArea center;

    /** The label used for demo. */
    private Node top;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public HandlerView(final HandlerModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {
        super.initView();
        final Label topLabel = new Label("Top Label");
        topLabel.setStyle("-fx-background-color: #CCCCCC;-fx-font-size:1.4em;-fx-label-padding:20px");
        this.top = topLabel;

        this.center = new TextArea();
        this.center.setText("");
        this.center.setMinWidth(600);
        this.center.setStyle("-fx-font-size:1.4em");

        this.button = new Button("Effacer");
        this.button.setStyle("-fx-background-color: #CCCCCC;-fx-font-size:1.4em;-fx-label-padding:20px");

        this.borderPane = new BorderPane();
        this.borderPane.setTop(this.top);
        this.borderPane.setCenter(this.center);
        this.borderPane.setBottom(this.button);

        BorderPane.setAlignment(this.top, Pos.CENTER);
        BorderPane.setAlignment(this.center, Pos.CENTER);
        BorderPane.setAlignment(this.button, Pos.CENTER);

        BorderPane.setMargin(this.top, new Insets(0));
        BorderPane.setMargin(this.center, new Insets(0));
        BorderPane.setMargin(this.button, new Insets(0));

        this.scene = new Scene(this.borderPane);

        this.stage = new Stage();
        this.stage.setHeight(700);
        this.stage.setWidth(980);
        this.stage.setResizable(true);
        this.stage.setTitle("Event Filtering and Handling Demo");
        this.stage.initStyle(StageStyle.DECORATED);
        this.stage.setScene(this.scene);
    }

    /**
     * Gets the stage.
     * 
     * @return Returns the stage.
     */
    Stage getStage() {
        return this.stage;
    }

    /**
     * Gets the scene.
     * 
     * @return Returns the scene.
     */
    Scene scene() {
        return this.scene;
    }

    /**
     * Gets the border pane.
     * 
     * @return Returns the borderPane.
     */
    BorderPane getBorderPane() {
        return this.borderPane;
    }

    /**
     * Gets the button.
     * 
     * @return Returns the button.
     */
    Node getButton() {
        return this.button;
    }

    /**
     * Gets the center.
     * 
     * @return Returns the center.
     */
    TextArea getCenter() {
        return this.center;
    }

    /**
     * Gets the top.
     * 
     * @return Returns the top.
     */
    Node getTop() {
        return this.top;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return new Pane();
    }

    /**
     * Show the text.
     */
    public void showText() {
        this.stage.close();

        showCustomSlideStep(buildDefaultContent(model().getDefaultContent()));
    }

    /**
     * Show the stage demo.
     */
    public void showHandlerStage() {

        showEmptySlide();

        this.stage.centerOnScreen();
        this.stage.show();
        this.stage.toFront();

    }

}
