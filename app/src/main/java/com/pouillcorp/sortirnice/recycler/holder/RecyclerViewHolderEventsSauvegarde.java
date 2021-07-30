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

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EventSauvegardeEntity;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEventsSauvegarde;
import com.pouillcorp.sortirnice.utils.BasicUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolderEventsSauvegarde extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.titre)
    TextView titre;
    @BindView(R.id.text_secondaire)
    TextView textSecondaire;
    @BindView(R.id.text_support)
    TextView textSupport;
    @BindView(R.id.image)
    ImageView image;
    EventSauvegardeEntity currentEvent;

    Bitmap bitmap = null;

    private WeakReference<RecyclerAdapterEventsSauvegarde.Listener> callbackWeakRef;

    public RecyclerViewHolderEventsSauvegarde(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithEvents(EventSauvegardeEntity event, RecyclerAdapterEventsSauvegarde.Listener callback)  {
        //this.detail.setText(event.getNameFr());
        //this.detail.setOnClickListener(this);
        currentEvent = event;
        String category = event.getCategory();

        String description = event.getDescriptionDescription();

        AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
        runnerImage.execute();
        //creer asynctask pour faire ce job
        /**/

        // this.image.setImageURI(Uri.parse(event.getListImages().get(0).getUrl()));
        this.titre.setText(event.getNameFr());
        this.textSecondaire.setText(category);
        this.textSupport.setText(BasicUtils.stringRaccourci(description,100));

        hideFields();

        this.callbackWeakRef = new WeakReference<RecyclerAdapterEventsSauvegarde.Listener>(callback);
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
        RecyclerAdapterEventsSauvegarde.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickEventsButton(getAdapterPosition());
    }

    private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url = null;
            bitmap = null;
            if (currentEvent.getImage() != null) {
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
