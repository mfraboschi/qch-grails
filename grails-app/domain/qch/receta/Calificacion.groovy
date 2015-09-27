package qch.receta

import qch.usuario.Usuario

class Calificacion implements Serializable {
    static belongsTo = [receta: Receta, usuario: Usuario]

    static mapping = {
        id composite: ['receta', 'usuario']
    }

    Integer puntaje
}

