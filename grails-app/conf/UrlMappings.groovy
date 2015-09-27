class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

				"/app/login"(view:"/login")
				"/app/crearUsuario"(view:"/crearUsuario")
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
