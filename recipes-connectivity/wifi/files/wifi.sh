#!/bin/sh

IFACE=wlan0

echo "Starte WLAN Setup..."

ip link set $IFACE up
wpa_supplicant -B -i $IFACE -c /etc/wpa_supplicant.conf
udhcpc -i $IFACE
