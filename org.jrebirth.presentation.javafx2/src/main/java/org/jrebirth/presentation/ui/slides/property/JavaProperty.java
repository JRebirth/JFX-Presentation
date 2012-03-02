package org.jrebirth.presentation.ui.slides.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class JavaProperty {

    /** The integer property. */
    private final IntegerProperty intProperty = new SimpleIntegerProperty();

    /**
     * @return Returns the value.
     */
    public final double getValue() {
        return this.intProperty.get();
    }

    /**
     * @param value The value to set.
     */
    public final void setValue(final int value) {
        this.intProperty.set(value);
    }

    /**
     * @return the integer property.
     */
    public IntegerProperty intProperty() {
        return this.intProperty;
    }

}