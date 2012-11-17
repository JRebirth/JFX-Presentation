package org.jrebirth.presentation.javafx.ui.slides.future;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.PaneBuilder;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>IntroView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class FutureView extends AbstractTemplateView<FutureModel, AnchorPane, FutureController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public FutureView(final FutureModel model) throws CoreException {
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
     * Show the pane sample.
     */
    public void showTimeline() {

        // this.layoutName.setText("Pane");

        final Image app = loadImage("images/future/timeline.gif");
        final ImageView appImageView = new ImageView(app);

        showCustomSlideStep(appImageView);
    }

}
