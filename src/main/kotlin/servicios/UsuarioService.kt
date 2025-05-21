package es.prog2425.taskmanager.servicios

import es.prog2425.taskmanager.datos.IUsuarioRepository
import es.prog2425.taskmanager.datos.UsuarioRepository
import es.prog2425.taskmanager.modelo.Tarea
import es.prog2425.taskmanager.modelo.Usuario

/**
 * Servicio encargado de gestionar operaciones relacionadas con usuarios,
 * como su creación, asignación de tareas y consultas.
 *
 * @property repositorio Implementación del repositorio de usuarios.
 */
class UsuarioService(private val repositorio: IUsuarioRepository = UsuarioRepository()) : IUsuarioService {


    /**
     * Crea un nuevo usuario con el nombre proporcionado.
     *
     * @param nombre Nombre del nuevo usuario.
     * @return El usuario creado.
     * @throws IllegalArgumentException si el nombre está vacío.
     */
    override fun crearUsuario(nombre: String): Usuario {
        if (nombre.isBlank()) {
            throw IllegalArgumentException("El nombre no puede estar vacío")
        }
        val usuario = Usuario(nombre)
        repositorio.agregarUsuario(usuario)
        return usuario
    }

    /**
     * Asigna una tarea a un usuario determinado.
     *
     * @param usuario Usuario al que se le asignará la tarea.
     * @param tarea Tarea que se va a asignar.
     * @throws IllegalArgumentException si la tarea es nula.
     */
    override fun asignarTareaAUsuario(usuario: Usuario, tarea: Tarea?) {
        requireNotNull(tarea) { "La tarea no puede ser nula" }

        tarea.asignarUsuario(usuario)
        usuario.asignarTarea(tarea)
    }

    /**
     * Obtiene la lista de tareas asignadas a un usuario.
     *
     * @param usuario Usuario del cual se quieren obtener las tareas.
     * @return Lista de tareas asignadas al usuario.
     */
    override fun obtenerTareasPorUsuario(usuario: Usuario): List<Tarea> {
        return usuario.obtenerTareasAsignadas()
    }


    /**
     * Busca un usuario por su nombre.
     *
     * @param nombre Nombre del usuario a buscar.
     * @return El usuario si se encuentra, o null si no existe.
     */
    override fun obtenerUsuarioPorNombre(nombre: String): Usuario? {
        return repositorio.obtenerUsuarioPorNombre(nombre)
    }
}
