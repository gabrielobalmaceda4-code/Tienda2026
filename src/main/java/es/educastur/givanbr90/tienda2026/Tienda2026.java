/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.educastur.givanbr90.tienda2026;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
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
            System.out.println("\t\t\t\t1 - NUUEVO PEDIDO");
            System.out.println("\t\t\t\t2 - LISTADO DE PEDIDOS");
            System.out.println("\t\t\t\t3 - TOTAL PEDIDO");
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
                case 3: {
                    totalPedido();
                    break;
                }

            }

        } while (opcion != 9);
    }
//</editor-fold>

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listado tradicional">
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
    private void altaArticulo() {
        Scanner sc= new Scanner (System.in);
        
    }

    private void bajaArticulo() {
        /*Solo tiene sentido guardar la información de dichos artículos ya sean activos=se venden, inactivos=no se venden, porque nos intereza tener guardados los artículos que he vendio anteriormente
        más que borar esos datos, los desactivo y los almaceno en un histórico para estén accesibles en el caso de ser necesarios, aunque no estén en el catálogo de ventas actual*/
    }

    private void reposicionArticulo() {

    }

    private void listarArticulos() {
        System.out.println("Vamos a mostrar los articulos de la tienda: ");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
            //System.out.print("\n" + a.getidArticulo() + "/" + a.getdescripción() + "/" + a.getexistencias() + "/" + a.getpvp());
        }
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
        System.out.println("Vamos a mostrar todos los clientes de la tienda: ");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
            //System.out.print("\n" + l.getIsbn() + "/" + l.getTitulo() + "/" + l.getAutor() + "/" + l.getGenero());
        }
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Gestión Pedidos">
    private void nuevoPedido() {

    }

    private void listadoPedido() {
        System.out.println("Vamos a mostrar los pedidos de la tienda: ");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }

    private void totalPedido() {

    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listados con STREAM">
    private void listadosConStreams() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Ordenar con STREAMS">
    private void ordenarConStream() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//</editor-fold>
}
