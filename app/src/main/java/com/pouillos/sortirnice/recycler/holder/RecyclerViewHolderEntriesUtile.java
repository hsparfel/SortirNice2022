package com.pouillos.sortirnice.recycler.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.sortirnice.App;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.modelentries.Atmospher;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Entry;
import com.pouillos.sortirnice.modelentries.Location;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntriesUtile;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderEntriesUtile extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.titre)
    TextView titre;
    @BindView(R.id.text_categories)
    TextView textCategories;
    @BindView(R.id.text_locations)
    TextView textLocations;
    @BindView(R.id.text_atmospheres)
    TextView textAtmospheres;
    //@BindView(R.id.image)
    //ImageView image;
    Entry currentEntry;

    //Bitmap bitmap = null;

    private WeakReference<RecyclerAdapterEntriesUtile.Listener> callbackWeakRef;

    public RecyclerViewHolderEntriesUtile(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithEntries(Entry entry, RecyclerAdapterEntriesUtile.Listener callback)  {
        //this.detail.setText(event.getNameFr());
        //this.detail.setOnClickListener(this);
        currentEntry = entry;

        String category = "";
        int i = 1;
        int w = 0;
        for (Category current : entry.getListCategories()) {
            if (current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))) {
                w++;
            }
        }
        for (Category current : entry.getListCategories()) {
            if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
                    && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))) {
                category += current.getValue();
                if (i < entry.getListCategories().size()-w) {
                    category += " / ";
                }
            }
            i++;
        }
        String location = "";
        if (entry.getListLocations() != null) {
            int j = 1;
            for (Location current : entry.getListLocations()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.metropole))) {
                    location += current.getValue();
                    if (j < entry.getListLocations().size()) {
                        location += " / ";
                    }
                }
                j++;
            }
        }
        String atmosphere = "";
        if (entry.getListAtmosphere() != null) {
            int k = 1;
            for (Atmospher current : entry.getListAtmosphere()) {
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

        /*AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
        runnerImage.execute();*/
        //creer asynctask pour faire ce job
        /**/

        // this.image.setImageURI(Uri.parse(event.getListImages().get(0).getUrl()));
        this.titre.setText(entry.getNameFr());

        this.textCategories.setText(category);


        this.textLocations.setText(location);
        this.textAtmospheres.setText(atmosphere);

        hideFields();


        this.callbackWeakRef = new WeakReference<RecyclerAdapterEntriesUtile.Listener>(callback);
    }

    public void showAllFields() {
        textCategories.setVisibility(View.VISIBLE);
        textLocations.setVisibility(View.VISIBLE);
        textAtmospheres.setVisibility(View.VISIBLE);
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
    }

    @Override
    public void onClick(View view) {
        RecyclerAdapterEntriesUtile.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickEntriesButton(getAdapterPosition());
    }

    /*private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url = null;
            bitmap = null;
            if (currentEntry.getListImages() != null && currentEntry.getListImages().size()>0) {
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

}
