package br.pedroca.movieticketbooking.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

import br.pedroca.movieticketbooking.R;
import br.pedroca.movieticketbooking.dao.OrderDao;
import br.pedroca.movieticketbooking.model.Order;
import br.pedroca.movieticketbooking.model.Ticket;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {
    public static OrderDao orderRepository = new OrderDao();
    private final Context context;

    public OrderListAdapter(Context context){
        this.context = context;
    }

    @Override
    public OrderListAdapter.OrderViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_order, viewGroup, false);

        return new OrderViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(OrderListAdapter.OrderViewHolder holder, int id) {
        Order order = orderRepository.getAllEntity().get(id);
        holder.showFields(order);
    }

    @Override
    public int getItemCount() {
        return orderRepository.getCount();
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


        public void removeOrder(int holderPosition){
            Order order = orderRepository.getAllEntity().get(holderPosition);
            orderRepository.deleteEntity(order);
            notifyItemRemoved(holderPosition);
            Toast.makeText(this.itemView.getContext(), "Removed order from cart", Toast.LENGTH_SHORT).show();
        }

        public void addOrderQuantityToItem(Order order){
            orderRepository.addOrderQuantity(order);
            notifyItemChanged(this.getAdapterPosition());
        }

        public void subtractOrderQuantityToItem(Order order){
            orderRepository.subtractOrderQuantity(order);
            notifyItemChanged(this.getAdapterPosition());
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

            increaseQuantity.setOnClickListener(view -> addOrderQuantityToItem(order));

            decreaseQuantity.setOnClickListener(view -> subtractOrderQuantityToItem(order));
        }
    }
}
