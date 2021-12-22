package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
        Intent intent = new Intent(this,TicketListActivity.class);
        startActivity(intent);
    }

    //private void sendDialogDataToActivity(String data)
    //{
    //    Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    //}
}