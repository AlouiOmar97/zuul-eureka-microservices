const { Router } = require("express");


const paymentRoute = require("./payment");
const order = require("./order");

module.exports = (app) => {
  const router = Router();
  router.use("/payment", paymentRoute);
  router.use("/order", order);

  app.use("/api", router);
};
