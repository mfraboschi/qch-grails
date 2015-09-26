import grails.test.mixin.TestFor
import org.junit.Before
import qch.enums.Dificultad
import qch.enums.Temporada
import qch.receta.Receta

/**
 * Created by mfraboschi on 26/9/15.
 */
@TestFor(RecomendarReceta)
class RecomendarRecetaTests {
    @Before
    void setUp() {
        Receta receta = new Receta(
                caloriasTotal: 300,
                cantVisitas: 10,
                dificultad: Dificultad.BAJA,
                nombre:"Arroz con pollo",
                temporada: Temporada.VERANO,
                porciones: 5)

        receta.save()
    }

}
