package edu.cpp.cs356.assignment2;

import javafx.scene.control.TreeItem;

/**
 * Created by wxy03 on 7/9/2017.
 */
public class ComponentTreeItem extends TreeItem {

    private Component component;

    public ComponentTreeItem(Component component)
    {
        this.component = component;
        if(component instanceof User)
            setValue("[U] "+component.getID());
        else if(component instanceof  UserGroup) {
            setValue("[G] " + component.getID());
            setExpanded(true);
        }
    }

    public Component getComponent() {
        return component;
    }
}
