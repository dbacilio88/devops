## Iniciar minikube

```shell
minikube start
minikube start --help
minikube start --kubernetes-version='version'
```

```shell
cat config
```

```yml
apiVersion: v1
clusters:
  - cluster:
      certificate-authority: /home/docker/.minikube/ca.crt
      extensions:
        - extension:
            last-update: Thu, 23 May 2024 16:01:16 -05
            provider: minikube.sigs.k8s.io
            version: v1.33.1
          name: cluster_info
      server: https://192.168.49.2:8443
    name: minikube
contexts:
  - context:
      cluster: minikube
      extensions:
        - extension:
            last-update: Thu, 23 May 2024 16:01:16 -05
            provider: minikube.sigs.k8s.io
            version: v1.33.1
          name: context_info
      namespace: default
      user: minikube
    name: minikube
current-context: minikube
kind: Config
preferences: { }
users:
  - name: minikube
    user:
      client-certificate: /home/docker/.minikube/profiles/minikube/client.crt
      client-key: /home/docker/.minikube/profiles/minikube/client.key
```

#### minikube: permite gestionar el cluster local

#### kubectl: permite conectarnos al cluster

```shell
 minikube status
 minikube ip
 minikube addons list
 minikube addons enable dashboard
 minikube addons enable metrics-server
 minikube addons list
 minikube dashboard
```

```shell
minikube ssh
```

## commands kubectl

```shell
kubectl get nodes

NAME       STATUS   ROLES           AGE   VERSION
minikube   Ready    control-plane   37m   v1.30.0
```

## configuration minikube

```shell
minikube config
minikube config view
```

## configuration minikube cluster

```shell
minikube start -p cluster1
minikube start -p cluster2
minikube -p cluster1 kubectl get nodes
minikube -p cluster2 kubectl get nodes
alias k1 "minikube -p cluster1 kubectl"
alias k2 "minikube -p cluster2 kubectl"
```

## configuration recursos declarativa e imperativa

```shell
kubectl get all
NAME                 TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
service/kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   17m


kubectl get all -o wide
```

```shell
kubectl get ns

NAME              STATUS   AGE
default           Active   17m
kube-node-lease   Active   17m
kube-public       Active   17m
kube-system       Active   17m

```

```shell
kubectl apply -f nginx-deployment.yaml
kubectl delete -f nginx-deployment.yaml
```

```shell
kubectl create deployment --image=nginx:latest --replicas=2 'name-deployment'
kubectl delete deployment 'name-deployment'
```

## Pods

#### Los pods son las unidades informáticas implementable más pequeñas que puede crear y administrar en Kubernetes.

- Pods que ejecutan un solo contenedor

```yml
apiVersion: v1
kind: Pod
metadata:
  name: nginx
spec:
  containers:
    - name: nginx
      image: nginx:1.14.2
      ports:
        - containerPort: 80

```

```shell
kubctl get all
kubctl get pods
kubctl get pods -w
kubctl get pod -o wide
kubctl describe pod 'name-pod'
```

## Metadata, labels y selectors

```shell
kubctl get pod --show-labels
kubctl get pod --show-labels -l environment
kubctl get pod --selector 'project=criterio de búsqueda'
```

## Pod lifecycle

```shell
kubctl exec 'name-pod' ls
kubctl exec 'name-pod' bash
```

## Replication controller | replicaSet

```yml
apiVersion: v1
kind: ReplicationController
metadata:
  name: nginx
spec:
  replicas: 3
  selector:
    app: nginx
  template:
    metadata:
      name: nginx
      labels:
        app: nginx
    spec:
      containers:
        - name: nginx
          image: nginx
          ports:
            - containerPort: 80
```

```yml
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: frontend
  labels:
    app: guestbook
    tier: frontend
spec:
  # modify replicas according to your case
  replicas: 3
  selector:
    matchLabels:
      tier: frontend
  template:
    metadata:
      labels:
        tier: frontend
    spec:
      containers:
        - name: php-redis
          image: us-docker.pkg.dev/google-samples/containers/gke/gb-frontend:v5

```

#### scale

