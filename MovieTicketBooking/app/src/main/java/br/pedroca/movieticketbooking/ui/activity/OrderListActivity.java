package br.pedroca.movieticketbooking.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.pedroca.movieticketbooking.ui.recyclerview.helper.OrderItemTouchHelperCallback;
import br.pedroca.movieticketbooking.ui.recyclerview.adapter.OrderListAdapter;
import br.pedroca.movieticketbooking.R;

public class OrderListActivity extends Activity {

    private OrderListAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        RecyclerView orderRecycleView = findViewById(R.id.recycleViewOrders);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        orderRecycleView.setLayoutManager(layoutManager);

        TextView fullPriceView = findViewById(R.id.txtTotalPrice);      //needs to send this reference to calculate total cart price. works for now
        orderAdapter = new OrderListAdapter(this, fullPriceView);
        orderRecycleView.setAdapter(orderAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new OrderItemTouchHelperCallback(orderAdapter));
        itemTouchHelper.attachToRecyclerView(orderRecycleView);
    }

    public void buyButtonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.dialog_title));
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_alert, null);
        orderAdapter.removeAllOrders();
        builder.setView(customLayout);
        builder.setPositiveButton("OK", (dialog, which) -> {
            //EditText editText= customLayout.findViewById(R.id.editText);
            //Toast.makeText(this,ditText.getText().toString(),Toast.LENGTH_SHORT).show();
            //sendDialogDataToActivity();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}