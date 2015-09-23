package qch.enums

/**
 * Created by mfraboschi on 23/9/15.
 */
enum Dificultad {

    BAJA('Baja'),
    MEDIA('Media'),
    DIFICIL('Dificil'),
    MUY_DIFICIL('Muy dificil')

    Dificultad(String dificultad) {
        this.texto = dificultad
    }

    private String texto

}