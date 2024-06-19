import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class GestorAcademico implements  ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private Map<Integer, ArrayList<Estudiante>> inscripciones = new HashMap<>();

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Estudiante> inscritos = inscripciones.getOrDefault(idCurso, new ArrayList<>());
        if (inscritos.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
        inscritos.add(estudiante);
        inscripciones.put(idCurso, inscritos);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> inscritos = inscripciones.get(idCurso);
        if (inscritos == null || inscritos.stream().noneMatch(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }
        inscritos.removeIf(e -> e.getId() == idEstudiante);
    }
}
