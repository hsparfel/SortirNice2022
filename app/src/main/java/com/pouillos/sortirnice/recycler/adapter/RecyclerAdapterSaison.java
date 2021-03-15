package com.pouillos.sortirnice.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.Saison;
import com.pouillos.sortirnice.recycler.holder.RecyclerViewHolderSaison;

import java.util.List;

public class RecyclerAdapterSaison extends RecyclerView.Adapter<RecyclerViewHolderSaison> {

        private List<Saison> listSaison;

    public interface Listener {
        void onClickSaisonButton(int position);
    }

    private final Listener callback;

    public RecyclerAdapterSaison(List<Saison> listSaison, Listener callback) {
        this.listSaison = listSaison;
        this.callback = callback;
    }

        @Override
        public RecyclerViewHolderSaison onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.recycler_list_saison, parent, false);

            return new RecyclerViewHolderSaison(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolderSaison viewHolder, int position) {
            viewHolder.updateWithSaison(this.listSaison.get(position),this.callback);
        }

        @Override
        public int getItemCount() {
            return this.listSaison.size();
        }

    public Saison getSaison(int position){
        return this.listSaison.get(position);
    }

}
