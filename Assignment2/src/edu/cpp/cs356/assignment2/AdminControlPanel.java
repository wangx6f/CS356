package edu.cpp.cs356.assignment2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Xinyuan Wang on 7/8/2017.
 */
public class AdminControlPanel extends Application {

    final private int SCENE_HEIGHT = 500;
    final private int SCENE_WIDTH = 600;
    final private double SPACING = 20f;
    final private double GAP_SPACING = 100f;

    private Server mServer;

    private TreeView treeView;



    @Override
    public void start(Stage primaryStage) throws Exception {

        mServer = TwitterServer.getInstance();
        primaryStage.setScene(initializeUI());
        primaryStage.show();




    }

    private Scene initializeUI()
    {

        initializeTreeView();




        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(treeView);
        borderPane.setCenter(initializeControlArea());
        Scene scene = new Scene(borderPane,SCENE_WIDTH,SCENE_HEIGHT);
        return scene;
    }


    private void initializeTreeView()
    {
        treeView = new TreeView();
        TreeViewController treeViewController = new TreeViewController(treeView,mServer.getRoot());
        ((Observable)mServer).attachObserver(treeViewController);
        treeView.getSelectionModel().selectFirst();
    }

    private Node initializeControlArea()
    {
        TextField inputUserID = new TextField("User ID");
        Button addUser = new Button("Add User");
        addUser.setOnMouseClicked(event -> {
            this.addNewComponent(new User(inputUserID.getText()));
        });
        HBox addUserBox = new HBox(SPACING);
        addUserBox.getChildren().addAll(inputUserID,addUser);

        TextField inputGroupID = new TextField("Group ID");
        Button addGroup = new Button("Add Group");
        HBox addUserGroupBox = new HBox(SPACING);
        addUserGroupBox.getChildren().addAll(inputGroupID,addGroup);

        Button userView = new Button("Open User View");

        VBox topBox = new VBox(SPACING);
        topBox.setPadding(new Insets(SPACING));
        topBox.getChildren().addAll(addUserBox,addUserGroupBox,userView);

        VBox mainBox = new VBox(GAP_SPACING);
        mainBox.getChildren().addAll(topBox);

        return mainBox;

    }

    private Component getSelectedComponent()
    {
        ComponentTreeItem selected = (ComponentTreeItem) treeView.getSelectionModel().getSelectedItem();
        if(selected==null)
            return null;
        else
            return selected.getComponent();
    }

    private void addNewComponent(Component newComponent)
    {

        if(newComponent.getID().isEmpty())
        {
            showAlert("Please enter new user ID.");
        }
        else if(getSelectedComponent()==null)
        {
            showAlert("Please Select a group.");
        }
        else
        {
            try{
                mServer.addComponent(newComponent,getSelectedComponent());
            } catch (ServerException e) {
                showAlert(e.getMessage());
            }

        }
    }


    private void showAlert(String message)
    {
        new Alert(Alert.AlertType.WARNING,message).show();
    }



}
