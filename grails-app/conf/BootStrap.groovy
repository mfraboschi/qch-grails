import qch.enums.CategoriaEnum
import qch.enums.CondicionPreexistente
import qch.enums.Dificultad
import qch.enums.PiramideAlimenticia
import qch.enums.Temporada
import qch.receta.Categoria
import qch.receta.Contraindicacion
import qch.receta.Receta
import qch.receta.TemporadaReceta
import qch.receta.ingrediente.Condimento
import qch.receta.ingrediente.CondimentoReceta
import qch.receta.ingrediente.Ingrediente
import qch.receta.ingrediente.IngredienteReceta

class BootStrap {

    def init = { servletContext ->
        //crearCondimentos()
        //crearRecetas()
    }
    def destroy = {
    }

    def crearRecetas() {

        Receta receta = new Receta(nombre: "Bondiola con salsa de panceta y porotos con batatas agridulces", dificultad: Dificultad.MEDIA, porciones: 6 )

        receta.addToProcedimientos("Bridar la bondiola entera para que no se deforme. Dorar de todos los lados en oliva junto con las cebolla, ajo y panceta en grandes trozos. Salpimentar. Desglasar con vino blanco.")
        receta.addToProcedimientos("Cuando evapora el alcohol, pasar toda la preparación a una fuente para horno junto con los porotos negros (hidratados en agua y hervidos por una hora y media).")
        receta.addToProcedimientos("Humectar con caldo de verdura, tapar con papel aluminio y llevar al horno medio por 2 horas.")
        receta.addToProcedimientos("Para las batatas, cortarlas en cubos (con piel), saltear en matneca y canela y cuando doran agregar agua hasta la mitad y miel. Salpimentar y reducir tapadas por unos 15 minutos a fuego bajo.")

        receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Sal")))
        receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Pimienta")))
        receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Canela en rama")))

        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Bondiola", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL), esIngredientePrincipal: true, cantidadGramos: 1000, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Cebolla", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL), esIngredientePrincipal: false, cantidadGramos: 200, calorias:123))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Panceta ahumada", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL), esIngredientePrincipal: false, cantidadGramos: 200, calorias:1231))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Poroto negro", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL), esIngredientePrincipal: false, cantidadGramos: 150, calorias:123))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Caldo de verdura", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL), esIngredientePrincipal: false, cantidadGramos: 1000, calorias:12))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Manteca", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL), esIngredientePrincipal: false, cantidadGramos: 100, calorias:1231))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Batata", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL), esIngredientePrincipal: false, cantidadGramos: 1000, calorias:1213))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Agua", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL), esIngredientePrincipal: false, cantidadGramos: null, calorias:13))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Miel", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL), esIngredientePrincipal: false, cantidadGramos: 30, calorias:1))

        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

        receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))

        receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
        receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))

        receta.save()

        println receta

    }

    def crearCondimentos() {
        new Condimento(nombre: "Sal").save()
        new Condimento(nombre: "Pimienta").save()
        new Condimento(nombre: "Romero").save()
        new Condimento(nombre: "Canela").save()
    }
}
