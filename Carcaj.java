import java.util.ArrayList;
import java.util.List;

/**
 * Modela el Carcaj que lleva el personaje para
 * tranportar sus flechas.
 */
public class Carcaj extends Elemento {
    private final Integer PESO_PROPIO = 10;
    private Integer capacidad;
    private List<Flecha> flechas;

    /**
     * Constructor para un Carcaj generico chico. Su capacidad
     * es de 5 flechas pero se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     */
    public Carcaj() {
        
        super("Carcaj chico",PESO_PROPIO,TipoElemento.RECIPIENTE);
        this.capacidad = 5;
        flechas = new ArrayList<>();
        
    }

    /**
     * Constructor para un Carcaj de nombre y capacidad indicados
     * por parametro.  Se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     * 
     * @param nombre El nombre del carcaj.
     * @param capacidad Cantidad maxima de flechas.
     */
    public Carcaj(String nombre, Integer capacidad) {
       super(nombre,super.setPeso(PESO_PROPIO),TipoElemento.RECIPIENTE);
       this.capacidad = capacidad;
       flechas = new ArrayList<>();
    }

    /**
     * Agrega una flecha al carcaj.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no tiene capacidad disponible, debe imprimir
     *     "<nombre>: Capacidad completa"
     * donde <nombre> es el nombre del carcaj.
     * 
     * Si el elemento a agregar no es una flecha, debe imprimir:
     *     "<nombre>: No es una flecha"
     * donde <nombre> es el nombre del elemento entregado.
     * 
     * @param flecha La flecha a agregar.
     */
    public void addFlecha (Elemento flecha) {
        
        
        if(getCapacidad() > 0){
          if(flecha instanceof Flecha){
              flechas.add((Flecha)flecha);
              addPeso(flecha.getPeso());
          }else{

            System.out.println(flecha.getNombre() + ": No es una flecha");
          }
          
        }else{

          System.out.println(this.getNombre() + ": Capacidad completa");
        }
        
    }

    /**
     * Quita del carcaj una flecha.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no hay mas flechas, devuelve null y debe imprimir:
     *      "<nombre>: No quedan flechas"
     * donde <nombre> es el nombre del carcaj.
     * 
     * @return Una flecha.
     */
    public Flecha getFlecha () {
        Flecha f = new Flecha();
        if(getCantidadFlechas() == 0){
          System.out.println(this.getNombre() + ": No quedan flechas");
          return null;
        }else{

          f = flechas.get(getCantidadFlechas() - 1);
          flechas.remove(getCantidadFlechas() - 1);
          addPeso(-(f.getPeso()));
        }
        return f;
    }

    /**
     * Modifica el peso del carcaj.
     * Puede sumar o restar peso.
     * 
     * @param peso El peso a modificar.
     */
    public void addPeso (Integer peso) {
        this.setPeso(this.getPeso() + peso);
    }

    /**
     * Devuelve informacion sobre el carcaj de la forma:
     *     "<nombre>: Flechas <cant>/<max>"
     * donde <nombre> es el nombre del carcaj,
     * <cant> es la cantidad de flechas que contiene y
     * <max> la capacidad maxima.
     */
    @Override        
    public String toString() {
        String info = this.getNombre() + ": Flechas " + this.getCantidadFlechas() + "/" + this.getCapacidad();
        return info;
    }

    public Integer getCantidadFlechas () {
        return flechas.size();
    }

    public Integer getCapacidad () {
        return capacidad;
    }
    
}
