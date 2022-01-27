// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherFavorisActivity_ViewBinding extends NavDrawerActivity_ViewBinding {
  private AfficherFavorisActivity target;

  @UiThread
  public AfficherFavorisActivity_ViewBinding(AfficherFavorisActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherFavorisActivity_ViewBinding(AfficherFavorisActivity target, View source) {
    super(target, source);

    this.target = target;

    target.btnEntryFavori = Utils.findOptionalViewAsType(source, R.id.btnEntryFavori, "field 'btnEntryFavori'", MaterialButton.class);
    target.btnEventFavori = Utils.findOptionalViewAsType(source, R.id.btnEventFavori, "field 'btnEventFavori'", MaterialButton.class);
    target.textFavoriVide = Utils.findOptionalViewAsType(source, R.id.textFavoriVide, "field 'textFavoriVide'", TextView.class);
  }

  @Override
  public void unbind() {
    AfficherFavorisActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnEntryFavori = null;
    target.btnEventFavori = null;
    target.textFavoriVide = null;

    super.unbind();
  }
}
