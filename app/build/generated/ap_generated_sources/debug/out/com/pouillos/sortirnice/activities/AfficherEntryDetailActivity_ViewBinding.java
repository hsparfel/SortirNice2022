// Generated code from Butter Knife. Do not modify!
package com.pouillos.sortirnice.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pouillos.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEntryDetailActivity_ViewBinding implements Unbinder {
  private AfficherEntryDetailActivity target;

  @UiThread
  public AfficherEntryDetailActivity_ViewBinding(AfficherEntryDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEntryDetailActivity_ViewBinding(AfficherEntryDetailActivity target, View source) {
    this.target = target;

    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.nameFr = Utils.findRequiredViewAsType(source, R.id.name_fr, "field 'nameFr'", TextView.class);
    target.category = Utils.findRequiredViewAsType(source, R.id.category, "field 'category'", TextView.class);
    target.descriptionDescription = Utils.findRequiredViewAsType(source, R.id.description_description, "field 'descriptionDescription'", TextView.class);
    target.start = Utils.findRequiredViewAsType(source, R.id.start, "field 'start'", TextView.class);
    target.end = Utils.findRequiredViewAsType(source, R.id.end, "field 'end'", TextView.class);
    target.addressLine1 = Utils.findRequiredViewAsType(source, R.id.address_line1, "field 'addressLine1'", TextView.class);
    target.addressLine2 = Utils.findRequiredViewAsType(source, R.id.address_line2, "field 'addressLine2'", TextView.class);
    target.addressLine3 = Utils.findRequiredViewAsType(source, R.id.address_line3, "field 'addressLine3'", TextView.class);
    target.addressZip = Utils.findRequiredViewAsType(source, R.id.address_zip, "field 'addressZip'", TextView.class);
    target.addressCity = Utils.findRequiredViewAsType(source, R.id.address_city, "field 'addressCity'", TextView.class);
    target.phone = Utils.findRequiredViewAsType(source, R.id.phone, "field 'phone'", TextView.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.email, "field 'email'", TextView.class);
    target.website = Utils.findRequiredViewAsType(source, R.id.website, "field 'website'", TextView.class);
    target.websiteReservation = Utils.findRequiredViewAsType(source, R.id.website_reservation, "field 'websiteReservation'", TextView.class);
    target.facebook = Utils.findRequiredViewAsType(source, R.id.facebook, "field 'facebook'", TextView.class);
    target.twitter = Utils.findRequiredViewAsType(source, R.id.twitter, "field 'twitter'", TextView.class);
    target.profile = Utils.findRequiredViewAsType(source, R.id.profile, "field 'profile'", TextView.class);
    target.station = Utils.findRequiredViewAsType(source, R.id.station, "field 'station'", TextView.class);
    target.option = Utils.findRequiredViewAsType(source, R.id.option, "field 'option'", TextView.class);
    target.disabledOption = Utils.findRequiredViewAsType(source, R.id.disabled_option, "field 'disabledOption'", TextView.class);
    target.frpOption = Utils.findRequiredViewAsType(source, R.id.frp_option, "field 'frpOption'", TextView.class);
    target.poiOption = Utils.findRequiredViewAsType(source, R.id.poi_option, "field 'poiOption'", TextView.class);
    target.groupOption = Utils.findRequiredViewAsType(source, R.id.group_option, "field 'groupOption'", TextView.class);
    target.familyOption = Utils.findRequiredViewAsType(source, R.id.family_option, "field 'familyOption'", TextView.class);
    target.secto = Utils.findRequiredViewAsType(source, R.id.secto, "field 'secto'", TextView.class);
    target.descriptionSituation = Utils.findRequiredViewAsType(source, R.id.description_situation, "field 'descriptionSituation'", TextView.class);
    target.descriptionTarification = Utils.findRequiredViewAsType(source, R.id.description_tarification, "field 'descriptionTarification'", TextView.class);
    target.descriptionHoraires = Utils.findRequiredViewAsType(source, R.id.description_horaires, "field 'descriptionHoraires'", TextView.class);
    target.payment = Utils.findRequiredViewAsType(source, R.id.payment, "field 'payment'", TextView.class);
    target.language = Utils.findRequiredViewAsType(source, R.id.language, "field 'language'", TextView.class);
    target.amenity = Utils.findRequiredViewAsType(source, R.id.amenity, "field 'amenity'", TextView.class);
    target.location = Utils.findRequiredViewAsType(source, R.id.location, "field 'location'", TextView.class);
    target.closure = Utils.findRequiredViewAsType(source, R.id.closure, "field 'closure'", TextView.class);
    target.label = Utils.findRequiredViewAsType(source, R.id.label, "field 'label'", TextView.class);
    target.service = Utils.findRequiredViewAsType(source, R.id.service, "field 'service'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AfficherEntryDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.image = null;
    target.nameFr = null;
    target.category = null;
    target.descriptionDescription = null;
    target.start = null;
    target.end = null;
    target.addressLine1 = null;
    target.addressLine2 = null;
    target.addressLine3 = null;
    target.addressZip = null;
    target.addressCity = null;
    target.phone = null;
    target.email = null;
    target.website = null;
    target.websiteReservation = null;
    target.facebook = null;
    target.twitter = null;
    target.profile = null;
    target.station = null;
    target.option = null;
    target.disabledOption = null;
    target.frpOption = null;
    target.poiOption = null;
    target.groupOption = null;
    target.familyOption = null;
    target.secto = null;
    target.descriptionSituation = null;
    target.descriptionTarification = null;
    target.descriptionHoraires = null;
    target.payment = null;
    target.language = null;
    target.amenity = null;
    target.location = null;
    target.closure = null;
    target.label = null;
    target.service = null;
  }
}
