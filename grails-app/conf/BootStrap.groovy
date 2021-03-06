import grails.util.Environment
import qch.enums.CategoriaEnum
import qch.enums.CondicionPreexistente
import qch.enums.Contextura
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.enums.PiramideAlimenticia
import qch.enums.Rutina
import qch.enums.Sexo
import qch.enums.Temporada
import qch.receta.Categoria
import qch.receta.Contraindicacion
import qch.receta.Receta
import qch.receta.TemporadaReceta
import qch.receta.ingrediente.Condimento
import qch.receta.ingrediente.CondimentoReceta
import qch.receta.ingrediente.Ingrediente
import qch.receta.ingrediente.IngredienteReceta
import qch.usuario.Usuario
import qch.usuario.Grupo

class BootStrap {

    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT) {
            crearRecetas()
			crearGrupo()
        }
    }
    def destroy = {
    }

    def crearRecetas() {

        Usuario.withTransaction 
		{
            Usuario user = new Usuario(rutina: Rutina.ACTIVA, pesoEnGramos: 8000, sexo: Sexo.MASCULINO, nombre: "QCH", alturaEnCentimetros: 180, contextura: Contextura.MEDIA, dieta: Dieta.DEPORTE, fechaNacimiento: new Date(), nickName: "qch", password: "qch").save()

            if(user.errors.errorCount) {
                for(error in user.errors.errors) {
                    println error
                }
            }
        }

        Receta.withTransaction {
            Receta receta = new Receta(nombre: "Bondiola con salsa de panceta y porotos con batatas agridulces", dificultad: Dificultad.MEDIA, porciones: 6, caloriasTotal: 123131, dieta: Dieta.NORMAL, urlImagen: "http://www.chacinadosscarano.com.ar/images/bondiola-de-cerdo.jpg")

            receta.addToProcedimientos("Bridar la bondiola entera para que no se deforme. Dorar de todos los lados en oliva junto con las cebolla, ajo y panceta en grandes trozos. Salpimentar. Desglasar con vino blanco.")
            receta.addToProcedimientos("Cuando evapora el alcohol, pasar toda la preparación a una fuente para horno junto con los porotos negros (hidratados en agua y hervidos por una hora y media).")
            receta.addToProcedimientos("Humectar con caldo de verdura, tapar con papel aluminio y llevar al horno medio por 2 horas.")
            receta.addToProcedimientos("Para las batatas, cortarlas en cubos (con piel), saltear en matneca y canela y cuando doran agregar agua hasta la mitad y miel. Salpimentar y reducir tapadas por unos 15 minutos a fuego bajo.")

            receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Sal").save(), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Pimienta").save(), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Canela en rama").save(), cantidadEnMiligramos: 200))

            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Bondiola", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Cebolla", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 123))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Panceta ahumada", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 1231))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Poroto negro", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 123))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Caldo de verdura", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias: 12))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Manteca", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 1231))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Batata", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias: 1213))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Agua", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 0, calorias: 13))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Miel", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 30, calorias: 1))

            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

            receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))
			
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))

            receta.save()
        }


        Receta.withTransaction {
            Receta receta = new Receta(nombre: "Supremas de pollo al horno con mojo y papas a la leche", dificultad: Dificultad.BAJA, porciones: 6, caloriasTotal: 123131, dieta: Dieta.NORMAL, urlImagen: "http://www.mis-recetas.org/receta/foto/0002/5076/grande/P1010094.jpg")

            receta.addToProcedimientos("Empezamos con el mojo. Picamos todos los ingredientes del mojo bien chiquito y ponemos en un pote con el vinagre el aceite y el jugo de limon")
            receta.addToProcedimientos("por otro lado condimentamos el pollo lo colocamos en una asadera previamente aceitada y le ponemos por arriba las aceitunas y la cebolla con el morron en tiritas. ..le vertimos el mojo y ponemos al horno previamente calentado.")
            receta.addToProcedimientos("Por otro lado en una asadera ponemos las papas laminadas cubriendo toda la asadera y las cubrimos con la leche ...encima le ponemos el queso rallado y la manteca en trocitos.")
            receta.addToProcedimientos("Mandamos al horno hasta que la papa este pronta y quedando dorada la preparaci�n de esa manera la preparaci�n queda rica y lista para acompa�ar nuestro pollo")

            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))

            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Suprema de pollo", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias: 7897))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Cebolla"), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Morron rojo", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 435))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Aceituna", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 200))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Morron adobo", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias: 12))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Vinagre", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 1231))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Acite", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias: 1213))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Limon", nivelPiramide: PiramideAlimenticia.PRIMER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 13))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Papa", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias: 400))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Queso", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 200))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Manteca"), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 1231))

            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

            receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.NINGUNA))
			
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))

            receta.save()
        }

        Receta.withTransaction {

            Receta receta = new Receta(nombre: "Pollo relleno con papas dauphine", dificultad: Dificultad.DIFICIL, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.DEPORTE, urlImagen: "http://www.cocinerosargentinos.com/images/1_pollo-a-la-mostaza-con-papas-a-la-provenzal.jpg")

            receta.addToProcedimientos("Deshuesar el pollo (con piel) manteniendo la forma para lograr una especie de bolsa para luego rellenar.")
            receta.addToProcedimientos("Para el relleno, en sartén con oliva, rehogar los champignones en cuartos, sin mover hasta que doren, dar vuelta y dorar del otro lado. Sumar la panceta en bastones, el jamón en tiritas, la cebolla y puerro picados y condimentar.")
            receta.addToProcedimientos("Integrar bien e incorporar los tomates secos picados, salsa barbacoa, desglasar con vino blanco y cuando evapora el alcohol pasar a un bol y dejar enfriar.")
            receta.addToProcedimientos("Rellenar el pollo. Cocer con hilo parrillero de todos lados. Salpimentar y cocer al horno en placa aceitada por unos 30 minutos.")
            receta.addToProcedimientos("Aparte, colocar el agua en una olla grande y llevar a fuego. Cuando hierve, sumar la harina y la manteca y revolver siempre hasta lograr una masa que se despegue de los bordes.")
            receta.addToProcedimientos("Freír bolitas (hacerlas con manos húmedos) en aceite bien caliente.")
            receta.addToProcedimientos("Para la salsa, llevar a fuego la crema con el jugo de limón, incorporar la ralladura, el azafrán y salpimentar. Terminar con vino blanco hasta que reduzca un poco y evapore el alcohol.")

            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Salsa barbacoa").save(), cantidadEnMiligramos: 100))

            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Aceite neutro", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 50, calorias: 1213))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Aceite de oliva", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 50, calorias: 1213))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Pollo", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Champignones", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Panceta ahumada"), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Jamon cocido", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Cebolla"), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Puerro", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Tomate seco", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Espinaca", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 12313))

            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

            receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))
			
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))

            receta.save()
        }

        Receta.withTransaction {

            Receta receta = new Receta(nombre: "Bifes de chorizo a la mostaza al disco con papas fritas", dificultad: Dificultad.DIFICIL, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.NORMAL, urlImagen: "http://i.ytimg.com/vi/CdDoXyOjFZ8/maxresdefault.jpg")

            receta.addToProcedimientos("En disco con oliva, sellar los bifes de ambos lados, y cuando doran agregar la cebolla y morrones fileteados.")
            receta.addToProcedimientos("Para elAl transparentar los vegetales, sumar el ajo picado. Desglasar con vino blanco. Cuando evapora el alcohol, sumar la mostaza y cocer por unos 15 minutos.")
            receta.addToProcedimientos("Antes de servir, agregar la crema e integrar.")
            receta.addToProcedimientos("Para la guarnición, cortar las papas en cu�a, con piel y fre�r.")

            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Salsa barbacoa"), cantidadEnMiligramos: 100))
            receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Mostaza").save(), cantidadEnMiligramos: 100))

            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Bife de chorizo", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias: 2000))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Aceite de oliva"), esIngredientePrincipal: false, cantidadGramos: 50, calorias: 1213))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Cebolla"), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 12313))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Morron rojo"), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 435))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Morron verde", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 485))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Ajo", nivelPiramide: PiramideAlimenticia.TERCER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 1800))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Vino blanco", nivelPiramide: PiramideAlimenticia.TERCER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 1000, calorias: 2000))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Papa"), esIngredientePrincipal: false, cantidadGramos: 500, calorias: 14319))


            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

            receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.HIPERTENSION))
			
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))

            receta.save()
        }


        Receta.withTransaction {

            Receta receta = new Receta(nombre: "Milanesas de ciervo napolitanas", dificultad: Dificultad.BAJA, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.DEPORTE, urlImagen: "http://www.just-eat.es/blog/wp-content/uploads/2011/04/milanesa-napolitana1.jpg")

            receta.addToProcedimientos("Cortar las milanesas del lomo. Salar.")
            receta.addToProcedimientos("Pasar los bifes por el batido de huevos con ajo y perejil picados, sal, or�gano, aj� molido y pimienta. Pasar por pan rallado y fre�r.")
            receta.addToProcedimientos("Gratinar al horno cubiertas con salsa, mozzarella y tomate.")

            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))
            receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))

            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Lomo de ciervo", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias: 3500))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Aceite neutro"), esIngredientePrincipal: false, cantidadGramos: 70, calorias: 1213))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Mozzarella", nivelPiramide: PiramideAlimenticia.CUARTO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 500, calorias: 900))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Tomate", nivelPiramide: PiramideAlimenticia.TERCER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 300, calorias: 1800))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Salsa de tomate", nivelPiramide: PiramideAlimenticia.TERCER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 700))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Huevo", nivelPiramide: PiramideAlimenticia.TERCER_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 400, calorias: 800))
            receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Pan rallado", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 50, calorias: 800))


            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
            receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

            receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.CELIAQUIA))
            
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))

            receta.save()
        }
		
		Receta.withTransaction
		{
			Receta receta = new Receta(nombre: "Tortilla al horno", dificultad: Dificultad.MEDIA, porciones: 2, caloriasTotal: 1231321, dieta: Dieta.VEGANO, urlImagen: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyO8UzrqiZp9LvAcyyJty3lTu2QMmtPBjYGXLuJyvSjNIH3lUw")

			receta.addToProcedimientos("Pelar y cortar en cubos a las papas . Rayar las zanahorias.")
			receta.addToProcedimientos("En un molde de horno, poner aceite en aerosol.")
			receta.addToProcedimientos("Mezclar las papas con la sal/pimienta y el aceite. Colocarlo en el molde. Llevar al horno (350 grados faringes) hasta que las papas esten cocidas (aprox. unos 20').")
			receta.addToProcedimientos("Batir los huevos, agregar las zanahorias rayadas. Esperar que esten las papas y agregarle esta preparacion. Cocinar nuevamente por unos 15' o hasta que el huevo este solidificado.")
			receta.addToProcedimientos("Dejar enfriar y desmoldar.")
			
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))

			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Papa"), esIngredientePrincipal: true, cantidadGramos: 400, calorias: 4231))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Huevo"), esIngredientePrincipal: false, cantidadGramos: 600, calorias: 7231))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Zanahoria", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 800))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Aceite de oliva"), esIngredientePrincipal: false, cantidadGramos: 50, calorias: 1213))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.CELIAQUIA))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))

			receta.save()
		}
		
		Receta.withTransaction
		{
			Receta receta = new Receta(nombre: "Pizza express sin horno y muy crocantita", dificultad: Dificultad.BAJA, porciones: 1, caloriasTotal: 931321, dieta: Dieta.VEGETARIANO, urlImagen: "http://servinox.com.mx/blog/wp-content/uploads/2015/03/4b7d08_25661c7cb90c4a2a95f28b05c7fe11fb.jpg")

			receta.addToProcedimientos("Hacemos una corona en el centro a�adimos el aceite y la levadura disuelta en el agua lejitos por algun costadito agregamos la sal ya que si la agregamos junto a la levadura esta moriria y no tendria efecto la misma.")
			receta.addToProcedimientos("Armamos la masa amasando muy bien hasta que este lisita y el�stica, tapamos con trapo h�medo o bolsa de polietileno hasta que duplique su volumen.")
			receta.addToProcedimientos("Una vez duplicado su volumen desgasificamos y cortamos 4 bollos iguales bollamos y dejamos descansar hasta que dupliquen otra vez. Una vez infladitos procedemos a estirar el bollo dentro del sarten previamente aceitado.")
			receta.addToProcedimientos("Una vez estirada la masa dentro de la sart�n disponemos salsa de tomate, mozzarella y lo que se nos ocurra como cualquier pizza tapamos y cocinamos en fuego corona unos 10 minutos o hasta que esta bien cocida.")
			receta.addToProcedimientos("Abajo decoramos con aceite con condimentos, perejil, queso rallado y aceitunas.")
			
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 10))
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))
			
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Harina", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 10, calorias: 800))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Agua"), esIngredientePrincipal: false, cantidadGramos: 250, calorias: 200))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Mozzarella"), esIngredientePrincipal: false, cantidadGramos: 1700, calorias: 17231))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Aceite de oliva"), esIngredientePrincipal: false, cantidadGramos: 15, calorias: 1213))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Levadura fresca de cerveza", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 10, calorias: 800))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Aceituna"), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 2573))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.CELIAQUIA))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
			
			receta.save()
		}
		

		Receta.withTransaction
		{
			Receta receta = new Receta(nombre: "Torreja al Horno", dificultad: Dificultad.MEDIA, porciones: 1, caloriasTotal: 931321, dieta: Dieta.VEGANO, urlImagen: "https://img-global.cpcdn.com/002_recipes/1223874af6216aff/640x640sq70/photo.jpg")

			receta.addToProcedimientos("Hacer una capa de salsa blanca, luego un colch�n de espinaca (cruda) y los dos huevos crudos.")
			receta.addToProcedimientos("Sobre los huevos poner otra capa de salsa blanca y otra de espinaca cruda. Despu�s los granos de choclo, queso y algo de or�gano.")
			receta.addToProcedimientos("Llevar al horno unos 15' o hasta q el queso se derrita.")
		
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 10))
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))
			
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Espinaca"), esIngredientePrincipal: false, cantidadGramos: 250, calorias: 200))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Huevo"), esIngredientePrincipal: false, cantidadGramos: 600, calorias: 7231))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Choclo", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 2900))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Salsa blanca", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 10, calorias: 800))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Queso"), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 2573))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.CELIAQUIA))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
			
			receta.save()
		}
		
		Receta.withTransaction
		{
			Receta receta = new Receta(nombre: "Lomos De Pescado al horno", dificultad: Dificultad.MEDIA, porciones: 1, caloriasTotal: 931321, dieta: Dieta.OVOLACTO, urlImagen: "http://www.cocinillas.es/wp-content/uploads/2011/04/merluza-al-horno.jpg")

			receta.addToProcedimientos("Hacer una capa de salsa blanca, luego un colch�n de espinaca (cruda) y los dos huevos crudos.")
			receta.addToProcedimientos("Sobre los huevos poner otra capa de salsa blanca y otra de espinaca cruda. Despu�s los granos de choclo, queso y algo de or�gano.")
			receta.addToProcedimientos("Llevar al horno unos 15' o hasta q el queso se derrita.")
		
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 10))
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))
			
            receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Cebolla"), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 12313))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Lomos de pescado", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 1000, calorias: 8900))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Anchoa", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 300, calorias: 800))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Salsa blanca"), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 2573))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Manteca"), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 1231))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Queso rallado", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 500, calorias: 5700))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.DIABETES))

			
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
			
			receta.save()
		}
		
		Receta.withTransaction {
			
			Receta receta = new Receta(nombre: "Capelettis de verduras asadas con estofado de asado", dificultad: Dificultad.MEDIA, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.DEPORTE, urlImagen: "http://i.ytimg.com/vi/VBFdCfUZ-cs/maxresdefault.jpg")

			receta.addToProcedimientos("Para el relleno, picar los vegetales previamente asados en oliva con sal y pimienta y saltear en oliva.")
			receta.addToProcedimientos("Mezclar en un bol junto con el queso y mozzarella rallados y el huevo.")
			receta.addToProcedimientos("Para los capelettis, estirar las masas de tarta y cortar formas de capelletti. Rellenar, cerrar y hervir en agua y sal.")

			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Pimienta"), cantidadEnMiligramos: 50))

			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Tapa de tarta", nivelPiramide: PiramideAlimenticia.QUINTO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Zanahoria"), esIngredientePrincipal: false, cantidadGramos: 500, calorias: 4213))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Aceite de oliva"), esIngredientePrincipal: false, cantidadGramos: 500, calorias: 4213))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Tomate"), esIngredientePrincipal: false, cantidadGramos: 500, calorias: 4213))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Cebolla"), esIngredientePrincipal: false, cantidadGramos: 200, calorias: 12313))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Papa"), esIngredientePrincipal: false, cantidadGramos: 500, calorias: 14319))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Morron rojo"), esIngredientePrincipal: false, cantidadGramos: 150, calorias: 435))
			

			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.NINGUNA))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))

			receta.save()
		}
		
		Receta.withTransaction {
			
			Receta receta = new Receta(nombre: "Alfajores de dulce de leche", dificultad: Dificultad.BAJA, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.NORMAL, urlImagen: "http://www.cocinerosargentinos.com/images/1_alfajores-de-dulce-de-leche-por-mauricio-asta.jpg")

			receta.addToProcedimientos("En bol, colocar manteca a punto pomada, agregar az�car impalpable, pizca de sal y batir. Sumar las yemas de huevo y continuar batiendo.")
			receta.addToProcedimientos("Aplicar en forma tamizada la harina junto con  almid�n de ma�z y la sal y mezclar a mano.")
			receta.addToProcedimientos("Formada la masa seguir amasando con la parte posterior de la palma. Colocar masa entre dos pliegos de papel manteca ,estirarla.")
			receta.addToProcedimientos("Reposar en la heladera durante 30 min. Posar masa ya estirada y fr�a sobre mesada y cortar las tapas para los alfajores con molde. Rellenar manga repostera")
			receta.addToProcedimientos("La tapa inferior de los alfajores con dulce de leche. Colocar la tapa superior y presionar suavemente. Espolvorear con az�car impalpable y hornear durante 12 min a 170�.")

            receta.addToCondimentos(new CondimentoReceta(condimento: new Condimento(nombre: "Azucar").save(), cantidadEnMiligramos: 1200))

			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Harina"), esIngredientePrincipal: true, cantidadGramos: 250, calorias: 200))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Manteca"), esIngredientePrincipal: false, cantidadGramos: 100, calorias: 1231))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Esencia de vainilla", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Almid�n de ma�z", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Dulce de leche", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.NINGUNA))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.MERIENDA))
			
			receta.save()
		}
		
		Receta.withTransaction {
			
			Receta receta = new Receta(nombre: "Alfajores enrollados", dificultad: Dificultad.MEDIA, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.NORMAL, urlImagen: "http://i.ytimg.com/vi/DSJs24DuzPc/maxresdefault.jpg")

			receta.addToProcedimientos("Para  el pionono, batir los huevos con la esencia de vainilla y el az�car por 10 minutos hasta cremar.")
			receta.addToProcedimientos("Agregar la harina con movimientos envolventes y disponer en placa de 30 cm por 40 cm (enmantecada y con papel manteca enmantecado) de manera pareja.")
			receta.addToProcedimientos("Cocer al horno fuerte (200 grados) por 10 minutos. Dejar entibiar y enrollar con el mismo papel manteca.")
			receta.addToProcedimientos("Cubrir el pionono con dulce de leche (o con membrillo derretido a ba�o Mar�a con un poquito de agua o con la crema o bien combinarlos) y enrollar desde la parte m�s ancha.")
			receta.addToProcedimientos("Envolver con el mismo papel manteca y llevar al freezer para que solidifique y no se desarme al cortar las rodajas (alfajores). Ba�ar con chocolate blanco y/o negro.")

			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Azucar"), cantidadEnMiligramos: 50))

			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Huevo"), esIngredientePrincipal: false, cantidadGramos: 600, calorias: 7231))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Harina"), esIngredientePrincipal: true, cantidadGramos: 250, calorias: 200))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Esencia de vainilla", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Nuez", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Dulce de membrillo", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Dulce de leche"), esIngredientePrincipal: false, cantidadGramos: 600, calorias: 7231))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.NINGUNA))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.MERIENDA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.DESAYUNO))
			
			receta.save()
		}
		
		Receta.withTransaction {
			
			Receta receta = new Receta(nombre: "Chocolatada caliente", dificultad: Dificultad.BAJA, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.NORMAL, urlImagen: "http://www.cocinerosargentinos.com/images/1_chocolatadacaliente.jpg")

			receta.addToProcedimientos("En una olla calentar 250 cc de leche y volcar el chocolate.")
			receta.addToProcedimientos("Revolver bien para que se derrita todo el chocolate.")
			receta.addToProcedimientos("Agregar el resto de la leche, la sal y la canela. Revover. Servir.")
			
			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Azucar"), cantidadEnMiligramos: 100))

			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Leche", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: true, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Caf� semiamargo", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 300, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Canela", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.DIABETES))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.MERIENDA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.DESAYUNO))
			
			receta.save()
		}
		
		Receta.withTransaction {
			
			Receta receta = new Receta(nombre: "Tiramis� con vainillas caseras", dificultad: Dificultad.DIFICIL, porciones: 4, caloriasTotal: 1231321, dieta: Dieta.NORMAL, urlImagen: "http://www.cocinerosargentinos.com/images/1_tiramisu-con-vainillas-caseras.jpg")

			receta.addToProcedimientos("En bol, colocar manteca a punto pomada, agregar az�car impalpable, pizca de sal y batir. Sumar las yemas de huevo y continuar batiendo.")
			receta.addToProcedimientos("Aplicar en forma tamizada la harina junto con  almid�n de ma�z y la sal y mezclar a mano.")
			receta.addToProcedimientos("Formada la masa seguir amasando con la parte posterior de la palma. Colocar masa entre dos pliegos de papel manteca ,estirarla.")
			receta.addToProcedimientos("Reposar en la heladera durante 30 min. Posar masa ya estirada y fr�a sobre mesada y cortar las tapas para los alfajores con molde. Rellenar manga repostera")
			receta.addToProcedimientos("La tapa inferior de los alfajores con dulce de leche. Colocar la tapa superior y presionar suavemente. Espolvorear con az�car impalpable y hornear durante 12 min a 170�.")

			receta.addToCondimentos(new CondimentoReceta(condimento: Condimento.findByNombre("Sal"), cantidadEnMiligramos: 50))

			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Harina"), esIngredientePrincipal: true, cantidadGramos: 250, calorias: 200))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Yema", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Esencia de vainilla", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: new Ingrediente(nombre: "Dulce de leche", nivelPiramide: PiramideAlimenticia.SEGUNDO_NIVEL).save(), esIngredientePrincipal: false, cantidadGramos: 2000, calorias: 3500))
			receta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findByNombre("Agua"), esIngredientePrincipal: false, cantidadGramos: 250, calorias: 200))
			
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
			receta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))

			receta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: CondicionPreexistente.DIABETES))

			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.MERIENDA))
			receta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
			
			receta.save()
		}
    }
    def crearCondimentos() {
		new Condimento(nombre: "Azucar").save()
        new Condimento(nombre: "Sal").save()
        new Condimento(nombre: "Pimienta").save()
        new Condimento(nombre: "Romero").save()
        new Condimento(nombre: "Canela").save()
    }
	def crearGrupo() 
	{		
		def grupo = new Grupo(creadorId: "qch", nombre: "Amantes de la pizza", descripcion: "Adoramos la pizza")
        grupo.addToUsuarios(Usuario.findByNickName("qch"))
        grupo.save()
        grupo = new Grupo(creadorId: "qch", nombre: "Los cuadraditos de maizena", descripcion: "Aguante el rock y los alfajores de maizena").save()
        grupo.addToUsuarios(Usuario.findByNickName("qch"))
        grupo.save()
        grupo = new Grupo(creadorId: "qch", nombre: "Alto guiso", descripcion: "Con 15 pesos nomas nos arreglamos").save()
        grupo.addToUsuarios(Usuario.findByNickName("qch"))
        grupo.save()
	}
}
