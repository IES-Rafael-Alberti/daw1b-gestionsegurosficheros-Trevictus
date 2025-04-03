import app.CargadorInicial
import data.*
import service.GestorSeguros
import service.GestorUsuarios
import ui.Consola
import utils.Ficheros
import utils.Seguridad
import java.time.LocalDate


fun main(){
    val archivoTxtUsuarios = "src/main/kotlin/data/res/Usuarios.txt"
    val archivoTxtSeguros = "src/main/kotlin/data/res/Seguros.txt"

    val ui = Consola()
    val gestorFicheros = Ficheros(ui)
    val moduloSeguridad = Seguridad()

    ui.limpiarPantalla()

    val simulacion = ui.preguntar("¿Desea iniciar en modo simulación? (s/n): ")

    val repoUsuarios: IRepoUsuarios
    val repoSeguros: IRepoSeguros

    if(simulacion){
        repoUsuarios = RepoUsuariosMem()
        repoSeguros = RepoSegurosMem()
    }else{
        repoUsuarios = RepoUsuariosFich(archivoTxtUsuarios, gestorFicheros)
        repoSeguros = RepoSegurosFich(archivoTxtSeguros, gestorFicheros)
        CargadorInicial(ui, repoSeguros, repoUsuarios).cargarSeguros()
        CargadorInicial(ui,repoSeguros, repoUsuarios).cargarUsuarios()
    }

    val gestorSeguros = GestorSeguros(repoSeguros)
    val gestorUsuarios = GestorUsuarios(repoUsuarios, moduloSeguridad)

    val login = ControlAcceso(archivoTxtUsuarios, ui, gestorUsuarios, gestorFicheros).autenticar()

    if(login != null){
        GestorMenu(login.first, login.second, ui, gestorUsuarios, gestorSeguros).iniciarMenu()
    }
}