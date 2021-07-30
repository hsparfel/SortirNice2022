package com.pouillcorp.sortirnice.services;

import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesHebergementApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesHotelApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesRestaurantApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesShoppingApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesSortieApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesTransportApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesUtileApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesVisiteApiService;
import com.pouillcorp.sortirnice.modelentries.Entries;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiServices {

    private static ApiServices apiService = new ApiServices();

    public List<Entry> listEntries;

    public static ApiServices getInstance( )
    {
        return apiService;
    }

    /*public void connectAndGetApiDataEntries(String url, EntriesType entryType) {

        listEntries = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        switch (entryType) {
            case Boutique:
                EntriesBoutiqueApiService entriesBoutiqueApiService = retrofit.create(EntriesBoutiqueApiService.class);
                call = entriesBoutiqueApiService.getEntries();
                break;
            case Hebergement:
                EntriesHebergementApiService entriesHebergementApiService = retrofit.create(EntriesHebergementApiService.class);
                call = entriesHebergementApiService.getEntries();
                break;
            case Hotel:
                EntriesHotelApiService entriesHotelApiService = retrofit.create(EntriesHotelApiService.class);
                call = entriesHotelApiService.getEntries();
                break;
            case Restaurant:
                EntriesRestaurantApiService entriesRestaurantApiService = retrofit.create(EntriesRestaurantApiService.class);
                call = entriesRestaurantApiService.getEntries();
                break;
            case Shopping:
                EntriesShoppingApiService entriesShoppingApiService = retrofit.create(EntriesShoppingApiService.class);
                call = entriesShoppingApiService.getEntries();
                break;
            case Sortie:
                EntriesSortieApiService entriesSortieApiService = retrofit.create(EntriesSortieApiService.class);
                call = entriesSortieApiService.getEntries();
                break;
            case Transport:
                EntriesTransportApiService entriesTransportApiService = retrofit.create(EntriesTransportApiService.class);
                call = entriesTransportApiService.getEntries();
                break;
            case Utile:
                EntriesUtileApiService entriesUtileApiService = retrofit.create(EntriesUtileApiService.class);
                call = entriesUtileApiService.getEntries();
                break;
            case Visite:
                EntriesVisiteApiService entriesVisiteApiService = retrofit.create(EntriesVisiteApiService.class);
                call = entriesVisiteApiService.getEntries();
                break;
            default:
                call = null;
        }
        if (call != null) {
            /*try {
                Log.e(TAG, "type: " + entryType.toString());
                listEntries.addAll(call.execute().body().getListEntries());
                Log.e(TAG, "type: " + entryType.toString());
                Log.e(TAG, "Number of entries received: " + listEntries.size());
            } catch (Exception e){
                Log.e(TAG, "exception execute: " + e);
                if (entryType != EntriesType.Shopping) {
                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    Log.e("TAG", "date rch : " + dateDemandeString);
                    myUrl = BASE_URL + dateDemandeString + "/";
                } else {
                    if (compteur < 15) {
                        dateDemande = DateUtils.calculerVeille(dateDemande);
                        dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                        compteur++;
                    } else {
                        dateDemandeString = "20160726";
                    }
                    Log.e("TAG", "date rch : " + dateDemandeString);
                    myUrl = BASE_URL + dateDemandeString + "/";

                }
                connectAndGetApiData(myUrl, entryType);
            }*/
            /*call.enqueue(new Callback<Entries>() {
                             @Override
                             public void onResponse(Call<Entries> call, Response<Entries> response) {
                                 if (response.code() == 200) {
                                     cptrEntriesType ++;
                                     for (Entry current : response.body().getListEntries()) {
                                         current.setEntryType(entryType);
                                     }
                                     //listEntries.addAll(response.body().getListEntries());
                                     switch (entryType) {
                                         case Boutique:
                                             listEntriesBoutique.addAll(response.body().getListEntries());
                                             break;
                                         case Hebergement:
                                             listEntriesHebergement.addAll(response.body().getListEntries());
                                             break;
                                         case Hotel:
                                             listEntriesHotel.addAll(response.body().getListEntries());
                                             break;
                                         case Restaurant:
                                             listEntriesRestaurant.addAll(response.body().getListEntries());
                                             break;
                                         case Shopping:
                                             listEntriesShopping.addAll(response.body().getListEntries());
                                             break;
                                         case Sortie:
                                             listEntriesSortie.addAll(response.body().getListEntries());
                                             break;
                                         case Transport:
                                             listEntriesTransport.addAll(response.body().getListEntries());
                                             break;
                                         case Utile:
                                             listEntriesUtile.addAll(response.body().getListEntries());
                                             break;
                                         case Visite:
                                             listEntriesVisite.addAll(response.body().getListEntries());
                                             break;
                                         default:
                                     }

                                     //si recherche sur un seul type d'entry penser à maj le compteur à 8
                                     if (cptrEntriesType == 9) {
                                         if (listEntriesBoutique != null && listEntriesBoutique.size()>0) {
                                             listEntries.addAll(listEntriesBoutique);
                                         }
                                         if (listEntriesHotel != null && listEntriesHotel.size()>0) {
                                             listEntries.addAll(listEntriesHotel);
                                         }
                                         if (listEntriesHebergement != null && listEntriesHebergement.size()>0) {
                                             listEntries.addAll(listEntriesHebergement);
                                         }
                                         if (listEntriesShopping != null && listEntriesShopping.size()>0) {
                                             listEntries.addAll(listEntriesShopping);
                                         }
                                         if (listEntriesVisite != null && listEntriesVisite.size()>0) {
                                             listEntries.addAll(listEntriesVisite);
                                         }
                                         if (listEntriesTransport != null && listEntriesTransport.size()>0) {
                                             listEntries.addAll(listEntriesTransport);
                                         }
                                         if (listEntriesUtile != null && listEntriesUtile.size()>0) {
                                             listEntries.addAll(listEntriesUtile);
                                         }
                                         if (listEntriesSortie != null && listEntriesSortie.size()>0) {
                                             listEntries.addAll(listEntriesSortie);
                                         }
                                         if (listEntriesRestaurant != null && listEntriesRestaurant.size()>0) {
                                             listEntries.addAll(listEntriesRestaurant);
                                         }

                                         configureRecyclerView();
                                     }
                                     //configureRecyclerView();
                                     //isResponded = true;
                                     Log.e(TAG, "type: " + entryType.toString());
                                     Log.e(TAG, "Number of entries received: " + listEntries.size());
                                     progressBar.setVisibility(View.GONE);
                                 } else {
                                     if (entryType != EntriesType.Shopping) {
                                         dateDemande = DateUtils.calculerVeille(dateDemande);
                                         dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                         Log.e("TAG", "date rch : " + dateDemandeString);
                                         myUrl = BASE_URL + dateDemandeString + "/";
                                     } else {
                                         if (compteur < 15) {
                                             dateDemande = DateUtils.calculerVeille(dateDemande);
                                             dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                             compteur++;
                                         } else {
                                             dateDemandeString = "20160726";
                                         }
                                         Log.e("TAG", "date rch : " + dateDemandeString);
                                         myUrl = BASE_URL + dateDemandeString + "/";

                                     }
                                     connectAndGetApiData(myUrl, entryType);
                                     //connectAndGetApiData(myUrl, entryType,true);

                                 }
                             }


                             @Override
                             public void onFailure(Call<Entries> call, Throwable throwable) {
                                 Log.e(TAG, throwable.toString());
                                 progressBar.setVisibility(View.GONE);
                                 Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                                 envoyerEmailErreur(entryType);
                             }
                         }
            );
        } else {
            Log.e(TAG, "call null (hors des 9 entriesType");
        }
    }*/



}
