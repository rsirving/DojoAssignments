import React from 'react';
import ReactDOM from 'react-dom';
const myButton = React.createElement('button', null, 'Click Me!');
console.log(JSON.stringify(myButton));
console.log(ReactDOM);
document.querySelector('#app', function(element){
    console.log(element);
});
// console.log(element);
ReactDOM.render(myButton, document.querySelector('#app'));