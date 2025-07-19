const txnService = require('../services');

async function getTransactions(req, res) {
    try {
        const val = await txnService.getTransactions();
        return res.json(val);
    } catch (err) {
        console.error('Error fetching transactions:', err);
        res.status(500).json({ error: 'Internal Server Error' });
    }
}

async function getSingleTransaction(req, res) {
    try {
        const id = req.params.id;
        const txn = await txnService.getTransactions(id);

        if (!txn) {
            return res.status(404).json({ error: 'Transaction not found' });
        }

        return res.json(txn);
    } catch (err) {
        console.error('Error fetching transaction by ID:', err);
        res.status(500).json({ error: 'Internal Server Error' });
    }
}

async function createTransaction(req, res) {
    try {
        const details = req.body;
        const newId = await txnService.createTransaction(details);
        return res.status(201).json(newId);
    } catch (err) {
        console.error('Error creating transaction:', err);
        res.status(500).json({ error: 'Internal Server Error' });
    }
}

module.exports = { getTransactions, getSingleTransaction, createTransaction };
