package br.pedroca.movieticketbooking;

public class OrderDao extends BaseDao<Order> {
    //public OrderDao() {         //just to simulate an existing database
    //    this.Insert(new Order(0,new Ticket(0,"Spider-man 2",15.00,4.5,"05/11/22","16:30","spiderman_banner"),4,"#TbU5IOt5"));
    //    this.Insert(new Order(0,new Ticket(2,"Pump Fiction",20.00,5.0,"15/11/22","13:45","pumpfiction_banner"),1,"#YXikOWJQ"));
    //    this.Insert(new Order(0,new Ticket(4,"Blade Runner 2049",25.00,5.0,"30/10/22","20:30","bladerunner_banner"),2,"#KW69I6qB"));
    //    this.Insert(new Order(0,new Ticket(1,"Fast and Furious 7",19.50,3.5,"16/09/22","11:00","fastandfurious_banner"),2,"#kOWJTbU5"));
    //}

    public void createNewOrder(Ticket ticket){
        int IdOfOrderWithTicket = this.getIdfromTicket(ticket.getId());
        if(IdOfOrderWithTicket != -1) //-1 is when the id is not found
        {
            this.addOrderQuantity(IdOfOrderWithTicket);
        }
        else{
            Order order = new Order(0,ticket,1,Order.generateRandomCode());
            this.Insert(order);
        }
    }

    public int getIdfromTicket(int idTicket){
        for(Order order:entityList){
            if(order.getTicket().getId() == idTicket)
                return order.getId();
        }
        return -1;
    }

    public void addOrderQuantity(int idOrder){
        Order order = this.GetById(idOrder);
        order.setQuantity(order.getQuantity()+1);
        this.Update(order,idOrder);
    }

    public void subtractOrderQuantity(int idOrder){
        Order order = this.GetById(idOrder);
        order.setQuantity(order.getQuantity()-1);
        this.Update(order,idOrder);
    }

}
