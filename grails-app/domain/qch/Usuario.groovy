package qch

class Usuario {

    String nombre
    String sexo
    Date fechaNacimiento
    String password
    Integer alturaEnCentimetros
    Integer pesoEnGramos

    //TODO: pasar a otra entidad
    String contextura
    String dieta
    String rutina


    static belongsTo = Grupo
    static hasMany = [recetas: Receta, grupos: Grupo]
}
