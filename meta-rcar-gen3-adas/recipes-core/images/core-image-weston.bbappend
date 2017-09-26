inherit ${@base_contains('DISTRO_FEATURES', 'qt5','populate_sdk_qt5',' ',d)}

IMAGE_INSTALL_append = " \
	packagegroup-common \
	packagegroup-qt5 \
	packagegroup-opencv-sdk \
	packagegroup-surroundview \
"

CONFLICT_DISTRO_FEATURES = "x11"