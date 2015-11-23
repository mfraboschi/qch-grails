package qch.strategy

import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */
interface EstrategiaBusqueda {

    public obtenerResultados(Usuario usuario, Map parametros);

}