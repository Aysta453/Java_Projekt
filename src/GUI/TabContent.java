/*
 * Copyright (c) 2019. Wojciech Wrona
 * All rights reserved
 */

package GUI;

import Classes.TableLists;
import EntityClasses.*;
import DAO.HibernateUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class TabContent extends TableLists implements TableViewInterfaceConnect {
    HibernateUtil hibernateUtil = new HibernateUtil();
    TableLists tableLists = new TableLists();

    ObservableList<Marki> markiList=FXCollections.observableArrayList();
    ObservableList<Modele> modeleList=FXCollections.observableArrayList();
    ObservableList<Prezes> prezesList=FXCollections.observableArrayList();
    ObservableList<Dane_modelu> dane_ModeluList=FXCollections.observableArrayList();


    public ObservableList<Marki> getMarkiList() {
        return markiList;
    }

    public void setMarkiList(ObservableList<Marki> markiList) {
        this.markiList = markiList;
    }

    public ObservableList<Modele> getModeleList() {
        return modeleList;
    }

    public void setModeleList(ObservableList<Modele> modeleList) {
        this.modeleList = modeleList;
    }

    public ObservableList<Prezes> getPrezesList() {
        return prezesList;
    }

    public void setPrezesList(ObservableList<Prezes> prezesList) {
        this.prezesList = prezesList;
    }

    public ObservableList<Dane_modelu> getDane_ModeluList() {
        return dane_ModeluList;
    }

    public void setDane_ModeluList(ObservableList<Dane_modelu> dane_ModeluList) {
        this.dane_ModeluList = dane_ModeluList;
    }

    // Observable list type method for specific table return observable list that is type of specific table/class
    @NotNull
    public ObservableList<Marki> AddMarkiDataToList() {
        tableLists.setMarkiArrayList((ArrayList<Marki>) hibernateUtil.openCurrentSession().createCriteria(Marki.class).list());
        markiList.addAll(tableLists.getMarkiArrayList());
        return markiList;
    }

    // Observable list type method for specific table return observable list that is type of specific table/class
    @NotNull
    public ObservableList<Modele> AddModeleDataToList() {
        tableLists.setModeleArrayList((ArrayList<Modele>) hibernateUtil.openCurrentSession().createCriteria(Modele.class).list());
        modeleList.addAll(tableLists.getModeleArrayList());
        return modeleList;
    }

    // Observable list type method for specific table return observable list that is type of specific table/class
    @NotNull
    public ObservableList<Prezes> AddPrezesDataToList() {
        tableLists.setPrezesArrayList((ArrayList<Prezes>) hibernateUtil.openCurrentSession().createCriteria(Prezes.class).list());
        prezesList.addAll(tableLists.getPrezesArrayList());
        return prezesList;
    }

    // Observable list type method for specific table return observable list that is type of specific table/class
    @NotNull
    public ObservableList<Dane_modelu> AddDane_modeluDataToList() {
        tableLists.setDane_modeluArrayList((ArrayList<Dane_modelu>) hibernateUtil.openCurrentSession().createCriteria(Dane_modelu.class).list());
        dane_ModeluList.addAll(tableLists.getDane_modeluArrayList());
        return dane_ModeluList;
    }



    // Method creating table view for specific table implemented from interface
    @Override
    public void MarkiTableView(@NotNull TableView tableView) {
        TableColumn<Integer, Marki> column0 = new TableColumn<>("Id");
        TableColumn<String, Marki> column1 = new TableColumn<>("nazwa");
        TableColumn<Integer, Marki> column2 = new TableColumn<>("rok_zalozenia");
        TableColumn<String, Marki> column3 = new TableColumn<>("siedziba");
        TableColumn<Integer, Marki> column4 = new TableColumn<>("ilosc_sprzedanych");
        TableColumn<Integer, Marki> column5 = new TableColumn<>("id_prezesa");

        column0.setCellValueFactory(new PropertyValueFactory<>("id"));
        column1.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        column2.setCellValueFactory(new PropertyValueFactory<>("rok_zalozenia"));
        column3.setCellValueFactory(new PropertyValueFactory<>("siedziba"));
        column4.setCellValueFactory(new PropertyValueFactory<>("ilosc_sprzedanych"));
        column5.setCellValueFactory(new PropertyValueFactory<>("id_prezesa"));

        tableView.getColumns().clear();
        tableView.setItems(AddMarkiDataToList());
        tableView.getColumns().addAll(column0, column1, column2, column3, column4, column5);

    }

    // Method creating table view for specific table implemented from interface
    @Override
    public void ModeleTableView(@NotNull TableView tableView) {
        TableColumn<Integer, Modele> column0 = new TableColumn<>("id_modelu");
        TableColumn<String, Modele> column1 = new TableColumn<>("nazwa");
        TableColumn<Integer, Modele> column2 = new TableColumn<>("ilosc_egzemplarzy");
        TableColumn<Integer, Modele> column3 = new TableColumn<>("rok_produkcji");


        column0.setCellValueFactory(new PropertyValueFactory<>("id_modelu"));
        column1.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        column2.setCellValueFactory(new PropertyValueFactory<>("ilosc_egzemplarzy"));
        column3.setCellValueFactory(new PropertyValueFactory<>("rok_produkcji"));


        tableView.getColumns().clear();
        tableView.setItems(AddModeleDataToList());

        tableView.getColumns().addAll(column0, column1, column2, column3);


    }

    // Method creating table view for specific table implemented from interface
    @Override
    public void PrezesTableView(@NotNull TableView tableView) {
        TableColumn<Integer, Prezes> column0 = new TableColumn<>("id_prezesa");
        TableColumn<String, Prezes> column1 = new TableColumn<>("imie");
        TableColumn<String, Prezes> column2 = new TableColumn<>("nazwisko");
        TableColumn<String, Prezes> column3 = new TableColumn<>("pesel");
        TableColumn<Integer, Prezes> column4 = new TableColumn<>("wiek");
        TableColumn<String, Prezes> column5 = new TableColumn<>("pochodzenie");

        column0.setCellValueFactory(new PropertyValueFactory<>("id_prezesa"));
        column1.setCellValueFactory(new PropertyValueFactory<>("imie"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        column3.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        column4.setCellValueFactory(new PropertyValueFactory<>("wiek"));
        column5.setCellValueFactory(new PropertyValueFactory<>("pochodzenie"));

        tableView.getColumns().clear();
        tableView.setItems(AddPrezesDataToList());

        tableView.getColumns().addAll(column0, column1, column2, column3, column4,column5);


    }

    // Method creating table view for specific table implemented from interface
    @Override
    public void Dane_modeluTableView(@NotNull TableView tableView) {
        TableColumn<Integer, Dane_modelu> column0 = new TableColumn<>("id");
        TableColumn<Integer, Dane_modelu> column1 = new TableColumn<>("id_modelu");
        TableColumn<Integer, Dane_modelu> column2 = new TableColumn<>("moc");
        TableColumn<Integer, Dane_modelu> column3 = new TableColumn<>("pojemnosc");
        TableColumn<String, Dane_modelu> column4 = new TableColumn<>("typ_nadwozia");
        TableColumn<String, Dane_modelu> column5 = new TableColumn<>("typ_silnika");

        column0.setCellValueFactory(new PropertyValueFactory<>("id"));
        column1.setCellValueFactory(new PropertyValueFactory<>("id_modelu"));
        column2.setCellValueFactory(new PropertyValueFactory<>("moc"));
        column3.setCellValueFactory(new PropertyValueFactory<>("pojemnosc"));
        column4.setCellValueFactory(new PropertyValueFactory<>("typ_nadwozia"));
        column5.setCellValueFactory(new PropertyValueFactory<>("typ_silnika"));

        tableView.getColumns().clear();
        tableView.setItems(AddDane_modeluDataToList());

        tableView.getColumns().addAll(column0, column1,column2,column3,column4,column5);


    }

}
