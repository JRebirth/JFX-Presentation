package org.jrebirth.presentation.ui.slides.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 * A candlestick chart is a style of bar-chart used primarily to describe price movements of a security, derivative, or currency over time.
 * 
 * The Data Y value is used for the opening price and then the close, high and low values are stored in the Data's extra value property using a CandleStickExtraValues object.
 */
public class CandleStickChart extends XYChart<Number, Number> {

    private static String[] labels = new String[] {

            "Fortran Intel",
            "C GNU gcc",
            "C++ GNU g++",
            "Ada 2005 GNAT",
            "ATS",
            "Java 7 averaged",
            "Java 7 -server",
            "Go",
            "Lisp SBCL",
            "Scala",
            "C# Mono",
            "Haskell GHC",
            "OCaml",
            "Pascal Free Pascal",
            "Racket",
            "F# Mono",
            "Clojure",
            "Erlang HiPE",
            "Erlang",
            "Python 3",
            "PHP",
            "Ruby",
            "Ruby JRuby",
            "Perl",
    };

    // -------------- CONSTRUCTORS ----------------------------------------------
    /**
     * Construct a new CandleStickChart with the given axis.
     * 
     * @param xAxis The x axis to use
     * @param yAxis The y axis to use
     */
    public CandleStickChart(final Axis<Number> xAxis, final Axis<Number> yAxis) {
        super(xAxis, yAxis);
        setAnimated(false);
        xAxis.setAnimated(false);
        yAxis.setAnimated(false);
    }

    /**
     * Construct a new CandleStickChart with the given axis and data.
     * 
     * @param xAxis The x axis to use
     * @param yAxis The y axis to use
     * @param data The data to use, this is the actual list used so any changes to it will be reflected in the chart
     */
    public CandleStickChart(final Axis<Number> xAxis, final Axis<Number> yAxis, final ObservableList<Series<Number, Number>> data) {
        this(xAxis, yAxis);
        setData(data);
    }

    // -------------- METHODS ------------------------------------------------------------------------------------------
    /** Called to update and layout the content for the plot */
    @Override
    protected void layoutPlotChildren() {
        // we have nothing to layout if no data is present
        if (getData() == null) {
            return;
        }
        // update candle positions
        for (int seriesIndex = 0; seriesIndex < getData().size(); seriesIndex++) {
            final Series<Number, Number> series = getData().get(seriesIndex);
            final Iterator<Data<Number, Number>> iter = getDisplayedDataIterator(series);
            Path seriesPath = null;
            if (series.getNode() instanceof Path) {
                seriesPath = (Path) series.getNode();
                seriesPath.getElements().clear();
            }
            int i = 0;
            while (iter.hasNext()) {
                final Data<Number, Number> item = iter.next();
                final double x = getXAxis().getDisplayPosition(getCurrentDisplayedXValue(item));
                final double y = getYAxis().getDisplayPosition(getCurrentDisplayedYValue(item));
                final Node itemNode = item.getNode();
                final CandleStickExtraValues extra = (CandleStickExtraValues) item.getExtraValue();
                if (itemNode instanceof Candle && extra != null) {
                    final Candle candle = (Candle) itemNode;

                    final double close = getYAxis().getDisplayPosition(extra.getClose());
                    final double high = getYAxis().getDisplayPosition(extra.getHigh());
                    final double low = getYAxis().getDisplayPosition(extra.getLow());
                    // calculate candle width
                    double candleWidth = -1;
                    if (getXAxis() instanceof NumberAxis) {
                        final NumberAxis xa = (NumberAxis) getXAxis();
                        candleWidth = xa.getDisplayPosition(xa.getTickUnit()) * 0.90; // use 90% width between ticks
                    }
                    // update candle
                    candle.update(close - y, high - y, low - y, candleWidth);
                    candle.setLabel(labels[i]);
                    candle.updateTooltip(item.getYValue().doubleValue(), extra.getClose(), extra.getHigh(), extra.getLow());

                    // position the candle
                    candle.setLayoutX(x);
                    candle.setLayoutY(y);
                }
                if (seriesPath != null) {
                    if (seriesPath.getElements().isEmpty()) {
                        seriesPath.getElements().add(new MoveTo(x, getYAxis().getDisplayPosition(extra.getAverage())));
                    } else {
                        seriesPath.getElements().add(new LineTo(x, getYAxis().getDisplayPosition(extra.getAverage())));
                    }
                }
                i++;
            }
        }
    }

    @Override
    protected void dataItemChanged(final Data<Number, Number> item) {
    }

