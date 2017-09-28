var arr = [1, 2, 3, 4, 5];
var map = arr.map(function (x) {
    return x * 2;
    // [2, 4, 6, 8, 10]
});



var arr_1 = [1,2,3,4,5];
var condition = function(x) {
    return x % 2 === 0;
}
var ex = function(array, cond) {
    return array.filter(cond);
    // [2, 4]
};



var sum = 0;
function add(sum, count) {
    sum += count;

    if(count > 0) {
        return add(sum, count - 1);
    }else{
        return sum;
    }
    // 55
}



var arr_2 = [1, 2, 3, 4, 5];
var count = 0;
var reduceSum = arr_2.reduce(function(pre, value) {
    count += 1;
    return pre+ value;
    /* 
        reduce 메소드를 사용할 때 initialValue 를 설정해주지 않으면
        1,  2
        3,  3
        6,  4
        10, 5

        이런 식으로 작동한다.
    */
    // 15, 4
});
count = 0;
var reduceSum_1 = arr_2.reduce(function(pre, value) {
    count += 1;
    return pre+ value;
    /* 
        reduce 메소드를 사용할 때 initialValue 를 설정해주면
        0,  1
        1,  2
        3,  3
        6,  4
        10, 5  
        이런 식으로 작동한다.
    */
    // 15, 5
}, 0);

console.log(reduceSum_1, count);