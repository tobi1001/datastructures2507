public class pilas{
    public static void main(String[] args){
        Sarray<Integer> pila1= new Sarray<>();
        pila1.push(1);
        System.out.println(pila1.sarray[0]); //Visualizar la posicion 0 del sarray, ya veremos que pasa al unir master y testssarray 
    }
}

@SuppressWarnings("unchecked")

class Sarray<T>{

    int top;//indica la posicion en donde se insertará un elemento
    T[] sarray;


    Sarray(int i){
        top = 0;//la posicion inicial de los elementos será 0
        sarray = (T[]) new Object[i];//lista con tamaño en el argumento del constructor
    }

    Sarray(){
        this(4);//el constructor sin argumentos hará a la lista de tamaño 4
    }

    public void push(T element){
        if(full())
            throw new RuntimeException("La pila ya está llena");
        sarray[top] = element;//se llena la posicion top
        top++;  //se incrementa un espacio
    }

    public T pop(){
        if(empty())
            throw new RuntimeException("La pila ya está vacía");
        top--;              //se reduce el top
        return sarray[top]; //retorna el elemento que quitamos, no es necesario hacerlo null ya que al hacer un push por ejemplo, este será reemplazado (-operaciones, + eficiencia)
    }

    public boolean full(){
        return top >= sarray.length; //el top solo puede ser igual al length, el ">" es solo una medida preventiva
    }

    public boolean empty(){
        return top <= 0;//el top al ser 0 es vacio ya que es la posicion inicial del array
    }
}