    @Override
    protected void dataItemAdded(final Series<Number, Number> series, final int itemIndex, final Data<Number, Number> item) {
        final Node candle = createCandle(getData().indexOf(series), item, itemIndex);
        if (shouldAnimate()) {
            candle.setOpacity(0);
            getPlotChildren().add(candle);
            // fade in new candle
            final FadeTransition ft = new FadeTransition(Duration.millis(500), candle);
            ft.setToValue(1);
            ft.play();
        } else {
            getPlotChildren().add(candle);
        }
        // always draw average line on top
        if (series.getNode() != null) {
            series.getNode().toFront();
        }
    }

    @Override
    protected void dataItemRemoved(final Data<Number, Number> item, final Series<Number, Number> series) {
        final Node candle = item.getNode();
        if (shouldAnimate()) {
            // fade out old candle
            final FadeTransition ft = new FadeTransition(Duration.millis(500), candle);
            ft.setToValue(0);
            ft.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(final ActionEvent actionEvent) {
                    getPlotChildren().remove(candle);
                }
            });
            ft.play();
        } else {
            getPlotChildren().remove(candle);
        }
    }

    @Override
    protected void seriesAdded(final Series<Number, Number> series, final int seriesIndex) {
        // handle any data already in series
        for (int j = 0; j < series.getData().size(); j++) {
            final Data item = series.getData().get(j);
            final Node candle = createCandle(seriesIndex, item, j);
            if (shouldAnimate()) {
                candle.setOpacity(0);
                getPlotChildren().add(candle);
                // fade in new candle
                final FadeTransition ft = new FadeTransition(Duration.millis(500), candle);
                ft.setToValue(1);
                ft.play();
            } else {
                getPlotChildren().add(candle);
            }
        }
        // create series path
        final Path seriesPath = new Path();
        seriesPath.getStyleClass().setAll("candlestick-average-line", "series" + seriesIndex);
        series.setNode(seriesPath);
        getPlotChildren().add(seriesPath);
    }

    @Override
    protected void seriesRemoved(final Series<Number, Number> series) {
        // remove all candle nodes
        for (final XYChart.Data<Number, Number> d : series.getData()) {
            final Node candle = d.getNode();
            if (shouldAnimate()) {
                // fade out old candle
                final FadeTransition ft = new FadeTransition(Duration.millis(500), candle);
                ft.setToValue(0);
                ft.setOnFinished(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(final ActionEvent actionEvent) {
                        getPlotChildren().remove(candle);
                    }
                });
                ft.play();
            } else {
                getPlotChildren().remove(candle);
            }
        }
    }

    /**
     * Create a new Candle node to represent a single data item
     * 
     * @param seriesIndex The index of the series the data item is in
     * @param item The data item to create node for
     * @param itemIndex The index of the data item in the series
     * @return New candle node to represent the give data item
     */
    private Node createCandle(final int seriesIndex, final Data item, final int itemIndex) {
        Node candle = item.getNode();
        // check if candle has already been created
        if (candle instanceof Candle) {
            ((Candle) candle).setSeriesAndDataStyleClasses("series" + seriesIndex, "data" + itemIndex);
        } else {
            candle = new Candle("series" + seriesIndex, "data" + itemIndex);
            item.setNode(candle);
        }
        return candle;
    }

    /**
     * This is called when the range has been invalidated and we need to update it. If the axis are auto ranging then we compile a list of all data that the given axis has to plot and call
     * invalidateRange() on the axis passing it that data.
     */
    @Override
    protected void updateAxisRange() {
        // For candle stick chart we need to override this method as we need to let the axis know that they need to be able
        // to cover the whole area occupied by the high to low range not just its center data value
        final Axis<Number> xa = getXAxis();
        final Axis<Number> ya = getYAxis();
        List<Number> xData = null;
        List<Number> yData = null;
        if (xa.isAutoRanging()) {
            xData = new ArrayList<Number>();
        }
        if (ya.isAutoRanging()) {
            yData = new ArrayList<Number>();
        }
        if (xData != null || yData != null) {
            for (final Series<Number, Number> series : getData()) {
                for (final Data<Number, Number> data : series.getData()) {
                    if (xData != null) {
                        xData.add(data.getXValue());
                    }
                    if (yData != null) {
                        final CandleStickExtraValues extras = (CandleStickExtraValues) data.getExtraValue();
                        if (extras != null) {
                            yData.add(extras.getHigh());
                            yData.add(extras.getLow());
                        } else {
                            yData.add(data.getYValue());
                        }
                    }
                }
            }
            if (xData != null) {
                xa.invalidateRange(xData);
            }
            if (yData != null) {
                ya.invalidateRange(yData);
            }
        }
    }
}