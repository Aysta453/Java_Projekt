/*
 * Copyright (c) 2019. Wojciech Wrona
 * All rights reserved
 */

package GUI;

import Classes.TableLists;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ButtonWindow extends MainWindow {

    TableLists tableLists = new TableLists();
    TabContent tabContent = new TabContent();

    // string tables containing names of columns in tables
    static String[] MarkiFieldsNames = {"id", "nazwa", "rok_zalozenia", "siedziba", "ilosc_sprzedanych", "id_prezesa"};
    static String[] ModeleFieldsNames = {"id_modelu", "nazwa", "ilosc_sprzedanych", "rok_produkcji"};
    static String[] PrezesFieldsNames = {"id_prezesa", "imie","nazwisko", "pesel","wiek", "pochodzenie"};
    static String[] Dane_modeluFieldsNames = {"id", "id_modelu","moc", "pojemnosc","typ_nadwozia", "typ_silnika"};


    // method containing an array list of labels for specific table
    @NotNull
    private ArrayList<Label> MarkiLabels() {
        ArrayList<Label> arrayList = new ArrayList<>();

        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();

        arrayList.add(label);
        arrayList.add(label1);
        arrayList.add(label2);
        arrayList.add(label3);
        arrayList.add(label4);
        arrayList.add(label5);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setText(MarkiFieldsNames[i]);
        }

        return arrayList;
    }
    // method containing an array list of jfx text fields (custom imported fields) for specific table
    @NotNull
    private ArrayList<JFXTextField> MarkiTextField() {
        ArrayList<JFXTextField> arrayList = new ArrayList<>();

        JFXTextField jfxTextField = new JFXTextField();
        JFXTextField jfxTextField1 = new JFXTextField();
        JFXTextField jfxTextField2 = new JFXTextField();
        JFXTextField jfxTextField3 = new JFXTextField();
        JFXTextField jfxTextField4 = new JFXTextField();
        JFXTextField jfxTextField5 = new JFXTextField();

        arrayList.add(jfxTextField);
        arrayList.add(jfxTextField1);
        arrayList.add(jfxTextField2);
        arrayList.add(jfxTextField3);
        arrayList.add(jfxTextField4);
        arrayList.add(jfxTextField5);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setPromptText(MarkiFieldsNames[i]);
            arrayList.get(i).setLabelFloat(true);
        }

        return arrayList;
    }


    // method containing an array list of labels for specific table
    @NotNull
    private ArrayList<Label> ModeleLabels() {
        ArrayList<Label> arrayList = new ArrayList<>();

        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();

        arrayList.add(label);
        arrayList.add(label1);
        arrayList.add(label2);
        arrayList.add(label3);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setText(ModeleFieldsNames[i]);
        }

        return arrayList;
    }
    // method containing an array list of jfx text fields (custom imported fields) for specific table
    @NotNull
    private ArrayList<JFXTextField> ModeleTextFields() {
        ArrayList<JFXTextField> arrayList = new ArrayList<>();

        JFXTextField jfxTextField = new JFXTextField();
        JFXTextField jfxTextField1 = new JFXTextField();
        JFXTextField jfxTextField2 = new JFXTextField();
        JFXTextField jfxTextField3 = new JFXTextField();

        arrayList.add(jfxTextField);
        arrayList.add(jfxTextField1);
        arrayList.add(jfxTextField2);
        arrayList.add(jfxTextField3);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setPromptText(ModeleFieldsNames[i]);
            arrayList.get(i).setLabelFloat(true);
        }

        return arrayList;
    }


    // method containing an array list of labels for specific table
    @NotNull
    private ArrayList<Label> PrezesLabels() {
        ArrayList<Label> arrayList = new ArrayList<>();

        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();

        arrayList.add(label);
        arrayList.add(label1);
        arrayList.add(label2);
        arrayList.add(label3);
        arrayList.add(label4);
        arrayList.add(label5);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setText(PrezesFieldsNames[i]);
        }

        return arrayList;
    }
    // method containing an array list of jfx text fields (custom imported fields) for specific table
    @NotNull
    private ArrayList<JFXTextField> PrezesTextFields() {
        ArrayList<JFXTextField> arrayList = new ArrayList<>();

        JFXTextField jfxTextField = new JFXTextField();
        JFXTextField jfxTextField1 = new JFXTextField();
        JFXTextField jfxTextField2 = new JFXTextField();
        JFXTextField jfxTextField3 = new JFXTextField();
        JFXTextField jfxTextField4 = new JFXTextField();
        JFXTextField jfxTextField5 = new JFXTextField();

        arrayList.add(jfxTextField);
        arrayList.add(jfxTextField1);
        arrayList.add(jfxTextField2);
        arrayList.add(jfxTextField3);
        arrayList.add(jfxTextField4);
        arrayList.add(jfxTextField5);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setPromptText(PrezesFieldsNames[i]);
            arrayList.get(i).setLabelFloat(true);
        }

        return arrayList;
    }


    // method containing an array list of labels for specific table
    @NotNull
    private ArrayList<Label> Dane_modeluLabels() {
        ArrayList<Label> arrayList = new ArrayList<>();

        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();

        arrayList.add(label);
        arrayList.add(label1);
        arrayList.add(label2);
        arrayList.add(label3);
        arrayList.add(label4);
        arrayList.add(label5);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setText(Dane_modeluFieldsNames[i]);
        }

        return arrayList;
    }
    // method containing an array list of jfx text fields (custom imported fields) for specific table
    @NotNull
    private ArrayList<JFXTextField> Dane_modeluTextFields() {
        ArrayList<JFXTextField> arrayList = new ArrayList<>();

        JFXTextField jfxTextField = new JFXTextField();
        JFXTextField jfxTextField1 = new JFXTextField();
        JFXTextField jfxTextField2 = new JFXTextField();
        JFXTextField jfxTextField3 = new JFXTextField();
        JFXTextField jfxTextField4 = new JFXTextField();
        JFXTextField jfxTextField5 = new JFXTextField();

        arrayList.add(jfxTextField);
        arrayList.add(jfxTextField1);
        arrayList.add(jfxTextField2);
        arrayList.add(jfxTextField3);
        arrayList.add(jfxTextField4);
        arrayList.add(jfxTextField5);

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setPromptText(Dane_modeluFieldsNames[i]);
            arrayList.get(i).setLabelFloat(true);
        }

        return arrayList;
    }





    /*
        // Dynamic refresh table view to update elements that are displayed
        // This method invokes methods that create the tables
        // Method takes table view and string as an arguments where string is name of the method
    */
    public void refreshTableView(@NotNull TableView tableView, String string) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        tableView.getItems().removeAll();
        Method method = TabContent.class.getMethod(string, TableView.class);
        method.invoke(tabContent,tableView);
    }


    // Managing the height of scene
    private int SetSceneHeight() {
        int height=0;
        switch(MainGUI.getCurrentTab()) {
            case 0: {
                height = MarkiFieldsNames.length*50+100;
            } break;
            case 1: {
                height = ModeleFieldsNames.length*50+100;
            } break;
            case 2: {
                height = PrezesFieldsNames.length*50+100;
            } break;
            case 3: {
                height = Dane_modeluFieldsNames.length*50+100;
            } break;
            default:
                break;
        }
        return height;
    }

    // Creating stage for button windows
    private void CreateStage(Node node, String string) {
        Stage stage = new Stage();
        stage.setTitle(string);
        stage.getIcons().add(new Image("file:src/Files/Icons/icon.png"));
        Scene scene = new Scene((Parent) node, 500, SetSceneHeight());
        scene.getStylesheets().add("file:src/Files/styleCSS_dark.css");
        stage.setScene(scene);
        stage.show();
    }


    // Window for the Add button
    private  void runWindow(@NotNull ArrayList<Label> arrayList, ArrayList<JFXTextField> arrayList1, GridPane gridPane) {

        for (int i = 0; i < arrayList.size(); i++) {
            GridPane.setHalignment(arrayList.get(i),HPos.CENTER);
            gridPane.add(arrayList.get(i),0,i);
        }

        for (int i = 0; i < arrayList1.size(); i++) {
            GridPane.setHalignment(arrayList1.get(i),HPos.CENTER);
            gridPane.add(arrayList1.get(i),1,i);
        }

        JFXButton jfxButton = new JFXButton("Add");
        gridPane.add(jfxButton,2,arrayList.size()+1);

        jfxButton.setOnAction(actionEvent -> {
            switch(MainGUI.getCurrentTab()) {
                case 0: {
                    tableLists.addMarkiArrayList(arrayList1);
                    try {
                        refreshTableView(tableView,"MarkiTableView");
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } break;
                case 1: {
                    tableLists.addModeleArrayList(arrayList1);
                    try {
                        refreshTableView(tableView1,"ModeleTableView");
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } break;
                case 2: {
                    tableLists.addPrezesArrayList(arrayList1);
                    try {
                        refreshTableView(tableView2,"PrezesTableView");
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } break;
                case 3: {
                    tableLists.addDane_modeluArrayList(arrayList1);
                    try {
                        refreshTableView(tableView3,"Dane_modeluTableView");
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } break;
                default:
                    break;
            }
        });

    }

    // Windows for the Replace button
    private void runWindow1(@NotNull ArrayList<Label> arrayList, ArrayList<JFXTextField> arrayList1, GridPane gridPane) {

        TableLists tableLists = new TableLists();

        for (int i = 0; i < arrayList.size(); i++) {
            GridPane.setHalignment(arrayList.get(i),HPos.CENTER);
            gridPane.add(arrayList.get(i),0,i);
        }

        for (int i = 0; i < arrayList1.size(); i++) {
            GridPane.setHalignment(arrayList1.get(i),HPos.CENTER);
            gridPane.add(arrayList1.get(i),1,i);
        }

        JFXButton jfxButton = new JFXButton("Replace");
        gridPane.add(jfxButton,2,arrayList.size()+1);

        jfxButton.setOnAction(actionEvent -> {
            switch(MainGUI.getCurrentTab()) {
                    case 0: {
                        tableLists.replaceMarkiArrayList(arrayList1);
                        try {
                            refreshTableView(tableView,"MarkiTableView");
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } break;
                    case 1: {
                        tableLists.replaceModeleArrayList(arrayList1);
                        try {
                            refreshTableView(tableView1,"ModeleTableView");
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } break;
                    case 2: {
                        tableLists.replacePrezesArrayList(arrayList1);
                        try {
                            refreshTableView(tableView2,"PrezesTableView");
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } break;
                    case 3: {
                        tableLists.replaceDane_modeluArrayList(arrayList1);
                        try {
                            refreshTableView(tableView3,"Dane_modeluTableView");
                        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } break;
                    default:
                        break;
                }
        });

    }


    // Creating window depending on which table is selected
    public void Window() {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(10));

        CreateStage(gridPane,"Add data");

        ColumnConstraints columnConstraints = new ColumnConstraints(100);
        ColumnConstraints columnConstraints1 = new ColumnConstraints(250);
        ColumnConstraints columnConstraints2 = new ColumnConstraints(75);
        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints1,columnConstraints2);

        switch(MainGUI.getCurrentTab()) {
            case 0: {
                runWindow(MarkiLabels(),MarkiTextField(),gridPane);
            } break;
            case 1: {
                runWindow(ModeleLabels(),ModeleTextFields(),gridPane);
            } break;
            case 2: {
                runWindow(PrezesLabels(),PrezesTextFields(),gridPane);
            } break;
            case 3: {
                runWindow(Dane_modeluLabels(),Dane_modeluTextFields(),gridPane);
            } break;
            default: {
                System.err.println("error");
            }break;
        }

    }

    // Creating window depending on which table is selected
    public void Window1() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(10));

        CreateStage(gridPane, "Replace data");

        ColumnConstraints columnConstraints = new ColumnConstraints(100);
        ColumnConstraints columnConstraints1 = new ColumnConstraints(250);
        ColumnConstraints columnConstraints2 = new ColumnConstraints(100);
        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints1,columnConstraints2);

        switch(MainGUI.getCurrentTab()) {
            case 0: {
                runWindow(MarkiLabels(),MarkiTextField(),gridPane);
            } break;
            case 1: {
                runWindow(ModeleLabels(),ModeleTextFields(),gridPane);
            } break;
            case 2: {
                runWindow(PrezesLabels(),PrezesTextFields(),gridPane);
            } break;
            case 3: {
                runWindow(Dane_modeluLabels(),Dane_modeluTextFields(),gridPane);
            } break;
            default: {
                System.err.println("error");
            }break;
        }

    }

}
