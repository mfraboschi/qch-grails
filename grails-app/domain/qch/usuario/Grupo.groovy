package qch.usuario

import qch.receta.ingrediente.Ingrediente

class Grupo {
    String nombre
    Usuario creador
	String descripcion
	
    static hasMany = [usuarios: Usuario]
	
	def pertenece(Usuario usuario) 
	{
		 if( (this?.creador.nickName.equals(usuario.nickName)) || (this.usuarios.contains(usuario)) )
		 {
			 return true
		 }
		
		 return false
	}
}
