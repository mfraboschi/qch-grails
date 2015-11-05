import grails.converters.JSON
import qch.estadistica.strategy.EstrategiaEstadistica

class EstadisticasController {
    def estadisticasService

    def main() {
        def userActual = session.user
        render(view:"estadisticas", model: [usuario: userActual])
    }

    def obtener() {
        EstrategiaEstadistica estrategiaEstadistica = estadisticasService.obtenerEstrategiaEstadistica(params.tipo_estadistica)

        def results = estrategiaEstadistica.obtenerResultadoEstadistica()

        render(estrategiaEstadistica.obtenerHtml(results))
    }
}
