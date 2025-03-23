package model

abstract class Seguro(val numPoliza: Int, val dniTitular: String, private val importe: Double) {


    companion object {
        var contHogar = 100000
        var contAuto = 400000
        var contVida = 800000
        fun generarId(tipoSeguro: String): Int {
            return if (tipoSeguro == "SeguroHogar") {
                contHogar++
            } else if (tipoSeguro == "SeguroAuto") {
                contAuto++
            } else if (tipoSeguro == "SeguroVida") {
                contVida++
            } else {
                throw IllegalArgumentException("Tipo de seguro inválido.")
            }
        }
    }

    abstract fun calcularImporteAnioSiguiente(interes: Double): Double

    abstract fun tipoSeguro(): String

    abstract fun serializar(): String//convierte el objeto a formato txt

}