package qch.usuario

import qch.receta.ingrediente.Ingrediente

class Grupo {
    String nombre
    Usuario creador
	String descripcion
	
    static hasMany = [usuarios: Usuario]
	
	public boolean pertenece(Usuario usuario) {
		 this.creador.equals(usuario) || (this.usuarios.contains(usuario))
	}
}
