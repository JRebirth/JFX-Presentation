package org.jrebirth.presentation.javafx.ui.slides.control;

import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>ControlSlideStep</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public enum ControlSlideStep implements SlideStep {

    Text,
    /** The Labeled step. */
    // Labeled,
    /** The TextInputControl step. */
    // TextInputControl,
    /** The ChoiceBox step. */
    ChoiceBox,
    /** The Slider step. */
    Slider,
    /** The HTMLEditor step. */
    HTMLEditor,
    /** The Separator step. */
    // Separator,
    /** The ProgressIndicator step. */
    ProgressIndicator,
    /** The MenuBar step. */
    MenuBar,
    /** The ToolBar step. */
    ToolBar,
    /** The ListView step. */
    ListView,
    /** The TableView step. */
    TableView,
    /** The TreeView step. */
    TreeView;

}
