package scr.model;

public class Director {

    private int id;
    private String name;
    private String urlWeb;
    private String urlFoto;

    public Director(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Director(int id, String name, String urlFoto, String urlWeb) {
        this.id = id;
        this.name = name;
        this.urlFoto = urlFoto;
        this.urlWeb = urlWeb;        
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return name;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public String getUrlFoto() {
        return urlFoto;
    }
    
    
}
