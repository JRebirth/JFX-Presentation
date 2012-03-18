package org.jrebirth.presentation.ui.stack;

import javafx.event.ActionEvent;

import org.jrebirth.core.exception.CoreException;
import org.jrebirth.core.ui.DefaultController;
import org.jrebirth.core.ui.adapter.ActionAdapter;

/**
 * The class <strong>WorkbenchController</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision: 72 $ $Author: sbordes $
 * @since $Date: 2011-10-17 22:26:35 +0200 (Mon, 17 Oct 2011) $
 */
public final class StackController extends DefaultController<StackModel, StackView> implements ActionAdapter {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public StackController(final StackView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(final ActionEvent actionEvent) {
        // final RotateTransition rt = new RotateTransition(Duration.millis(3000), getView().getHelloButton());
        // rt.setByAngle(180);
        // rt.setCycleCount(4);
        // rt.setAutoReverse(true);
        //
        // rt.play();
        // TODO

    }

}
