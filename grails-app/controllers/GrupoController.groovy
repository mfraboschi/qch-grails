import qch.usuario.Grupo
import qch.usuario.Usuario;

import java.text.DateFormat

class GrupoController {
    def index() {
        Usuario usuario = session.user
        List grupos = usuario.grupos.asList()

        def mensaje
        if(!grupos) mensaje = "No te has unido a ningún grupo"

        render(view:"misGrupos", model: [usuario: usuario, grupos: grupos, mensaje: mensaje])
    }

    def crearGrupo() {
        render(view:"crearGrupo", model: [usuario: session.user])
    }

  	def nuevoGrupo() {
    		Grupo grupoNuevo = new Grupo()
    		Usuario usuario = session.user

        Grupo.withTransaction {
            grupoNuevo.creadorId = usuario.nickName
            grupoNuevo.nombre = params.nombre
            grupoNuevo.descripcion = params.descripcion
            grupoNuevo.addToUsuarios(usuario)
            grupoNuevo.save()
        }

    		render(view:"crearGrupo", model: [usuario: usuario, exito: "El Grupo ${grupoNuevo.nombre} ha sido creado!"])
  	}

  	def verGrupos() {
    		List grupos = Grupo.findAll()
    		Usuario usuario = session.user

    		render(view:"verGrupos", model: [usuario: usuario, grupos: grupos])
  	}

  	def detalle() {
    		if (params.id) {
      		  Long id = params.id.toLong()
            Grupo grupoActual = Grupo.findById(id)
      		  Usuario usuario = session.user

      		  if ( grupoActual.creadorId.equals(usuario.nickName)) {
      			    return render(view:"detalleGrupo", model: [eliminar:"Eliminar Grupo", grupo: grupoActual])
    		    }

        		if( grupoActual.pertenece(usuario) ) {
        			  return render(view:"detalleGrupo", model: [abandonar:"Abandonar Grupo", grupo: grupoActual])
        		}

    		    return render(view:"detalleGrupo", model: [unirse:"Unirse al Grupo", grupo: grupoActual])
    		}
  	}

  	def unirseAGrupo() {
    		if (params.id) {
      			Long id = params.id.toLong()
      			Grupo grupoActual = Grupo.findById(id)
      			Usuario usuario = session.user

            Usuario.withTransaction {
                usuario.addToGrupos(grupoActual)
                usuario.save()
            }
      			return redirect(controller: "grupo", action: "detalle", id:"${grupoActual.id}")
    		}
  	}

  	def abandonarGrupo() {
    		if (params.id) {
      			Long id = params.id.toLong()
      			Usuario usuario = session.user

            Usuario.withTransaction {
                def grupo = usuario.grupos.asList().find { it.id == id }
                usuario.removeFromGrupos(grupo)
                usuario.save()
            }

            return redirect(controller: "grupo", action: "detalle", id:"${id}")
    		}
  	}

  	def eliminarGrupo() {
    		if (params.id) {
      			Long id = params.id.toLong()
      			Grupo grupoActual = Grupo.findById(id)
            Usuario usuario = session.user

            Usuario.withTransaction {
                def grupo = usuario.grupos.asList().find { it.id == id }
                usuario.removeFromGrupos(grupo)
            }

      			grupoActual.borrar()

      			return redirect(controller: "grupo", action: "verGrupos")
    		}
  	}
}
