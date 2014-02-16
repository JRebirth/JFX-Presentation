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
package org.jrebirth.af.presentation.javafx.ui.slides.lang;

import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

// TODO: Auto-generated Javadoc
/**
 * Candle node used for drawing a candle.
 */
public class Candle extends Group {

    /** The high low line. */
    private final Line highLowLine = new Line();

    /** The bar. */
    private final Region bar = new Region();

    /** The series style class. */
    private String seriesStyleClass;

    /** The data style class. */
    private String dataStyleClass;

    /** The open above close. */
    private boolean openAboveClose = true;

    /** The label. */
    private final Text label = new Text();

    /** The tooltip. */
    private final Tooltip tooltip = new Tooltip();

    /**
     * Instantiates a new candle.
     * 
     * @param seriesStyleClass the series style class
     * @param dataStyleClass the data style class
     */
    public Candle(final String seriesStyleClass, final String dataStyleClass) {
        setAutoSizeChildren(false);
        this.label.setRotate(-90);
        getChildren().addAll(this.highLowLine, this.bar, this.label);
        this.seriesStyleClass = seriesStyleClass;
        this.dataStyleClass = dataStyleClass;
        updateStyleClasses();
        this.tooltip.setGraphic(new TooltipContent());
        Tooltip.install(this.bar, this.tooltip);
    }

    /**
     * TODO To complete.
     * 
     * @param candleName the new label
     */
    public void setLabel(final String candleName) {
        this.label.setText(candleName);
    }

    /**
     * Sets the series and data style classes.
     * 
     * @param seriesStyleClass the series style class
     * @param dataStyleClass the data style class
     */
    public void setSeriesAndDataStyleClasses(final String seriesStyleClass, final String dataStyleClass) {
        this.seriesStyleClass = seriesStyleClass;
        this.dataStyleClass = dataStyleClass;
        updateStyleClasses();
    }

    /**
     * Update.
     * 
     * @param closeOffset the close offset
     * @param highOffset the high offset
     * @param lowOffset the low offset
     * @param candleWidth the candle width
     */
    public void update(final double closeOffset, final double highOffset, final double lowOffset, double candleWidth) {
        this.openAboveClose = closeOffset > 0;
        updateStyleClasses();
        this.highLowLine.setStartY(highOffset);
        this.highLowLine.setEndY(lowOffset);
        if (candleWidth == -1) {
            candleWidth = this.bar.prefWidth(-1);
        }
        if (this.openAboveClose) {
            this.bar.resizeRelocate(-candleWidth / 2, 0, candleWidth, closeOffset);
        } else {
            this.bar.resizeRelocate(-candleWidth / 2, closeOffset, candleWidth, closeOffset * -1);
        }
        // label.setLayoutY();

    }

    /**
     * Update tooltip.
     * 
     * @param open the open
     * @param close the close
     * @param high the high
     * @param low the low
     */
    public void updateTooltip(final double open, final double close, final double high, final double low) {
        final TooltipContent tooltipContent = (TooltipContent) this.tooltip.getGraphic();
        tooltipContent.update(open, close, high, low);
        // tooltip.setText("Open: "+open+"\nClose: "+close+"\nHigh: "+high+"\nLow: "+low);
    }

    /**
     * Update style classes.
     */
    private void updateStyleClasses() {
        getStyleClass().setAll("candlestick-candle", this.seriesStyleClass, this.dataStyleClass);
        this.highLowLine.getStyleClass().setAll("candlestick-line", this.seriesStyleClass, this.dataStyleClass,
                this.openAboveClose ? "open-above-close" : "close-above-open");
        this.bar.getStyleClass().setAll("candlestick-bar", this.seriesStyleClass, this.dataStyleClass,
                this.openAboveClose ? "open-above-close" : "close-above-open");
    }
}