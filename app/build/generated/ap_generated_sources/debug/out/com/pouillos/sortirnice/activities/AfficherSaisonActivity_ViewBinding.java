// Generated code from Butter Knife. Do not modify!
package com.pouillos.sortirnice.activities;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherSaisonActivity_ViewBinding implements Unbinder {
  private AfficherSaisonActivity target;

  private View view7f0800c7;

  private View view7f0800c6;

  @UiThread
  public AfficherSaisonActivity_ViewBinding(AfficherSaisonActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherSaisonActivity_ViewBinding(final AfficherSaisonActivity target, View source) {
    this.target = target;

    View view;
    target.layoutName = Utils.findRequiredViewAsType(source, R.id.layoutName, "field 'layoutName'", TextInputLayout.class);
    target.textName = Utils.findRequiredViewAsType(source, R.id.textName, "field 'textName'", TextInputEditText.class);
    target.btnAddSaison = Utils.findRequiredViewAsType(source, R.id.btnAddSaison, "field 'btnAddSaison'", Button.class);
    view = Utils.findRequiredView(source, R.id.fabSave, "field 'fabSave' and method 'fabSaveClick'");
    target.fabSave = Utils.castView(view, R.id.fabSave, "field 'fabSave'", FloatingActionButton.class);
    view7f0800c7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabSaveClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fabCancel, "field 'fabCancel' and method 'fabCancelClick'");
    target.fabCancel = Utils.castView(view, R.id.fabCancel, "field 'fabCancel'", FloatingActionButton.class);
    view7f0800c6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabCancelClick();
      }
    });
    target.list_recycler_saison = Utils.findRequiredViewAsType(source, R.id.list_recycler_saison, "field 'list_recycler_saison'", RecyclerView.class);
    target.layoutNbEpisode = Utils.findRequiredViewAsType(source, R.id.layoutNbEpisode, "field 'layoutNbEpisode'", TextInputLayout.class);
    target.textNbEpisode = Utils.findRequiredViewAsType(source, R.id.textNbEpisode, "field 'textNbEpisode'", TextInputEditText.class);
    target.layoutNumSaison = Utils.findRequiredViewAsType(source, R.id.layoutNumSaison, "field 'layoutNumSaison'", TextInputLayout.class);
    target.textNumSaison = Utils.findRequiredViewAsType(source, R.id.textNumSaison, "field 'textNumSaison'", TextInputEditText.class);
    target.switchLgg = Utils.findRequiredViewAsType(source, R.id.switchLgg, "field 'switchLgg'", SwitchMaterial.class);
    target.switchFini = Utils.findRequiredViewAsType(source, R.id.switchFini, "field 'switchFini'", SwitchMaterial.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AfficherSaisonActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutName = null;
    target.textName = null;
    target.btnAddSaison = null;
    target.fabSave = null;
    target.fabCancel = null;
    target.list_recycler_saison = null;
    target.layoutNbEpisode = null;
    target.textNbEpisode = null;
    target.layoutNumSaison = null;
    target.textNumSaison = null;
    target.switchLgg = null;
    target.switchFini = null;

    view7f0800c7.setOnClickListener(null);
    view7f0800c7 = null;
    view7f0800c6.setOnClickListener(null);
    view7f0800c6 = null;
  }
}
