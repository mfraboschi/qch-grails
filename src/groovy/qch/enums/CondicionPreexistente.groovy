package qch.enums

/**
 * Created by mfraboschi on 23/9/15.
 */
enum CondicionPreexistente {

    DIABETES('Diabetes'),
    HIPERTENSION('Hipertension'),
    CELIASIS('Celiasis')

    private String texto

    CondicionPreexistente(String texto) {
        texto = texto
    }

}