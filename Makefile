.PHONY: build deploy clean

build:
	podman build -t retrofocus:latest .

deploy: build
	podman kube play deployment.yaml

clean:
	podman pod rm -f retrofocus-pod
	podman rmi retrofocus:latest
