function Product(name, price) {
    this.name = name;
    this.price = price;
}


var otherObj = {};
otherObj.name = "aa";
otherObj.price = 5;

function Food(name, price) {
    Product.call(otherObj, name, price);
    this.name = "Food";         // 여기서 this 는 Food 를 가리킴
    console.log(otherObj);      // otherObj 의 name 과 price 가 Food 함수의 인자로 변경
    console.log("this(Food) 값 : " + this.name);     // Food 의 name 을 출력
}

function Toy(name, price) {
    Product.call(this, name, price);
    this.name = "asdasd";       // 여기서 this 는 Toy 를 가리킴
    console.log(this);          // Toy 의 인자로 robot 을 넣어줬지만 this.name 으로 인해 asdasd 로 변경
}

var cheese = new Food('feta', 5);
var fun = new Toy('robot', 40);