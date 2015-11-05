import qch.estadistica.strategy.MasConsultadasEstadistica
import qch.estadistica.strategy.MasConsultadasPorDificultadEstadistica
import qch.estadistica.strategy.MasConsultadasPorSexoEstadistica

/**
 * Created by mfraboschi on 5/11/15.
 */
class EstadisticasService {
    def obtenerEstrategiaEstadistica(tipoEstadistica) {
        def estrategiaEstadistica

        switch(tipoEstadistica) {
            case "consultas": estrategiaEstadistica = new MasConsultadasEstadistica()
                break
            case "sexo": estrategiaEstadistica = new MasConsultadasPorSexoEstadistica()
                break
            case "dificultad": estrategiaEstadistica = new MasConsultadasPorDificultadEstadistica()
                break
        }

        return estrategiaEstadistica
    }
}
