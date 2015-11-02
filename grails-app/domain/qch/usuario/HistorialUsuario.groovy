package qch.usuario

import qch.enums.CategoriaEnum
import qch.receta.Categoria
import qch.receta.Receta

/**
 * Created by mfraboschi on 26/9/15.
 */
class HistorialUsuario {
    Usuario usuario
    Receta receta
    //CategoriaEnum categoria
    Date fechaCreacion

    static mapping = {
        receta lazy: false
    }

    static void guardarHistorialUsuario(receta, usuario) {
        HistorialUsuario historial = new HistorialUsuario()
        historial.receta = receta
        historial.usuario = usuario
        historial.fechaCreacion = new Date()

        historial.save(flush: true)
    }

}
