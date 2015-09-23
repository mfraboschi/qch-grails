package qch.enums

/**
 * Created by mfraboschi on 22/9/15.
 */
enum Rutina {
    LEVE('leve','Sedentaria con algo de ejercicio (-30 min.)'),
    NADA('nada','Sedentaria con nada de ejercicio.'),
    MEDIANO('mediano','Sedentaria con ejercicio (+30 min.)'),
    INTENSIVO('intensivo','Activa con ejercicio adicional (+30 min.)'),
    ACTIVA('activa','Activa sin ejercicio adicional (+30 min)')

    private String texto
    private String descripcion

    Rutina(String texto, descripcion) {
        this.texto = texto
        this.descripcion = descripcion
    }

    public static Rutina fromString(String rutina) {
        if(rutina) {
            this.values().find { it.texto.equals(rutina) }
        }
    }
}