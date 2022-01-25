package com.pouillcorp.sortirnice.recycler.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryDescriptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillcorp.sortirnice.modelentries.Atmospher;
import com.pouillcorp.sortirnice.modelentries.Category;
import com.pouillcorp.sortirnice.modelentries.Description;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.modelentries.Location;

import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.utils.BasicUtils;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderEntries extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.titre)
    TextView titre;
    @BindView(R.id.text_categories)
    TextView textCategories;
    @BindView(R.id.text_locations)
    TextView textLocations;
    @BindView(R.id.text_atmospheres)
    TextView textAtmospheres;
    @BindView(R.id.text_description)
    TextView textDescription;
    //@BindView(R.id.image)
    //ImageView image;
    EntryEntity currentEntry;

    @BindView(R.id.cardEntry)
    MaterialCardView cardEntry;

    String newLine = System.getProperty("line.separator");

    //Bitmap bitmap = null;

    private WeakReference<RecyclerAdapterEntries.Listener> callbackWeakRef;

    public RecyclerViewHolderEntries(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithEntries(EntryEntity entry, RecyclerAdapterEntries.Listener callback)  {
        //this.detail.setText(event.getNameFr());
        //this.detail.setOnClickListener(this);
        currentEntry = entry;

        String description="";
        int cptr = 0;
        for (EntryDescriptionEntity current : entry.getListDescriptions()) {
            if (cptr == 0) {
                    description = current.getValue();
                    cptr++;
            } else {
                description = newLine + current.getValue();
            }
        }

        String category = "";
        int i = 1;
        //int w = 0;
    //    for (EntryCategoryEntity current : entry.getListCategories()) {
            /*if (current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))
            || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
            || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.infos_pratiques))
                    || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sans_categorie))
            ) {*/
             //   w++;
         //   }
       // }
        for (EntryCategoryEntity current : entry.getListCategories()) {
            /*if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
                    && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))
                    && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.infos_pratiques))
                    && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sans_categorie))
            ) {*/
                category += current.getValue();
                //if (i < entry.getListCategories().size()-w) {
                    if (i < entry.getListCategories().size()) {
                    category += " / ";
                }
                i++;
           // }

        }
        String location = "";
        if (entry.getListLocations() != null) {
            int j = 1;
            for (EntryLocationEntity current : entry.getListLocations()) {
                //if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.metropole))) {
                    location += current.getValue();
                    if (j < entry.getListLocations().size()) {
                        location += " / ";
                    }
                //}
                j++;
            }
        }
        String atmosphere = "";
        if (entry.getListAtmosphere() != null) {
            int k = 1;
            for (EntryAtmospherEntity current : entry.getListAtmosphere()) {
                //if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.metropole))) {
                    atmosphere += current.getValue();
                    if (k < entry.getListAtmosphere().size()) {
                        atmosphere += " / ";
                    }
               // }
                k++;
            }
        }
        /*String description="";
        for (Description current : entry.getListDescriptions()) {
            if (current.getLanguage().equalsIgnoreCase("fr")
            && current.getType().equalsIgnoreCase("description")) {
                description = current.getValue();
            }
        }*/

        //AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
        //runnerImage.execute();
        //creer asynctask pour faire ce job
        /**/

        // this.image.setImageURI(Uri.parse(event.getListImages().get(0).getUrl()));
        this.titre.setText(entry.getNameFr());

        this.textCategories.setText(category);

        this.textDescription.setText(BasicUtils.stringRaccourci(description,100));
        this.textLocations.setText(location);
        this.textAtmospheres.setText(atmosphere);

        hideFields();
        changerCouleur();

        this.callbackWeakRef = new WeakReference<RecyclerAdapterEntries.Listener>(callback);
        /*if (callback.getClass() == AfficherEntriesShoppingActivity.class) {
            image.setVisibility(View.VISIBLE);
        }*/

    }

    public void showAllFields() {
        textCategories.setVisibility(View.VISIBLE);
        textLocations.setVisibility(View.VISIBLE);
        textAtmospheres.setVisibility(View.VISIBLE);
        textDescription.setVisibility(View.VISIBLE);
    }

    public void hideFields() {
        showAllFields();
        if (textCategories.getText().toString().equalsIgnoreCase("")) {
            textCategories.setVisibility(View.GONE);
        }
        if (textLocations.getText().toString().equalsIgnoreCase("")) {
            textLocations.setVisibility(View.GONE);
        }
        if (textAtmospheres.getText().toString().equalsIgnoreCase("")) {
            textAtmospheres.setVisibility(View.GONE);
        }
        if (textDescription.getText().toString().equalsIgnoreCase("")) {
            textDescription.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        RecyclerAdapterEntries.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickEntriesButton(getAdapterPosition());
    }

    /*private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url = null;
            bitmap = null;
            if (currentEntry.getListImages().size()>0) {
                try {
                    url = new URL(currentEntry.getListImages().get(0).getUrl());
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
    }*/

    public void changerCouleur() {
        if (currentEntry.getFavori()) {
            cardEntry.setBackgroundColor(App.getRes().getColor(R.color.favori));
        } else {
            cardEntry.setBackgroundColor(App.getRes().getColor(R.color.white));
        }
    }
}
