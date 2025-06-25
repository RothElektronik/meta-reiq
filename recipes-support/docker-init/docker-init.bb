SUMMARY = "Initialisiert Docker Container beim ersten Build"
LICENSE = "MIT"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://files/dummy.txt;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI += "file://dummy.txt"
SRC_URI += "file://docker-init.sh"
SRC_URI += "file://home-assistant.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/docker-init.sh ${D}${bindir}/docker-init.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/home-assistant.service ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE:${PN} = "home-assistant.service"
inherit systemd
