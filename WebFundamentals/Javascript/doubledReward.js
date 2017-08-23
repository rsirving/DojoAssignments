function doubled(days) {
    var cash = .01;
    var hitTenK = false;
    var hitOneB = false;
    for (var i = 1; i <= days; i++) {
        cash *= 2;
        if (cash >= 10000 && hitTenK == false) {
            console.log("After ", i, " days, the reward would hit ten thousand dollars.");
            hitTenK = true;
        }
        if (cash >= 1000000000 && hitOneB == false) {
            console.log("After ", i, " days, the reward would hit one billion dollars.")
            hitOneB = true;
        }
    }
    console.log("After ", days, " days, the reward would be $", cash);
}
