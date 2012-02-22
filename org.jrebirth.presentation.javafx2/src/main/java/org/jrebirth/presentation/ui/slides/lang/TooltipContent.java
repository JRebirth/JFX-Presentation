package org.jrebirth.presentation.ui.slides.lang;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TooltipContent extends GridPane {
    private final Label openValue = new Label();
    private final Label closeValue = new Label();
    private final Label highValue = new Label();
    private final Label lowValue = new Label();

    public TooltipContent() {
        final Label open = new Label("OPEN:");
        final Label close = new Label("CLOSE:");
        final Label high = new Label("HIGH:");
        final Label low = new Label("LOW:");
        open.getStyleClass().add("candlestick-tooltip-label");
        close.getStyleClass().add("candlestick-tooltip-label");
        high.getStyleClass().add("candlestick-tooltip-label");
        low.getStyleClass().add("candlestick-tooltip-label");
        setConstraints(open, 0, 0);
        setConstraints(this.openValue, 1, 0);
        setConstraints(close, 0, 1);
        setConstraints(this.closeValue, 1, 1);
        setConstraints(high, 0, 2);
        setConstraints(this.highValue, 1, 2);
        setConstraints(low, 0, 3);
        setConstraints(this.lowValue, 1, 3);
        getChildren().addAll(open, this.openValue, close, this.closeValue, high, this.highValue, low, this.lowValue);
    }

    public void update(final double open, final double close, final double high, final double low) {
        this.openValue.setText(Double.toString(open));
        this.closeValue.setText(Double.toString(close));
        this.highValue.setText(Double.toString(high));
        this.lowValue.setText(Double.toString(low));
    }
}