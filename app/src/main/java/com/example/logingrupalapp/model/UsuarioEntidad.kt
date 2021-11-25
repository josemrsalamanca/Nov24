package com.example.logingrupalapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class UsuarioEntidad(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0,

    @ColumnInfo(name="correo_usuario")
    @NotNull var correo:String,

    @ColumnInfo(name="contrasenia_usuario")
    @NotNull var contraseña:String

)