package aed;

public class NodoEstudiante {
    Estudiante valor;
    NodoEstudiante siguiente;
    Estudiante estudiante;

    public NodoEstudiante(Estudiante estudiante) {
        valor = estudiante;
        this.siguiente = null;
        this.estudiante = estudiante;
    }
}
