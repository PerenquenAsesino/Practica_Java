package scr.model.statics;


public enum Genero {
    ACCION(1, "Accion"),
    AVENTURA(2, "Aventura"),
    COMEDIA(3, "Comedia"),
    DRAMA(4, "Drama"),
    FANTASIA(5, "Fantasia"),
    TERROR(6, "Terror"),
    CIENCIA_FICCION(7, "Ciencia_Ficcion"),
    MUSICAL_DANZA(8, "Musical_Danza"),
    SUSPENSE(9, "Suspense"),
    WESTERN(10, "Western"),
    DOCUMENTAL(11, "Documental"),
    BIOGRAFICO(12, "Biografico"),
    ROMANCE(13, "Romance");

    private final int id;
    private final String descripcion;

    Genero(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public static Genero getById(int id) {
        for (Genero genero : Genero.values()) {
            if (genero.getId() == id) {
                return genero;
            }
        }
        return null;
    }
}