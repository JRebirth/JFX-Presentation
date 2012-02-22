package org.jrebirth.presentation.ui.slides.layout;

import javafx.animation.FadeTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPaneBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraintsBuilder;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraintsBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.TilePaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>LayoutView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class LayoutView extends AbstractTemplateView<LayoutModel, BorderPane, LayoutController> {

    /**
     * The <code>BG_5</code> field is used to TODO
     */
    private static final String BG_5 = "-fx-background-color:#29354f";
    /**
     * The <code>BG_4</code> field is used to TODO
     */
    private static final String BG_4 = "-fx-background-color:#bfa731";
    /**
     * The <code>BG_3</code> field is used to TODO
     */
    private static final String BG_3 = "-fx-background-color:#f44b14";
    /**
     * The <code>BG_2</code> field is used to TODO
     */
    private static final String BG_2 = "-fx-background-color:#e58b5d";
    /**
     * The <code>BG_1</code> field is used to TODO
     */
    private static final String BG_1 = "-fx-background-color:#3365b2";
    /** The intro name transition. */
    private FadeTransition fadeTransition;
    private InnerShadow boxEffect;

    /** The Layout name. */
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
    protected void customInitializeComponents() {
        // Nothing to do yet
        super.customInitializeComponents();

        boxEffect = InnerShadowBuilder.create().blurType(BlurType.THREE_PASS_BOX).radius(8.0).offsetX(2).offsetY(2).color(Color.WHITE).build();

        getRootNode().setMaxSize(1000, 750);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return buildDefaultContent(getModel().getDefaultContent());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void animate() {
        // getFadeTransition().playFromStart();
    }

    /**
     * @return Returns the fadeTransition.
     */
    FadeTransition getFadeTransition() {
        return this.fadeTransition;
    }

    /**
     * TODO To complete.
     * 
     * @return
     */
    protected StackPaneBuilder<?> stackPane(double width, double height, Pos p, Node n, String style) {
        return StackPaneBuilder.create().prefWidth(width).prefHeight(height).alignment(p).children(n).style(style).effect(boxEffect);
    }

    /**
     * TODO To complete.
     * 
     * @param string
     * @return
     */
    private LabelBuilder<?> label(String text) {
        return LabelBuilder.create().text(text).scaleX(2.0).scaleY(2.0).textFill(Color.WHITE);
    }

    /**
     * Show the slide text.
     */
    public void showText() {
        getRootNode().setCenter(getContentPanel());
    }

    /**
     * Show the pane sample.
     */
    public void showPane() {

        getSubTitle().setText("Pane");

        final Pane p = new Pane();
        p.setFocusTraversable(true);
        p.setMaxSize(800, 600);

        p.getChildren().add(stackPane(700, 300, Pos.TOP_LEFT, label("1").build(), BG_1).padding(new Insets(20.0)).layoutX(100).layoutY(100).build());
        p.getChildren().add(stackPane(200, 500, Pos.TOP_RIGHT, label("2").build(), BG_2).padding(new Insets(20.0)).layoutX(500).layoutY(50).build());
        p.getChildren().add(stackPane(300, 100, Pos.CENTER, label("3").build(), "-fx-background-color:#29354F").layoutX(300).layoutY(250).build());
        p.getChildren().add(stackPane(600, 50, Pos.CENTER, label("4").build(), BG_3).layoutX(150).layoutY(450).build());

        BorderPane.setAlignment(p, Pos.CENTER);
        BorderPane.setMargin(p, new Insets(40));

        getRootNode().setCenter(p);
    }

    /**
     * Show the border pane sample.
     */
    public void showBorderPane() {

        getSubTitle().setText("BorderPane");

        final BorderPane bp = new BorderPane();
        bp.setFocusTraversable(true);
        bp.setMaxSize(800, 600);

        bp.setTop(stackPane(800, 100, Pos.CENTER, label("Top").build(), BG_1).build());
        bp.setLeft(stackPane(100, 400, Pos.CENTER, label("Left").build(), BG_2).build());

        bp.setCenter(stackPane(600, 400, Pos.CENTER, label("Center").build(), BG_3).build());

        bp.setRight(stackPane(100, 400, Pos.CENTER, label("Right").build(), BG_4).build());
        bp.setBottom(stackPane(800, 100, Pos.CENTER, label("Bottom").build(), BG_5).build());

        BorderPane.setAlignment(bp, Pos.CENTER);
        BorderPane.setMargin(bp, new Insets(40));

        getRootNode().setCenter(bp);
    }

    /**
     * Show the stack pane sample.
     */
    public void showStackPane() {

        getSubTitle().setText("StackPane");

        final StackPane sp = new StackPane();
        sp.setFocusTraversable(true);
        sp.setMaxSize(800, 600);

        sp.getChildren().add(label("TOP_LEFT").style(BG_1).build());
        sp.getChildren().add(label("TOP_CENTER").style(BG_2).build());
        sp.getChildren().add(label("TOP_RIGHT").style(BG_3).build());
        sp.getChildren().add(label("CENTER_LEFT").style(BG_3).build());
        sp.getChildren().add(label("CENTER").style(BG_1).build());
        sp.getChildren().add(label("CENTER_RIGHT").style(BG_2).build());
        sp.getChildren().add(label("BOTTOM_LEFT").style(BG_2).build());
        sp.getChildren().add(label("BOTTOM_CENTER").style(BG_4).build());
        sp.getChildren().add(label("BOTTOM_RIGHT").style(BG_5).build());

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

        getRootNode().setCenter(sp);
    }

    /**
     * Build the H Box sample.
     */
    public void showHBox() {

        getSubTitle().setText("HBox");

        final HBox hb = new HBox();
        hb.setFocusTraversable(true);

        hb.setMaxSize(800, 400);

        hb.getChildren().add(stackPane(200, 200, Pos.CENTER, label("1").build(), BG_1).build());
        Node n = stackPane(400, 200, Pos.CENTER, label("2").build(), BG_2).build();
        HBox.setHgrow(n, Priority.ALWAYS);
        hb.getChildren().add(n);
        hb.getChildren().add(stackPane(150, 200, Pos.CENTER, label("3").build(), BG_3).build());
        hb.getChildren().add(stackPane(200, 200, Pos.CENTER, label("4").build(), BG_4).build());
        Node n2 = stackPane(300, 200, Pos.CENTER, label("5").build(), BG_5).build();
        HBox.setHgrow(n2, Priority.NEVER);
        hb.getChildren().add(n2);

        BorderPane.setAlignment(hb, Pos.CENTER);
        BorderPane.setMargin(hb, new Insets(40));

        getRootNode().setCenter(hb);
    }

    /**
     * Build the Vertical Box sample.
     */
    public void showVBox() {

        getSubTitle().setText("VBox");

        final VBox vb = new VBox();
        vb.setFocusTraversable(true);

        vb.getChildren().add(stackPane(200, 100, Pos.CENTER, label("1").build(), BG_1).build());
        vb.getChildren().add(stackPane(200, 100, Pos.CENTER, label("2").build(), BG_2).build());
        vb.getChildren().add(stackPane(200, 100, Pos.CENTER, label("3").build(), BG_3).build());
        vb.getChildren().add(stackPane(200, 100, Pos.CENTER, label("4").build(), BG_4).build());
        vb.getChildren().add(stackPane(200, 100, Pos.CENTER, label("5").build(), BG_5).build());

        BorderPane.setAlignment(vb, Pos.CENTER);
        BorderPane.setMargin(vb, new Insets(40));

        getRootNode().setCenter(vb);
    }

    /**
     * TODO To complete.
     */
    public void showFlowPane() {

        getSubTitle().setText("FlowPane");

        final FlowPane flow1 = new FlowPane(Orientation.VERTICAL);
        flow1.setMaxSize(400, 200);
        flow1.setColumnHalignment(HPos.RIGHT); // align labels on left
        flow1.setPrefWrapLength(400); // preferred height = 200
        for (int i = 0; i < 5; i++) {
            flow1.getChildren().add(stackPane(100, 50, Pos.CENTER, label("Pane " + i).build(), BG_2).build());
        }
        flow1.setStyle(BG_5);

        final FlowPane flow2 = new FlowPane(Orientation.HORIZONTAL);
        flow2.setMaxSize(200, 400);
        flow2.setRowValignment(VPos.BOTTOM); // align labels on left
        flow2.setPrefWrapLength(400); // preferred height = 200
        for (int i = 0; i < 5; i++) {
            flow2.getChildren().add(stackPane(100, 50, Pos.CENTER, label("Pane " + i).build(), BG_3).build());
        }
        flow2.setStyle(BG_4);

        Label label1 = LabelBuilder.create().text("Vertical [400x200]").build();
        VBox v1 = VBoxBuilder.create().children(label1, flow1).build();
        Label label2 = LabelBuilder.create().text("Horizontal [200x400]").build();
        VBox v2 = VBoxBuilder.create().children(label2, flow2).build();

        // StackPane.setAlignment(v1, Pos.CENTER_LEFT);
        // StackPane.setMargin(v1, new Insets(40));
        //
        // StackPane.setAlignment(v2, Pos.CENTER_RIGHT);
        // StackPane.setMargin(v2, new Insets(40));

        getRootNode().setCenter(TilePaneBuilder.create()
                .orientation(Orientation.HORIZONTAL)
                .alignment(Pos.CENTER)
                .prefWidth(600)
                .prefHeight(600)
                .children(v1, v2)
                .build());
    }

    /**
     * TODO To complete.
     */
    public void showGridPane() {

        getSubTitle().setText("GridPane");

        final GridPane gridpane = new GridPane();
        gridpane.setMaxSize(800, 600);

        gridpane.getColumnConstraints().addAll(
                ColumnConstraintsBuilder.create().percentWidth(50).build(),
                ColumnConstraintsBuilder.create().percentWidth(50).build()
                );

        gridpane.getRowConstraints().addAll(
                RowConstraintsBuilder.create().minHeight(150).build(),
                RowConstraintsBuilder.create().minHeight(100).build(),
                RowConstraintsBuilder.create().minHeight(200).build()
                );

        StackPane sp1 = stackPane(150, 200, Pos.CENTER, label("First").build(), BG_1).build();
        StackPane sp2 = stackPane(200, 200, Pos.CENTER, label("Second").build(), BG_2).build();
        StackPane sp3 = stackPane(150, 100, Pos.CENTER, label("Third").build(), BG_3).build();
        StackPane sp4 = stackPane(200, 100, Pos.CENTER, label("Fourth").build(), BG_4).build();
        StackPane sp5 = stackPane(150, 300, Pos.CENTER, label("Fifth").build(), BG_5).build();

        GridPane.setConstraints(sp1, 0, 0);
        GridPane.setConstraints(sp2, 1, 0);
        GridPane.setConstraints(sp3, 0, 1, 2, 1);
        GridPane.setConstraints(sp4, 0, 2);
        GridPane.setConstraints(sp5, 1, 2);

        gridpane.getChildren().addAll(sp1, sp2, sp3, sp4, sp5);

        gridpane.setStyle("-fx-background-color:#00CCFF");

        BorderPane.setAlignment(gridpane, Pos.CENTER);
        BorderPane.setMargin(gridpane, new Insets(40));

        getRootNode().setCenter(gridpane);
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
            tile.getChildren().add(stackPane(100, 100, Pos.CENTER, label("Pane" + i).build(), BG_1).build());
        }

        tile.setStyle(BG_2);
        // StackPane sp = StackPaneBuilder.create().maxWidth(600).style(BG_2).maxHeight(450).children(tile).build();

        // BorderPane.setAlignment(tile, Pos.CENTER);
        // BorderPane.setMargin(tile, new Insets(40));

        getRootNode().setCenter(tile);
        getRootNode().requestLayout();
    }

    /**
     * TODO To complete.
     */
    public void showAnchorPane() {

        getSubTitle().setText("AnchorPane");

        final AnchorPane anchorpane = new AnchorPane();

        Node n1 = stackPane(400, 500, Pos.CENTER, label("Anchor 1 [bottom:10, left:10]").build(), BG_1).build();
        AnchorPane.setBottomAnchor(n1, 10.0);
        AnchorPane.setLeftAnchor(n1, 10.0);

        Node n2 = stackPane(300, 200, Pos.CENTER, label("Anchor 2 [top:30, right:10]").build(), BG_2).build();
        AnchorPane.setTopAnchor(n2, 30.0);
        AnchorPane.setRightAnchor(n2, 10.0);

        Node n3 = stackPane(500, 200, Pos.CENTER, label("No Anchor").build(), BG_3).build();

        anchorpane.getChildren().addAll(n1, n2, n3);

        BorderPane.setAlignment(anchorpane, Pos.CENTER);
        BorderPane.setMargin(anchorpane, new Insets(40));
        getRootNode().setCenter(anchorpane);
    }

    /**
     * TODO To complete.
     */
    public void showAccordion() {

        getSubTitle().setText("Accordion");

        Accordion accordion = new Accordion();

        accordion.getPanes().add(new TitledPane("First Row", stackPane(700, 400, Pos.CENTER, label("First").build(), BG_1).build()));
        accordion.getPanes().add(new TitledPane("Second Row", stackPane(700, 400, Pos.CENTER, label("Second").build(), BG_2).build()));
        accordion.getPanes().add(new TitledPane("Third Row", stackPane(700, 400, Pos.CENTER, label("Third").build(), BG_3).build()));

        BorderPane.setAlignment(accordion, Pos.CENTER);
        BorderPane.setMargin(accordion, new Insets(40));

        getRootNode().setCenter(accordion);
    }

    /**
     * TODO To complete.
     */
    public void showScrollPane() {

        getSubTitle().setText("ScrollPane");

        final ScrollPane s1 = new ScrollPane();
        s1.setPrefSize(120, 120);
        s1.setContent(stackPane(1920, 1080, Pos.CENTER, label("A panel").build(), BG_3).build());

        BorderPane.setMargin(s1, new Insets(40));
        getRootNode().setCenter(s1);
    }

    /**
     * Show a split pane.
     */
    public void showSplitPane() {

        getSubTitle().setText("SplitPane");

        final SplitPane spH = SplitPaneBuilder.create().orientation(Orientation.VERTICAL).items(
                stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("Third").build(), BG_3).build(),
                stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("Fourth").build(), BG_4).build()
                ).build();

        final SplitPane sp = SplitPaneBuilder.create()
                .dividerPositions(new double[] { 0.3, 0.6, 0.9 })
                .items(
                        stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("First").build(), BG_1).build(),
                        spH,
                        stackPane(Double.MAX_VALUE, Double.MAX_VALUE, Pos.CENTER, label("Second").build(), BG_2).build()
                ).build();
        // sp.setDividerPositions(0.3f, 0.6f, 0.9f);

        BorderPane.setMargin(sp, new Insets(40));
        getRootNode().setCenter(sp);
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

        getRootNode().setCenter(tp);

    }

}
