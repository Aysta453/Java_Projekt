/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package DAO;

import EntityClasses.Prezes;

import java.util.List;

public class PrezesDAO extends DAO<Prezes, Integer> {

    @Override
    public Prezes findById(Integer integer) {
        openCurrentSession();
        Prezes prezes = getCurrentSession().get(Prezes.class, integer);
        closeCurrentSession();
        return prezes;
    }

    @Override
    public List<Prezes> findAll() {
        openCurrentSession();
        List<Prezes> list = (List<Prezes>) getCurrentSession().createCriteria(Prezes.class).list();
        closeCurrentSession();
        return list;
    }

    public void PrezesDaoSave(Prezes d) {
        this.save(d);
    }

    public void PrezesDaoUpdate(Prezes d) {
        this.update(d);
    }

    public void PrezesDaoDelete(Prezes d) {
        this.delete(d);
    }

    public void PrezesDaoDeleteAll() {
        this.deleteAll();
    }
}

