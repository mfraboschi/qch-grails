import qch.usuario.Grupo
import qch.usuario.Usuario;

import java.text.DateFormat

class GrupoController {
		def begin(Grupo grupoActual) {
			render "OK"
			//Averiguar como pasar parametros
		}

	def guardarGrupo() {
		def grupoNuevo = new Grupo()
		
		session.getAttribute("user")
		
		grupoNuevo.nombre = params.nombre
		
		userNuevo.save(flush:true)

		redirect(uri: "/")
	}


}
