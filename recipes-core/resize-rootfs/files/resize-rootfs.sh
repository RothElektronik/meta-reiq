#!/bin/sh
export PATH=$PATH:/sbin:/usr/sbin

DEVICE="/dev/mmcblk1"
PARTITION="${DEVICE}p1"

# Partition auf maximalen Platz vergrößern (geht nur, wenn Partitionstabelle das zulässt!)
parted $DEVICE ---pretend-input-tty resizepart 1 100%

# Dateisystem anpassen
resize2fs $PARTITION

# Service beim nächsten Boot deaktivieren
#systemctl disable resize-rootfs.service
