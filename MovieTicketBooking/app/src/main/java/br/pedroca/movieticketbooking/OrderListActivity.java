package br.pedroca.movieticketbooking;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderListActivity extends Activity {
    public static OrderDao orderDao = new OrderDao();   //TODO: add OrderDAO instances by dependency injection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityOrderListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_order_list);

        RecyclerView orderRecycleView = findViewById(R.id.recycleViewOrders);
        List<Order> orderList = orderDao.getAllEntity();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        orderRecycleView.setLayoutManager(layoutManager);

        OrderListAdapter orderAdapter = new OrderListAdapter(this, orderList);
        orderRecycleView.setAdapter(orderAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new OrderItemTouchHelperCallback(orderAdapter));
        itemTouchHelper.attachToRecyclerView(orderRecycleView);
    }
}