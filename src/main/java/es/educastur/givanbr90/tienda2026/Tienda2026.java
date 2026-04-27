/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.educastur.givanbr90.tienda2026;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.print.attribute.HashAttributeSet;

/**
 *
 * @author 1dawd17
 */
public class Tienda2026 implements Serializable {

    public static transient Scanner sc = new Scanner(System.in);

    private ArrayList<Pedido> pedidos;
    private HashMap<String, Articulo> articulos; //String es la clave primaria de la base de datos, es obligatorio ponerlo, luego ponemos el objeto completo
    private HashMap<String, Cliente> clientes;

    public Tienda2026() {
        pedidos = new ArrayList();//Inicializamos los datos vacíos
        articulos = new HashMap();
        clientes = new HashMap();
    }

    public ArrayList<Pedido> getPedidos() { //SIN ESTOS GET NO PODEMOS HACER TESTS DE JUNIT
        return pedidos;
    }

    public HashMap<String, Articulo> getArticulos() {   //SIN ESTOS GET NO PODEMOS HACER TESTS DE JUNIT
        return articulos;
    }

    public HashMap<String, Cliente> getClientes() { //SIN ESTOS GET NO PODEMOS HACER TESTS DE JUNIT
        return clientes;
    }

    public static void main(String[] args) {

        Tienda2026 t = new Tienda2026();
        /*Estamos declarando el proyecto como un objeto que contiene los demás métodos, su contructor estrará formado por el cargaDatos que las va arrancar desde 0
        -En el main declaramos el objeto Tienda2026 t, por lo tanto, todos los 
        -Nos permite que los métodos no sean static ya que todos los métodos le pertenecen a ese objeto*/

 /*
        1-t.cargaDatos con importar comentado
        2-exportar siempre lo último para evitar guardar las collecciones sin datos
        3-Una vez hecho el exportar ejecutamos de nuevo con el carga datos comentado y el importar descomentado
        De esta manera ya no necesitamso el carga datos ya que accedemos a los datos mendiante las colecciones ya creadas en binario*/
        //t.cargaDatos(); //Se cambia el cargaDatos para hacer el examen
        t.importarColecciones(); //hay que descomentarlos luego
        //t.archivos();
        //t.leeCliente();
        //t.gauardaArtPorSeccion();
        //t.leeArticulosPorSeccion();
        //t.importarSeccion();
        //t.menu(); //hay que descomentarlos luego
        //t.exportarColecciones(); //hay que descomentarlos luego
        //t.leerSeccion();
        //t.exportarSeccion(); //hay que descomentarlos luego
        //t.leerSeccion(); //hay que descomentarlos luego
        /*t.uno();
        t.dos();
        t.tres();
        
        t.cuatro();
        t.cinco();
        //Si hacemos los métodos estáticos podemos llamarlos de la siguiente manera, sin necesidad del menú, esto es lo que va haber que entregar
        uno();
        -private static void uno(){
        }
         */
        //t.uno1();
        //t.dos2();
        //t.tres3();
        t.cuatro4();
        t.cinco5();
 /*System.out.println(t.udsVendidas1(t.articulos.get("4-33")));
        System.out.println(t.udsVendidas2(t.articulos.get("4-33")));
        System.out.println(t.udsVendidas3(t.articulos.get("4-33")));*/

 /*Persistencia de toda la tienda, archivos binarios que empaquetan todas las referencias de memoria de todos los objetos de la tienda, es demasiado tosco hacerlo todo de una vez, es mejor hacerlo de objeto a objeto
        Esto no es recomendable porque se pueden perder datos por el camino haciendo que pueda fallar el ejercicio
        try (ObjectOutputStream oosTienda = new ObjectOutputStream(new FileOutputStream("tienda.dat"))) {
            oosTienda.writeObject(t);
            System.out.println("TODO OK");

        } catch (Exception ex) {
            System.out.println("No se ha podido realizar la copia de Seguridad correspodiente, " + "revisa unidades de almacenamiento de nuevo");
            File f = new File("tienda.dat");
            f.delete();
        }*/
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos auxiliares">
    /**
     * Carga datos de prueba en las colecciones principales de la tienda
     * 
     * Inicializa clientes, artículos y pedidos con información ya preparada
     * para poder probar el programa sin necesidad de introducir todos los datos
     * por teclado al arrancar la aplicación.
     */
    public void cargaDatos() {
        
        //Añadimos clientes al HashMap usando el DNI como clave
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("80580845T", new Cliente("80580845T", "ANA", "658111111", "ana@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        //Añadimos artículos al catálogo usando el idArticulo como clave
        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 0, 15));
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 5, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 15, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-11", new Articulo("3-11", "HP LASERJET HP800 ", 2, 200));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        LocalDate hoy = LocalDate.now();
        //Creamos pedidos de ejemplo asociados a clientes y artículos y existentes
        pedidos.add(new Pedido("80580845T-001/2026", clientes.get("80580845T"), LocalDate.parse("2026-01-05"), new ArrayList<>(List.of(new LineaPedido(articulos.get("1-11"), 3), new LineaPedido(articulos.get("4-22"), 3)))));
        pedidos.add(new Pedido("80580845T-002/2026", clientes.get("80580845T"), LocalDate.parse("2026-01-10"), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-11"), 3), new LineaPedido(articulos.get("4-22"), 2), new LineaPedido(articulos.get("4-33"), 4)))));
        pedidos.add(new Pedido("80580845T-003/2026", clientes.get("80580845T"), LocalDate.parse("2026-01-15"), new ArrayList<>(List.of(new LineaPedido(articulos.get("2-11"), 1), new LineaPedido(articulos.get("3-22"), 2)))));
        pedidos.add(new Pedido("36347775R-001/2026", clientes.get("36347775R"), LocalDate.parse("2026-02-05"), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-22"), 1), new LineaPedido(articulos.get("2-22"), 3)))));
        pedidos.add(new Pedido("36347775R-002/2026", clientes.get("36347775R"), LocalDate.parse("2026-02-10"), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-33"), 3), new LineaPedido(articulos.get("2-11"), 3)))));
        pedidos.add(new Pedido("63921307Y-001/2026", clientes.get("63921307Y"), LocalDate.parse("2026-03-05"), new ArrayList<>(List.of(new LineaPedido(articulos.get("2-11"), 5), new LineaPedido(articulos.get("2-33"), 3), new LineaPedido(articulos.get("4-33"), 2)))));
    }

    /**
     * Comprueba si hay stock de un artículo para realizar una compra.
     * 
     * Este método valora las posibles excepciones de stock. Valida dos posibles
     * situaciones o que las unidades solicitadas sean superiores al stock
     * disponibble. En ambos casos se lanzan excepciones personaizadas.
     *
     * @param a artículo de que queremos comprobar el stock disponible
     * @param unidades número de unidades solicitadas por el cliente
     * @throws StockCero si el artículo no tiene existencias
     * @throws StockInsuficiente si el stock es menor que las unidades solicitadas
     */
    public void stock(Articulo a, int unidades) throws StockCero, StockInsuficiente {//Lanza las excepciones que hemos creado, ve las unidades del articulo que le pidamos

        //SE ACTUALIZA EL MÉTODO DE STOCK ENVIANDO DIRECTAMENTE EL ARTICULO COMO OBJETO ENTERO EN LUGAR DEL ID, SE SIMPLIFICA EL CÓDIGO Y SE HACE MÁS ELEGANTE (24/02/2026)
        //Cuando no quedan unidades lanza esta alarma, dando la info del throw
        if (a.getExistencias() == 0) {
            throw new StockCero("0 unidades disponibles de:"
                    + a.getDescripcion());
        }

        //Cuando nos piden más unidades de las que tenemos lanzamos esta excepción
        if (a.getExistencias() < unidades) {
            throw new StockInsuficiente("Sólo hay " + a.getExistencias() + " unidades disponibles de: "
                    + a.getDescripcion());
        }
    }

    /**
     * Calcula el total de unidades vendidas de un artículo concreto.
     *
     * Recorre todos los pedidos de la tienda y suma las unidades de aquellas
     * líneas de pedido cuyo artículo coincide con el artículo recibido.
     * 
     * @param a artículo del que queremos conocer las unidades vendidas
     * @return total de unidades vendidas de ese artículo
     */
    private int udsVendidas(Articulo a) {
        int total = 0;
        
        for (Pedido p : pedidos) { //Recorremos todos los pedidos de la tienda
            for (LineaPedido l : p.getCestaCompra()) { //Recorremos cada línea de la cesta del pedido
                
                //Si la línea corresponde al artículo buscado, sumamos sus unidades
                if (l.getArticulo().equals(a)) {
                    total += l.getUnidades();                  
                }
            }
        }
        return total;

    }

    /**
     * Calcula el importe total gastado por un cliente usando streams
     * 
     * Filtra los pedidos realizados por el cliente recibido como parámetro
     * y suma el total monetario de cada pedido mediante el método auxiliar
     * totalPedido().
     * 
     * @param c cliente de que queremos calcular el gasto total
     * @return importe total gastado por el cliente
     */
    //Total gastado por un Cliente
    public double totalCliente2(Cliente c) {
        //Filtramos los pedidos del cliente y sumamos el total de cada uno con el .sum
        return pedidos.stream().filter(p -> p.getClientePedido().equals(c))
                .mapToDouble(p -> totalPedido(p)).sum();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Menús">
    public void menu() {
        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES");
            System.out.println("\t\t\t\t1 - ARTICULO");
            System.out.println("\t\t\t\t2 - CLIENTE");
            System.out.println("\t\t\t\t3 - PEDIDOS");
            System.out.println("\t\t\t\t4 - LISTAR COLECCIONES");
            System.out.println("\t\t\t\t5 - LISTAR COLECCIONES CON STREAMS");
            System.out.println("\t\t\t\t6 - ORDENAR COLECCIONES CON STREAMS");
            System.out.println("\t\t\t\t7 - EJERCICIOS PUENTE");
            System.out.println("\t\t\t\t8 - EJERCICIOS FLATMAP");
            System.out.println("\t\t\t\t9 - EJERCICIOS COLECCIONES");
            System.out.println("\t\t\t\t10 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    menuArticulo();
                    break;
                }
                case 2: {
                    menuCliente();
                    break;
                }
                case 3: {
                    menuPedido();
                    break;
                }
                case 4: {
                    listarColecciones();
                    break;
                }
                case 5: {
                    listadosConStreams();
                    break;
                }
                case 6: {
                    ordenarConStream();
                    break;
                }
                case 7: {
                    ejsPuente();
                    break;
                }
                case 8: {
                    ejsFlatMap();
                    break;
                }
                case 9: {
                    coleccion();
                    break;
                }

            }

        } while (opcion != 10);

        /* Estamos creando un menú de opciones, dichas opciones son introducidas por teclado y están contenidas en los diferentes métodos para actualizar la información de la agenda
          - Se debe declarar una variable de tipo int para poder navegar en el menú
          - Se declaran "souts" para hacer visibles las posibles opciones
          - Se pide que introduzcan la opción a ejecutar por teclado
          1- Este método permite crear un nuevo contacto
          2- Permite listar todos los contactos, ya sea después de haber creado un contacto o solo para mostrarla
          3- Permite modificar/actualizar datos de un contacto, es decir, actualizar un atributo
          4- Permite borrar un contacto que ya no necesite
          9- Permite salir del bucle del menú*/
    }

    //<editor-fold defaultstate="collapsed" desc="Menú Artículos">
    public void menuArticulo() {
        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE ARTICULOS");
            System.out.println("\t\t\t\t1 - ALTA");
            System.out.println("\t\t\t\t2 - BAJA");
            System.out.println("\t\t\t\t3 - REPOSICIÓN");
            System.out.println("\t\t\t\t4 - LISTAR ARTICULOS");
            System.out.println("\t\t\t\t9 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    altaArticulo();
                    break;
                }
                case 2: {
                    bajaArticulo();
                    break;
                }
                case 3: {
                    reposicionArticulo();
                    break;
                }
                case 4: {
                    listarArticulos();
                    break;
                }

            }

        } while (opcion != 9);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Menú Cliente">
    public void menuCliente() {
        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE CLIENTES");
            System.out.println("\t\t\t\t1 - ALTA");
            System.out.println("\t\t\t\t2 - BAJA");
            System.out.println("\t\t\t\t3 - MODIFICACION CLIENTE");
            System.out.println("\t\t\t\t4 - LISTAR CLIENTES");
            System.out.println("\t\t\t\t9 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    altaCliente();
                    break;
                }
                case 2: {
                    bajaCliente();
                    break;
                }
                case 3: {
                    modificarDatos();
                    break;
                }
                case 4: {
                    listarClientes();
                    break;
                }

            }

        } while (opcion != 9);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Menú Pedido">
    public void menuPedido() {
        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE PEDIDOS");
            System.out.println("\t\t\t\t1 - NUEVO PEDIDO");
            System.out.println("\t\t\t\t2 - LISTADO DE PEDIDOS");
            System.out.println("\t\t\t\t9 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    nuevoPedido();
                    break;
                }
                case 2: {
                    listadoPedido();
                    break;
                }

            }

        } while (opcion != 9);
    }
//</editor-fold>

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Listado tradicional">
    /**
     * Listado de colecciones con for each.
     */
    public void listarColecciones() {
        
        /*System.out.println("Vamos a mostrar todos los artículos de la tienda");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
        }*/
        
        System.out.println("\nVamos a mostrar todos los clientes de la tienda: ");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
            //System.out.print("\n" + l.getIsbn() + "/" + l.getTitulo() + "/" + l.getAutor() + "/" + l.getGenero());
        }
        
        //Mostramos todos los artículos de la tienda, activos e inactivos
        System.out.println("\nVamos a mostrar todos los articulos de la tienda: ");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
            //System.out.print("\n" + a.getidArticulo() + "/" + a.getdescripción() + "/" + a.getexistencias() + "/" + a.getpvp());
        }
        
        ////Mostramos los artículos activos de la tienda
        System.out.println("\nVamos a mostrar los articulos activos de la tienda: ");
        for (Articulo a : articulos.values()) {
            if (a.isActivo()) {
                System.out.println(a);
                //System.out.print("\n" + a.getidArticulo() + "/" + a.getdescripción() + "/" + a.getexistencias() + "/" + a.getpvp());
            }
        }
        
        System.out.println("\nVamos a mostrar los pedidos de la tienda: ");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gestión Artículos">
    /**
     * Agregamos un nuevo artículo a la tienda.
     */
    private void altaArticulo() {
        //DEBEMOS PEDIR LOS 4 ATRIBUTOS POR TECLADO Y LUEGO AÑADIRLO AL HASHMAP
        Scanner sc = new Scanner(System.in);

        //En el caso del id tiene un formato, el primer nº es la sección (tipo de artículo) y el segundo es el artículo como tal, es necesaria un aexpresión regular para validar el id
        String idArticulo, descripción, existencias, pvp;

        System.out.println("ALTA DE NUEVO ARTICULO");
        //ANTES: idArticulo=sc.next();
        //AHORA DEBEMOS VALIDAR EL idArticulo CON UNA EXPRESÓN REGULAR SENCILLA
        do {
            System.out.println("IdArticulo (IDENTIFICADOR) : ");
            idArticulo = sc.nextLine();
        } while (!idArticulo.matches("[1-5][-][0-9][0-9]") || articulos.containsKey(idArticulo));
        /*EL STRING DEBE COINCIDIR CON ESTE PATRÓN, .matches INICIALIZA LA EXPRESIÓN REGULAR
        -NUESTRA TIENDA TIENE 5 SECCIONES-> [1-5]
        -UN GUIÓN-> [-]
        -UN Nº DEL 0 AL 9->[0-9] [0-9]
        -AÑADIMOS UN O PARA EL CASO DE QUE EL ARTÍCULO YA EXISTE MEDIANTE LA IDENTIFICACIÓN DE LA CLAVE-> ||articulos.containsKey(pvp));
        ESTO HARÁ QUE EL USUARIO ESTÉ EN EL BUCLE ETERNAMENTE HASTA TECLEAR BIEN EL FORMATO QUE HEMOS ESTABLECIDO, ESTAMOS CONTROLANDO EL FORMATP Y SI YA EXISTE*/

        System.out.println("DESCRIPCIÓN");//EN ESTE CASO NO TIENE UN FARMATO DECIDIDO, POR LO TANTO, NO ES NECESARIA UNA VALIDACIÓN
        descripción = sc.nextLine();

        //EXISTENCIAS CON VALIDACIÓN DE TIPO int
        do {
            System.out.println("EXISTENCIAS:");
            existencias = sc.nextLine();
        } while (!MetodosAuxiliares.esInt(existencias));//LLAMAMOS LOS MetodosAuxiliares PARA VALIDAR EL int

        //PVP CON VALIDACIÓN DE TIPO double
        do {
            System.out.println("PVP:");
            pvp = sc.nextLine();
        } while (!MetodosAuxiliares.esDouble(pvp));

        //YA HEMOS VALIDADO LOS ATRIBUTOS, AHORA AÑADIMOS EL NUEVO ARTICULO A LA COLECCIÓN
        Articulo a = new Articulo(idArticulo, descripción,
                Integer.parseInt(existencias), Double.parseDouble(pvp));//DEBEMOS PONER EL Integer.parseInt y el Double para convertir la validación de los Strings al dato que de verdad queremos almacenar
        
        articulos.put(idArticulo, a);
        System.out.println("SE HA AÑADIDO EL NUEVO ARTICULO CORRECTAMENTE");
    }
    
    /**
     * Gestiona la baja lógica de un artículo del catálogo.
     * 
     * Este método está pensado para desactivar artículos en lugar de borrarlos
     * físicamente, ya que puede interesar conservar su información para
     * consultas históricas o pedidos antiguos.
     */
    private void bajaArticulo() {
        /*Solo tiene sentido guardar la información de dichos artículos ya sean activos=se venden, inactivos=no se venden, porque nos intereza tener guardados los artículos que he vendio anteriormente
        más que borar esos datos, los desactivo y los almaceno en un histórico para estén accesibles en el caso de ser necesarios, aunque no estén en el catálogo de ventas actual*/
        
        // Pedimos el identificador del artículo
        System.out.println("ID DEL ARTICULO A DAR DE BAJA:");
        String idArticulo = sc.next();

        // Comprobamos si el artículo existe
        if (!articulos.containsKey(idArticulo)) {
            System.out.println("Ese artículo no existe en la tienda");
        } else {

            Articulo a = articulos.get(idArticulo);

            // Si ya está inactivo, avisamos
            if (!a.isActivo()) {
                System.out.println("Ese artículo ya estaba dado de baja");
            } else {

                // Si tiene stock, pedimos confirmación antes de darlo de baja
                if (a.getExistencias() > 0) {
                    System.out.println("El artículo todavía tiene stock disponible.");
                    System.out.println("¿Seguro que quieres darlo de baja? (SI/NO)");
                    String respuesta = sc.next();

                    if (!respuesta.equalsIgnoreCase("SI")) {
                        System.out.println("Operación cancelada");
                        return;
                    }
                }

                // Marcamos el artículo como inactivo
                a.setActivo(false);
                System.out.println("Artículo dado de baja correctamente");
            }
        }
        
        
        
        
        /*      ESTE MÉTODO BORRA DEFINITIVAMENTE UN ARTÍCULO PARA TENER UN CONTROL DE LA TIENDA NO ES MUY RECOMENDADO
        PARA PODER CREAR UNA BAJA LÓGICA ES NECESARIO AGREGAR NUEVOS ATRIBUTOS EN LA CLASE ARTÍCULO QUE NOS PERMITA SABER 
        QUÉ ARTÍCULOS ESTÁN ACTIVOS/DISPONIBLES
        //Primero pedimos el id del artículo que queremos dar de baja
        System.out.print("\nTeclea el id del ARTICULO a dar de baja (primeros dígitos del articulo; x-y): ");
        String idArticulo = sc.next();
        
        //Comprobamos si el artículo existe en la tienda
        if (!articulos.containsKey(idArticulo)){
            System.out.println("Este artículo existe en la tienda");
        } else{
            
            boolean apareceEnPedidos=false;
            
            //Recorremos todos los pedidos de la tienda
            for (Pedido p : pedidos) {
                //Recorremos todas las líneas de cada pedido
                for (LineaPedido l : p.getCestaCompra()) {
                    //Si el artículo aparece en algún pedido, no debemos borrarlo
                    if (l.getArticulo().getIdArticulo().equalsIgnoreCase(idArticulo)) {
                        apareceEnPedidos= true;
                        break;
                    }
                }
                //Si ya apareció en un pedido, no hace falta seguir buscando
                if (apareceEnPedidos){
                    break;
                }
            }
            //Si aparece en pedidos, no lo eliminamos
            if (apareceEnPedidos){
                System.out.println("No se puede dar de baja el artículo porque ya aparece en pedidos");
            } else{
                articulos.remove(idArticulo);
                System.out.println("Articul eliminado correctamente");
            }
        }*/
    }
    
    /**
     * Reposición de existencias de un artículo de la tienda.
     * 
     * El método solicita el identificador del artículo y el número de unidades
     * a añadir. Si tras la reposición el stock es mayor que 0, el artículo
     * se marca automáticamente como activo.
     */
    private void reposicionArticulo() {
        /*  -Aquí deberíamos pedir el id del artículo a reponer
            -Después comprobar que exista en la tienda
            -Finalmente sumar las nuevas unidades a las existencias actuales*/
        
        //Pedimos el id del artículo a reponer
        System.out.println("ID del artículo a reponer:");
        String idArticulo= sc.next();
        
        //Comprobamos si el artículo eiste en la tienda
        if (!articulos.containsKey(idArticulo)) {
            System.out.println("Este artículo no existe en la tienda");
        }   else{
            Articulo a=articulos.get(idArticulo);
            
            //Si el artículo está inactivo, preguntamos si se qeuire reactivar
            if (!a.isActivo()) {
                System.out.println("Este artículo está dado de baja.");
                System.out.println("¿Deseas reactivarlo y reponer stock? (SI/NO)");
                String respuesta=sc.next();
                
                if (!respuesta.equalsIgnoreCase("SI")) {
                    System.out.println("Operación cancelada");
                    return;
                }
                
                a.setActivo(true);
            }
            
            System.out.println("UNIDADES a añadir:");
            int unidades =sc.nextInt();
            
            a.setExistencias(a.getExistencias()+unidades);
            
            //Reactivamos el artículo cuando vuelve a tener stock= a.getExistencias()>0
            if (a.getExistencias()>0) {
                a.setActivo(true);
            }
            System.out.println("Reposición realizada correctamente");
        }
    }

    /**
     * Muestra distintos listados de artículos de la tienda.
     * 
     * El método perminte listar artículos de una sección introducida por teclado,
     * mostrar los artículos agrupados por secciones fijas y ordenarlos según
     * el número de unidades vendidas.
     */
    private void listarArticulos() {
        /*System.out.println("Vamos a mostrar los articulos de la tienda: ");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
            //System.out.print("\n" + a.getidArticulo() + "/" + a.getdescripción() + "/" + a.getexistencias() + "/" + a.getpvp());
        }
        
        System.out.println("\nVamos a nostrar los artículos con streams: ");
        articulos.values().stream()
                .forEach(a->System.out.println(a));//Imprime los values de dicho hashmap
        
        System.out.println("\n");
        articulos.values().stream()
                .forEach(a->System.out.println(a));
        
        //Lo convertimos en ArrayList
        System.out.println("\nLo convertimos a ArrayList y declaramos criterios de ordenaión");
        ArrayList<Articulo> articulosAux=new ArrayList(articulos.values());
        
        System.out.println("");
        articulosAux.stream()
                .filter(a->a.getPvp()<100)
                .sorted(Comparator.comparing(Articulo::getPvp).reversed())//CUANDO SON ATRIBUTOS, CLASE::ATRIBUO, CON MÉTODOS, EN PREDICADOS
                .forEach(a->System.out.println(a));
        
        System.out.println("\nListado tradicional con FOR EACH");
        for (Articulo a : articulos.values()) {//Cuidado despúes del punto, como es HashMap siempre lleva .values, si no lo lleva da error el código
            System.out.println(a);
        }*/

        //EJERCICIO UNO DEL 05/02/2026
        /*
        ESTO ES PARA MOSTRAR EN LA CABECERA LA SECCIÓN QUE SE HA TECLEADO
        String[] Secciones={"", "PERIFERICOS", "ALMACENAMIENTO", "MONITORES", "IMPRESORAS"};*/
        System.out.println("SECCION A LISTAR: ");
        String seccion = sc.next();
        System.out.println("ARTICULOS ACTIVOS DE LA SECCION" + " " + seccion);

        /*
        SOLUCIÓN EDU
        for (Articulo a: articulos.values()) {
            if (a.getIdArticulo().startsWith(seccion)) {
                System.out.println(a);
            }
        }*/
        //Filtramos los artículos cuya sección coincide con la introducida
        articulos.values().stream()
                .filter(a->a.isActivo())
                .filter(a -> a.getIdArticulo().startsWith(seccion))
                .sorted(Comparator.comparing(Articulo::getIdArticulo))
                .forEach(a -> System.out.println(a));

        //EJERCICO DOS: MOSTRAMOS LOS ARTÍCULOS AGRUPADOS POR CADA SECCIÓN
        System.out.println("\nPERIFERICOS ACTIVOS");
        articulos.values().stream()
                .filter(a->a.isActivo())
                .filter(a -> a.getIdArticulo().startsWith("1"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nALMACENAMIENTO ACTIVOS");
        articulos.values().stream()
                .filter(a->a.isActivo())
                .filter(a -> a.getIdArticulo().startsWith("2"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nIMPRESORAS ACTIVOS");
        articulos.values().stream()
                .filter(a->a.isActivo())
                .filter(a -> a.getIdArticulo().startsWith("3"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nMONITORES ACTIVOS");
        articulos.values().stream()
                .filter(a->a.isActivo())
                .filter(a -> a.getIdArticulo().startsWith("4"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));

        //EJERCICO CUATRO: ORDENAMOS LOS ARTÍCULOS POR NÚMERO DE UNIDADES VENDIDAS
        System.out.println("\nLISTADO DE ARTICULOS ACTIVOS- UNIDADES VENDIDAS:");
        articulos.values().stream()
                .filter(a->a.isActivo())
                .sorted(Comparator.comparing(a -> udsVendidas((Articulo) a)).reversed())
                .forEach(a -> System.out.println(
                a.getIdArticulo() + " - "
                + a.getDescripcion() + " - vendidas " + udsVendidas(a)));
        
        //EMPEZAR LISTADO DE ARTICULOS DADOS DE BAJA, INCLUYE ARTICULOS ACTIVOS Y NO ACTIVOS
                System.out.println("\nPERIFERICOS ACTIVOS E INACTIVOS");
        articulos.values().stream()
                
                .filter(a -> a.getIdArticulo().startsWith("1"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nALMACENAMIENTO ACTIVOS E INACTIVOS");
        articulos.values().stream()
                
                .filter(a -> a.getIdArticulo().startsWith("2"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nIMPRESORAS ACTIVOS E INACTIVOS");
        articulos.values().stream()
                
                .filter(a -> a.getIdArticulo().startsWith("3"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nMONITORES ACTIVOS E INACTIVOS");
        articulos.values().stream()
                
                .filter(a -> a.getIdArticulo().startsWith("4"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));

        //EJERCICO CUATRO: ORDENAMOS LOS ARTÍCULOS POR NÚMERO DE UNIDADES VENDIDAS
        System.out.println("\nLISTADO DE ARTICULOS ACTIVOS E INACTIVOS- UNIDADES VENDIDAS:");
        articulos.values().stream()
                
                .sorted(Comparator.comparing(a -> udsVendidas((Articulo) a)).reversed())
                .forEach(a -> System.out.println(
                a.getIdArticulo() + " - "
                + a.getDescripcion() + " - vendidas " + udsVendidas(a)));
        
        
    }

    //EVOLUCIÓN DE PROGRAMACIÓN TRADICIONAL A FUNCIONAL PARA CALCULAR LAS UNIDADES VENDIDAS
    /**
     * Calcula las unidades vendidas con bucles anidados.
     *
     * @param a
     * @return c= unidades vendidas
     *
     * Muy estructurado pero requiere de hacerlo todo de forma manual
     */
    private int udsVendidas1(Articulo a) {
        int c = 0;
        for (Pedido p : pedidos) {
            for (LineaPedido l : p.getCestaCompra()) {
                if (l.getArticulo().equals(a)) {
                    c += l.getUnidades();
                }
            }
        }
        return c;
    }

    /**
     * Calcula las unidades vendidas mediante streams, filter y mapToInt.
     *
     * @param a
     * @return total
     *
     * Simplifica la utilización de los bucles FOR EACH con streams aplicando
     * filter
     */
    private int udsVendidas2(Articulo a) {
        int total = 0;
        for (Pedido p : pedidos) {
            total += p.getCestaCompra().stream().filter(l -> l.getArticulo().equals(a))
                    .mapToInt(LineaPedido::getUnidades).sum();
        }
        return total;

    }

    /**
     * Calculamos las unidades vendidas aplanando el stream con flatMap.
     *
     * @param a
     * @return
     */
    private int udsVendidas3(Articulo a) {
        /*                                                  FLATMAP
        flatMap nos permite procesar todas las LineaPedido de la CestaCompra de cada Pedido de la tienda
        -Es decir saltamos de CestaCompra a LineaPedido de todos los pedidos de la tienda, nos da acceso a una coleccion dentro de otra, es decir,
        acceder individualmente a cada atributo CestaCompra como un stream para pdoer procesarlo Linea a Linea.
        -Antes del flatMap solo tenemos los bucles anidades de for (Pedido p : pedidos)
        -Tras el flatMap tenemos los 2 bucles anidados, estamos pasando a nivel de LineaPedido:
            for (Pedido p : pedidos) {
            for (LineaPedido l : p.getCestaCompra())
        -Aplicamos lo que queremos hacer con toda esa info a nivel de LineaPedido: .filter y mapToInt
        -NO PODEMOS APLICAR LOS FILTROS SIN EL FLATMAP*/
        return pedidos.stream() //Nivel de pedido
                .flatMap(pedidos -> pedidos.getCestaCompra().stream()) //Nivel CestaCompra
                .filter(l -> l.getArticulo().equals(a)) //Nivel LineaPedido
                .mapToInt(LineaPedido::getUnidades).sum();

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gestión de Clientes">
    /**
     * Da de alta un nuevo cliente en la tienda.
     * 
     * Este método debe solicitar por teclado los datos del cliente, validarlos
     * y añadir el nuevo objeto Cliente al HashMap clientes usando su DNI como clave.
     */
    private void altaCliente() {
        //Debemos pedir DNI, nombre, teléfono y email por teclado
        //El DNI será la clave del HashMap clientes
        //Antes de añadirlo, conviene comprobar que no exista ya en la colección
    }
    
    /**
     * Da de baja un cliente de la tienda.
     * 
     * Este método debería solcitar el DNI del cliente, comprobar si existe en 
     * la colección y eliminarlo o desactivarlo según el diseño elegido,
     * preferiblemente desactivarlo para poder realizar consultas si es necesario.
     */
    private void bajaCliente() {
        //Debemos pedir DNI del cliente
        //Comprobar si existe en el HashMap clientes
        //Si existe, lo eliminamos o lo marcamos como inactivo
    }

    /**
     * Modifica los datos de un cliente ya existente.
     * 
     * Este método debería localizar al cliente por su DNI y permitir actualizar
     * algunos de sus atributos, como nombre, teléfono o email.
     */
    private void modificarDatos() {
        //Debemos pedir DNI del cliente que queremos modificar
        //Si el cliente existe, pedimos los nuevos datos
        //Finalmente actualizamos sus atributos con los setters correspondientes
    }

    /**
     * Muestra la información relacionada con los clientes de la tienda.
     * 
     * En su estado actual, el método realiza dos ejercicios:
     *  -Muestra los pedidos y el total gastado por un cliente concreto
     *  -Lista los clientes que todavía no han realizado ningún pedido
     */
    private void listarClientes() {
        /*System.out.println("Vamos a mostrar todos los clientes de la tienda: ");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
            //System.out.print("\n" + l.getIsbn() + "/" + l.getTitulo() + "/" + l.getAutor() + "/" + l.getGenero());
        }*/

        //EJERCICIO 3: Pedimos el DNI del cliente que queremos consultar sus pedidos
        System.out.println("Introduce el DNI del cliente:");
        String dni = sc.next();
        double totalGastado = 0;
        
        //Mostramos todos los pedidos del cliente y vamos acumulando su gasto total
        System.out.println("\nPEDIDOS DEL CLIENTE " + dni);
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(dni)) {
                double total = totalPedido(p);
                System.out.println(p + " - TOTAL: " + total);
                totalGastado += total;
            }
        }
        
        //Mostramos el importe total gastado por ese cliente
        System.out.println("\nTOTAL GASTADO POR EL CLIENTE: " + totalGastado + "euros");

        /*clientesAux.stream()
                .filter(c->c.getIdCliente().equals(dni))
                .forEach(p->totalPedido(Pedido p));
                //.sorted(Comparator.comparing(c->totalPedido(p)));
        /*clientes.values().stream()
                .filter(c->c.getIdCliente().equalsIgnoreCase(dni))
                .sorted(Comparator.comparing(Cliente::getIdCliente))
                .forEach(c->System.out.println(c));*/
        
        //EJERCICIO 5: Buscamos los clientes que no tienen ningún pedido asociado
        ArrayList<Cliente> clientesNoPedidos = new ArrayList<>();
        for (Cliente c : clientes.values()) {
            int contador = 0;
            
            //Recorremos los pedidos para comprobar si el cliente aparece en alguno
            for (Pedido p : pedidos) {
                if (p.getClientePedido().getIdCliente().equalsIgnoreCase(c.getIdCliente())) {
                    contador++;
                }
            }
            
            //Si el contador sigue a 0, ese cliente no ha hecho pedidos
            if (contador == 0) {
                clientesNoPedidos.add(c);
            }
        }
        
        //Mostramos los clientes sin pedidos
        System.out.println("CLIENTE SIN PEDIDOS:");
        for (Cliente c : clientesNoPedidos) {
            System.out.println(c);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Gestión Pedidos">
    /**
     * Genera un identificador único para un nuevo pedido "IdPedido".
     * 
     * El formato del identificador es: DNI-XXX/AÑO, donde XXX representa
     * el número de pedido del cliente con tres cifras.
     *
     * @param idCliente identificador del cliente que realiza el pedido
     * @return identificador generado para el nuevo pedido
     */
    public String generaIdPedido(String idCliente) {
        String nuevoId;
        int contador = 0;
        //Calculo el número de pedidos de la persona, cuántos pedidos  tiene ya el cliente
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)) {
                contador++;
            }
        }
        //Hemos calculado cuúantos pedidos tiene el cliente aportado con el contador

        contador++;//Sumamos 1 al contador para el nuevo pedido

        //Construimos el ID con el formato DNI-XXX/AÑO
        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();

        return nuevoId;
    }

    /**
     * Permite crear un nuevo pedido para un cliente de la tienda.
     * 
     * El método valida el cliente, permite añadir artículos de una cesta compra,
     * comprueba el stock disponible mediante excepciones, muestra el resumen
     * del pedido y, si el usuario confirma, guarda el pedido y actualiza
     * las existencias de los artículos.
     */
    private void nuevoPedido() {
        //Limpiamos el Buffer y pedimos el cliente por teclado
        sc.nextLine();
        String idCliente;
        
        do {
            System.out.println("DNI (id) CLIENTE:");
            idCliente = sc.next().toUpperCase();
            
            //Comprobamos si el cliente existe en la tienda
            if (!clientes.containsKey(idCliente)) {
                System.out.println("No es cliente de la tienda."
                        + " Desea darse de alta o comprar como invitado ");
            }
        } while (!MetodosAuxiliares.validarDni(idCliente));

        //Controlamos que solo se pidan artículos de la tienda y de clientes de la tienda
        //Creamos la cesta compra
        ArrayList<LineaPedido> cestaCompra = new ArrayList();
        String idArticulo;
        int unidades = 0;

        System.out.print("\nTeclee el ID del articulo deseado (FIN para terminar la compra):");
        idArticulo = sc.next();

        //Seguimos pidiendo artículos hasta que el usuario escriba FIN
        while (!idArticulo.equalsIgnoreCase("FIN")) {
            
            //Comprobamos si el artículo existe en la tienda
            if (!articulos.containsKey(idArticulo)) {
                System.out.println("Este artículo no existe en la tienda");
                System.out.println("\nTeclee el ID del artículo deseado (FIN para teminar la compra)");
            }
            
            //Comprobamos que e artículo esté activo
            if (!articulos.get(idArticulo).isActivo()) {
                System.out.println("Ese artículo está dado de baja y no se puede vender");
                System.out.println("\nTeclee el ID del artículo deseado (FIN para terminar la compra)");
                idArticulo = sc.next();
                continue;
            }


            //Es mejor utilizar un while en lugar de un do while como en el commit anterior, con el do while estamos obligando a la persona a seguir con los atributos aunque no quiera comprar, se ve abajo del todo con do while
            System.out.print("\nTeclee las unidades deseadas: ");
            unidades = sc.nextInt();//Debemos valorar las execepciones llamando al método stock

            //Control de stock y gestión de excepciones
            try {
                stock(articulos.get(idArticulo), unidades); //Debemos darle a la penúltima sugenrecia
                //CAMBIAMOS DE IDARTICULO A EL OBJETO COMPLETO COMO ARTICULO

                //Si hay stock suficiente, añadimos la línea a la cesta
                cestaCompra.add(new LineaPedido(articulos.get(idArticulo), unidades)); //Si no pasa nada de las excepciones añadimos la linea a cestaCompra

                //Si damos por hecho que el pediddo se va cerrar, esto debería ir al final del código cuando estamnos seguros que se va afectuar el pedido
                //articulos.get(idArticulo).setExistencias(articulos.get(idArticulo).getExistencias()-unidades);
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());//Nos muestra el mensaje que fijamos en el método de stock cuando salta la excepción
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());//Aparte de mostrar el mensaje lo podemos matizar aún más
                System.out.println("Las quieres (SI/NO)");
                String respuesta = sc.next();
                
                //Si el cliente acepta, añadimos todas las unidades disponibles
                if (respuesta.equalsIgnoreCase("SI")) {
                    cestaCompra.add(new LineaPedido(
                            articulos.get(idArticulo), 
                            articulos.get(idArticulo).getExistencias()));//Le estamos dando las unidades que hay
                    //articulos.get(idArticulo).setExistencias(0);
                }
            }
            System.out.println("\nTeclee el ID del artículo deseado (FIN para terminar la compra)");
            idArticulo = sc.next();

        }

        //Si la cesta no está vacía, mostramos el resumen del pedido
        if (!cestaCompra.isEmpty()) {
            System.out.println("Este es tu pedido:\n");
            double totalLinea = 0;
            double totalPedido = 0;
            for (LineaPedido l : cestaCompra) {//Recorremos el hashmap para almacenar la iformación de dicho pedido respecto al precio
                totalLinea = l.getUnidades() * l.getArticulo().getPvp();//Calculamos el precio del pedido multiplicando las unidades por el precio del artículo
                totalPedido += totalLinea;//Aumentamos el total pedido en si aumenta la línea
                System.out.println(l.getArticulo() + " - "
                        + l.getUnidades() + " uds " + " - " + totalLinea);

            }
            System.out.println("\t\tEl precio total del pedido es " + totalPedido);
            System.out.println("\nProcedemos con la compra (SI/NO)");
            String respuesta = sc.next();

            if (respuesta.equalsIgnoreCase("SI")) {
                pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente),
                        LocalDate.now(), cestaCompra));
                
                //Restamos del stock las unidades compradas
                for (LineaPedido l : cestaCompra) {
                    l.getArticulo().setExistencias(
                            l.getArticulo().getExistencias() - l.getUnidades());

                    // Si el stock llega a 0, damos de baja lógica el artículo
                    if (l.getArticulo().getExistencias() == 0) {
                        l.getArticulo().setActivo(false);
                    }
                }
                
                /*Tras comprobar el stock hay 2 vías que podemos seguir:
                Opción A; activo= "forma parte del catálogo", por lo tanto:
                    -Un articulo puede estar activo y con stock=0
                    -El artículo sale como agotado
                    -No lo damos de baja automáticamente
                Dejamos el forEach de arriba sin colocar una condición
                
                Opción B; activo="Está disponible para la venta", por lo tanto cuando el stock llega a 0:
                    -Artículo pasa a estar inactivo
                    -Lo damos de baja automáticamente
                Agregamos una condición if al forEach para que automatice la baja del artículo:
                        // Si el stock llega a 0, damos de baja lógica el artículo
                        if (l.getArticulo().getExistencias() == 0) {
                            l.getArticulo().setActivo(false);
                        }
                */
                /*for (LineaPedido l : cestaCompra) {
                    articulos.get(l.getArticulo())
                            .setExistencias(articulos.get(l.getArticulo()).getExistencias() - l.getUnidades());
                }*/
            }
            //pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente), LocalDate.now(), cestaCompra));
        }
        //Solo hacemos el pedido si la persona metió algo en la cesta
        /*if (cestaCompra.size() > 0) {//()cestaCompra.isEmpty

            Pedido p = new Pedido(generaIdPedido(idCliente), clientes.get(idCliente), LocalDate.now(), cestaCompra);
            /*Pedimos uno a uno los atributos del pedido, son las cosas que necesitamos para realizar un pedido
                -Generamos el id de ese pedido mediante la llamada al método generaIdPedido anterior
                -Lo asociamos a un cliente
                -Obtenemos la fecha del pedido
                -Hace falta rellenar el ArrayList del pedido
            pedidos.add(p);
        }*/
        //generaIdPedido(idCliente);//Con esto ya lo tenemos, pero aún no ha hecho el pedido, no necesitamos el id aún porque no hay pedido, hace falta cestaCompra, hace falta rellenar ese ArrayList

        /*System.out.println(generaIdPedido("80580845T"));
        System.out.println(generaIdPedido("36347775R"));
        System.out.println(generaIdPedido("02337565Y"));
        PRUBA DE QUE GENERA UN ID DE PEDIDO PARA ESOS idCliente*/
 /*do {            
            System.out.println("Teclea el ID del articulo deseado (FIN para terminar la compra) ");
            idArticulo=sc.nextLine();
            System.err.println("\nTeclea las unidades deseadas: ");
            unidades=sc.nextInt();
            cestaCompra.add(new LineaPedido(idArticulo,unidades));
        } while (!idArticulo.equalsIgnoreCase("FIN"));
        Pedido p = new Pedido(generaIdPedido(idCliente), clientes.get(idCliente), LocalDate.now(), cestaCompra);
        pedidos.add(p);*/
    }
    //pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente), LocalDate.now(), cestaCompra));

    /**
     * Lista los pedidos con for each.
     */
    private void listadoPedido() {
        System.out.println("Vamos a mostrar los pedidos de la tienda: ");
        for (Pedido p : pedidos) {
            System.out.println(p + "- Total: " + totalPedido(p));
        }
    }

    /**
     * Calcula el importe total de un pedido.
     * 
     * Recorre todas las líneas de pedido y suma el importe de cada una,
     * multiplicando las unidades por el precio el artículo.
     * 
     * @param p pedido del que queremos calcular el total
     * @return importe total del pedido
     */
    public double totalPedido(Pedido p) { //Cambiamos a public para probarlo en los test de JUNIT 5
        double totalPedido = 0;
        
        //Recorremos todas las líneas del pedido
        for (LineaPedido l : p.getCestaCompra()) {
            //Sumamos el importe de cada línea
            totalPedido += l.getUnidades() * l.getArticulo().getPvp(); //SE CAMBIA DE l.getIdArticulo a l.getArticulo porque cambiamos la clase de LineaPedido, NOS PERMITE ACCEDER AL ARTICULO DIRECTAMENTE
        }
        return totalPedido;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Listados con STREAM">
    /**
     * Realiza distintos listados de clientes, artículos y pedidos utilizando streams.
     * 
     * El método muestra ejemplos básicos de recorrido completo de colecciones con
     * forEach, así como filtros y ordenaciones sencillas aplicadas sobre artículos
     * y pedidos.
     */
    private void listadosConStreams() {
        //Lista todos los artículos con streams
        System.out.println("\nVamos a listar articulos con streams");
        articulos.values().stream()
                //.filter(a->a.isActivo())Muestra solo los activos
                .forEach(a -> System.out.println(a));
        
        System.out.println("\nVamos a listar articulos ACTIVOS con streams");
        articulos.values().stream()
                .filter(a->a.isActivo())
                .forEach(a -> System.out.println(a));
        
        //Lista todos los clientes con streams
        System.out.println("\nVamos a listar clientes con streams");
        clientes.values().stream()
                .forEach(c -> System.out.println(c));
        
        //Lista todos los pedidos con streams
        System.out.println("\nVamos a listar pedidos con streams");
        pedidos.stream()
                .forEach(p -> System.out.println(p));

        //LISTADOS DE EDUARDO
        //EJEMPLOS SENCILLOS CON filter() - sorted() - forEach()
        System.out.println("\n\nListados con streams de Eduardo");
        // ARTICULOS DE MENOS DE 100€ ORDENADOS POR PRECIO DE - A +
        System.out.println("Articulos de menos de 100 euros ordenados de - a +");
        articulos.values().stream()
                .filter(a -> a.getPvp() < 100) //Aplicamos un filtro y ordenación en el listado
                .sorted(Comparator.comparing(Articulo::getPvp))
                .forEach(a -> System.out.println(a));

        
                    //ESTOS LISTADOS NO TIENEN EN CUENTA EL ESTADO DE ACTIVO/INACTIVO DEL ARTÍCULO
        //PEDIDOS ORDENADOS POR EL IMPORTE TOTAL DEL PEDIDO DE - A + (usamos el método auxiliar totalPedido()) 
        System.out.println("\nPEDIDOS ORDENADOS POR EL IMPORTE TOTAL DEL PEDIDO DE - A + (usamos el método auxiliar totalPedido()");
        pedidos.stream()
                .sorted(Comparator.comparing(p -> totalPedido(p))) //Ordenamos los pedidos por el importe total
                .forEach(p -> System.out.println(p + "- Total: " + totalPedido(p)));

        //PEDIDOS ORDENADOS POR EL IMPORTE TOTAL DEL PEDIDO DE + A - (usamos el método auxiliar totalPedido()) 
        System.out.println("\nPEDIDOS ORDENADOS POR EL IMPORTE TOTAL DEL PEDIDO DE + A - (usamos el método auxiliar totalPedido())");
        pedidos.stream()
                .sorted(Comparator.comparing(p -> totalPedido((Pedido) p)).reversed()) //Ordenamos los pedidos por el importe de forma descendente
                .forEach(p -> System.out.println(p + "- Total: " + totalPedido(p)));

        //PEDIDOS DE MÁS DE 1000€ (filter) ORDENADOS POR LA FECHA DEL PEDIDO DE - A + 
        System.out.println("\nPEDIDOS DE MÁS DE 1000€ (filter) ORDENADOS POR LA FECHA DEL PEDIDO DE - A +");
        pedidos.stream()
                .filter(p -> totalPedido(p) > 1000) //Aplicamos filtros por pedidos; pedidos de más de 1000 euros
                .sorted(Comparator.comparing(Pedido::getFechaPedido)) //Ordenamos los pedidos por fecha
                .forEach(p -> System.out.println(p + "- Total: " + p.getFechaPedido()));

                    //TENIENDO EN CUENTA EL ESTADO DEL ARTÍCULO
        System.out.println("\nArticulos activos de menos de 100 euros ordenados de - a +");
        articulos.values().stream()
                .filter(a -> a.isActivo())
                .filter(a -> a.getPvp() < 100)
                .sorted(Comparator.comparing(Articulo::getPvp))
                .forEach(a -> System.out.println(a));      
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Ordenar con STREAMS">
    /**
     * Ordenamos los pedidos utilizando criterios con streams.
     * 
     * -Criterios de organización: atributo y método
     * 
     * Se muestran ejemplos de ordenación por atributo, como identificador
     * del pedido, y por valores calculados, como el importe del pedido.
     */
    private void ordenarConStream() {
        
        //Ordenamos los pedidos por ID de forma ascendente
        System.out.println("Listado de pedidos ordenados por ID de menor a mayor total: ");
        pedidos.stream().sorted(Comparator.comparing(Pedido::getIdPedido))//El criterio de ordenación es el que está en el paréntesis después del .comparing, en ese caso usamos un atributo como pedido
                .forEach(p -> System.out.println(p + " - " + totalPedido(p)));

        //Ordenamos los pedidos por ID de forma descendente
        System.out.println("\nListado de pedidos ordenados por ID de mayor a menor total: ");
        pedidos.stream().sorted(Comparator.comparing(Pedido::getIdPedido).reversed())
                .forEach(p -> System.out.println(p + " - " + totalPedido(p)));

        //Ordenamos los pedidos por importe total de menor a mayor
        System.out.println("\nListado de pedidos ordenados usando como criterio un método de - a +: ");
        pedidos.stream().sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p -> System.out.println(p + " - " + totalPedido(p)));

        //Ordenamos los pedidos por importe total de mayor a menor
        System.out.println("\nListado de pedidos ordenados usando como criterio un método de + a -: ");
        pedidos.stream().sorted(Comparator.comparing(p -> totalPedido((Pedido) p)).reversed())
                .forEach(p -> System.out.println(p + " - " + totalPedido(p)));

        //VAMOS A MOSTRAR SOLO LOS PEDIDOS MAYORES DE MIL EUROS
        //FILTER SIEMPRE LO PRIMERO
        System.out.println("\n");
        /*pedidos.stream().filter(pedidos->totalPedido(p)>1000)
                .sorted(Comparator.comparing(Pedido::getFechaPedido))
                .forEach(pedidos->System.out.println(p " - " + totalPedido(p)));*/

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Ejercicios del puente">
    
    /**
     * Reúne ejercicios de prácticas con métodos puente de la API streams.
     * 
     * En este se trabajan operaciones como count(), mapToInt(),
     * groupingBy() y counting(), aplicadas a clientes, pedidos y artículos.
     */
    private void ejsPuente() {

        //EJERCICIOS CON MÉTODOS DEL API PARA REALIZAR CALCULOS count() map() mapToInt() .collect(Collectors.groupingBy) ...
        //CONTABILIZAR LOS PEDIDOS DE UN DETERMINADO CLIENTE - PODRÍA PEDIR NOMBRE O DNI POR TECLADO PERO LO HARÉ PARA UNO CONCRETO
        System.out.println("CONTABILIZAR LOS PEDIDOS DE UN DETERMINADO CLIENTE - PODRÍA PEDIR NOMBRE O DNI POR TECLADO PERO LO HARÉ PARA UNO CONCRETO");
        long numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getIdCliente().equalsIgnoreCase("80580845T"))//Aplicamos el filtro para que solo nos muestre este cliente
                .count();//Contamos los pedidos del cliente con dicho DNI
        System.out.println("El cliente con DNI - 80580845T tiene: " + numPedidos + " pedidos");
        //LAS FUNCIONES TIPO count() counting() almacenan resultados en variables de tipo long
        
        //Repetimos el ejrcicio pero, pedimos el DNI por teclado
        System.out.println("\nVAMOS A CONTABILIZAR LOS PEDIDOS DE UN CLIENTE INTRODUCIENDO SU DNI POR TECLADO");
        System.out.println("Introduce el DNI del cliente:");
        sc.nextLine();//HACERLO SIEMPRE ANTES DE INTRODUCIR DATOS PARA ELIMINAR BASURA DEL TECLADO
        String dni = sc.next();
        numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getIdCliente().equalsIgnoreCase(dni))
                .count();
        System.out.println("El cliente introducido tiene: " + numPedidos + " pedidos");

        //En este caso en lugar de pedir el DNI usamos el nombre del cliente como filtro
        System.out.println("\nVAMOS A CONTABILIZAR LOS PEDIDOS DE UN CLIENTE INTRODUCIENDO SU NOMBRE POR TECLADO");
        System.out.println("Introduce el NOMBRE del cliente:");
        String nombre = sc.next();
        numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getNombre().equalsIgnoreCase(nombre))
                .count();
        System.out.println("El cliente introducido tiene: " + numPedidos + " pedidos");

        //CONTABILIZAR CUANTOS PEDIDOS HAY POR CLIENTE - PARA LAS AGRUPACIONES SON IDEALES LOS MAPAS PORQUE PUEDEN CONTENER 2 DATOS
        //Agrupamos pedidos por cliente en un Map<Cliente, Long>
        System.out.println("\nCONTABILIZAR CUANTOS PEDIDOS HAY POR CLIENTE - PARA LAS AGRUPACIONES SON IDEALES LOS MAPAS PORQUE PUEDEN CONTENER 2 DATOS");
        Map<Cliente, Long> numPedidosPorCliente
                = pedidos.stream()
                        .collect(Collectors.groupingBy(Pedido::getClientePedido, Collectors.counting()));

        for (Cliente c : numPedidosPorCliente.keySet()) {
            System.out.println(c + " - " + numPedidosPorCliente.get(c));
        }

        // TOTAL DE UNIDADES VENDIDAS DE UN ARTICULO EN TODOS LOS PEDIDOS. PODEMOS APLICARLO AL 
        // MÉTODO UNIDADES VENDIDAS QUE HABÍA QUE HACER EN EL EJERCICIO 4 DE LA ÚLTIMA PRUEBA
        //Calculamos las unidades vendidas de cada artículo
        System.out.println("\nTOTAL DE UNIDADES VENDIDAS DE UN ARTICULO EN TODOS LOS PEDIDOS");
        for (Articulo a : articulos.values()) {
            int total = 0;
            for (Pedido p : pedidos) {
                total += p.getCestaCompra().stream().filter(l -> l.getArticulo().equals(a))
                        .mapToInt(LineaPedido::getUnidades).sum();
            }
            System.out.println(a + " - " + total);
        }

    }

    /**
     * Reúne ejercicios de práctica con flatMap() sobre coleccciones anidadas.
     * 
     * Se utiliza faltMap para trabajar directamente con todas las líneas de pedido
     * de todos los pedidos de la tienda, evitando el uso manual de bucles anidados.
     */
    private void ejsFlatMap() {
        /**
         * *************************************************************************************
         * EJERCICIOS CON flatMap() para colecciones anidadas. pedidos es un
         * ArrayList<Pedido>
         * dentro de cada Pedido hay una cestaCompra (ArrayList<LineaPedido>)
         * **************************************************************************************
         */

        // USUARIOS QUE HAN COMPRADO UN ARTÍCULO DETERMINADO
        // incluyendo cuántas unidades han comprado
        //Mostramos qué clientes han comprado un artículo concreto y cuántas unidades
        System.out.println("\nUSUARIOS QUE HAN COMPRADO UN ARTÍCULO DETERMINADO\n");

        for (Cliente c : clientes.values()) {

            int unidades = pedidos.stream()
                    .filter(p -> p.getClientePedido().equals(c))
                    .flatMap(p -> p.getCestaCompra().stream())
                    .filter(l -> l.getArticulo().equals(articulos.get("4-22")))
                    .mapToInt(LineaPedido::getUnidades)
                    .sum();

            System.out.println(c.getNombre() + ": " + unidades + " de "
                    + articulos.get("4-22").getDescripcion());
        }

        //ESTE MÉTODO SE DEBE PODER HACER PIDIENDO INFORMACIÓN POR TECLADO, POR EJEMPLO; idArticulo o descripcion
        //Repetimos el ejercicio pidiendo el artículo por teclado
        System.out.println("\nUSUARIOS QUE HAN COMPRADO UN ARTÍCULO DETERMINADO INTRODUCIENDO SU ID POR TECLADO");
        System.out.println("Introduce el ID del articulo:");
        sc.nextLine();
        var id = sc.nextLine();
        
        // Comprobamos que el artículo exista
        Articulo articuloBuscado = articulos.get(id);
        if (articuloBuscado == null) {
            System.out.println("No existe ningún artículo con ese ID.");
        } else {
            for (Cliente c : clientes.values()) {

                int unidades = pedidos.stream()
                        .filter(p -> p.getClientePedido().equals(c))
                        .flatMap(p -> p.getCestaCompra().stream())
                        .filter(l -> l.getArticulo().equals(articuloBuscado))
                        .mapToInt(LineaPedido::getUnidades)
                        .sum();
                if (unidades > 0) {
                    System.out.println(c.getNombre() + ": " + unidades + " de "
                            + articuloBuscado.getDescripcion());

                }
            }

            // TODOS LOS ARTÍCULOS VENDIDOS (sin repetir)
            //Obtenemos todos los artículos vendidos sin repetir usando un Set
            System.out.println("\nTODOS LOS ARTÍCULOS VENDIDOS\n");

            Set<Articulo> articulosVendidos = pedidos.stream()
                    .flatMap(p -> p.getCestaCompra().stream())
                    .map(LineaPedido::getArticulo)
                    .collect(Collectors.toSet());

            articulosVendidos.forEach(a -> System.out.println(a));

            // TOTAL DE UNIDADES VENDIDAS DE CADA ARTÍCULO
            //Calculamos las unidades vendidas de cada artículo agrupando por clave
            System.out.println("\nTOTAL DE UNIDADES VENDIDAS POR ARTÍCULO\n");

            Map<Articulo, Integer> unidadesPorArticulo = pedidos.stream()
                    .flatMap(p -> p.getCestaCompra().stream())
                    .collect(Collectors.groupingBy(
                            LineaPedido::getArticulo,
                            Collectors.summingInt(LineaPedido::getUnidades)
                    ));

            for (Articulo a : unidadesPorArticulo.keySet()) {
                System.out.println(a.getDescripcion() + " - "
                        + unidadesPorArticulo.get(a));
            }

            /**
             * **************************************************************************************
             * EJERCICIOS CON flatMap() para colecciones anidadas, nuestro caso
             * pues pedidos es un ArrayList de <Pedido> y dentro de cada Pedido
             * hay una cestaCompra, que es un ArrayList de
             * <Lineapedido>
             *
             *****************************************************************************************
             *
             * //USUARIOS QUE HAN COMPRADO UN ARTÍCULO DETERMINADO incluyendo
             * CUANTAS UNIDADES HAN COMPRADO //probamos con el artículo
             * articulos.get("4-22") System.out.println("\n"); for (Cliente
             * c:clientes.values()){ int unidades= pedidos.stream().filter(p->
             * p.getClientePedido().equals(c)) .flatMap(p ->
             * p.getCestaCompra().stream()).filter(l->l.getArticulo().equals(articulos.get("4-22")))
             * .mapToInt(LineaPedido::getUnidades).sum(); *
             * System.out.println(c.getNombre() + ": " + unidades + " de " +
             * articulos.get("4-22").getDescripcion()); } * //TODOS LOS
             * ARTICULOS VENDIDOS, LOS ALMACENAMOS EN UN SET PARA EVITAR
             * REPETICIONES System.out.println("\n");
             *
             * Set <Articulo> articulosVendidos = pedidos.stream() .flatMap(p ->
             * p.getCestaCompra().stream()) .map(LineaPedido::getArticulo)
             * .collect(Collectors.toSet());
             *
             * articulosVendidos.stream().forEach(a->System.out.println(a));
             *
             *
             * //TOTAL DE UNIDADES VENDIDAS DE TODOS LOS ARTÍCULOS usando
             * flatMap() System.out.println("\n"); Map<Articulo, Integer>
             * unidadesPorArticulo = pedidos.stream() .flatMap(p ->
             * p.getCestaCompra().stream())
             * .collect(Collectors.groupingBy(LineaPedido::getArticulo,
             * Collectors.summingInt(LineaPedido::getUnidades) )); for (Articulo
             * a:unidadesPorArticulo.keySet()){
             * System.out.println(a.getDescripcion() + " - " +
             * unidadesPorArticulo.get(a)); } }
             */
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Examen 20/02">
    
    /**
     * Muestra los clientes ordenados por el importe total gastado.
     * 
     * Utiliza streams para ordenar los clientes de mayor a menor
     * según el gasto total calculado mediante el método totalCliente().
     */
    private void uno() {
        System.out.println("\nCLIENTES ORDENADOS POR EL IMPORTE TOTAL DEL PEDIDO DE + A - (usamos el método auxiliar totalCliente())");
        clientes.values().stream()
                .sorted(Comparator.comparing(this::totalCliente).reversed())//Sorted ordenamos, Comparator.comparing declara el método de ordenación
                //this quiere decir que a los clientes le aplicamos el criterio que está después de los puntos = c->totalCliente((Cliente) c)
                .forEach(c -> System.out.println(c + "\tTotal GASTADO: " + totalCliente(c)));//For each para mostrar los clientes, el ToString + totalPedido respectivamente

        /*                                  SOLUCIÓN EDUARDO
        clientes.values().stream()
                .sorted(Comparator.comparing(c-> totalCliente((Cliente) c)).reversed())
                .forEach(c-> System.out.println(c + "\t\t Total GASTADO: " +  totalCliente(c))); */
    }

    /**
     * Calcula el importe total de los pedidos de un cliente.
     * 
     * @param c 
     * @return 
     */
    public double totalCliente(Cliente c) {
        return pedidos.stream().filter(p -> p.getClientePedido().equals(c))
                .flatMap(p -> p.getCestaCompra().stream())
                .mapToDouble(l -> l.getArticulo().getPvp() * l.getUnidades()).sum();

    }

    /**
     * Muestra los artículos de una sección con existencias disponibles.
     * 
     * Filtra los artículos cuya sección con la introducida por teclado,
     * comprueba que tengan stock y los ordena por precio de mayor a menor.
     */
    private void dos() {
        
        //Pedimos la sección que queremos consultar
        System.out.println("\nSECCION A LISTAR: ");
        String seccion = sc.next();
        System.out.println("ARTICULOS DE LA SECCION" + " " + seccion);

        //Filtramos por sección y por existencias, y ordenamos por precio descendente
        articulos.values().stream().filter(a -> a.getIdArticulo().startsWith(seccion) && a.getExistencias() > 0)
                .sorted(Comparator.comparing(Articulo::getPvp).reversed())
                .forEach(a -> System.out.println(a));

        /*ESTO MAL, SE TENÍA QUE HACER CON STREAMS
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith(seccion) & a.getExistencias() > 0) {
                System.out.println(a);
            }
        }
        
                                            SOLUCIÓN EDUARDO
        System.out.println("SECCION A LISTAR:");
        String sec=sc.next();
       
        articulos.values().stream()
                .filter(a->a.getIdArticulo().startsWith(sec)&&a.getExistencias()>0)
                .sorted(Comparator.comparing(Articulo::getPvp).reversed())
                .forEach(a->System.out.println(a));
         */
    }

    /**
     * Muestra los artículos que todavía no han sido vendidos.
     * 
     * Primero obtiene el conjunto de artículos vendidos en algún pedido y,
     * a continuación, muestra aquellos artículos del catálogo que no aparecen
     * en dicho conjunto.
     */
    private void tres() {
        System.out.println("\nARTICULOS NO VENDIDOS");
        
        //Guardamos en un set los artículos que sí han sido vendidos
        Set<Articulo> vendidos = pedidos.stream()
                .flatMap(p -> p.getCestaCompra().stream())
                .map(LineaPedido::getArticulo)
                .collect(Collectors.toSet());//Estamos guardando los datos en una nueva colección, en este caso el set no admite repeticiones

        //Filtramos los artículos del catálogo que no están en el set de vendidos
        Set<Articulo> articulosNoVendidos = articulos.values().stream()
                .filter(a -> !vendidos.contains(a))
                .collect(Collectors.toSet());

        //Mostramos los artículos no vendidos
        articulosNoVendidos.forEach(System.out::println);

        /*                                  SOLUCIÓN EDUARDO
        Set<Articulo> vendidos
                = pedidos.stream()
                        .flatMap(p -> p.getCestaCompra().stream())
                        .map(LineaPedido::getArticulo)
                        .collect(Collectors.toSet());

        List<Articulo> noVendidos
                = articulos.values().stream()
                        .filter(a -> !vendidos.contains(a))
                        .toList();
        System.out.println("\n");
        noVendidos.stream().forEach(a -> System.out.println(a));*/
    }

    
    //SE DEBE CORREGIR, CALCULAS MAL
    /**
     * Calcula el total facturado en los últimos cinco días
     * 
     * Filtra los pedidos cuya fecha sea posterior a la fecha límite calculada
     * y suma el importe de todas sus líneas de pedido.
     */
    private void cuatro() {
        System.out.println("\nTOTAL FACTURADO EN LOS ULTIMOS 5 DIAS:");
        
        //Calculamos la fecha límite
        LocalDate cincoD = LocalDate.now().minusDays(5);

        //Sumamos el importe de los pedidos psoteriores a esa fecha
        double total5 = pedidos.stream().filter(p -> p.getFechaPedido().isAfter(cincoD))
                .flatMap(p -> p.getCestaCompra().stream())
                .mapToDouble(lp -> lp.getArticulo().getPvp() * lp.getUnidades()).sum();
        /*double total = pedidos.stream()
                .filter(p -> !p.getFechaPedido().isBefore(cincoD))//p->p.getFechaPedido().isAfter(cincoD)
                .mapToDouble(this::totalPedido)
                .sum();*/

        System.out.println("Total facturado entre " + cincoD + " y " + LocalDate.now() + ": " + total5 + " euros");

        /*                                  SOLUCIÓN EDUARDO
        LocalDate fecha1 = LocalDate.now().minusDays(5);
        double total5dias = pedidos.stream()
            .filter(p -> p.getFechaPedido().isAfter(fecha1))
               .flatMap(p -> p.getCestaCompra().stream())
                .mapToDouble(lp -> lp.getArticulo().getPvp() * lp.getUnidades()).sum();
        System.out.println("\nTotal facturado los ultimos 5 dias: " + total5dias);*/
    }

    //EL DE EDU MEJOR
    /**
     * Calcula el importe medio de los pedidos de la tienda.
     * 
     * Obtiene el importe total de cada pedido mediante el método totalPedido()
     * y calcula la media usando average().
     */
    private void cinco() {
        System.out.println("\nIMPORTE MEDIO DE PEDIDOS DE LA TIENDA:");
        
        //Calculamos la media de los importes de todos los pedidos
        double medio = pedidos.stream()
                .mapToDouble(this::totalPedido)
                .average()
                .orElse(0);

        System.out.println("Importe Medio Pedidos TIENDA: " + medio);

        /*                                  SOLUCIÓN EDUARDO
        double importePedidos = pedidos.stream()
            .flatMap(p -> p.getCestaCompra().stream())
              .mapToDouble(lp -> lp.getArticulo().getPvp() * lp.getUnidades()).sum();
        
        System.out.println("\nImporte Medio Pedidos TIENDA: " + importePedidos/pedidos.size()); */
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Colecciones-Almecenado">
    
    /**
     * Realiza distintas operaciones avanzadas con colecciones.
     * 
     * Incluye ejemplos de ordenación, transformación a listas,
     * uso de TreeMap, agrupaciones de datos y eliminación de elementos.
     */
    private void coleccion() {
        
        //Guardamos los pedidos ordenados por fecha en una lista
        System.out.println("Pedidos ordenados por fecha de - reciente a + sin colección");
        List<Pedido> pedidosOrdenadosFecha //Pasamos de pedidos a esta lista
                = pedidos.stream()
                        .sorted(Comparator.comparing(Pedido::getFechaPedido).reversed())
                        .collect(Collectors.toList());//En lugar de imprimir los datos los guardamos en un una lista con el collect

        pedidos.stream().forEach(p -> System.out.println(p.getIdPedido() + " [" + p.getFechaPedido() + "] "));
        System.out.println("\nPedidos ordenados por fecha de + reciente a - con colección");
        pedidosOrdenadosFecha.stream().forEach(p -> System.out.println(p.getIdPedido() + " [" + p.getFechaPedido() + "] "));

        //Tenemos que crear un mapa que tenga com clave el total del pedido y como value el pedido, coger pedido, calcular el total y pedir pedido como value
        //Creamos un treemap con el total del pedido como clave
        System.out.println("\nVamos a listar pedidos en un mapa que tenga como clave el total del pedido y como value el pedido");

        //Si ponemos TREEMAP ordenamos la clave de - a + en el segundo bucle después de pedidosConTotales.
        TreeMap<Double, Pedido> pedidosConTotales = new TreeMap();
        for (Pedido p : pedidos) {
            pedidosConTotales.put(totalPedido(p), p);
            //System.out.println(p.getIdPedido() + " IMPORTE= "+ totalPedido(p));  Mostramos la colecció antigua
        }

        //Mostramos la nueva colección
        for (Double total : pedidosConTotales.descendingKeySet()) { //.key_ nos permite hacer de todo, son los criterios de ordenación 
            //forEach con claves, nos permiten acceder al value directamente
            System.out.println(pedidosConTotales.get(total).getIdPedido() + " - " + total);//Mostramos la nueva colección
        }

        /*HashMap <Double,Pedido> pedidosConTotales=new HashMap();
        for (Pedido p : pedidos) {
            pedidosConTotales.put(totalPedido(p), p);
            //System.out.println(p.getIdPedido() + " IMPORTE= "+ totalPedido(p));  Mostramos la colecció antigua
        }
        
        //Mostramos la nueva colección
        for (Double total : pedidosConTotales.keySet()) { //.key_ nos permite hacer de todo, son los criterios de ordenación 
            //forEach con claves, nos permiten acceder al value directamente
            System.out.println(pedidosConTotales.get(total).getIdPedido() + " - "+ total);//Mostramos la nueva colección
        }*/
        
        //Creamos un treemap de clientes con el total gastado como clave
        System.out.println("\nVamos a crear una colección de clientes en un mapa cuya clave sea el total y como value el cliente");
        TreeMap<Double, Cliente> clientesConTotales = new TreeMap();
        for (Cliente c : clientes.values()) { //Cogemos los values y los metemos en un TreeMap
            //Aquí podríamos peoner un if (totalC (c)>0) para que sol imoprima los que ya tengan gastos
            clientesConTotales.put(totalCliente(c), c);
        }

        for (Double totalC : clientesConTotales.descendingKeySet()) {
            System.out.println(clientesConTotales.get(totalC).getIdCliente() + " - " + clientesConTotales.get(totalC).getNombre() + " - " + totalC);
        }

        //Vamos hacer una lista para cada sección y llevamos los artículos correspondientes a sus respectivas listas
        //Creamos una lista para cada sección de artículos
        System.out.println("\nCrear una colección List con los artículos de cada secciòn");
        List<Articulo> perifericos, almacenamiento, monitores, impresoras;

        //Forma actualizada con streams y collect
        perifericos = articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("1-"))
                .collect(Collectors.toList());
        almacenamiento = articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("2-"))
                .collect(Collectors.toList());
        impresoras = articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("3-"))
                .collect(Collectors.toList());
        monitores = articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("4-"))
                .collect(Collectors.toList());

        System.out.println("\n" + perifericos + "\n" + almacenamiento + "\n" + impresoras + "\n" + monitores);

        //Forma tradicional
        for (Articulo a : articulos.values()) {
            //Para que funcione el switch debemos declarar 4 ArrayList diferentes para cada sección, ahora funciona porque ya están declaradas las listas de arriba con streams, sin los stream son necesarios los Array
            switch (a.getIdArticulo().charAt(0)) {
                case '1':
                    perifericos.add(a);
                    break;
                case '2':
                    almacenamiento.add(a);
                    break;
                case '3':
                    impresoras.add(a);
                    break;
                case '4':
                    monitores.add(a);
                    break;
            }
        }
        System.out.println("\n" + perifericos + "\n" + almacenamiento + "\n" + impresoras + "\n" + monitores);

        //Borrando elementos; eliminamos los artículos de la sección impresora "3"
        //articulos.values().removeIf(a -> a.getIdArticulo().startsWith("3")); //Borramos solo la condición, articulos de la sección impresoras
        System.out.println("\n");
        articulos.values().stream()
                .forEach(a -> System.out.println(a));

        //BORRAR LOS PEDIDOS 
        //LAS COLECCIONES DE TIPO LISTA NO ACEPTAN REMOVEIF                         HACE FALTA REVISAR LOS APUNTES DEL 26/02 DE TEAMS
        /*ARCHIVOS -> Pasamos de un carga datos a almacenarlos para que estén permanentemente en funcionamiento, es necesario hacer copias de seguridad de estos mismo datos para evitar perder datos.
        Posteriormente llegaremos a enlazar las bases de datos con el programa, solo nuestro programa puede leer estos archivos, esto genera una dependencia, el mismo programa que cree los archivos es el único que puede leerlos,
        sin embargo, hoy en día la mayoría de bases de datos se pueden utilizar en diferentes programas (MySQL), esto se debe a detrás de toda aplicación web hay una base de datos, debido a esto se sincronizan los estudiso de
        Bases de datos y Programación.
        
        Ahora vamos a crear "TUBERÍAS" para poder acceder a los archivos desde nuestro programa hacia donde se encuentren los datos, todo esto mediante el scanner, nos va permitir conectarnos de foram remota a dichos archivos.
        Vamos aprender: Crear carpetas, cambiar el nombre del archivo etc. Todo esto desde dentro del programa con el objeto File...
        
        FILE: con ella podemos declarar/crear un nuevo archivo [File f= new File("libros.txt")]. Crea el archivo en la carpeta en la que estamos trabajando, es decir donde se alamacena el proyecto de java, también podemos asignar
        nostros dónde se almacena el archivo:
        
        LA CLASE FILE Se usa para crear, eliminar y obtener información sobre archivos y directorios. En general para realizar todas las operaciones básicas a nivel de Sistema de Archivos en un Sistema Operativo.
        Un objeto de la clase Java File representa un archivo o directorio. La clase tiene varios constructores, pero nos limitaremos a ver el más sencillo, que nos permitirá crear un objeto File asociado al archivo
        o directorio especificado como parámetro: 
        (1) File f = new File("libros.txt"); La ruta o path dónde se va a crear el archivo “archivo1.txt” puede ser: 
        
        -Directorio actual de trabajo (1) - cuando sólo se especifica un nombre de archivo. 
        -Relativa (2) - (una subcarpeta a partir del directorio actual). [File f = new File("pruebas/libros.txt");]
        -Absoluta (3)  - (una subcarpeta de la que se especifica su ruta completa desde la raíz del sistema de archivos. [File f = new File("c:/documentos/pruebas/libros.txt");] */
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Archivos">
    
    /**
     * Genera varios archivos de texto con información de la tienda y los lee.
     * 
     * El étodo crea archivos .txt y .csv con datos de clientes, artículos
     * y pedidos, y después muesstra su contenido por pantalla para comprobar
     * que la escritura se ha realizado correctamente.
     */
    private void archivos() {
        
        //Creamos un archivo de texto con todos los clientes
        System.out.println("Vamos a almacenar los clientes en un archivo de texto");
        File f = new File("Clientes.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {

            for (Cliente c : clientes.values()) {
                bw.write(c.toString());
                bw.newLine();
            }
            
            //Mostramos información básica del archivo creado
            System.out.println("Nombre: " + f.getName());
            System.out.println("Ruta: " + f.getAbsolutePath());
            System.out.println("Tamaño en Bytes: " + f.length());
            System.out.println("Fecha Última modificación: " + new Date(f.lastModified()));

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }
        
        //Leemos el archivo de clientes para comprobar su contenido
        System.out.println("\nMostramos la lista de Clientes:");
        try (Scanner scf = new Scanner(new File("Clientes.txt"))) {
            while (scf.hasNextLine()) {
                System.out.println(scf.nextLine());
            }
        } catch (FileNotFoundException E) {
            System.out.println("El archivo NO EXISTE");

        }
        
                        //REPETIMOS EL PROCESO PARA ARTÍCULOS Y PEDIDOS

        System.out.println("\nVamos almacenar los artículos en un archivo de texto");
        File g = new File("Articulos.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(g))) {
            
            /*Guardamos todos los artículos estén activos o inactivos, ya que a estos archivos solo pueden acceder los empleados de la tienda
            se puede hacer un método que solo guarde los activos en caso de que un cliente necesite un archivo con dichos artículos*/
            for (Articulo a : articulos.values()) {
                bw.write(a.getIdArticulo() + " - " + a.getDescripcion() + "= " + a.getPvp() + " euros");
                bw.newLine();
            }

            System.out.println("Nombre: " + g.getName());
            System.out.println("Ruta: " + g.getAbsolutePath());
            System.out.println("Tamaño en Bytes: " + g.length());
            System.out.println("Fecha Última modificación: " + new Date(g.lastModified()));

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }

        System.out.println("\nMostramos la lista de Articulos:");
        try (Scanner scf = new Scanner(new File("Articulos.txt"))) {
            while (scf.hasNextLine()) {
                System.out.println(scf.nextLine());
            }
        } catch (FileNotFoundException E) {
            System.out.println("El archivo NO EXISTE");

        }

        System.out.println("\nVamos almacenar los pedidos en un archivo de texto");
        //File h = new File("Pedidos.txt"); declaración innecesaria, declaramos dentro del paréntesis del FileWriter

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Pedidos.txt"))) {

            for (Pedido p : pedidos) {
                bw.write(p.toString());
                bw.newLine();
            }

            System.out.println("Nombre: " + g.getName());
            System.out.println("Ruta: " + g.getAbsolutePath());
            System.out.println("Tamaño en Bytes: " + g.length());
            System.out.println("Fecha Última modificación: " + new Date(g.lastModified()));
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }
        
        System.out.println("\nMostramos la lista de Pedidos:");
        try (Scanner scf = new Scanner(new File("Pedidos.txt"))) {
            while (scf.hasNextLine()) {
                System.out.println(scf.nextLine());
            }
        } catch (FileNotFoundException E) {
            System.out.println("El archivo NO EXISTE");

        }
        
            //ARCHIVO PARA CLIENTES QUE SOLO QUIEREN LOS ARTÍCULOS ACTIVOS
            System.out.println("\nVamos almacenar los artículos activos en un archivo de texto");
        File h = new File("ArticulosActivos.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(h))) {

            // Guardamos solo los artículos activos porque representan el catálogo actual
            for (Articulo a : articulos.values()) {
                if (a.isActivo()) {
                    bw.write(a.getIdArticulo() + " - " + a.getDescripcion()
                            + " = " + a.getPvp() + " euros");
                    bw.newLine();
                }
            }

            System.out.println("Nombre: " + h.getName());
            System.out.println("Ruta: " + h.getAbsolutePath());
            System.out.println("Tamaño en Bytes: " + h.length());
            System.out.println("Fecha Última modificación: " + new Date(h.lastModified()));

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }

        System.out.println("\nMostramos la lista de Articulos activos:");
        try (Scanner scf = new Scanner(new File("ArticulosActivos.txt"))) {
            while (scf.hasNextLine()) {
                System.out.println(scf.nextLine());
            }
        } catch (FileNotFoundException E) {
            System.out.println("El archivo NO EXISTE");
        }

        System.out.println("");

        //Debemos copiar y pegar la dirección de memoria dónde querenos crear el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.csv"))) {
            for (Cliente c : clientes.values()) {
                bw.write(c.getIdCliente() + ", " + c.getNombre() + ", " + c.getTelefono() + ", " + c.getEmail() + "\n");
            }
            System.out.println("Archivo clientes.csv creado correctamente");
        } catch (Exception e) {
            System.out.println("No se ha podido crear el archivo clientes.csv");
        }
        System.out.println("");
    }

    /**
     * Lee archivos de clientes en formato de texto y CSV.
     * 
     * Primero muestra por pantalla el contenido del archivo clientes.txt y
     * después reconstruye una nueva colección HashMap a parti del archivo
     * clientes.cvs.
     */
    private void leeCliente() {
        
        //Leemos línea a línea el archivo de texto plano
        System.out.println("Vamos a leer el archivo clientes.txt:");

        //LEE LAS LÍNEAS DEL ARCHIVO clientes.txt Y MUESTRA POR PANTALLA
        try (Scanner scClientes = new Scanner(new File("clientes.txt"))) {
            while (scClientes.hasNextLine()) {
                System.out.println(scClientes.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //reconstruimos uan nueva colección de clientes a partir del CSV
        System.out.println("\n\n");
        //CREAR UNA NUEVA COLECCIÓN DE TIPO HASHMAP A PARTIR DEL ARCHIVO clientes.csv
        HashMap<String, Cliente> clientesAux = new HashMap();
        try (Scanner scClientes = new Scanner(new File("clientes.csv"))) {
            while (scClientes.hasNextLine()) {
                String[] atributos = scClientes.nextLine().split("[,]");
                Cliente c = new Cliente(atributos[0], atributos[1], atributos[2], atributos[3]);
                clientesAux.put(atributos[0], c);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //Mostramos la nueva colección reconstruida
        System.out.println("\nListado de Clientes del nuevo HashMap clientesAux\n");
        clientesAux.values().forEach(System.out::println);
        //Art de cada seccion a un archivo para cada sección dando una sola vuelta de articulos, 4 buffer writer separados por comas
    }

    /**
     * Guarda los artículos en cuatro archivos CSV separados por sección.
     * 
     * Crea un archivo distinto para periféricos, almacenamiento, impresoras
     * y monitores. Después lee esos archivos t muestra su contenido.
     */
    private void gauardaArtPorSeccion() {
        
                //GUARDAMOS TODOS LOS ARTÍCULO, ACTIVOS Y NO ACTIVOS
        //Abrimos cuatro canales de escrituram, uno por cada sección, no hace falta poner la ruta directa del archivo 
        try (BufferedWriter bwPerifericos = new BufferedWriter(new FileWriter("perifericos.csv")); 
             BufferedWriter bwAlmacenamiento = new BufferedWriter(new FileWriter("almacenamiento.csv")); 
             BufferedWriter bwImpresoras = new BufferedWriter(new FileWriter("impresoras.csv")); 
             BufferedWriter bwMonitores = new BufferedWriter(new FileWriter("monitores.csv"))) {
            
            //Recorremos todos los artículos y los enviamos al archivo de su sección
            for (Articulo a : articulos.values()) {
                switch (a.getIdArticulo().charAt(0)) {
                    case '1':
                        bwPerifericos.write(a.getIdArticulo() + "," + a.getDescripcion() + "," + a.getExistencias() + "," + a.getPvp());
                        bwPerifericos.newLine();
                        break;

                    case '2':
                        bwAlmacenamiento.write(a.getIdArticulo() + "," + a.getDescripcion() + "," + a.getExistencias() + "," + a.getPvp());
                        bwAlmacenamiento.newLine();
                        break;

                    case '3':
                        bwImpresoras.write(a.getIdArticulo() + "," + a.getDescripcion() + "," + a.getExistencias() + "," + a.getPvp());
                        bwImpresoras.newLine();
                        break;

                    case '4':
                        bwMonitores.write(a.getIdArticulo() + "," + a.getDescripcion() + "," + a.getExistencias() + "," + a.getPvp());
                        bwMonitores.newLine();
                        break;
                    default:
                        throw new AssertionError();
                }

            }
            System.out.println("Archivos creados correctamente");
        } catch (Exception e) {
            //Si hay un error, eliminamos los archivos creados de forma incompleta
            System.out.println("No se han podido crear los archivos");
            File f = new File("perifericos.csv");//Borramos el archivo solo se ejecuta si hay algún problema en el try con la conexxión con esos archivos
            f.delete();
            f = new File("almacenamiento.csv");
            f.delete();
            f = new File("impresoras.csv");
            f.delete();
            f = new File("monitores.csv");
            f.delete();
        }
        
        //Leemos lso cuatro archivos creados para comprobar su contenido
        System.out.println("\nAhora vamos a leer cada archivo de sección");

        //LEE LAS LÍNEAS DEL ARCHIVO clientes.txt Y MUESTRA POR PANTALLA
        try (Scanner scPerifericos = new Scanner(new File("perifericos.csv")); 
             Scanner scAlmacenamiento = new Scanner(new File("almacenamiento.csv"));
             Scanner scImpresoras = new Scanner(new File("impresoras.csv"));
             Scanner scMonitores = new Scanner(new File("monitores.csv"))) {

            System.out.println("\nPeriféricos:");
            while (scPerifericos.hasNextLine()) {
                System.out.println(scPerifericos.nextLine());
            }

            System.out.println("\nAlmacenamiento:");
            while (scAlmacenamiento.hasNextLine()) {
                System.out.println(scAlmacenamiento.nextLine());
            }

            System.out.println("\nImpresoras:");
            while (scImpresoras.hasNextLine()) {
                System.out.println(scImpresoras.nextLine());
            }

            System.out.println("\nMonitores:");
            while (scMonitores.hasNextLine()) {
                System.out.println(scMonitores.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
                //GUARDAMOS SOLO AQUELLOS QUE ESTÁN ACTIVOS
                try (BufferedWriter bwPerifericos = new BufferedWriter(new FileWriter("perifericosActv.csv"));
                        BufferedWriter bwAlmacenamiento = new BufferedWriter(new FileWriter("almacenamientoActv.csv")); 
                        BufferedWriter bwImpresoras = new BufferedWriter(new FileWriter("impresorasActv.csv")); 
                        BufferedWriter bwMonitores = new BufferedWriter(new FileWriter("monitoresActv.csv"))) {

            // Recorremos todos los artículos, pero exportamos solo los activos
            for (Articulo a : articulos.values()) {

                //Comprobamos que el artículo está activo
                if (a.isActivo()) {
                    switch (a.getIdArticulo().charAt(0)) {
                        case '1':
                            bwPerifericos.write(a.getIdArticulo() + ","
                                    + a.getDescripcion() + ","
                                    + a.getExistencias() + ","
                                    + a.getPvp());
                            bwPerifericos.newLine();
                            break;

                        case '2':
                            bwAlmacenamiento.write(a.getIdArticulo() + ","
                                    + a.getDescripcion() + ","
                                    + a.getExistencias() + ","
                                    + a.getPvp());
                            bwAlmacenamiento.newLine();
                            break;

                        case '3':
                            bwImpresoras.write(a.getIdArticulo() + ","
                                    + a.getDescripcion() + ","
                                    + a.getExistencias() + ","
                                    + a.getPvp());
                            bwImpresoras.newLine();
                            break;

                        case '4':
                            bwMonitores.write(a.getIdArticulo() + ","
                                    + a.getDescripcion() + ","
                                    + a.getExistencias() + ","
                                    + a.getPvp());
                            bwMonitores.newLine();
                            break;
                    }
                }
            }

            System.out.println("\nArchivos creados correctamente");

        } catch (Exception e) {
            System.out.println("No se han podido crear los archivos");
            File f = new File("perifericosActv.csv");
            f.delete();
            f = new File("almacenamientoActv.csv");
            f.delete();
            f = new File("impresorasActv.csv");
            f.delete();
            f = new File("monitoresActv.csv");
            f.delete();
        }
                
    }

    /**
     * Lee los archivos CVS de artículos por sección y reconstruye un HashMap.
     * 
     * Además de mostrar por pantalla el contenido de cada archivo, este método
     * vuleve a crear una colección auxiliar de artículos a partir de los datos
     * leídos desde texto.
     */
    private void leeArticulosPorSeccion() {
        
        //Colección auxiliar deonde iremos guradando los artículos reconstruidos
        HashMap<String, Articulo> articulosAux = new HashMap();
        String lineaArchivo; //para ir leyendo cada línea en los archivos
        String[] atributos; //Para "romper" cada línea en los atributos separados por ,

        try (Scanner scPerifericos = new Scanner(new File("perifericos.csv")); 
             Scanner scAlmacenamiento = new Scanner(new File("almacenamiento.csv")); 
             Scanner scImpresoras = new Scanner(new File("impresoras.csv")); 
             Scanner scMonitores = new Scanner(new File("monitores.csv"))) {
            
            //Leemos cada arcivo línea a línea, mostramos su contenido y creamos los objetos
            /* ADEMÁS DE MOSTRAR POR PANTALLA EL CONTENIDO DE LOS 4 ARCHIVOS CREADOS
            APROVECHAMOS PARA RECONSTRUIR UN HashMap CON LOS ARTICULOS DE LOS 4 ARCHIVOS */

            System.out.println("\nPERIFERICOS:");
            while (scPerifericos.hasNextLine()) {
                //leo una línea del archivo
                lineaArchivo = scPerifericos.nextLine();
                //Imprimo línea por pantalla
                System.out.println(lineaArchivo);
                //con esa línea creamos un nuevo Articulo para añadir al HashMap articulosAux
                atributos = lineaArchivo.split("[,]");
                articulosAux.put(atributos[0],
                        new Articulo(atributos[0], atributos[1], Integer.parseInt(atributos[2]), Double.parseDouble(atributos[3])));

            }
            System.out.println("\nALMACENAMIENTO:");
            while (scAlmacenamiento.hasNextLine()) {
                lineaArchivo = scAlmacenamiento.nextLine();
                System.out.println(lineaArchivo);
                atributos = lineaArchivo.split("[,]");
                articulosAux.put(atributos[0],
                        new Articulo(atributos[0], atributos[1], Integer.parseInt(atributos[2]), Double.parseDouble(atributos[3])));
            }
            System.out.println("\nIMPRESORAS:");
            while (scImpresoras.hasNextLine()) {
                lineaArchivo = scImpresoras.nextLine();
                System.out.println(lineaArchivo);
                atributos = lineaArchivo.split("[,]");
                articulosAux.put(atributos[0],
                        new Articulo(atributos[0], atributos[1], Integer.parseInt(atributos[2]), Double.parseDouble(atributos[3])));
            }
            System.out.println("\nMONITORES:");
            while (scMonitores.hasNextLine()) {
                lineaArchivo = scMonitores.nextLine();
                System.out.println(lineaArchivo);
                atributos = lineaArchivo.split("[,]");
                articulosAux.put(atributos[0],
                        new Articulo(atributos[0], atributos[1], Integer.parseInt(atributos[2]), Double.parseDouble(atributos[3])));

            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        //MOSTRAMOS POR PANTALLA EL CONTENIDO DEL HASHMAP articulosAux QUE HEMOS IDO CREANDO CON LOS ARTICULOS DE LOS 4 ARCHIVOS
        System.out.println("");
        System.out.println("MOSTRAMOS POR PANTALLA EL CONTENIDO DEL HASHMAP articulosAux QUE HEMOS IDO CREANDO CON LOS ARTICULOS DE LOS 4 ARCHIVOS");
        for (Articulo a : articulosAux.values()) {
            System.out.println(a);
        }
        
        System.out.println("\nLECTURA DE ARCHIVOS DE ARTÍCULOS ACTIVOS");

        try (Scanner scPerifericos = new Scanner(new File("perifericosActv.csv"));//
             Scanner scAlmacenamiento = new Scanner(new File("almacenamientoActv.csv"));//
             Scanner scImpresoras = new Scanner(new File("impresorasActv.csv"));//
             Scanner scMonitores = new Scanner(new File("monitoresActv.csv"))) {

            // PERIFÉRICOS ACTIVOS
            System.out.println("\nPERIFÉRICOS ACTIVOS:");
            while (scPerifericos.hasNextLine()) {
                System.out.println(scPerifericos.nextLine());
            }

            // ALMACENAMIENTO ACTIVO
            System.out.println("\nALMACENAMIENTO ACTIVO:");
            while (scAlmacenamiento.hasNextLine()) {
                System.out.println(scAlmacenamiento.nextLine());
            }

            // IMPRESORAS ACTIVAS
            System.out.println("\nIMPRESORAS ACTIVAS:");
            while (scImpresoras.hasNextLine()) {
                System.out.println(scImpresoras.nextLine());
            }

            // MONITORES ACTIVOS
            System.out.println("\nMONITORES ACTIVOS:");
            while (scMonitores.hasNextLine()) {
                System.out.println(scMonitores.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer los archivos de artículos activos. Verifica que existen.");
        }
    }

    /**
     * Exporta las colecciones principales de la tienda a archivos binarios.
     * 
     * Serializa artículos, clientes y pedidos en tres archivos .dat distintos
     * para poder recuperarlos más adelante mediante ObjectInpuntStream.
     */
    public void exportarColecciones() {

        //Para poder serializarlos debemos añadir implements Serilizable en las clases de las colecciones de que queremos guardar
        //Abrimos un flujo binario distinto para cada colección
        try (ObjectOutputStream oosArticulos = new ObjectOutputStream(new FileOutputStream("articulos.dat"));//OOS= ObjectOutputStream
                ObjectOutputStream oosClientes = new ObjectOutputStream(new FileOutputStream("clientes.dat"));//1
                ObjectOutputStream oosPedidos = new ObjectOutputStream(new FileOutputStream("pedidos.dat"))) {

            //Nos conectamos objeto a objeto y los empaquetamos en 3 archivos de distintos, accede a la referencia en la memoria y los empaqueta.
            //En el examen solo tendremos que agregar nuevos archivos siguiendo los criterios de los ejercicios que nos harán cambiar los bucles por dentro para acceder a información más específica. ejemplo archivo con clientes con pedidos superiores a 100 euros
            //GUARDAMOS TODOS LOS ARTÍCULOS, ESTÉN ACTIVOS O INACTIVOS
            for (Articulo a : articulos.values()) {
                oosArticulos.writeObject(a);
            }

            //Escribimos todos los clientes en su archivo binario
            for (Cliente c : clientes.values()) {
                oosClientes.writeObject(c);
            }

            //Escribimos todos los pedidos en su archivo binario
            for (Pedido p : pedidos) {
                oosPedidos.writeObject(p);
            }
            System.out.println("Copia de seguridad realizada con éxito");

            //IOException para cualquier cosa rara.
        } catch (IOException ex) {
            //Si falla la exportación, eliminamos los archivos para no dejar copias corruptas
            System.out.println("No se ha podido realizar la copia de Seguridad correspodiente, " + "revisa unidades de almacenamiento de nuevo");
            File f = new File("articulos.dat");
            f.delete();
            f = new File("clientes.dat");
            f.delete();
            f = new File("pedidos.dat");
            f.delete();
        }
    }

    /**
     * Importa las colecciones principales desde archivos binarios
     * 
     * Lee artículos, clientes y pedidos desde sus respectivos archivos .dat y
     *  reconstruye las colecciones en memoria. Cada archivo se lee por separado
     * para controlar correctamente la EOFException.
     */
    public void importarColecciones() {
        /* HAY QUE LEER DESDE CADA ARCHIVO POR SEPARADO PORQUE SI INTENTAMOS METERLO TODO EN EL MISMO
        TRY-CATCH AL LLEGAR AL FINAL DEL PRIMER ARCHIVO SE PRODUCE LA EOFException Y SÓLO SE 
        LEERÍA BIEN EL PRIMER ARCHIVO, EL RESTO NO */

        // A la hora de la lectura hay que hacerlo archivo a archivo, es decir un try catch para cada archivo con su respectivo bucle
        //Leemos el archivo de artículos y reconstruimos el HashMap artículos
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream("articulos.dat"))) {
            Articulo a;
            while ((a = (Articulo) oisArticulos.readObject()) != null) {
                articulos.put(a.getIdArticulo(), a);
                /*Mientras al leer el objeto no sea null convierte lo que estás leyendo lo empaquetas en el HashMap a, lo estamos regrenerando. SIEMPRE seguidos de los 3 catch
                NUNCA AÑADIR EL THROW*/

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {
            System.out.println("Finalizada la lectura del archivo articulos.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }

                    //REPETIMOS EL PROCESO PARA CLIENTES Y PEDIDOS
        try (ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            Cliente c;
            while ((c = (Cliente) oisClientes.readObject()) != null) {
                clientes.put(c.getIdCliente(), c);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {
            System.out.println("Finalizada la lectura del archivo clientes.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }

        try (ObjectInputStream oisPedidos = new ObjectInputStream(new FileInputStream("pedidos.dat"))) {
            Pedido p;
            while ((p = (Pedido) oisPedidos.readObject()) != null) {
                pedidos.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {
            System.out.println("Finalizada la lectura del archivo pedidos.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }

        /*TEXTO: Bufferwriter es canal
        BINARIOS: ObjectInpit stream es el canal
        
        EXAMEN 19
        Vamos a hacer consultas ya se a por texto y proceimeintos, debemos crear los canalas de comunincación adecuados para cada archivo*/
    }

    //VAMOS A CREAR POSIBLES EJEMPLOS DE ARCHIVOS SERIALIZABLES PARA EL EXAMEN
    //Guardar en 4 archivos cada una de las secciones en .dat esto no se ejecuta si no salimos del menú, hasta que no salga del menú no se exportan los archivos ni pide la sección por teclado
    /**
     * Exporta los artículo de cada sección a archivos binarios indenpendientes.
     * 
     * Crea un archivo .dat para cada sección de artículos que están activos, ya que
     * son loa  que siguen disponibles para la venta. Al finalizar,
     * permite comprobar por pantalla el contenido de uno de esos archivos.
     */
    public void exportarSeccion() {

        //Abrimos cuatro flujos de salida, uno para cada sección
        try (ObjectOutputStream oosPerifericos = new ObjectOutputStream(new FileOutputStream("perifericos.dat"));//OOS= ObjectOutputStream, solo hace falta poner el nombre del archivo
                ObjectOutputStream oosAlmacenamiento = new ObjectOutputStream(new FileOutputStream("almacenamiento.dat")); 
                ObjectOutputStream oosImpresoras = new ObjectOutputStream(new FileOutputStream("impresoras.dat"));
                ObjectOutputStream oosMonitores = new ObjectOutputStream(new FileOutputStream("monitores.dat"))) {

            //Recorremos todos los artículos y los enviamos al archivo de su sección
            //Nos conectamos objeto a objeto y los empaquetamos en 3 archivos de distintos, accede a la referencia en la memoria y los empaqueta.
            //En el examen solo tendremos que agregar nuevos archivos siguiendo los criterios de los ejercicios que nos harán cambiar los bucles por dentro para acceder a información más específica. ejemplo archivo con clientes con pedidos superiores a 100 euros
            for (Articulo a : articulos.values()) {
                switch (a.getIdArticulo().charAt(0)) {
                    case '1':
                        oosPerifericos.writeObject(a);
                        break;

                    case '2':
                        oosAlmacenamiento.writeObject(a);
                        break;

                    case '3':
                        oosImpresoras.writeObject(a);
                        break;

                    case '4':
                        oosMonitores.writeObject(a);
                        break;
                    default:
                        throw new AssertionError();
                }

                //oosArticulos.writeObject(a);
            }
            System.out.println("Copia de seguridad de las secciones de artículos realizada con éxito");

            //IOException para cualquier cosa rara.
        } catch (IOException ex) {
            //Si algo falla, borramos los archivos generados
            System.out.println("No se ha podido realizar la copia de Seguridad correspodiente, " + "revisa unidades de almacenamiento de nuevo");
            File f = new File("periferico.dat");
            f.delete();
            f = new File("almacenamiento.dat");
            f.delete();
            f = new File("impresoras.dat");
            f.delete();
            f = new File("monitores.dat");
            f.delete();
            
        /* PARA COMPROBAR QUE FUNCIONA, VERIFICAMOS QUE SE HAN CREADO LOS 4 ARCHIVOS EN LA CARPETA
        RAÍZ DEL PROYECTO CON LA FECHA Y HORA ACTUAL - 
        ... Y PARA COMPROBAR EL CONTENIDO DE LOS ARCHIVOS LEEREMOS/IMPRIMIREMOS "AL VUELO" SÓLO 1 DE ELLOS
         CUYA SECCION SOLICITAMOS POR TECLADO
        */
        }
        
        //Pedimos una sección por teclado y leemos su archivo para comprobarlo
        System.out.println("Teclea la Seccion de los articulos CUYO ARCHIVO QUIERES COMPROBAR:");
        char seccion = sc.next().charAt(0);
        String nombreArchivo = null;
        switch (seccion) {
            case '1':
                nombreArchivo = "perifericos.dat";
                break;
            case '2':
                nombreArchivo = "almacenamiento.dat";
                break;
            case '3':
                nombreArchivo = "impresoras.dat";
                break;
            case '4':
                nombreArchivo = "monitores.dat";
                break;
        }
        Articulo a;
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while ((a = (Articulo) oisArticulos.readObject()) != null) {
                System.out.println(a);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {

        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }
    }
    
    //No se ejecuta hasta que salgamos del menú
    /**
     * Lee por pantalla el archivo binario correspondiente a una sección.
     * 
     * Solicita al usuario la sección deseada, localiza el archivo .dat asociado
     * y muestra todos los artículos almacenados en él.
     */
    public void leerSeccion() {
        
        //Pedimos la sección cuyo archivo queremos consultar
        System.out.println("Teclea la Seccion de los articulos CUYO ARCHIVO QUIERES COMPROBAR:");
        String seccion = sc.next();

        //Asociamos la sección al nombre del archivo
        String nombreArchivo = "";

        switch (seccion) {
            case "1":
                nombreArchivo = "perifericos.dat";
                break;
            case "2":
                nombreArchivo = "almacenamiento.dat";
                break;
            case "3":
                nombreArchivo = "impresoras.dat";
                break;
            case "4":
                nombreArchivo = "monitores.dat";
                break;
            default:
                System.out.println("Sección no válida");
                return;
        }

        //Leemos secuencialmente todos los artículos del archivo elegido
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {

            while (true) {
                Articulo a = (Articulo) ois.readObject();
                System.out.println(a);
            }

        } catch (EOFException e) {
            System.out.println("Fin del archivo");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
}
    
    /**
     * Importa los artículos de todas las secciones desde archivos binarios.
     * 
     * Lee los archivos .dat de periféricos, almacenamiento, impresoras y
     * monitores, y reconstruye el HashMap artículos en memoria.
     */
    public void importarSeccion(){
        
        //Importamos los artículos de la sección periféricos
        try (ObjectInputStream oisPerifericos = new ObjectInputStream(new FileInputStream("perifericos.dat"))) {
            Articulo a;
            while ((a = (Articulo) oisPerifericos.readObject()) != null) {
                articulos.put(a.getIdArticulo(), a);
                /*Mientras al leer el objeto no sea null convierte lo que estás leyendo lo empaquetas en el HashMap a, lo estamos regrenerando. SIEMPRE seguidos de los 3 catch
                NUNCA AÑADIR EL THROW*/

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {
            System.out.println("Finalizada la lectura del archivo perifericos.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }

                    //REPETIMOS EL PROCESO PARA ALMACENAMIENTO, IMPRESORAS Y MONITORES
        try (ObjectInputStream oisAlmacenamiento = new ObjectInputStream(new FileInputStream("almacenamiento.dat"))) {
            Articulo a;
            while ((a = (Articulo) oisAlmacenamiento.readObject()) != null) {
                articulos.put(a.getIdArticulo(), a);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {
            System.out.println("Finalizada la lectura del archivo almacenamiento.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }

        try (ObjectInputStream oisImpresoras = new ObjectInputStream(new FileInputStream("impresoras.dat"))) {
            Articulo a;
            while ((a = (Articulo) oisImpresoras.readObject()) != null) {
                articulos.put(a.getIdArticulo(), a);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {
            System.out.println("Finalizada la lectura del archivo impresoras.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }
        
        try (ObjectInputStream oisMonitores = new ObjectInputStream(new FileInputStream("monitores.dat"))) {
            Articulo a;
            while ((a = (Articulo) oisMonitores.readObject()) != null) {
                articulos.put(a.getIdArticulo(), a);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {
            System.out.println("Finalizada la lectura del archivo monitores.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }
        
        //Pedir por teclado la sección y luego mostrar dicho archivo por pantalla
        
    }
    
    /*public void leerSecciones(){
        System.out.println("Introduce la sección que quieres ver:");
        String seccion = sc.next();

        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE SECCIONES");
            System.out.println("\t\t\t\t1 - PERIFERICOS");
            System.out.println("\t\t\t\t2 - ALMACENAMIENTO");
            System.out.println("\t\t\t\t3 - IMPRESORAS");
            System.out.println("\t\t\t\t4 - MONITORES");
            System.out.println("\t\t\t\t9 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    altaArticulo();
                    break;
                }
                case 2: {
                    bajaArticulo();
                    break;
                }
                case 3: {
                    reposicionArticulo();
                    break;
                }
                case 4: {
                    listarArticulos();
                    break;
                }

            }

        } while (opcion != 9);
    }*/

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Examen 19/03/26">
    /**
     * Guarda los clientes ordenados alfabéticamente en un archivo de texto.
     * 
     * Utiliza streams para ordenar los clientes por nombre antes de escribirlos
     * en un archivo .txt, y después uestra el contenido del archivo por pantalla.
     */
    private void uno1(){
        //Creamos el archivo de salida
        System.out.println("Vamos a almacenar los clientes alfabéticamente en un archivo de texto");
        File f = new File("clientesOrdenados.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            //Ordenamos los clientes alfabétcamente ignorando mayúsculas/minúsculas
            clientes.values().stream().sorted(Comparator.comparing(c->c.getNombre().toLowerCase())).forEach(c-> {
                try {bw.write(c.toString());
                bw.newLine();
                    
                } catch (IOException e) {
                    System.out.println("Error escirbiendo cliente");
                }
            });
            System.out.println("Archivo creado correctamente");

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }

        //Leemos el archivo para comprobar su contenido
        System.out.println("\nMostramos la lista de Clientes:");
        try (Scanner scf = new Scanner(new File("clientesOrdenados.txt"))) {
            while (scf.hasNextLine()) {
                System.out.println(scf.nextLine());
            }
        } catch (FileNotFoundException E) {
            System.out.println("El archivo NO EXISTE");

        }

    }
    
    /**
     * Genera archivos binarios de pedidos separados por mes.
     * 
     * Recorre todos los pedidos de la tienda y guarda cada uno en el archivo
     * correspondiente a su mes de realización.
     */
    private void dos2(){
        System.out.println("Vamos a crear archivos de los pedidos de cada mes de la tienda");
       
        try (ObjectOutputStream oosEnero = new ObjectOutputStream(new FileOutputStream("pedidosEnero2026.dat"));//coment1
             ObjectOutputStream oosFebrero = new ObjectOutputStream(new FileOutputStream("pedidosFebrero2026.dat"));//comnt2
             ObjectOutputStream oosMarzo = new ObjectOutputStream(new FileOutputStream("pedidosMarzo2026.dat"));) {
            
            //Recorremos todos los pedidos y los clasificamos por mes
            for (Pedido p : pedidos) {
                int mes= p.getFechaPedido().getMonthValue();
                switch (mes) {
                    case 1:
                        oosEnero.writeObject(p);
                        break;
                        
                    case 2:
                        oosFebrero.writeObject(p);
                        break;
                    
                    case 3:
                        oosMarzo.writeObject(p);
                        break;
                }
            }
            System.out.println("Archivo creado correctamente");

        } catch (IOException e) {
            //Si falla la escritura, borramos los archivos generados
                        System.out.println("No se ha podido realizar la copia de Seguridad correspodiente, " + "revisa unidades de almacenamiento de nuevo");
            File f = new File("pedidosEnero2026.dat");
            f.delete();
            f = new File("pedidosFebrero2026.dat");
            f.delete();
            f = new File("pedidosMarzo2026.dat");
            f.delete();            
        }
        
/*        System.out.println("Teclea el MES CUYO ARCHIVO QUIERES COMPROBAR:"+ "\n1=Enero" + "\n2=Febrero" + "\n3=Febrero");
        char seccion = sc.next().charAt(0);
        String nombreArchivo = null;
        switch (seccion) {
            case '1':
                nombreArchivo = "pedidosEnero2026.dat";
                break;
            case '2':
                nombreArchivo = "pedidosFebrero2026.dat";
                break;
            case '3':
                nombreArchivo = "pedidosMarzo2026.dat";
                break;
        }
        Articulo a;
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while ((a = (Articulo) oisArticulos.readObject()) != null) {
                System.out.println(a);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (EOFException e) {

        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.toString());
        }*/
    }
    
    /**
     * Lee varios archivos binarios de pedidos mensuales y reconstruye una lista.
     * 
     * Importa los pedidos almacenados por meses en archivos .dat y los reúne en
     * un ArrayList auxiliar para mostrarlos posteriormente por pantalla.
     */
    public void tres3() {
        //Lista auxiliar donde reunimos todos los pedidos leídos de los archivos
        ArrayList<Pedido> pedidosPorMeses = new ArrayList<>();

        //Array todos los archivos y leemos su contenido
        String[] archivos = {
            "pedidosEnero2026.dat",
            "pedidosFebrero2026.dat",
            "pedidosMarzo2026.dat"};

        //Recorremos todos los archivos y leemos su contenido
        for (String archivo : archivos) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                while (true) {
                    Pedido p = (Pedido) ois.readObject();
                    pedidosPorMeses.add(p);
                }
         
            } catch (EOFException e) {
                System.out.println("Finalizada lectura pedidos" + archivo);
            } catch (Exception ex) {
                System.out.println("Error leyendo: " + archivo);
            }

            
        }
            //Mostramos la nueva lista conjunta de pedidos
            System.out.println("\nLISTADO ARRAYLIST pedidosPorMeses");
            for (Pedido p : pedidosPorMeses) {
                System.out.println(p + " - Total:" + totalPedido(p));
                
            } 
    }
    
    /**
     * Crea un archivo de texto por cada cliente con sus pedidos.
     * 
     * Para cada cliente se genera un archivo individual con sus pedidos y el
     * importe de cada uno. Si un cliente no tiene pedidos, su archivo se elimina.
     */
    public void cuatro4(){
        System.out.println("Vamos a crear archivos de pedidos por cliente");
        
        //Recorremos todos los clientes de la tienda
        for (Cliente c : clientes.values()) {
            boolean tienePedidos= false;
            
            //Creamos el archivo asociado al cliente actual
            try (BufferedWriter bw= new BufferedWriter(new FileWriter("pedidos_"+ c.getNombre().toLowerCase() + ".txt"))){
                
                //Escribimos únicamente los pedidos de ese cliente
                for (Pedido p : pedidos) {
                    if (p.getClientePedido().getIdCliente().equalsIgnoreCase(c.getIdCliente())) {
                        tienePedidos=true;
                        bw.write(p.getIdPedido() + "/" + p.getFechaPedido() + "," + totalPedido(p));
                        bw.newLine();
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo de " + c.getNombre());
            }
            
            //Si el cliente no tiene pedidos, borramos el archivo vacío
            if (!tienePedidos) {
                File f=new File("pedidos_"+ c.getNombre().toLowerCase() + ".txt");
                f.delete();
            }
        }
        System.out.println("Archivos creados correctamente");
    }
    
    /**
     * Calcula el total gastado por un cliente a partit de su archivo de pedidos.
     * 
     * Solicita el nombre del cliente , lee su archivo de texto y suma
     * los importes de todos los pedidos almacenados en él.
     */
    public void cinco5(){
        //sc.nextLine();//Limpiamos el buffer y pedimos el nombre del cliente
        System.out.println("Introduce el nombre del cliente (Ana, Edu, Juan, Lola)");
        String nombre= sc.next().trim().toLowerCase();
        
        //Construimos el nombre del archivo del cliente
        String nombreArchivo= "pedidos_" + nombre + ".txt";
        double totalGastado=0;
        
        try (Scanner scf=new Scanner(new File(nombreArchivo))){
            
            /*if (!scf.hasNextLine()) {
                System.out.println("El archivo está vacío");
                return;
            }*/

            //Leemos el archivo línea a línea y vamos sumando de cada pedido
            while (scf.hasNextLine()) {
                String linea = scf.nextLine();
                
                //Separamos los datos de cada línea
                String[] partes = linea.split(",");
                
                //Mostramos el total acumulado del cliente
                double totalPedido = Double.parseDouble(partes[1].trim());
                totalGastado+=totalPedido;
                
            }
            
            //Mostramos el total acumulado del cliente
            System.out.println("TOTAL GASTADO POR "+ nombre.toUpperCase()+ ": " + totalGastado + " euros");
        } catch (FileNotFoundException e) {
            System.out.println("El cliente no existe o no tiene pedidos");
        }
    }
    
//</editor-fold>
}
