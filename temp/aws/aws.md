## install aws cli

```bash
```

### aws configure

```shell
aws configure

AWS Access Key ID [None]:*****************************
AWS Secret Access Key [None]: :*****************************
Default region name [None]: us-east-1
Default output format [None]:


```

```shell
aws sts get-caller-identity

{                                                                                                                              
    "UserId": "+++++++++++++++++++++",
    "Account": "++++++++++++++++++++",
    "Arn": "arn:aws:iam::++++++++++++:user/+++++-++++++"
}

```

https://docs.aws.amazon.com/eks/latest/userguide/service_IAM_role.html#create-service-role

```shell
aws eks list-clusters --region us-east-1
{                                                                                                                              
    "clusters": [
        "aws-cluster-01"
    ]
}

```

```shell
aws eks describe-cluster --name aws-cluster-01

```

```bash
./kube
aws eks update-configure --name aws-cluster-01

```
