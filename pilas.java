public class pilas{
    public static void main(String[] args){
        Sarray<Integer> pila1= new Sarray<>();
        pila1.push(1);
    }
}

@SuppressWarnings("unchecked")

class Sarray<T>{

    private int top;
    private T[] sarray;


    Sarray(int i){
        top = 0;
        sarray = (T[]) new Object[i];
    }

    Sarray(){
        this(4);
    }

    public void push(T element){
        if(full())
            throw new RuntimeException("La pila ya está llena");
        sarray[top] = element;
        top++;
    }

    public T pop(){
        if(empty())
            throw new RuntimeException("La pila ya está vacía");
        top--;
        return sarray[top];
    }

    public boolean full(){
        return top >= sarray.length;
    }

    public boolean empty(){
        return top <= 0;
    }
}