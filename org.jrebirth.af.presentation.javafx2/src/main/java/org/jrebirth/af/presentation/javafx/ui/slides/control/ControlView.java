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
package org.jrebirth.af.presentation.javafx.ui.slides.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuBarBuilder;
import javafx.scene.control.MenuBuilder;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.ProgressBarBuilder;
import javafx.scene.control.ProgressIndicatorBuilder;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorBuilder;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.ToolBarBuilder;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.web.HTMLEditor;
import javafx.util.Pair;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>ControlView</strong>.
 * 
 * The custom controls demo slide.
 * 
 * @author Sébastien Bordes
 */
public final class ControlView extends AbstractTemplateView<ControlModel, AnchorPane, ControlController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public ControlView(final ControlModel model) throws CoreException {
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
     * Show the border pane sample.
     */
    public void showChoiceBox() {

        getSubTitle().setText("ChoiceBox");

        final ChoiceBox<String> cb = new ChoiceBox<>();
        cb.getItems().addAll("Dog", "Cat", "Horse");
        cb.getSelectionModel().selectFirst();

        cb.setScaleX(4.0);
        cb.setScaleY(4.0);

        // node().setCenter(cb);
        showCustomSlideStep(cb);

        BorderPane.setAlignment(cb, Pos.CENTER);
        BorderPane.setMargin(cb, new Insets(40));
    }

    /**
     * Build the H Box sample.
     */
    public void showHtmlEditor() {

        getSubTitle().setText("HtmlEditor");

        final HTMLEditor editor = new HTMLEditor();

        // node().setCenter(editor);
        showCustomSlideStep(editor);
    }

    /**
     * Show the Labeled sample.
     */
    public void showLabeled() {

        getSubTitle().setText("Labeled");

        final Label l = new Label("Label");
        l.setScaleX(4.0);
        l.setScaleY(4.0);

        // node().setCenter(l);
        showCustomSlideStep(l);

        l.autosize();

        BorderPane.setAlignment(l, Pos.CENTER);
        BorderPane.setMargin(l, new Insets(40));
    }

    /**
     * TODO To complete.
     */
    public void showSlider() {

        getSubTitle().setText("Slider");

        final Slider s = new Slider(0, 100, 30);
        s.setScaleX(1.0);
        s.setScaleY(1.0);

        // node().setCenter(s);
        showCustomSlideStep(s);
        s.autosize();

        BorderPane.setAlignment(s, Pos.CENTER);
        BorderPane.setMargin(s, new Insets(40));
    }

    /**
     * TODO To complete.
     */
    public void showTextInputControl() {
        getSubTitle().setText("TextInputControl");

        final TextField s = new TextField("TextField");
        s.setScaleX(4.0);
        s.setScaleY(4.0);

        // node().setCenter(s);
        showCustomSlideStep(s);

        BorderPane.setAlignment(s, Pos.CENTER);
        BorderPane.setMargin(s, new Insets(40));
    }

    /**
     * Show ProgressIndicator sample.
     */
    public void showProgressIndicator() {

        getSubTitle().setText("Progress");

        final VBox vb = VBoxBuilder.create().spacing(20).alignment(Pos.CENTER).build();

        vb.getChildren().addAll(
                ProgressBarBuilder.create().build(),
                ProgressBarBuilder.create().prefWidth(300).prefHeight(30).build(),
                ProgressBarBuilder.create().prefWidth(400).prefHeight(40).build(),
                ProgressBarBuilder.create().progress(0.25).prefHeight(30).build(),
                ProgressBarBuilder.create().progress(0.50).prefHeight(30).build(),
                ProgressBarBuilder.create().progress(0.50).disable(true).prefHeight(30).build(),
                ProgressBarBuilder.create().progress(1).prefHeight(30).build(),

                ProgressIndicatorBuilder.create().prefWidth(50).prefHeight(50).build(),
                ProgressIndicatorBuilder.create().prefWidth(50).prefHeight(50).progress(0.25).build(),
                ProgressIndicatorBuilder.create().prefWidth(50).prefHeight(50).progress(0.60).build(),
                ProgressIndicatorBuilder.create().prefWidth(50).prefHeight(50).progress(1).build()
                );

        // node().setCenter(vb);
        showCustomSlideStep(vb);

        BorderPane.setAlignment(vb, Pos.CENTER);
        BorderPane.setMargin(vb, new Insets(40));
    }

    /**
     * TODO To complete.
     */
    public void showSeparator() {

        getSubTitle().setText("Separator");

        final Separator s = SeparatorBuilder.create().minHeight(20).maxWidth(700).halignment(HPos.CENTER).build();

        // node().setCenter(s);
        showCustomSlideStep(s);

        BorderPane.setAlignment(s, Pos.CENTER);
        BorderPane.setMargin(s, new Insets(40));
    }

