// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEvenementsActivity_ViewBinding extends NavDrawerActivity_ViewBinding {
  private AfficherEvenementsActivity target;

  private View view7f0801ea;

  private View view7f0801e9;

  private View view7f080126;

  private View view7f080125;

  @UiThread
  public AfficherEvenementsActivity_ViewBinding(AfficherEvenementsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEvenementsActivity_ViewBinding(final AfficherEvenementsActivity target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    target.list_recycler_event = Utils.findRequiredViewAsType(source, R.id.list_recycler_event, "field 'list_recycler_event'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.simpleProgressBar, "field 'progressBar'", ProgressBar.class);
    target.layoutFragmentEvenementTri = Utils.findRequiredViewAsType(source, R.id.layout_fragment_evenement_tri, "field 'layoutFragmentEvenementTri'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.radio_button_evenement_tri_nom, "field 'rbEvenementTriNom' and method 'rbEvenementTriNomClick'");
    target.rbEvenementTriNom = Utils.castView(view, R.id.radio_button_evenement_tri_nom, "field 'rbEvenementTriNom'", MaterialRadioButton.class);
    view7f0801ea = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.rbEvenementTriNomClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.radio_button_evenement_tri_date, "field 'rbEvenementTridDate' and method 'rbEvenementTriDateClick'");
    target.rbEvenementTridDate = Utils.castView(view, R.id.radio_button_evenement_tri_date, "field 'rbEvenementTridDate'", MaterialRadioButton.class);
    view7f0801e9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.rbEvenementTriDateClick();
      }
    });
    target.layoutFragmentEvenementFiltre = Utils.findRequiredViewAsType(source, R.id.layout_fragment_evenement_filtre, "field 'layoutFragmentEvenementFiltre'", FrameLayout.class);
    view = source.findViewById(R.id.fabEvenementValiderFiltre);
    target.fabEvenementValiderFiltre = Utils.castView(view, R.id.fabEvenementValiderFiltre, "field 'fabEvenementValiderFiltre'", FloatingActionButton.class);
    if (view != null) {
      view7f080126 = view;
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
      view7f080125 = view;
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
  }

  @Override
  public void unbind() {
    AfficherEvenementsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list_recycler_event = null;
    target.progressBar = null;
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

    view7f0801ea.setOnClickListener(null);
    view7f0801ea = null;
    view7f0801e9.setOnClickListener(null);
    view7f0801e9 = null;
    if (view7f080126 != null) {
      view7f080126.setOnClickListener(null);
      view7f080126 = null;
    }
    if (view7f080125 != null) {
      view7f080125.setOnClickListener(null);
      view7f080125 = null;
    }

    super.unbind();
  }
}
