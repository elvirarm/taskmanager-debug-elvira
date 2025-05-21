package services

import es.prog2425.taskmanager.datos.UsuarioRepository
import es.prog2425.taskmanager.modelo.Tarea
import es.prog2425.taskmanager.modelo.Usuario
import es.prog2425.taskmanager.servicios.UsuarioService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.mockk.verify
import io.mockk.mockk
import io.mockk.every


class UsuarioServiceTest : DescribeSpec({

    val mockRepositorio = mockk<UsuarioRepository>(relaxed = true)
    val usuarioService = UsuarioService(mockRepositorio)

    describe("Crear usuario") {
        it("Debe crear un usuario y agregarlo al repositorio") {
            val nombre = "Elvira"
            val usuario = usuarioService.crearUsuario(nombre)

            usuario.nombre shouldBe nombre
            verify { mockRepositorio.agregarUsuario(usuario) }
        }

        it("Debe lanzar excepción si el nombre está vacío") {
            val nombreVacio = ""
            shouldThrow<IllegalArgumentException> {
                usuarioService.crearUsuario(nombreVacio)
            }
        }
    }

    describe("Asignar tarea a usuario") {
        it("Debe asignar la tarea al usuario") {
            val usuario = mockk<Usuario>(relaxed = true)
            val tarea = mockk<Tarea>(relaxed = true)

            usuarioService.asignarTareaAUsuario(usuario, tarea)

            verify { tarea.asignarUsuario(usuario) }
            verify { usuario.asignarTarea(tarea) }
        }

        it("Debe lanzar una excepción si la tarea es nula") {
            val usuario = mockk<Usuario>(relaxed = true)
            val tarea: Tarea? = null

            shouldThrow<IllegalArgumentException> {
                usuarioService.asignarTareaAUsuario(usuario, tarea)
            }
        }
        }


    describe("Obtener tareas por usuario") {
        it("Debe devolver la lista de tareas del usuario") {
            val usuario = mockk<Usuario>()
            val tareasMock = listOf(mockk<Tarea>(), mockk<Tarea>())

            every { usuario.obtenerTareasAsignadas() } returns tareasMock

            val resultado = usuarioService.obtenerTareasPorUsuario(usuario)

            resultado shouldContainExactly tareasMock
        }
    }

    describe("Obtener usuario por nombre") {
        it("Debe devolver el usuario si existe") {
            val nombre = "Lucía"
            val usuarioMock = mockk<Usuario>()

            every { mockRepositorio.obtenerUsuarioPorNombre(nombre) } returns usuarioMock

            val resultado = usuarioService.obtenerUsuarioPorNombre(nombre)

            resultado shouldBe usuarioMock
        }

        it("Debe devolver null si no existe el usuario") {
            val nombre = "Desconocido"

            every { mockRepositorio.obtenerUsuarioPorNombre(nombre) } returns null

            val resultado = usuarioService.obtenerUsuarioPorNombre(nombre)

            resultado shouldBe null
        }
    }

})
