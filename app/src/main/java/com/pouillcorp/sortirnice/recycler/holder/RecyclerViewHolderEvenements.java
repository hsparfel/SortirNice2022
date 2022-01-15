package com.pouillcorp.sortirnice.recycler.holder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.entities.event.detail.DetailEvenementEntitySimple;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementDescriptionEntity;
import com.pouillcorp.sortirnice.modelevents.Description;
import com.pouillcorp.sortirnice.modelevents.Event;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvenements;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvents;
import com.pouillcorp.sortirnice.utils.BasicUtils;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderEvenements extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.titre)
    TextView titre;
    @BindView(R.id.text_secondaire)
    TextView textSecondaire;
    @BindView(R.id.text_support)
    TextView textSupport;
    @BindView(R.id.image)
    ImageView image;
    EvenementEntity currentEvent;
    @BindView(R.id.card)
    MaterialCardView card;

    Bitmap bitmap = null;
    String newLine = System.getProperty("line.separator");



    private WeakReference<RecyclerAdapterEvenements.Listener> callbackWeakRef;

    public RecyclerViewHolderEvenements(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
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

    public void updateWithEvents(EvenementEntity event, RecyclerAdapterEvenements.Listener callback)  {
        //this.detail.setText(event.getNameFr());
        //this.detail.setOnClickListener(this);
        currentEvent = event;
        String category ="";
        //revoir ça pour toutes les afficher
        //if (event.getListCategories() != null && event.getListCategories().size()>0) {
            category = getDetailListe(currentEvent.getListCategories());
        //}
        String description="";
        for (EvenementDescriptionEntity current : event.getListDescriptions()) {
            if (current.getLanguage().equalsIgnoreCase("fr")) {
                if (current.getType().equalsIgnoreCase("description")) {
                    description += (description == "" ? "" : newLine) + current.getValue();
                } else if (current.getType().equalsIgnoreCase("situation")) {
                    description += (description == "" ? "" : newLine) + current.getValue();
                }
            }
        }
        //String start="";
        if (event.getStart() != null) {
            //category += newLine;
            category += newLine + DateUtils.formatDateDD_MM_YYYY(event.getStart());
        }
        if (event.getEnd() != null && !event.getEnd().equalsIgnoreCase(event.getStart())) {
            category += " au "+DateUtils.formatDateDD_MM_YYYY(event.getEnd());
        }
        for (EvenementDescriptionEntity current : event.getListDescriptions()) {
            if (current.getLanguage().equalsIgnoreCase("fr")) {
                if (current.getType().equalsIgnoreCase("horaires")) {
                    category += " - "+current.getValue();
                }
            }
        }

        AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
        runnerImage.execute();
        //creer asynctask pour faire ce job
        /**/

        // this.image.setImageURI(Uri.parse(event.getListImages().get(0).getUrl()));
        this.titre.setText(event.getNameFr());
        this.textSecondaire.setText(BasicUtils.stringRaccourci(category,100));
        this.textSupport.setText(BasicUtils.stringRaccourci(description,100));

        hideFields();
        changerCouleur();

        this.callbackWeakRef = new WeakReference<RecyclerAdapterEvenements.Listener>(callback);
    }

    public void changerCouleur() {
        if (currentEvent.getFavori()) {
            card.setBackgroundColor(App.getRes().getColor(R.color.favori));
        } else {
            card.setBackgroundColor(App.getRes().getColor(R.color.white));
        }
    }

    public void showAllFields() {
        titre.setVisibility(View.VISIBLE);
        textSecondaire.setVisibility(View.VISIBLE);
        textSupport.setVisibility(View.VISIBLE);
    }

    public void hideFields() {
        showAllFields();
        if (titre.getText().toString().equalsIgnoreCase("")) {
            titre.setVisibility(View.GONE);
        }
        if (textSecondaire.getText().toString().equalsIgnoreCase("")) {
            textSecondaire.setVisibility(View.GONE);
        }
        if (textSupport.getText().toString().equalsIgnoreCase("")) {
            textSupport.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        RecyclerAdapterEvenements.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickEventsButton(getAdapterPosition());
    }

    private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url = null;
            bitmap = null;
            if (currentEvent.getImage() != null && !currentEvent.getImage().equalsIgnoreCase("")) {
                try {
                    url = new URL(currentEvent.getImage());
                    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                    httpConn.connect();
                    int resCode = httpConn.getResponseCode();
                    if (resCode == HttpURLConnection.HTTP_OK) {
                        InputStream in = httpConn.getInputStream();
                        bitmap = BitmapFactory.decodeStream(in);
                        //this.image.setImageBitmap(bitmap);
                        //RecyclerViewHolderEvents.this.image.setImageBitmap(bitmap);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    //this.image.setImageResource(R.drawable.outline_camera);
                    //RecyclerViewHolderEvents.this.image.setImageResource(R.drawable.outline_camera);
                } catch (IOException e) {
                    e.printStackTrace();
                    //this.image.setImageResource(R.drawable.outline_camera);
                    //RecyclerViewHolderEvents.this.image.setImageResource(R.drawable.outline_camera);
                }
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            if (bitmap != null) {
                image.setImageBitmap(bitmap);
            } else {
                image.setImageResource(R.drawable.outline_camera);
                //image.setVisibility(View.GONE);
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        protected void onProgressUpdate(Integer... integer) {
            //progressBar.setProgress(integer[0],true);
        }
    }

}
