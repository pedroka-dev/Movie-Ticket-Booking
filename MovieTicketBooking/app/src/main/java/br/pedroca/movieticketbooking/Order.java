package br.pedroca.movieticketbooking;

public class Order extends BaseEntity {
    private Ticket ticket;
    private int quantity;
    private String code;

    public Order(int id,Ticket ticket, int quantity, String code) {
        this.id = id;
        this.ticket = ticket;
        this.quantity = quantity;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", quantity=" + quantity +
                ", code='" + code + '\'' +
                '}';
    }
}
