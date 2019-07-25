const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
require("babel-polyfill");

module.exports = {
    //mode: 'development',
    mode: 'production',
    devtool: 'source-map',
    // entry: ['babel-polyfill', path.join(__dirname, 'src', 'main', 'resources', 'js','src','main.js')],
    entry:[
        'babel-polyfill',
        './src/main/resources/js/main.js'
    ],
    devServer: {
        contentBase: './dist',
        compress: true,
        port: 8001,
        allowedHosts: [
            '10.10.12.232:9001'
        ],
        host:'10.10.12.232:9001'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.css$/,
                use: [
                    'vue-style-loader',
                    'css-loader'
                ]
            }
        ],
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    resolve: {
        modules: [
            path.join(__dirname, 'src', 'main', 'resources', 'js'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}
