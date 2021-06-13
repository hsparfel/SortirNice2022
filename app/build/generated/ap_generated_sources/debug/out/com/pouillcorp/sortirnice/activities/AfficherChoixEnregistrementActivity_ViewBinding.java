// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import android.widget.ScrollView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.chip.Chip;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherChoixEnregistrementActivity_ViewBinding implements Unbinder {
  private AfficherChoixEnregistrementActivity target;

  private View view7f080083;

  private View view7f080084;

  private View view7f080086;

  private View view7f080087;

  private View view7f080088;

  private View view7f08008d;

  private View view7f080089;

  private View view7f08008b;

  private View view7f08008a;

  private View view7f08008c;

  @UiThread
  public AfficherChoixEnregistrementActivity_ViewBinding(
      AfficherChoixEnregistrementActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherChoixEnregistrementActivity_ViewBinding(
      final AfficherChoixEnregistrementActivity target, View source) {
    this.target = target;

    View view;
    target.list_recycler_event = Utils.findRequiredViewAsType(source, R.id.list_recycler_event, "field 'list_recycler_event'", RecyclerView.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scrollView, "field 'scrollView'", ScrollView.class);
    view = Utils.findRequiredView(source, R.id.chipBoutique, "field 'chipBoutique' and method 'setChipBoutiqueClick'");
    target.chipBoutique = Utils.castView(view, R.id.chipBoutique, "field 'chipBoutique'", Chip.class);
    view7f080083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipBoutiqueClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipEvent, "field 'chipEvent' and method 'setChipEventClick'");
    target.chipEvent = Utils.castView(view, R.id.chipEvent, "field 'chipEvent'", Chip.class);
    view7f080084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipEventClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipHebergement, "field 'chipHebergement' and method 'setChipHebergementClick'");
    target.chipHebergement = Utils.castView(view, R.id.chipHebergement, "field 'chipHebergement'", Chip.class);
    view7f080086 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipHebergementClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipHotel, "field 'chipHotel' and method 'setChipHotelClick'");
    target.chipHotel = Utils.castView(view, R.id.chipHotel, "field 'chipHotel'", Chip.class);
    view7f080087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipHotelClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipRestaurant, "field 'chipRestaurant' and method 'setChipRestaurantClick'");
    target.chipRestaurant = Utils.castView(view, R.id.chipRestaurant, "field 'chipRestaurant'", Chip.class);
    view7f080088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipRestaurantClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipVisite, "field 'chipVisite' and method 'setChipVisiteClick'");
    target.chipVisite = Utils.castView(view, R.id.chipVisite, "field 'chipVisite'", Chip.class);
    view7f08008d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipVisiteClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipShopping, "field 'chipShopping' and method 'setChipShoppingClick'");
    target.chipShopping = Utils.castView(view, R.id.chipShopping, "field 'chipShopping'", Chip.class);
    view7f080089 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipShoppingClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipTransport, "field 'chipTransport' and method 'setChipTransportClick'");
    target.chipTransport = Utils.castView(view, R.id.chipTransport, "field 'chipTransport'", Chip.class);
    view7f08008b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipTransportClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipSortie, "field 'chipSortie' and method 'setChipSortieClick'");
    target.chipSortie = Utils.castView(view, R.id.chipSortie, "field 'chipSortie'", Chip.class);
    view7f08008a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipSortieClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipUtile, "field 'chipUtile' and method 'setChipUtileClick'");
    target.chipUtile = Utils.castView(view, R.id.chipUtile, "field 'chipUtile'", Chip.class);
    view7f08008c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setChipUtileClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AfficherChoixEnregistrementActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list_recycler_event = null;
    target.scrollView = null;
    target.chipBoutique = null;
    target.chipEvent = null;
    target.chipHebergement = null;
    target.chipHotel = null;
    target.chipRestaurant = null;
    target.chipVisite = null;
    target.chipShopping = null;
    target.chipTransport = null;
    target.chipSortie = null;
    target.chipUtile = null;

    view7f080083.setOnClickListener(null);
    view7f080083 = null;
    view7f080084.setOnClickListener(null);
    view7f080084 = null;
    view7f080086.setOnClickListener(null);
    view7f080086 = null;
    view7f080087.setOnClickListener(null);
    view7f080087 = null;
    view7f080088.setOnClickListener(null);
    view7f080088 = null;
    view7f08008d.setOnClickListener(null);
    view7f08008d = null;
    view7f080089.setOnClickListener(null);
    view7f080089 = null;
    view7f08008b.setOnClickListener(null);
    view7f08008b = null;
    view7f08008a.setOnClickListener(null);
    view7f08008a = null;
    view7f08008c.setOnClickListener(null);
    view7f08008c = null;
  }
}
