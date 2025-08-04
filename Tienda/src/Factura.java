import java.util.ArrayList;

public class Factura {
    private double saldo;
    private double montoTotal = 0.0; // ✅ Agregado para llevar el total

    public void mensajeInicio(){
        System.out.println("========================================");
        System.out.println("        Sistema de Compras Cajero");
        System.out.println("========================================");
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void agregarAlTotal(double precio) {
        this.montoTotal += precio;
    }

    public void mostrarFactura(){
        System.out.println("========================================");
        System.out.println("        >>>FACTURA DE COMPRAS<<<");
        System.out.println("========================================");
    }

    public void listar(ArrayList<Producto> lista){
        int contador = 1;
        for (Producto compra : lista){
            System.out.println(contador + ". " + compra.toString()); // ✅ Usando toString()
            contador++;
        }
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL: $%.2f\n", montoTotal);
        System.out.printf("SALDO RESTANTE: $%.2f\n", (saldo - montoTotal));
        System.out.println("========================================");
    }
}