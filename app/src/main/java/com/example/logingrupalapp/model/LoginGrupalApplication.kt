package com.example.logingrupalapp.model

import android.app.Application
import androidx.room.Room

class LoginGrupalApplication:Application() {

    //Paso 3
    companion object{
        lateinit var DATABASE : UsuarioBaseDeDatos
    }
    //Paso 1
    override fun onCreate() {
        super.onCreate()
        initDataBase()
    }
    //Paso 2, viene del paso 1
    //Paso 4, lo que esta dentro
    private fun initDataBase() {
        DATABASE = Room.databaseBuilder(this, UsuarioBaseDeDatos::class.java,"usuario_database").allowMainThreadQueries().build()
        // ACA ESTAMOS INICIALIZANDO LA BASE DE DATOS DENTRO DEL APPLICATION
        // AHORA HAY QUE IRSE AL MANIFEST, linea 11 del manifest
        // tambien hay que volar al firstfragmentactivity para seguir con los pasos (validarusuario)
    }
}