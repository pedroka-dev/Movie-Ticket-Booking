package br.pedroca.movieticketbooking;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity>{
    protected List<T> entityList = new ArrayList<>();

    public void Insert(T object){
        object.setId(entityList.size());
        entityList.add(object);
    }

    public  void Update(T object,int id){
        entityList.set(id,object);
    }

    public void DeleteById(int id){
        entityList.remove(id);
        //for(T entity : entityList)
        //    if(entity.getId() == id)
        //      entityList.remove(entity);
    }

    public void DeleteEntity(T object){
        entityList.remove(object);
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
