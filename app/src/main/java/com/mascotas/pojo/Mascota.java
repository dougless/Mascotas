package com.mascotas.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DESARROLLO2 on 30/05/2016.
 */
public class Mascota implements Parcelable {
    private int id;
    private String nombre;
    private int likes;
    private int foto;


    public Mascota(){

    }

    public Mascota(int id,String nombre,int likes,int foto,int votos){
        this.id = id;
        this.nombre = nombre;
        this.likes = likes;
        this.foto = foto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    private Mascota(Parcel in) {
            id = in.readInt();
            nombre = in.readString();
            likes = in.readInt();
            foto = in.readInt();
        }

        @Override
        public int describeContents() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(nombre);
            dest.writeInt(likes);
            dest.writeInt(foto);

        }

        public static final Parcelable.Creator<Mascota> CREATOR = new Parcelable.Creator<Mascota>() {
            public Mascota createFromParcel(Parcel in) {
                return new Mascota(in);
            }

            public Mascota[] newArray(int size) {
                return new Mascota[size];

            }
        };

}
