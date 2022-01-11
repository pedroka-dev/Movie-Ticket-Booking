package br.pedroca.movieticketbooking.model;

public class Order extends BaseEntity {
    private Ticket ticket;
    private int quantity;
    private String code;
    private double orderPrice;

    public Order(int id,Ticket ticket, int quantity, String code) {
        this.id = id;
        this.ticket = ticket;
        this.quantity = quantity;
        this.code = code;
        this.orderPrice = calculateOrderPrice();
    }
    public static String generateRandomCode(){
        String orderCode = "#CodeCode";
        return orderCode;
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
        this.orderPrice = calculateOrderPrice();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public double calculateOrderPrice() {
        return quantity * ticket.getPrice();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", quantity=" + quantity +
                ", code='" + code + '\'' +
                ", totalPrice=" + orderPrice +
                '}';
    }
}
