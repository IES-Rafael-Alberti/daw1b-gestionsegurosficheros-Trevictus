package model

class SeguroAuto(numPoliza: Int = generarId("SeguroAuto"), dniTitular: String, importe: Double, val descripcion: String, val combustible: String, val tipoAuto: Enum<Auto>, val tipoCobertura: String, val asistenciaCarrera: Boolean, val numPartes: Int): Seguro(numPoliza, dniTitular, importe) {
    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        TODO("Not yet implemented")
        //Aumenta un 2% por cada parte el interés pasado como argumento, si hubo partes, si no solo usa el interés dado
    }

    override fun tipoSeguro(): String {
        TODO("Not yet implemented")
    }

    override fun serializar(): String {
        TODO("Not yet implemented")
    }
}