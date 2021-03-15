package com.pouillos.sortirnice.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.Saison;
import com.pouillos.sortirnice.entities.Serie;
import com.pouillos.sortirnice.recycler.holder.RecyclerViewHolderSerie;

import java.util.List;

public class RecyclerAdapterSerie extends RecyclerView.Adapter<RecyclerViewHolderSerie> {

        private List<Saison> listSaison;

    public interface Listener {
        void onClickSerieButton(int position);
    }

    private final Listener callback;

    public RecyclerAdapterSerie(List<Saison> listSaison, Listener callback) {
        this.listSaison = listSaison;
        this.callback = callback;
    }

        @Override
        public RecyclerViewHolderSerie onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.recycler_list_serie, parent, false);

            return new RecyclerViewHolderSerie(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolderSerie viewHolder, int position) {
            viewHolder.updateWithSerie(this.listSaison.get(position),this.callback);
        }

        @Override
        public int getItemCount() {
            return this.listSaison.size();
        }

    public Serie getSerie(int position){
        return this.listSaison.get(position).getSerie();
    }

}
