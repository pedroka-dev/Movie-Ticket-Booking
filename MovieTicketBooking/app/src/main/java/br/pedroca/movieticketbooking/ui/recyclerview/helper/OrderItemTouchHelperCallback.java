package br.pedroca.movieticketbooking.ui.recyclerview.helper;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import br.pedroca.movieticketbooking.ui.recyclerview.adapter.OrderListAdapter;

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
        OrderListAdapter.OrderViewHolder orderViewHolder = (OrderListAdapter.OrderViewHolder)viewHolder;
        orderViewHolder.removeOrder(swipedAdapterPosition);
    }
}
