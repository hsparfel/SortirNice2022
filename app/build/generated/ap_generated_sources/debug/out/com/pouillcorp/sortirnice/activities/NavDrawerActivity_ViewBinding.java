// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NavDrawerActivity_ViewBinding implements Unbinder {
  private NavDrawerActivity target;

  private View view7f08012f;

  private View view7f08012d;

  private View view7f0801fc;

  private View view7f0801fb;

  private View view7f080132;

  private View view7f080131;

  private View view7f080130;

  private View view7f08012e;

  @UiThread
  public NavDrawerActivity_ViewBinding(NavDrawerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NavDrawerActivity_ViewBinding(final NavDrawerActivity target, View source) {
    this.target = target;

    View view;
    target.list_recycler_entry = Utils.findOptionalViewAsType(source, R.id.list_recycler_entry, "field 'list_recycler_entry'", RecyclerView.class);
    target.progressBar = Utils.findOptionalViewAsType(source, R.id.simpleProgressBar, "field 'progressBar'", ProgressBar.class);
    target.layoutFragmentEntryFiltre = Utils.findOptionalViewAsType(source, R.id.layout_fragment_entry_filtre, "field 'layoutFragmentEntryFiltre'", FrameLayout.class);
    target.layoutFragmentEntryType = Utils.findOptionalViewAsType(source, R.id.layout_fragment_entry_type, "field 'layoutFragmentEntryType'", FrameLayout.class);
    view = source.findViewById(R.id.fabEntryValiderFiltre);
    target.fabEntryValiderFiltre = Utils.castView(view, R.id.fabEntryValiderFiltre, "field 'fabEntryValiderFiltre'", FloatingActionButton.class);
    if (view != null) {
      view7f08012f = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabEntryFiltreClick();
        }
      });
    }
    view = source.findViewById(R.id.fabEntryRazFiltre);
    target.fabEntryRazFiltre = Utils.castView(view, R.id.fabEntryRazFiltre, "field 'fabEntryRazFiltre'", FloatingActionButton.class);
    if (view != null) {
      view7f08012d = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabEntryRazFiltreClick();
        }
      });
    }
    target.linearLayoutEntryFiltreCategory = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreCategory, "field 'linearLayoutEntryFiltreCategory'", LinearLayout.class);
    target.checkboxEntryFiltreCategorySelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreCategorySelectAll, "field 'checkboxEntryFiltreCategorySelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreCategory = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreCategory, "field 'buttonEntryFiltreCategory'", MaterialButton.class);
    target.linearLayoutEntryType = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryType, "field 'linearLayoutEntryType'", LinearLayout.class);
    target.linearLayoutEntryFiltreLocation = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreLocation, "field 'linearLayoutEntryFiltreLocation'", LinearLayout.class);
    target.checkboxEntryFiltreLocationSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreLocationSelectAll, "field 'checkboxEntryFiltreLocationSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreLocation = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreLocation, "field 'buttonEntryFiltreLocation'", MaterialButton.class);
    target.linearLayoutEntryFiltreActivity = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreActivity, "field 'linearLayoutEntryFiltreActivity'", LinearLayout.class);
    target.checkboxEntryFiltreActivitySelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreActivitySelectAll, "field 'checkboxEntryFiltreActivitySelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreActivity = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreActivity, "field 'buttonEntryFiltreActivity'", MaterialButton.class);
    target.linearLayoutEntryFiltreAmenity = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreAmenity, "field 'linearLayoutEntryFiltreAmenity'", LinearLayout.class);
    target.checkboxEntryFiltreAmenitySelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreAmenitySelectAll, "field 'checkboxEntryFiltreAmenitySelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreAmenity = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreAmenity, "field 'buttonEntryFiltreAmenity'", MaterialButton.class);
    target.linearLayoutEntryFiltreAnimation = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreAnimation, "field 'linearLayoutEntryFiltreAnimation'", LinearLayout.class);
    target.checkboxEntryFiltreAnimationSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreAnimationSelectAll, "field 'checkboxEntryFiltreAnimationSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreAnimation = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreAnimation, "field 'buttonEntryFiltreAnimation'", MaterialButton.class);
    target.linearLayoutEntryFiltreAtmospher = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreAtmospher, "field 'linearLayoutEntryFiltreAtmospher'", LinearLayout.class);
    target.checkboxEntryFiltreAtmospherSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreAtmospherSelectAll, "field 'checkboxEntryFiltreAtmospherSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreAtmospher = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreAtmospher, "field 'buttonEntryFiltreAtmospher'", MaterialButton.class);
    target.linearLayoutEntryFiltreChain = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreChain, "field 'linearLayoutEntryFiltreChain'", LinearLayout.class);
    target.checkboxEntryFiltreChainSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreChainSelectAll, "field 'checkboxEntryFiltreChainSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreChain = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreChain, "field 'buttonEntryFiltreChain'", MaterialButton.class);
    target.linearLayoutEntryFiltreFurnishedRental = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreFurnishedRental, "field 'linearLayoutEntryFiltreFurnishedRental'", LinearLayout.class);
    target.checkboxEntryFiltreFurnishedRentalSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreFurnishedRentalSelectAll, "field 'checkboxEntryFiltreFurnishedRentalSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreFurnishedRental = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreFurnishedRental, "field 'buttonEntryFiltreFurnishedRental'", MaterialButton.class);
    target.linearLayoutEntryFiltreLabel = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreLabel, "field 'linearLayoutEntryFiltreLabel'", LinearLayout.class);
    target.checkboxEntryFiltreLabelSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreLabelSelectAll, "field 'checkboxEntryFiltreLabelSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreLabel = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreLabel, "field 'buttonEntryFiltreLabel'", MaterialButton.class);
    target.linearLayoutEntryFiltreService = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreService, "field 'linearLayoutEntryFiltreService'", LinearLayout.class);
    target.checkboxEntryFiltreServiceSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreServiceSelectAll, "field 'checkboxEntryFiltreServiceSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreService = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreService, "field 'buttonEntryFiltreService'", MaterialButton.class);
    target.linearLayoutEntryFiltreStandingLevel = Utils.findOptionalViewAsType(source, R.id.linearLayoutEntryFiltreStandingLevel, "field 'linearLayoutEntryFiltreStandingLevel'", LinearLayout.class);
    target.checkboxEntryFiltreStandingLevelSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEntryFiltreStandingLevelSelectAll, "field 'checkboxEntryFiltreStandingLevelSelectAll'", MaterialCheckBox.class);
    target.buttonEntryFiltreStandingLevel = Utils.findOptionalViewAsType(source, R.id.buttonEntryFiltreStandingLevel, "field 'buttonEntryFiltreStandingLevel'", MaterialButton.class);
    target.checkboxEntryTypeBoutique = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeBoutique, "field 'checkboxEntryTypeBoutique'", MaterialCheckBox.class);
    target.checkboxEntryTypeHotel = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeHotel, "field 'checkboxEntryTypeHotel'", MaterialCheckBox.class);
    target.checkboxEntryTypeShopping = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeShopping, "field 'checkboxEntryTypeShopping'", MaterialCheckBox.class);
    target.checkboxEntryTypeVisite = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeVisite, "field 'checkboxEntryTypeVisite'", MaterialCheckBox.class);
    target.checkboxEntryTypeHebergement = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeHebergement, "field 'checkboxEntryTypeHebergement'", MaterialCheckBox.class);
    target.checkboxEntryTypeUtile = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeUtile, "field 'checkboxEntryTypeUtile'", MaterialCheckBox.class);
    target.checkboxEntryTypeSortie = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeSortie, "field 'checkboxEntryTypeSortie'", MaterialCheckBox.class);
    target.checkboxEntryTypeTransport = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeTransport, "field 'checkboxEntryTypeTransport'", MaterialCheckBox.class);
    target.checkboxEntryTypeRestaurant = Utils.findOptionalViewAsType(source, R.id.checkboxEntryTypeRestaurant, "field 'checkboxEntryTypeRestaurant'", MaterialCheckBox.class);
    target.list_recycler_event = Utils.findOptionalViewAsType(source, R.id.list_recycler_event, "field 'list_recycler_event'", RecyclerView.class);
    target.layoutFragmentEvenementTri = Utils.findOptionalViewAsType(source, R.id.layout_fragment_evenement_tri, "field 'layoutFragmentEvenementTri'", FrameLayout.class);
    view = source.findViewById(R.id.radio_button_evenement_tri_nom);
    target.rbEvenementTriNom = Utils.castView(view, R.id.radio_button_evenement_tri_nom, "field 'rbEvenementTriNom'", MaterialRadioButton.class);
    if (view != null) {
      view7f0801fc = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.rbEvenementTriNomClick();
        }
      });
    }
    view = source.findViewById(R.id.radio_button_evenement_tri_date);
    target.rbEvenementTridDate = Utils.castView(view, R.id.radio_button_evenement_tri_date, "field 'rbEvenementTridDate'", MaterialRadioButton.class);
    if (view != null) {
      view7f0801fb = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.rbEvenementTriDateClick();
        }
      });
    }
    target.layoutFragmentEvenementFiltre = Utils.findOptionalViewAsType(source, R.id.layout_fragment_evenement_filtre, "field 'layoutFragmentEvenementFiltre'", FrameLayout.class);
    view = source.findViewById(R.id.fabEvenementValiderFiltre);
    target.fabEvenementValiderFiltre = Utils.castView(view, R.id.fabEvenementValiderFiltre, "field 'fabEvenementValiderFiltre'", FloatingActionButton.class);
    if (view != null) {
      view7f080132 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabEvenementFiltreClick();
        }
      });
    }
    view = source.findViewById(R.id.fabEvenementRazFiltre);
    target.fabEvenementRazFiltre = Utils.castView(view, R.id.fabEvenementRazFiltre, "field 'fabEvenementRazFiltre'", FloatingActionButton.class);
    if (view != null) {
      view7f080131 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabEvenementRazFiltreClick();
        }
      });
    }
    target.linearLayoutEvenementFiltreCategory = Utils.findOptionalViewAsType(source, R.id.linearLayoutEvenementFiltreCategory, "field 'linearLayoutEvenementFiltreCategory'", LinearLayout.class);
    target.checkboxEvenementFiltreCategorySelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEvenementFiltreCategorySelectAll, "field 'checkboxEvenementFiltreCategorySelectAll'", MaterialCheckBox.class);
    target.linearLayoutEvenementFiltreVille = Utils.findOptionalViewAsType(source, R.id.linearLayoutEvenementFiltreVille, "field 'linearLayoutEvenementFiltreVille'", LinearLayout.class);
    target.checkboxEvenementFiltreVilleSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxEvenementFiltreVilleSelectAll, "field 'checkboxEvenementFiltreVilleSelectAll'", MaterialCheckBox.class);
    target.buttonEvenementFiltreCategory = Utils.findOptionalViewAsType(source, R.id.buttonEvenementFiltreCategory, "field 'buttonEvenementFiltreCategory'", MaterialButton.class);
    target.buttonEvenementFiltreVille = Utils.findOptionalViewAsType(source, R.id.buttonEvenementFiltreVille, "field 'buttonEvenementFiltreVille'", MaterialButton.class);
    view = source.findViewById(R.id.fabEntryValiderType);
    if (view != null) {
      view7f080130 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabEntryTypeClick();
        }
      });
    }
    view = source.findViewById(R.id.fabEntryRazType);
    if (view != null) {
      view7f08012e = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabEntryRazTypeClick();
        }
      });
    }
  }

  @Override
  @CallSuper
  public void unbind() {
    NavDrawerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list_recycler_entry = null;
    target.progressBar = null;
    target.layoutFragmentEntryFiltre = null;
    target.layoutFragmentEntryType = null;
    target.fabEntryValiderFiltre = null;
    target.fabEntryRazFiltre = null;
    target.linearLayoutEntryFiltreCategory = null;
    target.checkboxEntryFiltreCategorySelectAll = null;
    target.buttonEntryFiltreCategory = null;
    target.linearLayoutEntryType = null;
    target.linearLayoutEntryFiltreLocation = null;
    target.checkboxEntryFiltreLocationSelectAll = null;
    target.buttonEntryFiltreLocation = null;
    target.linearLayoutEntryFiltreActivity = null;
    target.checkboxEntryFiltreActivitySelectAll = null;
    target.buttonEntryFiltreActivity = null;
    target.linearLayoutEntryFiltreAmenity = null;
    target.checkboxEntryFiltreAmenitySelectAll = null;
    target.buttonEntryFiltreAmenity = null;
    target.linearLayoutEntryFiltreAnimation = null;
    target.checkboxEntryFiltreAnimationSelectAll = null;
    target.buttonEntryFiltreAnimation = null;
    target.linearLayoutEntryFiltreAtmospher = null;
    target.checkboxEntryFiltreAtmospherSelectAll = null;
    target.buttonEntryFiltreAtmospher = null;
    target.linearLayoutEntryFiltreChain = null;
    target.checkboxEntryFiltreChainSelectAll = null;
    target.buttonEntryFiltreChain = null;
    target.linearLayoutEntryFiltreFurnishedRental = null;
    target.checkboxEntryFiltreFurnishedRentalSelectAll = null;
    target.buttonEntryFiltreFurnishedRental = null;
    target.linearLayoutEntryFiltreLabel = null;
    target.checkboxEntryFiltreLabelSelectAll = null;
    target.buttonEntryFiltreLabel = null;
    target.linearLayoutEntryFiltreService = null;
    target.checkboxEntryFiltreServiceSelectAll = null;
    target.buttonEntryFiltreService = null;
    target.linearLayoutEntryFiltreStandingLevel = null;
    target.checkboxEntryFiltreStandingLevelSelectAll = null;
    target.buttonEntryFiltreStandingLevel = null;
    target.checkboxEntryTypeBoutique = null;
    target.checkboxEntryTypeHotel = null;
    target.checkboxEntryTypeShopping = null;
    target.checkboxEntryTypeVisite = null;
    target.checkboxEntryTypeHebergement = null;
    target.checkboxEntryTypeUtile = null;
    target.checkboxEntryTypeSortie = null;
    target.checkboxEntryTypeTransport = null;
    target.checkboxEntryTypeRestaurant = null;
    target.list_recycler_event = null;
    target.layoutFragmentEvenementTri = null;
    target.rbEvenementTriNom = null;
    target.rbEvenementTridDate = null;
    target.layoutFragmentEvenementFiltre = null;
    target.fabEvenementValiderFiltre = null;
    target.fabEvenementRazFiltre = null;
    target.linearLayoutEvenementFiltreCategory = null;
    target.checkboxEvenementFiltreCategorySelectAll = null;
    target.linearLayoutEvenementFiltreVille = null;
    target.checkboxEvenementFiltreVilleSelectAll = null;
    target.buttonEvenementFiltreCategory = null;
    target.buttonEvenementFiltreVille = null;

    if (view7f08012f != null) {
      view7f08012f.setOnClickListener(null);
      view7f08012f = null;
    }
    if (view7f08012d != null) {
      view7f08012d.setOnClickListener(null);
      view7f08012d = null;
    }
    if (view7f0801fc != null) {
      view7f0801fc.setOnClickListener(null);
      view7f0801fc = null;
    }
    if (view7f0801fb != null) {
      view7f0801fb.setOnClickListener(null);
      view7f0801fb = null;
    }
    if (view7f080132 != null) {
      view7f080132.setOnClickListener(null);
      view7f080132 = null;
    }
    if (view7f080131 != null) {
      view7f080131.setOnClickListener(null);
      view7f080131 = null;
    }
    if (view7f080130 != null) {
      view7f080130.setOnClickListener(null);
      view7f080130 = null;
    }
    if (view7f08012e != null) {
      view7f08012e.setOnClickListener(null);
      view7f08012e = null;
    }
  }
}
