# Repaso Entrevista JDK

## La programación funcional:

La programación funcional en Java es un paradigma de programación que se centra en tratar las operaciones como
evaluaciones de funciones matemáticas y evita el cambio de estado y las mutaciones de datos. En la programación
funcional, se enfatiza el uso de funciones puras, que son funciones que producen el mismo resultado para los mismos
argumentos y no tienen efectos secundarios observables.

Aunque Java es principalmente un lenguaje de programación orientado a objetos, a partir de Java 8 se introdujeron
características que permiten la programación funcional, como expresiones lambda, interfaces funcionales predefinidas en
el paquete java.util.function, el API de Streams y los métodos de referencia.

Características Principales de la Programación Funcional en Java:

- Expresiones Lambda: Las expresiones lambda permiten definir funciones anónimas de forma concisa y se utilizan
  principalmente para pasar comportamientos como argumentos a métodos, como en el caso de las operaciones en Streams.
- Interfaces Funcionales: Java 8 introdujo un conjunto de interfaces funcionales predefinidas en el paquete
  java.util.function, como Function, Predicate, Consumer, Supplier, etc. Estas interfaces proporcionan un mecanismo
  estándar para representar funciones y predicados en Java.
- API de Streams: La API de Streams permite operar de manera declarativa y funcional en colecciones de datos, como
  listas,
  conjuntos y mapas. Proporciona operaciones de filtrado, mapeo, reducción, ordenamiento, y más, utilizando expresiones
  lambda.
- Métodos de Referencia: Los métodos de referencia proporcionan una forma de referenciar métodos existentes, incluyendo
  constructores, de manera concisa y legible. Se pueden utilizar en lugar de expresiones lambda cuando se pasa un método
  como argumento.
- Inmutabilidad y Funciones Puras: Aunque Java no es inherentemente inmutable o puramente funcional, se pueden seguir
  principios de inmutabilidad y funciones puras en el diseño y la implementación de programas en Java. Esto ayuda a
  reducir los errores y facilita la comprensión y el mantenimiento del código.

Ventajas de la Programación Funcional en Java:

- Legibilidad y Concisión: Las expresiones lambda y los métodos de referencia permiten escribir código de manera más
  concisa y legible.
- Composición de Funciones: La composición de funciones permite construir operaciones complejas a partir de funciones
  más simples, lo que facilita la creación de código modular y reutilizable.
- Programación Declarativa: El uso de Streams y expresiones lambda permite expresar operaciones en términos de qué hacer
  en lugar de cómo hacerlo, lo que resulta en un código más declarativo y fácil de entender.
- Paralelismo y Concurrencia: El API de Streams facilita la ejecución paralela de operaciones en colecciones de datos,
  lo que puede mejorar el rendimiento en sistemas multiproceso.

### Una expresión lambda

Una expresión lambda en Java es una forma de crear una función anónima de manera concisa. Es una característica
introducida en Java 8 que permite tratar las funciones como objetos de primera clase. Esto significa que puedes pasar
funciones como argumentos a otros métodos, devolverlas como resultados de métodos o almacenarlas en variables.

Estructura de una Expresión Lambda en Java:
Una expresión lambda consta de los siguientes elementos:

- Lista de parámetros: Se pueden especificar cero o más parámetros entre paréntesis. Si no hay parámetros, se utilizan
  paréntesis vacíos. Si hay un solo parámetro, los paréntesis pueden omitirse. Para múltiples parámetros, se separan por
  comas.
- Operador de flecha `(->):` Se utiliza para separar la lista de parámetros del cuerpo de la expresión lambda.
- Cuerpo de la lambda: Puede ser una expresión o un bloque de código. Si es una expresión, el valor de retorno se
  calcula automáticamente y se devuelve. Si es un bloque de código, se utilizan llaves `{}` y se debe incluir una
  declaración de retorno explícita si es necesario.

Uso de Expresiones Lambda:

Las expresiones lambda son comúnmente utilizadas en Java para:

- Pasar comportamientos como argumentos a métodos de alto orden, como los métodos forEach, filter, map en Streams.
- Simplificar el código al eliminar la necesidad de clases anónimas.
- Facilitar la programación funcional al permitir el uso de funciones como ciudadanos de primera clase.

## Interfaces:

