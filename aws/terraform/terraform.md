# Terraform

```bash
terraform init
```

```bash
terraform plan -out=tfplan
terraform apply
```

```bash
terraform apply --auto-approve
```

```bash
terraform destroy
```

## Tipos Infraestructura como código: (IaC)

- Orientado a la configuración:
    - **`Ansible`**
    - **`puppet`**
        - La finalidad es instalar y gestionar software (aprovisionamiento de servidores)
        - Nos permite mantener un estándar en nuestros servidores
        - Podemos tener un control de versiones de nuestros despliegues
- Orientado a Servidores: (templates)
    - **`Docker`**
    - **`Packer`**
    - **`Vagrant`**
        - Nos permite tener preinstalado el software y las dependencias necesarias
        - Funciona tanto para VM como para contenedores
        - Infraestructura Inmutable
- Orientado para aprovisionamiento:
    - **`Terraform`**
    - **`Aws CloudFormation`**
        - Infraestructura como código Declarativo
        - Aprovisionar recursos inmutables en nuestra infraestructura
        - Toda clase de recursos como instancias, bases de datos buckets, vpc etc
        - Podemos deploy infraestructura en multiples providers (Terraform)

## Que es HCL

![img.png](images/7446ff1c-96f0-46d5-a0c6-b29a1efc3a67.png)

```link
https://registry.terraform.io/
```

### Ejemplo:

```terraform
resource "local_file" "products" {
  content  = "List of products para el mes próximo"
  filename = "products.txt"
}
```

### Creación de un bucket:

```shell
aws sts get-caller-identity
```

### Iniciar código

```bash
terraform init
```

### Plan

```bash
terraform plan
```

### Desplegar la infraestructura

```bash
terraform plan
```

### Destruir la infraestructura

```bash
terraform destroy
```

### Formater archivos de configuración

```bash
terraform fmt
```

### Validar archivos sintaxis correcta

```bash
terraform validate
```

### Listar los providers

```bash
terraform providers
```

### Listar los outputs

```bash
terraform output
```

### Refrescar los cambios

```bash
terraform refresh
```

### Lista de las dependence e interrelacionan

```bash
terraform graph | 
```

## Restringir las versiones de Terraform y Providers

## Variables

![img_1.png](images/4f4678ac-2fa3-408f-8238-a134b5b34573.png)

### Tipos de Variables en terraform

- string
- number
- bool
- list
- map
- set
- object
- tuple
- output
- any

## Dependencias

- Implicitas
- Explicita

## Diagramas de Infraestructura

![(vpc.png](images/2ae050cf-2abd-450a-b8eb-759d5cf77fb8.png)

## Terraform State (tfstate)

![img_2.png](images/9749a373-127e-4455-88b2-526d24ff0db6.png)

- archivo texto plano
- **`terraform state list`**
- **`terraform state show name-recurso`**
- **`terraform state rm`**

## Terraform 