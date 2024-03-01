const exec = require('cordova/exec')

module.exports = {
    getPackageVersion(resolve, reject) {
        exec(resolve, reject, 'PackageInfoPlugin', 'getPackageVersion', [])
    }
}
