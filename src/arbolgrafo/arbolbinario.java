package arbolgrafo;
class Nodoo {
    private int d;
    private Nodoo iz, de;
    public Nodoo (int d) {
        this.d = d;
        this.iz = this.de = null;
    }
// referencia a un Nodo izquierda y a otro nodo derecha
    public int getDato() {
        return d;
    }
    public Nodoo getIzquierda() {
        return iz;
    }
    public void setIzquierda(Nodoo iz) {
        this.iz = iz;
    }
    public Nodoo getDerecha() {
        return de;
    }
    public void setDerecha(Nodoo de) {
        this.de = de;
    }
//dato que guarda cada nodo
    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}
class Arbol {
    private Nodoo r;
    public Arbol() {
    }
    //Busqueda
    //crear una función que indica si determinado dato existe o no dentro del árbol.
    public boolean existe(int busqueda) {
        return existe(this.r, busqueda);
    }
    private boolean existe(Nodoo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato() == busqueda) {
            return true;
            //se busca el valor por todos los izquierdos
        } else if (busqueda < n.getDato()) {
            return existe(n.getIzquierda(), busqueda);
        } else {
        	//se busca el valor por todos los derechos
            return existe(n.getDerecha(), busqueda);
        }
    }
    //Insertar
    //si la raíz no tiene dato, se le asigna un valor

    public void insertar(int dato) {
        if (this.r == null) {
            this.r = new Nodoo(dato);
        } else {
            this.insertar(this.r, dato);
        }
    }
    //Si el dato es mayor que el dato de la raíz, entonces se coloca en la derecha
    private void insertar(Nodoo padre, int dato) {
        if (dato > padre.getDato()) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodoo(dato));
            } else {
            	
            	this.insertar(padre.getDerecha(), dato);
            }
          //Si el dato es menor que el dato de la raíz, entonces se coloca en la izquierda
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodoo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }
    //Recorrido
    //se visita el actual, luego el izquierdo y luego el derecho.
    private void preorden(Nodoo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }    
    //primero se visitan todos los nodos izquierda, luego el central y finalmente el de la derecha.
    private void inorden(Nodoo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }
    //primero recorre la izquierda, luego la derecha y finalmente el nodo actual.
    private void postorden(Nodoo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }
    public void preorden() {
        this.preorden(this.r);
    }
    public void inorden() {
        this.inorden(this.r);
    }
    public void postorden() {
        this.postorden(this.r);
    }
}
//insertar los datos previamente dados
class Main {
     public static void main(String[] argumentos) {
        Arbol arbol = new Arbol();
        arbol.insertar(68);
        arbol.insertar(15);
        arbol.insertar(6);
        arbol.insertar(8);
        arbol.insertar(1);
        System.out.println("Recorriendo inorden:");
        arbol.inorden();
        System.out.println("Recorriendo postorden:");
        arbol.postorden();
        System.out.println("Recorriendo preorden:");
        arbol.preorden();
        //Buscar valores previamentes definidos
        System.out.println(arbol.existe(9)); // No esta
        System.out.println(arbol.existe(7)); // No esta
        System.out.println(arbol.existe(8)); // Si esta
    }
}