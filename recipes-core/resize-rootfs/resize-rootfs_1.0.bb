SUMMARY = "Resize rootfs on first boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://resize-rootfs.sh \
           file://resize-rootfs.service"

S = "${WORKDIR}"
RDEPENDS:${PN} += "e2fsprogs-resize2fs"
inherit systemd

SYSTEMD_SERVICE:${PN} = "resize-rootfs.service"

do_install() {
    install -d ${D}/usr/sbin
    install -m 0755 ${WORKDIR}/resize-rootfs.sh ${D}/usr/sbin/resize-rootfs.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/resize-rootfs.service ${D}${systemd_system_unitdir}/
}

FILES:${PN} += "${systemd_system_unitdir}/resize-rootfs.service /usr/sbin/resize-rootfs.sh"
