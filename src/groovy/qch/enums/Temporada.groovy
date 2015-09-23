package qch.enums

enum Temporada {
    VERANO('verano'), OTONIO('otonio'), INVIERNO('invierno'), PRIMAVERA('primavera'), NAVIDAD('navidad'), PASCUAS('pascuas');

    private String texto

    Temporada(String texto) {
        this.texto = texto
    }

    public static Temporada fromString(String temporada) {
        if(temporada) {
            this.values().find { it.texto.equals(temporada) }
        }
    }
}
