package com.pouillcorp.sortirnice.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.DateMaj;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryProfileEntity;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementProfileEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementProfileEntity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import icepick.Icepick;

public class AccueilActivity extends NavDrawerActivity {

    public static final String TAG = AccueilActivity.class.getSimpleName();
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Stetho.initializeWithDefaults(this);







        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        long nbEntry = entryEntityDao.count();
        if (nbEntry == 0) {
            AsyncTaskRunnerPrepopulate runner = new AsyncTaskRunnerPrepopulate();
            runner.execute();
        } else {
            progressBar.setVisibility(View.GONE);
        }
        setTitle("Accueil");
        if (mInterstitialAd != null) {
            mInterstitialAd.show(AccueilActivity.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }

    protected class AsyncTaskRunnerPrepopulate extends AsyncTask<Void, Integer, Void> {

        protected void onPreExecute() {
            Log.e("tag", "import affiche progress");
            progressBar.setVisibility(View.VISIBLE);
        }

        protected Void doInBackground(Void... voids) {
            remplirDbSiEntryVide(db);
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e("tag","import FINI !!!!!!!!!!!!!!!!!!!!!!");
            progressBar.setVisibility(View.GONE);
        }
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

    public void afficherEvenements(View view) {
        ouvrirActiviteSuivante(this, AfficherEvenementsActivity.class,false);
    }

    public void afficherEntriesDivers(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesDiversActivity.class,false);
    }

    public void afficherMesFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherFavorisActivity.class,false);
    }

    public void forcerDateEntry(View view) {
        DateMaj date = dateMajDao.load(1l);
        date.setDateMajEntry("01/01/2022");
        dateMajDao.update(date);
    }

    public void majDb(View view) {
        /*evenementEntityDao.deleteByKey(114l);
        List<JoinEvenementEntityWithEvenementProfileEntity> list = joinEvenementEntityWithEvenementProfileEntityDao.queryRaw("where evenement_entity_id = 114");
        for (JoinEvenementEntityWithEvenementProfileEntity current : list) {
            joinEvenementEntityWithEvenementProfileEntityDao.delete(current);
        }*/
        List<EvenementEntity> listEvent = evenementEntityDao.queryRaw("where favori = 1");
        List<EntryEntity> listEntry = entryEntityDao.queryRaw("where favori = 1");
        for (EvenementEntity event : listEvent) {
            event.setFavori(false);
            evenementEntityDao.update(event);
        }
        for (EntryEntity entry : listEntry) {
            entry.setFavori(false);
            entryEntityDao.update(entry);
        }
    }
}
