package aed;

public class NodoMateria {
    /*
    nodo con modificacion del 'tail' con instancia de clase Materia
     */
    boolean esFinalPalabra;
    NodoMateria[] hijo;
    NodoMateria padre;
    Materia materia;

    String letra;

    public NodoMateria() {
        this.letra = null;
        this.padre = null;
        this.hijo = new NodoMateria[1000];
        this.esFinalPalabra = false;
        this.materia = null;

    }
}
