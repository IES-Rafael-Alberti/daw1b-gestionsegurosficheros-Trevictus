package data

import model.Seguro

interface ICargarSegurosIniciales {
    fun cargarSeguros(mapa: Map<String, (List<String>) -> Seguro?>): Boolean
}//Lo utilizará el main.kt