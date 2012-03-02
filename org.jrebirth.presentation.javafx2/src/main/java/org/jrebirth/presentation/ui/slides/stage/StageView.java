package org.jrebirth.presentation.ui.slides.stage;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import javafx.stage.StageStyle;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.PrezColors;
import org.jrebirth.presentation.PrezFonts;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>StageView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class StageView extends AbstractTemplateView<StageModel, BorderPane, StageController> {

    /** The stage shown for demo purpose. */
    private Stage stage;

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
    public void show() {
        // Nothing to do yet

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
    public void showStage(final StageStyle stageStyle, final String title) {

        getSubTitle().setText(title);

        if (this.stage != null) {
            this.stage.close();
        }

        final Label stageTitle = LabelBuilder.create()
                .text(title)
                .textFill(PrezColors.SLIDE_TITLE.get())
                .font(PrezFonts.SLIDE_TITLE.get())
                .build();

        final StackPane sp = StackPaneBuilder.create().children(stageTitle).build();

        final Scene scene = SceneBuilder.create()
                .root(sp)
                .fill(Color.TRANSPARENT)
                .build();

        this.stage = StageBuilder.create()
                .height(600)
                .width(800)
                .resizable(true)
                .focused(true)
                .title(title)
                .style(stageStyle)
                .scene(scene).build();

        this.stage.centerOnScreen();
        this.stage.show();
        this.stage.toFront();
    }

}
