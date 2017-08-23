function printRange(start, end, skip = 1) {
    for (var i = start; i < end; i += skip) {
        if (skip <= 0) {
            break;
        }
        console.log(i);
    }
}