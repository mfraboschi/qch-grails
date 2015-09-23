package qch.enums

enum Dieta {
    VEGETARIANO('vegetariano'),
    VEGANO('vegano'),
    OVOLACTO('ovolacto'),
    DIET('diet'),
    DEPORTE('deporte'),
    NORMAL('normal');

    private String texto

    Dieta(String texto) {
        this.texto = texto
    }

    public static Dieta fromString(String dieta) {
        if(dieta) {
            this.values().find { it.texto.equals(dieta) }
        }
    }
}
