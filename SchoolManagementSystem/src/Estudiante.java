public class Estudiante extends Persona{
    private  String estado;
    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
