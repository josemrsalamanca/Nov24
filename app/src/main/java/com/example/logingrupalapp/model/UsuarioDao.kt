package com.example.logingrupalapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsuarioDao {


    @Query("SELECT * FROM UsuarioEntidad")
    fun getAll(): LiveData<List<UsuarioEntidad>>

    @Query("SELECT * FROM UsuarioEntidad")
    fun getAllItems(): List<UsuarioEntidad>

    @Query("SELECT * FROM UsuarioEntidad where correo_usuario=:correo and contrasenia_usuario=:contraseña")
    fun obtenerUsuario(correo:String,contraseña:String):Array<UsuarioEntidad> // esto retorna un objeto, en esta caso un array, por ejemplo aca

    @Insert
    fun insertAll(vararg usuario: UsuarioEntidad)

    @Update
    fun updateAll(vararg usuario: UsuarioEntidad)

    @Delete
    fun deleteAll(value: List<UsuarioEntidad>)
}