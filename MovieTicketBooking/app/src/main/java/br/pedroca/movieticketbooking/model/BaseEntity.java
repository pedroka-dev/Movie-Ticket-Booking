package br.pedroca.movieticketbooking.model;

public abstract class BaseEntity {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
