module.exports = {
    entry: './src/index.tsx',
    output: {
      path: __dirname + "/../resources/static/js",
      filename: 'index.js',
    },
    module: {
        rules: [
            // test = loaderを使う特定の拡張子を指定
            // use = testで指定した拡張子にloaderを使いwebpackが読み込めるようにする
            {
                test: /\.css$/,
                use: ["style-loader", "css-loader"],
                //↑公式docによると、上記2つのloaderを追加すればCSSが読めるらしい
            },
            {
                test: /\.tsx?$/,
                exclude: /node_modules/,
                use: {
                    loader: "ts-loader"
                }
            },
        ],
      },
      resolve: {
        extensions: ['.js', '.ts', '.tsx']
        }
  };