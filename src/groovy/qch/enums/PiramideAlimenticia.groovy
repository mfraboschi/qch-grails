package qch.enums

/**
 * Created by mfraboschi on 27/9/15.
 */
enum PiramideAlimenticia {

    PRIMER_NIVEL("De 6 a 11 porciones"),
    SEGUNDO_NIVEL("De 3 a 5 porciones"),
    TERCER_NIVEL("De 2 a 4 porciones"),
    CUARTO_NIVEL("De 2  3 porciones"),
    QUINTO_NIVEL("Poca cantidad")

    String descripcion

    PiramideAlimenticia(String descripcion) {
        this.descripcion = descripcion
    }
}