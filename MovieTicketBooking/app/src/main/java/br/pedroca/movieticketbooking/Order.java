package br.pedroca.movieticketbooking;

public class Order extends BaseEntity {
    private Ticket ticket;
    private int quantity;
    private String user;

    public Order(int id,Ticket ticket, int quantity, String user) {
        this.id = id;
        this.ticket = ticket;
        this.quantity = quantity;
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", quantity=" + quantity +
                ", user='" + user + '\'' +
                '}';
    }
}
