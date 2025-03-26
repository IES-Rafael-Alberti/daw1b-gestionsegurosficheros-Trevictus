package model

enum class Cobertura(val desc: String) {
    TERCEROS("Terceros"),
    TERCEROS_AMPLIADO("Terceros+"),
    FRANQUICIA_200("Todo Riesgo con Franquicia de 200€"),
    FRANQUICIA_300("Todo Riesgo con Franquicia de 300€"),
    FRANQUICIA_400("Todo Riesgo con Franquicia de 400€"),
    FRANQUICIA_500("Todo Riesgo con Franquicia de 500€"),
    TODO_RIESGO("Todo Riesgo");

    companion object {
        fun getCobertura(valor: String): Cobertura {
            //Retorna el valor de la enumeración correspondiente a la cadena de caracteres que se pasa por argumento o TERCEROS si no existe. Por ejemplo: getCobertura("terceros_ampliado") retornaría TERCEROS_AMPLIADO
            return when (valor.lowercase()) {
                "Terceros+" -> TERCEROS_AMPLIADO
                "Todo Riesgo con Franquicia de 200€" -> FRANQUICIA_200
                "Todo Riesgo con Franquicia de 300€" -> FRANQUICIA_300
                "Todo Riesgo con Franquicia de 400€" -> FRANQUICIA_400
                "Todo Riesgo con Franquicia de 500€" -> FRANQUICIA_500
                "Todo Riesgo" -> TODO_RIESGO
                else -> TERCEROS
            }
        }
    }
}