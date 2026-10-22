public class MatrizCompleja {
    private double[][] matriz;
    
    public MatrizCompleja(int filas, int columnas) {
        this.matriz = new double[filas][columnas];
    }
    
    public double[][] getMatriz() {
        return matriz;
    }
    
    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }
    
    public MatrizCompleja sumar(MatrizCompleja otraMatriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        MatrizCompleja resultado = new MatrizCompleja(filas, columnas);
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[i][j] = this.matriz[i][j] + otraMatriz.matriz[i][j];
            }
        }
        return resultado;
    }
    
    public MatrizCompleja multiplicar(MatrizCompleja otraMatriz) {
        int filas = matriz.length;
        int columnas = otraMatriz.matriz[0].length;
        int medio = matriz[0].length;
        MatrizCompleja resultado = new MatrizCompleja(filas, columnas);
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < medio; k++) {
                    resultado.matriz[i][j] += this.matriz[i][k] * otraMatriz.matriz[k][j];
                }
            }
        }
        return resultado;
    }
    
    public void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("]");
        }
    }
    
    
    public static void main(String[] args) {
        
        MatrizCompleja matriz1 = new MatrizCompleja(2, 2);
        matriz1.matriz[0][0] = 1;
        matriz1.matriz[0][1] = 2;
        matriz1.matriz[1][0] = 3;
        matriz1.matriz[1][1] = 4;
        
        MatrizCompleja matriz2 = new MatrizCompleja(2, 2);
        matriz2.matriz[0][0] = 5;
        matriz2.matriz[0][1] = 6;
        matriz2.matriz[1][0] = 7;
        matriz2.matriz[1][1] = 8;
        
        System.out.println("Matriz 1:");
        matriz1.imprimirMatriz();
        
        System.out.println();
        
        System.out.println("Matriz 2:");
        matriz2.imprimirMatriz();
        
        System.out.println();
        
        System.out.println("Suma:");
        MatrizCompleja suma = matriz1.sumar(matriz2);
        suma.imprimirMatriz();
        
        System.out.println();
        
        System.out.println("Multiplicacion:");
        MatrizCompleja producto = matriz1.multiplicar(matriz2);
        producto.imprimirMatriz();
    }
}