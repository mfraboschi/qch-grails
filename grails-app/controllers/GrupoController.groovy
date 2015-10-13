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
	
	def detalle(){
		if(params.id){	
		 Long id = params.id.toLong()
    	 Grupo grupoActual = Grupo.findById(id)
		 Usuario usuario = session.user
		 
		 if ( grupoActual.creador.equals(usuario) )
		 {
			 return render(view:"detalleGrupo", model: [eliminar:"Eliminar Grupo", grupo: grupoActual])
		 }
		 if(grupoActual.pertenece(usuario))	  {
			  return render(view:"detalleGrupo", model: [abandonar:"Abandonar Grupo", grupo: grupoActual])	
		  }

            return render(view:"detalleGrupo", model: [unirse:"Unirse al Grupo", grupo: grupoActual])
		}
	}
	
	def unirseAGrupo() {
		if(params.id){
			Long id = params.id.toLong()
			Grupo grupoActual = Grupo.findById(id)
			Usuario usuario = session.user

			grupoActual.addToUsuarios(usuario)
			grupoActual.save()
			
			usuario.addToGrupos(grupoActual)
			usuario.save()
			
			return redirect(controller: "grupo", action: "detalle", id:"${grupoActual.id}")
		}		
	}
	
	def eliminarGrupo() {
		if(params.id){
			Long id = params.id.toLong()
			Grupo grupoActual = Grupo.findById(id)
			
			grupoActual.delete()
						
			return redirect(controller: "grupo", action: "verGrupo")
		}
	}
}