Es un *contrato* entre dos entidades (interfaz e implementación), esto quiere decir que una interfaz provee un servicio
a una clase consumidora. Por lo tanto, la interfaz solo nos muestra la declaración de los métodos que esta posee (todos
sus métodos son abstractos).

- Las interfaces solo declaran métodos públicos y abstractos.
- Si se instancia una interfaz creamos una clase anónima.
- Podemos tener un método default (java 8+).
- Podemos tener métodos estáticos (java 8+).
- Podemos tener métodos privados (java 9+).

## Create Interface

```java
package com.bxcode.interfaces.contracts;

import java.util.List;

/**
 * IDatabaseService
 * <p>
 * IDatabaseService interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public interface IDatabaseService {

    String getById(long id);

    List<String> getAll();

    default String getName() {
        return "my name";
    }

    default String getLastName() {
        return "my lastName";
    }

    static String getMethod() {
        return "get static";
    }
}
```

## Create Implement Interface

```java
package com.bxcode.interfaces.implementations;

import com.bxcode.interfaces.contracts.IDatabaseService;

import java.util.List;

/**
 * MongoDatabaseService
 * <p>
 * MongoDatabaseService class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class PostgresDatabaseService implements IDatabaseService {
    @Override
    public String getById(long id) {
        return "Getting data From Postgres Database";
    }

    @Override
    public List<String> getAll() {
        return List.of("Hello World", "Tomorrow", "Postgres DB");
    }
}

```

## Programación Genérica

La programación genérica tiene como objetivo facilitar el desarrollo de algoritmos (o métodos en la POO) de manera tal
que el tipo de dato específico manipulado por el algoritmo sea especificado al momento de ejecutarlo y no al momento de
desarrollarlo.
Que quiere decir esto: que nosotros podemos trabajar con un tipo de dato (Integer, String), pero no sabemos, esto será
especificado al momento de ejecutarlo.
Para hacer más dinámico nuestro código.
Para evitar usar la clase Object como parámetro de los métodos abstractos cuando desconocemos el tipo de dato en
concreto de nuestra implementación.

Los parámetros de tipo:

- Se declaran en clases abstractas o interfaces.
- Podemos especificar que los tipos extiendan de una interfaz especificada con ```<T extends MyInterface>```.
- La convención para nombrar los parámetros de tipo es:
    - E - Elemento
    - K - Llave
    - N - Números
    - T - Tipo
    - V - Valor

```java
package com.bxcode.interfaces.contracts;

import java.util.List;

/**
 * IGenericDatabaseService
 * <p>
 * IGenericDatabaseService interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public interface IGenericDatabaseService<T> {

    T getById(long id);

    List<T> getAll();
}

```

```java
package com.bxcode.interfaces.implementations;

import com.bxcode.dto.Employee;
import com.bxcode.interfaces.contracts.IGenericDatabaseService;

import java.util.List;

/**
 * EmployeeDatabaseService
 * <p>
 * EmployeeDatabaseService class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class EmployeeDatabaseService implements IGenericDatabaseService<Employee> {

    @Override
    public Employee getById(long id) {
        return Employee.builder()
                .id(1L)
                .name("Employee 1")
                .description("Employee 1")
                .build();
    }

    @Override
    public List<Employee> getAll() {
        return List.of(Employee.builder()
                .id(1L)
                .name("Employee 1")
                .description("Employee 1")
                .build());
    }
}
```

```java
package com.bxcode.interfaces.implementations;

import com.bxcode.dto.Product;
import com.bxcode.interfaces.contracts.IGenericDatabaseService;

import java.util.List;

/**
 * ProductDatabaseService
 * <p>
 * ProductDatabaseService class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class ProductDatabaseService implements IGenericDatabaseService<Product> {

    @Override
    public Product getById(long id) {
        return Product.builder()
                .id(1L)
                .name("Product 1")
                .description("Description 1")
                .build();
    }

    @Override
    public List<Product> getAll() {
        return List.of(Product.builder()
                .id(1L)
                .name("Product 1")
                .description("Description 1")
                .build());
    }
}
```

## Clases Anónimas

Una clase anónima en JAVA es una solución rápida para implementar una clase abstracta o una interfaz que solo se va a
usar una vez sin necesidad de crear un archivo separado.

- Creamos una clase anónima al instanciar de una interfaz.
- Creamos una clase anónima al instanciar una clase abstracta.
- La clase anónima es clase interna.
- Podemos obtener el nombre de una clase con el método ```getClass().getName``` por java reflection.

