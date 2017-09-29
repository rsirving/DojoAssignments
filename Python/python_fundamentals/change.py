def change(cents):
    coins = {}
    dollars = cents // 100
    cents %= 100
    quarters = cents // 25
    cents %= 25
    dimes = cents // 10
    cents %= 10
    nickels = cents // 5
    cents %= 5
    pennies = cents // 1
    coins = {
        'dollars': dollars,
        'quarters': quarters,
        'dimes': dimes,
        'nickels': nickels,
        'pennies': pennies
        }
    return coins