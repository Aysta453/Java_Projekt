/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package EntityClasses;

import org.jetbrains.annotations.Contract;

public class Marki {
    private int id;
    private String nazwa;
    private int rok_zalozenia;
    private String siedziba;
    private int ilosc_sprzedanych;
    private int id_prezesa;

    @Contract(pure = true)
    public Marki() {
    }
    @Contract(pure = true)
    public Marki(int id, String nazwa, int rok_zalozenia, String siedziba, int ilosc_sprzedanych, int id_prezesa) {
        this.id = id;
        this.nazwa = nazwa;
        this.rok_zalozenia = rok_zalozenia;
        this.siedziba = siedziba;
        this.ilosc_sprzedanych = ilosc_sprzedanych;
        this.id_prezesa = id_prezesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getRok_zalozenia() {
        return rok_zalozenia;
    }

    public void setRok_zalozenia(int rok_zalozenia) {
        this.rok_zalozenia = rok_zalozenia;
    }

    public String getSiedziba() {
        return siedziba;
    }

    public void setSiedziba(String siedziba) {
        this.siedziba = siedziba;
    }

    public int getIlosc_sprzedanych() {
        return ilosc_sprzedanych;
    }

    public void setIlosc_sprzedanych(int ilosc_sprzedanych) {
        this.ilosc_sprzedanych = ilosc_sprzedanych;
    }

    public int getId_prezesa() {
        return id_prezesa;
    }

    public void setId_prezesa(int id_prezesa) {
        this.id_prezesa = id_prezesa;
    }

    @Override
    public String toString() {
        return "Marki{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", rok_zalozenia=" + rok_zalozenia +
                ", siedziba='" + siedziba + '\'' +
                ", ilosc_sprzedanych=" + ilosc_sprzedanych +
                ", id_prezesa=" + id_prezesa +
                '}';
    }
}
