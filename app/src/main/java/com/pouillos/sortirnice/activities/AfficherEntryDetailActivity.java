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
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.pouillos.sortirnice.App;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.entry.EntryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryChainEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDisabledOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryGridEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLanguageEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOpeningEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryProfileEntity;
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

public class AfficherEntryDetailActivity extends NavDrawerActivity {

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

    Bitmap bitmap = null;
    String newLine = System.getProperty("line.separator");

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_detail_entry);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        traiterIntent();
        setTitle("Detail Entry");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
        //linkSetup();
    }



    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("entryId")) {
            Long entryId = intent.getLongExtra("entryId", 0);
            entryTransmis = entryEntityDao.load(entryId);
            fillAllFields();
         //   hideFields();
            AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
            runnerImage.execute();
        }
    }

    private void hideFields() {
        if (entryTransmis.getNameFr() == null) {
            nameFr.setVisibility(View.GONE);
        }
        /*if (eventTransmis.getCategory() == null) {
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
        if (eventTransmis.getEnd() == null || eventTransmis.getEnd().equalsIgnoreCase(eventTransmis.getStart())) {
            end.setVisibility(View.GONE);
        }*/
        if (entryTransmis.getAddress().getAddressLine1() == null) {
            addressLine1.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getAddressLine2() == null) {
            addressLine1.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getAddressLine2() == null) {
            addressLine1.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getZip() == null) {
            addressZip.setVisibility(View.GONE);
        }
        if (entryTransmis.getAddress().getCity() == null) {
            addressCity.setVisibility(View.GONE);
        }
        if (entryTransmis.getPhone() == null) {
            phone.setVisibility(View.GONE);
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
        if (entryTransmis.getListPayments() == null) {
            payment.setVisibility(View.GONE);
        }

        if (entryTransmis.getListAmenities() == null) {
            amenity.setVisibility(View.GONE);
        }
        if (entryTransmis.getListLocations() == null) {
            location.setVisibility(View.GONE);
        }
        if (entryTransmis.getListClosures() == null) {
            closure.setVisibility(View.GONE);
        }
        if (entryTransmis.getListLabels() == null) {
            label.setVisibility(View.GONE);
        }









        /*if (eventTransmis.getStation() == null) {
            station.setVisibility(View.GONE);
        }
        if (eventTransmis.getOption() == null) {
            option.setVisibility(View.GONE);
        }
        if (eventTransmis.getSecto() == null) {
            secto.setVisibility(View.GONE);
        }*/
    }

    private void fillAllFields() {
        nameFr.setText("name: "+entryTransmis.getNameFr());
        //category.setText(eventTransmis.getCategory());
        //descriptionDescription.setText(eventTransmis.getDescriptionDescription());
        //descriptionHoraires.setText("Horaires: "+eventTransmis.getDescriptionHoraires());
        //descriptionSituation.setText(eventTransmis.getDescriptionSituation());
        //descriptionTarification.setText("Tarif: "+eventTransmis.getDescriptionTarification());
        //start.setText("Date: "+ DateUtils.formatDateDD_MM_YYYY(eventTransmis.getStart()));
       // end.setText(" au "+DateUtils.formatDateDD_MM_YYYY(eventTransmis.getEnd()));
        addressLine1.setText("adr1: "+entryTransmis.getAddress().getAddressLine1());
        addressLine2.setText("adr2: "+entryTransmis.getAddress().getAddressLine2());
        addressLine3.setText("adr3: "+entryTransmis.getAddress().getAddressLine3());
        addressZip.setText("zip: "+entryTransmis.getAddress().getZip());
        addressCity.setText("city: "+entryTransmis.getAddress().getCity());
        phone.setText("Tel: "+entryTransmis.getPhone());
        fax.setText("Fax: "+entryTransmis.getFax());
        email.setText("Email: "+entryTransmis.getEmail());
        website.setText("Site: "+entryTransmis.getWebsite());

        facebook.setText("Fb: "+entryTransmis.getFacebook());
        twitter.setText("Twitter: "+entryTransmis.getTwitter());
        opening.setText("ouvert: "+entryTransmis.getOpening());
        closing.setText("ferme: "+entryTransmis.getClosing());




        capacityTotal.setText("Cap. Total: "+entryTransmis.getCapacity().getTotal()+" pers");
        capacityInterieur.setText("Cap. Total: "+entryTransmis.getCapacity().getIndoor()+" pers");
        capacityExterieur.setText("Cap. Total: "+entryTransmis.getCapacity().getOutdoor()+" pers");
        capacityAssis.setText("Cap. Total: "+entryTransmis.getCapacity().getSeated()+" pers");
        capacityDebout.setText("Cap. Total: "+entryTransmis.getCapacity().getCocktail()+" pers");
        capacityGroup.setText("Cap. Total: "+entryTransmis.getCapacity().getGroup()+" pers");
        capacitySalle.setText("Nb Salle: "+entryTransmis.getCapacity().getRoomCount());


        String paymentString = "payment: ";
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



        String amenityString = "amenity: ";
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

        String locationString = "location: ";
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

        String closureString = "closure: ";
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

        String labelString = "label: ";
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








        String optionString = "option: ";
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

        String openingString = "opening: ";
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

        String closingString = "closing: ";
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







        String serviceString = "service: ";
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



        String stationString = "station: ";
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



        String animationString = "animation: ";
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





        String categoryString = "category: ";
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

        String atmosphereString = "atmosphere: ";
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

