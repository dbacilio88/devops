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
    "UserId": "AIDAZQ3DR34TGHQ7LBE5I",
    "Account": "654654431014",
    "Arn": "arn:aws:iam::654654431014:user/cbaciliod-kubernetes"
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
{                                                                                                                              
    "cluster": {
        "name": "aws-cluster-01",
        "arn": "arn:aws:eks:us-east-1:654654431014:cluster/aws-cluster-01",
        "createdAt": "2024-05-25T21:11:00.682000-05:00",
        "version": "1.29",
        "endpoint": "https://2245B8A573A24A71EE1F4864C6A26860.gr7.us-east-1.eks.amazonaws.com",
        "roleArn": "arn:aws:iam::654654431014:role/eksClusterRole",
        "resourcesVpcConfig": {
            "subnetIds": [
                "subnet-02e6eab63468f6563",
                "subnet-04d2a81fc04129695",
                "subnet-02a02ab739cdabe30",
                "subnet-08a53f3ba52a6d551",
                "subnet-02b03605e84bcaf98"
            ],
            "securityGroupIds": [
                "sg-03e72ac093c3d463c"
            ],
            "clusterSecurityGroupId": "sg-097eef75705fe014d",
            "vpcId": "vpc-0a70ba4e9b53d8c22",
            "endpointPublicAccess": true,
            "endpointPrivateAccess": false,
            "publicAccessCidrs": [
                "0.0.0.0/0"
            ]
        },                                                                                                                     
        "kubernetesNetworkConfig": {
            "serviceIpv4Cidr": "10.100.0.0/16",
            "ipFamily": "ipv4"
        },
        "logging": {
            "clusterLogging": [
                {
                    "types": [
                        "api",
                        "audit",
                        "authenticator",
                        "controllerManager",
                        "scheduler"
                    ],
                    "enabled": false
                }
            ]
        },
        "identity": {
            "oidc": {
                "issuer": "https://oidc.eks.us-east-1.amazonaws.com/id/2245B8A573A24A71EE1F4864C6A26860"
            }
        },
        "status": "ACTIVE",
        "certificateAuthority": {
            "data": "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSURCVENDQWUyZ0F3SUJBZ0lJTUVjSVJvYkVJQ1V3RFFZSktvWklodmNOQVFFTEJRQXd
GVEVUTUJFR0ExVUUKQXhNS2EzVmlaWEp1WlhSbGN6QWVGdzB5TkRBMU1qWXdNakV4TURoYUZ3MHpOREExTWpRd01qRTJNRGhhTUJVeApFekFSQmdOVkJBTVRDbXQxWW1
WeWJtVjBaWE13Z2dFaU1BMEdDU3FHU0liM0RRRUJBUVVBQTRJQkR3QXdnZ0VLCkFvSUJBUUN1eG4raUhJdUVpT0J2MVNQbjByUDc3VFpOcGYvZDVGamM0Tml2QVdPZ1p
0STBPc3dPK2xueFRBcFgKT0Ryb3dOVUgzcXJCbGp0bHVxdjFta0xaRXJHaHBnSEE1TkFGOE5HYVZzeWFkYXNkdHhRcHRSaTFaL3JMdXpydQp2V0ErSk5lazNaeTZaSW9
lYXRGNnVJWHVabXBUK0xlZytxQzhSZWRPbjJUTVR1SEtQYnRJOWRWVGt1TlpkejRKCjhsN2ZORHU1RFdmVWxWUUJxbHFWQjRpZ3VReGtUbGh4TmVRRkJzS0k1WDN5SkQ
vM2cwSjdJcEhBdjhHeHBhS0kKYW9QbjF3YUR3ekx1cXFLM3ZTc3NnNTdnNTRSTldxWEM0dnJMa25IYisxbkMxZHNPa001ZWtsZWNHNkFtMzNDegpzNGRsN2d2aVozTzF
NT0NpSDEwRjk3Ri9Jd1F4QWdNQkFBR2pXVEJYTUE0R0ExVWREd0VCL3dRRUF3SUNwREFQCkJnTlZIUk1CQWY4RUJUQURBUUgvTUIwR0ExVWREZ1FXQkJRbWJBTTdlUEx
YbkxNd3ZUc0RFR0F2MW9qT0pUQVYKQmdOVkhSRUVEakFNZ2dwcmRXSmxjbTVsZEdWek1BMEdDU3FHU0liM0RRRUJDd1VBQTRJQkFRQkMwR1hZcU53aApJbHMrZzZqUjd
rRC93MjRnV1dOMDYwbDgvb3RjQXFPOHhSQWQyUkNBNFhIb2NQZWtTQTdId2hsNFlKVjJpWkprCkxKRWFydERMTzZwVDRGQ2xiZkg2d1lNYlRLSVdIWjNaVVRKb1JMWTk
1MS9MWjNpTTB2cVQxNXRyZFUzRnRLT2gKMFdTd0hhR1pnSTBsSjR6WEUreGNZSURWNHp1NEZlMzMybWRBYnVON0lpWWtBR1F3akhpdE92OTVTVHV2bEJvNApjbVliWTd
zNjNOSzF3N01Jc21GU3lNM3JsN0ZIWFNVUXk4a1VETnVGYjdaMnY5dUxzZnVPaTBLcldjdVBKSVdlCno1WlE3TXkwV2J3cC90UlpJaG9sQmhudldYWWdoMms4WHhpWmpwQlN3YWtPZEg4SjlFMXZtSWl5VGE1N2U3MmoKSGdIeGxLU2tDeHkrCi0tLS0tRU5EIENFUlRJRklDQVRFLS0tLS0K"
        },
        "platformVersion": "eks.7",
        "tags": {},
        "health": {
            "issues": []
        },
        "accessConfig": {
            "authenticationMode": "API_AND_CONFIG_MAP"
        }
    }
}

```

```bash
./kube
aws eks update-configure --name aws-cluster-01

```
