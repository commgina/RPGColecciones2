class Main {
  public static void main(String[] args) {
        System.out.println("Proyecto Heroe");
        // Personaje p = new Personaje("Gandalf",100,30);
        // Bolsa b = new Bolsa ("Bolsa pequenia",10);

        // Ejemplo de uso - Funciona cuando Habitacion tiene constructor
        // Mapa mapa = Mapa.getInstance();
        // System.out.println(mapa.getInicio().getNombre());
        
        Personaje mago = new Personaje("Gandalf", 100, 260);
        Bolsa bolsa = new Bolsa("Mochila",150);
        mago.setBolsa(bolsa);
        mago.mirarAlrededor();
        mago.recogerElemento("Carcaj chico");
        mago.guardarElemento();
        mago.recogerElemento("Arco");
        System.out.println(mago.getNombre() + " " + mago.getElemento());
        // No puede continuar la ejecucion hasta implementar Habitacion
        mago.mirarAlrededor();
        mago.irHacia(Salida.NORTE);
        mago.mirarAlrededor();
        mago.irHacia(Salida.OESTE);
        mago.mirarAlrededor();
        mago.recogerElemento("Pluma");
        mago.recogerElemento("Botella");
        System.out.println("Bolsa: " + bolsa.getListaElementosEnLaBolsa());
  }
}