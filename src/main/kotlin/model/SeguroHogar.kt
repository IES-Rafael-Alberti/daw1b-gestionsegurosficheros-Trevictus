package model

import java.time.LocalDate

class SeguroHogar : Seguro {

    private var metrosCuadrados: Int
    private var valorContenido: Double
    private var direccion: String
    private var anioConstruccion: Int

    companion object {
        const val PORCENTAJE_INCREMENTO_ANIOS = 0.02
        const val CICLO_ANIOS_INCREMENTO = 5
        private var numPolizasHogar = 100000

        private fun setNumPolizasHogar(): Int {
            return numPolizasHogar++
        }

        fun crearSeguro(datos: List<String>): SeguroHogar? {
            try {
                val numPoliza = datos[0].toInt()
                val dniTitular: String = datos[1]
                val importe: Double = datos[2].toDouble()
                val metrosCuadrados: Int = datos[3].toInt()
                val valorContenido: Double = datos[4].toDouble()
                val direccion: String = datos[5]
                val anioConstruccion: Int = datos[6].toInt()

                return SeguroHogar(
                    numPoliza,
                    dniTitular,
                    importe,
                    metrosCuadrados,
                    valorContenido,
                    direccion,
                    anioConstruccion
                )
            } catch (e: NumberFormatException) {
                println("ERROR. No se pudo crear el seguro -> $e")
            }
            return null
        }

    }

    constructor(
        dniTitular: String,
        importe: Double,
        metrosCuadrados: Int,
        valorContenido: Double,
        direccion: String,
        anioConstruccion: Int
    ) : super(
        setNumPolizasHogar(), dniTitular, importe
    ) {
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }

    private constructor(
        numPoliza: Int,
        dniTitular: String,
        importe: Double,
        metrosCuadrados: Int,
        valorContenido: Double,
        direccion: String,
        anioConstruccion: Int
    ) : super(
        numPoliza, dniTitular, importe
    ) {
        this.metrosCuadrados = metrosCuadrados
        this.valorContenido = valorContenido
        this.direccion = direccion
        this.anioConstruccion = anioConstruccion
    }


    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        val aniosTotales = LocalDate.now().year - anioConstruccion
        val interesCiclico = aniosTotales / CICLO_ANIOS_INCREMENTO * PORCENTAJE_INCREMENTO_ANIOS
        val importeTotal = this.importe + interes * this.importe + interesCiclico * this.importe

        return importeTotal

    }

    override fun tipoSeguro(): String {
        return this::class.simpleName ?: ("Desconocido")
    }

    override fun serializar(separador: String): String {
        return super.serializar(separador) + listOf(
            metrosCuadrados,
            valorContenido,
            direccion,
            anioConstruccion
        ).joinToString(
            separador
        )
    }

    override fun toString(): String {
        return super.toString() + ", metros cuadrados=$metrosCuadrados, valor contenido=$valorContenido, direccion=$direccion, año de construcción=$anioConstruccion)"
    }
}