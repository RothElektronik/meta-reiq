#Sowohl netbase als auch iptables versuchen, die Datei /etc/ethertypes ins Root-Dateisystem zu installieren Dateikonflikt, daher bricht Yocto den Build ab.

do_install:append() {
    rm -f ${D}${sysconfdir}/ethertypes
}
