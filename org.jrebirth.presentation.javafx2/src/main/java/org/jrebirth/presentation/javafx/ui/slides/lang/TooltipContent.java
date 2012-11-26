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

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

// TODO: Auto-generated Javadoc
/**
 * The Class TooltipContent.
 */
public class TooltipContent extends GridPane {
    
    /** The open value. */
    private final Label openValue = new Label();
    
    /** The close value. */
    private final Label closeValue = new Label();
    
    /** The high value. */
    private final Label highValue = new Label();
    
    /** The low value. */
    private final Label lowValue = new Label();

    /**
     * Instantiates a new tooltip content.
     */
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

    /**
     * Update.
     * 
     * @param open the open
     * @param close the close
     * @param high the high
     * @param low the low
     */
    public void update(final double open, final double close, final double high, final double low) {
        this.openValue.setText(Double.toString(open));
        this.closeValue.setText(Double.toString(close));
        this.highValue.setText(Double.toString(high));
        this.lowValue.setText(Double.toString(low));
    }
}