```java
package com.bxcode.interfaces.test;

import com.bxcode.dto.Employee;
import com.bxcode.dto.Product;
import com.bxcode.interfaces.contracts.IDatabaseService;
import com.bxcode.interfaces.contracts.IGenericDatabaseService;
import com.bxcode.interfaces.implementations.EmployeeDatabaseService;
import com.bxcode.interfaces.implementations.MongoDatabaseService;
import com.bxcode.interfaces.implementations.PostgresDatabaseService;
import com.bxcode.interfaces.implementations.ProductDatabaseService;

import java.util.List;

/**
 * AppInterfaces
 * <p>
 * AppInterfaces class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class AppInterfaces {

    public static void main(String[] args) {

        IDatabaseService postgres = new PostgresDatabaseService();
        IDatabaseService mongo = new MongoDatabaseService();
        EmployeeDatabaseService employee = new EmployeeDatabaseService();
        ProductDatabaseService product = new ProductDatabaseService();

        System.out.println(postgres.getAll());
        System.out.println(mongo.getAll());

        System.out.println(employee.getById(1L));
        System.out.println(product.getById(1L));

        System.out.println(Product.class.getName());
        System.out.println(Employee.class.getName());


        IGenericDatabaseService<String> anonymousService = new IGenericDatabaseService<>() {
            @Override
            public String getById(long id) {
                return "Id anonymousService";
            }

            @Override
            public List<String> getAll() {
                return List.of("anonymousService", "database service");
            }
        };

        System.out.println(anonymousService);
    }
}
```

## Expresiones Lambda

Esta funcionalidad nos proporciona la interface ```Function<T,R>``` Jdk 8 y su único método abstracto
es ```apply(T val)```

Hasta la fecha, probablemente es Java 8 la versión más importante en toda la historia de este lenguaje de programación.
En esta versión se implementan las expresiones lambda, que permiten crear un código más conciso y expresivos. Además,
también se añade Streams, que da un modelo de programación funcional.

En Java, una expresión lambda es una característica introducida en Java 8 que permite tratar la funcionalidad como un
argumento que se pasa a un método o se utiliza en una variable. Las expresiones lambda son una manera concisa de
representar una función o una instancia de una interfaz funcional (una interfaz con un solo método abstracto).

### Interface funcional:

- Es una interfaz que dispone de un solo método abstracto, puede tener métodos por default y privados.
- Podemos avisarle al compilador de manera opcional que será una interface funcional anotándola
  con ```@FuncionalInterface```

### Expresión lambda

- Es una subrutina definida que no está enlazada a un identificador.
- Son la implementación de una interfaz funcional mediante una clase anónima con la siguiente:
  sintaxis: ```(x,y)-> return x+y;```
    - ```(a.b)```: Parámetros (Solo si son requeridos).
    - ```->```: Operador flecha para indicar que será una expresión lambda.
    - ```{}```: Cuerpo de la expresión. Si el cuerpo tiene más de una línea deben abrir y cerrar {}.
- Podemos referenciar métodos anónimos o métodos sin nombre,lo que nos permite escribir código más claro y conciso
  que cuando usamos clases anónimas.


- Beneficios de Usar Expresiones Lambda
    - Código Más Conciso: Las expresiones lambda reducen el código ceremonial, haciendo el código más limpio y conciso.
    - Mayor Legibilidad: Al eliminar la necesidad de clases anónimas, el código se vuelve más legible.
    - Funcionalidad en Parámetros: Permiten pasar la funcionalidad como un argumento a los métodos.
    - Facilitan el Uso de API de Streams: Las lambdas son fundamentales para trabajar con la API de Streams introducida
      en Java 8, permitiendo realizar operaciones de filtrado, mapeo y reducción de manera declarativa.

  Las expresiones lambda son una poderosa característica en Java que puede mejorar significativamente la concisión y
  claridad de tu código, especialmente cuando se trabaja con colecciones y operaciones funcionales.