    /**
     * Show MenuBar sample.
     */
    public void showMenuBar() {

        getSubTitle().setText("MenuBar");

        final MenuBar menubar = MenuBarBuilder.create()
                .menus(
                        MenuBuilder.create().graphic(LabelBuilder.create().text("Menu 1").build())
                                .items(
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 1.1").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 1.2").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 1.3").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 1.4").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 1.5").build()).build()
                                ).build(),
                        MenuBuilder.create().graphic(LabelBuilder.create().text("Menu 2").build())
                                .items(
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 2.1").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 2.2").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 2.3").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 2.4").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 2.5").build()).build()
                                ).build(),
                        MenuBuilder.create().graphic(LabelBuilder.create().text("Menu 3").build())
                                .items(
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 3.1").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 3.2").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 3.3").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 3.4").build()).build(),
                                        MenuItemBuilder.create().graphic(LabelBuilder.create().text("Menu 3.5").build()).build()
                                ).build()
                ).build();

        // node().setCenter(menubar);
        showCustomSlideStep(menubar);

        BorderPane.setAlignment(menubar, Pos.TOP_CENTER);
        BorderPane.setMargin(menubar, new Insets(100));
    }

    /**
     * TODO To complete.
     */
    public void showToolBar() {
        getSubTitle().setText("ToolBar");

        final ToolBar toolbar = ToolBarBuilder.create()
                .items(
                        new Button("Lorem"),
                        new Button("Ipsum"),
                        new Button("Dolor"),
                        new Button("Sit"),
                        new Button("Amet")
                )
                .build();

        // node().setCenter(toolbar);
        showCustomSlideStep(toolbar);

        BorderPane.setAlignment(toolbar, Pos.TOP_CENTER);
        BorderPane.setMargin(toolbar, new Insets(100));
    }

    /**
     * Show the stack pane sample.
     */
    public void showListView() {

        getSubTitle().setText("ListView");

        final ObservableList<String> list = populateList();

        final ListView<String> horizontalListView = new ListView<String>();
        horizontalListView.setOrientation(Orientation.HORIZONTAL);
        horizontalListView.setItems(list);
        horizontalListView.setPrefWidth(400);

        final ListView<String> verticalListView = new ListView<String>();
        verticalListView.setItems(list);
        verticalListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        verticalListView.setPrefWidth(400);

        final FlowPane fp = FlowPaneBuilder.create()
                .children(horizontalListView, verticalListView)
                .hgap(30)
                .build();

        // node().setCenter(fp);
        showCustomSlideStep(fp);

        BorderPane.setAlignment(fp, Pos.CENTER);
        BorderPane.setMargin(fp, new Insets(40));
    }

    /**
     * TODO To complete.
     * 
     * @return the observable list
     */
    private ObservableList<String> populateList() {
        final ObservableList<String> list = FXCollections.observableArrayList();

        final BufferedReader in = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("org/jrebirth/presentation/javafx/ui/slides/control/sdkTree.txt")));
        String line;
        try {
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Show a tab pane.
     */
    public void showTableView() {

        getSubTitle().setText("TableView");

        final TableColumn pathColumn = new TableColumn();
        pathColumn.setPrefWidth(700);
        pathColumn.setText("Path");
        pathColumn.setCellValueFactory(new PropertyValueFactory("key"));
        final TableColumn extColumn = new TableColumn();
        extColumn.setPrefWidth(200);
        extColumn.setText("Extension");
        extColumn.setCellValueFactory(new PropertyValueFactory("value"));

        final TableView<Pair<String, String>> tableView = new TableView<>();
        tableView.setItems(populateTable());
        tableView.getColumns().addAll(pathColumn, extColumn);

        // node().setCenter(tableView);
        showCustomSlideStep(tableView);

        BorderPane.setAlignment(tableView, Pos.CENTER);
        BorderPane.setMargin(tableView, new Insets(40));
    }

    /**
     * TODO To complete.
     * 
     * @return the observable list
     */
    private ObservableList<Pair<String, String>> populateTable() {
        final ObservableList<Pair<String, String>> list = FXCollections.observableArrayList();

        final BufferedReader in = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("org/jrebirth/presentation/javafx/ui/slides/control/sdkTree.txt")));
        String line;
        try {
            while ((line = in.readLine()) != null) {
                if (line.contains(".")) {
                    list.add(new Pair(line.substring(0, line.lastIndexOf(".")), line.substring(line.lastIndexOf(".") + 1, line.length())));
                } else {
                    list.add(new Pair(line, ""));
                }

            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * TODO To complete.
     */
    public void showTreeView() {
        getSubTitle().setText("TreeView");

        final TreeItem<String> treeRoot = new TreeItem<String>("JavaFX 2.0 SDK");

        try {
            populateTree(treeRoot);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final TreeView<String> treeView = new TreeView<>();
        treeView.setShowRoot(true);
        treeRoot.setExpanded(true);
        treeView.setRoot(treeRoot);

        // node().setCenter(treeView);
        showCustomSlideStep(treeView);

        BorderPane.setAlignment(treeView, Pos.CENTER);
        BorderPane.setMargin(treeView, new Insets(40));
    }

    /**
     * Populate the tree with content of JavaFX SDK folder.
     * 
     * @param treeRoot the root to populate
     * @throws IOException id an error occured while opening the sample file
     */
    private void populateTree(final TreeItem<String> treeRoot) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("org/jrebirth/presentation/javafx/ui/slides/control/sdkTree.txt")));

        final Map<String, TreeItem<String>> map = new HashMap<>();
        String line;
        while ((line = in.readLine()) != null) {

            final String[] path = line.split("/");

            final TreeItem<String> ti = new TreeItem<>(path[path.length - 1]);
            map.put(line, ti);

            if (path.length == 1) {
                treeRoot.getChildren().add(ti);
            } else {
                map.get(line.substring(0, line.lastIndexOf("/"))).getChildren().add(ti);
            }

        }
    }

}