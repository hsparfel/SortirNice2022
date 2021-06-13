package com.pouillcorp.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.enumeration.EntriesType;

import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherEntryHotelDetailActivity extends NavDrawerEntryActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_detail_entry);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        traiterIntentDetail();
        setTitle("Detail Hotel");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
    }

    public void exit(View view) {
        finish();
    }

    public void delete(View view) {
        entryEntityDao.delete(entryTransmis);
        AfficherChoixEnregistrementActivity.getInstance().finish();
        ouvrirActiviteSuivante(this, AfficherChoixEnregistrementActivity.class,true, EntriesType.Hotel);
        //AfficherChoixEnregistrementActivity.getInstance().chipHotel.setChecked(true);
    }

}

