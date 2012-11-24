package org.jrebirth.presentation.javafx.ui.slides.chart;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

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
                getView().showSlideStep(slideStep);
                break;
            case PieChart:
                getView().showPie();
                break;
            case AreaChart:
                getView().showArea();
                break;
            case BarChart:
                getView().showBar();
                break;
            case BubbleChart:
                getView().showBubble();
                break;
            case LineChart:
                getView().showLine();
                break;
            case ScatterChart:
                getView().showScatter();
                break;
            case Candle:
                getView().showCandle();
                break;
        }

    }
}
