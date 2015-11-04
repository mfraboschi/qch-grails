import qch.receta.strategy.BusquedaPorDietaContraindicacionEIngredientePrincipal
import qch.receta.strategy.BusquedaPorDificultadEIngredientePrincipal
import qch.receta.strategy.BusquedaPorIngredientePrincipal
import qch.strategy.BusquedaPorContraindicacion
import qch.strategy.BusquedaPorContraindicacionEIngredientePrincipal
import qch.strategy.BusquedaPorDieta
import qch.strategy.BusquedaPorDietaEIngredientePrincipal
import qch.strategy.BusquedaPorDietaYContraindicacion
import qch.strategy.BusquedaPorDificultad
import qch.strategy.BusquedaPorDificultadDietaContraindicacionEIngredientePrincipal
import qch.strategy.BusquedaPorDificultadDietaYContraindicacion
import qch.strategy.BusquedaPorDificultadYContraindicacion
import qch.strategy.BusquedaPorDificultadYDieta
import qch.strategy.BusquedaPorContraindicacionTemporadaCategoriaYDieta
import qch.strategy.BusquedaPorTemporada
import qch.strategy.BusquedaPorCategoria
import qch.strategy.BusquedaPorTemporadaYCategoria
import qch.strategy.BusquedaPorCategoriaYContraindicacion
import qch.strategy.BusquedaPorCategoriaTemporadaYContraindicacion
import qch.strategy.BusquedaPorTemporadaYContraindicacion
import qch.strategy.EstrategiaBusqueda
/**
 * Created by mfraboschi on 27/9/15.
 */
class RecetaService {

    final static CRITERIOS_BUSQUEDA = ["dificultad", "dieta", "contraindicacion", "ingredientePpal", "temporada", "categoria"]

    final static Map busquedas = [  categoria: new BusquedaPorCategoria(),
									temporada: new BusquedaPorTemporada(),
									dificultad: new BusquedaPorDificultad(),
                                    dieta: new BusquedaPorDieta(),
                                    contraindicacion: new BusquedaPorContraindicacion(),
                                    ingredientePpal: new BusquedaPorIngredientePrincipal(),
                                    dificultad_dieta: new BusquedaPorDificultadYDieta(),
                                    dificultad_contraindicacion: new BusquedaPorDificultadYContraindicacion(),
                                    dificultad_ingredientePpal: new BusquedaPorDificultadEIngredientePrincipal(),
                                    dieta_contraindicacion: new BusquedaPorDietaYContraindicacion(),
                                    dieta_ingredientePpal: new BusquedaPorDietaEIngredientePrincipal(),
                                    contraindicacion_ingredientePpal: new BusquedaPorContraindicacionEIngredientePrincipal(),
                                    dificultad_dieta_contraindicacion: new BusquedaPorDificultadDietaYContraindicacion(),
									contraindicacion_categoria: new BusquedaPorCategoriaYContraindicacion(),
									temporada_categoria: new BusquedaPorTemporadaYCategoria(),
									temporada_contraindicacion: new BusquedaPorTemporadaYContraindicacion(),
                                    dieta_contraindicacion_ingredientePpal: new BusquedaPorDietaContraindicacionEIngredientePrincipal(),
                                    dificultad_dieta_contraindicacion_ingredientePpal: new BusquedaPorDificultadDietaContraindicacionEIngredientePrincipal(),
									contraindicacion_temporada_categoria: new BusquedaPorCategoriaTemporadaYContraindicacion(),
									dieta_contraindicacion_temporada_categoria: new BusquedaPorContraindicacionTemporadaCategoriaYDieta()]

    public crearReceta() {

    }

    public EstrategiaBusqueda obtenerEstrategiaDeBusqueda(parametros) {
        def key = ""
        CRITERIOS_BUSQUEDA.each {
            if(parametros.contains(it)) {
                key += "_${it}"
            }
        }
        key = key?key[1..-1]:""

        return busquedas[key]
    }
	
	/*public EstrategiaEstadistica obtenerEstrategiaDeEstadisticas(estadistica)
	{
		if(estadistica.equals("masVisto"))
		{
			return new EstadisticaPorMasConsultadas()
		}
		if(estadistica.equals("dificultad"))
		{
			return new EstadisticaPorDificultad()
		}
	}*/
}
