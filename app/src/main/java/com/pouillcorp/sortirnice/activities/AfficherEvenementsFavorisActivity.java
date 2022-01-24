package com.pouillcorp.sortirnice.activities;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.entities.event.detail.DetailEvenementEntitySimple;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementAddressEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementCategoryEntity;
import com.pouillcorp.sortirnice.enumeration.EvenementTri;
import com.pouillcorp.sortirnice.modelevents.Event;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvenements;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import icepick.Icepick;

public class AfficherEvenementsFavorisActivity extends NavDrawerActivity implements RecyclerAdapterEvenements.Listener {

    int nbEvents;
    List<Event> listEvents;
    List<EvenementEntity> listEventEntities = new ArrayList<>();
    List<EvenementEntity> listEventEntitiesBasique = new ArrayList<>();

    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;

    @BindView(R.id.layout_fragment_evenement_tri)
    FrameLayout layoutFragmentEvenementTri;
    @BindView(R.id.radio_button_evenement_tri_nom)
    MaterialRadioButton rbEvenementTriNom;
    @BindView(R.id.radio_button_evenement_tri_date)
    MaterialRadioButton rbEvenementTridDate;

    @BindView(R.id.layout_fragment_evenement_filtre)
    FrameLayout layoutFragmentEvenementFiltre;

    private RecyclerAdapterEvenements adapterEvents;

    private static final String TAG = AfficherEvenementsFavorisActivity.class.getSimpleName();

    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";


    int positionScroll = 0;

    boolean layoutTriAffiche;
    boolean layoutFiltreAffiche;

    EvenementTri triEnCours = EvenementTri.Nom;

    List<EvenementAddressEntity> listFiltreEvenementAdresse = new ArrayList<>();
    List<EvenementCategoryEntity> listFiltreEvenementCategory = new ArrayList<>();

    @Nullable
    @BindView(R.id.fabEvenementValiderFiltre)
    FloatingActionButton fabEvenementValiderFiltre;
    @Nullable
    @BindView(R.id.fabEvenementRazFiltre)
    FloatingActionButton fabEvenementRazFiltre;

    @Nullable
    @BindView(R.id.linearLayoutEvenementFiltreCategory)
    LinearLayout linearLayoutEvenementFiltreCategory;
    @Nullable
    @BindView(R.id.checkboxEvenementFiltreCategorySelectAll)
    MaterialCheckBox checkboxEvenementFiltreCategorySelectAll;
    @Nullable
    @BindView(R.id.linearLayoutEvenementFiltreVille)
    LinearLayout linearLayoutEvenementFiltreVille;
    @Nullable
    @BindView(R.id.checkboxEvenementFiltreVilleSelectAll)
    MaterialCheckBox checkboxEvenementFiltreVilleSelectAll;
    @Nullable
    @BindView(R.id.buttonEvenementFiltreCategory)
    MaterialButton buttonEvenementFiltreCategory;
    @Nullable
    @BindView(R.id.buttonEvenementFiltreVille)
    MaterialButton buttonEvenementFiltreVille;

    boolean filtreCategoryDeplie = false;
    boolean filtreVilleDeplie = false;

    List<MaterialCheckBox> listCheckboxEvenementCategory = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxEvenementVille = new ArrayList<>();

    List<EvenementEntity> listEvenementEntityFiltre = new ArrayList<>();

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

