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
package org.jrebirth.presentation.javafx;

import javafx.scene.text.Font;

import org.jrebirth.core.resource.ResourceBuilders;
import org.jrebirth.core.resource.font.FontBuilder;
import org.jrebirth.core.resource.font.FontItem;
import org.jrebirth.core.resource.font.FontParams;
import org.jrebirth.core.resource.font.RealFont;
import org.jrebirth.presentation.resource.PrezFontNames;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>PrezFonts</strong>.
 * 
 * @author Sébastien Bordes
 * 
 */
public enum JfxFonts implements FontItem {

    /** The splash font. */
    PAGE(new RealFont(PrezFontNames.DINk, 24)),

    /** The slide title font. */
    SLIDE_TITLE(new RealFont(PrezFontNames.Harabara, 30)),

    /** The slide subtitle font. */
    SLIDE_SUBTITLE(new RealFont(PrezFontNames.Harabara, 20)),

    /** The typewriter font. */
    TYPEWRITER(new RealFont(PrezFontNames.Report_1942, 72)),

    /** The typewriter font. */
    TYPEWRITER2(new RealFont(PrezFontNames.OliJo, 72)),

    /** The splash font. */
    SPLASH(new RealFont(PrezFontNames.BorisBlackBloxx, 30));

    /**
     * Default Constructor.
     * 
     * @param fontParams the font size
     */
    JfxFonts(final FontParams fontParams) {
        builder().storeParams(this, fontParams);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font get() {
        return builder().get(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FontBuilder builder() {
        return ResourceBuilders.FONT_BUILDER;
    }

}
