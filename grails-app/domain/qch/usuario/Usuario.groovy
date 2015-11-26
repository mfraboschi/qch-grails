package qch.usuario

import qch.receta.Receta
import qch.enums.Contextura
import qch.enums.Dieta
import qch.enums.Rutina
import qch.enums.Sexo
import qch.enums.CondicionPreexistente
import qch.enums.Temporada;
import qch.receta.TemporadaReceta

class Usuario {

    String nombre
    Sexo sexo
    Date fechaNacimiento
    Integer alturaEnCentimetros
    Integer pesoEnGramos
	Integer cantVistas = 0
	
    String nickName
    String password

    Contextura contextura
    Dieta dieta
    Rutina rutina

    static hasMany = [condiciones: CondicionPreexistente, recetas: Receta, grupos: Grupo]

    static mapping = {
        id generator:'assigned', name: 'nickName'
        grupos lazy: false
        condiciones lazy: false
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

    if (formNuevoUsuario.boxCeliaco == "CELIAQUIA") this.addToCondiciones(CondicionPreexistente.CELIAQUIA)
    if (formNuevoUsuario.boxHipertenso == "HIPERTENSION") this.addToCondiciones(CondicionPreexistente.HIPERTENSION)
    if (formNuevoUsuario.boxDiabetes == "DIABETES") this.addToCondiciones(CondicionPreexistente.DIABETES)

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
	
	public Temporada mes(int month, int day)
	{
		Temporada temporada
		switch (month)
		{
			case Calendar.JANUARY:
				temporada = Temporada.VERANO
			case Calendar.FEBRUARY:
				temporada = Temporada.VERANO
			case Calendar.MARCH:
				if (day <= 21) temporada = Temporada.VERANO
				else temporada = Temporada.OTONIO
			case Calendar.APRIL:
				temporada = Temporada.OTONIO
			case Calendar.MAY:
				temporada = Temporada.OTONIO
			case Calendar.JUNE:
				if (day <= 21) temporada = Temporada.OTONIO
				else temporada = Temporada.INVIERNO
			case Calendar.JULY:
				temporada = Temporada.INVIERNO
			case Calendar.AUGUST:
				temporada = Temporada.INVIERNO
			case Calendar.SEPTEMBER:
				if (day <= 21) temporada = Temporada.INVIERNO
				else temporada = Temporada.PRIMAVERA
			case Calendar.OCTOBER:
				temporada = Temporada.PRIMAVERA
			case Calendar.NOVEMBER:
				temporada = Temporada.PRIMAVERA
			case Calendar.DECEMBER:
				if (day <= 21) temporada = Temporada.PRIMAVERA
				else temporada = Temporada.VERANO
			default: break
		}	
		return temporada;
	}
	def aumentarVisitas() {
		this.cantVistas++
		this.save(flush: true)
	}
}
