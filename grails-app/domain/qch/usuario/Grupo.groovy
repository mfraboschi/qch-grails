package qch.usuario

import qch.receta.ingrediente.Ingrediente

class Grupo {
    String nombre
    Usuario creador
	Ingrediente preferencias
	String descripcion
	
    static hasMany = [usuarios: Usuario]

    static belongsTo = Usuario
}
