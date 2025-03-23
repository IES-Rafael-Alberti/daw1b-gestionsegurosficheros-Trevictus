package models

class SeguroHogar(numPoliza: Int = generarId("SeguroHogar"), dniTitular: String, importe: Double, val metroCuadrados: Int, val valorContenido: Double, val direccion: String): Seguro(numPoliza, dniTitular, importe) {



    override fun calcularImporteAnioSiguiente(interes: Double): Double{
        TODO("Not yet implemented")
        //Aplica el porcentaje proporcionado al importe para generar la predicción del importe del siguiente año
    }

    override fun tipoSeguro(): String {
        TODO("Not yet implemented")
    }

    override fun serializar(): String {
        TODO("Not yet implemented")
    }
}