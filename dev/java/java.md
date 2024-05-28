### Clase Abstracta en java

Una clase abstracta en Java es una clase que no puede ser instanciada directamente, es decir, no se puede crear un
objeto de esa clase. En cambio, se utiliza como una plantilla o superclase para otras clases que extienden o heredan de
ella. Una clase abstracta puede contener métodos abstractos, que son métodos que no tienen implementación en la clase
abstracta y deben ser implementados por las clases hijas.

#### Características Clave de una Clase Abstracta:

- No se Puede Instanciar Directamente: No se puede crear un objeto de una clase abstracta utilizando la palabra clave
  new. Sin embargo, se pueden crear referencias de tipo de la clase abstracta.

- Puede Contener Métodos Abstractos: Una clase abstracta puede tener métodos abstractos, que son métodos que solo se
  declaran en la clase abstracta sin proporcionar una implementación. Estos métodos deben ser implementados por las
  clases hijas.

- Puede Contener Métodos Concretos: Además de los métodos abstractos, una clase abstracta puede contener métodos
  concretos (implementados) y campos de datos.

#### Sintaxis para Declarar una Clase Abstracta:

```java
public abstract class NombreClase {
    // Campos de datos
    // Métodos abstractos
    // Métodos concretos
}
```

#### Ejemplo de una Clase Abstracta en Java:

Supongamos que queremos crear una clase abstracta `Animal` que tenga un método abstracto `hacerSonido()` y un método
concreto `moverse()`. Las clases que representan tipos específicos de animales, como `Perro` y `Gato`, pueden extender
la clase `Animal` e implementar el método abstracto `hacerSonido()` según corresponda.

```java
public abstract class Animal {
    // Método abstracto
    public abstract void hacerSonido();

    // Método concreto
    public void moverse() {
        System.out.println("El animal se está moviendo");
    }
}

public class Perro extends Animal {
    // Implementación del método abstracto
    public void hacerSonido() {
        System.out.println("El perro ladra");
    }
}

public class Gato extends Animal {
    // Implementación del método abstracto
    public void hacerSonido() {
        System.out.println("El gato maulla");
    }
}
```

#### Ventajas del Uso de Clases Abstractas:

- Abstracción y Reutilización de Código: Permite definir una estructura común y compartir funcionalidades entre las
  clases hijas.

- Polimorfismo: Las referencias de tipo de la clase abstracta pueden apuntar a objetos de cualquier clase hija, lo que
  permite tratar a objetos de diferentes clases de manera uniforme.

- Forzar la Implementación de Métodos: Al definir métodos abstractos, se asegura que las clases hijas proporcionen una
  implementación específica.

#### Conclusión:

Una clase abstracta en Java es una herramienta poderosa para definir una estructura común y compartir funcionalidades
entre clases relacionadas. Se utiliza para representar conceptos generales que pueden tener diferentes implementaciones
en clases específicas.

### Interface en java

En Java, una interfaz es una colección de métodos abstractos y constantes (variables estáticas y finales) que se definen
como parte de una especificación pública. Las interfaces en Java proporcionan un mecanismo para la abstracción y la
definición de un contrato que las clases deben seguir.

#### Características Clave de una Interfaz:

- Métodos Abstractos: Una interfaz puede contener métodos sin implementación (abstractos). Estos métodos definen un
  conjunto de operaciones que las clases que implementan la interfaz deben proporcionar.

- Constantes: Además de métodos, una interfaz puede contener constantes, que son variables declaradas como public,
  static y final. Estas constantes se consideran parte de la interfaz y pueden ser accedidas por cualquier clase que
  implemente la interfaz.

- No Puede Contener Implementaciones de Métodos: A diferencia de las clases abstractas, una interfaz no puede
  proporcionar implementaciones de métodos. Solo puede declarar métodos sin cuerpo, que deben ser implementados por las
  clases que la implementan.

- Puede Extender Otras Interfaces: Una interfaz puede extender una o más interfaces, lo que significa que hereda los
  métodos y las constantes de esas interfaces. Esto permite la construcción de jerarquías de interfaces.

#### Sintaxis para Declarar una Interfaz:

```java
public interface NombreInterfaz {
    // Métodos abstractos
    // Constantes
}
```

#### Ejemplo de una Interfaz en Java:

```java
public interface Figura {
    // Métodos abstractos
    double calcularArea();

    double calcularPerimetro();
}

```

#### Ventajas del Uso de Interfaces:

