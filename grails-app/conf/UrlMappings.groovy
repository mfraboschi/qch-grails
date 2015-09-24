class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

				"/app/crearUsuario"(view:"/crearUsuario")
        "/app/index"(view:"/index")
        "500"(view:'/error')
	}
}
