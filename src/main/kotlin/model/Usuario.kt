package model

class Usuario(public val nombre: String, private var clave: String, public val perfil: String) : IExportable {
//    TODO("el nombre de usuario debe ser unico en (SERVICE)")

    companion object {
        fun crearSeguro(datos: List<String>): Usuario? {
            try {
                val nombre: String = datos[0]
                val clave: String = datos[1]
                val perfil: String = datos[2]

                return Usuario(
                    nombre,
                    clave,
                    perfil
                )
            } catch (e: NumberFormatException) {
                println("ERROR. No se pudo crear el usuario -> $e")
            }
            return null
        }

    }

    override fun serializar(separador: String): String {
        return listOf(nombre, clave, perfil).joinToString(separador)
    }

    fun verificarClave(claveEncriptada: String): Boolean {
        return claveEncriptada == this.clave
    }

    fun cambiarClave(nuevaClaveEncriptada: String): String {
        this.clave = nuevaClaveEncriptada
        return nuevaClaveEncriptada
//        TODO("cambiarClave(nuevaClaveEncriptada: String): Actualiza la clave del usuario (este método va a actualizar la clave del usuario directamente, pero en el servicio que gestiona los usuarios debe solicitar la antigua clave, verificarla y pedir la nueva).")
    }
}