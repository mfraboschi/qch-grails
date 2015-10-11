import qch.usuario.Grupo
import qch.usuario.Usuario;

import java.text.DateFormat

class GrupoController {
    def index() {
        render(view:"crearGrupo")
    }

	def crearGrupo() {
		Grupo grupoNuevo = new Grupo()
		
        Usuario usuario = session.user

        Grupo.withTransaction() {
            grupoNuevo.creador = usuario
            grupoNuevo.nombre = params.nombre
            grupoNuevo.descripcion = params.descripcion
            grupoNuevo.save()

            usuario.addToGrupos(grupoNuevo)
            usuario.save()
        }
		
		render(view:"crearGrupo", model: [exito: "El Grupo ${grupoNuevo.nombre} ha sido creado!"])
	}
	
	def verGrupos() {
		List grupos = Grupo.findAll()
		Usuario usuario = session.user
		render(view:"verGrupos", model: [usuario: usuario, grupos: grupos])
	}
}
