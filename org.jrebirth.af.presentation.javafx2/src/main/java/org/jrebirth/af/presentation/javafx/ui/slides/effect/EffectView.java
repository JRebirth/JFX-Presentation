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
package org.jrebirth.af.presentation.javafx.ui.slides.effect;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.javafx.resources.JFXImages;
import org.jrebirth.af.presentation.javafx.resources.JfxColors;
import org.jrebirth.af.presentation.ui.template.AbstractTemplateView;

/**
 * The class <strong>PatternView</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class EffectView extends AbstractTemplateView<EffectModel, AnchorPane, EffectController> {

    /** The Constant DECIMAL. */
    private static final NumberFormat DECIMAL = new DecimalFormat("0.0");

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public EffectView(final EffectModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {

        return buildDefaultContent(model().getDefaultContent());
    }

    /**
     * TODO To complete.
     * 
     * @param image the image
     * @param sliders the sliders
     */
    private void showEffectSubSlide(final Node image, final FlowPane sliders) {

        final BorderPane bp = new BorderPane();
        bp.setCenter(image);
        bp.setRight(sliders);
        showCustomSlideStep(bp);
    }

    /**
     * TODO To complete.
     * 
     * @param image the image
     * @param fx the fx
     * @return the image view
     */
    private ImageView displayImage(final Image image, final Effect fx) {
        final ImageView iv = new ImageView(image);
        iv.setEffect(fx);

        return iv;
        // BorderPane.setMargin(iv, new Insets(10));

        // StackPane.setAlignment(iv, Pos.CENTER_LEFT);
        // showCustomSlideStep(iv);
    }

    /**
     * TODO To complete.
     * 
     * @param image the image
     * @param fx the fx
     * @return the stack pane
     */
    protected StackPane displayComparedImage(final Image image, final Effect fx) {

        final Image img = image;

        final ImageView iv1 = new ImageView(img);
        iv1.setClip(new Rectangle(img.getWidth() / 2, 0, img.getWidth() / 2, img.getHeight()));

        final ImageView iv2 = new ImageView(img);
        iv2.setClip(new Rectangle(0, 0, img.getWidth() / 2, img.getHeight()));
        iv2.setEffect(fx);


        // l.addEventHandler(arg0, arg1)Filter(MouseEvent.MOUSE_DRAGGED, new EventHandler() {
        //
        // });
        final StackPane sp = new StackPane();
        sp.setPrefWidth(img.getWidth());
        sp.setPrefHeight(img.getHeight());
        sp.getChildren().addAll(iv1, /* l, */iv2);

        // BorderPane.setMargin(sp, new Insets(10));
        // showCustomSlideStep(sp);

        return sp;
    }

    /**
     * TODO To complete.
     * 
     * @param node the node
     * @return the flow pane
     */
    private FlowPane displaySliders(final Node... node) {

        final FlowPane fp = new FlowPane(Orientation.VERTICAL);
        fp.setAlignment(Pos.CENTER);
        fp.getChildren().addAll(node);

        return fp;
        // node().setRight();
        // getSlideContent().getChildren().add(fp);

        // StackPane.setAlignment(fp, Pos.CENTER_RIGHT);

        // BorderPane.setMargin(node().getRight(), new Insets(10));
        // BorderPane.setAlignment(node().getRight(), Pos.CENTER);

        // node().getRight().setStyle("-fx-border-color:#000000;-fx-border-width:2px;");
    }

    /**
     * TODO To complete.
     * 
     * @param name the name
     * @param property the property
     * @param min the min
     * @param max the max
     * @return the h box
     */
    private HBox buildIntegerSlider(final String name, final IntegerProperty property, final int min, final int max) {

        final Slider slider = new Slider(min, max, property.intValue());
        slider.setMaxWidth(80);
        slider.setBlockIncrement(0.1);

        final Label valueLabel = new Label(name);

        property.bind(slider.valueProperty());

        slider.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                event.consume();
            }

        });
        slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(final ObservableValue<? extends Number> observable, final Number oldValue, final Number newValue) {
                valueLabel.setText(DECIMAL.format(newValue));
            }
        });

        final HBox hbox = new HBox();
        hbox.getChildren().addAll(new Label(name), slider, valueLabel);
        hbox.setMaxWidth(200);
        return hbox;
    }

    /**
     * TODO To complete.
     * 
     * @param name the name
     * @param property the property
     * @param min the min
     * @param max the max
     * @return the h box
     */
    private HBox buildSlider(final String name, final DoubleProperty property, final double min, final double max) {

        final Slider slider = new Slider(min, max, property.doubleValue());
        slider.setMaxWidth(80);
        slider.setBlockIncrement(0.1);

        slider.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                event.consume();
            }

        });

        final Label valueLabel = new Label(name);

        slider.adjustValue(property.doubleValue());
        property.bind(slider.valueProperty());

        slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(final ObservableValue<? extends Number> observable, final Number oldValue, final Number newValue) {
                valueLabel.setText(DECIMAL.format(newValue));
            }
        });

        final HBox hbox = new HBox();
        hbox.getChildren().addAll(new Label(name), slider, valueLabel);
        return hbox;
    }

    /**
     * TODO To complete.
     */
    public void showReflection() {
        getSubTitle().setText("Reflection");

        final Reflection fx = new Reflection();
        fx.setFraction(0.5);
        fx.setTopOffset(10);
        fx.setTopOpacity(0.5);
        fx.setBottomOpacity(0);

        showEffectSubSlide(displayImage(JFXImages.CUSTOM_CAR.get(), fx), displaySliders(buildSlider("Fraction", fx.fractionProperty(), 0, 1.0)));

        // BorderPane.setAlignment(node().getCenter(), Pos.TOP_CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showSepiaTone() {
        getSubTitle().setText("SepiaTone");

        final SepiaTone st = new SepiaTone();
        st.setLevel(1.0);

        showEffectSubSlide(displayComparedImage(JFXImages.CUSTOM_CAR.get(), st), displaySliders(buildSlider("Tone Level", st.levelProperty(), 0, 1.0)));

        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showBloom() {
        getSubTitle().setText("Bloom");

        final Bloom b = new Bloom();
        b.setThreshold(0.5);

        showEffectSubSlide(
                displayComparedImage(JFXImages.CUSTOM_CAR.get(), b),
                displaySliders(buildSlider("Threshold", b.thresholdProperty(), 0, 1.0)));

        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showDropShadow() {
        getSubTitle().setText("Drop Shadow");

        final DropShadow fx = new DropShadow();
        fx.setBlurType(BlurType.GAUSSIAN);
        fx.setColor(JfxColors.DROP_SHADOW.get());
        fx.setOffsetX(30);
        fx.setOffsetY(30);

        showEffectSubSlide(
                displayImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildSlider("Radius", fx.radiusProperty(), 0, 127.0),
                        buildSlider("Height", fx.heightProperty(), 0, 255.0),
                        buildSlider("Width", fx.widthProperty(), 0, 255.0),
                        buildSlider("Offset X", fx.offsetXProperty(), 0, 255.0),
                        buildSlider("Offset Y", fx.offsetYProperty(), 0, 255.0)));
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showInnerShadow() {
        getSubTitle().setText("Inner Shadow");

        final InnerShadow fx = new InnerShadow();
        fx.setBlurType(BlurType.GAUSSIAN);
        fx.setColor(JfxColors.INNER_SHADOW.get());

        showEffectSubSlide(
                displayImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildSlider("Choke", fx.chokeProperty(), 0, 1.0),
                        buildSlider("Radius", fx.radiusProperty(), 0, 127.0),
                        buildSlider("Height", fx.heightProperty(), 0, 255.0),
                        buildSlider("Width", fx.widthProperty(), 0, 255.0),
                        buildSlider("Offset X", fx.offsetXProperty(), 0, 255.0),
                        buildSlider("Offset Y", fx.offsetYProperty(), 0, 255.0)));
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showBoxBlur() {
        getSubTitle().setText("Box Blur");

        final BoxBlur fx = new BoxBlur();
        fx.setWidth(15);
        fx.setHeight(15);
        fx.setIterations(3);

        showEffectSubSlide(
                displayImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildIntegerSlider("Iteration", fx.iterationsProperty(), 0, 3),
                        buildSlider("Width", fx.widthProperty(), 0, 255),
                        buildSlider("Height", fx.heightProperty(), 0, 255)));

        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showMotionBlur() {
        getSubTitle().setText("Motion Blur");

        final MotionBlur fx = new MotionBlur();
        fx.setRadius(8.0);
        fx.setAngle(150);

        showEffectSubSlide(
                displayComparedImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildSlider("Radius", fx.radiusProperty(), 0, 63.0),
                        buildSlider("Angle", fx.angleProperty(), 0, 360)));
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showGaussianBlur() {
        getSubTitle().setText("Gaussian Blur");

        final GaussianBlur fx = new GaussianBlur();

        showEffectSubSlide(
                displayComparedImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(buildSlider("Radius", fx.radiusProperty(), 0, 63.0)));

        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showShadow() {
        getSubTitle().setText("Shadow");

        final Shadow fx = new Shadow();
        fx.setBlurType(BlurType.GAUSSIAN);
        fx.setColor(Color.WHITESMOKE);

        showEffectSubSlide(
                displayComparedImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildSlider("Width", fx.widthProperty(), 0, 255.0),
                        buildSlider("Height", fx.heightProperty(), 0, 255.0),
                        buildSlider("Radius", fx.radiusProperty(), 0, 127.0)));

        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showGlow() {
        getSubTitle().setText("Glow");

        final Glow fx = new Glow();
        fx.setLevel(0.7);

        showEffectSubSlide(
                displayComparedImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(buildSlider("Level", fx.levelProperty(), 0, 1.0)));

        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showLighting() {
        getSubTitle().setText("Lighting");

        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);

        final Lighting fx = new Lighting();
        fx.setLight(light);
        fx.setDiffuseConstant(10.0);
        fx.setSurfaceScale(20.0);

        showEffectSubSlide(
                displayImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildSlider("Diffuse Constant", fx.diffuseConstantProperty(), 0, 2.0),
                        buildSlider("Specular Constant", fx.specularConstantProperty(), 0, 2.0),
                        buildSlider("Specular Exponent", fx.specularExponentProperty(), 0, 10.0),
                        buildSlider("Light Azimuth", light.azimuthProperty(), 0, 100.0),
                        buildSlider("Light Elevation", light.elevationProperty(), 0, 100.0)));
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showPerspectiveTransform() {
        getSubTitle().setText("PerspectiveTransform");

        final PerspectiveTransform fx = new PerspectiveTransform();
        fx.setUlx(0.0);
        fx.setUly(0.0);
        fx.setUrx(600.0);
        fx.setUry(0.0);
        fx.setLrx(600.0);
        fx.setLry(400.0);
        fx.setLlx(0.0);
        fx.setLly(600.0);

        showEffectSubSlide(
                displayImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildSlider("ULX", fx.ulxProperty(), 0, 600.0),
                        buildSlider("ULY", fx.ulyProperty(), 0, 600.0),

                        buildSlider("URX", fx.urxProperty(), 0, 600.0),
                        buildSlider("URY", fx.uryProperty(), 0, 600.0),

                        buildSlider("LRX", fx.lrxProperty(), 0, 600.0),
                        buildSlider("LRY", fx.lryProperty(), 0, 600.0),

                        buildSlider("LLX", fx.llxProperty(), 0, 600.0),
                        buildSlider("LLY", fx.llyProperty(), 0, 600.0)));
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showBlend() {
        getSubTitle().setText("Blend");

        final ImageInput imgInput = new ImageInput(JFXImages.CUSTOM_CAR.get());

        final Blend fx = new Blend();
        fx.setOpacity(0.5);
        fx.setBottomInput(imgInput);
        fx.setMode(BlendMode.EXCLUSION);

        showEffectSubSlide(
                displayImage(JFXImages.ORANGE.get(), fx),
                displaySliders(buildSlider("Opacity", fx.opacityProperty(), 0, 1.0)));
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showColorAdjust() {
        getSubTitle().setText("ColorAdjust");

        final ColorAdjust fx = new ColorAdjust();
        fx.setHue(0.5);
        fx.setSaturation(0.4);
        fx.setBrightness(0.5);
        fx.setContrast(0.5);

        showEffectSubSlide(
                displayImage(JFXImages.CUSTOM_CAR.get(), fx),
                displaySliders(
                        buildSlider("Hue", fx.hueProperty(), -1.0, 1.0),
                        buildSlider("Saturation", fx.saturationProperty(), -1.0, 1.0),
                        buildSlider("Brightness", fx.brightnessProperty(), -1.0, 1.0),
                        buildSlider("Contrast", fx.contrastProperty(), -1.0, 1.0)

                ));
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showDisplacementMap() {

        getSubTitle().setText("DisplacementMap");

        final int w = 220;
        final int h = 100;
        final FloatMap map = new FloatMap();
        map.setWidth(w);
        map.setHeight(h);

        for (int i = 0; i < w; i++) {
            final double v = (Math.sin(i / 50.0 * Math.PI) - 0.5) / 40.0;
            for (int j = 0; j < h; j++) {
                map.setSamples(i, j, 0.0f, (float) v);
            }
        }

        final DisplacementMap dm = new DisplacementMap();
        dm.setMapData(map);

        showEffectSubSlide(
                displayImage(JFXImages.CUSTOM_CAR.get(), dm),
                displaySliders());
        // BorderPane.setAlignment(node().getCenter(), Pos.CENTER);

    }

}
