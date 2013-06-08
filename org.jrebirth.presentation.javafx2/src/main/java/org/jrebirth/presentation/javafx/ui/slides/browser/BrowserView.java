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
package org.jrebirth.presentation.javafx.ui.slides.browser;

import javafx.scene.Node;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
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
    protected void initView() {
        super.initView();

        this.browser = new WebView();
    }

    /**
     * Gets the browser.
     * 
     * @return the web view
     */
    public WebView getBrowser() {
        return this.browser;
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

}
