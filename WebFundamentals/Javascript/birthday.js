function countDown (days) {
    var message = "";
    for (var i = days; i > 0; i--) {
        if (i > 30) {
            message = " days until my birthday. Ugh, that's so far away.";
        } if (i <= 30) {
            message = " days until my birthday. Oh man, it's getting close.";
        } if (i <= 5) {
            message = " DAYS UNTIL MY BIRTHDAY!";
        } if (i === 1) {
            message = " DAY UNTIL MY BIRTHDAY!!!";
        }
        console.log(i, message);
        }
    }
    console.log("Hooray, it's my birthday. Yay.");
}