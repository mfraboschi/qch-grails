package qch

class Usuario {

    String nombre
    Character sexo
    Date fechaNacimiento
    String id
    String password
    Integer alturaEnCentimetros
    Integer pesoEnGramos
    String complexion      // Pequeña, Media y Grande.

    //TODO: pasar a otra entidad
    String contextura
    String dieta
    String rutina


    static belongsTo = Grupo //No siempre pertenece a un grupo
    static hasMany = [recetas: Receta, grupos: Grupo] //Le quite las preferencias para que compile por ahora
                                                      //Tiene muchas preferencias

}
