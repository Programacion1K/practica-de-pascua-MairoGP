import javax.swing.*;
import java.io.File;

public class Periferico{
    private final String nombre;
    private final double precio;
//    private final Tipo tipo;

    Periferico(String n, double p){
        nombre = n;
        precio = p;
//        tipo = Tipo.valueOf(t);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre +" - "+ precio;
    }
}
