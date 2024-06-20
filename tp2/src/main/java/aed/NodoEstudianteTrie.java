package aed;

public class NodoEstudianteTrie {
    boolean esFinalPalabra;
    NodoEstudianteTrie[] hijo;
    NodoEstudianteTrie padre;
    Estudiante estudiante;
    String letra;

    public NodoEstudianteTrie() {
        this.letra = null;
        this.padre = null;
        this.hijo = new NodoEstudianteTrie[1000];
        this.esFinalPalabra = false;
        this.estudiante = null;

    }
}
