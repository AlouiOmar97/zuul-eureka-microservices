const paypal = require("paypal-rest-sdk");
const orders = require("../../models/order");
const dateReaction = require("../../lib/date");
const jwt = require("jsonwebtoken");

async function getOrdersByUserId(req, res) {
  /*  var decoded = jwt.verify(
     req.headers["authorization"],
     process.env.SECRET_KEY
   ); */
  let order = await orders.findItemsByUserId(req.params.id);
  if (order) {
    res.json(order);
  } else {
    res.json({ error: "Order does not exist" });
  }
}

async function addOrder(req, res) {
  /*  var decoded = jwt.verify(
     req.headers["authorization"],
     process.env.SECRET_KEY
   ); */
  const orderInfo = {
    reference: "56436485",
    total: 12,
    user_id: 1,
    product_id: 1,
    date_creation: dateReaction.getDate(),
  };
  console.log(req.body);
  let order = await orders.insertOne(req.body);
  if (order) {
    res.json(order);
  } else {
    res.json({ error: "Order does not exist" });
  }
}

async function getOrders(req, res) {

  let order = await orders.findAllOrder();
  if (order) {
    res.json(order);
  } else {
    res.json({ error: "Order does not exist" });
  }

}

async function cancel(req, res) {
  res.redirect("http://localhost:4200");
}

async function deleteOrder(req, res) {
  var decoded = jwt.verify(
    req.headers["authorization"],
    process.env.SECRET_KEY
  );
  console.log("delete");
  let order = await orders.findOrderbyId(req.params.id);
  if (order) {
    console.log("order user id");
    console.log(order.user_id);
    console.log("decoded user id");
    console.log(decoded._id);
    if (decoded.role === "admin" || decoded._id == order.user_id) {
      orders.deleteOrder(req.params.id);
      res.send("order deleted successfully");
    } else {
      res.send("order not deleted you need admin privilege");
    }
  } else {
    res.send("Order does not exist");
  }
}
module.exports = {
  getOrdersByUserId,
  cancel,
  deleteOrder,
  getOrders,
  addOrder,
};
