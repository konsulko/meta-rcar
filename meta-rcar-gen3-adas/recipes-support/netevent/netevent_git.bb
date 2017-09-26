SUMMARY = "netevent - share input devices over net"
SECTION = "misc"

LICENSE = "CLOSED"

PN = "netevent"
PE = "1"
PV = "0.1"
PR = "r1"

PATCHTOOL = "git"

SRC_URI = "git://github.com/CogentEmbedded/netevent.git;protocol=https;nobranch=1"

SRCREV = "5172a504359579b775b16f3db6cf70ff11426700"

S = "${WORKDIR}/git"

B = "${S}"

do_install() {
    install -d ${D}${bindir}

    install -m 0755 netevent ${D}${bindir}/
    install -m 0755 devname ${D}${bindir}/
}
