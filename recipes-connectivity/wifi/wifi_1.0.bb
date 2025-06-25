SUMMARY = "WiFi setup script and config"
LICENSE = "MIT"
SRC_URI = "file://wifi.sh \
           file://wifi-setup.service \
           file://dummy.txt"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/wifi
    install -m 0755 ${WORKDIR}/wifi.sh ${D}${sysconfdir}/wifi/wifi.sh

    # Service-File installieren:
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/wifi-setup.service ${D}${systemd_system_unitdir}/wifi-setup.service
}

FILES:${PN} += "${sysconfdir}/wifi"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://dummy.txt;md5=d41d8cd98f00b204e9800998ecf8427e"

inherit systemd
SYSTEMD_SERVICE:${PN} = "wifi-setup.service"
