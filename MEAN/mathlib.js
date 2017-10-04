module.exports = {
    add: function(one, two){
        return one + two;
    },
    multiply: function(one, two){
        return one * two;
    },
    square: function(one){
        return one * one;
    },
    random: function(one, two){
        return Math.floor((Math.random()*(two-one)+one))
    }
}