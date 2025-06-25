#!/bin/sh

# Pull Image, falls nicht vorhanden
docker image inspect ghcr.io/home-assistant/home-assistant:stable > /dev/null 2>&1
if [ $? -ne 0 ]; then
    docker pull ghcr.io/home-assistant/home-assistant:stable
fi

# Datenverzeichnis vorbereiten
mkdir -p /data/homeassistant
