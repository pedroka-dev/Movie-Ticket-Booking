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

public class TicketListAdapter extends BaseAdapter {
    private final List<Ticket> ticketList;
    private Context context;

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

        TextView title = createdView.findViewById(R.id.textViewMovieTitle);
        title.setText(ticket.getTitle());

        TextView price = createdView.findViewById(R.id.textViewMoviePrice);
        price.setText(Double.toString(ticket.getPrice()));

        TextView rating = createdView.findViewById(R.id.textViewMovieRating);
        rating.setText(Double.toString(ticket.getRating()));

        TextView sessionDate = createdView.findViewById(R.id.textViewSessionDate);
        sessionDate.setText(ticket.getSessionDate());

        TextView sessionTime= createdView.findViewById(R.id.textViewSessionTime);
        sessionTime.setText(ticket.getSessionDate());


        ImageView bannerImage = createdView.findViewById(R.id.imageViewBanner);
        Resources resources = context.getResources();
        int idOfDrawable = resources.getIdentifier(ticket.getBannerImage(), "drawable", context.getPackageName());
        Drawable drawableBannerImage = resources.getDrawable(idOfDrawable);
        bannerImage.setImageDrawable(drawableBannerImage);

        return createdView;
    }
}
