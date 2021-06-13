// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEventsActivity_ViewBinding implements Unbinder {
  private AfficherEventsActivity target;

  @UiThread
  public AfficherEventsActivity_ViewBinding(AfficherEventsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEventsActivity_ViewBinding(AfficherEventsActivity target, View source) {
    this.target = target;

    target.list_recycler_event = Utils.findRequiredViewAsType(source, R.id.list_recycler_event, "field 'list_recycler_event'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.simpleProgressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AfficherEventsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list_recycler_event = null;
    target.progressBar = null;
  }
}
