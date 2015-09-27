import qch.usuario.Usuario
//package ctl

class AppController {
    List<Usuario> users = new ArrayList();

    def index() {
    }

    def guardarUsuario() {
        def userNuevo = new Usuario()
        userNuevo.nombre = params.nombre
        userNuevo.id = params.id
        userNuevo.password = params.password
        userNuevo.fechaNacimiento = params.fechaNacimiento
        userNuevo.alturaEnCentimetros = params.alturaEnCentimetros
        userNuevo.pesoEnGramos = params.pesoEnGramos
        userNuevo.sexo = params.sexo
        userNuevo.contextura = params.contextura
        userNuevo.dieta = params.dieta
        userNuevo.rutina = params.rutina
        //userNuevo.save()  *Para cuando este implementado la BD*
        users.add(userNuevo)
        redirect(uri: "/")
    }

    def autenticar() {
        def userID = params.id
        def pass = params.password
        if (!users.isEmpty()) {
            def prueba = null
            for (def tmp : users)
                if (tmp.id.equals(userID))
                    prueba = tmp;
            if (prueba != null)
                if (prueba.password.equals(pass))
                    redirect(controller: "usuario", action: "begin", params: [userActivo: prueba]) //no se si es asi
        }
        render "ERROR"
    }
}
