/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package EntityClasses;

import org.jetbrains.annotations.Contract;

public class Prezes {

    private int id_prezesa;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
    private String pochodzenie;

    @Contract(pure = true)
    public Prezes() {
    }

    @Contract(pure = true)
    public Prezes(int id_prezesa, String imie, String nazwisko, String pesel, int wiek, String pochodzenie) {
        this.id_prezesa = id_prezesa;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.pochodzenie = pochodzenie;
    }

    public int getId_prezesa() {
        return id_prezesa;
    }

    public void setId_prezesa(int id_prezesa) {
        this.id_prezesa = id_prezesa;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPochodzenie() {
        return pochodzenie;
    }

    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }

    @Override
    public String toString() {
        return "Prezes{" +
                "id_prezesa=" + id_prezesa +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", wiek=" + wiek +
                ", pochodzenie='" + pochodzenie + '\'' +
                '}';
    }
}
