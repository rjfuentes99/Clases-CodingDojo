// Primer Ejercicio
function multiply(x,y) {
    console.log(x);
    console.log(y);
}
b = multiply(2,3);
console.log(b); // resultado 2,3 undefined

/*
 var  valor
  x     2
  y     3
  b     undefined
*/
// segundo ejercicio 
function multiply(x,y) {
    console.log(x);
    console.log(y);
}
b = multiply(2,3);
console.log(b); // resultado 6 , 10
/*
var valor
b    6
x    2 > 5
y    3 > 2
imp  6 > 10

*/

// tercer ejercicio

var x = [1,2,3,4,5,10];
for(var i=0; i<5; i++) {
   i = i + 3; 
   console.log(i);
}

/*
var    valor
x     [1,2,3,4,5,10]
i     0 > 3 > 4
imp   3,7
*/

// cuarto ejercicio

var x=15;
console.log(x); // 15
function awesome(){
    var x=10;
    console.log(x); // 10
}
console.log(x); // 15
awesome();
console.log(x);

/*
var    valor
x      15 > 10
imp    15,15,10,15
*/

// quinto ejercicio

for(var i=0; i<15; i+=2) {
    console.log(i);
 } 
 /*
 var  valor
i     0>2>4>6>8>10>12>14
imp   0,2,4,6,8,10,12,14
 */

// sexto ejercicio
for(var i=0; i<3; i++) {
    for(var j=0; j<2; j++) {    
        console.log(i*j);
    }
}
 /*
 var  valor
i     0>1
y     0>1
imp   0,0,1,1
 */





//Print 1 to x

function printUpTo(x) {
    for( i = 0; i <= x; i++){
          if (i%2 == 0) {
              console.log(i)
      }
  }
  }
  printUpTo(1000); // debería imprimir todos los enteros de 1 to 1000
  y = printUpTo(-10); // debería imprimir false
  console.log(y); // debería imprimir false
  

//PrintSum

function printSum(x) {
    var sum = 0;
    for( i = 0; i <= x; i++){
        sum += i
        console.log(sum)
    }
    return sum
  }
  y = printSum(255) // debería imprimir todos los enteros de 0 a 255 y que cada entero imprima la suma parcial.
  console.log(y) // // debería imprimir 32640
  