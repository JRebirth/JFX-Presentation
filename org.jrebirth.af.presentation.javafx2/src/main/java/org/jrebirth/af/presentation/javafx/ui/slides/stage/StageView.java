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
package org.jrebirth.af.presentation.javafx.ui.slides.stage;

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

import org.jrebirth.af.core.exception.CoreException;
import org.jrebirth.af.presentation.javafx.resources.JfxColors;
import org.jrebirth.af.presentation.javafx.resources.JfxFonts;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
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
     * @param x the x
     * @param y the y
     * @return the stage
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

}