package data

import model.Usuario
import utils.IUtilFicheros

class RepoUsuariosFich(private val rutaArchivo: String, private val utilFihero: IUtilFicheros) : RepoUsuariosMem(),
    ICargarUsuariosIniciales {
    override fun cargarUsuarios(): Boolean {
        if (utilFihero.existeFichero(rutaArchivo)) {
            val listaCampos = utilFihero.leerArchivo(rutaArchivo)
            for (campo in listaCampos) {
                val datos = campo.split(";")
                Usuario.crearUsuario(datos)?.let { super.agregar(it) }
            }
            return true
        } else {
            return false
        }

    }


    override fun agregar(usuario: Usuario): Boolean {
        if (buscar(usuario.nombre) != null) {
            println("ERROR. El usuario ${usuario.nombre} ya existe.")
            return false
        }
        utilFihero.agregarLinea(rutaArchivo, usuario.serializar())
        return true
    }

    override fun eliminar(usuario: Usuario): Boolean {
        val listaUsuariosFiltrada: List<Usuario> = listaUsuarios.filter { it != usuario }
        if (utilFihero.escribirArchivo(rutaArchivo, listaUsuariosFiltrada)) {
            return super.eliminar(usuario)

        }
        return false
    }
}