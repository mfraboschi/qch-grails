import qch.usuario.HistorialUsuario
import qch.usuario.Usuario

import java.text.DateFormat

class UsuarioController {

    def guardarUsuario() {
        Usuario userNuevo = new Usuario()

        if(!params.nombre) {
            return render(view:"crearUsuario", model: [error: "Debes completar el nombre"])
        }
        if(!params.nickName) {
            return render(view:"crearUsuario", model: [error: "Debes completar el nickname"])
        }
        if(!params.password) {
            return render(view:"crearUsuario", model: [error: "Debes completar el password"])
        }
        if(!params.fechaNacimiento) {
            return render(view:"crearUsuario", model: [error: "Debes completar tu fecha de nacimiento"])
        }
        try{
            Integer.parseInt(params.alturaEnCentimetros)
        } catch(Exception e) {
            return render(view:"crearUsuario", model: [error: "Tu altura debe ser un numero (en centímetros)"])
        }
        try{
            Integer.parseInt(params.pesoEnGramos)
        } catch(Exception e) {
            return render(view:"crearUsuario", model: [error: "Tu peso debe ser un numero (en gramos)"])
        }

        userNuevo.nombre = params.nombre + " " + params.apellido
        userNuevo.nickName = params.nickName
        userNuevo.password = params.password
        userNuevo.fechaNacimiento =  params.fechaNacimiento
        userNuevo.alturaEnCentimetros = Integer.parseInt(params.alturaEnCentimetros)
        userNuevo.pesoEnGramos = Integer.parseInt(params.pesoEnGramos)
        userNuevo.sexo = params.sexo
        userNuevo.contextura = params.contextura
        userNuevo.dieta = params.dieta
        userNuevo.rutina = params.rutina
        userNuevo.save(flush:true)

        render(view:"crearUsuario", model: [exito: "El usuario ${userNuevo.nickName} ha sido creado!"])
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

    def index() {
        render(view: 'index')
    }

    def login() {
        render(view: 'login')
    }

    def crearUsuario() {
        render(view: 'crearUsuario')
    }
}
