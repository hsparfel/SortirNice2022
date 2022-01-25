package com.pouillcorp.sortirnice.activities;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvenements;

import java.util.ArrayList;

import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherEvenementsFavorisActivity extends NavDrawerActivity implements RecyclerAdapterEvenements.Listener {

    public static final String TAG = AfficherEvenementsFavorisActivity.class.getSimpleName();
    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_event);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        listEvents = new ArrayList<>();
        nbEvents = 0;

        setTitle("Evenements Favoris");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_evenement).setChecked(true);

        progressBar.setVisibility(View.VISIBLE);
        loadAllEvenementFavorisFromDB();
        listEventEntitiesBasique.addAll(listEventEntities);
        configureRecyclerView();

        listerFiltre();
        initListFiltres();
        initCheckboxesSelectAllClick();

        progressBar.setVisibility(View.GONE);

        masquerFragmentTri();
        masquerFragmentFiltreEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
        itemEvenementFiltre.setVisible(true);
        itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
        itemEvenementTri.setVisible(true);
        return true;
    }

    private void loadAllEvenementFavorisFromDB() {
        evenementEntityDao.detachAll();
        listEventEntities = evenementEntityDao.queryRaw("where favori = 1");
        triSelonParametre(listEventEntities);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (Object current : listEventEntities) {
            ((EvenementEntity) current).refresh();
        }
        configureRecyclerView();
        list_recycler_event.scrollToPosition(positionScroll);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_evenement_tri:
                Log.e(TAG, "click sur tri evenement");
                if (layoutTriAffiche) {
                    masquerFragmentTri();
                } else {
                    afficherFragmentTri();
                }
                masquerFragmentFiltreEvent();
                break;
            case R.id.menu_activity_main_evenement_filter:
                Log.e(TAG, "click sur filtre evenement");
                if (layoutFiltreAffiche) {
                    masquerFragmentFiltreEvent();
                } else {
                    afficherFragmentFiltre();
                }
                masquerFragmentTri();
                break;
        }
        return true;
    }

    @Override
    public void onClickEventsButton(int position) {
    }
}