// Generated code from Butter Knife. Do not modify!
package com.pouillos.sortirnice.recycler.holder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pouillos.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecyclerViewHolderSerie_ViewBinding implements Unbinder {
  private RecyclerViewHolderSerie target;

  @UiThread
  public RecyclerViewHolderSerie_ViewBinding(RecyclerViewHolderSerie target, View source) {
    this.target = target;

    target.detail = Utils.findRequiredViewAsType(source, R.id.detail, "field 'detail'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecyclerViewHolderSerie target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.detail = null;
  }
}
