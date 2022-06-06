// Driver
const wdio = require("webdriverio")

const opts = {
    path: '/wd/hub',
    port: 4723,
    capabilities: {
        platformName: "Android",
        platformVersion: "12",
        deviceName: "Android Emulator",
        app: "<APK_DIRECTORY>/application.apk",
        automationName: "UiAutomator2"
    }
};

async function main() {
    const client = await wdio.remote(opts);
    // Write your test code here

}

main();

