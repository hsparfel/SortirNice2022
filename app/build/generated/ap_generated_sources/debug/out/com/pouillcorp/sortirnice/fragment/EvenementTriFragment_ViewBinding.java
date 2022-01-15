// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.fragment;

import android.view.View;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EvenementTriFragment_ViewBinding implements Unbinder {
  private EvenementTriFragment target;

  private View view7f0801db;

  private View view7f0801da;

  @UiThread
  public EvenementTriFragment_ViewBinding(final EvenementTriFragment target, View source) {
    this.target = target;

    View view;
    target.radioEvenementTriGroup = Utils.findRequiredViewAsType(source, R.id.radioEvenementTriGroup, "field 'radioEvenementTriGroup'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.radio_button_evenement_tri_nom, "field 'rbEvenementTriNom' and method 'rbEvenementTriNomClick'");
    target.rbEvenementTriNom = Utils.castView(view, R.id.radio_button_evenement_tri_nom, "field 'rbEvenementTriNom'", MaterialRadioButton.class);
    view7f0801db = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.rbEvenementTriNomClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.radio_button_evenement_tri_date, "field 'rbEvenementTridDate' and method 'rbEvenementTriDateClick'");
    target.rbEvenementTridDate = Utils.castView(view, R.id.radio_button_evenement_tri_date, "field 'rbEvenementTridDate'", MaterialRadioButton.class);
    view7f0801da = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.rbEvenementTriDateClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    EvenementTriFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.radioEvenementTriGroup = null;
    target.rbEvenementTriNom = null;
    target.rbEvenementTridDate = null;

    view7f0801db.setOnClickListener(null);
    view7f0801db = null;
    view7f0801da.setOnClickListener(null);
    view7f0801da = null;
  }
}
