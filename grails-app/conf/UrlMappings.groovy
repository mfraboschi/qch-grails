class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

				"/app/crearUsuario"(view:"/crearUsuario") //no se usarlo
        "/index"(view:"/index")
        "500"(view:'/error')
	}
}
