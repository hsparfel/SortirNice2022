// Generated code from Butter Knife. Do not modify!
package com.pouillos.sortirnice.activities;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EnregistrerSerieActivity_ViewBinding implements Unbinder {
  private EnregistrerSerieActivity target;

  private View view7f0800bd;

  @UiThread
  public EnregistrerSerieActivity_ViewBinding(EnregistrerSerieActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EnregistrerSerieActivity_ViewBinding(final EnregistrerSerieActivity target, View source) {
    this.target = target;

    View view;
    target.textName = Utils.findRequiredViewAsType(source, R.id.textName, "field 'textName'", TextInputEditText.class);
    target.layoutName = Utils.findRequiredViewAsType(source, R.id.layoutName, "field 'layoutName'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.fabSave, "field 'fabSave' and method 'fabSaveClick'");
    target.fabSave = Utils.castView(view, R.id.fabSave, "field 'fabSave'", FloatingActionButton.class);
    view7f0800bd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabSaveClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    EnregistrerSerieActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textName = null;
    target.layoutName = null;
    target.fabSave = null;

    view7f0800bd.setOnClickListener(null);
    view7f0800bd = null;
  }
}
