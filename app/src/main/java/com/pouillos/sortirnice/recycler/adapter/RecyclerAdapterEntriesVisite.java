package com.pouillos.sortirnice.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.modelentries.Entry;
import com.pouillos.sortirnice.recycler.holder.RecyclerViewHolderEntriesVisite;

import java.util.List;

public class RecyclerAdapterEntriesVisite extends RecyclerView.Adapter<RecyclerViewHolderEntriesVisite> {

        private List<Entry> listEntries;

    public interface Listener {
        void onClickEntriesButton(int position);
    }

    private final Listener callback;

    public RecyclerAdapterEntriesVisite(List<Entry> listEntries, Listener callback) {
        this.listEntries = listEntries;
        this.callback = callback;
    }

        @Override
        public RecyclerViewHolderEntriesVisite onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            //View view = inflater.inflate(R.layout.recycler_list_event, parent, false);
            View view = inflater.inflate(R.layout.recycler_list_entry_card_visite, parent, false);
            return new RecyclerViewHolderEntriesVisite(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolderEntriesVisite viewHolder, int position) {
            viewHolder.updateWithEntries(this.listEntries.get(position),this.callback);
        }

        @Override
        public int getItemCount() {
            return this.listEntries.size();
        }

    public Entry getEntry(int position){
        return this.listEntries.get(position);
    }
}
