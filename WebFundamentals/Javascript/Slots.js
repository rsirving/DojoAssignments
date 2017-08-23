function slots (quarters, target=0) {
    var outcome = 0;
    for (var i = quarters; i > 0; i--) {
        quarters--;
        outcome = Math.floor(Math.random()*100)+1;
        if (outcome === 1) {
            quarters += Math.floor(Math.random()*50)+51;
            if (quarters >= target) {
                break;
            }
        }
    } return quarters;
}