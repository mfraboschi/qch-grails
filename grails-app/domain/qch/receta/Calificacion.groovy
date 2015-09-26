package qch.receta

import qch.usuario.Usuario

class Calificacion {
    static belongsTo = [receta: Receta, usuario: Usuario]

    static mapping = {
        id composite: ['receta', 'usuario']
    }

    Integer puntaje
}
