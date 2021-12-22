package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.pedroca.movieticketbooking.databinding.ActivityOrderListBinding;

public class OrderListActivity extends Activity {
    //private AppBarConfiguration appBarConfiguration;
    private ActivityOrderListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_order_list);

        ListView orderListView = findViewById(R.id.listViewOrders);
        List<Order> orderList = new OrderDao().GetAll();
        orderListView.setAdapter(new OrderListAdapter(orderList,this));
    }
}