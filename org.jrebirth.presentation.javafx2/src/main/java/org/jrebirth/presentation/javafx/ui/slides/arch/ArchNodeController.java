package org.jrebirth.presentation.javafx.ui.slides.arch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Group;

import org.jrebirth.core.ui.fxml.AbstractFXMLController;

/**
 * The class <strong>ArchNodeController</strong>.
 * 
 * @author Sébastien Bordes
 */
public class ArchNodeController extends AbstractFXMLController {

    @FXML
    public Group nodes;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
        this.nodes.setVisible(false);

    }

    public void showNodes(final boolean b) {
        this.nodes.setVisible(b);
    }

}
