FROM almalinux:10.1-20260407

ARG VERSION="null"

RUN dnf -y install java-21-openjdk
RUN dnf -y clean all

COPY --chown=root:root --chmod=755 "./build/libs/nerf_exporter-$VERSION.jar" "/root/nerf_exporter.jar"

WORKDIR "/root/"
CMD ["java","-jar","/root/nerf_exporter.jar"]
