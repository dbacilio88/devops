# **KAFKA**

## TOPIC:

Un topic es un stream (flujo) de mensajes, cada topic se compone de una o más particiones.
Los mensajes son colocados en las particiones y son ordenados de acuerdo a un número llamado `**offset**`

Tener múltiples particiones permite tener más consumidores de mensajes funcionando de forma concurrente, esto se ve
reflejado en el incremento del throughput(tasa de transferencia o velocidad).

### CREAR TOPIC

Los mensajes se procesan en topics, para crear uno deberás ejecutar el siguiente comando:

```Bash
/opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server kafka:9092 --create --topic bacsystem.topic --partitions 5 --replication-factor 1
```

### LISTAR TOPIC

Puedes listar los topics disponibles ejecutando

```Bash
/opt/bitnami/kafka/bin/kafka-topics.sh --list --bootstrap-server kafka:9092
```

### VER DEFINICIÓN DE UN TOPIC

Si deseas consultar como se definió un topic puedes describirlo con el siguiente comando:

```Bash
/opt/bitnami/kafka/bin/kafka-topics.sh --describe --topic bacsystem-topic-1 --bootstrap-server kafka:9092
```

### MODIFICACIÓN DE UN TOPIC

Para modificar un topic existente ejecutaremos el siguiente comando:

```Bash
/opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server kafka:9092 --alter --topic bacsystem-topic-1 --partitions 40
```

### ELIMINAR TOPICS

```Bash
/opt/bitnami/kafka/bin/kafka-topics.sh --delete --topic bacsystem-topic-1 --bootstrap-server kafka:9092
```

## REPLICAS:

Para incrementar la disponibilidad de la información, los topics se deben replicar en múltiples brokers, esto se
define en el atributo `**replication-factor**`, el cual define el número de copias de la información. Cada topic tendrá
asignado un líder y seguidores.

Una réplica actualizada se conocerá como `**(In-sync)**` y se mantiene actualizada con los cambios del líder.
Si el líder falla una In-sync se puede convertir en líder.

En un ambiente saludable todas las réplicas deben encontrarse In-sync, es aceptable que no se encuentren de ese modo
después de un fallo.

## MENSAJES

Un mensaje es una unidad de datos en Kafka, está compuesto por una llave y un valor.

## PRODUCER

Un producer es un componente que publica mensajes en uno o más topics. Puede seleccionar en que partición desea colocar
los mensajes.

Para iniciar un producer ejecutaremos el siguiente comando:

### CREAR UN PRODUCER

```Bash
/opt/bitnami/kafka/bin/kafka-console-producer.sh --topic bacsystem-topic --bootstrap-server kafka:9092
```

## CONSUMER

Un consumer lee mensajes de uno o más topics y los procesa. La diferencia entre el la posición actual del consumer y el
mensaje más nuevo de la partición se conoce como `**(offset lag)**`.

Si el offset lag no es muy largo eso no es un problema, se puede convertir en uno si se acerca al
`**rentention period**` (Periodo de tiempo que se mantienen los mensajes en kafka).

### CREAR UN CONSUMER

Para iniciar un consumer ejecutaremos el siguiente comando:
El parámetro `**--from-beginning**` permite especificar si queremos recibir solo los mensajes nuevos o queremos leer
todos desde el inicio.

```Bash
/opt/bitnami/kafka/bin/kafka-console-consumer.sh --topic bacsystem-topic-1 --bootstrap-server kafka:9092
/opt/bitnami/kafka/bin/kafka-console-consumer.sh --topic bacsystem-topic-1 --from-beginning --bootstrap-server kafka:9092
/opt/bitnami/kafka/bin/kafka-console-consumer.sh --topic bacsystem-topic --from-beginning --bootstrap-server kafka:9092 --property print.key=true --property key.separator="-"
/opt/bitnami/kafka/bin/kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic dbserver1.public.bs_region --from-beginning
```