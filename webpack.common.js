const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
require("babel-polyfill");

module.exports = {
    // entry: ['babel-polyfill',path.resolve(__dirname, 'src/main.js')],
    // entry: ['babel-polyfill',path.join(__dirname, 'src', 'main', 'resources', 'js','src', 'main.js')],
    entry:[
        'babel-polyfill',
        './src/main/resources/js/main.js'
    ],
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
        ]
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
