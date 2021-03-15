package com.pouillos.sortirnice.activities;
   


    import android.content.Intent;
    import android.os.Build;
import android.os.Bundle;
    import android.util.Log;
    import android.view.Menu;
import android.view.View;
import android.widget.Button;
    import android.widget.CompoundButton;

    import androidx.annotation.RequiresApi;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.google.android.material.floatingactionbutton.FloatingActionButton;
    import com.google.android.material.switchmaterial.SwitchMaterial;
    import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.sortirnice.R;
    import com.pouillos.sortirnice.entities.Episode;
    import com.pouillos.sortirnice.entities.Serie;
    import com.pouillos.sortirnice.entities.Saison;
    import com.pouillos.sortirnice.enumeration.Langage;
    import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterSaison;
    import com.pouillos.sortirnice.utils.BasicUtils;
    import com.pouillos.sortirnice.utils.ItemClickSupport;

    import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;

public class AfficherSaisonActivity extends NavDrawerActivity implements RecyclerAdapterSaison.Listener {

    Serie serieTransmise;
    
    @BindView(R.id.layoutName)
    TextInputLayout layoutName;
    @BindView(R.id.textName)
    TextInputEditText textName;

    int nbSaison;
    List<Saison> listSaison;

    boolean isFini;

    @BindView(R.id.btnAddSaison)
    Button btnAddSaison;

    @BindView(R.id.fabSave)
    FloatingActionButton fabSave;
    @BindView(R.id.fabCancel)
    FloatingActionButton fabCancel;

    @BindView(R.id.list_recycler_saison)
    RecyclerView list_recycler_saison;

    @BindView(R.id.layoutNbEpisode)
    TextInputLayout layoutNbEpisode;
    @BindView(R.id.textNbEpisode)
    TextInputEditText textNbEpisode;
    @BindView(R.id.layoutNumSaison)
    TextInputLayout layoutNumSaison;
    @BindView(R.id.textNumSaison)
    TextInputEditText textNumSaison;

    @BindView(R.id.switchLgg)
    SwitchMaterial switchLgg;

    @BindView(R.id.switchFini)
    SwitchMaterial switchFini;

    private RecyclerAdapterSaison adapterSaison;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_saison);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        listSaison = new ArrayList<>();
        nbSaison = 0;
        layoutName.setEnabled(false);
        layoutNumSaison.setEnabled(false);
        traiterIntent();
        setTitle("Liste des Saisons");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
    }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("serieId")) {
            Long serieId = intent.getLongExtra("serieId", 0);
            serieTransmise = serieDao.load(serieId);
            fillAllFields();
            //identifier le nb de saisons de la serie
            listSaison = saisonDao.queryRaw("where serie_Id = ?",serieTransmise.getId().toString());
            nbSaison = listSaison.size();
            configureRecyclerView();
            configureOnClickRecyclerView();
            hideAllFields();
        }

        switchFini.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnAddSaison.setVisibility(View.GONE);
                } else {
                    btnAddSaison.setVisibility(View.VISIBLE);
                }
                serieTransmise.setFini(switchFini.isChecked());
                serieDao.update(serieTransmise);
                fabCancel.performClick();
            }
        });
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_saison, R.layout.recycler_list_saison)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Log.e("TAG", "Position : "+position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterSaison = new RecyclerAdapterSaison(listSaison, this);
        list_recycler_saison.setAdapter(adapterSaison);
        list_recycler_saison.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fillAllFields() {
        textName.setText(serieTransmise.getNom());
        switchFini.setChecked(serieTransmise.getFini());
    }

    private void displayAllFields() {
        layoutNbEpisode.setVisibility(View.VISIBLE);
        layoutNumSaison.setVisibility(View.VISIBLE);
        switchLgg.setVisibility(View.VISIBLE);
        fabSave.show();
        fabCancel.show();
    }

    private void hideAllFields() {
        layoutNbEpisode.setVisibility(View.GONE);
        layoutNumSaison.setVisibility(View.GONE);
        switchLgg.setVisibility(View.GONE);
        fabSave.hide();
        fabCancel.hide();
        if (serieTransmise.getFini()) {
            btnAddSaison.setVisibility(View.GONE);
        } else {
            btnAddSaison.setVisibility(View.VISIBLE);
        }
    }

    private void clearFields() {
        textNbEpisode.setText("");
        switchLgg.setChecked(false);
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        if (verifChamps()) {
            Saison saisonToCreate = new Saison();
            saisonToCreate.setSerie(serieTransmise);
            saisonToCreate.setNumSaison(Integer.parseInt(textNumSaison.getText().toString()));
            saisonToCreate.setNbEpisodes(Integer.parseInt(textNbEpisode.getText().toString()));
            saisonToCreate.setLangage(switchLgg.isChecked() ? Langage.Vost : Langage.Fr);
            saisonToCreate.setId(saisonDao.insert(saisonToCreate));

            for (int i=1;i<=saisonToCreate.getNbEpisodes();i++) {
                Episode episodeToCreate = new Episode();
                episodeToCreate.setNumEpisode(i);
                episodeToCreate.setSaison(saisonToCreate);
                episodeToCreate.setVu(false);
                episodeDao.insert(episodeToCreate);
            }
            finish();
            startActivity(getIntent());
        }
    }
    @OnClick(R.id.fabCancel)
    public void fabCancelClick() {
        hideAllFields();
        clearFields();
    }

    public void addSaison(View view) {
        displayAllFields();
        textNumSaison.setText(BasicUtils.afficherChiffre(nbSaison+1));
        btnAddSaison.setVisibility(View.GONE);
    }

    @Override
    public void onClickSaisonButton(int position) {
        Saison saison = listSaison.get(position);
        ouvrirActiviteSuivante(this, AfficherEventsActivity.class,"saisonId",saison.getId(),false);
    }

    public boolean verifChamps() {
        boolean bool = true;
        if (textNbEpisode.getText().toString().equalsIgnoreCase("")) {
            layoutNbEpisode.setError(getString(R.string.text_needed));
            bool = false;
        } else {
            layoutName.setError(null);
        }
        return bool;
    }
}

