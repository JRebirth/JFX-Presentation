package org.jrebirth.presentation.command;

import org.jrebirth.core.command.impl.CommandImpl;
import org.jrebirth.core.link.Wave;
import org.jrebirth.presentation.ui.stack.StackModel;

/**
 * The class <strong>ShowSlideMenuCommand</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public final class ShowSlideMenuCommand extends CommandImpl {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(final Wave wave) {

        getModel(StackModel.class).showSlideMenu();

    }

}
