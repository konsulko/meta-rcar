SUMMARY = "Tools for si46xx AM/FM/DAB radio chip"
SECTION = "multimedia"

LICENSE = "CLOSED"

PE = "1"
PV = "0.2"

SRC_URI = " \
    file://si-tools.tar.gz \
"

S = "${WORKDIR}/si-tools"

EXTRA_OEMAKE_append = " 'LDFLAGS=${LDFLAGS}'"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}/lib/firmware/radio/

    install -m 755 si_ctl ${D}${bindir}
    install -m 755 si_flash ${D}${bindir}
    install -m 755 ${S}/scripts/si_init ${D}${bindir}
    install -m 755 ${S}/scripts/si_firmware_update ${D}${bindir}
    install -m 755 ${S}/scripts/si_fm ${D}${bindir}
    install -m 755 ${S}/scripts/si_preset ${D}${bindir}
    install -m 755 ${S}/scripts/si_scan ${D}${bindir}
    install -m 644 ${S}/firmware/am.bif ${D}/lib/firmware/radio/
    install -m 644 ${S}/firmware/fm.bif ${D}/lib/firmware/radio/
    install -m 644 ${S}/firmware/dab.bif ${D}/lib/firmware/radio/
    install -m 644 ${S}/firmware/patch.bin ${D}/lib/firmware/radio/
}

FILES_${PN} = " \
    ${bindir}/si_ctl \
    ${bindir}/si_flash \
    ${bindir}/si_init \
    ${bindir}/si_firmware_update \
    ${bindir}/si_fm \
    ${bindir}/si_preset \
    ${bindir}/si_scan \
    /lib/firmware/radio/am.bif \
    /lib/firmware/radio/fm.bif \
    /lib/firmware/radio/dab.bif \
    /lib/firmware/radio/patch.bin \
"
