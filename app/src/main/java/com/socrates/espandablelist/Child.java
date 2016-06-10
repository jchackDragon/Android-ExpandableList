package com.socrates.espandablelist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juancarloslopez on 6/10/16.
 */
public class Child {

    public Boolean isChecked = false;

    public Child(String string) {
        this.string = string;
    }

    public Boolean isCheChecked() {
        return isChecked;
    }

    @Override
    public String toString() {
        return string;
    }

    public String string;

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
