package com.pouillos.sortirnice.activities;

import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.pouillos.sortirnice.R;

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

    public void afficherEntriesSortie(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesSortieActivity.class,false);
    }

    public void afficherEntriesRestaurant(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesRestaurantActivity.class,false);
    }

    public void afficherEntriesTransport(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesTransportActivity.class,false);
    }

    public void afficherEntriesHotel(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesHotelActivity.class,false);
    }

    public void afficherEntriesBoutique(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesBoutiqueActivity.class,false);
    }

    public void afficherEntriesHebergement(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesHebergementActivity.class,false);
    }

    public void afficherEntriesVisite(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesVisiteActivity.class,false);
    }

    public void afficherEntriesShopping(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesShoppingActivity.class,false);
    }

    public void afficherEntriesUtile(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesUtileActivity.class,false);
    }
    public void afficherChoixEnregistrement(View view) {
        ouvrirActiviteSuivante(this, AfficherChoixEnregistrementActivity.class,false);
    }











    public void createLanguageDialog() {

    }



}
