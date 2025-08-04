public class Producto implements Comparable<Producto>{
    private String nombreProducto;
    private double precio;
    private double montoTotal;

    public String getnombreProducto() {
        return nombreProducto;
    }

    public void setnombreProducto(String producto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        this.montoTotal += precio;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    @Override
    public int compareTo(Producto item){
        return this.getnombreProducto().compareTo(item.getnombreProducto());
    }

    @Override
    public String toString(){
        return this.getnombreProducto() + " = " + this.getPrecio();
    }
}

