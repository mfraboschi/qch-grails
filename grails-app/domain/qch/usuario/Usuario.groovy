package qch.usuario

import qch.receta.Receta
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

    String nickName
    String password

    Contextura contextura
    Dieta dieta
    Rutina rutina

    static hasMany = [recetas: Receta, grupos: Grupo]

    static mapping = {
        id generator:'assigned', name: 'nickName'
        grupos lazy: false
    }

    static belongsTo = Grupo

    @Override
    public boolean equals(Object object) {
        if(!object instanceof Usuario){
            return false
        }

        ((Usuario)object).nickName == this.nickName
    }


}
