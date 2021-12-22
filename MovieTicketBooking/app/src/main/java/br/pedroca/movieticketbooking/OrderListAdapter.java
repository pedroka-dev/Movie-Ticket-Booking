package br.pedroca.movieticketbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class OrderListAdapter extends BaseAdapter {
    private final List<Order> orderList;
    private final Context context;

    public OrderListAdapter(List<Order> orderList, Context context){
        this.orderList = orderList;
        this.context = context;
    }
    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Order getItem(int id) {
        return orderList.get(id);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int id, View view, ViewGroup viewGroup) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_order, viewGroup, false);

        Order order = orderList.get(id);
        showTitle(createdView, order.getTicket());
        showPrice(createdView, order.getTicket());
        showCode(createdView, order);
        showQuantity(createdView,order);
        showOrderPrice(createdView,order);

        return createdView;
    }

    private void showTitle(View createdView, Ticket ticket) {
        TextView txtView = createdView.findViewById(R.id.txtOrderMovieTitle);
        txtView.setText(ticket.getTitle());
    }

    private void showCode(View createdView, Order order) {
        TextView txtView = createdView.findViewById(R.id.textViewOrderCode);
        txtView.setText(order.getCode());
    }

    private void showQuantity(View createdView, Order order) {
        TextView txtView = createdView.findViewById(R.id.txtOrderQuantity);
        txtView.setText(Integer.toString(order.getQuantity()));
    }

    private void showOrderPrice(View createdView, Order order) {
        TextView txtView = createdView.findViewById(R.id.txtOrderTotalPrice);
        String priceText = "$" + String.format(Locale.getDefault(),"%.2f", order.getTotalPrice());  //todo: responsibility should be on Util layer
        txtView.setText(priceText);
    }

    private void showPrice(View createdView, Ticket ticket) {
        TextView txtView = createdView.findViewById(R.id.txtOrderMoviePrice);
        String priceText = "$" + String.format(Locale.getDefault(),"%.2f", ticket.getPrice());  //todo: responsibility should be on Util layer
        txtView.setText(priceText);
    }
}
