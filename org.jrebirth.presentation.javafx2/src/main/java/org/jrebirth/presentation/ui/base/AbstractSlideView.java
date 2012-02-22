package org.jrebirth.presentation.ui.base;

import javafx.scene.Parent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.impl.AbstractView;

/**
 * 
 * The class <strong>AbstractSlideView</strong>.
 * 
 * .
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 * 
 * @param <M> the slide model class
 * @param <N> the layout node
 * @param <C> the slide controller class
 */
public abstract class AbstractSlideView<M extends AbstractSlideModel<?, ?, ?>, N extends Parent, C extends AbstractSlideController<?, ?>> extends
        AbstractView<M, N, C> {

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public AbstractSlideView(final M model) throws CoreException {
        super(model);
    }

}
