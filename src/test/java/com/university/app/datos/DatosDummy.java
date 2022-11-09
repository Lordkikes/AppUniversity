package com.university.app.datos;

import com.university.app.entity.Carrera;

public class DatosDummy {

    public static Carrera carrera01(){
        return new Carrera(null, "Ingenieria de Sistemas", 50, 5);
    }

    public static Carrera carrera02(){
        return new Carrera(null, "Ingenieria Electronica", 52, 6);
    }

    public static Carrera carrera03(){
        return new Carrera(null, "Ingenieria Industrial", 60, 4);
    }
}
