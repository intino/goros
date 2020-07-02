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

    },
    output: {
        path: "/Users/mcaballero/Proyectos/goros/out/production/goros-elements/www/goros-elements",
        publicPath: '$basePath/goros-elements/',
        filename: "[name].js"
    },
    resolve: {
        alias: {
            "app-elements": path.resolve(__dirname, '.'),
            "goros-elements": path.resolve(__dirname, '.')
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

    ]
};