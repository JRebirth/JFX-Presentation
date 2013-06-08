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
package org.jrebirth.presentation.javafx.ui.slides.effect;

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
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendBuilder;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BloomBuilder;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.BoxBlurBuilder;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorAdjustBuilder;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.effect.Effect;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.GaussianBlurBuilder;
import javafx.scene.effect.Glow;
import javafx.scene.effect.GlowBuilder;
import javafx.scene.effect.ImageInputBuilder;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.LightingBuilder;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.MotionBlurBuilder;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.PerspectiveTransformBuilder;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.effect.SepiaTone;
import javafx.scene.effect.SepiaToneBuilder;
import javafx.scene.effect.Shadow;
import javafx.scene.effect.ShadowBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.FlowPaneBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.javafx.JfxColors;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>PatternView</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class EffectView extends AbstractTemplateView<EffectModel, AnchorPane, EffectController> {

    /** The <code>CUSTOM_CAR</code> field is used to TODO. */
    private static final String CUSTOM_CAR = "images/bg/Custom_Car.jpg";

    /** The Constant ORANGE. */
    private static final String ORANGE = "images/bg/fabric_texture_car.jpg";

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

        return buildDefaultContent(getModel().getDefaultContent());
    }

    /**
     * TODO To complete.
     * 
     * @param image the image
     * @param sliders the sliders
     */
    private void showEffectSubSlide(final Node image, final FlowPane sliders) {

        showCustomSlideStep(BorderPaneBuilder.create()
                .center(image)
                .right(sliders).build());
    }

    /**
     * TODO To complete.
     * 
     * @param image the image
     * @param fx the fx
     * @return the image view
     */
    private ImageView displayImage(final String image, final Effect fx) {
        final ImageView iv = ImageViewBuilder.create()
                .effect(fx)
                .image(loadImage(image))
                .build();

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
    protected StackPane displayComparedImage(final String image, final Effect fx) {
        final Image img = loadImage(image);

        final ImageView iv1 = ImageViewBuilder.create()
                .image(img)
                .clip(new Rectangle(img.getWidth() / 2, 0, img.getWidth() / 2, img.getHeight()))
                .build();
        final ImageView iv2 = ImageViewBuilder.create()
                .image(img)
                .clip(new Rectangle(0, 0, img.getWidth() / 2, img.getHeight()))
                .effect(fx)
                .build();

        // Line l = LineBuilder.create()
        // .strokeWidth(4)
        // .startX(img.getWidth() / 2)
        // .startY(0)
        // .endX(img.getWidth() / 2)
        // .endY(img.getHeight())
        // .build();

        // l.addEventHandler(arg0, arg1)Filter(MouseEvent.MOUSE_DRAGGED, new EventHandler() {
        //
        // });
        final StackPane sp = StackPaneBuilder.create()
                .prefWidth(img.getWidth())
                .prefHeight(img.getHeight())
                .children(iv1, /* l, */iv2)
                .build();

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

        final FlowPane fp = FlowPaneBuilder.create()
                .orientation(Orientation.VERTICAL)
                .alignment(Pos.CENTER)
                .children(node)
                .build();

        return fp;
        // getRootNode().setRight();
        // getSlideContent().getChildren().add(fp);

        // StackPane.setAlignment(fp, Pos.CENTER_RIGHT);

        // BorderPane.setMargin(getRootNode().getRight(), new Insets(10));
        // BorderPane.setAlignment(getRootNode().getRight(), Pos.CENTER);

        // getRootNode().getRight().setStyle("-fx-border-color:#000000;-fx-border-width:2px;");
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

        final Slider slider = SliderBuilder.create()
                .min(min)
                .max(max)
                .maxWidth(80)
                .value(property.intValue())
                .blockIncrement(0.1)
                .build();

        final Label valueLabel = LabelBuilder.create().text(name).build();

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

        return HBoxBuilder.create()
                .children(
                        LabelBuilder.create().text(name).build(),
                        slider,
                        valueLabel
                ).maxWidth(200)
                .build();
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

        final Slider slider = SliderBuilder.create()
                .min(min)
                .max(max)
                .maxWidth(80)
                .value(property.doubleValue())
                .blockIncrement(0.1)
                .build();

        slider.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                event.consume();
            }

        });

        final Label valueLabel = LabelBuilder.create().text(name).build();

        slider.adjustValue(property.doubleValue());
        property.bind(slider.valueProperty());

        slider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(final ObservableValue<? extends Number> observable, final Number oldValue, final Number newValue) {
                valueLabel.setText(DECIMAL.format(newValue));
            }
        });

        return HBoxBuilder.create()
                .children(
                        LabelBuilder.create().text(name).build(),
                        slider,
                        valueLabel
                )
                .build();
    }

    /**
     * TODO To complete.
     */
    public void showReflection() {
        getSubTitle().setText("Reflection");

        final Reflection fx = ReflectionBuilder.create()
                .fraction(0.5)
                .topOffset(10)
                .topOpacity(0.5)
                .bottomOpacity(0)
                .build();

        showEffectSubSlide(displayImage(CUSTOM_CAR, fx), displaySliders(buildSlider("Fraction", fx.fractionProperty(), 0, 1.0)));

        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.TOP_CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showSepiaTone() {
        getSubTitle().setText("SepiaTone");

        final SepiaTone st = SepiaToneBuilder.create().level(1.0).build();

        showEffectSubSlide(displayComparedImage(CUSTOM_CAR, st), displaySliders(buildSlider("Tone Level", st.levelProperty(), 0, 1.0)));

        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showBloom() {
        getSubTitle().setText("Bloom");

        final Bloom b = BloomBuilder.create().threshold(0.5).build();

        showEffectSubSlide(
                displayComparedImage(CUSTOM_CAR, b),
                displaySliders(buildSlider("Threshold", b.thresholdProperty(), 0, 1.0)));

        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showDropShadow() {
        getSubTitle().setText("Drop Shadow");

        final DropShadow fx = DropShadowBuilder.create()
                .blurType(BlurType.GAUSSIAN)
                .color(JfxColors.DROP_SHADOW.get())
                .offsetX(30)
                .offsetY(30)
                .build();

        showEffectSubSlide(
                displayImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildSlider("Radius", fx.radiusProperty(), 0, 127.0),
                        buildSlider("Height", fx.heightProperty(), 0, 255.0),
                        buildSlider("Width", fx.widthProperty(), 0, 255.0),
                        buildSlider("Offset X", fx.offsetXProperty(), 0, 255.0),
                        buildSlider("Offset Y", fx.offsetYProperty(), 0, 255.0)));
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showInnerShadow() {
        getSubTitle().setText("Inner Shadow");

        final InnerShadow fx = InnerShadowBuilder.create()
                .blurType(BlurType.GAUSSIAN)
                .color(JfxColors.INNER_SHADOW.get())
                .build();

        showEffectSubSlide(
                displayImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildSlider("Choke", fx.chokeProperty(), 0, 1.0),
                        buildSlider("Radius", fx.radiusProperty(), 0, 127.0),
                        buildSlider("Height", fx.heightProperty(), 0, 255.0),
                        buildSlider("Width", fx.widthProperty(), 0, 255.0),
                        buildSlider("Offset X", fx.offsetXProperty(), 0, 255.0),
                        buildSlider("Offset Y", fx.offsetYProperty(), 0, 255.0)));
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showBoxBlur() {
        getSubTitle().setText("Box Blur");

        final BoxBlur fx = BoxBlurBuilder.create()
                .width(15)
                .height(15)
                .iterations(3)
                .build();

        showEffectSubSlide(
                displayImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildIntegerSlider("Iteration", fx.iterationsProperty(), 0, 3),
                        buildSlider("Width", fx.widthProperty(), 0, 255),
                        buildSlider("Height", fx.heightProperty(), 0, 255)));

        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showMotionBlur() {
        getSubTitle().setText("Motion Blur");

        final MotionBlur fx = MotionBlurBuilder.create()
                .radius(8.0)
                .angle(150)
                .build();

        showEffectSubSlide(
                displayComparedImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildSlider("Radius", fx.radiusProperty(), 0, 63.0),
                        buildSlider("Angle", fx.angleProperty(), 0, 360)));
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showGaussianBlur() {
        getSubTitle().setText("Gaussian Blur");

        final GaussianBlur fx = GaussianBlurBuilder.create()
                .build();

        showEffectSubSlide(
                displayComparedImage(CUSTOM_CAR, fx),
                displaySliders(buildSlider("Radius", fx.radiusProperty(), 0, 63.0)));

        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showShadow() {
        getSubTitle().setText("Shadow");

        final Shadow fx = ShadowBuilder.create()
                .blurType(BlurType.GAUSSIAN)
                .color(Color.WHITESMOKE)
                .build();

        showEffectSubSlide(
                displayComparedImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildSlider("Width", fx.widthProperty(), 0, 255.0),
                        buildSlider("Height", fx.heightProperty(), 0, 255.0),
                        buildSlider("Radius", fx.radiusProperty(), 0, 127.0)));

        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showGlow() {
        getSubTitle().setText("Glow");

        final Glow fx = GlowBuilder.create()
                .level(0.7)
                .build();

        showEffectSubSlide(
                displayComparedImage(CUSTOM_CAR, fx),
                displaySliders(buildSlider("Level", fx.levelProperty(), 0, 1.0)));

        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showLighting() {
        getSubTitle().setText("Lighting");

        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);

        final Lighting fx = LightingBuilder.create()
                .light(light)
                .diffuseConstant(10.0)
                .surfaceScale(20.0)
                .build();

        showEffectSubSlide(
                displayImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildSlider("Diffuse Constant", fx.diffuseConstantProperty(), 0, 2.0),
                        buildSlider("Specular Constant", fx.specularConstantProperty(), 0, 2.0),
                        buildSlider("Specular Exponent", fx.specularExponentProperty(), 0, 10.0),
                        buildSlider("Light Azimuth", light.azimuthProperty(), 0, 100.0),
                        buildSlider("Light Elevation", light.elevationProperty(), 0, 100.0)));
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showPerspectiveTransform() {
        getSubTitle().setText("PerspectiveTransform");

        final PerspectiveTransform fx = PerspectiveTransformBuilder.create()
                .ulx(0.0)
                .uly(0.0)
                .urx(600.0)
                .ury(0.0)
                .lrx(600.0)
                .lry(400.0)
                .llx(0.0)
                .lly(600.0)
                .build();

        showEffectSubSlide(
                displayImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildSlider("ULX", fx.ulxProperty(), 0, 600.0),
                        buildSlider("ULY", fx.ulyProperty(), 0, 600.0),

                        buildSlider("URX", fx.urxProperty(), 0, 600.0),
                        buildSlider("URY", fx.uryProperty(), 0, 600.0),

                        buildSlider("LRX", fx.lrxProperty(), 0, 600.0),
                        buildSlider("LRY", fx.lryProperty(), 0, 600.0),

                        buildSlider("LLX", fx.llxProperty(), 0, 600.0),
                        buildSlider("LLY", fx.llyProperty(), 0, 600.0)));
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);

    }

    /**
     * TODO To complete.
     */
    public void showBlend() {
        getSubTitle().setText("Blend");

        final Blend fx = BlendBuilder.create()
                .opacity(0.5)
                .bottomInput(ImageInputBuilder.create().source(loadImage(CUSTOM_CAR)).build())
                .mode(BlendMode.EXCLUSION)
                .build();

        showEffectSubSlide(
                displayImage(ORANGE, fx),
                displaySliders(buildSlider("Opacity", fx.opacityProperty(), 0, 1.0)));
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);
    }

    /**
     * TODO To complete.
     */
    public void showColorAdjust() {
        getSubTitle().setText("ColorAdjust");

        final ColorAdjust fx = ColorAdjustBuilder.create()
                .hue(0.5)
                .saturation(0.4)
                .brightness(0.5)
                .contrast(0.5)
                .build();

        showEffectSubSlide(
                displayImage(CUSTOM_CAR, fx),
                displaySliders(
                        buildSlider("Hue", fx.hueProperty(), -1.0, 1.0),
                        buildSlider("Saturation", fx.saturationProperty(), -1.0, 1.0),
                        buildSlider("Brightness", fx.brightnessProperty(), -1.0, 1.0),
                        buildSlider("Contrast", fx.contrastProperty(), -1.0, 1.0)

                ));
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);

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
                displayImage(CUSTOM_CAR, dm),
                displaySliders());
        // BorderPane.setAlignment(getRootNode().getCenter(), Pos.CENTER);

    }

}
