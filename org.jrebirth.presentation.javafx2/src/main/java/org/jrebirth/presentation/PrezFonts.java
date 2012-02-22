package org.jrebirth.presentation;

import javafx.scene.text.Font;

import org.jrebirth.core.resource.ResourceFactories;
import org.jrebirth.core.resource.font.FontFactory;
import org.jrebirth.core.resource.font.FontName;
import org.jrebirth.core.resource.font.RealFont;

/**
 * The class <strong>PrezFonts</strong>.
 * 
 * @author Sébastien Bordes
 * 
 * @version $Revision$ $Author$
 * @since $Date$
 */
public enum PrezFonts implements RealFont {

    /** The splash font. */
    PAGE(FontsLoader.DINk, 24),

    /** The slide title font. */
    SLIDE_TITLE(FontsLoader.Harabara, 36),

    /** The slide subtitle font. */
    SLIDE_SUBTITLE(FontsLoader.Harabara, 24),

    /** The intro font. */
    TYPEWRITER(FontsLoader.Segoe_UI, 72),

    /** The intro font. */
    SPLASH(FontsLoader.BorisBlackBloxx, 40),

    ;

    /** The Font name. */
    private FontName fontName;

    /** The Font size. */
    private double size;

    /**
     * Default Constructor.
     * 
     * @param fontName the font name
     * @param size the font size
     */
    PrezFonts(final FontName fontName, final double size) {
        this.fontName = fontName;
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font get() {
        return factory().get(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FontFactory factory() {
        return (FontFactory) ResourceFactories.FONT_FACTORY.use();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FontName fontName() {
        return this.fontName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double size() {
        return this.size;
    }

}
