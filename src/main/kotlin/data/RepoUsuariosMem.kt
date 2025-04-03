package data

import model.Perfil
import model.Usuario

open class RepoUsuariosMem : IRepoUsuarios {


    val listaUsuarios: MutableList<Usuario> = mutableListOf()


    override fun agregar(usuario: Usuario): Boolean {
        if (buscar(usuario.nombre) != null) {
            println("ERROR. El usuario ${usuario.nombre} ya existe.")
            return false
        }
        listaUsuarios.add(usuario)
        println("Usuario ${usuario.nombre}, registrado con éxito.")
        return true
    }

    override fun buscar(nombreUsuario: String): Usuario? {
        return listaUsuarios.find { it.nombre == nombreUsuario }
    }

    override fun eliminar(usuario: Usuario): Boolean {
        if (listaUsuarios.remove(usuario)) {
            println("Usuario eliminado.")
            return true
        } else {
            println("ERROR. No se encontró el nombre de usuario.")
            return false
        }
    }

    override fun eliminar(nombreUsuario: String): Boolean {
        val usuarioNombre = buscar(nombreUsuario)
        if (usuarioNombre != null) {
            eliminar(usuarioNombre)
            return true
        }
        return false

    }

    override fun obtenerTodos(): List<Usuario> {
        return listaUsuarios
    }

    override fun obtener(perfil: Perfil): List<Usuario> {
        return listaUsuarios.filter { it.perfil == perfil }
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {
        if (buscar(usuario.nombre) != null) {
            usuario.cambiarClave(nuevaClave)
            return true
        } else {
            return false
        }
    }
}