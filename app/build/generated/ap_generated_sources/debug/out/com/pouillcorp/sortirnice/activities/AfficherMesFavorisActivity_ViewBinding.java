// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherMesFavorisActivity_ViewBinding extends NavDrawerEntryActivity_ViewBinding {
  private AfficherMesFavorisActivity target;

  private View view7f080116;

  private View view7f080117;

  @UiThread
  public AfficherMesFavorisActivity_ViewBinding(AfficherMesFavorisActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherMesFavorisActivity_ViewBinding(final AfficherMesFavorisActivity target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    target.rbEntries = Utils.findOptionalViewAsType(source, R.id.radio_button_entries, "field 'rbEntries'", MaterialRadioButton.class);
    target.rbEvents = Utils.findOptionalViewAsType(source, R.id.radio_button_events, "field 'rbEvents'", MaterialRadioButton.class);
    target.chipGroup = Utils.findOptionalViewAsType(source, R.id.chipGroup, "field 'chipGroup'", ChipGroup.class);
    target.chipVisit = Utils.findOptionalViewAsType(source, R.id.chip_visit, "field 'chipVisit'", Chip.class);
    target.chipBoutique = Utils.findOptionalViewAsType(source, R.id.chip_boutique, "field 'chipBoutique'", Chip.class);
    target.chipHebergement = Utils.findOptionalViewAsType(source, R.id.chip_hebergement, "field 'chipHebergement'", Chip.class);
    target.chipHotel = Utils.findOptionalViewAsType(source, R.id.chip_hotel, "field 'chipHotel'", Chip.class);
    target.chipTransport = Utils.findOptionalViewAsType(source, R.id.chip_transport, "field 'chipTransport'", Chip.class);
    target.chipUtile = Utils.findOptionalViewAsType(source, R.id.chip_utile, "field 'chipUtile'", Chip.class);
    target.chipShopping = Utils.findOptionalViewAsType(source, R.id.chip_shopping, "field 'chipShopping'", Chip.class);
    target.chipSortie = Utils.findOptionalViewAsType(source, R.id.chip_sortie, "field 'chipSortie'", Chip.class);
    target.chipRestaurant = Utils.findOptionalViewAsType(source, R.id.chip_restaurant, "field 'chipRestaurant'", Chip.class);
    target.recyclerView = Utils.findOptionalViewAsType(source, R.id.list_recycler_event, "field 'recyclerView'", RecyclerView.class);
    target.btnAfficherTypeEntries = Utils.findOptionalViewAsType(source, R.id.btn_afficher_type_entries, "field 'btnAfficherTypeEntries'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.fabFiltre, "method 'fabFiltreClick'");
    view7f080116 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabFiltreClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fabRazFiltre, "method 'fabRazFiltreClick'");
    view7f080117 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabRazFiltreClick();
      }
    });
  }

  @Override
  public void unbind() {
    AfficherMesFavorisActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rbEntries = null;
    target.rbEvents = null;
    target.chipGroup = null;
    target.chipVisit = null;
    target.chipBoutique = null;
    target.chipHebergement = null;
    target.chipHotel = null;
    target.chipTransport = null;
    target.chipUtile = null;
    target.chipShopping = null;
    target.chipSortie = null;
    target.chipRestaurant = null;
    target.recyclerView = null;
    target.btnAfficherTypeEntries = null;

    view7f080116.setOnClickListener(null);
    view7f080116 = null;
    view7f080117.setOnClickListener(null);
    view7f080117 = null;

    super.unbind();
  }
}
