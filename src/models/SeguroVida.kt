package models

class SeguroVida(numPoliza: Int = generarId("SeguroVida"), dniTitular: String, importe: Double, val fechaNac: String, val nivelRiesgo: Enum<TipoRiesgo>, val indemnizacion: Double): Seguro(numPoliza, dniTitular, importe) {
    override fun calcularImporteAnioSiguiente(interes: Double): Double {
        TODO("Not yet implemented")
        //Aumenta según el nivel de riesgo (Bajo 2%, Medio 5%, Alto 10%)
    }

    override fun tipoSeguro(): String {
        TODO("Not yet implemented")
    }

    override fun serializar(): String {
        TODO("Not yet implemented")
    }

}