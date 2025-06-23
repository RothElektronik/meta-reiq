SUMMARY = "WiFi setup script and config"
LICENSE = "MIT"
SRC_URI = "file://wifi.sh \
           file://wpa_supplicant.conf"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/wifi
    install -m 0755 ${WORKDIR}/wifi.sh ${D}${sysconfdir}/wifi/wifi.sh
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/wifi/wpa_supplicant.conf
}

FILES:${PN} += "${sysconfdir}/wifi"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://dummy.txt;md5=d41d8cd98f00b204e9800998ecf8427e"


SRC_URI += "file://dummy.txt"
