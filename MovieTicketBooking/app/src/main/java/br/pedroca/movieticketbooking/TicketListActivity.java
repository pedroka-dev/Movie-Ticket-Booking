package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.os.Bundle;
import androidx.navigation.ui.AppBarConfiguration;
import br.pedroca.movieticketbooking.databinding.ActivityTicketListBinding;

public class TicketListActivity extends Activity {

    //private AppBarConfiguration appBarConfiguration;
    private ActivityTicketListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTicketListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_ticket_list);
    }
}