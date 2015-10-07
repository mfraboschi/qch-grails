import qch.usuario.HistorialUsuario

/**
 * Created by mfraboschi on 6/10/15.
 */
class HistorialController {
    def historialRecetas() {
        def historial = HistorialUsuario.findAllByUsuario(session.user)
        def mensaje

        if(!historial) {
            mensaje = "Aún no has seleccionado ninguna receta"
        }

        render (view:"historial", model: [historial: historial, mensaje: mensaje])
    }
}
