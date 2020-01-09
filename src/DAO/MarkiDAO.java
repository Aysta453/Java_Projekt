/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package DAO;

import EntityClasses.Marki;


import java.util.List;

public class MarkiDAO extends DAO<Marki, Integer> {

    @Override
    public Marki findById(Integer integer) {
        openCurrentSession();
        Marki marki = getCurrentSession().get(Marki.class, integer);
        closeCurrentSession();
        return marki;
    }

    @Override
    public List<Marki> findAll() {
        openCurrentSession();
        List<Marki> list = (List<Marki>) getCurrentSession().createCriteria(Marki.class).list();
        closeCurrentSession();
        return list;
    }



}