- Java 9
    - ```List.of()```
        - Es un método de fábrica introducido en Java 9 que crea una lista inmutable que contiene los elementos
          especificados. Aquí hay algunos puntos clave a tener en cuenta:
        - Inmutabilidad: la lista resultante es inmutable, lo que significa que su tamaño y elementos no se pueden
          modificar
          después de la creación.
        - Tamaño fijo: la lista creada por List.of() tiene un tamaño fijo y no admite agregar o eliminar elementos.
        - Valores nulos: List.of() no permite elementos nulos. Si intenta incluir nulo, generará una
          NullPointerException.

```java
package com.bxcode.lambda;

/**
 * IMathFunctional
 * <p>
 * IMathFunctional interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
@FunctionalInterface
public interface IMathFunctional {

    Double execute(Double a, Double b);

    default Double sum(Double a, Double b) {
        return a + b;
    }
}

```

```java
package com.bxcode.lambda.test;

import com.bxcode.lambda.contracts.IMathFunctional;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class AppLambda {

    public static void main(String[] args) {
        IMathFunctional addition = Double::sum;
        IMathFunctional subtraction = (a, b) -> a - b;
        IMathFunctional division = (a, b) -> a / b;
        IMathFunctional multiplication = (a, b) -> a * b;

        log.info("addition: {}", addition.sum(1.3, 2.3));
        log.info("subtraction: {}", subtraction.execute(1.2, 2.2));
        log.info("addition: {}", division.execute(1.2, 2.2));
        log.info("multiplication: {}", multiplication.execute(1.2, 2.2));

        IPrinterFunctional<String> printString = log::info;
        printString.print("Hola mundo");

        IPrinterFunctional<Product> printProduct = log::debug;
        printProduct.print(Product.builder()
                .id(1L)
                .name("Producto expression lambda")
                .description("Producto expression lambda")
                .build());

        IPrinterFunctional<Employee> printEmployee = log::debug;

        printEmployee.print(Employee.builder()
                .id(1L)
                .name("Employee expression lambda")
                .description("Employee expression lambda")
                .build());
    }
}
```

### Expresiones Genéricas

```java
package com.bxcode.lambda.contracts;

/**
 * IPrinterFunctional
 * <p>
 * IPrinterFunctional interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@FunctionalInterface
public interface IPrinterFunctional<T> {
    void print(T t);
}
```

```java
package com.bxcode.lambda.test;

import com.bxcode.dto.Employee;
import com.bxcode.dto.Product;
import com.bxcode.lambda.contracts.IMathFunctional;
import com.bxcode.lambda.contracts.IPrinterFunctional;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class AppLambda {

    public static void main(String[] args) {
        IMathFunctional addition = Double::sum;
        IMathFunctional subtraction = (a, b) -> a - b;
        IMathFunctional division = (a, b) -> a / b;
        IMathFunctional multiplication = (a, b) -> a * b;

        System.out.println(addition.sum(1.2, 2.2));
        System.out.println(subtraction.execute(1.2, 2.2));
        System.out.println(division.execute(1.2, 2.2));
        System.out.println(multiplication.execute(1.2, 2.2));


        IPrinterFunctional<String> printString = System.out::println;
        printString.print("Hola mundo");

        IPrinterFunctional<Product> printProduct = System.out::println;
        printProduct.print(Product.builder()
                .id(1L)
                .name("Producto expression lambda")
                .description("Producto expression lambda")
                .build());

        IPrinterFunctional<Employee> printEmployee = System.out::println;

        printEmployee.print(Employee.builder()
                .id(1L)
                .name("Employee expression lambda")
                .description("Employee expression lambda")
                .build());
    }
}
```

```java
package com.bxcode.lambda.test;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppLambda {

    public static void main(String[] args) {
        List<String> countries = List.of("Mexico", "Colombia");
        for (String c : countries) {
            log.info("country: {}", c);
        }
        // Expression Lambda:
        countries.forEach(c -> log.info("lambda country: {}", c.toUpperCase()));
    }
}
```

### Referencias a métodos:

- Es una funcionalidad de java 8 que puede sustituir a una expresión lambda cuya única instrucción consiste en la
  llamada a un método.
- El compilador infiere las variables dadas por parámetro en el argumento del método.
- Lambda: o->System.out.print(o)
- Método Referenciado: o->System.out::print
- ```"MyClassOrObject::methodName" MyClassOrObject => Clase u Objeto, :: => Los métodos referenciados se especifica con doble punto (::) y methodName => Nombre del método a referenciar```

#### Existen 4 tipos:

