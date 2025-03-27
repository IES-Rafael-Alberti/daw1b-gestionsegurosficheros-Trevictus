//package ui
//
//class Consola() {
//
//    private fun mostrarMenuAdmin(){
//        println("1. Usuarios\n" +
//                "2. Seguros\n" +
//                "3. Salir")
//
//
//    }
//
//    fun opcionMenuAdmin(){
//        while (true){
//            try{
//                mostrarMenuAdmin()
//                val tipoOpcion = readln().toInt()
//                when(tipoOpcion){
//                    1 ->{
//                        println("1. Nuevo usuario\n" +
//                                "2. Eliminar usuario\n" +
//                                "3. Cambiar contraseña")
//                        val opcionUsuarioAdmin = readln().toInt()
//                        when(opcionUsuarioAdmin){
//                            1 -> crearUsuario()
//                            2 -> eliminarUsuario()
//                            3 -> cambiarContraseña()
//                            else -> {
//                                println("ERROR. Opción no válida.")
//                            }
//                        }
//                    }
//                    2 ->{
//                        println("1. Contratar Seguro\n" +
//                                "2. Eliminar Seguro (ingresar ID)\n" +
//                                "3. Listar Seguros")
//                        val opcionSegurosAdmin = readln().toInt()
//                        when(opcionSegurosAdmin){
//                            1 -> {
//                                println("1. Hogar\n" +
//                                        "2. Auto\n" +
//                                        "3. Vida")
//                                val opcionTipoSeguro = readln().toInt()
//                                when(opcionTipoSeguro){
//                                    1 -> contratarSeguroHogar()
//                                    2 -> contratarSeguroAuto()
//                                    3 -> contratarSeguroVida()
//                                    else -> {
//                                        println("ERROR. Opción inválida.")
//                                    }
//                                }
//                            }
//                            2 -> eliminarSeguro()
//                            3 -> {
//                                println("1. Todos\n" +
//                                        "2. Hogar\n" +
//                                        "3. Auto\n" +
//                                        "4. Vida")
//                                val opcionListar = readln().toInt()
//                                when(opcionListar){
//                                    1 -> listarTodos()
//                                    2 -> listarHogar()
//                                    3 -> listarAuto()
//                                    4 -> listarVida()
//                                    else ->{
//                                        println("ERROR. Opción inválida.")
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    3 -> break
//                    else -> {
//                        println("ERROR. Opción no válida.")
//                    }
//                }
//            }catch (e: NumberFormatException){
//                println("ERROR. $e")
//            }
//        }
//    }
//
//    private fun mostrarMenuGestionYConsulta(){
//        println("1. Seguros\n" +
//                "2. Salir")
//    }
//
//    fun opcionMenuGestion(){
//        while (true){
//            try {
//                mostrarMenuGestionYConsulta()
//                val tipoOpcion = readln().toInt()
//                when(tipoOpcion){
//                    1 -> {
//                        println("1. Contratar\n" +
//                                "2. Eliminar\n" +
//                                "3. Consultar")
//                        val opcioSegurosGetion = readln().toInt()
//                        when(opcioSegurosGetion){
//                            1 -> {
//                                println("1. Hogar\n" +
//                                        "2. Auto\n" +
//                                        "3. Vida")
//                                val opcionTipoSeguro = readln().toInt()
//                                when(opcionTipoSeguro){
//                                    1 -> contratarSeguroHogar()
//                                    2 -> contratarSeguroAuto()
//                                    3 -> contratarSeguroVida()
//                                    else -> {
//                                        println("ERROR. Opción inválida.")
//                                    }
//                                }
//                            }
//                            2 -> eliminarSeguro()
//                            3 -> {
//                                println("1. Todos\n" +
//                                        "2. Hogar\n" +
//                                        "3. Auto\n" +
//                                        "4. Vida")
//                                val opcionListar = readln().toInt()
//                                when(opcionListar){
//                                    1 -> listarTodos()
//                                    2 -> listarHogar()
//                                    3 -> listarAuto()
//                                    4 -> listarVida()
//                                    else ->{
//                                        println("ERROR. Opción inválida.")
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    2 -> break
//                    else -> {
//                        println("ERROR. Opción inválida.")
//                    }
//                }
//            }catch (e: NumberFormatException){
//                println("ERROR. $e")
//            }
//        }
//    }
//
//
//    fun opcionMenuConsulta(){
//        while(true){
//            try{
//                mostrarMenuGestionYConsulta()
//                val tipoOpcion = readln().toInt()
//                when(tipoOpcion){
//                    1 ->{
//                        println("1. Todos\n" +
//                                "2. Hogar\n" +
//                                "3. Auto\n" +
//                                "4. Vida")
//                        val opcionListar = readln().toInt()
//                        when(opcionListar){
//                            1 -> listarTodos()
//                            2 -> listarHogar()
//                            3 -> listarAuto()
//                            4 -> listarVida()
//                            else ->{
//                                println("ERROR. Opción inválida.")
//                            }
//                        }
//                    }
//                    2 -> break
//                    else -> {
//                        println("ERROR. Opción inválida.")
//                    }
//                }
//            }catch (e: NumberFormatException){
//                println("ERROR. $e")
//            }
//        }
//    }
//}