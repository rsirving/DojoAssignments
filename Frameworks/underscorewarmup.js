var myState = {
    name: "Washington",
    capital: "Olympia",
    population: 7062000,
    nickname: "The Evergreen State"
   };
var businesses = [
    {
     name: "Coding Dojo",
     city:  "Bellevue"
    },
    {
     name: "Facebook",
     city: "Mountain View"
    },
    {
     name: "Microsoft",
     city: "Redmond"
    },
    {
     name: "Expedia",
     city: "Bellevue"
    }
   ];
// 1.
let keyArray = _.keys(myState);
let valArray = _.values(myState);
// 2.
let newState = _.object(keyArray, valArray);
// 3.
_.each(myState, alert);
// 4.
_.pluck(businesses, 'name');
// 5.
_.find(businesses, function(obj) { return obj.name = 'Microsoft';});
// 6.
let bellevueArr = _.where(businesses, {city: "Bellevue"});
// 7.
let sortArr = _.sortBy(businesses, 'city');
// 8.
let dojoArr = _.map(businesses, _.mapObject({key: value}, function(key, value) { if (key === 'name') { value = "Coding Dojo"}; return {key: value};}));