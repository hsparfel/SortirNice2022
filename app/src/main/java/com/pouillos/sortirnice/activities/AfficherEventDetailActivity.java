package com.pouillos.sortirnice.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.Episode;
import com.pouillos.sortirnice.entities.EventEntity;
import com.pouillos.sortirnice.entities.Saison;
import com.pouillos.sortirnice.entities.Serie;
import com.pouillos.sortirnice.enumeration.Langage;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterSaison;
import com.pouillos.sortirnice.utils.BasicUtils;
import com.pouillos.sortirnice.utils.DateUtils;
import com.pouillos.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;

public class AfficherEventDetailActivity extends NavDrawerActivity {

    EventEntity eventTransmis;

    @BindView(R.id.name_fr)
    TextView nameFr;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.description_description)
    TextView descriptionDescription;

    @BindView(R.id.start)
    TextView start;
    @BindView(R.id.end)
    TextView end;
    @BindView(R.id.adress_content)
    TextView adressContent;
    @BindView(R.id.adress_zip)
    TextView adressZip;
    @BindView(R.id.adress_city)
    TextView adressCity;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.website_situation)
    TextView websiteSituation;
    @BindView(R.id.website_principal)
    TextView websitePrincipal;
    @BindView(R.id.profile)
    TextView profile;
    @BindView(R.id.station)
    TextView station;
    @BindView(R.id.option)
    TextView option;
    @BindView(R.id.secto)
    TextView secto;
    @BindView(R.id.description_situation)
    TextView descriptionSituation;
    @BindView(R.id.description_tarification)
    TextView descriptionTarification;
    @BindView(R.id.description_horaires)
    TextView descriptionHoraires;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_detail_event);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        traiterIntent();
        setTitle("Detail");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
    }

    public void exit(View view) {
        finish();
    }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("eventId")) {
            Long eventId = intent.getLongExtra("eventId", 0);
            eventTransmis = eventEntityDao.load(eventId);
            fillAllFields();
            hideFields();
        }
    }

    private void hideFields() {
        if (eventTransmis.getNameFr() == null) {
            nameFr.setVisibility(View.GONE);
        }
        if (eventTransmis.getCategory() == null) {
            category.setVisibility(View.GONE);
        }
        if (eventTransmis.getDescriptionDescription() == null) {
            descriptionDescription.setVisibility(View.GONE);
        }
        if (eventTransmis.getDescriptionHoraires() == null) {
            descriptionHoraires.setVisibility(View.GONE);
        }
        if (eventTransmis.getDescriptionSituation() == null) {
            descriptionSituation.setVisibility(View.GONE);
        }
        if (eventTransmis.getDescriptionTarification() == null) {
            descriptionTarification.setVisibility(View.GONE);
        }
        if (eventTransmis.getStart() == null) {
            start.setVisibility(View.GONE);
        }
        if (eventTransmis.getEnd() == null || eventTransmis.getEnd()==eventTransmis.getStart()) {
            end.setVisibility(View.GONE);
        }
        if (eventTransmis.getAdressContent() == null) {
            adressContent.setVisibility(View.GONE);
        }
        if (eventTransmis.getAdressZip() == null) {
            adressZip.setVisibility(View.GONE);
        }
        if (eventTransmis.getAdressCity() == null) {
            adressCity.setVisibility(View.GONE);
        }
        if (eventTransmis.getPhone() == null) {
            phone.setVisibility(View.GONE);
        }
        if (eventTransmis.getEmail() == null) {
            email.setVisibility(View.GONE);
        }
        if (eventTransmis.getWebsiteSituation() == null) {
            websiteSituation.setVisibility(View.GONE);
        }
        if (eventTransmis.getWebsitePrincipal() == null) {
            websitePrincipal.setVisibility(View.GONE);
        }
        if (eventTransmis.getProfile() == null) {
            profile.setVisibility(View.GONE);
        }
        if (eventTransmis.getStation() == null) {
            station.setVisibility(View.GONE);
        }
        if (eventTransmis.getOption() == null) {
            option.setVisibility(View.GONE);
        }
        if (eventTransmis.getSecto() == null) {
            secto.setVisibility(View.GONE);
        }
    }

    private void fillAllFields() {
        nameFr.setText(eventTransmis.getNameFr());
        category.setText(eventTransmis.getCategory());
        descriptionDescription.setText(eventTransmis.getDescriptionDescription());
        descriptionHoraires.setText("Horaires: "+eventTransmis.getDescriptionHoraires());
        descriptionSituation.setText("Lieu: "+eventTransmis.getDescriptionSituation());
        descriptionTarification.setText("Tarif: "+eventTransmis.getDescriptionTarification());
        start.setText("Date: "+ DateUtils.formatDateDD_MM_YYYY(eventTransmis.getStart()));
        end.setText(" au "+DateUtils.formatDateDD_MM_YYYY(eventTransmis.getEnd()));
        adressContent.setText(eventTransmis.getAdressContent());
        adressZip.setText(eventTransmis.getAdressZip());
        adressCity.setText(eventTransmis.getAdressCity());
        phone.setText("Tel: "+eventTransmis.getPhone());
        email.setText("email: "+eventTransmis.getEmail());
        websiteSituation.setText("site: "+eventTransmis.getWebsiteSituation());
        websitePrincipal.setText("site: "+eventTransmis.getWebsitePrincipal());
        profile.setText(eventTransmis.getProfile());
        station.setText(eventTransmis.getStation());
        option.setText(eventTransmis.getOption());
        secto.setText(eventTransmis.getSecto());
    }










}

