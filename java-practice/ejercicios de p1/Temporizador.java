public class Temporizador {
    private int tiempo;
    
    public Temporizador(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public int getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public void iniciar() {
        System.out.println("Temporizador iniciado en: " + tiempo + " segundos");
    }
    
    public void detener() {
        System.out.println("Temporizador detenido en: " + tiempo + " segundos");
    }
    
    public void reiniciar() {
        tiempo = 0;
        System.out.println("Temporizador reiniciado a: " + tiempo + " segundos");
    }
    
    
    public static void main(String[] args) {
        
        Temporizador temp1 = new Temporizador(60);
        Temporizador temp2 = new Temporizador(120);
        
        temp1.iniciar();
        temp1.setTiempo(45);
        temp1.detener();
        temp1.reiniciar();
        
        System.out.println();
        
        temp2.iniciar();
        temp2.setTiempo(90);
        temp2.detener();
        temp2.reiniciar();
    }
}
