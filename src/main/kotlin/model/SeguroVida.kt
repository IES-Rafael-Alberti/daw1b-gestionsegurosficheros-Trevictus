package model

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class SeguroVida : Seguro {

    private val fechaNac: LocalDate
    private val nivelRiesgo: Enum<Riesgo>
    private val indemnizacion: Boolean


    companion object {
        const val PORCENTAJE_INCREMENTO_ANIO = 0.05
        private var numPolizasVida = 800000

        private fun setNumPolizasVida(): Int {
            return numPolizasVida++
        }

        fun crearSeguro(datos: List<String>): SeguroVida? {
            try {
                val fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy")


                val numPoliza = datos[0].toInt()
                val dniTitular: String = datos[1]
                val importe: Double = datos[2].toDouble()
                val fechaNac: LocalDate = LocalDate.parse(datos[3], fechaFormato)
                val nivelRiesgo: Enum<Riesgo> = Riesgo.valueOf(datos[4])
                val indemnizacion: Boolean = datos[5].toBoolean()

                return SeguroVida(
                    numPoliza,
                    dniTitular,
                    importe,
                    fechaNac,
                    nivelRiesgo,
                    indemnizacion
                )
            } catch (e: NumberFormatException) {
                println("ERROR. No se pudo crear el seguro -> $e")
            } catch (e: IllegalArgumentException) {
                println("ERROR. No se pudo crear el seguro -> $e")
            }
            return null
        }
    }

    constructor(
        dniTitular: String,
        importe: Double,
        fechaNac: LocalDate,
        nivelRiesgo: Enum<Riesgo>,
        indemnizacion: Boolean
    ) : super(setNumPolizasVida(), dniTitular, importe) {
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }

    private constructor(
        numPoliza: Int,
        dniTitular: String,
        importe: Double,
        fechaNac: LocalDate,
        nivelRiesgo: Enum<Riesgo>,
        indemnizacion: Boolean
    ) : super(numPoliza, dniTitular, importe) {
        this.fechaNac = fechaNac
        this.nivelRiesgo = nivelRiesgo
        this.indemnizacion = indemnizacion
    }


    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        val interesBase = importe * interes
        val aniosPasados = LocalDate.now().year - fechaNac.year
        val interesResidual = aniosPasados * PORCENTAJE_INCREMENTO_ANIO * importe


        return when (this.nivelRiesgo) {
            Riesgo.BAJO -> interesBase + interesResidual + Riesgo.BAJO.interesAplicado
            Riesgo.ALTO -> interesBase + interesResidual + Riesgo.ALTO.interesAplicado

            else -> interesBase + interesResidual + Riesgo.MEDIO.interesAplicado

        }

    }

//    override fun tipoSeguro(): String {
//        return this::class.simpleName ?: ("Desconocido")
//    }

    override fun serializar(separador: String): String {
        return super.serializar(separador) + listOf(
            fechaNac,
            nivelRiesgo,
            indemnizacion
        ).joinToString(
            separador
        )
    }

    override fun toString(): String {
        return super.toString() + ", fecha nacimiento=$fechaNac, nivel de riesgo=$nivelRiesgo, indemnizacion=$indemnizacion)"
    }
}