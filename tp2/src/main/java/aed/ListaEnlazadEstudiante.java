package aed;

public class ListaEnlazadEstudiante {
    NodoEstudiante raiz;

    public ListaEnlazadEstudiante() {
        this.raiz = null;
    }

    public void insertarEstudiante(Estudiante estudiante) {
        /*
        Inserta al estudiante dentro de la lista enlazada de una materia
        Ademas le suma a su "materiasCursando" +1
         */
        NodoEstudiante nuevoEstudiante = new NodoEstudiante(estudiante);

        if (raiz == null) {
            raiz = nuevoEstudiante;
        } else {
            nuevoEstudiante.siguiente = raiz;
            raiz = nuevoEstudiante;
        }
    estudiante.materiasCursando += 1;
    }
}