# Spending Service
Processes the adding of spending and publishes the event.

## Requirements

### Components
- PubSub Cluster
- https://github.com/PeterUlb/spending-worker

### Secrets
The following secrets must be provided to run the application on k8s

#### GCP PubSub Key

**Name:** pubsub-key  
**Value:** key.json=BASE64_FILE_CONTENT  
**Example:**
<details>

`kubectl create secret generic pubsub-key --from-file=key.json=PATH-TO-KEY-FILE.json`
</details>

#### Secrets Configuration

**Name:** spending-service  
**Values:**  
relevant.property.x=BASE64  
other.property.set=BASE64  
**Example:**
<details>

```
apiVersion: v1
data:
  a.b.c: bGV0bWVpbg==
  d.e.f: ZGV2
kind: Secret
metadata:
  name: spending-service
```

`kubectl create secret generic spending-service --from-literal=a.b.c=user --from-literal=d.e.f=p455w0rd`
</details>






# Example YAML



## Roles
<details>

```
kind: Role
apiVersion: rbac.authorization.k8s.io/v1
metadata:
namespace: default
name: namespace-reader
rules:
- apiGroups: [ "", "extensions", "apps" ]
  resources: [ "configmaps", "pods", "services", "endpoints", "secrets" ]
  verbs: [ "get", "list", "watch" ]

---

kind: RoleBinding
apiVersion: rbac.authorization.k8s.io/v1
metadata:
name: namespace-reader-binding
namespace: default
subjects:
- kind: ServiceAccount
  name: default
  apiGroup: ""
  roleRef:
  kind: Role
  name: namespace-reader
  apiGroup: ""
```
</details>