import qch.estadistica.strategy.MasConsultadasEstadistica

/**
 * Created by mfraboschi on 5/11/15.
 */
class EstadisticasService {
    def obtenerEstrategiaEstadistica(tipoEstadistica) {
        def estrategiaEstadistica

        switch(tipoEstadistica) {
            case "consultas": estrategiaEstadistica = new MasConsultadasEstadistica()
                break
            case "sexo": break
            case "dificultad": break
        }

        return estrategiaEstadistica
    }
}
