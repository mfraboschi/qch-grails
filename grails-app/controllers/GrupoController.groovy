import qch.usuario.Grupo
import qch.usuario.Usuario;

import java.text.DateFormat

class GrupoController {
		def begin(Grupo grupoActual) {
			render "OK"
			//Averiguar como pasar parametros
		}

	def crearGrupo() {
		Grupo grupoNuevo = new Grupo()
		
        Usuario usuario = session.user
		
		grupoNuevo.creador = usuario
		grupoNuevo.nombre = params.nombre
		grupoNuevo.descripcion = params.descripcion

		usuario.addToGrupos(grupoNuevo)
		usuario.save()
		
		grupoNuevo.save(flush:true)
		
		render(view:"crearGrupo", model: [exito: "El Grupo ${grupoNuevo.nombre} ha sido creado!"])
	}


}
