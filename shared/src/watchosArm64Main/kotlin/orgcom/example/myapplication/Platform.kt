package orgcom.example.myapplication

import platform.WatchKit.WKInterfaceDevice

actual class Platform actual constructor() {
    actual val platform: String = WKInterfaceDevice.currentDevice().systemName() + " " + WKInterfaceDevice.currentDevice().systemVersion()
}