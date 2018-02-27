/**
 * Created by SPIQA4 on 7/15/2016.
 */
exports.config = {
    seleniumAddress: 'http://localhost:4723/wd/hub',
    specs: ['example_spec.js'],

    capabilities: {
        browserName: 'chrome',
        platformName: 'android',
        //platformVersion: '',
        deviceName: ''
    }
};