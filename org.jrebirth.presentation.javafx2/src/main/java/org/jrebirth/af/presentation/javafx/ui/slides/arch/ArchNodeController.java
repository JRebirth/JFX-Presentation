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
package org.jrebirth.af.presentation.javafx.ui.slides.arch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Group;

import org.jrebirth.af.core.ui.fxml.AbstractFXMLController;

/**
 * The class <strong>ArchNodeController</strong>.
 * 
 * @author Sébastien Bordes
 */
public class ArchNodeController extends AbstractFXMLController<ArchModel, ArchView> {

    /** The nodes. */
    @FXML
    public Group nodes;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
        this.nodes.setVisible(false);

    }

    /**
     * Show nodes.
     * 
     * @param b the b
     */
    public void showNodes(final boolean b) {
        this.nodes.setVisible(b);
    }

}
