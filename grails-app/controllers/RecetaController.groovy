import qch.receta.Receta
import qch.strategy.EstrategiaBusqueda
import qch.usuario.HistorialUsuario
import qch.usuario.Usuario

class RecetaController {

    def recetaService

    /**
     * Listado total de recetas creadas
     * @return
     */
    def index() {
        List recetas = Receta.findAll()
        Usuario usuario = session.user
        render(view:"main", model: [usuario: usuario, recetas: recetas])
    }

    /**
     * Detalle de receta para cierto id
     * @return
     */
   	def detalle(){
   		if(params.id){
    		Long id = params.id.toLong()
    		Receta recetaActual = Receta.findById(id)
    		return render(view:"detalleReceta", model: [receta: recetaActual])
    	}
   	}

    def seleccionar() {
        if(params.id) {
            Long id = params.id.toLong()
            Receta recetaActual = Receta.findById(id)

            HistorialUsuario historial = new HistorialUsuario()
            historial.receta = recetaActual
            historial.usuario = session.user
            historial.fechaCreacion = new Date()

            historial.save()

            return render(view:"detalleReceta", model:[receta: recetaActual, exito:"Seleccionaste la receta!"])
        }
    }

    def todas() {
        Usuario usuario = session.user
        List recetas = Receta.findAllByCreador(usuario.nickName)

        def mensaje
        if(!recetas) mensaje = "No tienes ninguna receta asociada"
        render (view:"misRecetas", model:[usuario: usuario, recetas: recetas, mensaje: mensaje])
    }

    def nueva() {
        render (view:"crearReceta", model:[usuario: session.user])
    }

    /**
     * Crea y guarda una nueva receta
     * @return
     */
    def crear() {
        Receta nuevaReceta = new Receta()
        Usuario usuario = session.user

        if(!params.nombre) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes completar el nombre"])
        }
        if(!params.caloriasTotal) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes completar las calorías"])
        }
        if(!params.porciones) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes completar la cantidad de porciones"])
        }

        nuevaReceta.nombre = params.nombre
        nuevaReceta.caloriasTotal = params.caloriasTotal
        nuevaReceta.porciones = params.porciones
        nuevaReceta.dificultad = params.dificultad
        nuevaReceta.creador = usuario.nickName
        nuevaReceta.dieta = params.dieta
        nuevaReceta.addToProcedimientos(params.paso1)

        /* NO ME FUNCA AUN
        if (!params.paso2) { nuevaReceta.addToProcedimientos(params.paso2) }
        if (!params.paso3) { nuevaReceta.addToProcedimientos(params.paso3) }
        if (!params.paso4) { nuevaReceta.addToProcedimientos(params.paso4) }
        if (!params.paso5) { nuevaReceta.addToProcedimientos(params.paso5) }
        */
        
        nuevaReceta.save(flush:true)

        render(view:"crearReceta", model: [usuario: usuario, exito: "La receta ha sido creada!"])
    }

    def buscar() {

        def recetas = []


        EstrategiaBusqueda estrategiaDeBusqueda = recetaService.obtenerEstrategiaDeBusqueda(params.findAll { it.value != 'null'}.keySet())

        if (estrategiaDeBusqueda) {
            recetas = estrategiaDeBusqueda.obtenerResultados(params)
        }

        render(view:"buscarReceta", model: [recetas: recetas])
    }

}
