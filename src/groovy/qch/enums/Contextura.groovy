package qch.enums

/**
 * Created by mfraboschi on 22/9/15.
 */
enum Contextura {
    PEQUEÑA("pequeña"), MEDIA("media"), GRANDE("grande")

    private String texto

    Contextura(String texto) {
        this.texto = texto
    }

    public static Contextura fromString(String contextura) {
        if(contextura) {
            this.values().find { it.texto.equals(contextura) }
        }
    }

}
