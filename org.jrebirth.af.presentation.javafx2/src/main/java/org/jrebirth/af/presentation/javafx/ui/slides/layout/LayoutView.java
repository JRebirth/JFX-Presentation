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
package org.jrebirth.af.presentation.javafx.ui.slides.layout;

import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>LayoutView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class LayoutView extends AbstractTemplateView<LayoutModel, AnchorPane, LayoutController> {

    /** The <code>BG_5</code> field is used to TODO. */
    private static final String BG_5 = "-fx-background-color:#FBE43D";

    /** The <code>BG_4</code> field is used to TODO. */
    private static final String BG_4 = "-fx-background-color:#EA661D";

    /** The <code>BG_3</code> field is used to TODO. */
    private static final String BG_3 = "-fx-background-color:#E53B20";

    /** The <code>BG_2</code> field is used to TODO. */
    private static final String BG_2 = "-fx-background-color:#C13C8B";

    /** The <code>BG_1</code> field is used to TODO. */
    private static final String BG_1 = "-fx-background-color:#1C9A9A";
    /** The intro name transition. */
    private FadeTransition fadeTransition;

    /** The box effect. */
    private InnerShadow boxEffect;

    /**
     * The Layout name.
     * 
     * @param model the model
     * @throws CoreException the core exception
     */
    // private Label layoutName;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public LayoutView(final LayoutModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {
        // Nothing to do yet
        super.initView();

        this.boxEffect = new InnerShadow();
        this.boxEffect.setBlurType(BlurType.THREE_PASS_BOX);
        this.boxEffect.setRadius(8.0);
        this.boxEffect.setOffsetX(2);
        this.boxEffect.setOffsetY(2);
        this.boxEffect.setColor(Color.WHITE);

        node().setMaxSize(1000, 750);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return buildDefaultContent(model().getDefaultContent());
    }

    /**
     * Gets the fade transition.
     * 
     * @return Returns the fadeTransition.
     */
    FadeTransition getFadeTransition() {
        return this.fadeTransition;
    }

    /**
     * TODO To complete.
     * 
     * @param width the width
     * @param height the height
     * @param p the p
     * @param n the n
     * @param style the style
     * @return the stack pane
     */
    protected StackPane stackPane(final double width, final double height, final Pos p, final Node n, final String style) {
        final StackPane sp = new StackPane();
        sp.setPrefWidth(width);
        sp.setPrefHeight(height);
        sp.setAlignment(p);
        sp.getChildren().add(n);
        sp.setStyle(style);
        sp.setEffect(this.boxEffect);
        return sp;
    }

    /**
     * TODO To complete.
     * 
     * @param text the text
     * @return the label
     */
    private Label label(final String text) {
        final Label l = new Label(text);
        l.setScaleX(2.0);
        l.setScaleY(2.0);
        l.setTextFill(Color.WHITE);
        return l;
    }

    /**
     * TODO To complete.
     * 
     * @param text the text
     * @param style the CSS style string
     * @return the label
     */
    private Label label(final String text, final String style) {
        final Label l = label(text);
        l.setStyle(style);
        return l;
    }

    /**
     * Show the slide text.
     */
    public void showText() {
        // node().setCenter(getContentPanel());
    }

    /**
     * Show the pane sample.
     */
    public void showPane() {

        getSubTitle().setText("Pane");

        final Pane p = new Pane();
        p.setFocusTraversable(true);
        p.setMaxSize(800, 600);

        final StackPane sp1 = stackPane(700, 300, Pos.TOP_LEFT, label("1"), BG_1);
        sp1.setPadding(new Insets(20.0));
        sp1.setLayoutX(100);
        sp1.setLayoutY(100);
        p.getChildren().add(sp1);

        final StackPane sp2 = stackPane(200, 500, Pos.TOP_RIGHT, label("2"), BG_2);
        sp2.setPadding(new Insets(20.0));
        sp2.setLayoutX(500);
        sp2.setLayoutY(50);
        p.getChildren().add(sp2);

        final StackPane sp3 = stackPane(300, 100, Pos.CENTER, label("3"), "-fx-background-color:#65AF23");
        sp3.setLayoutX(300);
        sp3.setLayoutY(250);
        p.getChildren().add(sp3);

        final StackPane sp4 = stackPane(600, 50, Pos.CENTER, label("4"), BG_3);
        sp4.setLayoutX(150);
        sp4.setLayoutY(450);
        p.getChildren().add(sp4);

        // node().setCenter(p);
        showCustomSlideStep(p);
    }

    /**
     * Show the border pane sample.
     */
    public void showBorderPane() {

        getSubTitle().setText("BorderPane");

        final BorderPane bp = new BorderPane();
        bp.setFocusTraversable(true);
        bp.setMaxSize(800, 600);

        bp.setTop(stackPane(800, 100, Pos.CENTER, label("Top"), BG_1));
        bp.setLeft(stackPane(100, 400, Pos.CENTER, label("Left"), BG_2));

        bp.setCenter(stackPane(600, 400, Pos.CENTER, label("Center"), BG_3));

        bp.setRight(stackPane(100, 400, Pos.CENTER, label("Right"), BG_4));
        bp.setBottom(stackPane(800, 100, Pos.CENTER, label("Bottom"), BG_5));

        BorderPane.setAlignment(bp, Pos.CENTER);
        BorderPane.setMargin(bp, new Insets(40));

        // node().setCenter(bp);

        showCustomSlideStep(bp);
    }

    /**
     * Show the stack pane sample.
     */
    public void showStackPane() {

        getSubTitle().setText("StackPane");

        final StackPane sp = new StackPane();
        sp.setFocusTraversable(true);
        sp.setMaxSize(800, 600);

        sp.getChildren().add(label("TOP_LEFT", BG_1));
        sp.getChildren().add(label("TOP_CENTER", BG_2));
        sp.getChildren().add(label("TOP_RIGHT", BG_3));
        sp.getChildren().add(label("CENTER_LEFT", BG_3));
        sp.getChildren().add(label("CENTER", BG_1));
        sp.getChildren().add(label("CENTER_RIGHT", BG_2));
        sp.getChildren().add(label("BOTTOM_LEFT", BG_2));
        sp.getChildren().add(label("BOTTOM_CENTER", BG_4));
        sp.getChildren().add(label("BOTTOM_RIGHT", BG_5));

        StackPane.setAlignment(sp.getChildren().get(0), Pos.TOP_LEFT);
        StackPane.setAlignment(sp.getChildren().get(1), Pos.TOP_CENTER);
        StackPane.setAlignment(sp.getChildren().get(2), Pos.TOP_RIGHT);
        StackPane.setAlignment(sp.getChildren().get(3), Pos.CENTER_LEFT);
        StackPane.setAlignment(sp.getChildren().get(4), Pos.CENTER);
        StackPane.setAlignment(sp.getChildren().get(5), Pos.CENTER_RIGHT);
        StackPane.setAlignment(sp.getChildren().get(6), Pos.BOTTOM_LEFT);
        StackPane.setAlignment(sp.getChildren().get(7), Pos.BOTTOM_CENTER);
        StackPane.setAlignment(sp.getChildren().get(8), Pos.BOTTOM_RIGHT);
        sp.setStyle("-fx-background-color:#FFFFFF");

        BorderPane.setAlignment(sp, Pos.CENTER);
        BorderPane.setMargin(sp, new Insets(40));

        // node().setCenter(sp);
        showCustomSlideStep(sp);
    }

    /**
     * Build the H Box sample.
     */
    public void showHBox() {

        getSubTitle().setText("HBox");

        final HBox hb = new HBox();
        hb.setFocusTraversable(true);

        hb.setMaxSize(800, 400);

        hb.getChildren().add(stackPane(200, 200, Pos.CENTER, label("1"), BG_1));
        final Node n = stackPane(400, 200, Pos.CENTER, label("2"), BG_2);
        HBox.setHgrow(n, Priority.ALWAYS);
        hb.getChildren().add(n);
        hb.getChildren().add(stackPane(150, 200, Pos.CENTER, label("3"), BG_3));
        hb.getChildren().add(stackPane(200, 200, Pos.CENTER, label("4"), BG_4));
        final Node n2 = stackPane(300, 200, Pos.CENTER, label("5"), BG_5);
        HBox.setHgrow(n2, Priority.NEVER);
        hb.getChildren().add(n2);

        BorderPane.setAlignment(hb, Pos.CENTER);
        BorderPane.setMargin(hb, new Insets(40));

        // node().setCenter(hb);
        showCustomSlideStep(hb);
    }

    /**
     * Build the Vertical Box sample.
     */
    public void showVBox() {

        getSubTitle().setText("VBox");

        final VBox vb = new VBox();
        vb.setFocusTraversable(true);

        vb.getChildren().add(stackPane(200, 120, Pos.CENTER, label("1"), BG_1));
        vb.getChildren().add(stackPane(200, 100, Pos.CENTER, label("2"), BG_2));
        vb.getChildren().add(stackPane(200, 150, Pos.CENTER, label("3"), BG_3));
        vb.getChildren().add(stackPane(200, 80, Pos.CENTER, label("4"), BG_4));
        vb.getChildren().add(stackPane(200, 110, Pos.CENTER, label("5"), BG_5));

        BorderPane.setAlignment(vb, Pos.CENTER);
        BorderPane.setMargin(vb, new Insets(40));

        // node().setCenter(vb);
        showCustomSlideStep(vb);
    }

    /**
     * TODO To complete.
     */
    public void showFlowPane() {

        getSubTitle().setText("FlowPane");

        final Random r = new Random();

        final FlowPane flow1 = new FlowPane(Orientation.VERTICAL);
        flow1.setMinSize(400, 300);
        flow1.setMaxSize(400, 300);
        flow1.setPrefSize(400, 300);
        flow1.setColumnHalignment(HPos.RIGHT); // align labels on left
        flow1.setPrefWrapLength(400); // preferred height = 200
        for (int i = 0; i < 10; i++) {
            flow1.getChildren().add(stackPane(100 + r.nextInt(Integer.MAX_VALUE) % 60, 50 + r.nextInt(Integer.MAX_VALUE) % 30, Pos.CENTER, label("Pane " + i), BG_2));
        }
        flow1.setStyle(BG_5);

        final FlowPane flow2 = new FlowPane(Orientation.HORIZONTAL);
        flow2.setMinSize(400, 300);
        flow2.setMaxSize(400, 300);
        flow2.setPrefSize(400, 300);
        flow2.setRowValignment(VPos.BOTTOM); // align labels on left
        flow2.setPrefWrapLength(400); // preferred height = 200
        for (int i = 0; i < 10; i++) {
            flow2.getChildren().add(stackPane(100 + r.nextInt(Integer.MAX_VALUE) % 60, 50 + r.nextInt(Integer.MAX_VALUE) % 30, Pos.CENTER, label("Pane " + i), BG_3));
        }
        flow2.setStyle(BG_4);

        final Label label1 = new Label("Vertical [400x300]");
        final VBox v1 = new VBox(label1, flow1);
        final Label label2 = new Label("Horizontal [400x300]");
        final VBox v2 = new VBox(label2, flow2);

        // StackPane.setAlignment(v1, Pos.CENTER_LEFT);
        // StackPane.setMargin(v1, new Insets(40));
        //
        // StackPane.setAlignment(v2, Pos.CENTER_RIGHT);
        // StackPane.setMargin(v2, new Insets(40));


        final HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(40);
        hb.setPrefWidth(900);
        hb.setPrefHeight(640);
        hb.getChildren().addAll(v1, v2);

        StackPane.setAlignment(hb, Pos.CENTER);
        showCustomSlideStep(hb);
    }

    /**
     * TODO To complete.
     */
    public void showGridPane() {

        getSubTitle().setText("GridPane");

        final GridPane gridpane = new GridPane();
        gridpane.setMaxSize(800, 600);

        final ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setPercentWidth(50);
        final ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setPercentWidth(50);
        gridpane.getColumnConstraints().addAll(cc1, cc2);

        final RowConstraints rc1 = new RowConstraints();
        rc1.setMinHeight(150);
        final RowConstraints rc2 = new RowConstraints();
        rc2.setMinHeight(100);
        final RowConstraints rc3 = new RowConstraints();
        rc3.setMinHeight(200);
        gridpane.getRowConstraints().addAll(rc1, rc2, rc3);

        final StackPane sp1 = stackPane(150, 200, Pos.CENTER, label("First"), BG_1);
        final StackPane sp2 = stackPane(200, 200, Pos.CENTER, label("Second"), BG_2);
        final StackPane sp3 = stackPane(150, 100, Pos.CENTER, label("Third"), BG_3);
        final StackPane sp4 = stackPane(200, 100, Pos.CENTER, label("Fourth"), BG_4);
        final StackPane sp5 = stackPane(150, 300, Pos.CENTER, label("Fifth"), BG_5);

        GridPane.setConstraints(sp1, 0, 0);
        GridPane.setConstraints(sp2, 1, 0);
        GridPane.setConstraints(sp3, 0, 1, 2, 1);
        GridPane.setConstraints(sp4, 0, 2);
        GridPane.setConstraints(sp5, 1, 2);

        gridpane.getChildren().addAll(sp1, sp2, sp3, sp4, sp5);

        gridpane.setStyle("-fx-background-color:#00CCFF");

        BorderPane.setAlignment(gridpane, Pos.CENTER);
        BorderPane.setMargin(gridpane, new Insets(40));

        // node().setCenter(gridpane);
        showCustomSlideStep(gridpane);
    }

    /**
     * TODO To complete.
     */
    public void showTilePane() {

        getSubTitle().setText("TilePane");

        final TilePane tile = new TilePane(Orientation.HORIZONTAL);
        tile.setPrefSize(600, 450);
        tile.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        tile.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        tile.setPrefTileWidth(80);
        tile.setPrefTileHeight(80);
        for (int i = 0; i < 17; i++) {
            tile.getChildren().add(stackPane(100, 100, Pos.CENTER, label("Pane" + i), BG_3));
        }

        tile.setStyle(BG_4);

        // BorderPane.setAlignment(tile, Pos.CENTER);
        // BorderPane.setMargin(tile, new Insets(40));

        // node().setCenter(tile);

        showCustomSlideStep(tile);
    }

    /**
     * TODO To complete.
     */
    public void showAnchorPane() {

        getSubTitle().setText("AnchorPane");

        final AnchorPane anchorpane = new AnchorPane();

        final Node n1 = stackPane(400, 500, Pos.CENTER, label("Anchor 1 [bottom:10, left:10]"), BG_1);
        AnchorPane.setBottomAnchor(n1, 10.0);
        AnchorPane.setLeftAnchor(n1, 10.0);

        final Node n2 = stackPane(300, 200, Pos.CENTER, label("Anchor 2 [top:30, right:10]"), BG_2);
        AnchorPane.setTopAnchor(n2, 30.0);
        AnchorPane.setRightAnchor(n2, 10.0);

        final Node n3 = stackPane(500, 200, Pos.CENTER, label("No Anchor"), BG_3);

        anchorpane.getChildren().addAll(n1, n2, n3);

        BorderPane.setAlignment(anchorpane, Pos.CENTER);
        BorderPane.setMargin(anchorpane, new Insets(40));
        // node().setCenter(anchorpane);

        showCustomSlideStep(anchorpane);
    }

    /**
     * TODO To complete.
     */
    public void showAccordion() {

        getSubTitle().setText("Accordion");

        final Accordion accordion = new Accordion();

        accordion.getPanes().add(new TitledPane("First Row", stackPane(700, 400, Pos.CENTER, label("First"), BG_1)));
        accordion.getPanes().add(new TitledPane("Second Row", stackPane(700, 400, Pos.CENTER, label("Second"), BG_2)));
        accordion.getPanes().add(new TitledPane("Third Row", stackPane(700, 400, Pos.CENTER, label("Third"), BG_3)));

        BorderPane.setAlignment(accordion, Pos.CENTER);
        BorderPane.setMargin(accordion, new Insets(40));

        // node().setCenter(accordion);

        showCustomSlideStep(accordion);
    }

    /**
     * TODO To complete.
     */
    public void showScrollPane() {

        getSubTitle().setText("ScrollPane");

        final ScrollPane s1 = new ScrollPane();
        s1.setPrefSize(120, 120);
        s1.setContent(stackPane(1920, 1080, Pos.CENTER, label("A panel"), BG_3));

        BorderPane.setMargin(s1, new Insets(40));
        // node().setCenter(s1);

        showCustomSlideStep(s1);
    }

    /**
     * Show a split pane.
     */
    public void showSplitPane() {

        getSubTitle().setText("SplitPane");

        final SplitPane spH = new SplitPane();
        spH.setOrientation(Orientation.VERTICAL);
        spH.getItems().addAll(
                stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("Third"), BG_3),
                stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("Fourth"), BG_4));

        final SplitPane sp = new SplitPane();
        sp.setDividerPositions(0.3, 0.6, 0.9);
        sp.getItems().addAll(
                stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("First"), BG_1),
                spH,
                stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("Second"), BG_2));

        BorderPane.setMargin(sp, new Insets(40));
        // node().setCenter(sp);

        showCustomSlideStep(sp);
    }

    /**
     * Show a tab pane.
     */
    public void showTabPane() {

        getSubTitle().setText("TabPane");

        final TabPane tp = new TabPane();

        tp.getTabs().add(new Tab("Lorem"));
        tp.getTabs().add(new Tab("Ipsum"));
        tp.getTabs().add(new Tab("Dolor"));
        tp.getTabs().add(new Tab("Sit"));
        tp.getTabs().add(new Tab("Amet"));

        BorderPane.setAlignment(tp, Pos.CENTER);
        BorderPane.setMargin(tp, new Insets(40));

        // node().setCenter(tp);

        showCustomSlideStep(tp);

    }

}
