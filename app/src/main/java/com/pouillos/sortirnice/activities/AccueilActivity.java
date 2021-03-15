package com.pouillos.sortirnice.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.stetho.Stetho;
import com.google.android.material.snackbar.Snackbar;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.Saison;
import com.pouillos.sortirnice.entities.Serie;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterSerie;
import com.pouillos.sortirnice.utils.ItemClickSupport;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AccueilActivity extends NavDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Stetho.initializeWithDefaults(this);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        setTitle("Accueil");

    }

    public void afficherEvents(View view) {
        ouvrirActiviteSuivante(this, AfficherEventsActivity.class,false);
    }





}
