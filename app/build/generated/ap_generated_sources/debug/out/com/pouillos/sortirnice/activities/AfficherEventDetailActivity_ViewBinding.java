// Generated code from Butter Knife. Do not modify!
package com.pouillos.sortirnice.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillos.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEventDetailActivity_ViewBinding implements Unbinder {
  private AfficherEventDetailActivity target;

  @UiThread
  public AfficherEventDetailActivity_ViewBinding(AfficherEventDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEventDetailActivity_ViewBinding(AfficherEventDetailActivity target, View source) {
    this.target = target;

    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.nameFr = Utils.findRequiredViewAsType(source, R.id.name_fr, "field 'nameFr'", TextView.class);
    target.category = Utils.findRequiredViewAsType(source, R.id.category, "field 'category'", TextView.class);
    target.descriptionDescription = Utils.findRequiredViewAsType(source, R.id.description_description, "field 'descriptionDescription'", TextView.class);
    target.start = Utils.findRequiredViewAsType(source, R.id.start, "field 'start'", TextView.class);
    target.end = Utils.findRequiredViewAsType(source, R.id.end, "field 'end'", TextView.class);
    target.adressContent = Utils.findRequiredViewAsType(source, R.id.adress_content, "field 'adressContent'", TextView.class);
    target.adressZip = Utils.findRequiredViewAsType(source, R.id.adress_zip, "field 'adressZip'", TextView.class);
    target.adressCity = Utils.findRequiredViewAsType(source, R.id.adress_city, "field 'adressCity'", TextView.class);
    target.phone = Utils.findRequiredViewAsType(source, R.id.phone, "field 'phone'", TextView.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.email, "field 'email'", TextView.class);
    target.websiteSituation = Utils.findRequiredViewAsType(source, R.id.website_situation, "field 'websiteSituation'", TextView.class);
    target.websitePrincipal = Utils.findRequiredViewAsType(source, R.id.website_principal, "field 'websitePrincipal'", TextView.class);
    target.profile = Utils.findRequiredViewAsType(source, R.id.profile, "field 'profile'", TextView.class);
    target.station = Utils.findRequiredViewAsType(source, R.id.station, "field 'station'", TextView.class);
    target.option = Utils.findRequiredViewAsType(source, R.id.option, "field 'option'", TextView.class);
    target.secto = Utils.findRequiredViewAsType(source, R.id.secto, "field 'secto'", TextView.class);
    target.descriptionSituation = Utils.findRequiredViewAsType(source, R.id.description_situation, "field 'descriptionSituation'", TextView.class);
    target.descriptionTarification = Utils.findRequiredViewAsType(source, R.id.description_tarification, "field 'descriptionTarification'", TextView.class);
    target.descriptionHoraires = Utils.findRequiredViewAsType(source, R.id.description_horaires, "field 'descriptionHoraires'", TextView.class);
    target.fabExit = Utils.findRequiredViewAsType(source, R.id.fabExit, "field 'fabExit'", FloatingActionButton.class);
    target.fabSave = Utils.findRequiredViewAsType(source, R.id.fabSave, "field 'fabSave'", FloatingActionButton.class);
    target.fabDelete = Utils.findRequiredViewAsType(source, R.id.fabDelete, "field 'fabDelete'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AfficherEventDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.image = null;
    target.nameFr = null;
    target.category = null;
    target.descriptionDescription = null;
    target.start = null;
    target.end = null;
    target.adressContent = null;
    target.adressZip = null;
    target.adressCity = null;
    target.phone = null;
    target.email = null;
    target.websiteSituation = null;
    target.websitePrincipal = null;
    target.profile = null;
    target.station = null;
    target.option = null;
    target.secto = null;
    target.descriptionSituation = null;
    target.descriptionTarification = null;
    target.descriptionHoraires = null;
    target.fabExit = null;
    target.fabSave = null;
    target.fabDelete = null;
  }
}
