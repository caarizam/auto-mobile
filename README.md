# auto-mobile
Mobile automation with appium

## Common ADB commands

`adb` (Android Debug Bridge) ships with the Android SDK `platform-tools`. Make sure it is on your `PATH`.

### Connect and manage devices

| Action | Command |
|---|---|
| List connected devices | `adb devices` |
| List devices with details (model, transport id) | `adb devices -l` |
| Connect over Wi-Fi (TCP/IP) | `adb connect <ip>:5555` |
| Enable TCP/IP mode on a USB-connected device | `adb tcpip 5555` |
| Disconnect a Wi-Fi device | `adb disconnect <ip>:5555` |
| Disconnect all devices | `adb disconnect` |
| Target a specific device when several are connected | `adb -s <device_id> <command>` |
| Start the adb server | `adb start-server` |
| Stop / restart the adb server | `adb kill-server` then `adb start-server` |
| Open a shell on the device | `adb shell` |

### Reboot

| Action | Command |
|---|---|
| Reboot the device | `adb reboot` |
| Reboot into recovery | `adb reboot recovery` |
| Reboot into bootloader | `adb reboot bootloader` |

### Install and uninstall apps

| Action | Command |
|---|---|
| Install an APK | `adb install path/to/app.apk` |
| Reinstall keeping data | `adb install -r path/to/app.apk` |
| Allow version downgrade | `adb install -r -d path/to/app.apk` |
| Grant all runtime permissions on install | `adb install -g path/to/app.apk` |
| Uninstall an app | `adb uninstall <appPackage>` |
| Uninstall but keep data and cache | `adb uninstall -k <appPackage>` |
| Clear app data | `adb shell pm clear <appPackage>` |
| List installed packages | `adb shell pm list packages` |
| List third-party packages only | `adb shell pm list packages -3` |
| Find a package by name | `adb shell pm list packages \| findstr <name>` (Windows) / `\| grep <name>` (Linux/macOS) |

### Get app information

| Action | Command |
|---|---|
| Get the app version (`versionName` / `versionCode`) | `adb shell dumpsys package <appPackage> \| findstr version` (Windows) / `\| grep version` (Linux/macOS) |
| Get the APK path on the device | `adb shell pm path <appPackage>` |
| Get the currently focused `appPackage` and `appActivity` (Windows) | `adb shell dumpsys window \| findstr mCurrentFocus` |
| Get the currently focused `appPackage` and `appActivity` (Linux/macOS) | `adb shell dumpsys window \| grep mCurrentFocus` |
| Get the resumed activity (Android 10+) | `adb shell dumpsys activity activities \| findstr ResumedActivity` |
| Get the launcher activity of a package | `adb shell cmd package resolve-activity --brief <appPackage>` |
| Get package and activity from an APK file | `aapt dump badging path/to/app.apk \| findstr "package: launchable-activity"` |

Example output of `mCurrentFocus`:

```
mCurrentFocus=Window{abc123 u0 com.example.app/com.example.app.MainActivity}
```

- **appPackage**: `com.example.app`
- **appActivity**: `com.example.app.MainActivity` (or `.MainActivity`)

### Device information

| Action | Command |
|---|---|
| Android version (release) | `adb shell getprop ro.build.version.release` |
| SDK / API level | `adb shell getprop ro.build.version.sdk` |
| Device model | `adb shell getprop ro.product.model` |
| Manufacturer | `adb shell getprop ro.product.manufacturer` |
| Device serial number | `adb get-serialno` |
| Screen resolution | `adb shell wm size` |
| Screen density | `adb shell wm density` |
| Battery status | `adb shell dumpsys battery` |

### Launch and stop apps

| Action | Command |
|---|---|
| Launch an app by activity | `adb shell am start -n <appPackage>/<appActivity>` |
| Launch an app by package (no activity needed) | `adb shell monkey -p <appPackage> -c android.intent.category.LAUNCHER 1` |
| Force stop an app | `adb shell am force-stop <appPackage>` |
| Open a URL | `adb shell am start -a android.intent.action.VIEW -d https://example.com` |

### Files, logs and screenshots

| Action | Command |
|---|---|
| Copy a file to the device | `adb push local/file /sdcard/` |
| Copy a file from the device | `adb pull /sdcard/file local/path` |
| Take a screenshot | `adb shell screencap -p /sdcard/screen.png` then `adb pull /sdcard/screen.png` |
| Record the screen | `adb shell screenrecord /sdcard/video.mp4` |
| View logs | `adb logcat` |
| Clear logs | `adb logcat -c` |
| Filter logs by tag/priority (errors only) | `adb logcat *:E` |
| Save logs to a file | `adb logcat -d > logcat.txt` |

### Input events

| Action | Command |
|---|---|
| Tap at coordinates | `adb shell input tap <x> <y>` |
| Swipe | `adb shell input swipe <x1> <y1> <x2> <y2> <duration_ms>` |
| Type text | `adb shell input text "hello"` |
| Press Back | `adb shell input keyevent 4` |
| Press Home | `adb shell input keyevent 3` |
| Press Enter | `adb shell input keyevent 66` |
| Wake / sleep screen (power button) | `adb shell input keyevent 26` |

### Appium capabilities tip

The values obtained above map directly to Appium capabilities:

```java
caps.setCapability("appPackage", "com.example.app");
caps.setCapability("appActivity", "com.example.app.MainActivity");
caps.setCapability("platformVersion", "13"); // from ro.build.version.release
caps.setCapability("udid", "emulator-5554"); // from adb devices
```
