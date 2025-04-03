package model

enum class Riesgo(val interesAplicado: Double) {
    BAJO(2.0),
    MEDIO(5.0),
    ALTO(10.0);

    companion object {
        fun getRiesgo(valor: String): Riesgo{
            //Retorna el valor de la enumeración correspondiente a la cadena de caracteres que se pasa por argumento o MEDIO si no existe. Por ejemplo: getRiesgo("bajo") retornaría BAJO
            return when(valor.lowercase()){
                "bajo" -> BAJO
                "alto" -> ALTO
                else -> MEDIO
            }
        }
    }
}