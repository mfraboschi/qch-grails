package qch.estadistica.strategy

/**
 * Created by mfraboschi on 5/11/15.
 */
interface EstrategiaEstadistica {
    def obtenerResultadoEstadistica(parametros);

    def obtenerHtml(results);
}
