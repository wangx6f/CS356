package edu.cpp.cs356.assignment2;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


/**
 * Created by Xinyuan Wang on 7/9/2017.
 */
public class TreeViewController  implements Observer{


    private TreeView treeView;

    private Component root;

    public TreeViewController(TreeView treeView,Component root)
    {
        this.treeView = treeView;
        this.root = root;
       treeView.setRoot(construct());
    }


    @Override
    public void update(Intent intent) {

        treeView.setRoot(construct());

    }

    private TreeItem construct()
    {
        return construct(root);
    }

    private TreeItem construct(Component rootComponent)
    {
        TreeItem rootItem = createItem(rootComponent);
        if(rootComponent.getChildren()!=null) {
            for (Component child : rootComponent.getChildren())
            {
                    rootItem.getChildren().add(construct(child));
            }
        }
        return rootItem;
    }


    private TreeItem createItem(Component component)
    {
       return new ComponentTreeItem(component);

    }

}
