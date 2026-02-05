/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.educastur.givanbr90.tienda2026;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashAttributeSet;

/**
 *
 * @author 1dawd17
 */
public class Tienda2026 {

    static Scanner sc = new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap<String, Articulo> articulos; //String es la clave primaria de la base de datos, es obligatorio ponerlo, luego ponemos el objeto completo
    private HashMap<String, Cliente> clientes;

    public Tienda2026() {
        pedidos = new ArrayList();//Inicializamos los datos vacíos
        articulos = new HashMap();
        clientes = new HashMap();
    }

    public static void main(String[] args) {

        Tienda2026 t = new Tienda2026();
        /*Estamos declarando el proyecto como un objeto que contiene los demás métodos, su contructor estrará formado por el cargaDatos que las va arrancar desde 0
        -En el main declaramos el objeto Tienda2026 t, por lo tanto, todos los 
        -Nos permite que los métodos no sean static ya que todos los métodos le pertenecen a ese objeto*/

        t.cargaDatos();
        t.menu();
        //Si hacemos los métodos estáticos podemos llamarlos de la siguiente manera, sin necesidad del menú, esto es lo que va haber que entregar
        /*uno();
        -private static void uno(){
        }
         */

    }

    //<editor-fold defaultstate="collapsed" desc="Métodos auxiliares">
    public void cargaDatos() {

        clientes.put("80580845T", new Cliente("80580845T", "ANA ", "658111111", "ana@gmail.com"));
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 14, 15));//El primer nº es la sección y el siguiente el artículo
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 9, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 16, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        LocalDate hoy = LocalDate.now();
        pedidos.add(new Pedido("80580845T-001/2025", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<>(List.of(new LineaPedido("1-11", 3), new LineaPedido("4-22", 3)))));
        pedidos.add(new Pedido("80580845T-002/2025", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<>(List.of(new LineaPedido("4-11", 3), new LineaPedido("4-22", 2), new LineaPedido("4-33", 4)))));
        pedidos.add(new Pedido("36347775R-001/2025", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<>(List.of(new LineaPedido("4-22", 1), new LineaPedido("2-22", 3)))));
        pedidos.add(new Pedido("36347775R-002/2025", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<>(List.of(new LineaPedido("4-33", 3), new LineaPedido("2-11", 3)))));
        pedidos.add(new Pedido("63921307Y-001/2025", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<>(List.of(new LineaPedido("2-11", 5), new LineaPedido("2-33", 3), new LineaPedido("4-33", 2)))));
    }

    /**
     * Este método valora las posibles excepciones de stock
     *
     * @param idArticulo
     * @param unidades
     * @throws StockCero
     * @throws StockInsuficiente
     */
    private void stock(String idArticulo, int unidades) throws StockCero, StockInsuficiente {//Lanza las excepciones que hemos creado, ve las unidades del articulo que le pidamos
        //Cuando no quedan unidades lanza esta alarma, dando la info del throw
        if (articulos.get(idArticulo).getExistencias() == 0) {
            throw new StockCero("0 unidades disponibles de:"
                    + articulos.get(idArticulo).getDescripcion());
        }

        //Cuando nos piden más unidades de las que tenemos
        if (articulos.get(idArticulo).getExistencias() < unidades) {
            throw new StockInsuficiente("Sólo hay " + articulos.get(idArticulo).getExistencias() + " unidades disponibles de: "
                    + articulos.get(idArticulo).getDescripcion());
        }
    }
    
    private int udsVendidas (Articulo a){
        int total=0;
        for (Pedido p : pedidos) {
            for (LineaPedido l : p.getCestaCompra()) {
                if (l.getIdArticulo().equalsIgnoreCase(a.getIdArticulo())) {
                    total+=l.getUnidades();
                }
            }
        }
        return total;
        
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
            System.out.println("\t\t\t\t9 - SALIR");
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

            }

        } while (opcion != 9);

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
     * Listado de colecciones con for each
     */
    public void listarColecciones() {
        System.out.println("Vamos a mostrar todos los clientes de la tienda: ");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
            //System.out.print("\n" + l.getIsbn() + "/" + l.getTitulo() + "/" + l.getAutor() + "/" + l.getGenero());
        }
        System.out.println("");

        System.out.println("Vamos a mostrar los articulos de la tienda: ");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
            //System.out.print("\n" + a.getidArticulo() + "/" + a.getdescripción() + "/" + a.getexistencias() + "/" + a.getpvp());
        }
        System.out.println("");

        System.out.println("Vamos a mostrar los pedidos de la tienda: ");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gestión Artículos">
    /**
     * Agregamos un nuevo artículo a la tienda
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

    private void bajaArticulo() {
        /*Solo tiene sentido guardar la información de dichos artículos ya sean activos=se venden, inactivos=no se venden, porque nos intereza tener guardados los artículos que he vendio anteriormente
        más que borar esos datos, los desactivo y los almaceno en un histórico para estén accesibles en el caso de ser necesarios, aunque no estén en el catálogo de ventas actual*/
    }

    private void reposicionArticulo() {

    }

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
        System.out.println("SECCION A LISTAR: ");
        String seccion = sc.next();
        System.out.println("ARTICULOS DE LA SECCION" + " " + seccion);
        articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith(seccion))
                .sorted(Comparator.comparing(Articulo::getIdArticulo))
                .forEach(a -> System.out.println(a));

        //EJERCICO DOS
        System.out.println("\nPERIFERICOS");
        articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("1"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nALMACENAMIENTO");
        articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("2"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nIMPRESORAS");
        articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("3"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));
        System.out.println("\nMONITORES");
        articulos.values().stream()
                .filter(a -> a.getIdArticulo().startsWith("4"))
                .sorted(Comparator.comparing(Articulo::getIdArticulo)).forEach(a -> System.out.println(a));

        //EJERCICO CUATRO
        System.out.println("\nLISTADO DE ARTICULOS - UNIDADES VENDIDAS:");
        articulos.values().stream()
                .sorted(Comparator.comparing(a->udsVendidas((Articulo) a)).reversed())
                .forEach(a->System.out.println(
                a.getIdArticulo()+ " - " +
                a.getDescripcion()+" - vendidas " + udsVendidas(a)));
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gestión de Clientes">
    private void altaCliente() {

    }

    private void bajaCliente() {

    }

    private void modificarDatos() {

    }

    private void listarClientes() {
        /*System.out.println("Vamos a mostrar todos los clientes de la tienda: ");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
            //System.out.print("\n" + l.getIsbn() + "/" + l.getTitulo() + "/" + l.getAutor() + "/" + l.getGenero());
        }*/
        
        //EJERCICIO 3
        System.out.println("Introduce el DNI del cliente:");
        String dni = sc.next();
        double totalGastado = 0;
        System.out.println("\nPEDIDOS DEL CLIENTE " + dni);
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(dni)) {
                double total = totalPedido(p);
                System.out.println(p + " - TOTAL: " + total);
                totalGastado += total;
            }
        }
        System.out.println("\nTOTAL GASTADO POR EL CLIENTE: " + totalGastado + "euros");

        /*clientesAux.stream()
                .filter(c->c.getIdCliente().equals(dni))
                .forEach(p->totalPedido(Pedido p));
                //.sorted(Comparator.comparing(c->totalPedido(p)));
        /*clientes.values().stream()
                .filter(c->c.getIdCliente().equalsIgnoreCase(dni))
                .sorted(Comparator.comparing(Cliente::getIdCliente))
                .forEach(c->System.out.println(c));*/
        
        //EJERCICIO 5
        ArrayList<Cliente> clientesNoPedidos =new ArrayList<>();
        for (Cliente c : clientes.values()) {
            int contador=0;
            for (Pedido p: pedidos) {
                if (p.getClientePedido().getIdCliente().equalsIgnoreCase(c.getIdCliente())) {
                    contador++;
                }
            }
            
            if (contador==0) {
                clientesNoPedidos.add(c);
            }
        }
        System.out.println("CLIENTE SIN PEDIDOS:");
            for (Cliente c : clientesNoPedidos) {
                System.out.println(c);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Gestión Pedidos">
    /**
     * Generación de IdPedido
     *
     * @param idCliente
     * @return
     */
    public String generaIdPedido(String idCliente) {
        String nuevoId;
        int contador = 0;
        //Calculo el numero de pedidos de la persona
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)) {
                contador++;
            }
        }
        //Hemos calculado cuúantos pedidos tiene el cliente aportado con el contador

        contador++;//Sumamos 1 al contador para el nuevo pedido

        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();

        return nuevoId;
    }

    /**
     * Generamos un nuevo pedido teniendo en cuenta el método anterior
     */
    private void nuevoPedido() {
        sc.nextLine();
        String idCliente;
        do {
            System.out.println("DNI (id) CLIENTE:");
            idCliente = sc.next().toUpperCase();
            if (!clientes.containsKey(idCliente)) {
                System.out.println("No es cliente de la tienda."
                        + " Desea darse de alta o comprar como invitado ");
            }
        } while (!MetodosAuxiliares.validarDni(idCliente));

        //Controlamos que solo se pidan artículos de la tienda y de clientes de la tienda
        ArrayList<LineaPedido> cestaCompra = new ArrayList();
        String idArticulo;
        int unidades = 0;

        System.out.print("\nTeclee el ID del articulo deseado (FIN para terminar la compra):");
        idArticulo = sc.next();

        while (!idArticulo.equalsIgnoreCase("FIN")) {
            //Es mejor utilizar un while en lugar de un do while como en el commit anterior, con el do while estamos obligando a la persona a seguir con los atributos aunque no quiera comprar, se ve abajo del todo con do while
            System.out.print("\nTeclee las unidades deseadas: ");
            unidades = sc.nextInt();//Debemos valorar las execepciones llamando al método stock

            try {
                stock(idArticulo, unidades); //Debemos darle a la penúltima sugenrecia
                cestaCompra.add(new LineaPedido(idArticulo, unidades));//Si no pasa nada de las excepciones añadimos la linea a cestaCompra

                //Si damos por hecho que el pediddo se va cerrar, esto debería ir al final del código cuando estamnos seguros que se va afectuar el pedido
                //articulos.get(idArticulo).setExistencias(articulos.get(idArticulo).getExistencias()-unidades);
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());//Nos muestra el mensaje que fijamos en el método de stock cuando salta la excepción
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());//Aparte de mostrar el mensaje lo podemos matizar aún más
                System.out.println("Las quieres (SI/NO)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI")) {
                    cestaCompra.add(new LineaPedido(idArticulo, articulos.get(idArticulo).getExistencias()));//Le estamos dando las unidades que hay
                    //articulos.get(idArticulo).setExistencias(0);
                }
            }
            System.out.println("\nTeclee el ID del artículo deseado (FIN para terminar la compra)");
            idArticulo = sc.next();

        }

        if (!cestaCompra.isEmpty()) {
            System.out.println("Este es tu pedido:\n");
            double totalLinea = 0;
            double totalPedido = 0;
            for (LineaPedido l : cestaCompra) {//Recorremos el hashmap para almacenar la iformación de dicho pedido respecto al precio
                totalLinea = l.getUnidades() * articulos.get(l.getIdArticulo()).getPvp();//Calculamos el precio del pedido multiplicando las unidades por el precio del artículo
                totalPedido += totalLinea;//Aumentamos el total pedido en si aumenta la línea
                System.out.println(l.getIdArticulo() + " - "
                        + articulos.get(l.getIdArticulo()).getDescripcion() + " - "
                        + l.getUnidades() + " uds " + " - "
                        + articulos.get(l.getIdArticulo()).getPvp() + " euros cada uno");
            }
            System.out.println("\t\tEl precio total del pedido es " + totalPedido);
            System.out.println("\nProcedemos con la compra (SI/NO)");

            for (LineaPedido l : cestaCompra) {
                System.out.println(l.getIdArticulo() + "-"
                        + articulos.get(l.getIdArticulo()).getDescripcion() + " - " + l.getUnidades());
            }

            System.out.println("Desea proceder con la compra (SI/NO) ");
            String respuesta = sc.next();

            if (respuesta.equalsIgnoreCase("SI")) {
                pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente),
                        LocalDate.now(), cestaCompra));
                for (LineaPedido l : cestaCompra) {
                    articulos.get(l.getIdArticulo())
                            .setExistencias(articulos.get(l.getIdArticulo()).getExistencias() - l.getUnidades());
                }
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
     * Lista los pedidos con for each
     */
    private void listadoPedido() {
        System.out.println("Vamos a mostrar los pedidos de la tienda: ");
        for (Pedido p : pedidos) {
            System.out.println(p + "- Total: " + totalPedido(p));
        }
    }

    private double totalPedido(Pedido p) {
        double totalPedido = 0;
        for (LineaPedido l : p.getCestaCompra()) {
            totalPedido += l.getUnidades() * articulos.get(l.getIdArticulo()).getPvp();
        }
        return totalPedido;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Listados con STREAM">
    private void listadosConStreams() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Ordenar con STREAMS">
    /**
     * Ordenamos pedidos con streams y criterios de organización: atributo y
     * método
     */
    private void ordenarConStream() {
        System.out.println("Listado de pedidos ordenados de menor a mayor total: ");
        pedidos.stream().sorted(Comparator.comparing(Pedido::getIdPedido))//El criterio de ordenación es el que está en el paréntesis después del .comparing, en ese caso usamos un atributo como pedido
                .forEach(p -> System.out.println(p + " - " + totalPedido(p)));

        System.out.println("\nListado de pedidos ordenados de mayor a menor total: ");
        pedidos.stream().sorted(Comparator.comparing(Pedido::getIdPedido).reversed())
                .forEach(p -> System.out.println(p + " - " + totalPedido(p)));

        System.out.println("\nListado de pedidos ordenados usando como criterio un método de - a +: ");
        pedidos.stream().sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p -> System.out.println(p + " - " + totalPedido(p)));

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
}
