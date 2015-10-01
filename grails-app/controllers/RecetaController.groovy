import qch.receta.Receta
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 27/9/15.
 */
class RecetaController {

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

    /**
     * Crea y guarda una nueva receta
     * @return
     */
    def crear(){

        Receta nuevaReceta = new Receta()

        if(!params.nombre) {
            return render(view:"crearReceta", model: [error: "Debes completar el nombre"])
        }
        if(!params.caloriasTotal) {
            return render(view:"crearReceta", model: [error: "Debes completar las calorías"])
        }

        nuevaReceta.nombre = params.nombre
        nuevaReceta.caloriasTotal = params.caloriasTotal
        nuevaReceta.creador =  session.user

        nuevaReceta.save(flush:true)

        render(view:"crearReceta", model: [exito: "La receta ha sido creada!"])
    }
    
}
