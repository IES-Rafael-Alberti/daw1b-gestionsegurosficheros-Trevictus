package data

import model.Perfil
import model.Usuario

open class RepoUsuariosMem : IRepoUsuarios {
    private val listaUsuarios: MutableList<Usuario> = mutableListOf()

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
        if (buscar(nombreUsuario) != null) {
            eliminar(nombreUsuario)
            return true
        } else {
            println("ERROR. No se encontró el nombre de usuario.")
            return false
        }
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