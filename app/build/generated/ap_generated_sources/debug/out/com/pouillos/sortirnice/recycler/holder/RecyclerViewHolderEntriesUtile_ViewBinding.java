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

public class RecyclerViewHolderEntriesUtile_ViewBinding implements Unbinder {
  private RecyclerViewHolderEntriesUtile target;

  @UiThread
  public RecyclerViewHolderEntriesUtile_ViewBinding(RecyclerViewHolderEntriesUtile target,
      View source) {
    this.target = target;

    target.titre = Utils.findRequiredViewAsType(source, R.id.titre, "field 'titre'", TextView.class);
    target.textCategories = Utils.findRequiredViewAsType(source, R.id.text_categories, "field 'textCategories'", TextView.class);
    target.textLocations = Utils.findRequiredViewAsType(source, R.id.text_locations, "field 'textLocations'", TextView.class);
    target.textAtmospheres = Utils.findRequiredViewAsType(source, R.id.text_atmospheres, "field 'textAtmospheres'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecyclerViewHolderEntriesUtile target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titre = null;
    target.textCategories = null;
    target.textLocations = null;
    target.textAtmospheres = null;
  }
}
