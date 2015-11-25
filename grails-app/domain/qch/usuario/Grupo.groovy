package qch.usuario

class Grupo {
    String nombre
    String creadorId
	String descripcion

    static hasMany = [usuarios: Usuario]

    static mapping = { usuarios lazy: false }

	public boolean pertenece(Usuario usuario) {
		 (this.usuarios.asList().contains(usuario))
	}

    public borrar() {
        this.delete(flush: true)
    }

	public crearGrupo(guardarGrupo, Usuario usuario)
	{
		this.creadorId = usuario.nickName
		this.nombre = guardarGrupo.nombre
		this.descripcion = guardarGrupo.descripcion
		this.addToUsuarios(usuario)
		this.save()
	}

	public agregarA(Usuario usuario)
	{
		this.addToUsuarios(usuario)
		this.save()
	}

	public removerA(Usuario usuario)
	{
		this.removeFromUsuarios(usuario)
		this.save()
	}

    public static obtenerUsuariosDeSusGrupos(Usuario usuario) {
        Set usuarios = new HashSet()
        usuario.grupos.each {
            Grupo grupo -> grupo.usuarios.each {
                usuarios.add(it.nickName)
            }
        }
        usuarios.add(usuario.nickName)
        return usuarios
    }
}
