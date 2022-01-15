public class Botella extends Elemento {
    private static final Integer PESO_PROPIO = 4;
    private Elemento contenido;

    public Botella() {
        setPeso(PESO_PROPIO);
        generarNombre();
        setTipo(TipoElemento.RECIPIENTE);
    }    

    /**
     * Llena la botella con el liquido indicado agregando el peso del
     * nuevo liquido. Genera el nuevo nombre de la botella y actualiza
     * el peso.
     * 
     * Solo puede rellenarse cuando esta vacia. Si tiene contenido,
     * debe imprimir el mensaje:
     *    "<botella>: Se encuentra llena"
     * siendo <botella> el texto provisto por toString().
     * 
     * Si el elemento no es del tipo "liquido", debe imprimir el mensaje:
     *    "<botella>: No admite <elemento>"
     * siendo <botella> el texto provisto por toString() y <elemento> la
     * descripcion del elemento entregado (toString()).
     * 
     * @param liquido El liquido para rellenar la botella
     */
    public void llenarBotella (Elemento liquido) {

      if(isVacia()){

        if(liquido.getTipo().equals(TipoElemento.LIQUIDO)){

          contenido = liquido;
          generarNombre();
          setPeso(liquido.getPeso() + PESO_PROPIO);

        }else{
          
          System.out.println(this.toString() + ": No admite " + liquido.toString());

        }
        

      }else{

        System.out.println(this.toString() + ": Se encuentra llena");
      }
        
    }

    /**
     * Vacia el contenido de la botella y actualiza el peso.
     * La botella queda lista para recargar.
     * Genera el nuevo nombre de la botella.
     * 
     * @return El contenido de la botella.
     */
    public Elemento vaciarBotella () {
        Elemento cont = getContenido();
        this.contenido = null;
        setPeso(PESO_PROPIO);
        generarNombre();
        return cont;
    }

    /**
     * Establece la descripcion de la botella con su contenido
     * correspondiente, por ej. "Botella con Agua".
     * En caso de que no tenga contenido, utiliza el texto
     * "Botella vacia"
     */
    public void generarNombre () {
        if(!isVacia()){
            this.setNombre("Botella con " + getContenido().getNombre());
       
        }else{

            this.setNombre("Botella vacia");
        }
    }

    /**
     * Devuelve verdadero en caso de contener algun tipo de pocima
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener algun tipo de pocima.
     */
    public Boolean hasPocima () {
        
        if (getContenido() instanceof Pocima){
          return true;
        }

        return false;
    }

    /**
     * Devuelve verdadero en caso de contener agua
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener agua
     */
    public Boolean hasAgua () {
        if (getContenido() instanceof Agua){
          return true;
        }

        return false;
    }
  
    /**
     * Devuelve verdadero en caso de contener vino
     * y falso si esta vacia o contiene otro tipo de liquido.
     * 
     * @return true en caso de contener vino
     */
    public Boolean hasVino () {
        if (getContenido() instanceof Vino){
          return true;
        }

        return false;
    }
  
    /**
     * Devuelve verdadero o falso segun tenga o no contenido.
     * 
     * @return true en caso de estar vacia
     */
    public Boolean isVacia () { 
        return contenido == null;
    }

    public Elemento getContenido() {
        return contenido;
    }

    public void setContenido(Elemento contenido) {
        this.contenido = contenido;
    }

}