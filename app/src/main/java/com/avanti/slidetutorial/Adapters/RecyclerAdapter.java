package com.avanti.slidetutorial.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avanti.slidetutorial.Beans.ProxMessage;
import com.avanti.slidetutorial.R;

import java.util.List;

/**
 * Created by emichniak on 16/01/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MessageViewHolder> {

    private List<ProxMessage> messageList;

    public RecyclerAdapter(List<ProxMessage> messageList){
        this.messageList = messageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        ProxMessage p = messageList.get(position);
        holder.cardDistance.setText("1 Mile");
        holder.cardLocation.setText(p.getLocation());
        holder.cardMessage.setText(p.getMessage());
        holder.cardName.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder{

        public TextView cardName,cardLocation, cardDistance, cardMessage;

        public MessageViewHolder(View v){
            super(v);
            this.cardDistance = (TextView) v.findViewById(R.id.cardDistance);
            this.cardLocation = (TextView) v.findViewById(R.id.cardLocation);
            this.cardMessage = (TextView) v.findViewById(R.id.cardMessage);
            this.cardName = (TextView) v.findViewById(R.id.cardName);
        }

    }
}


