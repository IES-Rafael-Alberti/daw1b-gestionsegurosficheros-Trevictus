package model

class SeguroHogar : Seguro {

    private var metrosCuadrados: Int
    private var valorContenido: Double
    private var direccion: String
    private var anioConstruccion: Int

    companion object{
        private var numPolizasHogar = 100000


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