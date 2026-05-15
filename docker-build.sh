#!/bin/bash

repository="hyperpaint"
name="nerf_exporter"
version="1.0.0"

./gradlew assemble

docker build --build-arg VERSION="${version}" --tag "$repository/$name:$version" .
