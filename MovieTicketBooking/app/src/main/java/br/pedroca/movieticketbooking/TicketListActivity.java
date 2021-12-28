package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class TicketListActivity extends AppCompatActivity {

    //private AppBarConfiguration appBarConfiguration;
    //private ActivityTicketListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityTicketListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_ticket_list);

        RecyclerView ticketRecyclerView = findViewById(R.id.recyclerViewTickets);
        //ticketRecyclerView.setHasFixedSize(true);
        List<Ticket> ticketList = new TicketDao().GetAll();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ticketRecyclerView.setLayoutManager(layoutManager);

        ticketRecyclerView.setAdapter(new TicketListAdapter(this,ticketList));

    }

    public void addToCartButtonClicked(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.dialog_title));

        final View customLayout = getLayoutInflater().inflate( R.layout.dialog_alert, null);
        builder.setView(customLayout);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //EditText editText= customLayout.findViewById(R.id.editText);
                //sendDialogDataToActivity(ditText.getText().toString());
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showCartButtonClicked(View view){
        Intent intent = new Intent(this, OrderListActivity.class);
        startActivity(intent);
    }

    //private void sendDialogDataToActivity(String data)
    //{
    //    Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    //}
}