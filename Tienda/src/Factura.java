import java.util.ArrayList;

public class Factura {
    private double saldo;

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

    public void mostrarFactura(){
        System.out.println("========================================");
        System.out.println("        >>>FACTURA DE COMPRAS<<<");
        System.out.println("========================================");
    }

    public void listar(ArrayList<Producto> lista){
        int contador=1;

        for (Producto compra : lista){
            System.out.println(contador+"."+ compra.getnombreProducto()+ " = "+ compra.getPrecio());
            contador++;
        }
    }


}
