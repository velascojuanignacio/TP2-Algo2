package aed;

public class InfoMateria{
    String[] carreras;
    String[] nombresEnCarreras;

    public InfoMateria(ParCarreraMateria[] listaPares){
        this.carreras = new String[listaPares.length];
        this.nombresEnCarreras = new String[listaPares.length];
        for(int i = 0; i<listaPares.length; i++) {
            this.carreras[i] = listaPares[i].getCarrera();
            this.nombresEnCarreras[i] = listaPares[i].getNombreMateria();
        }
    }

    public int longitud() {
        return carreras.length;
    }

    public String obtenerCarrera(int i) {
        if (i < 0 || i >= longitud()) {
            throw new IndexOutOfBoundsException("indice fuera de rango.");
        }
        return carreras[i];
    }

    public String obtenerNombresMateria(int i) {
        if (i < 0 || i >= longitud()) {
            throw new IndexOutOfBoundsException("indice fuera de rango.");
        }
        return nombresEnCarreras[i];
    }

    public String[] obtenerPar(int i)  {
        String[] par = {carreras[i], nombresEnCarreras[i]};
        return par;
    }
    
}