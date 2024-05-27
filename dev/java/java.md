# Repaso Entrevista JDK

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

- Interface funcional:
    - Es una interfaz que dispone de un solo método abstracto, puede tener métodos por default y privados.
    - Podemos avisarle al compilador de manera opcional que será una interface funcional anotándola
      con ```@FuncionalInterface```

- Expresión lambda
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

- Expresiones Genéricas

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

- Referencias a métodos:
    - Es una funcionalidad de java 8 que puede sustituir a una expresión lambda cuya única instrucción consiste en la
      llamada a un método.
    - El compilador infiere las variables dadas por parámetro en el argumento del método.
    - Lambda: o->System.out.print(o)
    - Método Referenciado: o->System.out::print
    - ```"MyClassOrObject::methodName" MyClassOrObject => Clase u Objeto, :: => Los métodos referenciados se especifica con doble punto (::) y methodName => Nombre del método a referenciar```
- Existen 4 tipos:

  | **Tipo de Referencia**       | **Referencia método**                | **Expresión lamba**                        |
    |------------------------------|--------------------------------------|--------------------------------------------|
  | [Método estático](#Estático) | ```String::ValueOf```                | ```s-> String.valueOf(s)```                |
  | Método de un objeto          | ```var r = new Random() r::nexInt``` | ```var r=new Random() n -> r.nextInt(n)``` |
  | Método arbitrario            | ```String::equals```                 | ```(s1,s2)-> s1.equals(s2)```              |
  | Método constructor           | ```Person::new```                    | ```s-> new Person(s)```                    |

Referencia de método:

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

Estático

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


