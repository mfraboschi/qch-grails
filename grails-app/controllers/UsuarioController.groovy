import qch.usuario.Usuario

import java.text.DateFormat

class UsuarioController {
    def begin(Usuario userActual) {
        render "OK"
        //Averiguar como pasar parametros
    }

    def guardarUsuario() {
        def userNuevo = new Usuario()
        userNuevo.nombre = params.nombre
        userNuevo.nickName = params.nickName
        userNuevo.password = params.password
        userNuevo.fechaNacimiento = Date.parse("dd/MM/yyyy", params.fechaNacimiento)
        userNuevo.alturaEnCentimetros = Integer.parseInt(params.alturaEnCentimetros)
        userNuevo.pesoEnGramos = Integer.parseInt(params.pesoEnGramos)
        userNuevo.sexo = params.sexo
        userNuevo.contextura = params.contextura
        userNuevo.dieta = params.dieta
        userNuevo.rutina = params.rutina
        userNuevo.save(flush:true)

        redirect(uri: "/")
    }

    def autenticar() {
        def nickname = params.nickname
        def password = params.password

        Usuario usuario = Usuario.findByNickName(nickname)
        if(usuario?.password.equals(password)) {
            session.setAttribute("user",usuario)
            return redirect(controller: "receta", action: "index") //no se si es asi
        }
        render (view:"login", model: [mensaje: "Nombre de usuario o contraseña inválidos"])
    }
}
