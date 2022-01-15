// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.recycler.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.card.MaterialCardView;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecyclerViewHolderEvenements_ViewBinding implements Unbinder {
  private RecyclerViewHolderEvenements target;

  @UiThread
  public RecyclerViewHolderEvenements_ViewBinding(RecyclerViewHolderEvenements target,
      View source) {
    this.target = target;

    target.titre = Utils.findRequiredViewAsType(source, R.id.titre, "field 'titre'", TextView.class);
    target.textSecondaire = Utils.findRequiredViewAsType(source, R.id.text_secondaire, "field 'textSecondaire'", TextView.class);
    target.textSupport = Utils.findRequiredViewAsType(source, R.id.text_support, "field 'textSupport'", TextView.class);
    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.card = Utils.findRequiredViewAsType(source, R.id.card, "field 'card'", MaterialCardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecyclerViewHolderEvenements target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.titre = null;
    target.textSecondaire = null;
    target.textSupport = null;
    target.image = null;
    target.card = null;
  }
}
