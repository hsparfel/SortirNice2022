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
import com.pouillos.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDisabledOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFrpOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryGroupOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLanguageEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPoiOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryProfileEntity;
import com.pouillos.sortirnice.entities.event.EventEntity;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Payment;
import com.pouillos.sortirnice.utils.DateUtils;

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
    @BindView(R.id.description_description)
    TextView descriptionDescription;

    @BindView(R.id.start)
    TextView start;
    @BindView(R.id.end)
    TextView end;
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
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.website)
    TextView website;
    @BindView(R.id.website_reservation)
    TextView websiteReservation;
    @BindView(R.id.facebook)
    TextView facebook;
    @BindView(R.id.twitter)
    TextView twitter;
    @BindView(R.id.profile)
    TextView profile;
    @BindView(R.id.station)
    TextView station;
    @BindView(R.id.option)
    TextView option;
    @BindView(R.id.disabled_option)
    TextView disabledOption;
    @BindView(R.id.frp_option)
    TextView frpOption;
    @BindView(R.id.poi_option)
    TextView poiOption;
    @BindView(R.id.group_option)
    TextView groupOption;
    @BindView(R.id.family_option)
    TextView familyOption;
    @BindView(R.id.secto)
    TextView secto;
    @BindView(R.id.description_situation)
    TextView descriptionSituation;
    @BindView(R.id.description_tarification)
    TextView descriptionTarification;
    @BindView(R.id.description_horaires)
    TextView descriptionHoraires;

    @BindView(R.id.payment)
    TextView payment;
    @BindView(R.id.language)
    TextView language;
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


    Bitmap bitmap = null;

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
            hideFields();
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
        if (entryTransmis.getWebsiteReservation() == null) {
            websiteReservation.setVisibility(View.GONE);
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
        if (entryTransmis.getListLanguages() == null) {
            language.setVisibility(View.GONE);
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
        if (entryTransmis.getListProfiles() == null) {
            profile.setVisibility(View.GONE);
        }
        if (entryTransmis.getListDisabledOptions() == null) {
            disabledOption.setVisibility(View.GONE);
        }
        if (entryTransmis.getListFrpOptions() == null) {
            frpOption.setVisibility(View.GONE);
        }
        if (entryTransmis.getListPoiOptions() == null) {
            poiOption.setVisibility(View.GONE);
        }
        if (entryTransmis.getListGroupOptions() == null) {
            profile.setVisibility(View.GONE);
        }
        if (entryTransmis.getListFamilyOptions() == null) {
            familyOption.setVisibility(View.GONE);
        }
        if (entryTransmis.getListGroupOptions() == null) {
            groupOption.setVisibility(View.GONE);
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
        nameFr.setText(entryTransmis.getNameFr());
        //category.setText(eventTransmis.getCategory());
        //descriptionDescription.setText(eventTransmis.getDescriptionDescription());
        //descriptionHoraires.setText("Horaires: "+eventTransmis.getDescriptionHoraires());
        //descriptionSituation.setText(eventTransmis.getDescriptionSituation());
        //descriptionTarification.setText("Tarif: "+eventTransmis.getDescriptionTarification());
        //start.setText("Date: "+ DateUtils.formatDateDD_MM_YYYY(eventTransmis.getStart()));
       // end.setText(" au "+DateUtils.formatDateDD_MM_YYYY(eventTransmis.getEnd()));
        addressLine1.setText(entryTransmis.getAddress().getAddressLine1());
        addressLine2.setText(entryTransmis.getAddress().getAddressLine2());
        addressLine3.setText(entryTransmis.getAddress().getAddressLine3());
        addressZip.setText(entryTransmis.getAddress().getZip());
        addressCity.setText(entryTransmis.getAddress().getCity());
        phone.setText("Tel: "+entryTransmis.getPhone());
        email.setText("Email: "+entryTransmis.getEmail());
        website.setText("Site: "+entryTransmis.getWebsite());
        websiteReservation.setText("Site: "+entryTransmis.getWebsiteReservation());
        facebook.setText("Site: "+entryTransmis.getFacebook());
        twitter.setText("Site: "+entryTransmis.getTwitter());

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

        String languageString = "";
        if (entryTransmis.getListLanguages()!=null) {
            int i = 1;
            for (EntryLanguageEntity current : entryTransmis.getListLanguages()) {
                languageString += current.getValue();
                if (i < entryTransmis.getListLanguages().size()) {
                    languageString += " / ";
                }
                i++;
            }
        }
        language.setText(languageString);

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
                locationString += current.getValue();
                if (i < entryTransmis.getListLocations().size()) {
                    locationString += " / ";
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

        String profileString = "";
        if (entryTransmis.getListProfiles()!=null) {
            int i = 1;
            for (EntryProfileEntity current : entryTransmis.getListProfiles()) {
                profileString += current.getValue();
                if (i < entryTransmis.getListProfiles().size()) {
                    profileString += " / ";
                }
                i++;
            }
        }
        profile.setText(" - "+profileString);

        String disabledOptionString = "";
        if (entryTransmis.getListDisabledOptions()!=null) {
            int i = 1;
            for (EntryDisabledOptionEntity current : entryTransmis.getListDisabledOptions()) {
                disabledOptionString += current.getValue();
                if (i < entryTransmis.getListDisabledOptions().size()) {
                    disabledOptionString += " / ";
                }
                i++;
            }
        }
        disabledOption.setText(disabledOptionString);

        String frpOptionString = "";
        if (entryTransmis.getListFrpOptions()!=null) {
            int i = 1;
            for (EntryFrpOptionEntity current : entryTransmis.getListFrpOptions()) {
                frpOptionString += current.getValue();
                if (i < entryTransmis.getListFrpOptions().size()) {
                    frpOptionString += " / ";
                }
                i++;
            }
        }
        frpOption.setText(frpOptionString);

        String poiOptionString = "";
        if (entryTransmis.getListPoiOptions()!=null) {
            int i = 1;
            for (EntryPoiOptionEntity current : entryTransmis.getListPoiOptions()) {
                poiOptionString += current.getValue();
                if (i < entryTransmis.getListPoiOptions().size()) {
                    poiOptionString += " / ";
                }
                i++;
            }
        }
        poiOption.setText(poiOptionString);

        String groupOptionString = "";
        if (entryTransmis.getListGroupOptions()!=null) {
            int i = 1;
            for (EntryGroupOptionEntity current : entryTransmis.getListGroupOptions()) {
                groupOptionString += current.getValue();
                if (i < entryTransmis.getListGroupOptions().size()) {
                    groupOptionString += " / ";
                }
                i++;
            }
        }
        groupOption.setText(groupOptionString);

        String familyOptionString = "";
        if (entryTransmis.getListFamilyOptions()!=null) {
            int i = 1;
            for (EntryFamilyOptionEntity current : entryTransmis.getListFamilyOptions()) {
                familyOptionString += current.getValue();
                if (i < entryTransmis.getListFamilyOptions().size()) {
                    familyOptionString += " / ";
                }
                i++;
            }
        }
        familyOption.setText(familyOptionString);

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






        //station.setText(eventTransmis.getStation());

        //secto.setText(eventTransmis.getSecto());
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

