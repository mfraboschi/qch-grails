package qch.usuario

import qch.receta.ingrediente.Ingrediente

class Grupo {
    String nombre
    Usuario creador
	String descripcion
	
    static hasMany = [usuarios: Usuario]

    static belongsTo = Usuario
	
	public boolean pertenece(Usuario usuario) {
		 (this.usuarios.contains(usuario))
	}
}
