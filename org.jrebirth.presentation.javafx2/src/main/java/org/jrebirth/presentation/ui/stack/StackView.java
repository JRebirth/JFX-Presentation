package org.jrebirth.presentation.ui.stack;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.impl.AbstractView;

/**
 * 
 * The class <strong>SlidesView</strong>.
 * 
 * The main view of the JavaFX 2.0 Presentation.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class StackView extends AbstractView<StackModel, StackPane, StackController> {

    /**
     * Default Constructor.
     * 
     * @param model the view model
     * 
     * @throws CoreException if build fails
     */
    public StackView(final StackModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {

        getRootNode().setId("SlideStack");

        getRootNode().setPrefSize(1024, 768);
        getRootNode().setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        getRootNode().setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        getRootNode().setAlignment(Pos.CENTER);
        getRootNode().setPadding(new Insets(5, 5, 5, 5));

        // Blend blend = new Blend();
        // blend.setMode(BlendMode.HARD_LIGHT);
        //
        // ColorInput colorInput = new ColorInput();
        // colorInput.setPaint(PrezColors.BACKGROUND_INPUT.get());
        // colorInput.setX(0);
        // colorInput.setY(0);
        // colorInput.setWidth(1024);
        // colorInput.setHeight(768);
        // blend.setTopInput(colorInput);
        //
        // getRootNode().setEffect(blend);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void animate() {
        // Nothing to do yet
    }
}
