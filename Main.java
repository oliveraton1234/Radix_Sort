import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        /*
        lista.insertar(12);
        lista.insertar(21);
        lista.insertar(12312);
        lista.radixSort();
        
        */
        for(int i = 0; i < 1000001; ++i){
            Random R = new Random();
            int x = R.nextInt(100001);

            lista.insertar(x);
        }

        lista.radixSort();
        lista.recorrer();
        

    }
}
