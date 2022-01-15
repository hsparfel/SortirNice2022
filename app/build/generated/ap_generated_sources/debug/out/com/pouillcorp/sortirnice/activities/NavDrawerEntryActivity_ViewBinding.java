// Generated code from Butter Knife. Do not modify!
package com.pouillcorp.sortirnice.activities;

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
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillcorp.sortirnice.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NavDrawerEntryActivity_ViewBinding implements Unbinder {
  private NavDrawerEntryActivity target;

  private View view7f080118;

  private View view7f080116;

  private View view7f080117;

  @UiThread
  public NavDrawerEntryActivity_ViewBinding(NavDrawerEntryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NavDrawerEntryActivity_ViewBinding(final NavDrawerEntryActivity target, View source) {
    this.target = target;

    View view;
    target.list_recycler_event = Utils.findOptionalViewAsType(source, R.id.list_recycler_event, "field 'list_recycler_event'", RecyclerView.class);
    target.progressBar = Utils.findOptionalViewAsType(source, R.id.simpleProgressBar, "field 'progressBar'", ProgressBar.class);
    target.image = Utils.findOptionalViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.nameFr = Utils.findOptionalViewAsType(source, R.id.name_fr, "field 'nameFr'", TextView.class);
    target.description = Utils.findOptionalViewAsType(source, R.id.description, "field 'description'", TextView.class);
    target.category = Utils.findOptionalViewAsType(source, R.id.category, "field 'category'", TextView.class);
    target.addressLine1 = Utils.findOptionalViewAsType(source, R.id.address_line1, "field 'addressLine1'", TextView.class);
    target.addressLine2 = Utils.findOptionalViewAsType(source, R.id.address_line2, "field 'addressLine2'", TextView.class);
    target.addressLine3 = Utils.findOptionalViewAsType(source, R.id.address_line3, "field 'addressLine3'", TextView.class);
    target.addressZip = Utils.findOptionalViewAsType(source, R.id.address_zip, "field 'addressZip'", TextView.class);
    target.addressCity = Utils.findOptionalViewAsType(source, R.id.address_city, "field 'addressCity'", TextView.class);
    target.phone = Utils.findOptionalViewAsType(source, R.id.phone, "field 'phone'", TextView.class);
    target.fax = Utils.findOptionalViewAsType(source, R.id.fax, "field 'fax'", TextView.class);
    target.email = Utils.findOptionalViewAsType(source, R.id.email, "field 'email'", TextView.class);
    target.website = Utils.findOptionalViewAsType(source, R.id.website, "field 'website'", TextView.class);
    target.facebook = Utils.findOptionalViewAsType(source, R.id.facebook, "field 'facebook'", TextView.class);
    target.twitter = Utils.findOptionalViewAsType(source, R.id.twitter, "field 'twitter'", TextView.class);
    target.station = Utils.findOptionalViewAsType(source, R.id.station, "field 'station'", TextView.class);
    target.option = Utils.findOptionalViewAsType(source, R.id.option, "field 'option'", TextView.class);
    target.payment = Utils.findOptionalViewAsType(source, R.id.payment, "field 'payment'", TextView.class);
    target.amenity = Utils.findOptionalViewAsType(source, R.id.amenity, "field 'amenity'", TextView.class);
    target.location = Utils.findOptionalViewAsType(source, R.id.location, "field 'location'", TextView.class);
    target.closure = Utils.findOptionalViewAsType(source, R.id.closure, "field 'closure'", TextView.class);
    target.label = Utils.findOptionalViewAsType(source, R.id.label, "field 'label'", TextView.class);
    target.service = Utils.findOptionalViewAsType(source, R.id.service, "field 'service'", TextView.class);
    target.opening = Utils.findOptionalViewAsType(source, R.id.opening, "field 'opening'", TextView.class);
    target.closing = Utils.findOptionalViewAsType(source, R.id.closing, "field 'closing'", TextView.class);
    target.openings = Utils.findOptionalViewAsType(source, R.id.openings, "field 'openings'", TextView.class);
    target.closings = Utils.findOptionalViewAsType(source, R.id.closings, "field 'closings'", TextView.class);
    target.animation = Utils.findOptionalViewAsType(source, R.id.animation, "field 'animation'", TextView.class);
    target.atmosphere = Utils.findOptionalViewAsType(source, R.id.atmosphere, "field 'atmosphere'", TextView.class);
    target.capacityTotal = Utils.findOptionalViewAsType(source, R.id.capacity_total, "field 'capacityTotal'", TextView.class);
    target.capacityInterieur = Utils.findOptionalViewAsType(source, R.id.capacity_interieur, "field 'capacityInterieur'", TextView.class);
    target.capacityExterieur = Utils.findOptionalViewAsType(source, R.id.capacity_exterieur, "field 'capacityExterieur'", TextView.class);
    target.capacityAssis = Utils.findOptionalViewAsType(source, R.id.capacity_assis, "field 'capacityAssis'", TextView.class);
    target.capacityDebout = Utils.findOptionalViewAsType(source, R.id.capacity_debout, "field 'capacityDebout'", TextView.class);
    target.capacityGroup = Utils.findOptionalViewAsType(source, R.id.capacity_group, "field 'capacityGroup'", TextView.class);
    target.capacitySalle = Utils.findOptionalViewAsType(source, R.id.capacity_salle, "field 'capacitySalle'", TextView.class);
    target.layoutAddress = Utils.findOptionalViewAsType(source, R.id.layout_address, "field 'layoutAddress'", LinearLayout.class);
    target.boutonsMapWaze = Utils.findOptionalViewAsType(source, R.id.boutons_map_waze, "field 'boutonsMapWaze'", LinearLayout.class);
    target.ouvert = Utils.findOptionalViewAsType(source, R.id.ouvert, "field 'ouvert'", LinearLayout.class);
    target.ferme = Utils.findOptionalViewAsType(source, R.id.ferme, "field 'ferme'", LinearLayout.class);
    target.layoutPayment = Utils.findOptionalViewAsType(source, R.id.layout_payment, "field 'layoutPayment'", LinearLayout.class);
    target.layoutLabel = Utils.findOptionalViewAsType(source, R.id.layout_label, "field 'layoutLabel'", LinearLayout.class);
    target.layoutAnimation = Utils.findOptionalViewAsType(source, R.id.layout_animation, "field 'layoutAnimation'", LinearLayout.class);
    target.layoutStation = Utils.findOptionalViewAsType(source, R.id.layout_station, "field 'layoutStation'", LinearLayout.class);
    target.layoutPratique = Utils.findOptionalViewAsType(source, R.id.layout_pratique, "field 'layoutPratique'", LinearLayout.class);
    target.layoutStanding = Utils.findOptionalViewAsType(source, R.id.layout_standing, "field 'layoutStanding'", LinearLayout.class);
    target.standing = Utils.findOptionalViewAsType(source, R.id.standing, "field 'standing'", TextView.class);
    target.layoutMeuble = Utils.findOptionalViewAsType(source, R.id.layout_meuble, "field 'layoutMeuble'", LinearLayout.class);
    target.meuble = Utils.findOptionalViewAsType(source, R.id.meuble, "field 'meuble'", TextView.class);
    target.layoutPeriode = Utils.findOptionalViewAsType(source, R.id.layout_periode, "field 'layoutPeriode'", LinearLayout.class);
    target.periode = Utils.findOptionalViewAsType(source, R.id.periode, "field 'periode'", TextView.class);
    target.couchage = Utils.findOptionalViewAsType(source, R.id.couchage, "field 'couchage'", TextView.class);
    target.roomCount = Utils.findOptionalViewAsType(source, R.id.room_count, "field 'roomCount'", TextView.class);
    target.roomBathCount = Utils.findOptionalViewAsType(source, R.id.room_bath_count, "field 'roomBathCount'", TextView.class);
    target.roomShowerCount = Utils.findOptionalViewAsType(source, R.id.room_shower_count, "field 'roomShowerCount'", TextView.class);
    target.suiteCount = Utils.findOptionalViewAsType(source, R.id.suite_count, "field 'suiteCount'", TextView.class);
    target.studioCount = Utils.findOptionalViewAsType(source, R.id.studio_count, "field 'studioCount'", TextView.class);
    target.apartmentCount = Utils.findOptionalViewAsType(source, R.id.apartment_count, "field 'apartmentCount'", TextView.class);
    target.roomAccessibleCount = Utils.findOptionalViewAsType(source, R.id.room_accessible_count, "field 'roomAccessibleCount'", TextView.class);
    target.singleCount = Utils.findOptionalViewAsType(source, R.id.single_count, "field 'singleCount'", TextView.class);
    target.doubleCount = Utils.findOptionalViewAsType(source, R.id.double_count, "field 'doubleCount'", TextView.class);
    target.tripleCount = Utils.findOptionalViewAsType(source, R.id.triple_count, "field 'tripleCount'", TextView.class);
    target.twinsCount = Utils.findOptionalViewAsType(source, R.id.twins_count, "field 'twinsCount'", TextView.class);
    target.familyCount = Utils.findOptionalViewAsType(source, R.id.family_count, "field 'familyCount'", TextView.class);
    target.area = Utils.findOptionalViewAsType(source, R.id.area, "field 'area'", TextView.class);
    target.type = Utils.findOptionalViewAsType(source, R.id.type, "field 'type'", TextView.class);
    target.floor = Utils.findOptionalViewAsType(source, R.id.floor, "field 'floor'", TextView.class);
    target.bedroomCount = Utils.findOptionalViewAsType(source, R.id.bedroom_count, "field 'bedroomCount'", TextView.class);
    target.sleepsCount = Utils.findOptionalViewAsType(source, R.id.sleeps_count, "field 'sleepsCount'", TextView.class);
    target.furnishedRoomCount = Utils.findOptionalViewAsType(source, R.id.furnished_room_count, "field 'furnishedRoomCount'", TextView.class);
    target.scrollView = Utils.findOptionalViewAsType(source, R.id.scrollView, "field 'scrollView'", ScrollView.class);
    target.fabExit = Utils.findOptionalViewAsType(source, R.id.fabExit, "field 'fabExit'", FloatingActionButton.class);
    view = source.findViewById(R.id.fabSave);
    target.fabSave = Utils.castView(view, R.id.fabSave, "field 'fabSave'", FloatingActionButton.class);
    if (view != null) {
      view7f080118 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabSaveClick();
        }
      });
    }
    target.scrollViewFiltre = Utils.findOptionalViewAsType(source, R.id.scrollView_filtre, "field 'scrollViewFiltre'", ScrollView.class);
    target.linearLayoutAmenities = Utils.findOptionalViewAsType(source, R.id.linearLayoutAmenities, "field 'linearLayoutAmenities'", LinearLayout.class);
    target.checkboxFiltreAmenities = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreAmenities, "field 'checkboxFiltreAmenities'", MaterialCheckBox.class);
    target.linearLayoutAnimations = Utils.findOptionalViewAsType(source, R.id.linearLayoutAnimations, "field 'linearLayoutAnimations'", LinearLayout.class);
    target.checkboxFiltreAnimations = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreAnimations, "field 'checkboxFiltreAnimations'", MaterialCheckBox.class);
    target.linearLayoutAtmosphere = Utils.findOptionalViewAsType(source, R.id.linearLayoutAtmosphere, "field 'linearLayoutAtmosphere'", LinearLayout.class);
    target.checkboxFiltreAtmosphere = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreAtmosphere, "field 'checkboxFiltreAtmosphere'", MaterialCheckBox.class);
    target.linearLayoutCategory = Utils.findOptionalViewAsType(source, R.id.linearLayoutCategory, "field 'linearLayoutCategory'", LinearLayout.class);
    target.checkboxFiltreCategory = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreCategory, "field 'checkboxFiltreCategory'", MaterialCheckBox.class);
    target.linearLayoutChains = Utils.findOptionalViewAsType(source, R.id.linearLayoutChains, "field 'linearLayoutChains'", LinearLayout.class);
    target.checkboxFiltreChains = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreChains, "field 'checkboxFiltreChains'", MaterialCheckBox.class);
    target.linearLayoutCity = Utils.findOptionalViewAsType(source, R.id.linearLayoutCity, "field 'linearLayoutCity'", LinearLayout.class);
    target.checkboxFiltreCity = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreCity, "field 'checkboxFiltreCity'", MaterialCheckBox.class);
    target.linearLayoutFamilyOptions = Utils.findOptionalViewAsType(source, R.id.linearLayoutFamilyOptions, "field 'linearLayoutFamilyOptions'", LinearLayout.class);
    target.checkboxFiltreFamilyOptions = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreFamilyOptions, "field 'checkboxFiltreFamilyOptions'", MaterialCheckBox.class);
    target.linearLayoutFurnishedRentals = Utils.findOptionalViewAsType(source, R.id.linearLayoutFurnishedRentals, "field 'linearLayoutFurnishedRentals'", LinearLayout.class);
    target.checkboxFiltreFurnishedRentals = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreFurnishedRentals, "field 'checkboxFiltreFurnishedRentals'", MaterialCheckBox.class);
    target.linearLayoutGroupOptions = Utils.findOptionalViewAsType(source, R.id.linearLayoutGroupOptions, "field 'linearLayoutGroupOptions'", LinearLayout.class);
    target.checkboxFiltreGroupOptions = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreGroupOptions, "field 'checkboxFiltreGroupOptions'", MaterialCheckBox.class);
    target.linearLayoutLabels = Utils.findOptionalViewAsType(source, R.id.linearLayoutLabels, "field 'linearLayoutLabels'", LinearLayout.class);
    target.checkboxFiltreLabels = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreLabels, "field 'checkboxFiltreLabels'", MaterialCheckBox.class);
    target.linearLayoutLocations = Utils.findOptionalViewAsType(source, R.id.linearLayoutLocations, "field 'linearLayoutLocations'", LinearLayout.class);
    target.checkboxFiltreLocations = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreLocations, "field 'checkboxFiltreLocations'", MaterialCheckBox.class);
    target.linearLayoutRentalMonthes = Utils.findOptionalViewAsType(source, R.id.linearLayoutRentalMonthes, "field 'linearLayoutRentalMonthes'", LinearLayout.class);
    target.checkboxFiltreRentalMonthes = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreRentalMonthes, "field 'checkboxFiltreRentalMonthes'", MaterialCheckBox.class);
    target.linearLayoutServices = Utils.findOptionalViewAsType(source, R.id.linearLayoutServices, "field 'linearLayoutServices'", LinearLayout.class);
    target.checkboxFiltreServices = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreServices, "field 'checkboxFiltreServices'", MaterialCheckBox.class);
    target.linearLayoutSleepings = Utils.findOptionalViewAsType(source, R.id.linearLayoutSleepings, "field 'linearLayoutSleepings'", LinearLayout.class);
    target.checkboxFiltreSleepings = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreSleepings, "field 'checkboxFiltreSleepings'", MaterialCheckBox.class);
    target.linearLayoutStandingLevels = Utils.findOptionalViewAsType(source, R.id.linearLayoutStandingLevels, "field 'linearLayoutStandingLevels'", LinearLayout.class);
    target.checkboxFiltreStandingLevels = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreStandingLevels, "field 'checkboxFiltreStandingLevels'", MaterialCheckBox.class);
    target.linearLayoutStations = Utils.findOptionalViewAsType(source, R.id.linearLayoutStations, "field 'linearLayoutStations'", LinearLayout.class);
    target.checkboxFiltreStations = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreStations, "field 'checkboxFiltreStations'", MaterialCheckBox.class);
    target.checkboxFiltreAmenitiesSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreAmenitiesSelectAll, "field 'checkboxFiltreAmenitiesSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreAnimationsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreAnimationsSelectAll, "field 'checkboxFiltreAnimationsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreAtmosphereSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreAtmosphereSelectAll, "field 'checkboxFiltreAtmosphereSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreCategorySelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreCategorySelectAll, "field 'checkboxFiltreCategorySelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreChainsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreChainsSelectAll, "field 'checkboxFiltreChainsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreCitySelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreCitySelectAll, "field 'checkboxFiltreCitySelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreFamilyOptionsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreFamilyOptionsSelectAll, "field 'checkboxFiltreFamilyOptionsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreFurnishedRentalsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreFurnishedRentalsSelectAll, "field 'checkboxFiltreFurnishedRentalsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreGroupOptionsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreGroupOptionsSelectAll, "field 'checkboxFiltreGroupOptionsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreLabelsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreLabelsSelectAll, "field 'checkboxFiltreLabelsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreLocationsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreLocationsSelectAll, "field 'checkboxFiltreLocationsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreRentalMonthesSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreRentalMonthesSelectAll, "field 'checkboxFiltreRentalMonthesSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreServicesSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreServicesSelectAll, "field 'checkboxFiltreServicesSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreSleepingsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreSleepingsSelectAll, "field 'checkboxFiltreSleepingsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreStandingLevelsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreStandingLevelsSelectAll, "field 'checkboxFiltreStandingLevelsSelectAll'", MaterialCheckBox.class);
    target.checkboxFiltreStationsSelectAll = Utils.findOptionalViewAsType(source, R.id.checkboxFiltreStationsSelectAll, "field 'checkboxFiltreStationsSelectAll'", MaterialCheckBox.class);
    view = source.findViewById(R.id.fabFiltre);
    target.fabFiltre = Utils.castView(view, R.id.fabFiltre, "field 'fabFiltre'", FloatingActionButton.class);
    if (view != null) {
      view7f080116 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabFiltreClick();
        }
      });
    }
    view = source.findViewById(R.id.fabRazFiltre);
    target.fabRazFiltre = Utils.castView(view, R.id.fabRazFiltre, "field 'fabRazFiltre'", FloatingActionButton.class);
    if (view != null) {
      view7f080117 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.fabRazFiltreClick();
        }
      });
    }
  }

  @Override
  @CallSuper
  public void unbind() {
    NavDrawerEntryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list_recycler_event = null;
    target.progressBar = null;
    target.image = null;
    target.nameFr = null;
    target.description = null;
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
    target.layoutStation = null;
    target.layoutPratique = null;
    target.layoutStanding = null;
    target.standing = null;
    target.layoutMeuble = null;
    target.meuble = null;
    target.layoutPeriode = null;
    target.periode = null;
    target.couchage = null;
    target.roomCount = null;
    target.roomBathCount = null;
    target.roomShowerCount = null;
    target.suiteCount = null;
    target.studioCount = null;
    target.apartmentCount = null;
    target.roomAccessibleCount = null;
    target.singleCount = null;
    target.doubleCount = null;
    target.tripleCount = null;
    target.twinsCount = null;
    target.familyCount = null;
    target.area = null;
    target.type = null;
    target.floor = null;
    target.bedroomCount = null;
    target.sleepsCount = null;
    target.furnishedRoomCount = null;
    target.scrollView = null;
    target.fabExit = null;
    target.fabSave = null;
    target.scrollViewFiltre = null;
    target.linearLayoutAmenities = null;
    target.checkboxFiltreAmenities = null;
    target.linearLayoutAnimations = null;
    target.checkboxFiltreAnimations = null;
    target.linearLayoutAtmosphere = null;
    target.checkboxFiltreAtmosphere = null;
    target.linearLayoutCategory = null;
    target.checkboxFiltreCategory = null;
    target.linearLayoutChains = null;
    target.checkboxFiltreChains = null;
    target.linearLayoutCity = null;
    target.checkboxFiltreCity = null;
    target.linearLayoutFamilyOptions = null;
    target.checkboxFiltreFamilyOptions = null;
    target.linearLayoutFurnishedRentals = null;
    target.checkboxFiltreFurnishedRentals = null;
    target.linearLayoutGroupOptions = null;
    target.checkboxFiltreGroupOptions = null;
    target.linearLayoutLabels = null;
    target.checkboxFiltreLabels = null;
    target.linearLayoutLocations = null;
    target.checkboxFiltreLocations = null;
    target.linearLayoutRentalMonthes = null;
    target.checkboxFiltreRentalMonthes = null;
    target.linearLayoutServices = null;
    target.checkboxFiltreServices = null;
    target.linearLayoutSleepings = null;
    target.checkboxFiltreSleepings = null;
    target.linearLayoutStandingLevels = null;
    target.checkboxFiltreStandingLevels = null;
    target.linearLayoutStations = null;
    target.checkboxFiltreStations = null;
    target.checkboxFiltreAmenitiesSelectAll = null;
    target.checkboxFiltreAnimationsSelectAll = null;
    target.checkboxFiltreAtmosphereSelectAll = null;
    target.checkboxFiltreCategorySelectAll = null;
    target.checkboxFiltreChainsSelectAll = null;
    target.checkboxFiltreCitySelectAll = null;
    target.checkboxFiltreFamilyOptionsSelectAll = null;
    target.checkboxFiltreFurnishedRentalsSelectAll = null;
    target.checkboxFiltreGroupOptionsSelectAll = null;
    target.checkboxFiltreLabelsSelectAll = null;
    target.checkboxFiltreLocationsSelectAll = null;
    target.checkboxFiltreRentalMonthesSelectAll = null;
    target.checkboxFiltreServicesSelectAll = null;
    target.checkboxFiltreSleepingsSelectAll = null;
    target.checkboxFiltreStandingLevelsSelectAll = null;
    target.checkboxFiltreStationsSelectAll = null;
    target.fabFiltre = null;
    target.fabRazFiltre = null;

    if (view7f080118 != null) {
      view7f080118.setOnClickListener(null);
      view7f080118 = null;
    }
    if (view7f080116 != null) {
      view7f080116.setOnClickListener(null);
      view7f080116 = null;
    }
    if (view7f080117 != null) {
      view7f080117.setOnClickListener(null);
      view7f080117 = null;
    }
  }
}
