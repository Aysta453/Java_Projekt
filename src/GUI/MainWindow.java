/*
 * Copyright (c) 2019. Wojciech Wrona
 * All rights reserved
 */

package GUI;

import Classes.TableLists;
import EntityClasses.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import DAO.*;
import javafx.application.Application;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Predicate;

public class MainWindow extends TableLists{

    // Table View declarations
    static TableView tableView = new TableView();
    static TableView tableView1 = new TableView();
    static TableView tableView2 = new TableView();
    static TableView tableView3 = new TableView();


    // Returns currently selected row
    public int getSelectedRow(@NotNull TableView tableView) {
        return tableView.getSelectionModel().getSelectedIndex();
    }

    // Method for delete button
    public void deleteButtonAction() {
        ButtonWindow buttonWindow = new ButtonWindow();

        MarkiDAO markiDAO= new MarkiDAO();
        ModeleDAO modeleDAO = new ModeleDAO();
        PrezesDAO prezesDAO = new PrezesDAO();
        Dane_modeluDAO dane_modeluDAO = new Dane_modeluDAO();


        switch(MainGUI.getCurrentTab()) {
            case 0: {
                if(this.getSelectedRow(tableView)==tableView.getItems().size()) {
                    markiDAO.delete(markiDAO.findById((this.getSelectedRow(tableView))));
                }
                markiDAO.delete(markiDAO.findById(this.getSelectedRow(tableView) + 1));

                try {
                    buttonWindow.refreshTableView(tableView,"MarkiTableView");
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } break;
            case 1: {
                if(this.getSelectedRow(tableView1)==tableView1.getItems().size()) {
                    modeleDAO.delete(modeleDAO.findById((this.getSelectedRow(tableView1))));
                }
                modeleDAO.delete(modeleDAO.findById(this.getSelectedRow(tableView1) + 1));
                try {
                    buttonWindow.refreshTableView(tableView1,"ModeleTableView");
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } break;
            case 2: {
                if(this.getSelectedRow(tableView2)==tableView2.getItems().size()) {
                    prezesDAO.delete(prezesDAO.findById((this.getSelectedRow(tableView2))));
                }
                prezesDAO.delete(prezesDAO.findById(this.getSelectedRow(tableView2) + 1));

                try {
                    buttonWindow.refreshTableView(tableView2,"PrezesTableView");
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } break;
            case 3: {
                if(this.getSelectedRow(tableView3)==tableView3.getItems().size()) {
                    dane_modeluDAO.delete(dane_modeluDAO.findById((this.getSelectedRow(tableView3))));
                }
                dane_modeluDAO.delete(dane_modeluDAO.findById(this.getSelectedRow(tableView3) + 1));

                try {
                    buttonWindow.refreshTableView(tableView3,"Dane_modeluTableView");
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } break;
            default:
                break;
        }
    }

    // Method for search field
    public void searchField(JFXTextField textField) {
        TabContent tabContent = new TabContent();
        switch(MainGUI.getCurrentTab()) {
            case 0: {
                tabContent.AddMarkiDataToList();
                FilteredList<Marki> filteredList = new FilteredList<>(tabContent.getMarkiList(), e -> true);
                textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
                    filteredList.setPredicate((Predicate<? super Marki>) marki -> {
                        if(newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        if (String.valueOf(marki.getId()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(marki.getNazwa()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(marki.getRok_zalozenia()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(marki.getSiedziba()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(marki.getIlosc_sprzedanych()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(marki.getId_prezesa()).contains(newValue)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<Marki> sortedList = new SortedList<>(filteredList);
                sortedList.comparatorProperty().bind(tableView.comparatorProperty());
                tableView.setItems(sortedList);
            } break;
            case 1: {
                tabContent.AddModeleDataToList();
                FilteredList<Modele> filteredList = new FilteredList<>(tabContent.getModeleList(), e -> true);
                textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
                    filteredList.setPredicate((Predicate<? super Modele>) modele -> {
                        if(newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        if (String.valueOf(modele.getId_modelu()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(modele.getNazwa()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(modele.getIlosc_egzemplarzy()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(modele.getRok_produkcji()).contains(newValue)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<Modele> sortedList = new SortedList<>(filteredList);
                sortedList.comparatorProperty().bind(tableView1.comparatorProperty());
                tableView1.setItems(sortedList);
            } break;
            case 2: {
                tabContent.AddPrezesDataToList();
                FilteredList<Prezes> filteredList = new FilteredList<>(tabContent.getPrezesList(), e -> true);
                textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
                    filteredList.setPredicate((Predicate<? super Prezes>) prezes -> {
                        if(newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        if (String.valueOf(prezes.getId_prezesa()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(prezes.getImie()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(prezes.getNazwisko()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(prezes.getPesel()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(prezes.getWiek()).contains(newValue)) {
                            return true;
                        }else if (String.valueOf(prezes.getPochodzenie()).contains(newValue)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<Prezes> sortedList = new SortedList<>(filteredList);
                sortedList.comparatorProperty().bind(tableView2.comparatorProperty());
                tableView2.setItems(sortedList);
            } break;
            case 3: {
                tabContent.AddDane_modeluDataToList();
                FilteredList<Dane_modelu> filteredList = new FilteredList<>(tabContent.getDane_ModeluList(), e -> true);
                textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
                    filteredList.setPredicate((Predicate<? super Dane_modelu>) dane_modelu -> {
                        if(newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        if (String.valueOf(dane_modelu.getId()).contains(newValue)) {
                            return true;
                        }else if (String.valueOf(dane_modelu.getId_modelu()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(dane_modelu.getMoc()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(dane_modelu.getPojemnosc()).contains(newValue)){
                            return true;
                        } else if (String.valueOf(dane_modelu.getTyp_nadwozia()).contains(newValue)) {
                            return true;
                        } else if (String.valueOf(dane_modelu.getTyp_silnika()).contains(newValue)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<Dane_modelu> sortedList = new SortedList<>(filteredList);
                sortedList.comparatorProperty().bind(tableView3.comparatorProperty());
                tableView3.setItems(sortedList);
            } break;
            default:
                break;
        }
    }

    // Created menu bar
    private static void MENU_BAR(@NotNull VBox vBox) {
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("About");
        MenuItem menuItem4 = new MenuItem("Licence");
        MenuItem menuItem = new MenuItem("About");
        menu.getItems().addAll(menuItem, new SeparatorMenuItem(), menuItem4);


        Menu menu1 = new Menu("Copyright");
        MenuItem menuItem1 = new MenuItem("Copyright");
        menu1.getItems().add(menuItem1);


        Menu menu2 = new Menu("Theme");
        MenuItem menuItem2 = new MenuItem("Light");
        MenuItem menuItem3 = new MenuItem("Dark");
        menu2.getItems().addAll(menuItem2,menuItem3);

        menuBar.getMenus().addAll(menu,menu1,menu2);
        vBox.getChildren().add(menuBar);

        menuItem.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(MainGUI.getStage());
            alert.setTitle("About");
            alert.setHeaderText("");
            alert.setContentText("Program to control database in Java by using JavaFX GUI");
            Image image = new Image("file:src/Files/Icons/info.png");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(64);
            imageView.setFitHeight(64);
            alert.setGraphic(imageView);
            alert.showAndWait();
        });

        menuItem1.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(MainGUI.getStage());
            alert.setTitle("Copyright");
            alert.setHeaderText("");
            alert.setContentText("Copyright (c) 2020 Wojciech Wrona\nAll rights reserved");
            Image image = new Image("file:src/Files/Icons/info.png");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(64);
            imageView.setFitHeight(64);
            alert.setGraphic(imageView);
            alert.showAndWait();
        });

        menuItem2.setOnAction(actionEvent -> {
            String formatCSS = "file:src/Files/styleCSS_light.css";
            Application.setUserAgentStylesheet(formatCSS);
        });

        menuItem3.setOnAction(actionEvent -> {
            String formatCSS = "file:src/Files/styleCSS_dark.css";
            Application.setUserAgentStylesheet(formatCSS);
        });

        menuItem4.setOnAction(actionEvent -> {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.edit(new File("src/Files/LICENSE.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Created anchor pane with button and search field
    private static void ANCHOR_PANE(@NotNull VBox vBox) {
        ButtonWindow buttonWindow = new ButtonWindow();
        MainWindow mainWindow = new MainWindow();
        AnchorPane anchorPane = new AnchorPane();

        JFXButton jfxButton = new JFXButton("Add");
        JFXButton jfxButton1 = new JFXButton("Remove");
        JFXButton jfxButton2 = new JFXButton("Change data");

        Image image = new Image("file:src/Files/Icons/search-1.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(28);
        imageView.setFitHeight(28);

        JFXTextField jfxTextField = new JFXTextField();
        jfxTextField.promptTextProperty().set("Search");
        jfxTextField.setLabelFloat(true);
        jfxTextField.setPrefWidth(350);
        jfxTextField.setMinWidth(jfxTextField.getPrefWidth());
        jfxTextField.setMaxWidth(jfxTextField.getPrefWidth());

        HBox hBox = new HBox(1,jfxButton,jfxButton1,jfxButton2);
        HBox hBox1 = new HBox(5,imageView,jfxTextField);

        anchorPane.getChildren().addAll(hBox,hBox1);
        AnchorPane.setLeftAnchor(hBox,10d);
        AnchorPane.setRightAnchor(hBox1, 10d);
        AnchorPane.setBottomAnchor(hBox1, 10d);

        vBox.getChildren().add(anchorPane);

        jfxButton.setOnAction(actionEvent -> {
            buttonWindow.Window();
        });

        jfxButton1.setOnAction(actionEvent -> {
            mainWindow.deleteButtonAction();
        });

        jfxButton2.setOnAction(actionEvent -> {
            buttonWindow.Window1();
        });

        jfxTextField.setOnKeyPressed(keyEvent -> {
            mainWindow.searchField(jfxTextField);
        });

    }

    // Created VBox to store menu bar and anchor pane
    // Also it can be easily scaled up since it's v boc
    public static void V_BOX(@NotNull VBox vBox) {
        vBox.setSpacing(1);
        MENU_BAR(vBox);
        ANCHOR_PANE(vBox);

    }

    // Created tab pane
    public static void JFX_TAB_PANE(@NotNull JFXTabPane jfxTabPane) {
        TabContent tabContent = new TabContent();
        jfxTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tab = new Tab("Marki");
        Tab tab1 = new Tab("Modele");
        Tab tab2= new Tab("Prezes");
        Tab tab3 = new Tab("Dane_modelu");
        Tab tab4 = new Tab("Position");
        Tab tab5 = new Tab("Employees");
        Tab tab6 = new Tab("Address");

        jfxTabPane.getTabs().addAll(tab,tab1,tab2,tab3,tab4,tab5,tab6);

        tabContent.MarkiTableView(tableView);
        tabContent.ModeleTableView(tableView1);
        tabContent.PrezesTableView(tableView2);
        tabContent.Dane_modeluTableView(tableView3);


        tab.setContent(tableView);
        tab1.setContent(tableView1);
        tab2.setContent(tableView2);
        tab3.setContent(tableView3);


    }

}
