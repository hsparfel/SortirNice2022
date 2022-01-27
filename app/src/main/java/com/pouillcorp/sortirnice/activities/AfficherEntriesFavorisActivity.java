package com.pouillcorp.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherEntriesFavorisActivity extends NavDrawerActivity implements RecyclerAdapterEntries.Listener {

    public static final String TAG = AfficherEntriesFavorisActivity.class.getSimpleName();
    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_entry_various);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        listEntries = new ArrayList<>();
        nbEntries = 0;

        setTitle("Entries Favoris");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).setChecked(true);

        loadAllEntryFavorisFromDB();
        listEntryEntitiesBasique.addAll(listEntryEntities);
        configureRecyclerViewEntry();

        listerFiltreEntry();
        initListFiltresEntry();
        initCheckboxesSelectAllClickEntry();
        progressBar.setVisibility(View.GONE);

        masquerFragmentFiltreEntry();
        masquerFragmentType();

        listCheckboxEntryType.add(checkboxEntryTypeBoutique);
        listCheckboxEntryType.add(checkboxEntryTypeSortie);
        listCheckboxEntryType.add(checkboxEntryTypeUtile);
        listCheckboxEntryType.add(checkboxEntryTypeVisite);
        listCheckboxEntryType.add(checkboxEntryTypeHebergement);
        listCheckboxEntryType.add(checkboxEntryTypeHotel);
        listCheckboxEntryType.add(checkboxEntryTypeRestaurant);
        listCheckboxEntryType.add(checkboxEntryTypeTransport);
        listCheckboxEntryType.add(checkboxEntryTypeShopping);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
        itemEntryType.setVisible(true);
        itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        itemEntryFiltre.setVisible(false);
        return true;
    }

    private void loadAllEntryFavorisFromDB() {
        entryEntityDao.detachAll();
        listEntryEntities = entryEntityDao.queryRaw("where favori = 1");
        Collections.sort(listEntryEntities);
    }



    @Override
    protected void onResume() {
        super.onResume();
        for (Object current : listEntryEntities) {
            ((EntryEntity) current).refresh();
        }
        configureRecyclerViewEntry();
        list_recycler_entry.scrollToPosition(positionScroll);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_entry_type:
                if (layoutTypeAffiche) {
                    masquerFragmentType();
                } else {
                    afficherFragmentType();
                }
                masquerFragmentFiltreEntry();
                break;
            case R.id.menu_activity_main_entry_filter:
                if (layoutFiltreAffiche) {
                    masquerFragmentFiltreEntry();
                } else {
                    afficherFragmentFiltre();
                }
                masquerFragmentType();
                break;
        }
        return true;
    }

    @Override
    public void onClickEntriesButton(int position) {
    }
}