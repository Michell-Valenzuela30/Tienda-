import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Factura nuevoCliente = new Factura();
        Scanner scanner = new Scanner(System.in);

        nuevoCliente.mensajeInicio();

        System.out.print("Ingrese su saldo en tarjeta: $");
        double respuesta = scanner.nextDouble();
        scanner.nextLine();
        nuevoCliente.setSaldo(respuesta);

        ArrayList<Producto> listaCompra = new ArrayList<>();
        char bandera = 'c';

        do{
            Producto nuevoProducto = new Producto();
            System.out.print("Ingrese el producto que desea llevar: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el costo del producto: $");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            // Verificar si el nuevo producto excede el saldo disponible
            double nuevoTotal = nuevoCliente.getMontoTotal() + precio;
            
            if (nuevoTotal > nuevoCliente.getSaldo()) {
                System.out.println("========================================");
                System.out.println("****  SALDO INSUFICIENTE  ****");
                System.out.printf("Producto: %s - Precio: $%.2f\n", nombre, precio);
                System.out.printf("Total actual: $%.2f\n", nuevoCliente.getMontoTotal());
                System.out.printf("Saldo disponible: $%.2f\n", nuevoCliente.getSaldo());
                System.out.println("No se puede agregar este producto.");
                System.out.println("========================================");
                
                // Mostrar factura actual si hay productos
                if (!listaCompra.isEmpty()) {
                    nuevoCliente.mostrarFactura();
                    Collections.sort(listaCompra);
                    nuevoCliente.listar(listaCompra);
                }
                
                System.out.print("Presiona (s) para salir, (c) para continuar: ");
                bandera = scanner.nextLine().charAt(0);
                continue;
            }

            // Agregar producto a la lista y actualizar total
            nuevoProducto.setnombreProducto(nombre);
            nuevoProducto.setPrecio(precio);
            listaCompra.add(nuevoProducto);
            nuevoCliente.agregarAlTotal(precio);

            // Verificar si se consumió todo el saldo
            if (nuevoCliente.getMontoTotal() == nuevoCliente.getSaldo()) {
                System.out.println("****  CONSUMIÓ TODO EL SALDO DISPONIBLE  ****");
                nuevoCliente.mostrarFactura();
                Collections.sort(listaCompra);
                nuevoCliente.listar(listaCompra);
                break; // Salir del bucle
            }

            System.out.print("Presiona (s) para salir, (c) para continuar: ");
            bandera = scanner.nextLine().charAt(0);
            System.out.println("========================================");

        } while (bandera == 'c' || bandera == 'C');

        // Mostrar factura final si el usuario decide salir
        if ((bandera == 's' || bandera == 'S') && !listaCompra.isEmpty()) {
            nuevoCliente.mostrarFactura();
            Collections.sort(listaCompra);
            nuevoCliente.listar(listaCompra);
        }

        System.out.println("Gracias por su compra!");
        scanner.close();
    }
}