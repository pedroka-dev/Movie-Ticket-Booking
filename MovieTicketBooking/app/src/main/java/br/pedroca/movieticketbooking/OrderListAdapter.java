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
        //showOrderPrice(createdView,order);

        return createdView;
    }

    private void showOrderPrice(View createdView, Order order) {

    }

    private void showQuantity(View createdView, Order order) {
        TextView title = createdView.findViewById(R.id.textViewOrderQuantity);
        title.setText(Integer.toString(order.getQuantity()));
    }

    private void showCode(View createdView, Order order) {
        TextView title = createdView.findViewById(R.id.textViewOrderCode);
        title.setText(order.getCode());
    }

    private void showTitle(View createdView, Ticket ticket) {
        TextView title = createdView.findViewById(R.id.textViewOrderMovieTitle);
        title.setText(ticket.getTitle());
    }

    private void showPrice(View createdView, Ticket ticket) {
        TextView price = createdView.findViewById(R.id.textViewOrderMoviePrice);
        String priceText = "$" + String.format(Locale.getDefault(),"%.2f", ticket.getPrice());  //todo: responsibility should be on Util layer
        price.setText(priceText);
    }
}
