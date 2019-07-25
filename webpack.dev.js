const merge = require('webpack-merge');
const common = require('./webpack.common.js');

module.exports = merge(common, {
    mode: 'development',
    devtool: 'source-map',
    devServer: {
        contentBase: './dist',
        compress: true,
        port: 8001,
        host:'10.10.12.232',
        progress:true,
        allowedHosts: [
            '10.10.12.232:9001'
        ],
        stats: 'normal',
        clientLogLevel: 'error',
    }
});
