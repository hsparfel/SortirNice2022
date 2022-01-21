package com.pouillcorp.sortirnice.activities;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.entities.event.detail.DetailEvenementEntitySimple;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementAddressEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementDescriptionEntity;
import com.pouillcorp.sortirnice.enumeration.EvenementAdresseDetail;
import com.pouillcorp.sortirnice.enumeration.EvenementDescriptionLanguage;
import com.pouillcorp.sortirnice.enumeration.EvenementDescriptionType;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherEvenementDetailActivity extends NavDrawerActivity {

    EvenementEntity eventTransmis;
    //EventSauvegardeEntity eventSauvegardeTransmis;

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
    @BindView(R.id.bloc_description_tarification)
    LinearLayout blocDescriptionTarification;
    @BindView(R.id.bloc_description_horaires)
    LinearLayout blocDescriptionHoraires;
    @BindView(R.id.bloc_date)
    LinearLayout blocDate;
    @BindView(R.id.bloc_phone)
    LinearLayout blocPhone;
    @BindView(R.id.bloc_email)
    LinearLayout blocEmail;
    @BindView(R.id.bloc_website)
    LinearLayout blocWebsite;
    @BindView(R.id.bloc_station)
    LinearLayout blocStation;
    @BindView(R.id.bloc_option)
    LinearLayout blocOption;
    @BindView(R.id.bloc_sector)
    LinearLayout blocSector;

    Bitmap bitmap = null;

    @BindView(R.id.fabExit)
    FloatingActionButton fabExit;
    @BindView(R.id.fabFavoriAdd)
    FloatingActionButton fabFavoriAdd;
    @BindView(R.id.fabFavoriSuppr)
    FloatingActionButton fabFavoriSuppr;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    boolean isSauvegarde;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_detail_evenement);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        traiterIntent();
        setTitle("Detail");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_evenement).setChecked(true);
    }

    public void changerCouleur() {
        if (eventTransmis.getFavori()) {
            scrollView.setBackgroundColor(getResources().getColor(R.color.favori));
        } else {
            scrollView.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("eventId")) {
            isSauvegarde = false;
            Long eventId = intent.getLongExtra("eventId", 0);
            eventTransmis = evenementEntityDao.load(eventId);
            fillAllFields();
            hideFields();
            AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
            runnerImage.execute();
            changerCouleur();
        }
    }

    private boolean isListDescriptionRenseigne(List<EvenementDescriptionEntity> listDescription, EvenementDescriptionType type) {
        if (listDescription != null && listDescription.size() > 0) {
            for (EvenementDescriptionEntity current : listDescription) {
                if (current.getType().equalsIgnoreCase(type.toString())
                        && current.getValue() != null && !current.getValue().equalsIgnoreCase("")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void hideFields() {
            if (eventTransmis.getImage() == null) {
                image.setVisibility(View.GONE);
            }
            if (eventTransmis.getNameFr() == null) {
                nameFr.setVisibility(View.GONE);
            }
            if (eventTransmis.getListCategories().size() == 0) {
                category.setVisibility(View.GONE);
            }
            if (!isListDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Horaires)) {
                blocDescriptionHoraires.setVisibility(View.GONE);
            }
            if (!isListDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Situation)) {
                descriptionSituation.setVisibility(View.GONE);
            }
            if (!isListDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Tarification)) {
                blocDescriptionTarification.setVisibility(View.GONE);
            }
            if (!isListDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Description)) {
                descriptionDescription.setVisibility(View.GONE);
            }
            if (eventTransmis.getStart() == null) {
                blocDate.setVisibility(View.GONE);
            }
            if (eventTransmis.getEnd() == null || eventTransmis.getEnd().equalsIgnoreCase(eventTransmis.getStart())) {
                end.setVisibility(View.GONE);
            }
            if (eventTransmis.getListAddresses().size() == 0) {
                adressContent.setVisibility(View.GONE);
                adressZip.setVisibility(View.GONE);
                adressCity.setVisibility(View.GONE);
            }
            if (eventTransmis.getPhone() == null) {
                blocPhone.setVisibility(View.GONE);
            }
            if (eventTransmis.getEmail() == null) {
                blocEmail.setVisibility(View.GONE);
            }
            if (eventTransmis.getWebsiteSituation() == null && eventTransmis.getWebsitePrincipal() == null){
                blocWebsite.setVisibility(View.GONE);
            }
            if (eventTransmis.getWebsiteSituation() == null) {
                websiteSituation.setVisibility(View.GONE);
            }
            if (eventTransmis.getWebsitePrincipal() == null) {
                websitePrincipal.setVisibility(View.GONE);
            }
            if (eventTransmis.getListProfiles().size() == 0) {
                profile.setVisibility(View.GONE);
            }
            if (eventTransmis.getListStations().size() == 0) {
                blocStation.setVisibility(View.GONE);
            }
            if (eventTransmis.getListOptions().size() == 0) {
                blocOption.setVisibility(View.GONE);
            }
            if (eventTransmis.getListSectos().size() == 0) {
                blocSector.setVisibility(View.GONE);
            }
        if (eventTransmis.getFavori()) {
            fabFavoriAdd.setVisibility(View.GONE);
        } else {
            fabFavoriSuppr.setVisibility(View.GONE);
        }
    }

    private String getDescriptionRenseigne(List<EvenementDescriptionEntity> listDescription, EvenementDescriptionType type) {
        if (listDescription != null && listDescription.size() > 0) {
            for (EvenementDescriptionEntity current : listDescription) {
                if (current.getType().equalsIgnoreCase(type.toString())){
                    if (current.getLanguage().equalsIgnoreCase(EvenementDescriptionLanguage.Fr.toString())){
                       if (current.getValue() != null && !current.getValue().equalsIgnoreCase("")){
                           return current.getValue();
                       }
                    } else if (current.getLanguage().equalsIgnoreCase(EvenementDescriptionLanguage.En.toString())){
                        if (current.getValue() != null && !current.getValue().equalsIgnoreCase("")){
                            return current.getValue();
                        }
                    }
                }
            }
        }
        return null;
    }

    private String getAdresseRenseignee(List<EvenementAddressEntity> listAdresse, EvenementAdresseDetail detail) {
        if (listAdresse != null && listAdresse.size() > 0) {
            for (EvenementAddressEntity current : listAdresse) {
                if (current.getType().equalsIgnoreCase("situation")){
                    if (detail.toString().equalsIgnoreCase(EvenementAdresseDetail.Adresse.toString())){
                        if (current.getAddressContent() != null && !current.getAddressContent().equalsIgnoreCase("")){
                            return current.getAddressContent();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EvenementAdresseDetail.Zip.toString())){
                        if (current.getZip() != null && !current.getZip().equalsIgnoreCase("")){
                            return current.getZip();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EvenementAdresseDetail.Ville.toString())){
                        if (current.getCity() != null && !current.getCity().equalsIgnoreCase("")){
                            return current.getCity();
                        }
                    }
                } else {
                    if (detail.toString().equalsIgnoreCase(EvenementAdresseDetail.Adresse.toString())){
                        if (current.getAddressContent() != null && !current.getAddressContent().equalsIgnoreCase("")){
                            return current.getAddressContent();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EvenementAdresseDetail.Zip.toString())){
                        if (current.getZip() != null && !current.getZip().equalsIgnoreCase("")){
                            return current.getZip();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EvenementAdresseDetail.Ville.toString())){
                        if (current.getCity() != null && !current.getCity().equalsIgnoreCase("")){
                            return current.getCity();
                        }
                    }
                }
            }
        }
        return null;
    }

    private String getDetailListe(List<? extends DetailEvenementEntitySimple> list) {
        String reponse = "";
        int cptr = 0;
        if (list != null && list.size() > 0) {
            for (DetailEvenementEntitySimple current : list) {
                if (cptr == 0) {
                    reponse += current.getValue();
                    cptr++;
                } else {
                    reponse += " / "+current.getValue();
                }
            }
            return reponse;
        }
        return null;
    }

    private void fillAllFields() {
            nameFr.setText(eventTransmis.getNameFr());
            category.setText(getDetailListe(eventTransmis.getListCategories()));
            descriptionDescription.setText(getDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Description));
            descriptionHoraires.setText(getDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Horaires));
            descriptionSituation.setText(getDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Situation));
            descriptionTarification.setText(getDescriptionRenseigne(eventTransmis.getListDescriptions(), EvenementDescriptionType.Tarification));
            start.setText(DateUtils.formatDateDD_MM_YYYY(eventTransmis.getStart()));
            end.setText(" au "+DateUtils.formatDateDD_MM_YYYY(eventTransmis.getEnd()));
            adressContent.setText(getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Adresse));
            adressZip.setText(getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Zip));
            adressCity.setText(getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Ville));
            phone.setText(eventTransmis.getPhone());
            email.setText(eventTransmis.getEmail());
            websiteSituation.setText(eventTransmis.getWebsiteSituation());
            websitePrincipal.setText(eventTransmis.getWebsitePrincipal());
            profile.setText(getDetailListe(eventTransmis.getListProfiles()));
            station.setText(getDetailListe(eventTransmis.getListStations()));
            option.setText(getDetailListe(eventTransmis.getListOptions()));
            secto.setText(getDetailListe(eventTransmis.getListSectos()));
    }

    private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url;
            bitmap = null;
                if (eventTransmis.getImage()!= null && eventTransmis.getImage().length()>0) {
                    try {
                        url = new URL(eventTransmis.getImage());
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
        }
    }

    public void exit(View view) {
        finish();
    }

    public void favoriAdd(View view) {
        eventTransmis.setFavori(true);
        evenementEntityDao.update(eventTransmis);
        fabFavoriAdd.setVisibility(View.GONE);
        fabFavoriSuppr.setVisibility(View.VISIBLE);
        changerCouleur();
        Log.e("TAG", "Add Favori : "+eventTransmis.getNameFr());
    }

    public void favoriDelete(View view) {
        eventTransmis.setFavori(false);
        evenementEntityDao.update(eventTransmis);
        fabFavoriAdd.setVisibility(View.VISIBLE);
        fabFavoriSuppr.setVisibility(View.GONE);
        changerCouleur();
        Log.e("TAG", "Suppr Favori : "+eventTransmis.getNameFr());
    }

    public void launchGoogleMap(View view) {
        String url = "geo:";
        String addr = "";
        if (eventTransmis.getLatitude() != 0 && eventTransmis.getLongitude() != 0) {
            url += eventTransmis.getLatitude()+","+eventTransmis.getLongitude();
            url += "?q="+eventTransmis.getLatitude()+","+eventTransmis.getLongitude();
        } else if (getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Adresse) != null
                    || getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Zip) != null
                    || getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Ville) != null) {
            url += "0,0?q=";
            addr += Uri.parse(getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Adresse)
                                +" "+ getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Zip)
                                +" "+ getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Ville));
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
            if (eventTransmis.getLatitude() !=0d && eventTransmis.getLongitude()!=0d) {
                url = "https://waze.com/ul?ll=";
                url += eventTransmis.getLatitude()+","+eventTransmis.getLongitude()+"&navigate=yes";
            } else {
                url = "https://waze.com/ul?q=";
                url += getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Adresse)
                        +" " + getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Zip)
                        +" " + getAdresseRenseignee(eventTransmis.getListAddresses(), EvenementAdresseDetail.Ville);
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

    public void launchMoovIt(View view) {
        try {
            PackageManager pm = App.getInstance().getApplicationContext().getPackageManager();
            pm.getPackageInfo("com.tranzmate", PackageManager.GET_ACTIVITIES);
            String uri ="moovit://directions?dest_lat="
                    +eventTransmis.getLatitude()
                    +"&dest_lon="
                    +eventTransmis.getLongitude()
                    +"&auto_run=true";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uri));
            startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            String url = "http://app.appsflyer.com/com.tranzmate?pid=DL&c=";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    }
}