package com.pouillos.sortirnice.recycler.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.sortirnice.R;

import com.pouillos.sortirnice.model.Event;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEvents;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderEvents extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.detail)
    TextView detail;

    private WeakReference<RecyclerAdapterEvents.Listener> callbackWeakRef;

    public RecyclerViewHolderEvents(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithEvents(Event event, RecyclerAdapterEvents.Listener callback){
        this.detail.setText(event.toString());
        this.detail.setOnClickListener(this);
        this.callbackWeakRef = new WeakReference<RecyclerAdapterEvents.Listener>(callback);
    }

    @Override
    public void onClick(View view) {
        RecyclerAdapterEvents.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickEventsButton(getAdapterPosition());
    }
}
