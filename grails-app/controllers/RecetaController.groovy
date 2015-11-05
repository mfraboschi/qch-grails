import qch.receta.Calificacion
import qch.receta.Receta
import qch.receta.ingrediente.Ingrediente
import qch.receta.ingrediente.Condimento
import qch.receta.ingrediente.IngredienteReceta
import qch.receta.ingrediente.CondimentoReceta
import qch.strategy.EstrategiaBusqueda
import qch.usuario.HistorialUsuario
import qch.usuario.Usuario
import qch.enums.Temporada
import qch.enums.CategoriaEnum
import qch.enums.CondicionPreexistente

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
    		Receta recetaActual = Receta.buscarPorId(id)

            recetaActual.aumentarVisitas()

			def calificacion = Calificacion.findByRecetaAndUsuario(recetaActual, session.user)

    		return render(view:"detalleReceta", model: [usuario: session.user, receta: recetaActual, calificacion: calificacion])
    	}
   	}

    def seleccionar() {
        if(params.id) {
            Long id = params.id.toLong()

            Receta recetaActual = Receta.buscarPorId(id)

            HistorialUsuario.guardarHistorialUsuario(recetaActual, session.user)

            return render(view:"detalleReceta", model:[usuario: session.user, receta: recetaActual, exito:"Seleccionaste la receta!"])
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
        def ingredientes = Ingrediente.findAll()
        def condimentos = Condimento.findAll()
        render (view:"crearReceta", model:[usuario: session.user, ingredientes: ingredientes, condimentos: condimentos])
    }

    /**
     * Crea y guarda una nueva receta
     * @return
     */
    def crear() {
        Receta nuevaReceta = new Receta()
        Usuario usuario = session.user
        def ingredient = Ingrediente.findAll()
        def condiment = Condimento.findAll()

        if(!params.nombre) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes completar el nombre", ingredientes: ingredient, condimentos: condiment])
        }
        if(!params.caloriasTotal) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes completar las calorías", ingredientes: ingredient, condimentos: condiment])
        }
        if(!params.procedimientos) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes agregar al menos un procedimiento", ingredientes: ingredient, condimentos: condiment])
        }
        if(!params.ingredientes) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes agregar al menos un ingrediente", ingredientes: ingredient, condimentos: condiment])
        }
        if(!params.dieta) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes especificar la dieta", ingredientes: ingredient, condimentos: condiment])
        }
        if(!params.dificultad) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes especificar la dificultad", ingredientes: ingredient, condimentos: condiment])
        }

        def procedimientos = params.procedimientos instanceof String[] ? params.procedimientos : [params.procedimientos]

        def ingredientes = params.ingredientes instanceof String[] ? params.ingredientes : [params.ingredientes]
        def cantidades = params.cantidades instanceof String[] ? params.cantidades : [params.cantidades]
        def condimentos = params.condimentos instanceof String[] ? params.condimentos : [params.condimentos]
        def cantidades2 = params.cantidades2 instanceof String[] ? params.cantidades2 : [params.cantidades2]

		nuevaReceta.guardarReceta(params, usuario)

        procedimientos.each {
            nuevaReceta.addToProcedimientos(it)
        }

        [ingredientes, cantidades].transpose().each() {
            nuevaReceta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findById(it[0]), cantidadGramos: it[1], calorias: 1234, esIngredientePrincipal: false))
        }

        if (condimentos[0].size() > 0) {
            [condimentos, cantidades2].transpose().each() {
                nuevaReceta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findById(it[0]), cantidadEnMiligramos: it[1]))
            }
        }

        nuevaReceta.save(flush:true)

        render(view:"crearReceta", model: [usuario: usuario, exito: "La receta ha sido creada!", ingredientes: ingredient, condimentos: condiment])
    }

    def buscar() {

        def recetas = []


        EstrategiaBusqueda estrategiaDeBusqueda = recetaService.obtenerEstrategiaDeBusqueda(params.findAll { it.value }.keySet())

        if (estrategiaDeBusqueda) {
            recetas = estrategiaDeBusqueda.obtenerResultados(params)
        }

        render(view:"buscarReceta", model: [usuario: session.user, recetas: recetas, dificultad: params.dificultad, dieta: params.dieta, temporada: params.temporada, categoria: params.categoria, contraindicacion: params.contraindicacion])
    }

    def recomendadas()
	{
        Usuario userActual = session.user
        def recetas = []
        Temporada temporada
        CategoriaEnum categoria
        CondicionPreexistente condicion
		Receta receta
        Date dt = new Date();
        int month = dt.getMonth();
        int day = dt.getDay();
        int hours = dt.getHours();
/*
        switch (month)
		{
            case Calendar.JANUARY:
                temporada = Temporada.VERANO
            case Calendar.FEBRUARY:
                temporada = Temporada.VERANO
            case Calendar.MARCH:
                if (day <= 21) temporada = Temporada.VERANO
                else temporada = Temporada.OTONIO
            case Calendar.APRIL:
                temporada = Temporada.OTONIO
            case Calendar.MAY:
                temporada = Temporada.OTONIO
            case Calendar.JUNE:
                if (day <= 21) temporada = Temporada.OTONIO
                else temporada = Temporada.INVIERNO
            case Calendar.JULY:
                temporada = Temporada.INVIERNO
            case Calendar.AUGUST:
                temporada = Temporada.INVIERNO
            case Calendar.SEPTEMBER:
                if (day <= 21) temporada = Temporada.INVIERNO
                else temporada = Temporada.PRIMAVERA
            case Calendar.OCTOBER:
                temporada = Temporada.PRIMAVERA
            case Calendar.NOVEMBER:
                temporada = Temporada.PRIMAVERA
            case Calendar.DECEMBER:
                if (day <= 21) temporada = Temporada.PRIMAVERA
                else temporada = Temporada.VERANO
            default: break
        }
*/
		temporada = userActual.mes(month, day)

        switch (hours) {
            case 5..10:
                categoria = CategoriaEnum.DESAYUNO
            case 11..15:
                categoria = CategoriaEnum.ALMUERZO
            case 16..18:
                categoria = CategoriaEnum.MERIENDA
            case 19..23:
                categoria = CategoriaEnum.CENA
            case 0..4:
                categoria = CategoriaEnum.CENA
        }

        if (userActual.condiciones.size() == 0) {
            condicion = CondicionPreexistente.NINGUNA
        } else {
            condicion = userActual.condiciones.first()
        }

        Map pref = [
                contraindicacion: condicion.name(),
                temporada: temporada.name(),
                categoria: categoria.name(),
                dieta: userActual.dieta.name()
        ]

        EstrategiaBusqueda estrategiaDeBusqueda = recetaService.obtenerEstrategiaDeBusqueda(pref.keySet())

        if (estrategiaDeBusqueda) {
            recetas = estrategiaDeBusqueda.obtenerResultados(pref)
        }

        render(view:"recomendaciones", model: [usuario: userActual, recetas: recetas])
    }

    def calificar() {
        def calificacion = Calificacion.crearCalificacion(Receta.buscarPorId(params.id), session.user, Integer.valueOf(params.calificacion))

        calificacion.receta.actualizarCalificacionPromedio()

        render(status: 200)
    }

    def estadisticas() {
        def userActual = session.user
        render(view:"/estadisticas/estadisticas", model: [usuario: userActual])
    }

}
