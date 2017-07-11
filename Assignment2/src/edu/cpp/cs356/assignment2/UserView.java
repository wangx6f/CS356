package edu.cpp.cs356.assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by wxy03 on 7/10/2017.
 */
public class UserView implements Observer {

    private Server mServer;

    private User mUser;

    private ObservableList followingObservableList;

    private ObservableList tweetObservableList;

    public UserView(Server server, User thisUser)
    {
        mServer=server;
        mUser=thisUser;
        updateFollowingInfo();

    }

    public void showUserWindows() {

        BorderPane root = new BorderPane();
        root.setCenter(initializeUI());
        Scene scene = new Scene(root,AdminControlPanel.SCENE_WIDTH,AdminControlPanel.SCENE_HEIGHT);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle(mUser.getID());
        newStage.show();



    }

    private Node initializeUI()
    {

        TextField userIDInput = new TextField("User ID");
        Button followUser = new Button("Follow User");
        followUser.setOnMouseClicked(event -> {
            follow(userIDInput.getText());
        });
        HBox followUserBox = new HBox(AdminControlPanel.SPACING);
        followUserBox.getChildren().addAll(userIDInput,followUser);

        ListView followingListView = new ListView(followingObservableList);

        VBox mainBox = new VBox(AdminControlPanel.SPACING);
        mainBox.setPadding(new Insets(AdminControlPanel.SPACING));
        mainBox.getChildren().addAll(followUserBox,followingListView);

        return mainBox;



    }

    private void follow(String userID)
    {
        try {
            mUser.follow(mServer.getUserByID(userID));
            updateFollowingInfo();
        }catch (ServerException e)
        {
            showAlert(e.getMessage());
        }
    }

    private void updateFollowingInfo()
    {
        List<String> userIDList = new ArrayList<>();
        List<String> tweetList = new ArrayList<>();
        for(User followingUser:mUser.getFollowingList())
        {
            userIDList.add(followingUser.getID());
            for(Tweet tweet:followingUser.getAllTweets())
                tweetList.add(formatTweet(tweet));
        }
        for(Tweet tweet:mUser.getAllTweets())
            tweetList.add(formatTweet(tweet));

        Collections.sort(tweetList);

        if(followingObservableList == null)
            followingObservableList = FXCollections.observableList(userIDList);
        else
            followingObservableList.setAll(FXCollections.observableList(userIDList));

        if(tweetObservableList == null)
            tweetObservableList = FXCollections.observableList(tweetList);
        else
            tweetObservableList.setAll(FXCollections.observableList(tweetList));
    }


    private String formatTweet(Tweet tweet)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("["+tweet.getDateTime().toString()+"] ");
        stringBuilder.append(tweet.getUserID()+": ");
        stringBuilder.append(tweet.getContent());
        return stringBuilder.toString();

    }

    private void showAlert(String message)
    {
        new Alert(Alert.AlertType.WARNING,message).show();
    }

    @Override
    public void update(Intent intent) {

    }

}
