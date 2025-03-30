package model


class SeguroAuto : Seguro {

    private val descripcion: String
    private val combustible: String
    private val tipoAuto: Enum<Auto>
    private val tipoCobertura: Enum<Cobertura>
    private val asistenciaCarrera: Boolean
    private val numPartes: Int

    companion object {
        const val PORCENTAJE_INCREMENTO_PARTES = 2
        private var numPolizasAuto = 400000

        private fun setNumPolizasAuto(): Int {
            return numPolizasAuto++
        }

        fun crearSeguro(datos: List<String>): SeguroAuto? {
            try {
                val numPoliza = datos[0].toInt()
                val dniTitular: String = datos[1]
                val importe: Double = datos[2].toDouble()
                val descripcion: String = datos[3]
                val combustible: String = datos[4]
                val tipoAuto: Enum<Auto> = Auto.valueOf(datos[5])
                val tipoCobertura: Enum<Cobertura> = Cobertura.valueOf(datos[6])
                val asistenciaCarrera: Boolean = datos[7].toBoolean()
                val numPartes: Int = datos[8].toInt()


                return SeguroAuto(
                    numPoliza,
                    dniTitular,
                    importe,
                    descripcion,
                    combustible,
                    tipoAuto,
                    tipoCobertura,
                    asistenciaCarrera,
                    numPartes
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
        descripcion: String,
        combustible: String,
        tipoAuto: Enum<Auto>,
        tipoCobertura: Enum<Cobertura>,
        asistenciaCarrera: Boolean,
        numPartes: Int
    ) : super(setNumPolizasAuto(), dniTitular, importe) {
        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.tipoCobertura = tipoCobertura
        this.asistenciaCarrera = asistenciaCarrera
        this.numPartes = numPartes
    }

    private constructor(
        numPoliza: Int,
        dniTitular: String,
        importe: Double,
        descripcion: String,
        combustible: String,
        tipoAuto: Enum<Auto>,
        tipoCobertura: Enum<Cobertura>,
        asistenciaCarrera: Boolean,
        numPartes: Int
    ) : super(numPoliza, dniTitular, importe) {
        this.descripcion = descripcion
        this.combustible = combustible
        this.tipoAuto = tipoAuto
        this.tipoCobertura = tipoCobertura
        this.asistenciaCarrera = asistenciaCarrera
        this.numPartes = numPartes
    }


    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        val incrementoPartes = numPartes * PORCENTAJE_INCREMENTO_PARTES / 100
        val importeTotal = this.importe + interes * this.importe + incrementoPartes * this.importe

        return importeTotal
    }

//    override fun tipoSeguro(): String {
//        return this::class.simpleName ?: ("Desconocido")
//    }

    override fun serializar(separador: String): String {
        return super.serializar(separador) + listOf(
            descripcion,
            combustible,
            tipoAuto,
            tipoCobertura,
            asistenciaCarrera,
            numPartes
        ).joinToString(
            separador
        )
    }

    override fun toString(): String {
        return super.toString() + ", descripción=$descripcion, combustible=$combustible, tipo de auto=$tipoAuto, tipo de cobertura=$tipoCobertura, asistencia en carretera=$asistenciaCarrera, partes al seguro=$numPartes)"
    }
}