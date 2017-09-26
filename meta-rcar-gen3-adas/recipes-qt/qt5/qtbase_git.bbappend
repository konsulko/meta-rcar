FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# switch to GLES 2 support
PACKAGECONFIG_GL = "${@base_contains('DISTRO_FEATURES', 'opengl', 'virtual/libgles2  virtual/egl', '', d)}"
PACKAGECONFIG_WAYLAND = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)}"

PACKAGECONFIG[wayland]="-qpa wayland-egl -no-qpa-platform-guard"

QT_CONFIG_FLAGS += " -c++std c++1z "

# add necessary packages
PACKAGECONFIG_append = " \
        ${PACKAGECONFIG_WAYLAND} \
	sql-sqlite \
	sql-sqlite2 \
	openssl \
	icu \
	accessibility \
	examples \
	alsa \
	glib \
"
do_install_append() {
  # Avoid qmake error "Cannot read [...]/usr/lib/qt5/mkspecs/oe-device-extra.pri: No such file or directory"
    touch ${D}/${OE_QMAKE_PATH_QT_ARCHDATA}/mkspecs/oe-device-extra.pri
}
