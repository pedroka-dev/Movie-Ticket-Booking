package br.pedroca.movieticketbooking;

import java.util.List;

public abstract class BaseDao<T extends BaseEntity>{
    protected List<T> entityList;

    public void Insert(T object){
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
