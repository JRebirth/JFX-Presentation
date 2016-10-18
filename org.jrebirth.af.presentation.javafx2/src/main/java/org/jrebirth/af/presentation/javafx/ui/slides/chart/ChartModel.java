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
package org.jrebirth.af.presentation.javafx.ui.slides.chart;

import org.jrebirth.af.presentation.ui.template.AbstractTemplateModel;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>ChartModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class ChartModel extends AbstractTemplateModel<ChartModel, ChartView, ChartSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected ChartSlideStep[] initializeSlideStep() {
        return ChartSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final ChartSlideStep slideStep) {

        switch (slideStep) {
            case Chart:
                view().showSlideStep(slideStep);
                break;
            case PieChart:
                view().showPie();
                break;
            case AreaChart:
                view().showArea();
                break;
            case BarChart:
                view().showBar();
                break;
            case BubbleChart:
                view().showBubble();
                break;
            case LineChart:
                view().showLine();
                break;
            case ScatterChart:
                view().showScatter();
                break;
            case Candle:
                view().showCandle();
                break;
        }

    }
}
