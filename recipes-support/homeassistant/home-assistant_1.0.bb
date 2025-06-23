SUMMARY = "Systemd service for Home Assistant in Docker"
DESCRIPTION = "Installs a systemd service to run Home Assistant as a Docker container"
LICENSE = "MIT"
SRC_URI = "file://home-assistant.service"

inherit systemd

SYSTEMD_SERVICE:${PN} = "home-assistant.service"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/home-assistant.service ${D}${systemd_system_unitdir}/
}

RDEPENDS:${PN} = "docker"

FILES:${PN} += "${systemd_system_unitdir}/home-assistant.service"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://dummy.txt;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI += "file://dummy.txt"