- Abstracción: Las interfaces permiten definir un contrato común para un conjunto de clases que implementan esa
  interfaz. Esto facilita la abstracción y la creación de código genérico.

- Polimorfismo: Las referencias de tipo de la interfaz pueden apuntar a objetos de cualquier clase que implemente esa
  interfaz, lo que permite tratar a los objetos de diferentes clases de manera uniforme.

- Desacoplamiento: El uso de interfaces reduce el acoplamiento entre componentes de software, lo que facilita la
  modularidad y el mantenimiento del código.

- Reusabilidad: Las interfaces permiten la reutilización de código al definir un conjunto de métodos comunes que pueden
  ser implementados por diferentes clases.

#### Conclusión

Las interfaces en Java son una parte fundamental de la programación orientada a objetos y proporcionan un mecanismo
poderoso para definir contratos y abstracciones en un sistema de software. Se utilizan para establecer un comportamiento
común entre clases relacionadas y promueven el diseño flexible y modular del código.

### Diferencias

Las clases abstractas y las interfaces son dos conceptos importantes en Java que permiten la abstracción y la definición
de contratos para las clases que las implementan. Aunque comparten algunas similitudes, también tienen diferencias
significativas en su uso y funcionalidad.

#### Clase Abstracta:

- Puede Contener Métodos con Implementaciones: Una clase abstracta puede contener tanto métodos abstractos (sin
  implementación) como métodos concretos (con implementación).

- Puede Contener Campos de Datos: Una clase abstracta puede tener campos de datos, constructores y métodos concretos.

- Puede Extender Otra Clase o Implementar Interfaces: Una clase abstracta puede extender otra clase (solo una, debido a
  la herencia simple en Java) y puede implementar una o más interfaces.

- Es Usada para la Reutilización de Código: Se utiliza cuando se quiere proporcionar una implementación base común para
  clases relacionadas.

#### Interfaz

- Solo Contiene Métodos Abstractos y Constantes: Una interfaz solo puede contener métodos abstractos (sin
  implementación) y constantes (variables public, static y final).

- No Puede Contener Implementaciones de Métodos: A diferencia de las clases abstractas, una interfaz no puede
  proporcionar implementaciones de métodos. Solo define un contrato que las clases deben seguir.

- Puede Extender Otras Interfaces: Una interfaz puede extender una o más interfaces, pero no puede extender una clase.

- Es Usada para la Abstracción y el Polimorfismo: Se utiliza para definir un contrato común para un conjunto de clases
  que implementan la interfaz, permitiendo el polimorfismo y la abstracción.

#### Cuándo Usar una Clase Abstracta o una Interfaz

- Clase Abstracta: Se utiliza cuando se quiere proporcionar una implementación base común para clases relacionadas y
  cuando se desea compartir código entre las clases hijas.

- Interfaz: Se utiliza cuando se quiere definir un contrato común para un conjunto de clases sin proporcionar ninguna
  implementación. También se utiliza cuando una clase puede implementar múltiples contratos (interfaces) o cuando se
  quiere lograr un nivel más alto de desacoplamiento entre componentes de software.

#### Resumen

En resumen, la principal diferencia entre una clase abstracta y una interfaz en Java radica en su funcionalidad y uso.
Una clase abstracta se utiliza para proporcionar una implementación base común y compartir código entre clases
relacionadas, mientras que una interfaz se utiliza para definir un contrato común y promover el polimorfismo y la
abstracción en el diseño de software.

### Clase final

Una clase final en Java es una clase que no puede ser extendida, es decir, no se puede crear una subclase de una clase
final. Al declarar una clase como final, se impide que otras clases extiendan o hereden de ella. Esta característica se
utiliza para restringir la herencia y evitar que se modifiquen ciertos aspectos críticos de la clase.

#### Características Clave de una Clase Final:

- No Puede Ser Extendida: Una vez que una clase se declara como final, no se puede crear una subclase de esa clase
  final. Cualquier intento de extender una clase final resultará en un error de compilación.

- Puede Contener Métodos y Campos de Datos: A pesar de ser final, una clase puede contener métodos, campos de datos y
  constructores como cualquier otra clase.

- Se Utiliza para Restringir la Herencia: Se utiliza cuando se desea evitar que ciertas clases sean extendidas, lo que
  puede ser útil para preservar la integridad de la clase y prevenir la modificación de su comportamiento.

#### Sintaxis para Declarar una Clase Final:

```java 
public final class NombreClase {
    // Campos de datos
    // Métodos
}
```

#### Ejemplo de una Clase Final en Java:

```java
public final class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

```

