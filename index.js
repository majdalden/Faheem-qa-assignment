// Driver
const wdio = require("webdriverio")
const EC = require('wdio-wait-for');

const opts = {
    path: '/wd/hub',
    port: 4723,
    capabilities: {
        platformName: "Android",
        platformVersion: "10",
        deviceName: "Android Emulator",
        app: "/Volumes/MyFiles/MyProjects/MyJavaScriptProjects/qa-assignment/application.apk",
        automationName: "UiAutomator2"
    }
};

async function main() {
    const client = await wdio.remote(opts);
    // Write your test code here

    client.waitUntil(EC.elementToBeClickable(client.$("//android.widget.TextView[@text='تصفح كزائر']").click()), { timeout: 5000, timeoutMsg: 'Failed, after waiting for the تصفح كزائر elements' })
    client.waitUntil(EC.elementToBeClickable(client.$("//android.widget.TextView[@text='ثالث ابتدائي']").click()), { timeout: 5000, timeoutMsg: 'Failed, after waiting for the ثالث ابتدائي elements' })

    // await client.quit();
}

main();

