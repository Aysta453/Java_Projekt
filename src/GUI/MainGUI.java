/*
 * Copyright (c) 2019. Wojciech Wrona
 * All rights reserved
 */

package GUI;

import DAO.HibernateUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class MainGUI extends Application {
    public static JFXTabPane jfxTabPane;
    public static VBox vBox;
    public static Stage stage;

    // return index of current tab
    public static int getCurrentTab() {
        return jfxTabPane.getSelectionModel().getSelectedIndex();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        MainGUI.stage = stage;
    }

    // main method launching the application
    public static void MainFunction() {
        launch();
    }


    @Override
    public void start(@NotNull Stage primaryStage) {
        setStage(primaryStage);
        //getting rid of hibernate build logs
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        //opening hibernate connection
        HibernateUtil.OpenConnection("hibernate.cfg.xml");

        //setting css styling for the application
        Application.setUserAgentStylesheet("file:src/Files/styleCSS_dark.css");

        //setting attributes for primaryStage main window
        primaryStage.setTitle("Company database");
        primaryStage.getIcons().add(new Image("file:src/Files/Icons/database-1.png"));


        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1280, 720, Color.WHITE);
        vBox = new VBox();
        MainWindow.V_BOX(vBox);

        jfxTabPane = new JFXTabPane();
        MainWindow.JFX_TAB_PANE(jfxTabPane);

        root.setTop(vBox);
        root.setCenter(jfxTabPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
