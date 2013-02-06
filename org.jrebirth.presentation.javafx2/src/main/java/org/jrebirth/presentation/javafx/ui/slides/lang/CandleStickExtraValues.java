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

// TODO: Auto-generated Javadoc
/** Data extra values for storing close, high and low. */
public class CandleStickExtraValues {

    /** The close. */
    private final double close;

    /** The high. */
    private final double high;

    /** The low. */
    private final double low;

    /** The average. */
    private final double average;

    /**
     * Instantiates a new candle stick extra values.
     * 
     * @param close the close
     * @param high the high
     * @param low the low
     * @param average the average
     */
    public CandleStickExtraValues(final double close, final double high, final double low, final double average) {
        this.close = close;
        this.high = high;
        this.low = low;
        this.average = average;
    }

    /**
     * Gets the close.
     * 
     * @return the close
     */
    public double getClose() {
        return this.close;
    }

    /**
     * Gets the high.
     * 
     * @return the high
     */
    public double getHigh() {
        return this.high;
    }

    /**
     * Gets the low.
     * 
     * @return the low
     */
    public double getLow() {
        return this.low;
    }

    /**
     * Gets the average.
     * 
     * @return the average
     */
    public double getAverage() {
        return this.average;
    }
}