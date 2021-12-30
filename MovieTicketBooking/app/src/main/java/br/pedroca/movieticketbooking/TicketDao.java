package br.pedroca.movieticketbooking;

import java.util.ArrayList;
import java.util.Arrays;

public class TicketDao extends BaseDao<Ticket> {
    public TicketDao() {    //just to simulate an existing database
        this.Insert(new Ticket(0,"Spider-man 2",15.00,4.5,"05/11/22","16:30","spiderman_banner"));
        this.Insert(new Ticket(0,"Fast and Furious 7",19.50,3.5,"16/09/22","11:00","fastandfurious_banner"));
        this.Insert(new Ticket(0,"Pump Fiction",20.00,5.0,"15/11/22","13:45","pumpfiction_banner"));
        this.Insert(new Ticket(0,"Transformers 3",12.99,2.6,"01/10/22","9:30","transformers_banner"));
        this.Insert(new Ticket(0,"Blade Runner 2049",25.00,5.0,"30/10/22","20:30","bladerunner_banner"));
        //this.entityList = new ArrayList<>(Arrays.asList(
        //        new Ticket(0,"Spider-man 2",15.00,4.5,"05/11/22","16:30","spiderman_banner"),
        //        new Ticket(1,"Fast and Furious 7",19.50,3.5,"16/09/22","11:00","fastandfurious_banner"),
        //        new Ticket(2,"Pump Fiction",20.00,5.0,"15/11/22","13:45","pumpfiction_banner"),
        //        new Ticket(3,"Transformers 3",12.99,2.6,"01/10/22","9:30","transformers_banner"),
        //        new Ticket(4,"Blade Runner 2049",25.00,5.0,"30/10/22","20:30","bladerunner_banner")
        //));
    }
}
