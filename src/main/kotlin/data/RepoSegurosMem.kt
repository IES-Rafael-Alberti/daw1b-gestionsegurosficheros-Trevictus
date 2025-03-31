package data

import model.Seguro

open class RepoSegurosMem: IRepoSeguros {
    val listaSeguros: MutableList<Seguro> = mutableListOf()

    override fun agregar(seguro: Seguro): Boolean {
        if (buscar(seguro.numPoliza) != null) {
            println("ERROR. El seguro ${seguro.numPoliza} ya existe.")
            return false
        }
        listaSeguros.add(seguro)
        println("Seguro ${seguro.numPoliza}, registrado con éxito.")
        return true
    }

    override fun buscar(numPoliza: Int): Seguro? {
        return listaSeguros.find { it.numPoliza == numPoliza }
    }

    override fun eliminar(seguro: Seguro): Boolean {
        if (listaSeguros.remove(seguro)) {
            println("Seguro eliminado.")
            return true
        } else {
            println("ERROR. No se encontró el nº de póliza del seguro.")
            return false
        }
    }

    override fun eliminar(numPoliza: Int): Boolean {
        val seguroNum = buscar(numPoliza)
        if (seguroNum != null) {
            eliminar(seguroNum)
            return true
        }
        return false
    }

    override fun obtenerTodos(): List<Seguro> {
        return listaSeguros
    }

    override fun obtener(tipoSeguro: String): List<Seguro> {
        return listaSeguros.filter { it.tipoSeguro() == tipoSeguro }
    }
}