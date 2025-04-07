package service

import data.IRepoUsuarios
import model.Perfil
import model.Usuario
import utils.IUtilSeguridad

class GestorUsuarios(val repoUsuarios: IRepoUsuarios, val seguridad: IUtilSeguridad) : IServUsuarios {
    override fun iniciarSesion(nombre: String, clave: String): Perfil? {
        val usuario = buscarUsuario(nombre)

        if (usuario != null) {
            usuario.verificarClave(seguridad.encriptarClave(clave))
            return usuario.perfil
        } else {
            return null
        }
    }

    override fun agregarUsuario(nombre: String, clave: String, perfil: Perfil): Boolean {
        return repoUsuarios.agregar(Usuario(nombre, seguridad.encriptarClave(clave), perfil))
    }

    override fun eliminarUsuario(nombre: String): Boolean {
        return repoUsuarios.eliminar(nombre)
    }

    override fun cambiarClave(usuario: Usuario, nuevaClave: String): Boolean {
        return repoUsuarios.cambiarClave(usuario, seguridad.encriptarClave(nuevaClave))
    }

    override fun buscarUsuario(nombre: String): Usuario? {
        return repoUsuarios.buscar(nombre)
    }

    override fun consultarTodos(): List<Usuario> {
        return repoUsuarios.obtenerTodos()
    }

    override fun consultarPorPerfil(perfil: Perfil): List<Usuario> {
        return repoUsuarios.obtener(perfil)
    }


}