#### Ventajas del Uso de Clases Finales:

- Protege la Integridad de la Clase: Evita que se modifiquen ciertos aspectos críticos de la clase al restringir la
  herencia.

- Facilita la Optimización y el Análisis Estático: Al declarar una clase como final, el compilador puede realizar
  optimizaciones y análisis estático más efectivos, ya que no necesita considerar la posibilidad de que se creen
  subclases.

- Mejora la Seguridad: Evita que otras clases modifiquen o extiendan clases sensibles o críticas en el sistema.

#### Conclusión

En resumen, una clase final en Java es una herramienta que se utiliza para restringir la herencia y proteger la
integridad de ciertas clases en un sistema de software. Se utiliza cuando se desea prevenir la extensión de una clase y
garantizar que ciertos aspectos de la clase permanezcan inalterados.

### Excepciones en Java

En Java, las excepciones se dividen en dos categorías principales: excepciones verificadas (checked exceptions) y
excepciones no verificadas (unchecked exceptions).

#### Excepciones Verificadas (Checked Exceptions):

- Definición: Son excepciones que el compilador obliga a manejar. Estas excepciones deben ser declaradas en la firma del
  método o atrapadas (catch) dentro del bloque del método.

- Ejemplos: Algunos ejemplos de excepciones verificadas son IOException, SQLException, ClassNotFoundException, etc.

- Manejo: Se deben manejar utilizando una declaración try-catch o lanzándolas (throws) en la firma del método.

- Propósito: Se utilizan para manejar condiciones excepcionales que el programa puede anticipar y recuperarse, como
  errores de entrada/salida, errores de base de datos, etc.

#### Ejemplos de Excepciones Verificadas (Checked Exceptions):

`IOException`: Esta excepción se produce cuando ocurre un error de entrada/salida, como no poder encontrar un archivo o no poder escribir en un archivo debido a permisos insuficientes.


```java
import java.io.*;

public class IOExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("archivo.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
```
`SQLException`: Esta excepción se produce cuando ocurre un error relacionado con la base de datos, como una conexión perdida o una consulta SQL inválida.

```java
import java.sql.*;

public class SQLExceptionExample {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM table");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column"));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
}
```

#### Excepciones No Verificadas (Unchecked Exceptions):

- Definición: Son excepciones que el compilador no obliga a manejar. Estas excepciones no tienen que ser declaradas en
  la firma del método ni atrapadas explícitamente dentro del bloque del método.

- Ejemplos: Algunos ejemplos de excepciones no verificadas son NullPointerException, ArrayIndexOutOfBoundsException,
  ArithmeticException, etc.

- Manejo: Se pueden manejar utilizando una declaración try-catch, pero no es obligatorio. Si no se manejan, estas
  excepciones se propagarán hacia arriba en la pila de llamadas hasta que se atrapen o el programa se detenga.

- Propósito: Se utilizan para manejar condiciones excepcionales que generalmente son causadas por errores en la lógica
  del programa, como divisiones por cero, acceso a elementos de un arreglo fuera de los límites, etc.


#### Ejemplos de Excepciones No Verificadas (Unchecked Exceptions):

`NullPointerException`: Esta excepción se produce cuando se intenta acceder a un objeto que es null.


```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Se produjo un NullPointerException: " + e.getMessage());
        }
    }
}
```
`ArithmeticException`: Esta excepción se produce cuando se intenta realizar una operación aritmética inválida, como la división por cero.

```java
public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("Resultado: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Se produjo una ArithmeticException: " + e.getMessage());
        }
    }
}
```


#### Comparación

- Verificación en Tiempo de Compilación: Las excepciones verificadas se verifican en tiempo de compilación, lo que
  significa que el compilador exige que se manejen.
- No Verificación en Tiempo de Compilación: Las excepciones no verificadas no se verifican en tiempo de compilación, lo
  que significa que no es necesario manejarlas, aunque es recomendable hacerlo.
- Manejo Obligatorio vs Opcional: El manejo de excepciones verificadas es obligatorio, mientras que el manejo de
  excepciones no verificadas es opcional.
- Propósito: Las excepciones verificadas se utilizan para manejar condiciones excepcionales recuperables, mientras
  que las excepciones no verificadas se utilizan para errores de programación o condiciones excepcionales no
  recuperables.

#### Resumen

En resumen, las excepciones verificadas se utilizan para manejar condiciones excepcionales anticipadas y recuperables,
mientras que las excepciones no verificadas se utilizan para errores de programación o condiciones excepcionales no
recuperables.




```
```




