package com.pouillos.sortirnice.activities;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.pouillos.sortirnice.App;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.entry.EntryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryGridEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOpeningEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStationEntity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherEntryHebergementDetailActivity extends NavDrawerActivity {

    EntryEntity entryTransmis;

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name_fr)
    TextView nameFr;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.address_line1)
    TextView addressLine1;
    @BindView(R.id.address_line2)
    TextView addressLine2;
    @BindView(R.id.address_line3)
    TextView addressLine3;
    @BindView(R.id.address_zip)
    TextView addressZip;
    @BindView(R.id.address_city)
    TextView addressCity;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.fax)
    TextView fax;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.website)
    TextView website;
    @BindView(R.id.facebook)
    TextView facebook;
    @BindView(R.id.twitter)
    TextView twitter;
    @BindView(R.id.station)
    TextView station;
    @BindView(R.id.option)
    TextView option;
    @BindView(R.id.payment)
    TextView payment;
    @BindView(R.id.amenity)
    TextView amenity;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.closure)
    TextView closure;
    @BindView(R.id.label)
    TextView label;
    @BindView(R.id.service)
    TextView service;
    @BindView(R.id.opening)
    TextView opening;
    @BindView(R.id.closing)
    TextView closing;
    @BindView(R.id.openings)
    TextView openings;
    @BindView(R.id.closings)
    TextView closings;
    @BindView(R.id.animation)
    TextView animation;
    @BindView(R.id.atmosphere)
    TextView atmosphere;
    @BindView(R.id.capacity_total)
    TextView capacityTotal;
    @BindView(R.id.capacity_interieur)
    TextView capacityInterieur;
    @BindView(R.id.capacity_exterieur)
    TextView capacityExterieur;
    @BindView(R.id.capacity_assis)
    TextView capacityAssis;
    @BindView(R.id.capacity_debout)
    TextView capacityDebout;
    @BindView(R.id.capacity_group)
    TextView capacityGroup;
    @BindView(R.id.capacity_salle)
    TextView capacitySalle;
    @BindView(R.id.layout_address)
    LinearLayout layoutAddress;
    @BindView(R.id.boutons_map_waze)
    LinearLayout boutonsMapWaze;
    @BindView(R.id.ouvert)
    LinearLayout ouvert;
    @BindView(R.id.ferme)
    LinearLayout ferme;
    @BindView(R.id.layout_payment)
    LinearLayout layoutPayment;
    @BindView(R.id.layout_label)
    LinearLayout layoutLabel;
    @BindView(R.id.layout_animation)
    LinearLayout layoutAnimation;

    Bitmap bitmap = null;
    String newLine = System.getProperty("line.separator");

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_detail_entry_hebergement);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        traiterIntent();
        setTitle("Detail Hebergement");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
    }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("entryId")) {
            Long entryId = intent.getLongExtra("entryId", 0);
            entryTransmis = entryEntityDao.load(entryId);
            fillAllFields();
            hideFields();
            AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
            runnerImage.execute();
        }
    }

    private void hideFields() {
        if (entryTransmis.getNameFr() == null) {
            nameFr.setVisibility(View.GONE);
        }
        if (entryTransmis.getListCategories() == null || entryTransmis.getListCategories().size() == 0) {
            category.setVisibility(View.GONE);
        }
        if (entryTransmis.getListLocations() == null || entryTransmis.getListLocations().size() == 0) {
            location.setVisibility(View.GONE);
        }
        if (entryTransmis.getListAtmosphere() == null || entryTransmis.getListAtmosphere().size() == 0) {
            atmosphere.setVisibility(View.GONE);
        }
        if (entryTransmis.getListServices() == null || entryTransmis.getListServices().size() == 0) {
            service.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress() == null && (entryTransmis.getListStations() == null || entryTransmis.getListStations().size() == 0)) {
            layoutAddress.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress() == null) {
            boutonsMapWaze.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getAddressLine1() == null) {
            addressLine1.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getAddressLine2() == null) {
            addressLine2.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getAddressLine3() == null) {
            addressLine3.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getZip() == null) {
            addressZip.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getCity() == null) {
            addressCity.setVisibility(View.GONE);
        }
        if (entryTransmis.getListStations() == null || entryTransmis.getListStations().size() == 0) {
            station.setVisibility(View.GONE);
        }
        if (entryTransmis.getPhone() == null) {
            phone.setVisibility(View.GONE);
        }
        if (entryTransmis.getFax() == null) {
            fax.setVisibility(View.GONE);
        }
        if (entryTransmis.getEmail() == null) {
            email.setVisibility(View.GONE);
        }
        if (entryTransmis.getWebsite() == null) {
            website.setVisibility(View.GONE);
        }
        if (entryTransmis.getFacebook() == null) {
            facebook.setVisibility(View.GONE);
        }
        if (entryTransmis.getTwitter() == null) {
            twitter.setVisibility(View.GONE);
        }
        if (entryTransmis.getListPayments() == null || entryTransmis.getListPayments().size() == 0) {
            layoutPayment.setVisibility(View.GONE);
        }
        if ((entryTransmis.getListOpenings() == null || entryTransmis.getListOpenings().size() == 0) && entryTransmis.getOpening() == null) {
            ouvert.setVisibility(View.GONE);
        }
        if (entryTransmis.getListOpenings() == null|| entryTransmis.getListOpenings().size() == 0) {
            openings.setVisibility(View.GONE);
        }
        if (entryTransmis.getOpening() == null) {
            opening.setVisibility(View.GONE);
        }
        if ((entryTransmis.getListClosings() == null || entryTransmis.getListClosings().size() == 0) && entryTransmis.getClosing() == null && (entryTransmis.getListClosures() == null || entryTransmis.getListClosures().size() == 0)) {
            ferme.setVisibility(View.GONE);
        }
        if (entryTransmis.getListClosings() == null || entryTransmis.getListClosings().size() == 0) {
            closings.setVisibility(View.GONE);
        }
        if (entryTransmis.getClosing() == null) {
            closing.setVisibility(View.GONE);
        }
        if (entryTransmis.getListClosures() == null || entryTransmis.getListClosures().size() == 0) {
            closure.setVisibility(View.GONE);
        }
        if (entryTransmis.getListLabels() == null || entryTransmis.getListLabels().size() == 0) {
            layoutLabel.setVisibility(View.GONE);
        }
        if (entryTransmis.getListAnimations() == null || entryTransmis.getListAnimations().size() == 0) {
            layoutAnimation.setVisibility(View.GONE);
        }
        if (entryTransmis.getListOptions() == null || entryTransmis.getListOptions().size() == 0) {
            option.setVisibility(View.GONE);
        }
        if (entryTransmis.getListAmenities() == null || entryTransmis.getListAmenities().size() == 0) {
            amenity.setVisibility(View.GONE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getGroup() == 0) {
            capacityGroup.setVisibility(View.GONE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getCocktail() == 0) {
            capacityDebout.setVisibility(View.GONE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getSeated() == 0) {
            capacityAssis.setVisibility(View.GONE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getOutdoor() == 0) {
            capacityExterieur.setVisibility(View.GONE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getIndoor() == 0) {
            capacityInterieur.setVisibility(View.GONE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getTotal() == 0) {
            capacityTotal.setVisibility(View.GONE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getRoomCount() == 0) {
            capacitySalle.setVisibility(View.GONE);
        }
          }

    private void fillAllFields() {
        nameFr.setText(entryTransmis.getNameFr());
        addressLine1.setText(entryTransmis.getAddress().getAddressLine1());
        addressLine2.setText(entryTransmis.getAddress().getAddressLine2());
        addressLine3.setText(entryTransmis.getAddress().getAddressLine3());
        addressZip.setText(entryTransmis.getAddress().getZip());
        addressCity.setText(entryTransmis.getAddress().getCity());
        phone.setText("Tel: "+entryTransmis.getPhone());
        fax.setText("Fax: "+entryTransmis.getFax());
        email.setText("Email: "+entryTransmis.getEmail());
        website.setText("Site: "+entryTransmis.getWebsite());
        facebook.setText("Fb: "+entryTransmis.getFacebook());
        twitter.setText("Twitter: "+entryTransmis.getTwitter());
        opening.setText(entryTransmis.getOpening());
        closing.setText(entryTransmis.getClosing());
        capacityTotal.setText("Cap. Total: "+entryTransmis.getCapacity().getTotal()+" pers");
        capacityInterieur.setText("Cap. Intérieur: "+entryTransmis.getCapacity().getIndoor()+" pers");
        capacityExterieur.setText("Cap. Extérieur: "+entryTransmis.getCapacity().getOutdoor()+" pers");
        capacityAssis.setText("Cap. Assis: "+entryTransmis.getCapacity().getSeated()+" pers");
        capacityDebout.setText("Cap. Debout: "+entryTransmis.getCapacity().getCocktail()+" pers");
        capacityGroup.setText("Cap. Group: "+entryTransmis.getCapacity().getGroup()+" pers");
        capacitySalle.setText("Nb Salle: "+entryTransmis.getCapacity().getRoomCount());

        String paymentString = "";
        if (entryTransmis.getListPayments()!=null) {
            int i = 1;
            for (EntryPaymentEntity current : entryTransmis.getListPayments()) {
                paymentString += current.getValue();
                if (i < entryTransmis.getListPayments().size()) {
                    paymentString += " / ";
                }
                i++;
            }
        }
        payment.setText(paymentString);

        String amenityString = "";
        if (entryTransmis.getListAmenities()!=null) {
            int i = 1;
            for (EntryAmenityEntity current : entryTransmis.getListAmenities()) {
                amenityString += current.getValue();
                if (i < entryTransmis.getListAmenities().size()) {
                    amenityString += " / ";
                }
                i++;
            }
        }
        amenity.setText(amenityString);

        String locationString = "";
        if (entryTransmis.getListLocations()!=null) {
            int i = 1;
            for (EntryLocationEntity current : entryTransmis.getListLocations()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.metropole))) {
                    locationString += current.getValue();
                    if (i < entryTransmis.getListLocations().size()) {
                        locationString += " / ";
                    }
                }
                i++;
            }
        }
        location.setText(locationString);

        String closureString = "";
        if (entryTransmis.getListClosures()!=null) {
            int i = 1;
            for (EntryClosureEntity current : entryTransmis.getListClosures()) {
                closureString += current.getClosureDay() + " - "+current.getClosureSpan();
                if (i < entryTransmis.getListClosures().size()) {
                    closureString += " / ";
                }
                i++;
            }
        }
        closure.setText(closureString);

        String labelString = "";
        if (entryTransmis.getListLabels()!=null) {
            int i = 1;
            for (EntryLabelEntity current : entryTransmis.getListLabels()) {
                labelString += current.getValue();
                if (i < entryTransmis.getListLabels().size()) {
                    labelString += " / ";
                }
                i++;
            }
        }
        label.setText(labelString);

        String optionString = "";
        if (entryTransmis.getListOptions()!=null) {
            int i = 1;
            for (EntryOptionEntity current : entryTransmis.getListOptions()) {
                optionString += current.getValue();
                if (i < entryTransmis.getListOptions().size()) {
                    optionString += " / ";
                }
                i++;
            }
        }
        option.setText(optionString);

        String openingString = "";
        if (entryTransmis.getListOpenings()!=null) {
            int i = 1;
            int j = 1;
            for (EntryOpeningEntity current : entryTransmis.getListOpenings()) {
                openingString += current.getOpeningStart() + " - "+current.getOpeningEnd()+ " - "+current.getOpeningReplay()+newLine;
                for (EntryGridEntity currentGrid : current.getListGrids()) {
                    openingString+= currentGrid.getOpeningDays()+" - "+currentGrid.getOpeningHours();
                    if (j<current.getListGrids().size()){
                        openingString += " / ";
                    }
                    j++;
                }
                if (i < entryTransmis.getListOpenings().size()) {
                    openingString += " / ";
                }
                i++;
            }
        }
        openings.setText(openingString);

        String closingString = "";
        if (entryTransmis.getListClosings()!=null) {
            int i = 1;
            for (EntryClosingEntity current : entryTransmis.getListClosings()) {
                closingString += current.getValue();
                if (i < entryTransmis.getListClosings().size()) {
                    closingString += " / ";
                }
                i++;
            }
        }
        closings.setText(closingString);

        String serviceString = "";
        if (entryTransmis.getListServices()!=null) {
            int i = 1;
            for (EntryServiceEntity current : entryTransmis.getListServices()) {
                serviceString += current.getValue();
                if (i < entryTransmis.getListServices().size()) {
                    serviceString += " / ";
                }
                i++;
            }
        }
        service.setText(serviceString);

        String stationString = "";
        if (entryTransmis.getListStations()!=null) {
            int i = 1;
            for (EntryStationEntity current : entryTransmis.getListStations()) {
                stationString += current.getValue();
                if (i < entryTransmis.getListStations().size()) {
                    stationString += " / ";
                }
                i++;
            }
        }
        station.setText(stationString);

        String animationString = "";
        if (entryTransmis.getListAnimations()!=null) {
            int i = 1;
            for (EntryAnimationEntity current : entryTransmis.getListAnimations()) {
                animationString += current.getValue();
                if (i < entryTransmis.getListAnimations().size()) {
                    animationString += " / ";
                }
                i++;
            }
        }
        animation.setText(animationString);

        String categoryString = "";
        if (entryTransmis.getListCategories()!=null) {
            int i = 1;
            for (EntryCategoryEntity current : entryTransmis.getListCategories()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))) {
                    categoryString += current.getValue();
                    if (i < entryTransmis.getListCategories().size()) {
                        categoryString += " / ";
                    }
                }
                i++;
            }
        }
        category.setText(categoryString);

        String atmosphereString = "";
        if (entryTransmis.getListAtmosphere()!=null) {
            int i = 1;
            for (EntryAtmospherEntity current : entryTransmis.getListAtmosphere()) {
                atmosphereString += current.getValue();
                if (i < entryTransmis.getListAtmosphere().size()) {
                    atmosphereString += " / ";
                }
                i++;
            }
        }
        atmosphere.setText(atmosphereString);
    }

    private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url = null;
            bitmap = null;
            if (entryTransmis.getListImages()!= null) {
                if (entryTransmis.getListImages().size()>0 && entryTransmis.getListImages().get(0).getUrl().length() > 0) {
                    try {
                        url = new URL(entryTransmis.getListImages().get(0).getUrl());
                        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                        httpConn.connect();
                        int resCode = httpConn.getResponseCode();
                        if (resCode == HttpURLConnection.HTTP_OK) {
                            InputStream in = httpConn.getInputStream();
                            bitmap = BitmapFactory.decodeStream(in);
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            if (bitmap != null) {
                image.setImageBitmap(bitmap);
            } else {
                image.setImageResource(R.drawable.outline_camera);
                image.setVisibility(View.GONE);
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        protected void onProgressUpdate(Integer... integer) {
            //progressBar.setProgress(integer[0],true);
        }
    }

    public void exit(View view) {
        finish();
    }

    public void launchGoogleMap(View view) {
        String url = "geo:";
        String addr = "";
        if (entryTransmis.getLatitude() != 0 && entryTransmis.getLongitude() != 0) {
            url += entryTransmis.getLatitude()+","+entryTransmis.getLongitude();
            url += "?q="+entryTransmis.getLatitude()+","+entryTransmis.getLongitude();
        } else if (entryTransmis.getAddress().getAddressLine1() != null
                || entryTransmis.getAddress().getAddressLine2() != null
                || entryTransmis.getAddress().getAddressLine3() != null
                || entryTransmis.getAddress().getZip() != null
                || entryTransmis.getAddress().getCity() != null) {
            url += "0,0?q=";
            addr += Uri.parse(entryTransmis.getAddress().getAddressLine1()
                    +" "+entryTransmis.getAddress().getAddressLine2()
                    +" "+entryTransmis.getAddress().getAddressLine3()
                    +" "+entryTransmis.getAddress().getZip()
                    +" "+entryTransmis.getAddress().getCity());
            url += addr;
        }
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void launchWaze(View view) {
        try
        {
            String url = "";
            if (entryTransmis.getLatitude() !=0d && entryTransmis.getLongitude()!=0d) {
                url = "https://waze.com/ul?ll=";
                url += entryTransmis.getLatitude()+","+entryTransmis.getLongitude()+"&navigate=yes";
            } else {
                url = "https://waze.com/ul?q=";
                url += entryTransmis.getAddress().getAddressLine1()
                        +" " +entryTransmis.getAddress().getAddressLine2()
                        +" " +entryTransmis.getAddress().getAddressLine3()
                        +" " +entryTransmis.getAddress().getZip()
                        +" " + entryTransmis.getAddress().getCity();
            }
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
            startActivity( intent );
        }
        catch ( ActivityNotFoundException ex  )
        {
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
            startActivity(intent);
        }
    }
}

