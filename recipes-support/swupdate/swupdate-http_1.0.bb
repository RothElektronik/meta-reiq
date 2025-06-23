SUMMARY = "SWUpdate OTA Auto-Start"
LICENSE = "MIT"
SRC_URI += "file://swupdate.cfg file://swupdate-http.service"

inherit systemd

SYSTEMD_SERVICE:${PN} = "swupdate-http.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}/etc
    install -m 0644 ${WORKDIR}/swupdate.cfg ${D}/etc/

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/swupdate-http.service ${D}${systemd_unitdir}/system/
}

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://dummy.txt;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI += "file://dummy.txt"
