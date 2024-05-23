## Instalación de KUBECTL

```
https://kubernetes.io/es/docs/tasks/tools/install-kubectl-linux/#instalaci%C3%B3n-mediante-el-administrador-de-paquetes-nativo
```

## Agregar Kubernetes al repositorio

```bash
cat <<EOF | sudo tee /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=https://pkgs.k8s.io/core:/stable:/v1.30/rpm/
enabled=1
gpgcheck=1
gpgkey=https://pkgs.k8s.io/core:/stable:/v1.30/rpm/repodata/repomd.xml.key
EOF
```

## Instalación de Minikube

```bash
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
```

```bash
sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64
```

```shell
minikube version
  minikube version: v1.33.1
  commit: 5883c09216182566a63dff4c326a6fc9ed2982ff
```
