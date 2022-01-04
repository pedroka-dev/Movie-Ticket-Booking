package br.pedroca.movieticketbooking.ui.recyclerview.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

import br.pedroca.movieticketbooking.R;
import br.pedroca.movieticketbooking.dao.TicketDao;
import br.pedroca.movieticketbooking.model.Ticket;

public class TicketListAdapter extends RecyclerView.Adapter<TicketListAdapter.TicketViewHolder>  {
    public static TicketDao ticketRepository = new TicketDao();
    private final Context context;

    public TicketListAdapter(Context context){
        this.context = context;
    }

    @Override
    public TicketListAdapter.TicketViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_ticket, viewGroup, false);

        return new TicketViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(TicketListAdapter.TicketViewHolder holder, int id) {
        Ticket ticket = ticketRepository.getEntity(id);
        holder.showFields(ticket);
    }

    @Override
    public int getItemCount() {
        return ticketRepository.getCount();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView price;
        public TextView rating;
        public TextView sessionDate;
        public TextView sessionTime;
        public ImageView bannerImage;
        public Button addCard;

        public TicketViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTicketTitle);
            price = itemView.findViewById(R.id.txtTicketPrice);
            rating = itemView.findViewById(R.id.txtTicketRating);
            sessionDate  = itemView.findViewById(R.id.txtTicketDate);
            sessionTime = itemView.findViewById(R.id.txtTicketTime);
            bannerImage = itemView.findViewById(R.id.imageViewBanner);
            addCard = itemView.findViewById(R.id.buttonAddToCart);
        }

        public void showFields(Ticket ticket){
            title.setText(ticket.getTitle());

            String priceText = "$" + String.format(Locale.getDefault(),"%.2f", ticket.getPrice());  //todo: responsibility should be on Util layer
            price.setText(priceText);

            String ratingText = String.format(Locale.getDefault(),"%.1f",ticket.getRating());   //todo: responsibility should be on Util layer
            rating.setText(ratingText);

            sessionDate.setText(ticket.getSessionDate());

            sessionTime.setText(ticket.getSessionTime());

            Resources resources = context.getResources();
            int idOfDrawable = resources.getIdentifier(ticket.getBannerImage(), "drawable", context.getPackageName());
            Drawable drawableBannerImage = resources.getDrawable(idOfDrawable);
            bannerImage.setImageDrawable(drawableBannerImage);

            addCard.setOnClickListener(view -> {
                OrderListAdapter.orderRepository.createNewOrder(ticket);
                Toast.makeText(view.getContext(), "Ticket: '" +ticket.getTitle()+"' added to shopping cart successfully.", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
