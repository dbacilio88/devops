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