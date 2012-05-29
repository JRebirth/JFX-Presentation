package org.jrebirth.presentation.javafx;

import org.jrebirth.core.resource.font.FontName;

/**
 * The class <strong>FontsLoader</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public enum JfxFontsLoader implements FontName {

    /** . */
    DINk,

    /** . */
    OliJo,

    /** . */
    Harabara,

    /** . */
    Report_1942,

    /** . */
    arfmoochikncheez,

    /** . */
    Neuton_Cursive,

    BorisBlackBloxx;

    /**
     * {@inheritDoc}
     */
    @Override
    public String get() {
        return name();
    }

}
