/*
 * Copyright (c) 2019. Wojciech Wrona
 * All rights reserved
 */

package Classes;

import EntityClasses.*;
import com.jfoenix.controls.JFXTextField;
import DAO.*;
import com.sun.webkit.Timer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Query;
import java.util.ArrayList;

public class TableLists {

    MarkiDAO markiDAO=new MarkiDAO();
    ModeleDAO modeleDAO=new ModeleDAO();
    PrezesDAO prezesDAO= new PrezesDAO();
    Dane_modeluDAO dane_modeluDAO=new Dane_modeluDAO();



    // Array lists storing information about currently added record and all record while reading from data base
    ArrayList<Marki>  markiArrayList = new ArrayList<>();
    ArrayList<Modele> modeleArrayList = new ArrayList<>();
    ArrayList<Prezes> prezesArrayList = new ArrayList<>();
    ArrayList<Dane_modelu> dane_modeluArrayList = new ArrayList<>();


    // setters and getters for the array lists


    public ArrayList<Marki> getMarkiArrayList() {
        return markiArrayList;
    }

    public void setMarkiArrayList(ArrayList<Marki> markiArrayList) {
        this.markiArrayList = markiArrayList;
    }

    public ArrayList<Modele> getModeleArrayList() {
        return modeleArrayList;
    }

    public void setModeleArrayList(ArrayList<Modele> modeleArrayList) {
        this.modeleArrayList = modeleArrayList;
    }

    public ArrayList<Prezes> getPrezesArrayList() {
        return prezesArrayList;
    }

    public void setPrezesArrayList(ArrayList<Prezes> prezesArrayList) {
        this.prezesArrayList = prezesArrayList;
    }

    public ArrayList<Dane_modelu> getDane_modeluArrayList() {
        return dane_modeluArrayList;
    }

    public void setDane_modeluArrayList(ArrayList<Dane_modelu> dane_modeluArrayList) {
        this.dane_modeluArrayList = dane_modeluArrayList;
    }

    // This method return table specific data type and sets it to whatever end user decides to
    @NotNull
    @Contract("_, _ -> param1")
    private Marki MarkiData(@NotNull Marki d, @NotNull ArrayList<JFXTextField> arrayList) {
        d.setId(Integer.parseInt(arrayList.get(0).getText()));
        d.setNazwa(arrayList.get(1).getText());
        d.setRok_zalozenia(Integer.parseInt(arrayList.get(2).getText()));
        d.setSiedziba(arrayList.get(3).getText());
        d.setIlosc_sprzedanych(Integer.parseInt(arrayList.get(4).getText()));
        d.setId_prezesa(Integer.parseInt(arrayList.get(5).getText()));
        return d;
    }

    // This method saves the input from user in gui
    // It takes an jfx text field type array list
    public void addMarkiArrayList(ArrayList<JFXTextField> arrayList) {
        Marki d = new Marki();
        MarkiData(d,arrayList);
        markiDAO.save(d);
    }

    // This method changes data in selected row with the input from user in gui
    // It takes an jfx text field type array list
    // To replace data it's using native query update
    public void replaceMarkiArrayList(@NotNull ArrayList<JFXTextField> arrayList) {

        String hql = "update Marki m " +
                "set nazwa = :nazwa2, rok_zalozenia = :rok_zalozenia2, siedziba = :siedziba2, ilosc_sprzedanych = :ilosc_sprzedanych2, id_prezesa = :id_prezesa2 " +
                "where id = :id2";

        Query query1 = markiDAO.openCurrentSessionwithTransaction().createQuery(hql)
                .setParameter("id2",Integer.parseInt(arrayList.get(0).getText()))
                .setParameter("nazwa2", Integer.parseInt(arrayList.get(1).getText()))
                .setParameter("rok_zalozenia2", Integer.parseInt(arrayList.get(2).getText()))
                .setParameter("siedziba2", Integer.parseInt(arrayList.get(3).getText()))
                .setParameter("ilosc_sprzedanych2", Integer.parseInt(arrayList.get(4).getText()))
                .setParameter("id_prezesa2", Integer.parseInt(arrayList.get(5).getText()));

        query1.executeUpdate();
        markiDAO.getCurrentTransaction().commit();
    }


    // This method return table specific data type and sets it to whatever end user decides to
    @NotNull
    @Contract("_, _ -> param1")
    private Modele ModeleData(@NotNull Modele d, @NotNull ArrayList<JFXTextField> arrayList) {
        d.setId_modelu(Integer.parseInt(arrayList.get(0).getText()));
        d.setNazwa(arrayList.get(1).getText());
        d.setIlosc_egzemplarzy(Integer.parseInt(arrayList.get(2).getText()));
        d.setRok_produkcji(Integer.parseInt(arrayList.get(3).getText()));
        return d;
    }

    // This method saves the input from user in gui
    // It takes an jfx text field type array list
    public void addModeleArrayList(ArrayList<JFXTextField> arrayList) {
        Modele d = new Modele();
        ModeleData(d,arrayList);
        modeleDAO.save(d);
    }

