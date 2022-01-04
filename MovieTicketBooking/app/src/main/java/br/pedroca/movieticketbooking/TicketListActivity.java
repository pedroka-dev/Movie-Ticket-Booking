package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TicketListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ticket_list);

        RecyclerView ticketRecyclerView = findViewById(R.id.recyclerViewTickets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ticketRecyclerView.setLayoutManager(layoutManager);
        ticketRecyclerView.setAdapter(new TicketListAdapter(this));
    }

    public void showCartButtonClicked(View view){
        Intent intent = new Intent(this, OrderListActivity.class);
        startActivity(intent);
    }
}