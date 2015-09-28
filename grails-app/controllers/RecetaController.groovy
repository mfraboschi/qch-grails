import qch.usuario.Usuario

/**
 * Created by mfraboschi on 27/9/15.
 */
class RecetaController {

    def index() {
        Usuario usuario = session.user
        render(view:"main", model: [usuario: usuario])
    }
}
