function tellTime (HOUR, MINUTE, PERIOD) {
    var periodPrint, hourRelation = "";
    if (HOUR === 12 && MINUTE === 0 && PERIOD === "AM") {
        console.log("It's midnight.");
    }
    else if (HOUR === 12 && MINUTE === 0 && PERIOD === "PM") {
        console.log("It's noon.");
    }
    else {
        if (MINUTE === 30) {
            hourRelation = "half past ";
        }
        if (MINUTE > 30) {
            hourRelation = "almost ";
            HOUR += 1;
        }
        else if (MINUTE === 45) {
            hourRelation = "quarter to ";
        }
        else if (MINUTE === 55) {
            hourRelation = "five to ";
        }
        if (MINUTE < 30) {
            hourRelation = "just after ";
        }
        else if (MINUTE === 15) {
            hourRelation = "quarter after ";
            }
        else if (MINUTE === 5) {
            hourRelation = "five after "
            }
        if (MINUTE === 0) {
            hourRelation = "exactly ";
        }
        if (PERIOD === "AM") {
            periodPrint = " in the morning.";
        }
        else if ((PERIOD === "PM" && HOUR >=7 ) || (PERIOD === "AM" && HOUR <= 4)) {
            periodPrint = " at night."
        }
        else if (PERIOD === "PM" && HOUR < 7) {
            periodPrint = " in the afternoon."
        }
        console.log("It's ", hourRelation, HOUR, periodPrint);
    }
}
