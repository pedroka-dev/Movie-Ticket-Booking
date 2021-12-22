package br.pedroca.movieticketbooking;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class TicketListAdapter extends BaseAdapter {
    private final List<Ticket> ticketList;
    private final Context context;

    public TicketListAdapter(List<Ticket> ticketList, Context context){
        this.ticketList = ticketList;
        this.context = context;
    }
    @Override
    public int getCount() {
        return ticketList.size();
    }

    @Override
    public Ticket getItem(int id) {
        return ticketList.get(id);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int id, View view, ViewGroup viewGroup) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_ticket, viewGroup, false);

        Ticket ticket = ticketList.get(id);
        showTitle(createdView, ticket);
        showPrice(createdView, ticket);
        showRating(createdView, ticket);
        showSessionDate(createdView, ticket);
        showSessionTime(createdView, ticket);
        showImage(createdView, ticket);

        return createdView;
    }

    private void showTitle(View createdView, Ticket ticket) {
        TextView title = createdView.findViewById(R.id.txtTicketTitle);
        title.setText(ticket.getTitle());
    }

    private void showPrice(View createdView, Ticket ticket) {
        TextView price = createdView.findViewById(R.id.txtTicketPrice);
        String priceText = "$" + String.format(Locale.getDefault(),"%.2f", ticket.getPrice());  //todo: responsibility should be on Util layer
        price.setText(priceText);
    }

    private void showRating(View createdView, Ticket ticket) {
        TextView rating = createdView.findViewById(R.id.txtTicketRating);
        String ratingText = String.format(Locale.getDefault(),"%.1f",ticket.getRating());   //todo: responsibility should be on Util layer
        rating.setText(ratingText);
    }

    private void showSessionDate(View createdView, Ticket ticket) {
        TextView sessionDate = createdView.findViewById(R.id.txtTicketDate);
        sessionDate.setText(ticket.getSessionDate());
    }

    private void showSessionTime(View createdView, Ticket ticket) {
        TextView sessionTime= createdView.findViewById(R.id.txtTicketTime);
        sessionTime.setText(ticket.getSessionTime());
    }

    private void showImage(View createdView, Ticket ticket) {
        ImageView bannerImage = createdView.findViewById(R.id.imageViewBanner);
        Resources resources = context.getResources();
        int idOfDrawable = resources.getIdentifier(ticket.getBannerImage(), "drawable", context.getPackageName());
        Drawable drawableBannerImage = resources.getDrawable(idOfDrawable);
        bannerImage.setImageDrawable(drawableBannerImage);
    }
}