    // This method changes data in selected row with the input from user in gui
    // It takes an jfx text field type array list
    // To replace data it's using native query update
    public void replaceModeleArrayList(@NotNull ArrayList<JFXTextField> arrayList) {

        String hql = "update Modele m " +
                "set nazwa = :nazwa2, ilosc_egzemplarzy = :ilosc_egzemplarzy2, rok_produkcji = :rok_produkcji2 " +
                "where id_modelu = :id_modelu2";

        Query query1 = markiDAO.openCurrentSessionwithTransaction().createQuery(hql)
                .setParameter("id_modelu2",Integer.parseInt(arrayList.get(0).getText()))
                .setParameter("nazwa2", Integer.parseInt(arrayList.get(1).getText()))
                .setParameter("ilosc_egzemplarzy2", Integer.parseInt(arrayList.get(2).getText()))
                .setParameter("rok_produkcji2", Integer.parseInt(arrayList.get(3).getText()));

        query1.executeUpdate();
        markiDAO.getCurrentTransaction().commit();
    }


    // This method return table specific data type and sets it to whatever end user decides to
    @NotNull
    @Contract("_, _ -> param1")
    private Prezes PrezesData(@NotNull Prezes d, @NotNull ArrayList<JFXTextField> arrayList) {
        d.setId_prezesa(Integer.parseInt(arrayList.get(0).getText()));
        d.setImie(arrayList.get(1).getText());
        d.setNazwisko(arrayList.get(2).getText());
        d.setPesel(arrayList.get(3).getText());
        d.setWiek(Integer.parseInt(arrayList.get(4).getText()));
        d.setPochodzenie(arrayList.get(5).getText());
        return d;
    }

    // This method saves the input from user in gui
    // It takes an jfx text field type array list
    public void addPrezesArrayList(ArrayList<JFXTextField> arrayList) {
        Prezes d = new Prezes();
        PrezesData(d,arrayList);
        prezesDAO.save(d);
    }

    // This method changes data in selected row with the input from user in gui
    // It takes an jfx text field type array list
    // To replace data it's using native query update
    public void replacePrezesArrayList(@NotNull ArrayList<JFXTextField> arrayList) {

        String hql = "update Prezes p " +
                "set imie = :imie2, nazwisko = :nazwisko2, pesel = :pesel2, wiek = :wiek2 ,pochodzenie= :pochodzenie2 " +
                "where id_prezesa = :id_prezesa2";

        Query query1 = markiDAO.openCurrentSessionwithTransaction().createQuery(hql)
                .setParameter("id_prezesa2",Integer.parseInt(arrayList.get(0).getText()))
                .setParameter("imie2", Integer.parseInt(arrayList.get(1).getText()))
                .setParameter("nazwisko2", Integer.parseInt(arrayList.get(2).getText()))
                .setParameter("pesel2", Integer.parseInt(arrayList.get(3).getText()))
                .setParameter("wiek2", Float.parseFloat(arrayList.get(4).getText()))
                .setParameter("pochodzenie2", Float.parseFloat(arrayList.get(5).getText()));

        query1.executeUpdate();
        markiDAO.getCurrentTransaction().commit();
    }


    // This method return table specific data type and sets it to whatever end user decides to
    @NotNull
    @Contract("_, _ -> param1")
    private Dane_modelu Dane_modeluData(@NotNull Dane_modelu d, @NotNull ArrayList<JFXTextField> arrayList) {
        d.setId(Integer.parseInt(arrayList.get(0).getText()));
        d.setId_modelu(Integer.parseInt(arrayList.get(1).getText()));
        d.setMoc(Integer.parseInt(arrayList.get(2).getText()));
        d.setPojemnosc(Integer.parseInt(arrayList.get(3).getText()));
        d.setTyp_nadwozia(arrayList.get(4).getText());
        d.setTyp_silnika(arrayList.get(5).getText());
        return d;
    }

    // This method saves the input from user in gui
    // It takes an jfx text field type array list
    public void addDane_modeluArrayList(ArrayList<JFXTextField> arrayList) {
        Dane_modelu d = new Dane_modelu();
        Dane_modeluData(d,arrayList);
        dane_modeluDAO.save(d);
    }

    // This method changes data in selected row with the input from user in gui
    // It takes an jfx text field type array list
    // To replace data it's using native query update
    public void replaceDane_modeluArrayList(@NotNull ArrayList<JFXTextField> arrayList) {

        String hql = "update Dane_modelu d set id_modelu = :id_modelu2, moc = :moc2, pojemnosc = :pojemnosc2, typ_nadwozia = :typ_nadwozia2, typ_silnika = :typ_silnika2 where id = :id2";

        Query query1 = markiDAO.openCurrentSessionwithTransaction().createQuery(hql)
                .setParameter("id2",Integer.parseInt(arrayList.get(0).getText()))
                .setParameter("id_modelu2",Integer.parseInt(arrayList.get(1).getText()))
                .setParameter("moc2",Integer.parseInt(arrayList.get(2).getText()))
                .setParameter("pojemnosc2",Integer.parseInt(arrayList.get(3).getText()))
                .setParameter("typ_nadwozia2", arrayList.get(4).getText())
                .setParameter("typ_silnika2", arrayList.get(5).getText());

        query1.executeUpdate();
        markiDAO.getCurrentTransaction().commit();
    }


}
