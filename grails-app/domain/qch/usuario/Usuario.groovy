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

	public guardar(formNuevoUsuario)
	{
		this.nombre = formNuevoUsuario.nombre + " " + formNuevoUsuario.apellido
		this.nickName = formNuevoUsuario.nickName
		this.password = formNuevoUsuario.password
		this.fechaNacimiento =  formNuevoUsuario.fechaNacimiento
		this.alturaEnCentimetros = Integer.parseInt(formNuevoUsuario.alturaEnCentimetros)
		this.pesoEnGramos = Integer.parseInt(formNuevoUsuario.pesoEnGramos)
		this.sexo = formNuevoUsuario.sexo
		this.contextura = formNuevoUsuario.contextura
		this.dieta = formNuevoUsuario.dieta
		this.rutina = formNuevoUsuario.rutina
		this.save(flush:true)
	}
	
	public agregarA(Grupo grupo)
	{
		this.addToGrupos(grupo)
		this.save()
	}

	public removerA(Grupo grupo)
	{
        this.removeFromGrupos(grupo)
		this.save()
	}
}
