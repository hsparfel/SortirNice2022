// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import androidx.annotation.UiThread;
import butterknife.internal.DebouncingOnClickListener;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RechercherAllEntriesActivity_ViewBinding extends NavDrawerEntryActivity_ViewBinding {
  private RechercherAllEntriesActivity target;

  private View view7f080118;

  @UiThread
  public RechercherAllEntriesActivity_ViewBinding(RechercherAllEntriesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RechercherAllEntriesActivity_ViewBinding(final RechercherAllEntriesActivity target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    view = source.findViewById(R.id.fabSave);
    if (view != null) {
      view7f080118 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabSaveClick();
        }
      });
    }
  }

  @Override
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    if (view7f080118 != null) {
      view7f080118.setOnClickListener(null);
      view7f080118 = null;
    }

    super.unbind();
  }
}
