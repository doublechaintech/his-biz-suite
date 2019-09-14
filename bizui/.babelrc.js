module.exports = {
  plugins: [

    ["@babel/plugin-proposal-decorators", { "legacy": true }],
    ["@babel/plugin-proposal-class-properties", { "loose" : true }],
    [
      'babel-plugin-module-resolver',
      {
        alias: {
          components: './src/components',
        },
      },
    ],
  ],
};
