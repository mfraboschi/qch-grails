package qch.receta

import qch.usuario.Usuario

class Calificacion implements Serializable {
    static belongsTo = [receta: Receta, usuario: Usuario]

    static mapping = {
        id composite: ['receta', 'usuario']
    }

    Integer puntaje

    static def crearCalificacion(Receta receta, Usuario usuario, Integer puntaje) {
        def calificacion = new Calificacion()

        calificacion.receta = receta
        calificacion.usuario = usuario

        calificacion.puntaje = Integer.valueOf(puntaje)

        calificacion.save(flush: true)
    }
}

