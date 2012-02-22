package org.jrebirth.presentation.ui.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jrebirth.core.link.Wave;
import org.jrebirth.core.ui.impl.AbstractModel;
import org.jrebirth.presentation.model.Slide;
import org.jrebirth.presentation.model.SlideContent;

/**
 * The class <strong>AbstractSlideModel</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 55 $ $Author: sbordes $
 * @since $Date: 2011-10-14 19:23:59 +0200 (Fri, 14 Oct 2011) $
 * 
 * @param <M> the SlideModel class
 * @param <V> the SlideView class
 * @param <S> the SlideStep to use
 */
public abstract class AbstractSlideModel<M extends AbstractSlideModel<M, V, S>, V extends AbstractSlideView<?, ?, ?>, S extends SlideStep> extends AbstractModel<M, V> implements SlideModel<S> {

    /** The slide data object. */
    private Slide slide;

    /** The step position. */
    private int stepPosition;

    /** The list of slide step. */
    private List<S> stepList;

    /** The slide number. */
    private int slideNumber;

    /**
     * @return Returns the slide.
     */
    public Slide getSlide() {
        if (this.slide == null) {
            this.slide = Slide.class.cast(getModelObject().getValue());
        }
        return this.slide;
    }

    /**
     * @param slide The slide to set.
     */
    public void setSlide(final Slide slide) {
        this.slide = slide;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareView() {
        super.prepareView();

        // Load the default slide step (if exists)
        if (getStepList().size() > 0) {
            showSlideStep(getStepList().get(this.stepPosition));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeInnerModels() {
        // Nothing to do generic TODO
        getClass();
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    @Override
    protected void processAction(final Wave wave) {
        // Nothing to do generic TODO
        getClass();
    }

    /**
     * @return Returns the slideNumber.
     */
    public int getSlideNumber() {
        return this.slideNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSlideNumber(final int slideNumber) {
        this.slideNumber = slideNumber;
    }

    /**
     * @return Returns the stepPosition.
     */
    public int getStepPosition() {
        return this.stepPosition;
    }

    /**
     * @return Returns the stepList.
     */
    private List<S> getStepList() {
        if (this.stepList == null) {
            this.stepList = new ArrayList<>();
            this.stepList.addAll(Arrays.asList(initializeSlideStep()));
        }
        return this.stepList;
    }

    /**
     * Initialize the SlideStep array.
     */
    protected abstract S[] initializeSlideStep();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean nextStep() {
        final boolean res = this.stepPosition < this.stepList.size() - 1;
        if (res) {
            this.stepPosition++;
            // Launch the next step
            showSlideStep(getStepList().get(this.stepPosition));
        }
        // otherwise no more step return true to go to the next slide
        return !res;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean previousStep() {
        final boolean res = this.stepPosition > 0;
        if (res) {
            this.stepPosition--;
            // Launch the previous step
            showSlideStep(getStepList().get(this.stepPosition));
        }
        // otherwise no more step return true to go to the previous slide
        return !res;
    }

    /**
     * Return the default content or null.
     * 
     * @return the SlideContent
     */
    public SlideContent getDefaultContent() {
        if (getSlide().getContent() != null && !getSlide().getContent().isEmpty()) {
            return getSlide().getContent().get(0);
        }
        return null;
    }

    /**
     * Return the default content or null.
     * 
     * @return the SlideContent
     */
    public SlideContent getContent(final SlideStep slideStep) {
        if (getSlide().getContent() != null && !getSlide().getContent().isEmpty()) {
            for (SlideContent sc : getSlide().getContent()) {
                if (sc.getName() != null && !sc.getName().isEmpty() && sc.getName().equals(slideStep.toString())) {
                    return sc;
                }
            }
        }
        return getDefaultContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void showSlideStep(final S slideStep);
}
