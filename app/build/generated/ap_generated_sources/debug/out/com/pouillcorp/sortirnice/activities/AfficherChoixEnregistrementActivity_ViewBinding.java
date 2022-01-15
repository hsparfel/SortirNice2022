// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherChoixEnregistrementActivity_ViewBinding implements Unbinder {
  private AfficherChoixEnregistrementActivity target;

  private View view7f080078;

  private View view7f080079;

  private View view7f08007a;

  private View view7f08007b;

  private View view7f08007d;

  private View view7f080082;

  private View view7f08007e;

  private View view7f080080;

  private View view7f08007f;

  private View view7f080081;

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
    view = Utils.findRequiredView(source, R.id.btn_boutique, "field 'btnBoutique' and method 'setButtonBoutiqueClick'");
    target.btnBoutique = Utils.castView(view, R.id.btn_boutique, "field 'btnBoutique'", Button.class);
    view7f080078 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonBoutiqueClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_event, "field 'btnEvent' and method 'setButtonEventClick'");
    target.btnEvent = Utils.castView(view, R.id.btn_event, "field 'btnEvent'", Button.class);
    view7f080079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonEventClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_hebergement, "field 'btnHebergement' and method 'setButtonHebergementClick'");
    target.btnHebergement = Utils.castView(view, R.id.btn_hebergement, "field 'btnHebergement'", Button.class);
    view7f08007a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonHebergementClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_hotel, "field 'btnHotel' and method 'setButtonHotelClick'");
    target.btnHotel = Utils.castView(view, R.id.btn_hotel, "field 'btnHotel'", Button.class);
    view7f08007b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonHotelClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_restaurant, "field 'btnRestaurant' and method 'setButtonRestaurantClick'");
    target.btnRestaurant = Utils.castView(view, R.id.btn_restaurant, "field 'btnRestaurant'", Button.class);
    view7f08007d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonRestaurantClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_visit, "field 'btnVisite' and method 'setButtonVisiteClick'");
    target.btnVisite = Utils.castView(view, R.id.btn_visit, "field 'btnVisite'", Button.class);
    view7f080082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonVisiteClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_shopping, "field 'btnShopping' and method 'setButtonShoppingClick'");
    target.btnShopping = Utils.castView(view, R.id.btn_shopping, "field 'btnShopping'", Button.class);
    view7f08007e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonShoppingClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_transport, "field 'btnTransport' and method 'setButtonTransportClick'");
    target.btnTransport = Utils.castView(view, R.id.btn_transport, "field 'btnTransport'", Button.class);
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonTransportClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sortie, "field 'btnSortie' and method 'setButtonSortieClick'");
    target.btnSortie = Utils.castView(view, R.id.btn_sortie, "field 'btnSortie'", Button.class);
    view7f08007f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonSortieClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_utile, "field 'btnUtile' and method 'setButtonUtileClick'");
    target.btnUtile = Utils.castView(view, R.id.btn_utile, "field 'btnUtile'", Button.class);
    view7f080081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setButtonUtileClick();
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
    target.btnBoutique = null;
    target.btnEvent = null;
    target.btnHebergement = null;
    target.btnHotel = null;
    target.btnRestaurant = null;
    target.btnVisite = null;
    target.btnShopping = null;
    target.btnTransport = null;
    target.btnSortie = null;
    target.btnUtile = null;

    view7f080078.setOnClickListener(null);
    view7f080078 = null;
    view7f080079.setOnClickListener(null);
    view7f080079 = null;
    view7f08007a.setOnClickListener(null);
    view7f08007a = null;
    view7f08007b.setOnClickListener(null);
    view7f08007b = null;
    view7f08007d.setOnClickListener(null);
    view7f08007d = null;
    view7f080082.setOnClickListener(null);
    view7f080082 = null;
    view7f08007e.setOnClickListener(null);
    view7f08007e = null;
    view7f080080.setOnClickListener(null);
    view7f080080 = null;
    view7f08007f.setOnClickListener(null);
    view7f08007f = null;
    view7f080081.setOnClickListener(null);
    view7f080081 = null;
  }
}
