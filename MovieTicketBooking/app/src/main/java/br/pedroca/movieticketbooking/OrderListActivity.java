package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.pedroca.movieticketbooking.databinding.ActivityOrderListBinding;

public class OrderListActivity extends AppCompatActivity {
    //private AppBarConfiguration appBarConfiguration;
    //private ActivityOrderListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityOrderListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_order_list);

        RecyclerView orderRecycleView = findViewById(R.id.recycleViewOrders);
        List<Order> orderList = new OrderDao().GetAll();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        orderRecycleView.setLayoutManager(layoutManager);

        orderRecycleView.setAdapter(new OrderListAdapter(this, orderList));
    }
}