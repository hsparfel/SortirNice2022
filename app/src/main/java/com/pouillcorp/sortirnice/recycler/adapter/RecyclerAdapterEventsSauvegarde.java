package com.pouillcorp.sortirnice.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EventSauvegardeEntity;
import com.pouillcorp.sortirnice.recycler.holder.RecyclerViewHolderEventsSauvegarde;

import java.util.List;

public class RecyclerAdapterEventsSauvegarde extends RecyclerView.Adapter<RecyclerViewHolderEventsSauvegarde> {

        private List<EventSauvegardeEntity> listEvents;

    public interface Listener {
        void onClickEventsButton(int position);
    }

    private final Listener callback;

    public RecyclerAdapterEventsSauvegarde(List<EventSauvegardeEntity> listEvents, Listener callback) {
        this.listEvents = listEvents;
        this.callback = callback;
    }

        @Override
        public RecyclerViewHolderEventsSauvegarde onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            //View view = inflater.inflate(R.layout.recycler_list_event, parent, false);
            View view = inflater.inflate(R.layout.recycler_list_event_card, parent, false);
            return new RecyclerViewHolderEventsSauvegarde(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolderEventsSauvegarde viewHolder, int position) {
            viewHolder.updateWithEvents(this.listEvents.get(position),this.callback);
        }

        @Override
        public int getItemCount() {
            return this.listEvents.size();
        }

    public EventSauvegardeEntity getEvent(int position){
        return this.listEvents.get(position);
    }
}
