package org.jrebirth.presentation;

import javafx.scene.paint.Color;

import org.jrebirth.core.resource.ResourceFactories;
import org.jrebirth.core.resource.color.ColorFactory;
import org.jrebirth.core.resource.color.WebColor;

/**
 * The class <strong>PrezColors</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public enum PrezColors implements WebColor {

    SLIDE_TITLE("#0088D3", 1.0),

    SHAPE_BLUE("#3495CE", 1.0),

    DROP_SHADOW("#000000", 0.8),
    INNER_SHADOW("#FFFFFF", 0.3),

    GRADIENT_1("#1AA2AC", 1.0),
    GRADIENT_2("#F04F24", 1.0),
    GRADIENT_3("#FFF200", 1.0)

    ;

    /** The hexadecimal string. */
    private String hexString;

    /** The color opacity. */
    private Double opacity;

    /**
     * Private Constructor.
     * 
     * @param hexString the hexa string
     */
    private PrezColors(final String hexString, final double opacity) {
        this.hexString = hexString;
        this.opacity = opacity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double opacity() {
        return this.opacity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color get() {
        return factory().get(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorFactory factory() {
        return (ColorFactory) ResourceFactories.COLOR_FACTORY.use();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String hex() {
        return this.hexString;
    }

}
