package com.pouillcorp.sortirnice.activities;

import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.pouillcorp.sortirnice.R;

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

    public void afficherEvenements(View view) {
        ouvrirActiviteSuivante(this, AfficherEvenementsActivity.class,false);
    }

    public void afficherEntriesDivers(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesDiversActivity.class,false);
    }

    public void afficherMesFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherFavorisActivity.class,false);
    }
}
