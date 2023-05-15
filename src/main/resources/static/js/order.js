/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
let vegetableList ;
let cart = [];
fetch('http://localhost:8080/restvegetable')
        .then(response => response.json())
        .then(data => vegetableList = data)
