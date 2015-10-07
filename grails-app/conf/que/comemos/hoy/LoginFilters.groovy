package que.comemos.hoy

class LoginFilters {

    def filters = {

        all(controller:'*', action:'*') {
            before = {
                if(controllerName == "usuario") {
                    return
                }

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
