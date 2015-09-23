package qch.enums

enum Sexo {
    MASCULINO('masculino'),
    FEMENINI('femenino')

    private String texto

    Sexo(String texto) {
        this.texto = texto
    }

    public static Sexo fromString(String sexo) {
        if(sexo) {
            this.values().find { it.texto.equals(sexo) }
        }
    }
}