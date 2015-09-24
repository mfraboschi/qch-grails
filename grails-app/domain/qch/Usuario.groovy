package qch

import qch.enums.Contextura
import qch.enums.Dieta
import qch.enums.Rutina
import qch.enums.Sexo

class Usuario {

    String nombre
    Sexo sexo
    Date fechaNacimiento
    Integer alturaEnCentimetros
    Integer pesoEnGramos

    String id
    String password

    Contextura contextura
    Dieta dieta
    Rutina rutina


    static belongsTo = Grupo
    static hasMany = [recetas: Receta, grupos: Grupo]
    static mapping = {
        contextura sqlType: 'enum'
        dieta sqlType: 'enum'
        rutina sqlType: 'enum'
        sexo sqlType: 'enum'
    }
}
