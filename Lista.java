public class Lista {
    Nodo inicio = null;

    public void insertar (int dato){
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        if (inicio != null){
            nuevo.siguiente = inicio;
        }
        inicio = nuevo;

    }

    public void imprimir(){
        Nodo aux = inicio;
        while(aux != null){
            System.out.println(aux.dato + " ");
            aux = aux.siguiente;
        }
    }

    //Obtenemos el numero mas grande de la lista
    public int numeroMasGrande(Nodo incio){
        Nodo aux = inicio;
        int digitoMasGrande = aux.dato;
        while (aux != null){
            if (aux.dato > digitoMasGrande){
                digitoMasGrande = aux.dato;
            }
            aux = aux.siguiente;
        }
        return digitoMasGrande;
    }

    //Contamos los digitos del numero mas grande
    public int numerDeDigitos(){
        int digitos = numeroMasGrande(inicio);
        int i = 0;
        while (digitos != 0){
            digitos /= 10;
            i++;
        }
        return i;
    }

    public int[] mat(){
        int[] radix = new int[elementos()+1];
        Nodo aux = inicio;
        while (aux != null){
            int i = 0;
            radix[i] = aux.dato;
            aux = aux.siguiente;
            i++;
        }
        return radix;
    }

    public void Radix(int matriz[], int tamaño, int lugar ){
        int[] output = new int[tamaño + 1];
        int max = matriz[0];
        for (int i = 1; i < tamaño; i++) {
            if (matriz[i] > max)
                max = matriz[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        for (int i = 0; i < tamaño; i++)
            count[(matriz[i] / lugar) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = tamaño - 1; i >= 0; i--) {
            output[count[(matriz[i] / lugar) % 10] - 1] = matriz[i];
            count[(matriz[i] / lugar) % 10]--;
        }

        for (int i = 0; i < tamaño; i++) {
            matriz[i] = output[i];
            //System.out.println(output[i]);
        }


    }

    public void recorrer(){

    }

    public void radixSort(){
        int max = numeroMasGrande(inicio);

        for (int lugar = 1; max/lugar > 0; lugar*=10) {
            Radix(mat(), numerDeDigitos(), lugar);
        }
    }

    public int elementos(){
        Nodo aux = inicio;
        int i = 0;
        while (aux != null){
            i++;
            aux = aux.siguiente;
        }
        return i;
    }

}
