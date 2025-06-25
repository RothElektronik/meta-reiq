#Konflikt mit mDNS auflösen die, die selbe datei erstellen wollen

do_install:append() {
    # Entferne die Datei, die mit mdns kollidiert
    rm -f ${D}${libdir}/libnss_mdns.so.2
}
