package com.pouillos.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.sortirnice.R;

import com.pouillos.sortirnice.interfaces.EventsApiService;
import com.pouillos.sortirnice.model.Event;
import com.pouillos.sortirnice.model.Events;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEvents;
import com.pouillos.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEventsActivity extends NavDrawerActivity implements RecyclerAdapterEvents.Listener {

    int nbEvents;
    List<Event> listEvents;

    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    private RecyclerAdapterEvents adapterEvents;

    private static final String TAG = AfficherEventsActivity.class.getSimpleName();
    public static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    private static Retrofit retrofit = null;
    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_event);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        listEvents = new ArrayList<>();
        nbEvents = 0;

        setTitle("Liste des Events");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);

        connectAndGetApiData();
    }

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }
        EventsApiService eventApiService = retrofit.create(EventsApiService.class);
        //Call<Events> call = eventApiService.getEvents(API_KEY);
        Call<Events> call = eventApiService.getEvents();
        call.enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                listEvents = response.body().getListEvents();
                configureRecyclerView();
                //recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                Log.d(TAG, "Number of events received: " + listEvents.size());
            }

            @Override
            public void onFailure(Call<Events> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Log.e("TAG", "Position : "+position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEvents = new RecyclerAdapterEvents(listEvents, this);
        list_recycler_event.setAdapter(adapterEvents);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fillAllFields() {
       // textName.setText(saisonTransmise.getSerie().toString()+" - Saison "+BasicUtils.afficherChiffre(saisonTransmise.getNumSaison()));
    }

    @Override
    public void onClickEventsButton(int position) {
        Event event = listEvents.get(position);
     /*   episode.setVu(!episode.getVu());
        episodeDao.update(episode);
        QueryBuilder<Events> queryBuilder =
                episodeDao.queryBuilder().where(
                        EventsDao.Properties.Vu.eq(true),
                        EventsDao.Properties.SaisonId.eq(saisonTransmise.getId()));
        long count = queryBuilder.buildCount().count();
        if (count == saisonTransmise.getNbEventss()) {
            saisonTransmise.setVu(true);
            saisonDao.update(saisonTransmise);
        }
        configureRecyclerView();*/
    }
}