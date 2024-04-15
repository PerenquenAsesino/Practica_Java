package scr.statics;


public enum Genero {
    ACCION(1),
    AVENTURA(2),
    COMEDIA(3),
    DRAMA(4),
    FANTASIA(5),
    TERROR(6),
    CIENCIA_FICCION(7),
    MUSICAL_DANZA(8),
    SUSPENSE(9),
    WESTERN(10),
    DOCUMENTAL(11),
    BIOGRAFICO(12),
    ROMANCE(13);

    private final int id;

    Genero(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}