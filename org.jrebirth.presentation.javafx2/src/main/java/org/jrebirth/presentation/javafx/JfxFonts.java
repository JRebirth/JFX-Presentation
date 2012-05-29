package org.jrebirth.presentation.javafx;

import javafx.scene.text.Font;

import org.jrebirth.core.resource.ResourceFactories;
import org.jrebirth.core.resource.font.FontEnum;
import org.jrebirth.core.resource.font.FontFactory;
import org.jrebirth.core.resource.font.FontParams;
import org.jrebirth.core.resource.font.RealFont;
import org.jrebirth.presentation.FontsLoader;

/**
 * The class <strong>PrezFonts</strong>.
 * 
 * @author Sébastien Bordes
 * 
 */
public enum JfxFonts implements FontEnum {

    /** The splash font. */
    PAGE(new RealFont(FontsLoader.DINk, 24)),

    /** The slide title font. */
    SLIDE_TITLE(new RealFont(FontsLoader.Harabara, 30)),

    /** The slide subtitle font. */
    SLIDE_SUBTITLE(new RealFont(FontsLoader.Harabara, 20)),

    /** The typewriter font. */
    TYPEWRITER(new RealFont(FontsLoader.Report_1942, 72)),
    
    /** The typewriter font. */
    TYPEWRITER2(new RealFont(FontsLoader.OliJo, 72)),

    /** The splash font. */
    SPLASH(new RealFont(FontsLoader.BorisBlackBloxx, 30));

    /**
     * Default Constructor.
     * 
     * @param fontParams the font size
     */
    JfxFonts(final FontParams fontParams) {
        factory().storeParams(this, fontParams);
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

}
