package org.jrebirth.presentation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.jrebirth.core.application.AbstractApplication;
import org.jrebirth.core.ui.Model;
import org.jrebirth.presentation.ui.stack.StackModel;

/**
 * The class <strong>JRebirthAnalyzer</strong>.
 * 
 * The application that demonstrate how to use JRebirth Framework. It also allow to show all JRebirth events.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 85 $ $Author: sbordes $
 * @since $Date: 2011-10-19 19:16:15 +0200 (Wed, 19 Oct 2011) $
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
    protected Class<? extends Model> getFirstModelClass() {
        return StackModel.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApplicationTitle() {
        return "JavaFX 2.0 - Presentation";
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
        scene.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

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

        // Preload font for CSS
        PrezFonts.SPLASH.get();

    }
}
