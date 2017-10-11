var myNum: number = 5;
var myString: string = "Hello Universe";
var myArr: number[] = [1,2,3,4];
var myObj: {} = { name:'Bill'};
var anythingVariable: any = "Hey";
var anythingVariable: any = 25; 
var arrayOne: boolean[] = [true, false, true, true]; 
var arrayTwo: any[] = [1, 'abc', true, 2];
var myObj: {} = { x: 5, y: 10 };
// object constructor
class MyNode {
    val: number;
    _priv: number;

    constructor(valueP: number){
        this.val = valueP;
    }
    doSomething(){
        this._priv = 10;
    }
}
let myNodeInstance = new MyNode(1);
console.log(myNodeInstance.val);

function myFunction(): void{
    console.log("Hello World");
    return;
}

function sendingErrors(): void{
    throw new Error('Error message');
}