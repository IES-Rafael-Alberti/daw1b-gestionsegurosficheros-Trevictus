package ui

class Consola: IEntradaSalida {

    override fun mostrar(msj: String, salto: Boolean, pausa: Boolean) {

        if(salto){
            println(msj)
        }else{
            print(msj)
        }
        if(pausa){
            println("Pulsa Enter para continuar...")
            readln()
        }
    }

    override fun mostrarError(msj: String, pausa: Boolean) {
        val error = "ERROR - "
        if(msj.startsWith(error)){
            println(msj)
        }else{
            println(error + msj)
        }
        if(pausa){
            println("Pulsa Enter para continuar...")
            readln()
        }
    }

    override fun pedirInfo(msj: String): String {
        if(msj.isNotEmpty()){
            println(msj)
        }
        val entrada = readln()
        return entrada.trim()
    }

    override fun pedirInfo(msj: String, error: String, debeCumplir: (String) -> Boolean): String {
        if(msj.isNotEmpty()){
            println(msj)
        }
        var entrada = readlnOrNull()?.trim() ?: ""
        while (!debeCumplir(entrada)) {
            println(error)
            if (msj.isNotEmpty()) {
                println(msj)
            }
            entrada = readlnOrNull()?.trim() ?: ""
        }
        return entrada
    }

    override fun pedirDouble(
        prompt: String,
        error: String,
        errorConv: String,
        debeCumplir: (Double) -> Boolean
    ): Double {
        val numDecimal
    }

    override fun pedirEntero(prompt: String, error: String, errorConv: String, debeCumplir: (Int) -> Boolean): Int {
        TODO("Not yet implemented")
    }

    override fun pedirInfoOculta(prompt: String): String {
        TODO("Not yet implemented")
    }

    override fun pausar(msj: String) {
        TODO("Not yet implemented")
    }

    override fun limpiarPantalla(numSaltos: Int) {
        TODO("Not yet implemented")
    }

    override fun preguntar(mensaje: String): Boolean {
        TODO("Not yet implemented")
    }
}