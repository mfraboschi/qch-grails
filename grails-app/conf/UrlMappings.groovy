class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/login"(view:"/usuario/login")
        "/crearUsuario"(view:"/usuario/crearUsuario")
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
