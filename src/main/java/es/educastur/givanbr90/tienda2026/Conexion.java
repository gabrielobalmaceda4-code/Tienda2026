/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.givanbr90.tienda2026;

/** SI EL PROYECTO SE HACE CON MAVEN, HAY QUE AÑADIR AL ARCHIVO pom.xml, en Project Files,
 * las dependencias para que Maven nos incorpore al proyecto el driver JDBC para MySQL
 *
 *  <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.22</version>
        </dependency>
    </dependencies>
    
    SI EL PROYECTO SE HACE EN JAVA "NORMAL", tendremos que descargar nosotros el archivo .jar del driver JDBC para MYSQL
    (buscar en google) e incorporarlo con la opción add .jar file en la seccion LIBRARIES del proyecto

 */
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3307/tienda2026?serverTimezone=UTC", "root", "");
                /*Dirección de la base d datos, es la cadena de conexión para conectarme con la máquina de que aloja la base de datos, lo lógico es poner una ip o nombre de dominio
                    -Nos pide dónde está la base de datos: jdbc:mysql://
                    -El puerto dónde se encuentra: localhost:3307/
                    -Ajustar la zona horaria: tienda2026?serverTimezone=UTC"
                    -El usuario: "root"
                    -La contraseña: "" en este caso la base de datos no tiene contraseña, carece de seguridad
                */
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
}
