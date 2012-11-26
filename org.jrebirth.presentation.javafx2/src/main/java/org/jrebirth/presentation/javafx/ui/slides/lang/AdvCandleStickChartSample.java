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
package org.jrebirth.presentation.javafx.ui.slides.lang;

/**
 * Copyright (c) 2008, 2011 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * A custom candlestick chart.
 * 
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.NumberAxis
 * @see javafx.scene.chart.XYChart
 */
public class AdvCandleStickChartSample extends Application {

    // DAY, OPEN, CLOSE, HIGH, LOW, AVERAGE
    /** The data. */
    private static double[][] data = new double[][] {

            // { 1, 25, 20, 32, 16, 20 },
            // { 2, 26, 30, 33, 22, 25 },
            // { 3, 30, 38, 40, 20, 32 },
            // { 4, 24, 30, 34, 22, 30 },
            // { 5, 26, 36, 40, 24, 32 },
            // { 6, 28, 38, 45, 25, 34 },
            // { 7, 36, 30, 44, 28, 39 },
            // { 8, 30, 18, 36, 16, 31 },
            // { 9, 40, 50, 52, 36, 41 },
            // { 10, 30, 34, 38, 28, 36 },
            // { 11, 24, 12, 30, 8, 32.4 },
            // { 12, 28, 40, 46, 25, 31.6 },
            // { 13, 28, 18, 36, 14, 32.6 },
            // { 14, 38, 30, 40, 26, 30.6 },
            // { 15, 28, 33, 40, 28, 30.6 },
            // { 16, 25, 10, 32, 6, 30.1 },
            // { 17, 26, 30, 42, 18, 27.3 },
            // { 18, 20, 18, 30, 10, 21.9 },
            // { 19, 20, 10, 30, 5, 21.9 },
            // { 20, 26, 16, 32, 10, 17.9 },
            // { 21, 38, 40, 44, 32, 18.9 },
            // { 22, 26, 40, 41, 12, 18.9 },
            // { 23, 30, 18, 34, 10, 18.9 },
            // { 24, 12, 23, 26, 12, 18.2 },
            // { 25, 30, 40, 45, 16, 18.9 },
            // { 26, 25, 35, 38, 20, 21.4 },
            // { 27, 24, 12, 30, 8, 19.6 },
            // { 28, 23, 44, 46, 15, 22.2 },
            // { 29, 28, 18, 30, 12, 23 },
            // { 30, 28, 18, 30, 12, 23.2 },
            // { 31, 28, 18, 30, 12, 22 }

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

    /**
     * Inits the.
     * 
     * @param primaryStage the primary stage
     */
    private void init(final Stage primaryStage) {
        final BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);

        primaryStage.getScene().getStylesheets().add("style/candle.css");
        root.setCenter(createChart());
    }

    /**
     * Creates the chart.
     * 
     * @return the candle stick chart
     */
    protected CandleStickChart createChart() {
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
        ObservableList<XYChart.Series<Number, Number>> data = bc.getData();
        if (data == null) {
            data = FXCollections.observableArrayList(series);
            bc.setData(data);
        } else {
            bc.getData().add(series);
        }
        return bc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
