const express = require('express');
const router = express.Router();
const { getTransactions, getSingleTransaction, createTransaction } = require('./controllers');

router.get("/transactions", getTransactions);
router.get("/transactions/:id", getSingleTransaction);
router.post("/transactions", createTransaction);

module.exports = router;
