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
package org.jrebirth.presentation.javafx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.jrebirth.core.application.AbstractApplication;
import org.jrebirth.core.resource.font.FontEnum;
import org.jrebirth.core.ui.Model;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.presentation.ui.stack.StackModel;

/**
 * The class <strong>Presentation</strong>.
 * 
 * Application as support for live javafx presentation.
 * 
 * @author Sébastien Bordes
 * 
 */
public final class Presentation extends AbstractApplication<StackPane> {

    /**
     * Application launcher.
     * 
     * @param args the command line arguments
     */
    public static void main(final String... args) {
        Application.launch(Presentation.class, args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Model> getFirstModelClass() {
        return StackModel.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApplicationTitle() {
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
                        getScene().getRoot().setScaleX(getScene().getRoot().getScaleX() + 0.05);
                        getScene().getRoot().setScaleY(getScene().getRoot().getScaleY() + 0.05);
                        event.consume();
                    } else if (event.getCode() == KeyCode.SUBTRACT || event.getCode() == KeyCode.MINUS) {
                        getScene().getRoot().setScaleX(getScene().getRoot().getScaleX() - 0.05);
                        getScene().getRoot().setScaleY(getScene().getRoot().getScaleY() - 0.05);
                        event.consume();
                    } else if (event.getCode() == KeyCode.DIGIT0 || event.getCode() == KeyCode.NUMPAD0) {
                        getScene().getRoot().setScaleX(1.0);
                        getScene().getRoot().setScaleY(1.0);
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
    public List<FontEnum> getFontToPreload() {
        return Arrays.asList(new FontEnum[] {
                JfxFonts.SPLASH,
                JfxFonts.TYPEWRITER,
                JfxFonts.TYPEWRITER2
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Wave> getPreBootWaveList() {
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Wave> getPostBootWaveList() {
        return Collections.emptyList();
    }
}
