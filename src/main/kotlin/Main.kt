import java.time.LocalDate


fun main(){
    val lista = mutableListOf(1,1,2,3,4,5,6)
    val listaCopia = lista.filter { it != 1 }
    println(lista)
    println(listaCopia)
}