package br.pedroca.movieticketbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {
    private final List<Order> orderList;
    private final Context context;

    public OrderListAdapter(Context context,List<Order> orderList){
        this.context = context;
        this.orderList = orderList;
    }

    @Override
    public OrderListAdapter.OrderViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_order, viewGroup, false);

        return new OrderViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(OrderListAdapter.OrderViewHolder holder, int id) {
        Order order = orderList.get(id);
        holder.showFields(order);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView price;
        public TextView code;
        public TextView quantity;
        public TextView orderPrice;
        public Button increaseQuantity;
        public Button decreaseQuantity;

        public OrderViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtOrderMovieTitle);
            price = itemView.findViewById(R.id.txtOrderMoviePrice);
            code = itemView.findViewById(R.id.textViewOrderCode);
            quantity = itemView.findViewById(R.id.txtOrderQuantity);
            orderPrice = itemView.findViewById(R.id.txtOrderTotalPrice);
            increaseQuantity = itemView.findViewById(R.id.buttonIncreaseQuantity);
            decreaseQuantity = itemView.findViewById(R.id.buttonDecreaseQuantity);
        }

        public void showFields(Order order){
            Ticket ticket = order.getTicket();
            title.setText(ticket.getTitle());
            String priceText = "$" + String.format(Locale.getDefault(),"%.2f", ticket.getPrice());  //todo: responsibility should be on Util layer
            price.setText(priceText);

            String orderPriceText = "$" + String.format(Locale.getDefault(),"%.2f", order.getTotalPrice());  //todo: responsibility should be on Util layer
            orderPrice.setText(orderPriceText);

            quantity.setText(Integer.toString(order.getQuantity()));

            code.setText(order.getCode());

            increaseQuantity.setOnClickListener(view -> {
                OrderListActivity.orderDao.addOrderQuantity(order.getId());
                notifyItemChanged(order.getId());
            });

            decreaseQuantity.setOnClickListener(view -> {
                OrderListActivity.orderDao.subtractOrderQuantity(order.getId());
                notifyItemChanged(order.getId());
            });

        }
    }
}
