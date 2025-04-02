package utils

import model.IExportable
import ui.IEntradaSalida
import java.io.File

class Ficheros(private val entradaSalida: IEntradaSalida) : IUtilFicheros {
    override fun leerArchivo(ruta: String): List<String> {
        val cadenaArchivo = File(ruta).readLines()
        if (!existeFichero(ruta)) {
            entradaSalida.mostrarError("ERROR. No se pudo leer el archivo.")
            return emptyList()
        }
        return cadenaArchivo
    }

    override fun agregarLinea(ruta: String, linea: String): Boolean {
        try {
            val archivo = File(ruta)
            if (!existeFichero(ruta)) {
                archivo.writeText(linea + "\n")
            } else {
                archivo.appendText(linea + "\n")
            }
            return true
        } catch (e: Exception) {
            println("ERROR. Problemas al escribir en/el archivo. ${e.message}")
            return false
        }
    }

    override fun <T : IExportable> escribirArchivo(ruta: String, elementos: List<T>): Boolean {
        File(ruta).writeText(elementos.joinToString("\n") { it.serializar() })
        return true
    }

    override fun existeFichero(ruta: String): Boolean {
        return File(ruta).exists()
    }

    override fun existeDirectorio(ruta: String): Boolean {
        return File(ruta).isDirectory
    }
}