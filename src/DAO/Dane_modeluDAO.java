/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package DAO;

import EntityClasses.Dane_modelu;

import java.util.List;

public class Dane_modeluDAO extends DAO<Dane_modelu, Integer> {

    @Override
    public Dane_modelu findById(Integer integer) {
        openCurrentSession();
        Dane_modelu dane_modelu = getCurrentSession().get(Dane_modelu.class, integer);
        closeCurrentSession();
        return dane_modelu;
    }

    @Override
    public List<Dane_modelu> findAll() {
        openCurrentSession();
        List<Dane_modelu> list = (List<Dane_modelu>) getCurrentSession().createCriteria(Dane_modelu.class).list();
        closeCurrentSession();
        return list;
    }

    public void daneDaoSave(Dane_modelu d) {
        this.save(d);
    }

    public void daneDaoUpdate(Dane_modelu d) {
        this.update(d);
    }

    public void daneDaoDelete(Dane_modelu d) {
        this.delete(d);
    }

    public void daneDaoDeleteAll() {
        this.deleteAll();
    }

}
