package br.pedroca.movieticketbooking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class BaseDao<T extends BaseEntity>{
    protected List<T> entityList = new ArrayList<>();

    public void Insert(T object){
        object.setId(entityList.size());
        entityList.add(object);
    }

    public  void Update(T object,int id){
        throw new UnsupportedOperationException();
    }

    public void DeleteById(int id){
        for(T entity : entityList)
            if(entity.getId() == id)
                entityList.remove(entity);
    }

    public  void DeleteAll(){
        entityList.clear();
    }

    public T GetById(int id){
        for(T entity : entityList)
            if(entity.getId() == id)
                return entity;
        return null;
    }

    public List<T> GetAll(){
        return entityList;
    }
}
