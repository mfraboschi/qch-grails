package qch.usuario

import qch.receta.ingrediente.Ingrediente

class Grupo {
    String nombre
    String creadorId
	String descripcion
	
    static hasMany = [usuarios: Usuario]

    static belongsTo = Usuario
	
	public boolean pertenece(Usuario usuario) {
		 this.creador.equals(usuario) || (this.usuarios.contains(usuario))
	}
}
