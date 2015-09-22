package qch

class Usuario {

    String nombre
    Char sexo
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


    static belongsTo = Grupo
    static hasMany = [recetas: Receta, grupos: Grupo, String: Preferencias]
                                                      //Tiene muchas preferencias
    
}
