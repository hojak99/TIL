function test(x, callback) {
    setTimeout(callback, 100, x*x);
}

var number = 0;
test(2, function(x) {
    number = x;
});

console.log(number);