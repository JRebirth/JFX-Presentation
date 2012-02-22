package org.jrebirth.presentation.ui.slides.layout;

import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>LayoutSlideStep</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public enum LayoutSlideStep implements SlideStep {

    /** The Text step. */
    Text,
    /** The Pane step. */
    Pane,
    /** The BorderPane step. */
    BorderPane,
    BorderConstraint,
    /** The HBox step. */
    HBox,
    /** The VBox step. */
    VBox,
    BoxConstraint,
    /** The StackPane step. */
    StackPane,
    StackConstraint,
    /** The FlowPane step. */
    FlowPane,
    /** The TilePane step. */
    TilePane,
    TileConstraint,
    /** The GridPane step. */
    GridPane,
    GridConstaint,
    /** The AnchorPane step. */
    AnchorPane,
    /** The Accordion step. */
    Accordion,
    /** The ScrollPane step. */
    ScrollPane,
    /** The SplitPane step. */
    SplitPane,
    /** The TabPane step. */
    TabPane;

}
