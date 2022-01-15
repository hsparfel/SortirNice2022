package com.pouillcorp.sortirnice.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EvenementTriFragment extends Fragment {

    @BindView(R.id.radioEvenementTriGroup)
    RadioGroup radioEvenementTriGroup;
    @BindView(R.id.radio_button_evenement_tri_nom)
    MaterialRadioButton rbEvenementTriNom;
    @BindView(R.id.radio_button_evenement_tri_date)
    MaterialRadioButton rbEvenementTridDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evenement_tri, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.radio_button_evenement_tri_nom)
    public void rbEvenementTriNomClick() {
        Log.e("TAG", "click sur Tri Nom");
    }
    @OnClick(R.id.radio_button_evenement_tri_date)
    public void rbEvenementTriDateClick() {
        Log.e("TAG", "click sur Tri Date");
    }
}