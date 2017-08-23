function onlyNumbers (arr) {
    var newArr = [];
    for (var i = 0; i < arr.length; i++) {
        if (typeof arr[i] === "number") {
            newArr.push(arr[i]);
        }
    } return newArr;
}

function removeNumbers (arr) {
    var temp;
    len = arr.length;
    for (var i = 0; i < len; i++) {
        temp = arr.shift();
        if (typeof temp === "number") {
            continue;
        } else (arr.push(temp));
    } return arr;
}