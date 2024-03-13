const entries = {
    main: './src/pages/main/index.tsx',
    article: './src/pages/article/index.tsx',
    signUp: './src/pages/sign/up/index.tsx',
    signIn: './src/pages/sign/in/index.tsx',
    signOut: './src/pages/sign/out/index.tsx',
}

module.exports = [{
    entry: entries,
    output: {
      path: __dirname + "/../resources/static/js/",
      filename: '../js/[name]/index.js',
    },
    module: {
        rules: [
            { 
                test: /\.css$/,
                use: ["style-loader", "css-loader"],
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
  },{
    entry: './src/css/style.css',
    output: {
      path: __dirname + "/../resources/static/css/",
      filename: 'style.css',
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ["style-loader", "css-loader"],
            },
        ],
      },
      resolve: {
        extensions: ['.css']
        }
  }];