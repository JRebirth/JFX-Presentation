package org.jrebirth.presentation.javafx.ui.slides.property;

public class JavaBean {

    /** The bean integer value. */
    private int value;

    /**
     * @param value The value to set.
     */
    public final void setValue(final int value) {
        this.value = value;
    }

    /**
     * @return Returns the value.
     */
    public final int getValue() {
        return this.value;
    }
}