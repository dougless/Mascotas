package com.mascotas.view.framents;

import com.mascotas.adaptador.MascotaAdaptador;
import com.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DESARROLLO2 on 14/06/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
