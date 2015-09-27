import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import qch.enums.CategoriaEnum
import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.PiramideAlimenticia
import qch.receta.Categoria
import qch.receta.Contraindicacion
import qch.receta.TemporadaReceta
import qch.receta.ingrediente.Condimento
import qch.receta.ingrediente.CondimentoReceta
import qch.receta.ingrediente.Ingrediente
import qch.receta.ingrediente.IngredienteReceta
import qch.receta.Receta
import qch.enums.Dificultad
import qch.enums.Temporada

/**
 * Created by mfraboschi on 23/9/15.
 */

@TestFor(Receta)
@Mock([Receta, IngredienteReceta, Ingrediente, Categoria,  ])
class RecetaTests {

    void "test la creacion de una Receta sin errores"() {
        Receta receta = new Receta(
                caloriasTotal: 300,
                cantVisitas: 10,
                dificultad: Dificultad.BAJA,
                nombre:"Arroz con pollo",
                procedimientos: ["Encender hornalla","Condimentar el Pollo","Hacer el Arroz"],
                dieta: Dieta.NORMAL,
                porciones: 5)

        receta.save()

        assertTrue receta.errors.errorCount == 0
    }

    void "test conversión de string a enum"() {
        Receta receta = new Receta(
                caloriasTotal: 300,
                cantVisitas: 10,
                dificultad: Dificultad.BAJA,
                nombre:"Arroz con pollo",
                condimentos: [ new CondimentoReceta(condimento: new Condimento(nombre: "Sal"), cantidadEnMiligramos: 30)],
                procedimientos: ["Encender hornalla","Condimentar el Pollo","Hacer el Arroz"],
                dieta: Dieta.NORMAL,
                porciones: 5)

        receta.save()

        Receta recetaDos = Receta.findById(receta.id)

        assertFalse recetaDos.dificultad == Dificultad.MEDIA
        assertTrue recetaDos.dificultad == Dificultad.BAJA
        assertTrue recetaDos.dieta == Dieta.NORMAL
    }
}