```shell
kbctl scale rc 'name' --replicas=1
```

| component     | Description                                               |
|---------------|-----------------------------------------------------------| 
| `Pod`         | *Capa que se construye sobre los contenedores*            |
| `Service`     | *Permite comunicación con direcciones fijas*              |
| `Ingress`     | *Tráfico externo que viaja para adentro del cluster*      |
| `ConfigMap`   | *Configuraciones como variables de entorno*               |
| `Secrets`     | *Similar al ConfigMap pero secretos*                      |
| `Volume`      | *Mantener la data persistente*                            |
| `Deployment`  | *Planos o "BluePrints" de la construcción de un pod*      |
| `StatefulSet` | *Similar al "Deployment" pero para uso de bases de datos* |

# MINI KUBE

```
https://minikube.sigs.k8s.io/docs/
```

### KUBECTL

## Basic Kubernetes Commandskb

| command                                                                | description                                      |
|------------------------------------------------------------------------|--------------------------------------------------|
| `kubectl config view`                                                  | Para ver la configuración actual de kubectl      |
| `kubectl config get-contexts`                                          | Para enumerar todos los contextos disponibles    |
| `kubectl cluster-info`                                                 | información del cluster                          |
| `kubectl get nodes`                                                    | lista de los nodos del cluster                   |
| `kubectl get service`                                                  | lista de los servicios                           |
| `kubectl get pods`                                                     | lista de los pods                                |
| `kubectl get deployments`                                              | lista de deployments                             |
| `kubectl get namespaces`                                               | lista de namespaces                              |
| `kubectl get pods -n prueba`                                           | lista de los pods del namespace prueba           |
| `kubectl expose deployment first-deployment --port=80 --type=NodePort` | exponer un deployment                            |
| `kubectl describe pod apache1`                                         | información detallada del pod apache1            |
| `kubectl delete service hello-world`                                   | eliminar servicio                                |
| `kubectl delete deployment hello-world`                                | eliminar deployment                              |
| `kubectl scale --replicas=3 deployment prestashop -n prestashop`       | escalar a 3 replicas un deployment               |
| `kubectl apply -f deployment.yaml`                                     | aplicar el contenido del fichero deployment.yaml |
| `kubeadm token list`                                                   | listar los tokens                                |
| `kubectl config current-context`                                       | Para obtener el contexto actual de kubectl       |

```bash
$ minikube start
$ minikube version
$ kubectl version --shot
$ kubectl get all
```

### OUT KUBECTL

#### kubectl get all

| NAME                                    | READY | STATUS  | RESTARTS | AGE |
|-----------------------------------------|-------|---------|----------|-----|
| pod/postgres-deployment-cb955444f-rfmmw | 1/1   | Running | 0        | 15m |

| NAME                     | TYPE      | CLUSTER-IP     | EXTERNAL-IP | PORT(S)  | AGE |
|--------------------------|-----------|----------------|-------------|----------|-----|
| service/kubernetes       | ClusterIP | 10.96.0.1      | <none>      | 443/TCP  | 45m |
| service/postgres-service | ClusterIP | 10.111.187.169 | <none>      | 5432/TCP | 15m |

| NAME                                | READY | UP-TO-DATE | AVAILABLE | AGE |
|-------------------------------------|-------|------------|-----------|-----|
| deployment.apps/postgres-deployment | 1/1   | 1          | 1         | 15m |

| NAME                                          | DESIRED | CURRENT | READY | AGE |
|-----------------------------------------------|---------|---------|-------|-----|
| replicaset.apps/postgres-deployment-cb955444f | 1       | 1       | 1     | 15m |

## SECRETS

### Managing Secrets using Configuration File

#### 1. Create the Secret Convert the strings to base64:

```bash
$ echo -n 'admin' | base64
$ echo -n '1f2d1e2e67df' | base64
```

#### The output is similar to:

```textmate
 YWRtaW4=
 MWYyZDFlMmU2N2Rm
```

#### 2. Create the manifest:

```yml
apiVersion: v1
kind: Secret
metadata:
  name: postgres-secrets
type: Opaque
data:
  DB_USER: cG9zdGdyZXM=
  DB_PASSWORD: cG9zdGdyZXM=
```

