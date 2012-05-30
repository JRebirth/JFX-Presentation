package org.jrebirth.presentation.javafx.ui.slides.handler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.layout.PaneBuilder;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import javafx.stage.StageStyle;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>HandlerView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class HandlerView extends AbstractTemplateView<HandlerModel, BorderPane, HandlerController> {

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
    protected void customInitializeComponents() {
        super.customInitializeComponents();
        this.top = LabelBuilder.create()
                .text("Top Label")
                .style("-fx-background-color: #CCCCCC;-fx-font-size:1.4em;-fx-label-padding:20px")
                .build();
        this.center = TextAreaBuilder.create()
                .text("")
                .minWidth(600)
                .style("-fx-font-size:1.4em")
                .build();
        this.button = ButtonBuilder.create()
                .text("Effacer")
                .style("-fx-background-color: #CCCCCC;-fx-font-size:1.4em;-fx-label-padding:20px")
                .build();

        this.borderPane = BorderPaneBuilder.create()
                .top(this.top)
                .center(this.center)
                .bottom(this.button)
                .build();

        BorderPane.setAlignment(this.top, Pos.CENTER);
        BorderPane.setAlignment(this.center, Pos.CENTER);
        BorderPane.setAlignment(this.button, Pos.CENTER);

        BorderPane.setMargin(this.top, new Insets(0));
        BorderPane.setMargin(this.center, new Insets(0));
        BorderPane.setMargin(this.button, new Insets(0));

        this.scene = SceneBuilder.create()
                .root(this.borderPane)
                .build();

        this.stage = StageBuilder.create()
                .height(700)
                .width(980)
                .resizable(true)
                .focused(true)
                .title("Event Filtering and Handling Demo")
                .style(StageStyle.DECORATED)
                .scene(this.scene).build();
    }

    /**
     * @return Returns the stage.
     */
    Stage getStage() {
        return this.stage;
    }

    /**
     * @return Returns the scene.
     */
    Scene getScene() {
        return this.scene;
    }

    /**
     * @return Returns the borderPane.
     */
    BorderPane getBorderPane() {
        return this.borderPane;
    }

    /**
     * @return Returns the button.
     */
    Node getButton() {
        return this.button;
    }

    /**
     * @return Returns the center.
     */
    TextArea getCenter() {
        return this.center;
    }

    /**
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
        return PaneBuilder.create().build();
    }

    /**
     * Show the text.
     */
    public void showText() {
        this.stage.close();

        getRootNode().setCenter(buildDefaultContent(getModel().getDefaultContent()));
    }

    /**
     * Show the stage demo.
     */
    public void showHandlerStage() {

        this.stage.centerOnScreen();
        this.stage.show();
        this.stage.toFront();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doReload() {
        // Nothing to do yet
        
    }

}
