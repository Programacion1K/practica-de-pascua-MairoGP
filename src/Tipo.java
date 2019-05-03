public enum Tipo {
    RATON("Ratón"),
    MONITOR("Monitor"),
    IMPRESORA("Impresora"),
    TECLADO("Teclado"),
    AURICULARES("Auriculares"),
    SILLA("Silla Gaming");

    private final String nombre;

    Tipo(String n){
        nombre = n;
    }

    public String getNombre() {
        return nombre;
    }
}
