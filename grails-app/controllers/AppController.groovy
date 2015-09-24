//package ctl

import qch.Usuario

class AppController {
    def index() {
    }

    def guardarUsuario() {
        def userNuevo = new Usuario(params)
        userNuevo.save()
        redirect(view:"/index")
    }
}
