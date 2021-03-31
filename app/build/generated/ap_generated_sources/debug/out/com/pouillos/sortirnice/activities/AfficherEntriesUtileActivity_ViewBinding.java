// Generated code from Butter Knife. Do not modify!
package com.pouillos.sortirnice.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillos.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEntriesUtileActivity_ViewBinding implements Unbinder {
  private AfficherEntriesUtileActivity target;

  private View view7f0800d1;

  @UiThread
  public AfficherEntriesUtileActivity_ViewBinding(AfficherEntriesUtileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEntriesUtileActivity_ViewBinding(final AfficherEntriesUtileActivity target,
      View source) {
    this.target = target;

    View view;
    target.list_recycler_event = Utils.findRequiredViewAsType(source, R.id.list_recycler_event, "field 'list_recycler_event'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.simpleProgressBar, "field 'progressBar'", ProgressBar.class);
    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.nameFr = Utils.findRequiredViewAsType(source, R.id.name_fr, "field 'nameFr'", TextView.class);
    target.category = Utils.findRequiredViewAsType(source, R.id.category, "field 'category'", TextView.class);
    target.addressLine1 = Utils.findRequiredViewAsType(source, R.id.address_line1, "field 'addressLine1'", TextView.class);
    target.addressLine2 = Utils.findRequiredViewAsType(source, R.id.address_line2, "field 'addressLine2'", TextView.class);
    target.addressLine3 = Utils.findRequiredViewAsType(source, R.id.address_line3, "field 'addressLine3'", TextView.class);
    target.addressZip = Utils.findRequiredViewAsType(source, R.id.address_zip, "field 'addressZip'", TextView.class);
    target.addressCity = Utils.findRequiredViewAsType(source, R.id.address_city, "field 'addressCity'", TextView.class);
    target.phone = Utils.findRequiredViewAsType(source, R.id.phone, "field 'phone'", TextView.class);
    target.fax = Utils.findRequiredViewAsType(source, R.id.fax, "field 'fax'", TextView.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.email, "field 'email'", TextView.class);
    target.website = Utils.findRequiredViewAsType(source, R.id.website, "field 'website'", TextView.class);
    target.facebook = Utils.findRequiredViewAsType(source, R.id.facebook, "field 'facebook'", TextView.class);
    target.twitter = Utils.findRequiredViewAsType(source, R.id.twitter, "field 'twitter'", TextView.class);
    target.station = Utils.findRequiredViewAsType(source, R.id.station, "field 'station'", TextView.class);
    target.option = Utils.findRequiredViewAsType(source, R.id.option, "field 'option'", TextView.class);
    target.payment = Utils.findRequiredViewAsType(source, R.id.payment, "field 'payment'", TextView.class);
    target.amenity = Utils.findRequiredViewAsType(source, R.id.amenity, "field 'amenity'", TextView.class);
    target.location = Utils.findRequiredViewAsType(source, R.id.location, "field 'location'", TextView.class);
    target.closure = Utils.findRequiredViewAsType(source, R.id.closure, "field 'closure'", TextView.class);
    target.label = Utils.findRequiredViewAsType(source, R.id.label, "field 'label'", TextView.class);
    target.service = Utils.findRequiredViewAsType(source, R.id.service, "field 'service'", TextView.class);
    target.opening = Utils.findRequiredViewAsType(source, R.id.opening, "field 'opening'", TextView.class);
    target.closing = Utils.findRequiredViewAsType(source, R.id.closing, "field 'closing'", TextView.class);
    target.openings = Utils.findRequiredViewAsType(source, R.id.openings, "field 'openings'", TextView.class);
    target.closings = Utils.findRequiredViewAsType(source, R.id.closings, "field 'closings'", TextView.class);
    target.animation = Utils.findRequiredViewAsType(source, R.id.animation, "field 'animation'", TextView.class);
    target.atmosphere = Utils.findRequiredViewAsType(source, R.id.atmosphere, "field 'atmosphere'", TextView.class);
    target.capacityTotal = Utils.findRequiredViewAsType(source, R.id.capacity_total, "field 'capacityTotal'", TextView.class);
    target.capacityInterieur = Utils.findRequiredViewAsType(source, R.id.capacity_interieur, "field 'capacityInterieur'", TextView.class);
    target.capacityExterieur = Utils.findRequiredViewAsType(source, R.id.capacity_exterieur, "field 'capacityExterieur'", TextView.class);
    target.capacityAssis = Utils.findRequiredViewAsType(source, R.id.capacity_assis, "field 'capacityAssis'", TextView.class);
    target.capacityDebout = Utils.findRequiredViewAsType(source, R.id.capacity_debout, "field 'capacityDebout'", TextView.class);
    target.capacityGroup = Utils.findRequiredViewAsType(source, R.id.capacity_group, "field 'capacityGroup'", TextView.class);
    target.capacitySalle = Utils.findRequiredViewAsType(source, R.id.capacity_salle, "field 'capacitySalle'", TextView.class);
    target.layoutAddress = Utils.findRequiredViewAsType(source, R.id.layout_address, "field 'layoutAddress'", LinearLayout.class);
    target.boutonsMapWaze = Utils.findRequiredViewAsType(source, R.id.boutons_map_waze, "field 'boutonsMapWaze'", LinearLayout.class);
    target.ouvert = Utils.findRequiredViewAsType(source, R.id.ouvert, "field 'ouvert'", LinearLayout.class);
    target.ferme = Utils.findRequiredViewAsType(source, R.id.ferme, "field 'ferme'", LinearLayout.class);
    target.layoutPayment = Utils.findRequiredViewAsType(source, R.id.layout_payment, "field 'layoutPayment'", LinearLayout.class);
    target.layoutLabel = Utils.findRequiredViewAsType(source, R.id.layout_label, "field 'layoutLabel'", LinearLayout.class);
    target.layoutAnimation = Utils.findRequiredViewAsType(source, R.id.layout_animation, "field 'layoutAnimation'", LinearLayout.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scrollView, "field 'scrollView'", ScrollView.class);
    target.fabExit = Utils.findRequiredViewAsType(source, R.id.fabExit, "field 'fabExit'", FloatingActionButton.class);
    view = Utils.findRequiredView(source, R.id.fabSave, "field 'fabSave' and method 'fabSaveClick'");
    target.fabSave = Utils.castView(view, R.id.fabSave, "field 'fabSave'", FloatingActionButton.class);
    view7f0800d1 = view;
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
    AfficherEntriesUtileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list_recycler_event = null;
    target.progressBar = null;
    target.image = null;
    target.nameFr = null;
    target.category = null;
    target.addressLine1 = null;
    target.addressLine2 = null;
    target.addressLine3 = null;
    target.addressZip = null;
    target.addressCity = null;
    target.phone = null;
    target.fax = null;
    target.email = null;
    target.website = null;
    target.facebook = null;
    target.twitter = null;
    target.station = null;
    target.option = null;
    target.payment = null;
    target.amenity = null;
    target.location = null;
    target.closure = null;
    target.label = null;
    target.service = null;
    target.opening = null;
    target.closing = null;
    target.openings = null;
    target.closings = null;
    target.animation = null;
    target.atmosphere = null;
    target.capacityTotal = null;
    target.capacityInterieur = null;
    target.capacityExterieur = null;
    target.capacityAssis = null;
    target.capacityDebout = null;
    target.capacityGroup = null;
    target.capacitySalle = null;
    target.layoutAddress = null;
    target.boutonsMapWaze = null;
    target.ouvert = null;
    target.ferme = null;
    target.layoutPayment = null;
    target.layoutLabel = null;
    target.layoutAnimation = null;
    target.scrollView = null;
    target.fabExit = null;
    target.fabSave = null;

    view7f0800d1.setOnClickListener(null);
    view7f0800d1 = null;
  }
}
