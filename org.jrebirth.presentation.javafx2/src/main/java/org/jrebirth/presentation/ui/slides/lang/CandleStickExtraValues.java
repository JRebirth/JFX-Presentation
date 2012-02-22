package org.jrebirth.presentation.ui.slides.lang;

/** Data extra values for storing close, high and low. */
public class CandleStickExtraValues {
    private final double close;
    private final double high;
    private final double low;
    private final double average;

    public CandleStickExtraValues(final double close, final double high, final double low, final double average) {
        this.close = close;
        this.high = high;
        this.low = low;
        this.average = average;
    }

    public double getClose() {
        return this.close;
    }

    public double getHigh() {
        return this.high;
    }

    public double getLow() {
        return this.low;
    }

    public double getAverage() {
        return this.average;
    }
}