| **Tipo de Referencia**                        | **Referencia método**                | **Expresión lamba**                        |
|-----------------------------------------------|--------------------------------------|--------------------------------------------|
| [Método de un objeto](#Referencia-de-Método)  | ```var r = new Random() r::nexInt``` | ```var r=new Random() n -> r.nextInt(n)``` |
| [Método estático](#Método-Estático)           | ```String::ValueOf```                | ```s-> String.valueOf(s)```                |
| [Método constructor](#Referencia-Constructor) | ```Person::new```                    | ```s-> new Person(s)```                    |
| [Método arbitrario](#Método-arbitrario)       | ```String::equals```                 | ```(s1,s2)-> s1.equals(s2)```              |

### Referencia de Método:

```java
package com.bxcode.lambda.test;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppLambda {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(10);
        //similar a un for
        IntStream repeat = IntStream.range(1, 11);
        //repeat.forEach(i -> numbers.add(i));
        //referencia a métodos
        repeat.forEach(numbers::add);
        log.info("numbers {}", numbers);
    }
}


```

### Método Estático

```java

package com.bxcode.lambda.test;

import lombok.extern.log4j.Log4j2;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppLambda {

    public static void main(String[] args) {

        //expresión lambda:
        Supplier<UUID> token = () -> UUID.randomUUID();
        //referencia a método estético:
        Supplier<UUID> uuid = UUID::randomUUID;

        log.info("token: {}", token.get());
        log.info("uuid: {}", uuid.get());

    }
}



```

### Referencia Constructor

```java
package com.bxcode.lambda.test;

import com.bxcode.dto.Product;
import lombok.extern.log4j.Log4j2;

import java.util.function.Supplier;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppLambda {

    public static void main(String[] args) {

        //expresión lambda:
        Supplier<Product> productEL = () -> new Product();
        //referencia a método constructor:
        Supplier<Product> productRM = Product::new;

        log.info("productEL: {}", productEL.get());
        log.info("productRM : {}", productRM.get());
    }
}
```

### Método arbitrario

```java
package com.bxcode.lambda.test;

import lombok.extern.log4j.Log4j2;

import java.util.function.BiPredicate;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppLambda {

    public static void main(String[] args) {

        //expresión lambda:
        BiPredicate<String, String> equalsEL = (s1, s2) -> s1.equals(s2);
        //referencia a método arbitraria:
        BiPredicate<String, String> equalsRM = String::equals;

        log.info("equalsEL: {}", equalsEL.test("1", "1"));
        log.info("equalsRM : {}", equalsRM.test("2", "1"));
    }
}
```

### Paquete java.util.function

El paquete `java.util.function` está presente a partir de la version 1.8 JDK y nos provee un conjunto de interfaces
funcionales, cada una con un propósito distinto.

En Java, una interfaz funcional es una interfaz que tiene un único método abstracto. Las interfaces funcionales son
fundamentales en la programación funcional y son la base para las expresiones lambda y las referencias a métodos. Las
expresiones lambda proporcionan una forma concisa de representar una instancia de una interfaz funcional.

#### Interface Function<T,V>

- `Interface Function<T,V>`: Representa una función que acepta un argumento y produce un resultado.
- `R apply(T t)`: Aplica la función dada un argumento
- `compose(Function<? supper V,? extends T> before)`: Primero aplica la función pasada por argumento y después el método
  apply
- `andthen(Function<? supper R,? extends V> after)`: Después de aplicar la función apply, aplica la función dada por
  parámetro.

```java
package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.function.Function;

/**
 * AppFunctions
 * <p>
 * AppFunctions class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppFunctions {

    static Function<Integer, Integer> sum = n -> n + 10;
    static Function<Integer, Integer> multiply = n -> n * 10;

    public static void main(String[] args) {
        //method apply
        log.info("sum {}", sum.apply(10));
        log.info("multiply {}", multiply.apply(2));
        //method andThen
        log.info("andThen multiply {}", multiply.andThen(sum).apply(4));
        log.info("andThen sum {}", sum.andThen(multiply).apply(4));
        //method compose
        log.info("compose multiply {}", multiply.compose(sum).apply(4));
        log.info("compose sum {}", sum.compose(multiply).apply(4));
    }
}
```

```java 
package com.bxcode.functions.test;

import com.bxcode.dto.Product;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

/**
 * AppFunctions
 * <p>
 * AppFunctions class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppFunctions {

    static Function<Product, ByteArrayOutputStream> serializer = p -> {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(stream)) {
            oos.writeObject(p);
            oos.flush();
        } catch (IOException e) {
            log.error("error serializer: {}", e.getMessage());
        }

        return stream;
    };

    static Function<ByteArrayInputStream, Product> deserializer = p -> {
        try (ObjectInputStream ois = new ObjectInputStream(p)) {
            return (Product) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error("error deserializer: {}", e.getMessage());
        }
        return null;
    };

    public static void main(String[] args) {
        ByteArrayOutputStream stream = serializer.apply(Product.builder()
                .id(1L)
                .name("serializer product")
                .description("serializer product")
                .build());


        //trasmitir a través de la red
        log.info("stream serializer {}", Arrays.toString(stream.toByteArray()));

        Product product = deserializer.apply(new ByteArrayInputStream(stream.toByteArray()));

        log.info("stream deserializer {}", product);
    }
}
```

#### InterfaceBiFunction<T,U,R>

- Representa una función que acepta dos argumentos y produce un resultado. Esta es la especialización de dos aridades de
  Function.

```java
package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;


/**
 * AppFunctions
 * <p>
 * AppFunctions class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppFunctions {


    static BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

    static <T, U, R> List<R> combiner(List<T> l1, List<U> l2, BiFunction<T, U, R> function) {

        List<R> result = new ArrayList<>();

        for (int i = 0; i < l1.size(); i++) {
            result.add(function.apply(l1.get(i), l2.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a", "b", "c", "d");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> result = combiner(letters, numbers, (l1, l2) -> l1 + l2);
        log.info("list combinator {}", result);

        // multiply:
        log.info("list multiply {}", multiply.apply(2, 3));

    }
}
```

#### Interface Predicate<T>

- En Java es una interfaz funcional que representa un predicado (una función que devuelve un valor booleano) de un solo
  argumento. Es una parte fundamental del paquete java.util.function y se utiliza ampliamente en el API de Streams de
  Java para filtrar datos y realizar otras operaciones que implican la evaluación de condiciones.

- función lógica: Representa un predicado, devuelve un boolean.
- La interfaz Predicate<T> es una herramienta poderosa en Java para representar condiciones booleanas y trabajar con
  ellas de manera funcional. Su integración con la API de Streams permite un manejo más limpio y eficiente de las
  colecciones de datos.
- Esta es una interfaz funcional y, por lo tanto, puede ser utilizada como el objetivo de asignación para una expresión
  lambda o una referencia a un método.

```java
package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * AppFunctions
 * <p>
 * AppFunctions class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppFunctions {

    static Predicate<Integer> isGreaterThan100 = n -> n > 100;

    static Predicate<Integer> isLessThan10 = n -> n < 10;
    static Predicate<String> hasLengthGreaterThanThree = n -> n.length() > 3;

    static Predicate<Integer> isBetweenThan10And100 = isGreaterThan100.or(isLessThan10);

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 200, 300));

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward");


        List<Integer> filter = numbers.stream()
                .filter(isLessThan10)
                .collect(Collectors.toList());

        List<Integer> negate = numbers.stream()
                .filter(isBetweenThan10And100.negate())
                .collect(Collectors.toList());

        List<String> filterName = names.stream()
                .filter(hasLengthGreaterThanThree)
                .collect(Collectors.toList());

        numbers.removeIf(isGreaterThan100);

        //result numbers:
        log.info("list numbers filter {}", filter);
        log.info("list numbers negate {}", negate);
        log.info("list numbers removeIf {}", numbers);
        log.info("list filterName > 3 {}", filterName);
    }
}
```

#### Interface BiPredicate<T>

- Esta es una interfaz funcional y, por lo tanto, puede ser utilizada como el objetivo de asignación para una expresión
  lambda o una referencia a un método.
- Representa un predicado (una función que devuelve un valor booleano) de dos argumentos. Esta es la especialización de
  dos aridades de Predicate.
  Esta es una interfaz funcional cuyo método funcional es test(Object, Object).

```java
package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.function.BiPredicate;


/**
 * AppFunctions
 * <p>
 * AppFunctions class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppFunctions {

    static BiPredicate<String, String> biPredicate = (s1, s2) -> s1.concat(s2).equals("HelloWorld");
    static BiPredicate<String, String> haveSameLength = (s1, s2) -> s1.length() == s2.length();
    static BiPredicate<String, String> startWithSameLetter = (s1, s2) -> s1.charAt(0) == s2.charAt(0);
    static BiPredicate<String, String> complexPredicate = haveSameLength.and(startWithSameLetter);

    public static void main(String[] args) {

        log.info("biPredicate {}", biPredicate.test("Hello", "Henry"));
        log.info("haveSameLength {}", haveSameLength.test("Hello", "Helio"));
        log.info("startWithSameLetter {}", startWithSameLetter.test("Hello", "Hierro"));
        log.info("complexPredicate {}", complexPredicate.test("Hello", "Hierro"));
    }
}
```

#### Interface Consumer<T>

- Representa una operación que acepta un único argumento y no devuelve ningún resultado.
- Esta es una interfaz funcional y, por lo tanto, puede ser utilizada como el objetivo de asignación para una expresión
  lambda o una referencia a un método.
- Representa una operación que acepta un único argumento de entrada y no devuelve ningún resultado. A diferencia de la
  mayoría de las otras interfaces funcionales, se espera que Consumer opere mediante efectos secundarios
- La interfaz `Consumer<T>` en Java es una interfaz funcional que acepta un solo argumento y no devuelve ningún
  resultado.
  Es una parte fundamental del paquete java.util.function y se utiliza principalmente para representar operaciones que
  se realizan sobre un solo argumento, como consumir un valor o realizar una acción con ese valor.
- Concisión y Claridad: Las expresiones lambda permiten escribir operaciones de consumo de manera más concisa y legible.
- Composición de Operaciones: El método andThen permite componer operaciones secuenciales de manera simple y clara.
- Compatibilidad con API Funcionales: `Consumer<T>` se puede usar en varios contextos, especialmente en operaciones de
  Streams para realizar acciones sobre cada elemento de una colección de datos.

```java
package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


/**
 * AppFunctions
 * <p>
 * AppFunctions class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppFunctions {

    // Consumer que imprime un valor
    static Consumer<String> printConsumer = log::info;
    // Consumer que imprime la longitud del valor
    static Consumer<String> lengthConsumer = s -> log.info("Longitud: {}", s.length());
    // Combinar Consumers usando 'andThen'
    static Consumer<String> combinedConsumer = printConsumer.andThen(lengthConsumer);
    static Consumer<Integer> printNumber = n -> log.info("Número: {}", n);


    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        printConsumer.accept("Hello world");
        lengthConsumer.accept("Java");
        combinedConsumer.accept("Hello, world");
        numbers.forEach(printNumber);
    }
}
```

#### Interface Supplier<T>

- Representa una operación que provee un objeto y no requiere parámetros
- La interfaz `Supplier<T>` en Java es una interfaz funcional que no acepta argumentos y produce un resultado de tipo T.
  Es parte del paquete java.util.function y se utiliza para representar proveedores de valores, es decir, funciones que
  no reciben ningún argumento y devuelven un resultado.
- `get():` Este es el único método abstracto que debe implementarse. No acepta ningún argumento y devuelve un resultado
  de tipo T.

```java
package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;


/**
 * AppFunctions
 * <p>
 * AppFunctions class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppFunctions {
    private static Random random = new Random();

    // Definir un Supplier que genera un número aleatorio entre 0 y 100

    static Supplier<Integer> randomSupplier = () -> random.nextInt(101);


    public static void main(String[] args) {

        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        List<Integer> squares = new LinkedList<>();

        numbers.forEach(n -> squares.add(n * n));
        log.info("number squares {}", squares);

        Map<Boolean, String> map = Map.of(true, "Hello", false, "World");

        map.forEach((k, v) -> log.info("key {} - value {}", k, v));


        // Obtener el número aleatorio usando el Supplier
        int number = randomSupplier.get();
        log.info("number random {}", number);

        // Generar una secuencia de 5 números enteros usando el Supplier
        Stream<Integer> integerStream = Stream.generate(randomSupplier).limit(10);
        integerStream.forEach(log::info);

    }
}
```

#### Interface UnaryOperator<T>

- Esta interfaz extiende de la interface Function y en esencia es lo mismo, con la diferencia que el argumento de tipo
  especificado será la entrada pasada por parámetro y el tipo de retorno.