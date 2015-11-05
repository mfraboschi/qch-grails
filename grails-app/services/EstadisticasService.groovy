import qch.estadistica.strategy.MasConsultadasEstadistica
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
            case "dificultad": break
        }

        return estrategiaEstadistica
    }
}
