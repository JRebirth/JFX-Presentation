package org.jrebirth.presentation.ui.slides.lang;

import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/** Candle node used for drawing a candle */
public class Candle extends Group {

    private final Line highLowLine = new Line();
    private final Region bar = new Region();
    private String seriesStyleClass;
    private String dataStyleClass;
    private boolean openAboveClose = true;

    private final Text label = new Text();
    private final Tooltip tooltip = new Tooltip();

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
     * @param string
     */
    public void setLabel(final String candleName) {
        this.label.setText(candleName);
    }

    public void setSeriesAndDataStyleClasses(final String seriesStyleClass, final String dataStyleClass) {
        this.seriesStyleClass = seriesStyleClass;
        this.dataStyleClass = dataStyleClass;
        updateStyleClasses();
    }

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

    public void updateTooltip(final double open, final double close, final double high, final double low) {
        final TooltipContent tooltipContent = (TooltipContent) this.tooltip.getGraphic();
        tooltipContent.update(open, close, high, low);
        // tooltip.setText("Open: "+open+"\nClose: "+close+"\nHigh: "+high+"\nLow: "+low);
    }

    private void updateStyleClasses() {
        getStyleClass().setAll("candlestick-candle", this.seriesStyleClass, this.dataStyleClass);
        this.highLowLine.getStyleClass().setAll("candlestick-line", this.seriesStyleClass, this.dataStyleClass,
                this.openAboveClose ? "open-above-close" : "close-above-open");
        this.bar.getStyleClass().setAll("candlestick-bar", this.seriesStyleClass, this.dataStyleClass,
                this.openAboveClose ? "open-above-close" : "close-above-open");
    }
}