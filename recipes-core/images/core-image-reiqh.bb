DESCRIPTION = "Image mit SWUpdate, Docker, HA & persistentem /data"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL:append = " \
  iw \
  wpa-supplicant \
  bluez5 \
  bluez5-testtools \
  networkmanager \
  alsa-utils \
  alsa-state \
  alsa-lib \
  nano \
  v4l-utils \
  htop \
  openssh \
  openssh-sftp-server \
  swupdate \
  docker \
  home-assistant \
  wifi \
  sudo \
  "

EXTRA_IMAGE_FEATURES = " \
    qtcreator-debug \
    allow-root-login \
    "
INHERIT += "extrausers"
EXTRA_USERS_PARAMS = "\
    useradd -p '\$6\$QuMEg7DIckTmQ3cp\$h9Vg5OnG2VAHdeIExwhDYyefJ0WA4NQsCq/8sFWneN3/rnDIkI24bWWRs7VClww/ONgZ3c/jCzqcmFNGUylcZ0' yoctobuild; \
    usermod -a -G wheel yoctobuild; \
    usermod -p '\$6\$QuMEg7DIckTmQ3cp\$h9Vg5OnG2VAHdeIExwhDYyefJ0WA4NQsCq/8sFWneN3/rnDIkI24bWWRs7VClww/ONgZ3c/jCzqcmFNGUylcZ0' root; \
"

# persistentes /data-Verzeichnis vorbereiten
ROOTFS_POSTPROCESS_COMMAND += "setup_data_mount;"

setup_data_mount () {
    install -d ${IMAGE_ROOTFS}/data/homeassistant
    install -d ${IMAGE_ROOTFS}/data/reiqh-ui
}

