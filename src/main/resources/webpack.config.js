const path = require('path');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

module.exports = {
  output: {
    path: path.resolve(__dirname, 'static/dist'),
  },
  plugins: [new MiniCssExtractPlugin({
    filename: 'styles.css',
  })],
  module: {
    rules: [
      {
        test: /\.(png|jpe?g|gif)$/i,
        use: [{ loader: 'file-loader' }]
      },
      {
        test: /\.css$/i,
        exclude: /node_modules/,
        use: [MiniCssExtractPlugin.loader, 'css-loader'],
      },
      {
        test: /\.m?js$/,
        exclude: /(node_modules)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env','@babel/preset-react']
          }
        }
      }
    ],
  },
};