        setTitle("Evenements Favoris");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_evenement).setChecked(true);


        progressBar.setVisibility(View.VISIBLE);
        loadAllEvenementFavorisFromDB();
        listEventEntitiesBasique.addAll(listEventEntities);
        configureRecyclerView();
        /*itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
        itemEvenementFiltre.setVisible(true);
        itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
        itemEvenementTri.setVisible(true);*/

        listerFiltre();
        initListFiltres();
        initCheckboxesSelectAllClick();

        progressBar.setVisibility(View.GONE);

        masquerFragmentTri();
        masquerFragmentFiltre();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
        itemEvenementFiltre.setVisible(true);
        itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
        itemEvenementTri.setVisible(true);
        return true;
    }

    @OnClick(R.id.radio_button_evenement_tri_nom)
    public void rbEvenementTriNomClick() {
        Log.e("TAG", "click sur Tri Nom");
        triEnCours = EvenementTri.Nom;
        triSelonParametre(listEventEntities);
        configureRecyclerView();
        masquerFragmentTri();
    }

    @OnClick(R.id.radio_button_evenement_tri_date)
    public void rbEvenementTriDateClick() {
        Log.e("TAG", "click sur Tri Date");
        triEnCours = EvenementTri.Date;
        triSelonParametre(listEventEntities);
        configureRecyclerView();
        masquerFragmentTri();
    }

    private void loadAllEvenementFavorisFromDB() {
        evenementEntityDao.detachAll();
        listEventEntities = evenementEntityDao.queryRaw("where favori = 1");
        triSelonParametre(listEventEntities);
    }

    private void masquerFragmentTri() {
        layoutFragmentEvenementTri.setVisibility(View.GONE);
        layoutTriAffiche = false;
    }

    private void afficherFragmentTri() {
        layoutFragmentEvenementTri.setVisibility(View.VISIBLE);
        layoutTriAffiche = true;
        rbEvenementTriNom.setText(EvenementTri.Nom.getNom());
        rbEvenementTridDate.setText(EvenementTri.Date.getNom());
    }

    /*private void masquerFragmentFiltre() {
        layoutFragmentEvenementFiltre.setVisibility(View.GONE);
        layoutFiltreAffiche = false;
    }

    private void afficherFragmentFiltre() {
        layoutFragmentEvenementFiltre.setVisibility(View.VISIBLE);
        layoutFiltreAffiche = true;
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        for (EvenementEntity current : listEventEntities) {
            current.refresh();
        }
        configureRecyclerView();
        list_recycler_event.scrollToPosition(positionScroll);
        Log.e(TAG, "on resume method");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_evenement_tri:
                Log.e(TAG, "click sur tri evenement");
                if (layoutTriAffiche) {
                    masquerFragmentTri();
                } else {
                    afficherFragmentTri();
                }
                masquerFragmentFiltre();
                break;
            case R.id.menu_activity_main_evenement_filter:
                Log.e(TAG, "click sur filtre evenement");
                if (layoutFiltreAffiche) {
                    masquerFragmentFiltre();
                } else {
                    afficherFragmentFiltre();
                }
                masquerFragmentTri();
                break;
        }
        return true;
    }

    private void configureOnClickRecyclerViewEvent() {
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        positionScroll = position;
                        masquerFragmentTri();
                        ouvrirActiviteSuivante(AfficherEvenementsFavorisActivity.this, AfficherEvenementDetailActivity.class, "eventId", listEventEntities.get(position).getId(), false);
                        //Log.e("TAG", "Position : " + position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEvents = new RecyclerAdapterEvenements(listEventEntities, this);
        list_recycler_event.setAdapter(adapterEvents);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerViewEvent();
    }

    @Override
    public void onClickEventsButton(int position) {
        //  ouvrirActiviteSuivante(this,AfficherEventDetailActivity.class,"eventId",listEventEntities.get(position).getId(),false);
    }

    public void afficherListCbEvenementFiltreCategory(View view) {
        if (!filtreCategoryDeplie) {
            filtreCategoryDeplie = true;
            checkboxEvenementFiltreCategorySelectAll.setVisibility(View.VISIBLE);
            linearLayoutEvenementFiltreCategory.setVisibility(View.VISIBLE);
            buttonEvenementFiltreCategory.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreCategoryDeplie = false;
            checkboxEvenementFiltreCategorySelectAll.setVisibility(View.GONE);
            linearLayoutEvenementFiltreCategory.setVisibility(View.GONE);
            buttonEvenementFiltreCategory.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEvenementFiltreVille(View view) {
        if (!filtreVilleDeplie) {
            filtreVilleDeplie = true;
            checkboxEvenementFiltreVilleSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEvenementFiltreVille.setVisibility(View.VISIBLE);
            buttonEvenementFiltreVille.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreVilleDeplie = false;
            checkboxEvenementFiltreVilleSelectAll.setVisibility(View.GONE);
            linearLayoutEvenementFiltreVille.setVisibility(View.GONE);
            buttonEvenementFiltreVille.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    protected boolean verifFiltreActif(List<? extends DetailEvenementEntitySimple> list) {
        boolean bool = false;
        for (DetailEvenementEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    protected boolean verifFiltreAdresseActif(List<EvenementAddressEntity> list) {
        boolean bool = false;
        for (EvenementAddressEntity current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    protected void reinitListeEvents() {
        listEventEntities.clear();
        listEventEntities.addAll(listEventEntitiesBasique);
    }

    @Optional
    @OnClick(R.id.fabEvenementValiderFiltre)
    public void fabEvenementFiltreClick() {
        //fabEvenementValiderFiltre.setVisibility(View.GONE);
        //fabEvenementRazFiltre.setVisibility(View.GONE);
        reinitListeEvents();
        layoutFragmentEvenementFiltre.setVisibility(View.GONE);
        listEvenementEntityFiltre = new ArrayList<>();
        listEvenementEntityFiltre.addAll(listEventEntities);
        boolean boolEvenementCategory = verifFiltreActif(listFiltreEvenementCategory);
        for (EvenementEntity current : listEventEntities) {
            if (boolEvenementCategory && listEvenementEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EvenementCategoryEntity filtre : listFiltreEvenementCategory) {
                    if (filtre.isChecked() && current.getListCategories() != null) {
                        for (EvenementCategoryEntity current2 : current.getListCategories()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEvenementEntityFiltre.remove(current);
                }
            }
        }
        boolean boolEvenementVille = verifFiltreAdresseActif(listFiltreEvenementAdresse);
        for (EvenementEntity current : listEventEntities) {
            if (boolEvenementVille && listEvenementEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EvenementAddressEntity filtre : listFiltreEvenementAdresse) {
                    if (filtre.isChecked() && current.getListAddresses() != null) {
                        for (EvenementAddressEntity current2 : current.getListAddresses()) {
                            if (current2.getCity().equalsIgnoreCase(filtre.getCity())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEvenementEntityFiltre.remove(current);
                }
            }
        }
        triSelonParametre(listEvenementEntityFiltre);
        listEventEntities.clear();
        listEventEntities.addAll(listEvenementEntityFiltre);
        configureRecyclerView();
    }

    protected void triSelonParametre(List<EvenementEntity> list) {
        if (triEnCours == EvenementTri.Nom) {
            Collections.sort(list);
        } else if (triEnCours == EvenementTri.Date) {
            Collections.sort(list, EvenementEntity.ComparatorDate);
        }
    }

    @Optional
    @OnClick(R.id.fabEvenementRazFiltre)
    public void fabEvenementRazFiltreClick() {
        decocherTout();
        layoutFragmentEvenementFiltre.setVisibility(View.GONE);
        //listEvenementEntityFiltre = new ArrayList<>();
        listEventEntities.clear();
        listEventEntities.addAll(listEventEntitiesBasique);
        triSelonParametre(listEventEntities);
        configureRecyclerView();
    }

    public void decocherFiltre(List<? extends DetailEvenementEntitySimple> list) {
        for (DetailEvenementEntitySimple current : list) {
            current.setChecked(false);
        }
    }

    public void decocherFiltreAdresse(List<EvenementAddressEntity> list) {
        for (EvenementAddressEntity current : list) {
            current.setChecked(false);
        }
    }

    /*public void decocherCheckbox(List<MaterialCheckBox> list) {
        for (MaterialCheckBox current : list) {
            current.setChecked(false);
        }
    }

    public void decocherCheckbox(MaterialCheckBox cb) {
        cb.setChecked(false);
    }*/

    public void decocherTout() {
        decocherFiltre(listFiltreEvenementCategory);
        decocherFiltreAdresse(listFiltreEvenementAdresse);
        for (EvenementAddressEntity current : listFiltreEvenementAdresse) {
            current.setChecked(false);
        }
        decocherCheckbox(listCheckboxEvenementCategory);
        decocherCheckbox(listCheckboxEvenementVille);
        decocherCheckbox(checkboxEvenementFiltreCategorySelectAll);
        decocherCheckbox(checkboxEvenementFiltreVilleSelectAll);
    }

    protected void initFiltre(List<? extends DetailEvenementEntitySimple> list, LinearLayout ll, List<MaterialCheckBox> listCb, MaterialCheckBox cb) {
        Collections.sort(list);
        for (DetailEvenementEntitySimple current : list) {
            MaterialCheckBox checkBox = new MaterialCheckBox(this);
            checkBox.setText(current.getValue());
            checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        current.setChecked(true);
                    } else {
                        current.setChecked(false);
                        if (!verifSiUnFiltreMinimum(list)) {
                            cb.setChecked(false);
                        }
                    }
                }
            });
            if (ll != null) {
                ll.addView(checkBox);
            }
            listCb.add(checkBox);
        }
    }

    protected List<EvenementAddressEntity> supprimerDoublonVille(List<EvenementAddressEntity> list) {
        List<EvenementAddressEntity> listTemp = new ArrayList<>();
        EvenementAddressEntity previous = null;
        for (EvenementAddressEntity current : list) {
            if (previous == null) {
                listTemp.add(current);
            } else if (!current.getCity().equalsIgnoreCase(previous.getCity())) {
                listTemp.add(current);
            }
            previous = current;
        }
        return listTemp;
    }

    protected void initListFiltres() {
        initFiltre(listFiltreEvenementCategory, linearLayoutEvenementFiltreCategory, listCheckboxEvenementCategory, checkboxEvenementFiltreCategorySelectAll);
        Collections.sort(listFiltreEvenementAdresse);
        listFiltreEvenementAdresse = supprimerDoublonVille(listFiltreEvenementAdresse);
        for (EvenementAddressEntity current : listFiltreEvenementAdresse) {
            MaterialCheckBox checkBox = new MaterialCheckBox(this);
            checkBox.setText(current.getCity());
            checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        current.setChecked(true);
                    } else {
                        current.setChecked(false);
                        boolean bool = false;
                        for (EvenementAddressEntity current : listFiltreEvenementAdresse) {
                            if (current.isChecked()) {
                                bool = true;
                            }
                        }
                        if (!bool) {
                            checkboxEvenementFiltreVilleSelectAll.setChecked(false);
                        }
                    }
                }
            });
            if (linearLayoutEvenementFiltreVille != null) {
                linearLayoutEvenementFiltreVille.addView(checkBox);
            }
            listCheckboxEvenementVille.add(checkBox);
        }
    }

    protected boolean verifSiUnFiltreMinimum(List<? extends DetailEvenementEntitySimple> list) {
        boolean bool = false;
        for (DetailEvenementEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    public void listerFiltre() {
        listFiltreEvenementCategory = evenementCategoryEntityDao.loadAll();
        listFiltreEvenementAdresse = evenementAddressEntityDao.loadAll();
        //Log.d(TAG, "Number of Category received: " + listFiltreEvenementCategory.size());
        //Log.d(TAG, "Number of City received: " + listFiltreEvenementAdresse.size());
    }

    /*protected void initCheckboxesSelectAllClick() {
        initCheckboxSelectAllClick(checkboxEvenementFiltreCategorySelectAll, listCheckboxEvenementCategory);
        initCheckboxSelectAllClick(checkboxEvenementFiltreVilleSelectAll, listCheckboxEvenementVille);
    }

    protected void initCheckboxSelectAllClick(MaterialCheckBox cbSelectAll, List<MaterialCheckBox> list) {
        cbSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (MaterialCheckBox current : list) {
                    if (isChecked) {
                        current.setChecked(true);
                    } else {
                        current.setChecked(false);
                    }
                }
            }
        });
    }*/
}