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
package org.jrebirth.af.presentation.javafx.resources;

import static org.jrebirth.af.core.resource.Resources.create;

import org.jrebirth.af.api.resource.style.StyleSheetItem;
import org.jrebirth.af.core.resource.style.StyleSheet;

/**
 * The JfxStyles interface providing all application style sheets.
 * Uses .module() so ModuleUtility can resolve the CSS files from the
 * correct JPMS module (org.jrebirth.af.presentation.javafx) under
 * the stylesFolder=style folder declared in jrebirth.properties.
 */
public interface JfxStyles {

    /** Main presentation template style sheet (style/template.css). */
    StyleSheetItem TEMPLATE = create(new StyleSheet("template")).module(JfxStyles.class.getModule());

    /** Candle-stick chart style sheet (style/candle.css). */
    StyleSheetItem CANDLE = create(new StyleSheet("candle")).module(JfxStyles.class.getModule());

}
