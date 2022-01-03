package br.pedroca.movieticketbooking;

import android.widget.Toast;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class OrderItemTouchHelperCallback extends ItemTouchHelper.Callback{
    OrderListAdapter orderAdapter;

    public OrderItemTouchHelperCallback(OrderListAdapter orderAdapter) {
        this.orderAdapter = orderAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int slideFlags = ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
        return makeMovementFlags(0, slideFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int swipedAdapterPosition = viewHolder.getAdapterPosition();
        Order order = OrderListActivity.orderDao.getAllEntity().get(swipedAdapterPosition);
        OrderListActivity.orderDao.deleteEntity(order);
        orderAdapter.notifyItemRemoved(swipedAdapterPosition);
        Toast.makeText(viewHolder.itemView.getContext(), "Removed order from cart", Toast.LENGTH_SHORT).show();
    }
}
