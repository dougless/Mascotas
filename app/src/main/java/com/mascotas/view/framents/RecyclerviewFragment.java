package com.mascotas.view.framents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mascotas.Main2Activity;
import com.mascotas.R;
import com.mascotas.adaptador.MascotaAdaptador;
import com.mascotas.pojo.Mascota;
import com.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by DESARROLLO2 on 7/06/2016.
 */
public class RecyclerviewFragment extends Fragment implements IRecyclerViewFragmentView{

    Button boton;
    RecyclerView listaMascotas;
    RecyclerViewFragmentPresenter presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        //return super.onCreateView(layoutInflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        Toolbar actionBar = (Toolbar) getActivity().findViewById(R.id.actionBar);

        boton = (Button) actionBar.findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2 = new Intent(getActivity(), Main2Activity.class);
                startActivity(activity2);
            }
        });

        listaMascotas = (RecyclerView) v.findViewById(R.id.rv1);

        presentador = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
    }

    private ArrayList<Mascota> favoritas;

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,favoritas,getActivity());

        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
       listaMascotas.setAdapter(mascotaAdaptador);
    }
}
