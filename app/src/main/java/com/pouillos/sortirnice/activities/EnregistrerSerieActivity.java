package com.pouillos.sortirnice.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.RequiresApi;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.Serie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;

public class EnregistrerSerieActivity extends NavDrawerActivity {

    @BindView(R.id.textName)
    TextInputEditText textName;
    @BindView(R.id.layoutName)
    TextInputLayout layoutName;

    @BindView(R.id.fabSave)
    FloatingActionButton fabSave;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_enregistrer_serie);
        // 6 - Configure all views
        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        setTitle("Enregistrer Serie");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        if (verifChamps()) {
            Serie serie = new Serie();
            serie.setNom(textName.getText().toString().toUpperCase());
            Long serieId = serieDao.insert(serie);
            ouvrirActiviteSuivante(this, AfficherSaisonActivity.class,"serieId",serieId,false);
        }
    }

    public boolean verifChamps() {
        boolean bool = true;
        List<Serie> listSerie = serieDao.queryRaw("where nom = ?",textName.getText().toString().toUpperCase());
        if (textName.getText().toString().equalsIgnoreCase("")) {
            layoutName.setError(getString(R.string.text_needed));
            bool = false;
        } else if (listSerie.size()>0) {
            layoutName.setError(getString(R.string.text_already_exist));
            bool = false;
        } else {
            layoutName.setError(null);
        }
        return bool;
    }
}
