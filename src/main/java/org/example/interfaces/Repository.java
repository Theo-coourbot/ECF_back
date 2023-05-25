package org.example.interfaces;

import java.util.List;

public interface Repository<Obj> {

    boolean create(Obj obj);

    boolean update(Obj obj);

    boolean delete(Obj obj);

    Obj findById(int id);

    List<Obj> findAll();
}
