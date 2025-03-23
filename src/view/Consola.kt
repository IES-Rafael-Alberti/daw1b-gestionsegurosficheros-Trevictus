package view

import controller.IActividadRepositorio

class Consola(val repositorio: IActividadRepositorio) {

    fun mostrarMenuAdmin(){
        println("1. Usuarios\n" +
                "2. Seguros\n" +
                "3. Salir")


    }

    fun opcionMenuAdmin(){
        while (true){
            try{
                val tipoOpcion = readln().toInt()
                when(tipoOpcion){
                    1 ->{
                        println("1. Nuevo usuario\n" +
                                "2. Eliminar usuario\n" +
                                "3. Cambiar contraseña")
                        val opcionUsuarioAdmin = readln().toInt()
                        when(opcionUsuarioAdmin){
                            1 -> crearUsuario()
                            2 -> eliminarUsuario()
                            3 -> cambiarContraseña()
                            else -> {
                                println("ERROR. Opción no válida.")
                            }
                        }
                    }
                    2 ->{
                        println("1. Contratar Seguro\n" +
                                "2. Eliminar Seguro (ingresar ID)\n" +
                                "3. Listar Seguros")
                        val opcionSegurosAdmin = readln().toInt()
                        when(opcionSegurosAdmin){
                            1 -> {
                                println("1. Hogar\n" +
                                        "2. Auto\n" +
                                        "3. Vida")
                                val opcionTipoSeguro = readln().toInt()
                                when(opcionTipoSeguro){
                                    1 -> contratarSeguroHogar()
                                    2 -> contratarSeguroAuto()
                                    3 -> contratarSeguroVida()
                                    else -> {
                                        println("ERROR. Opción inválida.")
                                    }
                                }
                            }
                            2 -> eliminarSeguro()
                            3 -> listarSeguros()
                        }
                    }
                    3 -> break
                    else -> {
                        println("ERROR. Opción no válida.")
                    }
                }
            }catch (e: NumberFormatException){
                println("ERROR. $e")
            }
        }
    }
}