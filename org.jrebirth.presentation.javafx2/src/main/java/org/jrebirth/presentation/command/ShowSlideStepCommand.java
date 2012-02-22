package org.jrebirth.presentation.command;

import org.jrebirth.core.command.impl.CommandImpl;
import org.jrebirth.core.link.Wave;
import org.jrebirth.presentation.ui.base.ShowSlideWaveItem;
import org.jrebirth.presentation.ui.base.SlideModel;
import org.jrebirth.presentation.ui.base.SlideStep;

/**
 * The class <strong>ShowSlideStepCommand</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public final class ShowSlideStepCommand extends CommandImpl {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void run(final Wave wave) {

        // Retrieve the slide model
        final SlideModel<SlideStep> model = getModel((Class<SlideModel<SlideStep>>) wave.get(ShowSlideWaveItem.SLIDE_MODEL_CLASS).getValue());

        // Show the the next slide step
        model.showSlideStep((SlideStep) wave.get(ShowSlideWaveItem.SLIDE_STEP_TYPE).getValue());

    }
}
