var createError = require("http-errors");
const http = require("http");
var express = require("express");
const co = require("co");
const PORT = process.env.NODE_DOCKER_PORT || 3200;
var path = require("path");
var cookieParser = require("cookie-parser");
const eurekaHelper = require("./eureka-helper.js")
//var logger = require("chpr-logger");
const { configure } = require("./config/express");
require("dotenv").config();

var mongoose = require("mongoose");
const { port } = require("./config");
require("mongoose-paginate-v2");
const DBUSER = (process.env.DB_USER || 'root');
const DBPASSWORD = (process.env.DB_PASSWORD || 'root');
const DBHOST = (process.env.DB_HOST || 'localhost');
const DBPORT = (process.env.DB_PORT || '27017');
const DBNAME = (process.env.DB_NAME || 'store');
/* const url =
  "mongodb+srv://root:root@cluster0.o6bqt.mongodb.net/PiDev?retryWrites=true&w=majority"; *//* 
const url =
"mongodb://" + DBUSER + ":" + DBPASSWORD + "@" + DBHOST + ":" + DBPORT + "/" + DBNAME + "?retryWrites=true&w=majority&authSource=admin&&ssl=false`"; */
const url = "mongodb://localhost:27017/store";
let app;
let server;

mongoose.connect(url, { useNewUrlParser: true, useUnifiedTopology: true });

const mongo = mongoose.connection;

mongo.on("connected", () => {
  console.log("initialisation");
});
mongo.on("open", () => {
  console.log("connexion etablie");
  console.log(PORT);
});

mongo.on("error", (err) => {
  console.log(err);
});

/**
 * Start the web app.
 *
 * @returns {Promise} when app end to start
 */
async function start() {
  if (app) {
    return app;
  }
  //logger.info("Express web server creation");
  app = configure(express());
  server = http.createServer(app);

  eurekaHelper.registerWithEureka("payments", 3200);
  if (process.env.NODE_ENV == "production") {
    app.use(express.static('client/build'));
    const path = require('path');
    app.get("*", (req, res) => {
      res.sendFile(path.resolve(__dirname, 'client', 'build', 'index.html'))
    })
  }
  await server.listen(PORT);

  //logger.info(
  //{
  //  port: server.address().port,
  //  environment: process.env.NODE_ENV,
  // },
  // "✔ Server running"
  //);

  return app;
}

/**
 * Stop the web app.
 *
 * @returns {Promise} when app end to start
 */
async function stop() {
  if (server) {
    await server.close();
    server = null;
    app = null;
  }
  await mongoose.disconnect();
  return Promise.resolve();
}

if (!module.parent) {
  co(start);
}

module.exports = {
  start,
  stop,
  get server() {
    return server;
  },
  get app() {
    return app;
  },
};
