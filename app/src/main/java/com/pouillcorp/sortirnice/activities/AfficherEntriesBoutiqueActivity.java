package com.pouillcorp.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.email.SendEmailService;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillcorp.sortirnice.modelentries.Affiliation;
import com.pouillcorp.sortirnice.modelentries.AllianceOption;
import com.pouillcorp.sortirnice.modelentries.Amenity;
import com.pouillcorp.sortirnice.modelentries.Animation;
import com.pouillcorp.sortirnice.modelentries.Atmospher;
import com.pouillcorp.sortirnice.modelentries.Category;
import com.pouillcorp.sortirnice.modelentries.Chain;
import com.pouillcorp.sortirnice.modelentries.Commercia;
import com.pouillcorp.sortirnice.modelentries.CommonTag;
import com.pouillcorp.sortirnice.modelentries.DisabledOption;
import com.pouillcorp.sortirnice.modelentries.Entries;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.modelentries.FamilyOption;
import com.pouillcorp.sortirnice.modelentries.FrpOption;
import com.pouillcorp.sortirnice.modelentries.FurnishedRental;
import com.pouillcorp.sortirnice.modelentries.GroupOption;
import com.pouillcorp.sortirnice.modelentries.Label;
import com.pouillcorp.sortirnice.modelentries.Location;
import com.pouillcorp.sortirnice.modelentries.Option;
import com.pouillcorp.sortirnice.modelentries.PoiOption;
import com.pouillcorp.sortirnice.modelentries.Profile;
import com.pouillcorp.sortirnice.modelentries.Publication;
import com.pouillcorp.sortirnice.modelentries.RentalMonth;
import com.pouillcorp.sortirnice.modelentries.Sector;
import com.pouillcorp.sortirnice.modelentries.Service;
import com.pouillcorp.sortirnice.modelentries.Sleeping;
import com.pouillcorp.sortirnice.modelentries.StandingLevel;
import com.pouillcorp.sortirnice.modelentries.Station;
import com.pouillcorp.sortirnice.utils.DateUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEntriesBoutiqueActivity extends NavDrawerEntryActivity  {

    //private EntriesType entryType = EntriesType.Boutique;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_entry_various);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        setTitle(R.string.boutiques);
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_entry).setChecked(true);
        Log.e("verif menuItemB1", "menuItem : "+menuItems);
        Log.e("verif itemB1", "item : "+item);
        connectAndGetApiData(myUrl);

        entryType = EntriesType.Boutique;
    }



    public void connectAndGetApiData(String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        EntriesBoutiqueApiService entriesBoutiqueApiService = retrofit.create(EntriesBoutiqueApiService.class);
        Call<Entries> call = entriesBoutiqueApiService.getEntries();
        call.enqueue(new Callback<Entries>() {
            @Override
            public void onResponse(Call<Entries> call, Response<Entries> response) {
                if (response.code()==200) {
                    listEntries = response.body().getListEntries();
                    configureRecyclerView();
                    isResponded = true;
                    Log.d(TAG, "Number of entries received: " + listEntries.size());
                    listerFiltre();
                    initListFiltres();
                    afficherFiltreNonVide();
                    initCheckboxesTitreClick();
                    initCheckboxesSelectAllClick();
                    progressBar.setVisibility(View.GONE);
                    Log.e("verif menuItemB2", "menuItem : "+menuItems);
                    Log.e("verif itemB2", "item : "+item);
                    item = menuItems.findItem(R.id.menu_activity_main_entry_filter);
                    item.setVisible(true);

                } else {
                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    Log.e("TAG", "date rch : "+dateDemandeString);
                    myUrl = BASE_URL+dateDemandeString+"/";
                    connectAndGetApiData(myUrl);
                }
            }

            @Override
            public void onFailure(Call<Entries> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
                gererErreur(EntriesType.Boutique,throwable.toString());
            }
        });
    }


}