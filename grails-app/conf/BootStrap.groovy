import grails.util.Environment
import qch.enums.CategoriaEnum
import qch.enums.CondicionPreexistente
import qch.enums.Dieta
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
        if(Environment.current == Environment.DEVELOPMENT) {
            crearCondimentos()
        }
    }
    def destroy = {
    }

    def crearRecetas() {

        Receta receta = new Receta(nombre: "Bondiola con salsa de panceta y porotos con batatas agridulces", dificultad: Dificultad.MEDIA, porciones: 6, caloriasTotal: 123131, dieta: Dieta.NORMAL )

        receta.addToProcedimientos("Bridar la bondiola entera para que no se deforme. Dorar de todos los lados en oliva junto con las cebolla, ajo y panceta en grandes trozos. Salpimentar. Desglasar con vino blanco.")
        receta.addToProcedimientos("Cuando evapora el alcohol, pasar toda la preparaci√≥n a una fuente para horno junto con los porotos negros (hidratados en agua y hervidos por una hora y media).")
        receta.addToProcedimientos("Humectar con caldo de verdura, tapar con papel aluminio y llevar al horno medio por 2 horas.")
        receta.addToProcedimientos("Para las batatas, cortarlas en cubos (con piel), saltear en matneca y canela y cuando doran agregar agua hasta la mitad y miel. Salpimentar y reducir tapadas por unos 15 minutos a fuego bajo.")

        receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Sal").save(), cantidadEnMiligramos: 50))
        receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Pimienta").save(), cantidadEnMiligramos: 50))
        receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Canela en rama").save(), cantidadEnMiligramos: 200))

        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Bondiola", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Cebolla", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias:123))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Panceta ahumada", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias:1231))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Poroto negro", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:123))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Caldo de verdura", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias:12))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Manteca", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 100, calorias:1231))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Batata", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias:1213))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Agua", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 0, calorias:13))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Miel", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 30, calorias:1))

        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

        receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))

        receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
        receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))

        receta.save()
		
		
		
		Receta receta1 = new Receta(nombre: "Supremas de pollo al horno con mojo y papas a la leche", dificultad: Dificultad.FACIL, porciones: 6, caloriasTotal: 123131, dieta: Dieta.NORMAL )
		
		receta.addToProcedimientos("Empezamos con el mojo. Picamos todos los ingredientes del mojo bien chiquito y ponemos en un pote con el vinagre el aceite y el jugo de limon...QuÈ repose y asiente ....por otro lado condimentamos el pollo lo colocamos en una asadera previamente aceitada y le ponemos por arriba las aceitunas y la cebolla con el morrÛn en tiritas. ..le vertimos el mojo y ponemos al horno previamente calentado.")
		receta.addToProcedimientos("Por otro lado en una asadera ponemos las papas laminadas cubriendo toda la asadera y las cubrimos con la leche ...encima le ponemos el queso rallado y la manteca en trocitos. ...mandamos al horno hasta que la papa este pronta y quedando dorada la preparaciÛn de esa manera la preparaciÛn queda rica y lista para acompaÒar nuestro pollo")
		
		receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Sal").save(), cantidadEnMiligramos: 50))
		receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Pimienta").save(), cantidadEnMiligramos: 50))
		receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Canela en rama").save(), cantidadEnMiligramos: 200))

		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Suprema de pollo", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias:7897))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Cebolla", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias:123))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Morron rojo", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:435))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Aceituna", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:200))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Morron adobo", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias:12))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Vinagre", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 100, calorias:1231))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Acite", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias:1213))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Limon", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias:13))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Papa", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias:400))
		receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Queso", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias:200))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Manteca", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 100, calorias:1231))
		
		receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
		receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
		receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

		receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))
		receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))
		
		receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
		receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))

		receta.save()

        receta = new Receta(nombre: "Pollo relleno con papas dauphine", dificultad: Dificultad.DIFICIL, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.NORMAL)

        receta.addToProcedimientos("Deshuesar el pollo (con piel) manteniendo la forma para lograr una especie de bolsa para luego rellenar.")
        receta.addToProcedimientos("Para el relleno, en sart√©n con oliva, rehogar los champignones en cuartos, sin mover hasta que doren, dar vuelta y dorar del otro lado. Sumar la panceta en bastones, el jam√≥n en tiritas, la cebolla y puerro picados y condimentar.")
        receta.addToProcedimientos("Integrar bien e incorporar los tomates secos picados, salsa barbacoa, desglasar con vino blanco y cuando evapora el alcohol pasar a un bol y dejar enfriar.")
        receta.addToProcedimientos("Rellenar el pollo. Cocer con hilo parrillero de todos lados. Salpimentar y cocer al horno en placa aceitada por unos 30 minutos.")
        receta.addToProcedimientos("Aparte, colocar el agua en una olla grande y llevar a fuego. Cuando hierve, sumar la harina y la manteca y revolver siempre hasta lograr una masa que se despegue de los bordes. Retirar del fuego y sumar el huevo, volver a integrar (va a costar integrarlo).")
        receta.addToProcedimientos("Fre√≠r bolitas (hacerlas con manos h√∫medos) en aceite bien caliente.")
        receta.addToProcedimientos("Para la salsa, llevar a fuego la crema con el jugo de lim√≥n, incorporar la ralladura, el azafr√°n y salpimentar. Terminar con vino blanco hasta que reduzca un poco y evapore el alcohol.")

        receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))
        receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))
        receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Salsa barbacoa").save(), cantidadEnMiligramos: 100))

        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Aceite neutro", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 50, calorias:1213))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Aceite de oliva", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 50, calorias:1213))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Pollo", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Champignones", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Panceta ahumada"), esIngredientePrincipal: false, cantidadGramos: 100, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Jamon cocido", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Cebolla"), esIngredientePrincipal: false, cantidadGramos: 200, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Puerro", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Tomate seco", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:12313))
        receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Espinaca", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias:12313))

        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
        receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

        receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))

        receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
        receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))

        receta.save()
    }

    def crearCondimentos() {
        new Condimento(nombre: "Sal").save()
        new Condimento(nombre: "Pimienta").save()
        new Condimento(nombre: "Romero").save()
        new Condimento(nombre: "Canela").save()
    }
}
