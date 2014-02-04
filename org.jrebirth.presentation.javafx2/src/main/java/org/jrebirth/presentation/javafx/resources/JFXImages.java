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
package org.jrebirth.presentation.javafx.resources;

import static org.jrebirth.core.resource.Resources.create;

import org.jrebirth.core.resource.image.ImageExtension;
import org.jrebirth.core.resource.image.ImageItem;
import org.jrebirth.core.resource.image.LocalImage;

/**
 * The JFXImages interface providing all application images.
 */
public interface JFXImages {

    /** . */
    ImageItem CUSTOM_CAR = create(new LocalImage("bg", "Custom_Car", ImageExtension.JPG));

    /** . */
    ImageItem ORANGE = create(new LocalImage("bg", "fabric_texture_car", ImageExtension.JPG));

    /** . */
    ImageItem TIMELINE = create(new LocalImage("future", "timeline", ImageExtension.GIF));

    /** . */
    ImageItem BZH = create(new LocalImage("intro", "breizhcamp", ImageExtension.JPG));

    /** . */
    ImageItem NODE = create(new LocalImage("tree", "think_node", ImageExtension.JPG));

    /** . */
    ImageItem TREE = create(new LocalImage("tree", "think_tree", ImageExtension.JPG));

}
