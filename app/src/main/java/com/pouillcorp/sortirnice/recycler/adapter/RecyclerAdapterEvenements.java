package com.pouillcorp.sortirnice.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.modelevents.Event;
import com.pouillcorp.sortirnice.recycler.holder.RecyclerViewHolderEvenements;
import com.pouillcorp.sortirnice.recycler.holder.RecyclerViewHolderEvents;

import java.util.List;

public class RecyclerAdapterEvenements extends RecyclerView.Adapter<RecyclerViewHolderEvenements> {

        private List<EvenementEntity> listEvents;

    public interface Listener {
        void onClickEventsButton(int position);
    }

    private final Listener callback;

    public RecyclerAdapterEvenements(List<EvenementEntity> listEvents, Listener callback) {
        this.listEvents = listEvents;
        this.callback = callback;
    }

        @Override
        public RecyclerViewHolderEvenements onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            //View view = inflater.inflate(R.layout.recycler_list_event, parent, false);
            View view = inflater.inflate(R.layout.recycler_list_event_card, parent, false);
            return new RecyclerViewHolderEvenements(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolderEvenements viewHolder, int position) {
            viewHolder.updateWithEvents(this.listEvents.get(position),this.callback);
        }

        @Override
        public int getItemCount() {
            return this.listEvents.size();
        }

    public EvenementEntity getEvent(int position){
        return this.listEvents.get(position);
    }
}
