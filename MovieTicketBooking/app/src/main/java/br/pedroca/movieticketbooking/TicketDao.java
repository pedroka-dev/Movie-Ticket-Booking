package br.pedroca.movieticketbooking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TicketDao {
    public  List<Ticket> GetAll(){
        List<Ticket> tickets = new ArrayList<>(Arrays.asList(
                new Ticket("Spider-man 2",15.00,4.5,"05/11/22","16:30","spiderman_banner"),
                new Ticket("Fast and Furious 7",19.50,3.5,"16/09/22","11:00","spiderman_banner"),
                new Ticket("Pump Fiction",20.00,5.0,"15/11/22","13:45","spiderman_banner"),
                new Ticket("Transformers 3",12.99,2.6,"01/10/22","9:30","spiderman_banner"),
                new Ticket("Blade Runner 2049",25.00,5.0,"30/10/22","20:30","spiderman_banner")
        ));
        return tickets;
    }
}
