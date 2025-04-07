package utils

import model.IExportable
import ui.IEntradaSalida
import java.io.File

class Ficheros(private val entradaSalida: IEntradaSalida) : IUtilFicheros {
    override fun leerArchivo(ruta: String): List<String> {
        if (!existeFichero(ruta)) {
            return mutableListOf()
        }
        val rutaArchivo = File(ruta)
        return rutaArchivo.readLines()
    }

    override fun agregarLinea(ruta: String, linea: String): Boolean {
        try {
            val archivo = File(ruta)
            if (!existeFichero(ruta)) {
                archivo.appendText(linea + "\n")
            } else {
                archivo.appendText(linea + "\n")
            }
            return true
        } catch (e: Exception) {
            entradaSalida.mostrarError("Problemas al escribir en/el archivo. ${e.message}")
            return false
        }
    }

    override fun <T : IExportable> escribirArchivo(ruta: String, elementos: List<T>): Boolean {
        if (elementos.size == 1) {
            File(ruta).writeText(elementos[0].serializar() + "\n")
        } else {
            File(ruta).writeText(elementos.joinToString("\n") { it.serializar() })
        }
        return true
    }

    override fun existeFichero(ruta: String): Boolean {
        return File(ruta).exists()
    }

    override fun existeDirectorio(ruta: String): Boolean {
        return File(ruta).isDirectory
    }
}