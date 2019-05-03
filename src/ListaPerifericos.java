import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListaPerifericos implements Utilizable{
    List<Periferico> lista = new ArrayList<>();

    @Override
    public String muestraTodos() {
        String salida = "";

        for (Periferico p:
             lista) {
            salida += p.toString()+"\n";
        }
        return salida;
    }

    @Override
    public void leeDeFichero(File fichero) {
            try {
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);

                String linea;
                while((linea = br.readLine()) != null){
                    extraerObjeto(linea);
                }
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void extraerObjeto(String linea) {
        String[] atributos = new String[2];
        int i = 0;
        for (char c:
             linea.toCharArray()) {
            if(c != ',') {
                atributos[i] += c;
            } else {
                i=1;
            }
        }
        atributos[0] = atributos[0].substring(4);
        atributos[1] = atributos[1].substring(4);
        Anyadir(atributos[0],Double.parseDouble(atributos[1]));
    }

    @Override
    public void guardaEnFichero(File fichero) {

    }

    @Override
    public void pideYAnyade() {
        JFrame entrada = new JFrame();

        Container contenedor = entrada.getContentPane();
        contenedor.setLayout(new FlowLayout());

        contenedor.add(new JLabel("Nombre: "));
        JTextField nombre = new JTextField(10);
        contenedor.add(nombre);
        contenedor.add(new JLabel("Precio: "));
        JTextField precio = new JTextField(10);
        contenedor.add(precio);

        JButton boton = new JButton("Añadir");
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Anyadir(nombre.getText(),Double.parseDouble(precio.getText()));
                    JOptionPane.showMessageDialog(null,"Añadido con exito","Succes",JOptionPane.INFORMATION_MESSAGE);
                    nombre.setText("");
                    precio.setText("");
                }

            });

        contenedor.add(boton);
        entrada.setLocationRelativeTo(null);
        entrada.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        entrada.setVisible(true);
        entrada.pack();
    }

    private void Anyadir(String n, double p) {
        Periferico nuevo = new Periferico(n,p);
        lista.add(nuevo);
    }
}
