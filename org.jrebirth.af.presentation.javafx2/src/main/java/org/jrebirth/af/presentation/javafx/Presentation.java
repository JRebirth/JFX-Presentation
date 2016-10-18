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
package org.jrebirth.af.presentation.javafx;

import java.util.Arrays;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.jrebirth.af.api.resource.ResourceItem;
import org.jrebirth.af.api.resource.font.FontItem;
import org.jrebirth.af.api.ui.Model;
import org.jrebirth.af.core.application.DefaultApplication;
import org.jrebirth.af.presentation.javafx.resources.JfxFonts;
import org.jrebirth.af.presentation.ui.stack.SlideStackModel;

/**
 * The class <strong>Presentation</strong>.
 * 
 * Application as support for live javafx presentation.
 * 
 * @author Sébastien Bordes
 * 
 */
public final class Presentation extends DefaultApplication<StackPane> {

    /**
     * Application launcher.
     * 
     * @param args the command line arguments
     */
    public static void main(final String... args) {

        preloadAndLaunch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Model> firstModelClass() {
        return SlideStackModel.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String applicationTitle() {
        return "JavaFX 2.1 - Presentation";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeStage(final Stage stage) {
        stage.setFullScreen(false);
        stage.setWidth(1040);
        stage.setHeight(800);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeScene(final Scene scene) {

        scene.getStylesheets().add("style/template.css");
        scene.getStylesheets().add("style/candle.css");

        // Manage F11 button to switch full screen
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(final KeyEvent event) {
                if (event.isControlDown()) {
                    if (event.getCode() == KeyCode.ADD || event.getCode() == KeyCode.PLUS) {
                        scene().getRoot().setScaleX(scene().getRoot().getScaleX() + 0.05);
                        scene().getRoot().setScaleY(scene().getRoot().getScaleY() + 0.05);
                        event.consume();
                    } else if (event.getCode() == KeyCode.SUBTRACT || event.getCode() == KeyCode.MINUS) {
                        scene().getRoot().setScaleX(scene().getRoot().getScaleX() - 0.05);
                        scene().getRoot().setScaleY(scene().getRoot().getScaleY() - 0.05);
                        event.consume();
                    } else if (event.getCode() == KeyCode.DIGIT0 || event.getCode() == KeyCode.NUMPAD0) {
                        scene().getRoot().setScaleX(1.0);
                        scene().getRoot().setScaleY(1.0);
                        event.consume();
                    }
                }
            }
        });

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<? extends ResourceItem<?, ?, ?>> getResourceToPreload() {
        return Arrays.asList(new FontItem[] {
                JfxFonts.SPLASH,
                JfxFonts.TYPEWRITER,
                JfxFonts.TYPEWRITER2
        });
    }

}
