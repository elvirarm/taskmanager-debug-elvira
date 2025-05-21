package es.prog2425.taskmanager.servicios

import es.prog2425.taskmanager.datos.ActividadRepository
import es.prog2425.taskmanager.datos.IActividadRepository
import es.prog2425.taskmanager.modelo.*

/**
 * Maneja las operaciones sobre actividades como crear eventos, tareas,
 * cambiar estados, asignar usuarios y gestionar subtareas.
 *
 * @param repositorio Permite acceder y modificar los datos almacenados.
 */
class ActividadService(val repositorio: IActividadRepository = ActividadRepository()) {

    /**
     * Crea un evento nuevo con la descripción, fecha y lugar que se le pasan,
     * y lo guarda en el repositorio.
     *
     * @param descripcion Descripción del evento.
     * @param fecha Fecha en que tendrá lugar el evento.
     * @param ubicacion Lugar donde se realizará el evento.
     */
    fun crearEvento(descripcion: String, fecha: String, ubicacion: String) {
        val evento = Evento.crearInstancia(descripcion, fecha, ubicacion)
        repositorio.agregarEvento(evento)
    }


    /**
     * Crea una tarea nueva con la descripción dada, la agrega al repositorio
     * y devuelve la tarea creada para que pueda usarse luego.
     *
     * @param descripcion Texto que explica la tarea.
     * @return La tarea que se acaba de crear.
     */
    fun crearTarea(descripcion: String): Tarea {
        val tarea = Tarea.crearInstancia(descripcion)
        repositorio.agregarTarea(tarea)
        return tarea
    }

    /**
     * Añade una subtarea a una tarea principal.
     *
     * @param tareaPrincipal La tarea a la que se le añade la subtarea.
     * @param subtarea La tarea que será subtarea.
     */
    fun asociarSubtarea(tareaPrincipal: Tarea, subtarea: Tarea) {
        tareaPrincipal.agregarSubtarea(subtarea)
    }

    /**
     * Cambia el estado de una tarea y guarda ese cambio en el historial.
     *
     * @param tarea La tarea que se va a actualizar.
     * @param nuevoEstado El nuevo estado que tendrá la tarea.
     */
    fun cambiarEstadoTarea(tarea: Tarea, nuevoEstado: Estado) {
        tarea.cambiarEstadoConHistorial(nuevoEstado)
    }

    /**
     * Marca una tarea como cerrada y registra esa acción.
     *
     * @param tarea La tarea que se va a cerrar.
     */
    fun cerrarTarea(tarea: Tarea) {
        tarea.cerrarConHistorial()
    }

    /**
     * Asigna un usuario a una tarea y deja constancia en el historial de la tarea.
     *
     * @param tarea La tarea a la que se asigna el usuario.
     * @param usuario Usuario que recibirá la tarea.
     */
    fun asignarTarea(tarea: Tarea, usuario: Usuario) {
        tarea.asignarUsuarioConHistorial(usuario)
    }

    /**
     * Devuelve todas las actividades que hay guardadas.
     *
     * @return Lista con todas las actividades.
     */
    fun listarActividades(): List<Actividad> = repositorio.obtenerActividades()
}