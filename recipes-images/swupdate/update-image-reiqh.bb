DESCRIPTION = "SWUpdate OTA Paket für reIQH"
LICENSE = "MIT"
inherit swupdate

SRC_URI += "file://sw-description"
SRC_URI += "file://version_check.lua"

SWUPDATE_IMAGES = "core-image-reiqh"
SWUPDATE_IMAGES_FSTYPES[core-image-reiqh] = ".ext4.gz"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
