package org.jrebirth.presentation.javafx.ui.slides.stage;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import javafx.stage.StageStyle;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.javafx.JfxColors;
import org.jrebirth.presentation.javafx.JfxFonts;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>StageView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class StageView extends AbstractTemplateView<StageModel, AnchorPane, StageController> {

    /** The stage shown for demo purpose. */
    private final List<Stage> stageList = new ArrayList<>();

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public StageView(final StageModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return PaneBuilder.create().build();
    }

    /**
     * Show a stage type.
     * 
     * @param stageStyle the style of the stage
     * @param title the title to display.
     */
    public Stage showStage(final StageStyle stageStyle, final String title, final double x, final double y) {

        // getSubTitle().setText(title);
        //
        // if (this.stage != null) {
        // this.stage.close();
        // }

        Stage stage;

        final Label stageTitle = LabelBuilder.create()
                .text(title)
                .textFill(JfxColors.SLIDE_TITLE.get())
                .font(JfxFonts.SLIDE_TITLE.get())
                .build();

        final StackPane sp = StackPaneBuilder.create().children(stageTitle).build();

        final Scene scene = SceneBuilder.create()
                .root(sp)
                .fill(Color.TRANSPARENT)
                .build();

        stage = StageBuilder.create()
                .height(300)
                .width(400)
                .x(x)
                .y(y)
                .resizable(true)
                .focused(true)
                .title(title)
                .style(stageStyle)
                .scene(scene).build();

        // this.stage.centerOnScreen();
        stage.show();
        stage.toFront();

        return stage;
    }

    /**
     * TODO To complete.
     */
    public void showStages() {
        this.stageList.add(showStage(StageStyle.DECORATED, "StageStyle.DECORATED", 74, 56));
        this.stageList.add(showStage(StageStyle.TRANSPARENT, "StageStyle.TRANSPARENT", 74, 56 * 2 + 300));
        this.stageList.add(showStage(StageStyle.UNDECORATED, "StageStyle.UNDECORATED", 74 * 2 + 400, 56));
        this.stageList.add(showStage(StageStyle.UTILITY, "StageStyle.UTILITY", 74 * 2 + 400, 56 * 2 + 300));
    }

    /**
     * TODO To complete.
     */
    public void releaseStages() {
        for (final Stage stage : this.stageList) {
            stage.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doHide() {
        // Nothing to do yet
    }

}