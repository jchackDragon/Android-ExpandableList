package com.socrates.espandablelist;

/**
 * Created by juancarloslopez on 6/10/16.
 */
import java.util.ArrayList;
import java.util.List;

public class Group {




    public  List<Child> children = new ArrayList<Child>();

    public Group(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    public String string;

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Child> getChildren() {
        return children;
    }

}