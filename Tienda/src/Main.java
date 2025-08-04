import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Factura nuevoCliente = new Factura();
        /*Producto nuevoProducto = new Producto();*/
        Scanner scanner = new Scanner(System.in);

        nuevoCliente.mensajeInicio();

        System.out.print("Ingrese su saldo en tarjeta: ");
        double respuesta = scanner.nextDouble();
        scanner.nextLine();
        nuevoCliente.setSaldo(respuesta);

        //listas para ordenar y mostrar
        ArrayList<Producto> listaCompra = new ArrayList<>();

        char bandera = 'c';
        double localMontoFactura;

        do{
            Producto nuevoProducto = new Producto();
            System.out.print("Ingrese el producto que desea llevar: ");
            String nombre = scanner.nextLine();


            System.out.print("Ingrese el costo del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();//limpia el buffer (toma el salto de linea)


            //AÑADE A LA CLASE
            nuevoProducto.setnombreProducto(nombre);
            nuevoProducto.setPrecio(precio);

            //asignar
            listaCompra.add(nuevoProducto);
            localMontoFactura = nuevoProducto.getMontoTotal();

            if (nuevoProducto.getMontoTotal()>nuevoCliente.getSaldo()) {

                System.out.println("========================================");
                System.out.println("****  SALDO INSUFICIENTE  ****");
                nuevoCliente.mostrarFactura();
                Collections.sort(listaCompra);
                nuevoCliente.listar(listaCompra);

                continue;


            } else if (nuevoProducto.getMontoTotal()==nuevoCliente.getSaldo()) {

                System.out.println("****  CONSUMIÓ TODO EL SALDO DISPONIBLE  ****");
                nuevoCliente.mostrarFactura(); //membrete
                Collections.sort(listaCompra); //ordena
                nuevoCliente.listar(listaCompra); //presenta los productos de la lista
                continue;
            }
            System.out.print("Presiona (s) para salir, (c) para continuar: ");
            bandera = scanner.nextLine().charAt(0); //para tomar solo 1 caracteres

            System.out.println("========================================");

        }while (nuevoCliente.getSaldo()>localMontoFactura && (bandera == 'c' || bandera == 'C') );



    }
}