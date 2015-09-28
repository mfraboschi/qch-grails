package que.comemos.hoy

class LoginFilters {

    def filters = {
        all(controller:'receta', action:'*') {
            before = {
                if(!session.user) {
                    redirect(controller: "usuario", action: "autenticar")
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
