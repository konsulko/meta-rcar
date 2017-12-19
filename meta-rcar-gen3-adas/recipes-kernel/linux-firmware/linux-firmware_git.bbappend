# Support additional firmware for WiLink8 modules
#
# TIInit_11.8.32.bts V4.2 is not in the linux-firmware repository.

SRC_URI_append = " \
     https://git.ti.com/ti-bt/service-packs/blobs/raw/3acb49e97179320cb7564d202d0dde23ad7bd0a2/initscripts/TIInit_11.8.32.bts \
"

SRC_URI[md5sum] = "b1e142773e8ef0537b93895ebe2fcae3"
SRC_URI[sha256sum] = "962322c05857ad6b1fb81467bdfc59c125e04a6a8eaabf7f24b742ddd68c3bfa"

do_install_append() {
     install -m 644 ${WORKDIR}/TIInit_11.8.32.bts ${D}/lib/firmware/ti-connectivity/
}
