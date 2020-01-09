/*
 * Copyright (c) 2020. Wojciech Wrona
 * All rights reserved
 */

package DAO;

import EntityClasses.Modele;
import java.util.List;

public class ModeleDAO extends DAO<Modele, Integer> {

    @Override
    public Modele findById(Integer integer) {
        openCurrentSession();
        Modele modele = getCurrentSession().get(Modele.class, integer);
        closeCurrentSession();
        return modele;
    }

    @Override
    public List<Modele> findAll() {
        openCurrentSession();
        List<Modele> list = (List<Modele>) getCurrentSession().createCriteria(Modele.class).list();
        closeCurrentSession();
        return list;
    }

    public void ModeleDaoSave(Modele d) {
        this.save(d);
    }

    public void ModeleDaoUpdate(Modele d) {
        this.update(d);
    }

    public void ModeleDaoDelete(Modele d) {
        this.delete(d);
    }

    public void ModeleDaoDeleteAll() {
        this.deleteAll();
    }
}
