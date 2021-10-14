const path = require("path");
const HtmlWebPackPlugin = require("html-webpack-plugin");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CircularDependencyPlugin = require('circular-dependency-plugin');

module.exports = {
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules\/(?!(alexandria-ui-elements)\/).*/,
                options: {
                    rootMode: "upward",
                    presets: ['@babel/preset-env'],
                    cacheDirectory: true
                },
                loader: "babel-loader"
            },
            {
                test: /\.html$/,
                loader: "html-loader"
            },
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            }
        ]
    },
    entry : {
        'gorosAppTemplate' : './gen/apps/GorosAppTemplate.js',
        'gorosInstallTemplate' : './gen/apps/GorosInstallTemplate.js'
    },
    output: {
        path: "/Users/mcaballero/Proyectos/goros/out/production/unit-elements/www/unit-elements",
        publicPath: '$basePath/unit-elements/',
        filename: "[name].js"
    },
    resolve: {
        alias: {
            "app-elements": path.resolve(__dirname, '.'),
            "unit-elements": path.resolve(__dirname, '.')
        }
    },
    plugins: [
        new CircularDependencyPlugin({
            failOnError: true,
            allowAsyncCycles: false,
            cwd: process.cwd(),
        }),
        new CopyWebpackPlugin([{
            from: 'res',
            to: './res'
        }]),
        new HtmlWebPackPlugin({
            hash: true,
            title: "Test UI",
            chunks: ['gorosAppTemplate'],
            template: "./src/gorosAppTemplate.html",
            filename: "./gorosAppTemplate.html"
        }),
        new HtmlWebPackPlugin({
            hash: true,
            title: "Test UI",
            chunks: ['gorosInstallTemplate'],
            template: "./src/gorosInstallTemplate.html",
            filename: "./gorosInstallTemplate.html"
        })
    ]
};