public class herencia {
    public static void main(String[] args){
    DLinkedList<Integer> stack = new DLinkedList<>();
    stack.pushBack(2);
    stack.pushBack(6);
    stack.pushBack(7);
    stack.pushBack(76);
    DNode<Integer> i = new DNode<>(0);
    i = stack.head;
    while(i != null){
        System.out.println(i.key);
        i = i.next;
    }
    System.out.println(stack.find(4));
    System.out.println("-----------------");
    //PRUEBAS
    }
}

class Node<T>{
    
    T key;
    Node<T> next;

    Node(T key){
        this.key = key;
        this.next = null;
    }

    public void setKey(T key){
        this.key = key;
    }

    public void setNext(Node<T> n){
        this.next = n;
    }

    public T getKey(){
        return this.key;
    }

    public Node<T> getNext(){
        return this.next;
    }
}

class LinkedList<T>{

    protected Node<T> head;
    protected Node<T> tail;

    public LinkedList(){
        head = tail = null;
    }

    public void pushFront(T element){
        Node<T> nodo = new Node<>(element);     //Creación del nodo                    
        nodo.next = head;                       //La direccion del head pasará a ser el next del nodo que pusheamos
        head = nodo;                            //Ahora el head será el nodo que pusheamos...si se hiciera al reves el nodo que ahora es nuestro head no tendría un next 
        if(tail == null)
            tail = head;
    }

    public T popFront(){
        if(head == null)
            throw new RuntimeException("La lista enlazada está vacía"); //En caso de que la lista esté vacía
        Node<T> p = head;
        head = head.next;   //La cabeza ahora será el nodo siguiente                                                             
        if(head == null){
            tail = null;
        }                   //Caso por si la lista enlazada tenia solo 1 elemento y lo eliminamos            
        return p.key;
    }

    public void pushBack(T element){
        Node<T> nodo = new Node<>(element);
        nodo.key = element;
        nodo.next = null;
        if(tail == null){
            head = nodo;
            tail = nodo;
        }
        else{
            tail.next = nodo;
            tail = nodo;
        }
    }

    public T popBack(){
        if(tail == null)
            throw new RuntimeException("La lista ya está vacía");
        if(head == tail){
            head = tail = null;
            return null;
        }
        else{
        Node<T> p = tail;
        Node<T> current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        tail = current;
        return p.key;
        }
    }

    public void addAfter(Node<T> current, T value){
        if(empty())
            throw new RuntimeException("La lista ya está vacía, no se puede añadir después de nada");
        Node<T> nodo = new Node<T>(value);
        nodo.next = current.next;
        current.next = nodo;
        if(tail == current)
            tail = nodo;         
    }

    public T erase(T keyToRemove) {
    if (head == null) {
        throw new RuntimeException("La lista está vacía");
    }

    if (head.key == keyToRemove) {
        T removedValue = head.key;
        head = head.next;
        return removedValue;
    }

    Node<T> current = head;
    while (current.next != null) {
        if (current.next.key == keyToRemove) {
            T removedValue = current.next.key;
            current.next = current.next.next;
            return removedValue;
        }
        current = current.next;
    }
    throw new RuntimeException("Elemento no encontrado");
}

    public T findint(T keyToFind) {
    Node<T> current = head;
    while (current != null) {
        if (current.key == keyToFind) {
            return current.key;         // Elemento encontrado, retorna el valor
        }
        current = current.next;
    }
    return null;                        // Elemento no encontrado, retorna null como valor especial
    }

    public boolean findboolean(T keyToFind) {
    Node<T> current = head;
    while (current != null) {
        if (current.key == keyToFind) {
            return true;                // Elemento encontrado, retorna el valor
        }
        current = current.next;
    }
    return false;                       // Elemento no encontrado, retorna -1 como valor especial
    }

    public boolean empty(){
        return head == null;
    }
}


class ListQueue<T> extends LinkedList<T>{
    private int count;

    ListQueue(){                       //El array por defecto tiene head y tail = 0, la cola tendrá i espacios para elementos
        super();
        count = 0;      
    }

    public void enqueue(T element){
        pushBack(element);
        count++;                    //En caso de que el tail sea igual o mas grande que la length de la cola, este sera pasado por un modulo,
    }                               //es decir, si tail y length = 4, el modulo hará a tail 0, si el tail es 5, pasará a ser 1

    public T dequeue(){
        T primero;
        primero = popFront();
        count--;
        return primero;
    }

    @Override 
    public boolean empty(){
        return count <= 0;
    }

}

class ListStack<T> extends LinkedList<T>{
    
    private int top;                   //Indica la posicion en donde se insertará un elemento

    ListStack(){
        super();
        top = 0;                       //La posición inicial de los elementos será 0
    }

    public void push(T element){
        pushBack(element);          //Se llena la posicion top
        top++;                      //Se incrementa un espacio
    }

    public T pop(){
        T ultimo;
        ultimo = popBack();
        top--;                      //Se reduce el top
        return ultimo;              //retorna el elemento que quitamos, no es necesario hacerlo null ya que al hacer un push por ejemplo, este será reemplazado (-operaciones, + eficiencia)
    }

    public boolean empty(){
        return top <= 0;            //El top al ser 0 es vacio ya que es la posicion inicial del array
    }

    public T peek(){
        return tail.key;
    }
}

class DNode<T>{
    DNode<T> next;
    DNode<T> prev;
    T key;

    DNode(T key){
        this.key = key;
    }

    public T getKey(T key){
        return this.key;
    }

    public void setKey(T key){
        this.key = key;
    }

    public DNode<T> getNext(){
        return this.next;
    }

    public void setNext(DNode<T> n){
        this.next = n;
    }

    public DNode<T> getPrevious(){
        return this.prev;
    }

    public void setPrevious(DNode<T> p){
        this.prev = p;
    }
}

class DLinkedList<T>{
    protected DNode<T> head;
    protected DNode<T> tail;

    public DLinkedList(){
        head = null;
        tail = null;
    }

    public void pushFront(T element){
        DNode<T> nodo = new DNode<>(element);
        nodo.next = head;
        head.prev = nodo;
        head = nodo;
        if(tail == null)
            tail = head;
    }

    public T popFront(){
        if(head == null)
            throw new RuntimeException("La Lista enlazada doble ya está vacía");
        DNode<T> p = head;
        head = head.next;
        head.prev = null; //Puede que no sea necesario este paso
        if(head == null)
            tail = null;
        return p.key;
    }

    public void pushBack(T element){
        DNode<T> nodo = new DNode<>(element);
        if(tail == null){
            head = tail = nodo;
        }
        else{
            tail.next = nodo;
            nodo.prev = tail;
            tail = nodo;
        }
    }

    public T popBack(){
        if(tail == null)
            throw new RuntimeException("La lista enlazada doble ya está vacía");
        DNode<T> p = tail;
        tail = tail.prev;
        tail.next = null; //Puede que no sea necesario este paso
        if(tail == null)
            head = null;
        return p.key;
    }

    public void addAfter(DNode<T> current, T element){
        DNode<T> nodo = new DNode<>(element);
        nodo.next = current.next;
        nodo.prev = current;
        current.next = nodo;
    }

    public void affBefore(DNode<T> current, T element){
        DNode<T> nodo = new DNode<>(element);
        nodo.next = current;
        nodo.prev = current.prev;
        current.prev = nodo;
    }

    public boolean find(T keytofind){
        DNode<T> nodo = head;
        while(nodo != null){
            if(nodo.key == keytofind){
                return true;
            }
            nodo = nodo.next;
        }
        return false;
    }

    public boolean empty(){
        return head == null;
    }
}