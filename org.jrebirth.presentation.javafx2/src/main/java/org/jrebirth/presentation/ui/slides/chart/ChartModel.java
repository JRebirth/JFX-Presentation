package org.jrebirth.presentation.ui.slides.chart;

import org.jrebirth.presentation.ui.template.AbstractTemplateModel;

/**
 * The class <strong>ChartModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
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
