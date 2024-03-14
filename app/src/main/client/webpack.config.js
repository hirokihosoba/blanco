// import MiniCssExtractPlugin from 'mini-css-extract-plugin';
// import TerserPlugin from 'terser-webpack-plugin';
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const TerserPlugin = require('terser-webpack-plugin')
const path = require('path')
const glob = require('glob')
const basePath = path.resolve(__dirname)
const resources = path.resolve(basePath, '../resources')

const tsxPath = `${basePath}/src/pages`
const tsxTargets = glob.sync('**/index.tsx', {
  cwd: tsxPath
})
const tsEntries = {}
const jsEntries = {}
const cssEntries = {}

//tsx
tsxTargets.forEach((value) => {
  const fliePath = `${path.dirname(value)}/${path.basename(
    value,
    path.extname(value)
  )}`
  const key = `/js/pages/${fliePath}`
  tsEntries[key] = `./src/pages/${fliePath}.tsx`
})

//js
const jsPath = `${basePath}/src`
const jsTargets = glob.sync('**/*.js', {
  cwd: jsPath
})
jsTargets.forEach((value) => {
  const key = `/js/${path.dirname(value)}/${path.basename(
    value,
    path.extname(value)
  )}`
  jsEntries[key] = `./src/${value}`
})

//css
const cssPath = `${basePath}/src/static/style`
const cssTargets = glob.sync('**/style.css', {
  cwd: cssPath
})
cssTargets.forEach((value) => {
  const dirName = path.dirname(value) === '.' ? '' : `${path.dirname(value)}/`;
  const filePath = dirName + path.basename(value, path.extname(value));
  const key = `/css/${filePath}`;
  tsEntries[key] = `./src/static/style/${filePath}.css`
})
  
module.exports = [{
    entry: tsEntries,
    output: {
      path: path.resolve(resources, 'static'),
      filename: '[name].js',
    },
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                exclude: [/node_modules/, /\.(sa|sc|c)ss?$/],
                use: {
                    loader: "ts-loader"
                }
            },
            { 
              test: /\.js$/,
              exclude: [/node_modules/, /\.(sa|sc|c)ss?$/],
              use: ["bable-loader"],
          },
          { 
            test: /\.css$/,
            exclude: [/node_modules/, /\.(j|t|)s[x]?$/],
            use: [MiniCssExtractPlugin.loader,'css-loader']
        },
        ],
    },
    resolve: {
      extensions: ['.js', '.ts', '.tsx']
    },
    optimization: {
      minimizer: [
        new TerserPlugin({
          extractComments: false
        })]
    },
    plugins: [
      new MiniCssExtractPlugin({
        filename: '[name].css'
      })
    ]
  
  }];
  