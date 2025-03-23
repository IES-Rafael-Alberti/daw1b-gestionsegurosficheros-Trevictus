package model

enum class Auto {
    COCHE, MOTO, CAMION;

    companion object{
        fun getAuto(valor: String): Auto{
        //Retorna el valor de la enumeración correspondiente a la cadena de caracteres que se pasa por argumento o COCHE si no existe. Por ejemplo: getAuto("moto") retornaría MOTO
            return when(valor.lowercase()){
                "moto" -> MOTO
                "camion" -> CAMION
                else -> COCHE
            }
        }
    }
}