#### 3. Create the Secret using kubectl apply:

```bash
$ kubectl apply -f postgres-secret.yml
```

```text
 secret/postgres-secrets created
```

#### 4. When you retrieve the Secret data

```bash
$ kubectl get secret 
````

#### The output is similar to:

| NAME             | TYPE   | DATA | AGE |
|------------------|--------|------|-----|
| postgres-secrets | Opaque | 2    | 28s |

#### 4.1 When you retrieve the Secret data

```bash
$ kubectl get secret postgres-secrets -o yaml
````

#### The output is similar to:

```yaml
apiVersion: v1
data:
  DB_PASSWORD: cG9zdGdyZXM=
  DB_USER: cG9zdGdyZXM=
kind: Secret
metadata:
  annotations:
    kubectl.kubernetes.io/last-applied-configuration: |
      {"apiVersion":"v1","data":{"DB_PASSWORD":"cG9zdGdyZXM=","DB_USER":"cG9zdGdyZXM="},"kind":"Secret","metadata":{"annotations":{},"name":"postgres-secrets","namespace":"default"},"type":"Opaque"}
  creationTimestamp: "2023-12-12T12:41:17Z"
  name: postgres-secrets
  namespace: default
  resourceVersion: "6698"
  uid: 7950fc20-fb8f-4f6d-9bae-d52897d82f72
type: Opaque
```

#### 5. Edit a Secret

#### 5.1. Encode the new password string:

```bash
$ echo -n 'postgres1' | base64
```

#### The output is similar to:

```textmate
 cG9zdGdyZXMx
```

#### 5.2. Update the data field with your new password string:

```yml
apiVersion: v1
kind: Secret
metadata:
  name: postgres-secrets
type: Opaque
data:
  DB_USER: cG9zdGdyZXM=
  DB_PASSWORD: cG9zdGdyZXMx
```

#### 5.3. Apply the manifest to your cluster:

```bash
$ kubectl apply -f postgres-secret.yml
```

```text
 secret/postgres-secrets configured
```

#### 6. Clean up

```bash
$ kubectl delete secret postgres-secrets
````

```text
 secret "postgres-secrets" deleted
```

# updating down

### CONFIG MAP

```yml
apiVersion: v1
kind: ConfigMap
metadata:
  name: postgres-config
data:
  DB_NAME: postgres
  DB_HOST: postgres-service
  DB_PORT: "5432"
```

### RUN CONFIG MAP

```bash
$ kubectl apply -f postgres-config.yml
```

## DEPLOYMENT AND SERVICES

```yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: postgres-deployment
spec:
  replicas: 1
  selector:
    matchLabels:
      app: postgres
  template:
    metadata:
      labels:
        app: postgres
    spec:
      containers:
        - name: postgres
          image: postgres:15.1
          resources:
            limits:
              memory: "128Mi"
              cpu: "500m"
          ports:
            - containerPort: 5432
          env:
            - name: POSTGRES_PASSWORD
              valueFrom:
                secretKeyRef:
                  name: postgres-secrets
                  key: DB_PASSWORD
---
apiVersion: v1
kind: Service
metadata:
  name: postgres-service
spec:
  selector:
    app: postgres
  ports:
    - protocol: TCP
      port: 5432 #cualquier puerto
      targetPort: 5432

```

### RUN DEPLOYMENT AND SERVICES

```bash
$ kubectl apply -f postgres.yml
```

### DESCRIBE DEPLOYMENT

```bash
$ kubectl describe deployment.apps/postgres-deployment
```

### LOGS PODS

```bash
$ kubectl logs pod/postgres-deployment-cb955444f-rfmmw
```

### PODS

```bash
$ kubectl get pods
```

### OUT PODS

| NAME                                | READY | STATUS  | RESTARTS | AGE |
|-------------------------------------|-------|---------|----------|-----|
| postgres-deployment-cb955444f-rfmmw | 1/1   | Running | 0        | 11m |

```bash
$ echo dbacilio88@gmail.com | base64
```