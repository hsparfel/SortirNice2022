package com.pouillcorp.sortirnice.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.facebook.stetho.Stetho;
import com.google.android.material.button.MaterialButton;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherFavorisActivity extends NavDrawerActivity {

    @Nullable
    @BindView(R.id.btnEntryFavori)
    MaterialButton btnEntryFavori;
    @Nullable
    @BindView(R.id.btnEventFavori)
    MaterialButton btnEventFavori;
    @Nullable
    @BindView(R.id.textFavoriVide)
    TextView textFavoriVide;

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
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).setChecked(true);
        afficherOuMasquerButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
        itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
        itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
        itemEntryType.setVisible(false);
        return true;
    }

    public void afficherEvenementsFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherEvenementsFavorisActivity.class,false);
    }

    public void afficherEntriesFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesFavorisActivity.class,false);
    }

    private void afficherOuMasquerButtons() {
        List<EntryEntity> listEntry = entryEntityDao.queryRaw("where favori = 1");
        List<EvenementEntity> listEvent = evenementEntityDao.queryRaw("where favori = 1");
        if (listEntry.size() > 0) {
            btnEntryFavori.setVisibility(View.VISIBLE);
            textFavoriVide.setVisibility(View.GONE);
        } else {
            btnEntryFavori.setVisibility(View.GONE);
        }
        if (listEvent.size() > 0) {
            btnEventFavori.setVisibility(View.VISIBLE);
            textFavoriVide.setVisibility(View.GONE);
        } else {
            btnEventFavori.setVisibility(View.GONE);
        }
        if (listEntry.size() == 0 && listEvent.size() == 0) {
            textFavoriVide.setVisibility(View.VISIBLE);
            btnEntryFavori.setVisibility(View.GONE);
            btnEventFavori.setVisibility(View.GONE);
        }
    }
}
