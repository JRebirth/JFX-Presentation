package org.jrebirth.presentation.javafx.ui.slides.browser;

import javafx.scene.Node;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

/**
 * 
 * The class <strong>BrowserView</strong>.
 * 
 * The custom slide to introduce javafx 2.0 web browsinf capabilities.
 * 
 * @author Sébastien Bordes
 */
public final class BrowserView extends AbstractTemplateView<BrowserModel, AnchorPane, BrowserController> {

    /** The browser node. */
    private WebView browser;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public BrowserView(final BrowserModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeComponents() {
        super.customInitializeComponents();

        this.browser = new WebView();
    }

    /**
     * @return the web view
     */
    public WebView getBrowser() {
        return this.browser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart() {
        super.doStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return new Pane();
    }

    /**
     * Show the browser.
     */
    public void showBrowser() {

        final VBox vb = buildDefaultContent(getModel().getContent(BrowserSlideStep.Browser));

        // load the web page
        this.browser.getEngine().load(Thread.currentThread().getContextClassLoader().getResource("balls/balls.htm").toString());

        vb.getChildren().add(this.browser);
        showCustomSlideStep(vb);
    }

    /**
     * Show a gradient effect.
     */
    public void showGradient() {
        final VBox vb = buildDefaultContent(getModel().getContent(BrowserSlideStep.Gradient));

        // load the gradient page
        this.browser.getEngine().load(Thread.currentThread().getContextClassLoader().getResource("balls/canvas-grad.htm").toString());

        vb.getChildren().add(this.browser);
        showCustomSlideStep(vb);
    }

    /**
     * Transform the browser with perspective effect.
     */
    public void showPerspective() {
        this.browser.setTranslateY(-80);
        this.browser.setScaleX(0.6);
        this.browser.setScaleY(0.6);
        this.browser.setEffect(ReflectionBuilder.create().build());
        this.browser.getEngine().reload();
        this.browser.setCache(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doHide() {
        // Nothing to do yet
    }

}
