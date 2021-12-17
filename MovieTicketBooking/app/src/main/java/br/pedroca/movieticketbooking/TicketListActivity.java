package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.navigation.ui.AppBarConfiguration;

import java.util.List;

import br.pedroca.movieticketbooking.databinding.ActivityTicketListBinding;

public class TicketListActivity extends Activity {

    //private AppBarConfiguration appBarConfiguration;
    private ActivityTicketListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_ticket_list);
        ListView ticketListView = findViewById(R.id.listViewTickets);

        List<Ticket> ticketList = new TicketDao().GetAll();
        ticketListView.setAdapter(new TicketListAdapter(ticketList,this));
    }
}