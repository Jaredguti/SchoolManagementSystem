public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}

class EstudianteYaInscritoException extends Exception {
    public EstudianteYaInscritoException(String mensaje) {
        super(mensaje);
    }
}

class EstudianteNoInscritoEnCursoException extends Exception {
    public EstudianteNoInscritoEnCursoException(String mensaje) {
        super(mensaje);
    }

}
