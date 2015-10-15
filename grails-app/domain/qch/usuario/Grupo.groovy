package qch.usuario

class Grupo {
    String nombre
    String creadorId
	String descripcion
	
    static hasMany = [usuarios: Usuario]

    static belongsTo = Usuario

    static mapping = { usuarios lazy: false }
	
	public boolean pertenece(Usuario usuario) {
		 (this.usuarios.asList().contains(usuario))
	}

    public borrar() {
        this.delete(flush: true)

        this.removeF
    }
}
