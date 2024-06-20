package aed;

public class NodoCarrera {
    /*
    nodo con modificacion del 'tail' con instancia de trie de Materias de carrera
     */
    boolean esFinalPalabra;
    NodoCarrera[] hijo;
    TrieMaterias trieMaterias;
    String letra;

    public NodoCarrera() {
        this.letra = null;
        this.hijo = new NodoCarrera[1000];
        this.esFinalPalabra = false;
        this.trieMaterias = null;
    }
}
