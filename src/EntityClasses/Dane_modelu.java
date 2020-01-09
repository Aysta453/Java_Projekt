/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package EntityClasses;

import org.jetbrains.annotations.Contract;

public class Dane_modelu {
   private int id;
   private int id_modelu;
   private int moc;
   private int pojemnosc;
   private String typ_nadwozia;
   private String typ_silnika;

    @Contract(pure = true)
    public Dane_modelu() {
    }
    @Contract(pure = true)
    public Dane_modelu(int id, int id_modelu, int moc, int pojemnosc, String typ_nadwozia, String typ_silnika) {
        this.id = id;
        this.id_modelu = id_modelu;
        this.moc = moc;
        this.pojemnosc = pojemnosc;
        this.typ_nadwozia = typ_nadwozia;
        this.typ_silnika = typ_silnika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_modelu() {
        return id_modelu;
    }

    public void setId_modelu(int id_modelu) {
        this.id_modelu = id_modelu;
    }

    public int getMoc() {
        return moc;
    }

    public void setMoc(int moc) {
        this.moc = moc;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getTyp_nadwozia() {
        return typ_nadwozia;
    }

    public void setTyp_nadwozia(String typ_nadwozia) {
        this.typ_nadwozia = typ_nadwozia;
    }

    public String getTyp_silnika() {
        return typ_silnika;
    }

    public void setTyp_silnika(String typ_silnika) {
        this.typ_silnika = typ_silnika;
    }

    @Override
    public String toString() {
        return "Dane_modelu{" +
                "id=" + id +
                ", id_modelu=" + id_modelu +
                ", moc=" + moc +
                ", pojemnosc=" + pojemnosc +
                ", typ_nadwozia='" + typ_nadwozia + '\'' +
                ", typ_silnika='" + typ_silnika + '\'' +
                '}';
    }
}
