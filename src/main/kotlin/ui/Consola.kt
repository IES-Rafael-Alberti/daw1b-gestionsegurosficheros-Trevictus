package ui

import org.jline.reader.EndOfFileException
import org.jline.reader.LineReaderBuilder
import org.jline.reader.UserInterruptException
import org.jline.terminal.TerminalBuilder

class Consola : IEntradaSalida {

    override fun mostrar(msj: String, salto: Boolean, pausa: Boolean) {

        if (salto) {
            println(msj)
        } else {
            print(msj)
        }
        if (pausa) {
            pausar()
        }
    }

    override fun mostrarError(msj: String, pausa: Boolean) {
        val error = "ERROR - "
        if (msj.startsWith(error)) {
            println(msj)
        } else {
            println(error + msj)
        }
        if (pausa) {
            pausar()
        }
    }

    override fun pedirInfo(msj: String): String {
        if (msj.isNotEmpty()) {
            mostrar(msj, false)
        }
        val entrada = readln()
        return entrada.trim()
    }

    override fun pedirInfo(msj: String, error: String, debeCumplir: (String) -> Boolean): String {
        val entrada = pedirInfo(msj)
        require(debeCumplir(entrada)) { error }
        return entrada
//        if (msj.isNotEmpty()) {
//            println(msj)
//        }
//        var entrada = readlnOrNull()?.trim() ?: ""
//        while (!debeCumplir(entrada)) {
//            println(error)
//            if (msj.isNotEmpty()) {
//                println(msj)
//            }
//            entrada = readlnOrNull()?.trim() ?: ""
//        }
//        return entrada

    }

    override fun pedirDouble(
        prompt: String,
        error: String,
        errorConv: String,
        debeCumplir: (Double) -> Boolean
    ): Double {
        var input: String
        var numero: Double? = null

        do {
            input = pedirInfo(prompt)

            input = input.replace(',', '.')

            try {
                numero = input.toDoubleOrNull() ?: throw IllegalArgumentException(errorConv)
                require(debeCumplir(numero)) { error }

            } catch (e: Exception) {
                mostrarError(e.message.toString())
            }
        } while (numero == null)
        return numero
    }

    override fun pedirEntero(prompt: String, error: String, errorConv: String, debeCumplir: (Int) -> Boolean): Int {
        var input: String
        var numero: Int? = null

        do {
            input = pedirInfo(prompt)

            try {
                numero = input.toIntOrNull() ?: throw IllegalArgumentException(errorConv)
                require(debeCumplir(numero)) { error }

            } catch (e: Exception) {
                mostrarError(e.message.toString())
            }
        } while (numero == null)
        return numero
    }

    override fun pedirInfoOculta(prompt: String): String {
        return try {
            val terminal = TerminalBuilder.builder()
                .dumb(true) // Para entornos no interactivos como IDEs
                .build()

            val reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build()

            reader.readLine(prompt, '*') // Oculta la contraseña con '*'
        } catch (e: UserInterruptException) {
            mostrarError("Entrada cancelada por el usuario (Ctrl + C).", pausa = false)
            ""
        } catch (e: EndOfFileException) {
            mostrarError("Se alcanzó el final del archivo (EOF ó Ctrl+D).", pausa = false)
            ""
        } catch (e: Exception) {
            mostrarError("Problema al leer la contraseña: ${e.message}", pausa = false)
            ""
        }
    }

    override fun pausar(msj: String) {
        print(msj)
        readln()
    }

    override fun limpiarPantalla(numSaltos: Int) {
        if (System.console() != null) {
            mostrar("\u001b[H\u001b[2J", false)
            System.out.flush()
        } else {
            repeat(numSaltos) {
                mostrar("")
            }
        }
    }

    override fun preguntar(mensaje: String): Boolean {
        while (true) {
            mostrar(mensaje)
            val opcion = readln()
            if (opcion == "s") {
                return true
            } else if (opcion == "n") {
                return false
            }
        }
    }
}