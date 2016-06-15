package com.mascotas.presentador;

import android.content.Context;

import com.mascotas.db.ConstructorMascotas;
import com.mascotas.pojo.Mascota;
import com.mascotas.view.framents.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by DESARROLLO2 on 14/06/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> favoritas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragment, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        favoritas = constructorMascotas.obtenerFavoritas();

        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
