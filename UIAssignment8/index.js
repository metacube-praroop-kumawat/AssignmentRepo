const express = require('express');

const app = express();

const PORT = 3000;

app.listen(PORT, ()=>{
    console.log(`Server running on port : ${PORT}`);
})

app.get("/", (req, res)=>{
    res.send("<h2>Hey, Praroop.</h2>");
})