# VPC

Una nube privada virtual (VPC) es una red virtual dedicada a su AWS cuenta. El servicio Amazon VPC que lo proporciona es
una capa de red para sus AWS recursos. Con Amazon VPC, puede definir una red virtual en su propia área aislada
lógicamente dentro de la nube. AWS Una VPC se parece mucho a una red tradicional que puede operar en su propio centro de
datos, con las ventajas de utilizar una infraestructura AWS escalable. Amazon VPC para los entornos de computación
virtual Amazon EC2, conocidos como instancias, se puede utilizar para una variedad de recursos. AWS

Las VPC ofrecen opciones que permiten flexibilidad en un entorno seguro, por ejemplo:

- Para configurar la VPC, puede seleccionar su rango de direcciones IP, crear subredes, configurar tablas de
  enrutamiento,
  puertas de enlace de red, interfaces de red y ajustes de seguridad.

- Para convertir la AWS nube en una extensión de su centro de datos, puede conectar su VPC a su propio centro de datos
  corporativo.

- Puede conectar las instancias de la VPC a Internet o mantener las instancias aisladas en una red privada.

- Para proteger los recursos de cada subred, puede utilizar varias capas de seguridad, incluidos grupos de seguridad y
  listas de control de acceso a la red (ACL).

Para obtener más información, consulte la Guía del usuario de Amazon VPC.

## Características

Las siguientes funciones lo ayudan a configurar una VPC para proporcionar la conectividad que necesitan sus
aplicaciones:

- **Nubes virtuales privadas (VPC)**
  Una VPC es una red virtual prácticamente idéntica a una red tradicional que podría operar en su propio centro de
  datos. Una vez creada una VPC, podrá agregar las subredes.

- **Subredes**
  Una subred es un rango de direcciones IP en su VPC. Una subred debe residir en una sola zona de disponibilidad.
  Después de agregar subredes, puede implementar recursos de AWS de su VPC.

- **Direccionamiento IP**
  Puede asignar direcciones IP, IPv4 y IPv6, a las VPC y las subredes. También puede incorporar sus direcciones IPv4
  públicas y GUA IPv6 a AWS y asignarlas a los recursos de su VPC, como las instancias de EC2, las puertas de enlace NAT
  y los equilibradores de carga de red.

- **Enrutamiento**
  Use las tablas de enrutamiento para determinar dónde se dirige el tráfico de red de su subred o puerta de enlace.

- Puertas de enlace y puntos de conexión
  Una puerta de enlace conecta su VPC a otra red. Por ejemplo, use una puerta de enlace de Internet para conectar la VPC
  a Internet. Use un punto de conexión de VPC para conectarse a Servicios de AWS de forma privada, sin el uso de una
  puerta de enlace de Internet o un dispositivo NAT.

- Conexiones de emparejamiento
  Use una conexión de emparejamiento de VPC para enrutar el tráfico entre los recursos de dos VPC.
- Replicación de tráfico
  Copie el tráfico de red desde las interfaces de red y envíelo a dispositivos de seguridad y monitoreo para una
  inspección profunda de paquetes.

- Puertas de enlace de tránsito
  Use una puerta de enlace de tránsito, que actúa como un concentrador central, para enrutar el tráfico entre sus VPC,
  las conexiones de VPN y las conexiones de AWS Direct Connect.

- Logs de flujo de VPC
  Los registros de flujo capturan información acerca del tráfico IP entrante y saliente de las interfaces de red en su
  VPC.

- Conexiones de VPN
  Conecte sus VPC a las redes en las instalaciones mediante AWS Virtual Private Network (AWS VPN).

# Subnet :

Network Address Block: 10.10.0.0/16
Subnet Mask: 255.255.240.0/20
No. of Hosts/Subnet; 4096
Number of Subnets: 16

| Subnet ID | Subnet Address |     Host Address Range      | Broadcast Address |
|:---------:|:--------------:|:---------------------------:|:-----------------:|
|     1     |   10.10.0.0    |  10.10.0.1 - 10.10.15.254   |   10.10.15.255    |
|     2     |   10.10.16.0   |  10.10.16.1 - 10.10.31.254  |   10.10.31.255    |
|     3     |   10.10.32.0   |  10.10.32.1 - 10.10.47.254  |   10.10.47.255    |
|     4     |   10.10.48.0   |  10.10.48.1 - 10.10.63.254  |   10.10.63.255    |
|     5     |   10.10.64.0   |  10.10.64.1 - 10.10.79.254  |   10.10.79.255    |
|     6     |   10.10.80.0   |  10.10.80.1 - 10.10.95.254  |   10.10.95.255    |
|     7     |   10.10.96.0   | 10.10.96.1 - 10.10.111.254  |   10.10.111.255   |
|     8     |  10.10.112.0   | 10.10.112.1 - 10.10.127.254 |   10.10.127.255   |
|     9     |  10.10.128.0   | 10.10.128.1 - 10.10.143.254 |   10.10.143.255   |
|    10     |  10.10.144.0   | 10.10.144.1 - 10.10.159.254 |   10.10.159.255   |
|    11     |  10.10.160.0   | 10.10.160.1 - 10.10.175.254 |   10.10.175.255   |
|    12     |  10.10.176.0   | 10.10.176.1 - 10.10.191.254 |   10.10.191.255   |
|    13     |  10.10.192.0   | 10.10.192.1 - 10.10.207.254 |   10.10.207.255   |
|    14     |  10.10.208.0   | 10.10.208.1 - 10.10.223.254 |   10.10.223.255   |
|    15     |  10.10.224.0   | 10.10.224.1 - 10.10.239.254 |   10.10.239.255   |
|    16     |  10.10.240.0   | 10.10.240.1 - 10.10.255.254 |   10.10.255.255   |