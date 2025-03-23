package model

class SeguroHogar: Seguro {

    private constructor(dniTitular: String, importe: Double, metrosCuadrados: Int, valorContenido: Double, direccion: String, anioConstruccion: Int): super(
        generarId("SeguroHogar"), dniTitular, importe){


    }



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