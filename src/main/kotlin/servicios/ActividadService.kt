package es.prog2425.taskmanager.servicios

import es.prog2425.taskmanager.datos.ActividadRepository
import es.prog2425.taskmanager.datos.IActividadRepository
import es.prog2425.taskmanager.modelo.*

class ActividadService(val repositorio: IActividadRepository = ActividadRepository()) {


    fun crearEvento(descripcion: String, fecha: String, ubicacion: String) {
        val evento = Evento.crearInstancia(descripcion, fecha, ubicacion)
        repositorio.agregarEvento(evento)
    }

    fun crearTarea(descripcion: String): Tarea {
        val tarea = Tarea.crearInstancia(descripcion)
        repositorio.agregarTarea(tarea)
        return tarea
    }

    fun asociarSubtarea(tareaPrincipal: Tarea, subtarea: Tarea) {
        tareaPrincipal.agregarSubtarea(subtarea)
    }

    fun cambiarEstadoTarea(tarea: Tarea, nuevoEstado: Estado) {
        tarea.cambiarEstadoConHistorial(nuevoEstado)
    }

    fun cerrarTarea(tarea: Tarea) {
        tarea.cerrarConHistorial()
    }

    fun asignarTarea(tarea: Tarea, usuario: Usuario) {
        tarea.asignarUsuarioConHistorial(usuario)
    }

    fun listarActividades(): List<Actividad> = repositorio.obtenerActividades()
}