package qch.enums

/**
 * Created by mfraboschi on 22/9/15.
 */
enum CategoriaEnum {
    DESAYUNO('desayuno'),
    ALMUERZO('almuerzo'),
    MERIENDA('merienda'),
    CENA('cena')

    String texto

    CategoriaEnum(String texto) {
        this.texto = texto
    }

    static CategoriaEnum fromString(String categoria) {
        if(categoria) {
            this.values().find { it.texto.equals(categoria) }
        }
    }
}