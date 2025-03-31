package data

import model.Usuario
import utils.IUtilFicheros

class RepoUsuariosFich(val rutaArchivo: String, val utilFiheros: IUtilFicheros) : RepoUsuariosMem(), ICargarUsuariosIniciales {
    override fun cargarUsuarios(): Boolean {
        TODO("Not yet implemented")
    }

    override fun agregar(usuario: Usuario): Boolean {
        if (buscar(usuario.nombre) != null) {
            println("ERROR. El usuario ${usuario.nombre} ya existe.")
            return false
        }
        utilFiheros.agregarLinea(rutaArchivo, usuario.serializar())
        return true
    }

    override fun eliminar(usuario: Usuario): Boolean {
        return super.eliminar(usuario)
    }
}