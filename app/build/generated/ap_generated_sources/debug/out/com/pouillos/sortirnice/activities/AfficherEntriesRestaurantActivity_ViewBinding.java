// Generated code from Butter Knife. Do not modify!
package com.pouillos.sortirnice.activities;

import android.view.View;
import androidx.annotation.UiThread;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pouillos.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEntriesRestaurantActivity_ViewBinding extends NavDrawerEntryActivity_ViewBinding {
  private AfficherEntriesRestaurantActivity target;

  private View view7f0800d5;

  @UiThread
  public AfficherEntriesRestaurantActivity_ViewBinding(AfficherEntriesRestaurantActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEntriesRestaurantActivity_ViewBinding(
      final AfficherEntriesRestaurantActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fabSave, "method 'fabSaveClick'");
    view7f0800d5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabSaveClick();
      }
    });
  }

  @Override
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0800d5.setOnClickListener(null);
    view7f0800d5 = null;

    super.unbind();
  }
}
