FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://wpa_supplicant.conf"

do_install:append() {
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant.conf
}
