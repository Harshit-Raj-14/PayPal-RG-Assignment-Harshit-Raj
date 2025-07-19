const express = require('express');
const morgan = require('morgan');
const bodyParser = require('body-parser');

const routes = require('./routes');

const app = express();

app.use(morgan('dev'));
app.use(bodyParser.json());

app.use('/', routes); // now routes is a Router, so this works

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
