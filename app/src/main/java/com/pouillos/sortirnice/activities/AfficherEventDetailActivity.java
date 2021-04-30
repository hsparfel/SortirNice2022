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


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.event.EventEntity;
import com.pouillos.sortirnice.entities.event.EventSauvegardeEntity;
import com.pouillos.sortirnice.utils.DateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherEventDetailActivity extends NavDrawerActivity {

    EventEntity eventTransmis;
    EventSauvegardeEntity eventSauvegardeTransmis;

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

    Bitmap bitmap = null;

    @BindView(R.id.fabExit)
    FloatingActionButton fabExit;
    @BindView(R.id.fabSave)
    FloatingActionButton fabSave;
    @BindView(R.id.fabDelete)
    FloatingActionButton fabDelete;

    boolean isSauvegarde;

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



    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("eventId")) {
            isSauvegarde = false;
            Long eventId = intent.getLongExtra("eventId", 0);
            eventTransmis = eventEntityDao.load(eventId);
            fillAllFields();
            hideFields();
            AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
            runnerImage.execute();
        } else if (intent.hasExtra("eventSauvegardeId")) {
            isSauvegarde = true;
            Long eventSauvegardeId = intent.getLongExtra("eventSauvegardeId", 0);
            eventSauvegardeTransmis = eventSauvegardeEntityDao.load(eventSauvegardeId);
            fillAllFields();
            hideFields();
            AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
            runnerImage.execute();
        }
    }

    private void hideFields() {
        if (!isSauvegarde) {
            if (eventTransmis.getImage() == null) {
                image.setVisibility(View.GONE);
            }
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
            if (eventTransmis.getEnd() == null || eventTransmis.getEnd().equalsIgnoreCase(eventTransmis.getStart())) {
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
            if (isEventAlreadySaved(eventTransmis)) {
                fabSave.hide();
            }
            fabDelete.hide();
        } else {
            if (eventSauvegardeTransmis.getImage() == null) {
                image.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getNameFr() == null) {
                nameFr.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getCategory() == null) {
                category.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getDescriptionDescription() == null) {
                descriptionDescription.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getDescriptionHoraires() == null) {
                descriptionHoraires.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getDescriptionSituation() == null) {
                descriptionSituation.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getDescriptionTarification() == null) {
                descriptionTarification.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getStart() == null) {
                start.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getEnd() == null || eventSauvegardeTransmis.getEnd().equalsIgnoreCase(eventSauvegardeTransmis.getStart())) {
                end.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getAdressContent() == null) {
                adressContent.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getAdressZip() == null) {
                adressZip.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getAdressCity() == null) {
                adressCity.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getPhone() == null) {
                phone.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getEmail() == null) {
                email.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getWebsiteSituation() == null) {
                websiteSituation.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getWebsitePrincipal() == null) {
                websitePrincipal.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getProfile() == null) {
                profile.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getStation() == null) {
                station.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getOption() == null) {
                option.setVisibility(View.GONE);
            }
            if (eventSauvegardeTransmis.getSecto() == null) {
                secto.setVisibility(View.GONE);
            }
            fabDelete.show();
            fabSave.hide();
        }

    }

    private void fillAllFields() {
        if (!isSauvegarde) {
            nameFr.setText(eventTransmis.getNameFr());
            category.setText(eventTransmis.getCategory());
            descriptionDescription.setText(eventTransmis.getDescriptionDescription());
            descriptionHoraires.setText("Horaires: "+eventTransmis.getDescriptionHoraires());
            descriptionSituation.setText(eventTransmis.getDescriptionSituation());
            descriptionTarification.setText("Tarif: "+eventTransmis.getDescriptionTarification());
            start.setText("Date: "+ DateUtils.formatDateDD_MM_YYYY(eventTransmis.getStart()));
            end.setText(" au "+DateUtils.formatDateDD_MM_YYYY(eventTransmis.getEnd()));
            adressContent.setText(eventTransmis.getAdressContent());
            adressZip.setText(eventTransmis.getAdressZip());
            adressCity.setText(eventTransmis.getAdressCity());
            phone.setText("Tel: "+eventTransmis.getPhone());
            email.setText("Email: "+eventTransmis.getEmail());
            websiteSituation.setText("Site: "+eventTransmis.getWebsiteSituation());
            websitePrincipal.setText("Site: "+eventTransmis.getWebsitePrincipal());
            profile.setText(" - "+eventTransmis.getProfile());
            station.setText(eventTransmis.getStation());
            option.setText(eventTransmis.getOption());
            secto.setText(eventTransmis.getSecto());
        } else {
            nameFr.setText(eventSauvegardeTransmis.getNameFr());
            category.setText(eventSauvegardeTransmis.getCategory());
            descriptionDescription.setText(eventSauvegardeTransmis.getDescriptionDescription());
            descriptionHoraires.setText("Horaires: "+eventSauvegardeTransmis.getDescriptionHoraires());
            descriptionSituation.setText(eventSauvegardeTransmis.getDescriptionSituation());
            descriptionTarification.setText("Tarif: "+eventSauvegardeTransmis.getDescriptionTarification());
            start.setText("Date: "+ DateUtils.formatDateDD_MM_YYYY(eventSauvegardeTransmis.getStart()));
            end.setText(" au "+DateUtils.formatDateDD_MM_YYYY(eventSauvegardeTransmis.getEnd()));
            adressContent.setText(eventSauvegardeTransmis.getAdressContent());
            adressZip.setText(eventSauvegardeTransmis.getAdressZip());
            adressCity.setText(eventSauvegardeTransmis.getAdressCity());
            phone.setText("Tel: "+eventSauvegardeTransmis.getPhone());
            email.setText("Email: "+eventSauvegardeTransmis.getEmail());
            websiteSituation.setText("Site: "+eventSauvegardeTransmis.getWebsiteSituation());
            websitePrincipal.setText("Site: "+eventSauvegardeTransmis.getWebsitePrincipal());
            profile.setText(" - "+eventSauvegardeTransmis.getProfile());
            station.setText(eventSauvegardeTransmis.getStation());
            option.setText(eventSauvegardeTransmis.getOption());
            secto.setText(eventSauvegardeTransmis.getSecto());
        }

    }

    private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url;
            bitmap = null;
            if (!isSauvegarde) {
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
            } else {
                if (eventSauvegardeTransmis.getImage()!= null && eventSauvegardeTransmis.getImage().length()>0) {
                    try {
                        url = new URL(eventSauvegardeTransmis.getImage());
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
        }
    }

    public void exit(View view) {
        finish();
    }

    public void delete(View view) {
        eventSauvegardeEntityDao.delete(eventSauvegardeTransmis);
        AfficherChoixEnregistrementActivity.getInstance().finish();
        ouvrirActiviteSuivante(this, AfficherChoixEnregistrementActivity.class,true,null);
        //AfficherChoixEnregistrementActivity.getInstance().chipEvent.setChecked(true);
    }

    public void save(View view) {
        EventSauvegardeEntity current = new EventSauvegardeEntity();
        current.setEventId(eventTransmis.getEventId() != null ? eventTransmis.getEventId() : null);
        current.setNameFr(eventTransmis.getNameFr() != null ? eventTransmis.getNameFr() : null);
        current.setStart(eventTransmis.getStart() != null ? eventTransmis.getStart() : null);
        current.setEnd(eventTransmis.getEnd() != null ? eventTransmis.getEnd() : null);
        current.setAdressContent(eventTransmis.getAdressContent() != null ? eventTransmis.getAdressContent() : null);
        current.setAdressZip(eventTransmis.getAdressZip() != null ? eventTransmis.getAdressZip() : null);
        current.setAdressCity(eventTransmis.getAdressCity() != null ? eventTransmis.getAdressCity() : null);
        current.setPhone(eventTransmis.getPhone() != null ? eventTransmis.getPhone() : null);
        current.setEmail(eventTransmis.getEmail() != null ? eventTransmis.getEmail() : null);
        current.setWebsiteSituation(eventTransmis.getWebsiteSituation() != null ? eventTransmis.getWebsiteSituation() : null);
        current.setWebsitePrincipal(eventTransmis.getWebsitePrincipal() != null ? eventTransmis.getWebsitePrincipal() : null);
        current.setProfile(eventTransmis.getProfile() != null ? eventTransmis.getProfile() : null);
        current.setStation(eventTransmis.getStation() != null ? eventTransmis.getStation() : null);
        current.setCategory(eventTransmis.getCategory() != null ? eventTransmis.getCategory() : null);
        current.setOption(eventTransmis.getOption() != null ? eventTransmis.getOption() : null);
        current.setSecto(eventTransmis.getSecto() != null ? eventTransmis.getSecto() : null);
        current.setDescriptionSituation(eventTransmis.getDescriptionSituation() != null ? eventTransmis.getDescriptionSituation() : null);
        current.setDescriptionHoraires(eventTransmis.getDescriptionHoraires() != null ? eventTransmis.getDescriptionHoraires() : null);
        current.setDescriptionTarification(eventTransmis.getDescriptionTarification() != null ? eventTransmis.getDescriptionTarification() : null);
        current.setDescriptionDescription(eventTransmis.getDescriptionDescription() != null ? eventTransmis.getDescriptionDescription() : null);
        current.setImage(eventTransmis.getImage() != null ? eventTransmis.getImage() : null);
        current.setLatitude(eventTransmis.getLatitude());
        current.setLongitude(eventTransmis.getLongitude());
        current.setNote(eventTransmis.getNote());
        current.setEntryId(eventTransmis.getEntryId() != null ? eventTransmis.getEntryId() : null);
        current.setEntryName(eventTransmis.getEntryName() != null ? eventTransmis.getEntryName() : null);
        current.setCreated(eventTransmis.getCreated() != null ? eventTransmis.getCreated() : null);
        current.setUpdated(eventTransmis.getUpdated() != null ? eventTransmis.getUpdated() : null);
        eventSauvegardeEntityDao.insert(current);
        fabSave.hide();
    }

    public void launchGoogleMap(View view) {
        String url = "geo:";
        String addr = "";
        if (eventTransmis.getLatitude() != 0 && eventTransmis.getLongitude() != 0) {
            url += eventTransmis.getLatitude()+","+eventTransmis.getLongitude();
            url += "?q="+eventTransmis.getLatitude()+","+eventTransmis.getLongitude();
        } else if (eventTransmis.getAdressContent() != null || eventTransmis.getAdressZip() != null
        || eventTransmis.getAdressCity() != null) {
            url += "0,0?q=";
            addr += Uri.parse(eventTransmis.getAdressContent()+" "+eventTransmis.getAdressZip()+" "+eventTransmis.getAdressCity());
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
                url += eventTransmis.getAdressContent()+" " +eventTransmis.getAdressZip()+" " + eventTransmis.getAdressCity();
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

