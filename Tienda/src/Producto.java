public class Producto implements Comparable<Producto>{
    private String nombreProducto;
    private double precio;

    public String getnombreProducto() {
        return nombreProducto;
    }

    public void setnombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto; // ✅ Corregido
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Producto item){
        return this.getnombreProducto().compareTo(item.getnombreProducto());
    }

    @Override
    public String toString(){
        return this.getnombreProducto() + " = $" + this.getPrecio();
    }
}