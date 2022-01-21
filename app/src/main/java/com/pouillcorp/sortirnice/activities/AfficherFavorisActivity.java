package com.pouillcorp.sortirnice.activities;

import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.pouillcorp.sortirnice.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherFavorisActivity extends NavDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_favoris);
        Stetho.initializeWithDefaults(this);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        setTitle("Choix Favoris");
    }

    public void afficherEvenementsFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherEvenementsFavorisActivity.class,false);
    }

    public void afficherEntriesFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesFavorisActivity.class,false);
    }
}
