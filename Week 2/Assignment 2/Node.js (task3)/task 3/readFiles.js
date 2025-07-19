const fs = require('fs').promises;
const path = require('path');

async function displayTransactions() {
  try {
    // TODO: Read 'transactions.json' file using fs.readFile or fs.readFile with async/await
    const filePath = path.join(__dirname, 'data', 'transactions.json');

    // Read 'transactions.json' file using fs.readFile with async/await
    const data = await fs.readFile(filePath, 'utf-8');

    // Parse the JSON data
    const transactions = JSON.parse(data);

    // Display the transactions
    console.log('Transactions:', transactions);
   
  } catch (error) {
    // TODO: Handle errors that occur during file reading or JSON parsing
    // Handle errors that occur during file reading or JSON parsing
    console.error('Error reading or parsing transactions.json:', error.message);
  }
}

displayTransactions();
