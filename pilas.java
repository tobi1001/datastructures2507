public class pilas{
    public static void main(String[] args){
        Sarray<Integer> pila1= new Sarray<>();
        pila1.push(1);
        pila1.push(1);
        pila1.push(1);
        pila1.push(1);

        for(int i = 0; i<=4;i++){
            System.out.println(pila1[i]); //dará error puesto que pila1 no es un arreglo, no tiene indices
        }
    }
}

@SuppressWarnings("unchecked")

class Sarray<T>{

    private int top;//indica la posicion en donde se insertará un elemento
    private T[] sarray;


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