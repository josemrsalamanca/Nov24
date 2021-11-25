package com.example.logingrupalapp.util

import java.util.regex.Pattern

// se cambia el nombre de la clase para no generar confusion
object StringUtils {

    // eso se va a usar para traer las f(x) y que
    //puedan ser utilizadas por ambos fragment


    fun validarContraseña(contrasniaUsuario: String):Boolean {
        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
        val matcher = pattern.matcher(contrasniaUsuario)
        return matcher.find()
    }

    fun validarCorreo(correoUsario: String):Boolean {
        //Valida que el correo tenga el formato de correo

        val pattern = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+")

        val matcher = pattern.matcher(correoUsario)

        return matcher.find()
    }

}