package model

abstract class Seguro(val numPoliza: Int, val dniTitular: String, private val importe: Double): IExportable {


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

    fun comprobarNumPoliza(numPoliza: Int): Boolean{
        return numPoliza == this.numPoliza
    }

    override fun serializar(): String {
        return listOf(numPoliza, dniTitular, importe).joinToString(";")
    }

    override fun equals(other: Any?): Boolean {
        if(this === other){
            return true
        }
        if(other !is Seguro){
            return false
        }

        return this.numPoliza == other.numPoliza
    }

    override fun hashCode(): Int {
        return numPoliza.hashCode()
    }

    override fun toString(): String {
        return "Seguro(numPoliza=$numPoliza, dniTitular=$dniTitular, importe=${"%.2f".format(importe)})"
    }
}