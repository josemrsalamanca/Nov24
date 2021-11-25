package com.example.logingrupalapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
//parece que no xd
@Database(entities = [UsuarioEntidad::class], version = 1)

abstract class UsuarioBaseDeDatos : RoomDatabase(){
    abstract val registroDao : UsuarioDao

    companion object{
        const val DATABASE_NAME = "registros"
    }
}