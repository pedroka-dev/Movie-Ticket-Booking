package br.pedroca.movieticketbooking.ui.recyclerview.adapter;

import android.app.AlertDialog;
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
    private final TextView fullPriceView;

    public OrderListAdapter(Context context, TextView fullPriceView){
        this.context = context;
        this.fullPriceView = fullPriceView;     //TODO: implement total price update by other means. sending the textview here is a bad practice
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

    public void updateCartTotalPrice(){
        String fullPriceText = "$" + String.format(Locale.getDefault(),"%.2f", orderRepository.calculateCartTotalPrice());
        fullPriceView.setText(fullPriceText);
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView priceView;
        public TextView codeView;
        public TextView quantityView;
        public TextView orderPriceView;
        public Button increaseQuantityButton;
        public Button decreaseQuantityButton;

        public OrderViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.txtOrderMovieTitle);
            priceView = itemView.findViewById(R.id.txtOrderMoviePrice);
            codeView = itemView.findViewById(R.id.textViewOrderCode);
            quantityView = itemView.findViewById(R.id.txtOrderQuantity);
            orderPriceView = itemView.findViewById(R.id.txtOrderFullPrice);
            increaseQuantityButton = itemView.findViewById(R.id.buttonIncreaseQuantity);
            decreaseQuantityButton = itemView.findViewById(R.id.buttonDecreaseQuantity);
            decreaseQuantityButton = itemView.findViewById(R.id.buttonDecreaseQuantity);
            //updateCartTotalPrice();
        }

        public void removeOrder(int holderPosition){
            Order order = orderRepository.getAllEntity().get(holderPosition);
            orderRepository.deleteEntity(order);
            notifyItemRemoved(holderPosition);
            updateCartTotalPrice();
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

        public void showTicketDetails(Order order){
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setTitle("Ticket Details");
            LayoutInflater inflater = (LayoutInflater) itemView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View customLayout = inflater.inflate(R.layout.item_details, null);
            builder.setView(customLayout);
            builder.setPositiveButton("OK", (dialog, which) -> {
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }

        public void showFields(Order order){
            Ticket ticket = order.getTicket();
            titleView.setText(ticket.getTitle());
            String priceText = "$" + String.format(Locale.getDefault(),"%.2f", ticket.getPrice());  //todo: responsibility should be on Util layer
            priceView.setText(priceText);

            String orderPriceText = "$" + String.format(Locale.getDefault(),"%.2f", order.getOrderPrice());  //todo: responsibility should be on Util layer
            orderPriceView.setText(orderPriceText);

            quantityView.setText(Integer.toString(order.getQuantity()));

            codeView.setText(order.getCode());

            increaseQuantityButton.setOnClickListener(view -> addOrderQuantityToItem(order));
            decreaseQuantityButton.setOnClickListener(view -> subtractOrderQuantityToItem(order));
            itemView.setOnClickListener(view -> showTicketDetails(order));

            updateCartTotalPrice();
        }
    }
}
