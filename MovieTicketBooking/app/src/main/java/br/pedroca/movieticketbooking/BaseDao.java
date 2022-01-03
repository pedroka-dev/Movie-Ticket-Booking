package br.pedroca.movieticketbooking;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity>{
    protected List<T> entityList = new ArrayList<>();

    public void insertEntity(T object){
        object.setId(entityList.size());
        entityList.add(object);
    }

    public  void updateEntity(T object, int id){
        entityList.set(id,object);
    }

    public void deleteEntity(T object){
        entityList.remove(object);
        //for(T entity : entityList)
        //    if(entity.getId() == id)
        //      entityList.remove(entity);
    }

    public  void deleteAllEntity(){
        entityList.clear();
    }

    public T getEntity(int id){
        for(T entity : entityList)
            if(entity.getId() == id)
                return entity;
        return null;
    }

    public List<T> getAllEntity(){
        return entityList;
    }
}
