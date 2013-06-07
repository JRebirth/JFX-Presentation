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
package org.jrebirth.presentation.javafx.ui.slides.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.presentation.javafx.ui.slides.lang.CandleStickChart;
import org.jrebirth.presentation.javafx.ui.slides.lang.CandleStickExtraValues;
import org.jrebirth.presentation.ui.template.AbstractTemplateView;

// TODO: Auto-generated Javadoc
/**
 * 
 * The class <strong>ChartView</strong>.
 * 
 * The custom slide to introduce chart capabilities.
 * 
 * @author Sébastien Bordes
 */
public final class ChartView extends AbstractTemplateView<ChartModel, AnchorPane, ChartController> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public ChartView(final ChartModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {
        super.initView();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node getContentPanel() {
        return new Pane();
    }

    /**
     * TODO To complete.
     */
    public void showPie() {

        getSubTitle().setText("Pie Chart");

        final PieChart pc = new PieChart();
        // setup chart
        pc.setTitle("Top 5 Systèmes d'exploitation - Janvier 2012 - France");
        pc.setLegendSide(Side.RIGHT);
        pc.setAnimated(true);
        pc.setLabelLineLength(30);
        pc.setStartAngle(180);

        showCustomSlideStep(pc);

        final List<PieChart.Data> dataList = new ArrayList<>();
        dataList.add(new PieChart.Data("Win7", 44.67));
        dataList.add(new PieChart.Data("WinXP", 23.05));
        dataList.add(new PieChart.Data("Win Vista", 17.68));
        dataList.add(new PieChart.Data("MacOSX", 10.38));
        dataList.add(new PieChart.Data("Linux", 1.95));

        final List<PieChart.Data> dataList2 = new ArrayList<>();
        dataList2.add(new PieChart.Data("Win7", 44.67));
        dataList2.add(new PieChart.Data("WinXP", 23.05));
        dataList2.add(new PieChart.Data("Win Vista", 17.68));
        dataList2.add(new PieChart.Data("MacOSX", 10.38));
        dataList2.add(new PieChart.Data("Linux", 1.95));

        final ObservableList<PieChart.Data> data = FXCollections.observableArrayList(dataList);

        final EventHandler<ActionEvent> removeLast = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {
                data.remove(data.size() - 1);
            }
        };

        final EventHandler<ActionEvent> addNext = new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {
                data.add(dataList2.get(data.size()));
            }
        };

        final Timeline loading = new Timeline();
        loading.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(500), new KeyValue(pc.dataProperty(), data)),
                new KeyFrame(Duration.millis(2000), removeLast),
                new KeyFrame(Duration.millis(2500), removeLast),
                new KeyFrame(Duration.millis(3000), removeLast),
                new KeyFrame(Duration.millis(3500), removeLast),
                new KeyFrame(Duration.millis(4000), removeLast),

                new KeyFrame(Duration.millis(4500), addNext),
                new KeyFrame(Duration.millis(5000), addNext),
                new KeyFrame(Duration.millis(5500), addNext),
                new KeyFrame(Duration.millis(6000), addNext),
                new KeyFrame(Duration.millis(6500), addNext)

                );
        loading.play();
    }

    /**
     * TODO To complete.
     */
    public void showArea() {
        getSubTitle().setText("Area Chart");

        final NumberAxis xAxis = new NumberAxis("X Values", 1.0d, 9.0d, 2.0d);
        xAxis.setTickLength(12.0f);
        final NumberAxis yAxis = new NumberAxis("Y Values", 0.0d, 10.0d, 2.0d);
        final ObservableList<AreaChart.Series> areaChartData = FXCollections.observableArrayList(
                new AreaChart.Series("Series 1", FXCollections.observableArrayList(
                        new AreaChart.Data(0, 4),
                        new AreaChart.Data(2, 5),
                        new AreaChart.Data(4, 4),
                        new AreaChart.Data(6, 2),
                        new AreaChart.Data(8, 6),
                        new AreaChart.Data(10, 8)
                        )),
                new AreaChart.Series("Series 2", FXCollections.observableArrayList(
                        new AreaChart.Data(0, 8),
                        new AreaChart.Data(2, 2),
                        new AreaChart.Data(4, 9),
                        new AreaChart.Data(6, 7),
                        new AreaChart.Data(8, 5),
                        new AreaChart.Data(10, 7)
                        )),
                new AreaChart.Series("Series 3", FXCollections.observableArrayList(
                        new AreaChart.Data(0, 2),
                        new AreaChart.Data(2, 5),
                        new AreaChart.Data(4, 8),
                        new AreaChart.Data(6, 6),
                        new AreaChart.Data(8, 9),
                        new AreaChart.Data(10, 7)
                        ))
                );

        final AreaChart chart = new AreaChart(xAxis, yAxis, areaChartData);

        showCustomSlideStep(chart);

    }

    /**
     * TODO To complete.
     */
    public void showBar() {
        getSubTitle().setText("Bar Chart");

        final String[] years = { "2007", "2008", "2009" };
        final CategoryAxis yAxis = new CategoryAxis();
        final NumberAxis xAxis = new NumberAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        // setup chart
        bc.setTitle("Horizontal Bar Chart Example");
        yAxis.setLabel("Price");
        yAxis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(years)));
        xAxis.setLabel("Year");
        // add starting data
        final XYChart.Series<Number, String> series1 = new XYChart.Series<Number, String>();
        series1.setName("Data Series 1");
        final XYChart.Series<Number, String> series2 = new XYChart.Series<Number, String>();
        series2.setName("Data Series 2");
        final XYChart.Series<Number, String> series3 = new XYChart.Series<Number, String>();
        series3.setName("Data Series 3");
        series1.getData().add(new XYChart.Data<Number, String>(567, years[0]));
        series1.getData().add(new XYChart.Data<Number, String>(1292, years[1]));
        series1.getData().add(new XYChart.Data<Number, String>(2180, years[2]));
        series2.getData().add(new XYChart.Data<Number, String>(956, years[0]));
        series2.getData().add(new XYChart.Data<Number, String>(1665, years[1]));
        series2.getData().add(new XYChart.Data<Number, String>(2450, years[2]));
        series3.getData().add(new XYChart.Data<Number, String>(800, years[0]));
        series3.getData().add(new XYChart.Data<Number, String>(1000, years[1]));
        series3.getData().add(new XYChart.Data<Number, String>(2800, years[2]));
        bc.getData().add(series1);
        bc.getData().add(series2);
        bc.getData().add(series3);

        showCustomSlideStep(bc);
    }

    /**
     * TODO To complete.
     */
    public void showBubble() {
        getSubTitle().setText("Bubble Chart");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BubbleChart<Number, Number> bc = new BubbleChart<Number, Number>(xAxis, yAxis);
        // setup chart
        bc.setTitle("Advanced BubbleChart");
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        // add starting data
        final XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        series1.setName("Data Series 1");
        for (int i = 0; i < 20; i++) {
            series1.getData().add(
                    new XYChart.Data<Number, Number>(Math.random() * 100, Math.random() * 100, Math.random() * 10));
        }
        final XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        series2.setName("Data Series 2");
        for (int i = 0; i < 20; i++) {
            series2.getData().add(
                    new XYChart.Data<Number, Number>(Math.random() * 100, Math.random() * 100, Math.random() * 10));
        }
        bc.getData().addAll(series1, series2);

        bc.setEffect(ReflectionBuilder.create().topOpacity(0.8).bottomOpacity(0).build());
        showCustomSlideStep(bc);
    }

    /**
     * TODO To complete.
     */
    public void showLine() {
        getSubTitle().setText("Line Chart");

        final NumberAxis xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        final NumberAxis yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);
        final ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList(
                new LineChart.Series<Double, Double>("Series 1", FXCollections.observableArrayList(
                        new XYChart.Data<Double, Double>(0.0, 1.0),
                        new XYChart.Data<Double, Double>(1.2, 1.4),
                        new XYChart.Data<Double, Double>(2.2, 1.9),
                        new XYChart.Data<Double, Double>(2.7, 2.3),
                        new XYChart.Data<Double, Double>(2.9, 0.5)
                        )),
                new LineChart.Series<Double, Double>("Series 2", FXCollections.observableArrayList(
                        new XYChart.Data<Double, Double>(0.0, 1.6),
                        new XYChart.Data<Double, Double>(0.8, 0.4),
                        new XYChart.Data<Double, Double>(1.4, 2.9),
                        new XYChart.Data<Double, Double>(2.1, 1.3),
                        new XYChart.Data<Double, Double>(2.6, 0.9)
                        ))
                );
        final LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
        showCustomSlideStep(chart);
    }

    /**
     * TODO To complete.
     */
    public void showScatter() {
        getSubTitle().setText("Scatter Chart");

        final NumberAxis xAxis = new NumberAxis("X-Axis", 0d, 8.0d, 1.0d);
        final NumberAxis yAxis = new NumberAxis("Y-Axis", 0.0d, 5.0d, 1.0d);
        final ObservableList<XYChart.Series> data = FXCollections.observableArrayList(
                new ScatterChart.Series("Series 1", FXCollections.<ScatterChart.Data> observableArrayList(
                        new XYChart.Data(0.2, 3.5),
                        new XYChart.Data(0.7, 4.6),
                        new XYChart.Data(1.8, 1.7),
                        new XYChart.Data(2.1, 2.8),
                        new XYChart.Data(4.0, 2.2),
                        new XYChart.Data(4.1, 2.6),
                        new XYChart.Data(4.5, 2.0),
                        new XYChart.Data(6.0, 3.0),
                        new XYChart.Data(7.0, 2.0),
                        new XYChart.Data(7.8, 4.0)
                        ))
                );
        final ScatterChart chart = new ScatterChart(xAxis, yAxis, data);
        showCustomSlideStep(chart);

    }

    /**
     * TODO To complete.
     */
    public void showCandle() {
        getSubTitle().setText("Custom Chart");

        final double[][] data = new double[][] {
                /* Fortran Intel */
                { 1, 1.00, 1.00, 1.00, 1.02, 1.84, 3.09, 25.26 },
                /* C GNU gcc */
                { 2, 1.00, 1.00, 1.01, 1.21, 1.39, 1.96, 4.97 },
                /* C++ GNU g++ */
                { 3, 1.00, 1.00, 1.10, 1.26, 1.58, 1.94, 1.94 },
                /* Ada 2005 GNAT */
                { 4, 1.00, 1.00, 1.20, 1.28, 1.77, 2.63, 4.81 },
                /* ATS */
                { 5, 1.00, 1.00, 1.23, 1.33, 2.15, 3.52, 7.24 },
                /* Java 7 averaged */
                { 6, 1.42, 1.42, 1.45, 1.82, 2.18, 2.30, 2.30 },
                /* Java 7 -server */
                { 7, 1.09, 1.09, 1.52, 1.94, 2.15, 3.09, 3.47 },
                /* Go */
                { 8, 1.21, 1.21, 2.01, 2.09, 5.78, 11.43, 23.96 },
                /* Lisp SBCL */
                { 9, 1.12, 1.12, 1.75, 2.39, 4.24, 7.99, 11.20 },
                /* Scala */
                { 10, 1.27, 1.27, 1.81, 2.53, 3.30, 5.52, 10.18 },
                /* C# Mono */
                { 11, 1.60, 1.60, 2.22, 2.82, 7.12, 14.21, 14.21 },
                /* Haskell GHC */
                { 12, 1.70, 1.70, 2.40, 2.98, 4.59, 7.87, 13.35 },
                /* OCaml */
                { 13, 1.18, 1.18, 1.62, 3.42, 4.81, 9.24, 9.24 },
                /* Pascal Free Pascal */
                { 14, 1.53, 1.53, 2.27, 3.83, 7.49, 15.32, 24.20 },
                /* Racket */
                { 15, 1.23, 1.75, 4.75, 5.22, 6.75, 9.75, 39.89 },
                /* F# Mono */
                { 16, 2.74, 2.74, 3.72, 5.39, 9.56, 12.79, 12.79 },
                /* Clojure */
                { 17, 1.86, 1.86, 3.63, 5.48, 8.50, 15.81, 18.44 },
                /* Erlang HiPE */
                { 18, 5.17, 5.17, 7.55, 9.32, 21.05, 41.31, 46.55 },
                /* Erlang */
                { 19, 5.40, 5.40, 19.92, 22.51, 51.41, 98.64, 218.10 },
                /* Python 3 */
                { 20, 1.22, 1.22, 9.25, 41.82, 116.75, 197.50, 197.50 },
                /* PHP */
                { 21, 1.92, 1.92, 10.65, 46.03, 120.54, 285.38, 337.17 },
                /* Ruby */
                { 22, 1.9, 4.67, 4.67, 11.74, 49.76, 101.33, 235.71, 356.61 },
                /* Ruby JRuby */
                { 23, 5.63, 5.63, 27.17, 53.20, 115.32, 235.46, 235.46 },
                /* Perl */
                { 24, 4.00, 4.00, 22.61, 92.78, 126.82, 249.63, 249.63 }
        };
        final NumberAxis xAxis = new NumberAxis(0, 25, 1);
        xAxis.setMinorTickCount(0);
        final NumberAxis yAxis = new NumberAxis(0, 50, 1);
        final CandleStickChart bc = new CandleStickChart(xAxis, yAxis);
        // setup chart
        bc.setTitle("Temps processeur par langages");
        xAxis.setLabel("Langages");
        yAxis.setLabel("Temps Processeur");
        // add starting data
        final XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        for (int i = 0; i < data.length; i++) {
            final double[] day = data[i];
            series.getData().add(
                    // new XYChart.Data<Number, Number>(day[0], day[1], new CandleStickExtraValues(day[2], day[3], day[4], day[5]))
                    new XYChart.Data<Number, Number>(day[0], day[3], new CandleStickExtraValues(day[5], day[6], day[2], day[4]))
                    );
        }
        ObservableList<XYChart.Series<Number, Number>> data2 = bc.getData();
        if (data2 == null) {
            data2 = FXCollections.observableArrayList(series);
            bc.setData(data2);
        } else {
            bc.getData().add(series);
        }

        showCustomSlideStep(bc);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        // Nothing to do yet
    }

}
