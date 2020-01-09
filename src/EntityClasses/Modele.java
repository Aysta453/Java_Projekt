/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package EntityClasses;

import org.jetbrains.annotations.Contract;

public class Modele {
    private int id_modelu;
    private String nazwa;
    private int ilosc_egzemplarzy;
    private int rok_produkcji;

    @Contract(pure = true)
    public Modele(int id_modelu, String nazwa, int ilosc_egzemplarzy, int rok_produkcji) {
        this.id_modelu = id_modelu;
        this.nazwa = nazwa;
        this.ilosc_egzemplarzy = ilosc_egzemplarzy;
        this.rok_produkcji = rok_produkcji;
    }
    @Contract(pure = true)
    public Modele() {
    }

    public int getId_modelu() {
        return id_modelu;
    }

    public void setId_modelu(int id_modelu) {
        this.id_modelu = id_modelu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIlosc_egzemplarzy() {
        return ilosc_egzemplarzy;
    }

    public void setIlosc_egzemplarzy(int ilosc_egzemplarzy) {
        this.ilosc_egzemplarzy = ilosc_egzemplarzy;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    @Override
    public String toString() {
        return "Modele{" +
                "id_modelu=" + id_modelu +
                ", nazwa='" + nazwa + '\'' +
                ", ilosc_egzemplarzy=" + ilosc_egzemplarzy +
                ", rok_produkcji=" + rok_produkcji +
                '}';
    }
}
