package model

enum class Perfil {
    ADMIN, GESTION, CONSULTA;

    companion object {
        fun getPerfil(valor: String): Perfil {
        //Retorna el valor de la enumeración correspondiente a la cadena de caracteres que se pasa por argumento o CONSULTA si no existe. Por ejemplo: getPerfil("gestion") retornaría GESTION
            return when(valor.lowercase()){
                "admin" -> ADMIN
                "gestion" -> GESTION
                else -> CONSULTA
            }
        }
    }
}