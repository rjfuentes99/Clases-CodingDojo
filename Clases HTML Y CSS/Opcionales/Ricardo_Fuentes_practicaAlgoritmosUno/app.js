// Primer Ejercicio 

for(var i=0; i<5;i++){   
    console.log(i);
 }  // Respuesta imprime 0,1,2,3,4


// Segundo Ejercicio 

for(var i=0; i<5; i++)
{
   i = i + 1;  
   console.log(i);
} // Respuesta imprime 1,3,5


 // Tercer Ejercicio 

 for(var i=0; i<5; i++)
{
   i = i + 3; 
   console.log(i);
} // Respuesta imprime 3,7


// Cuarto Ejercicio

function y(num1, num2){   
    return num1+num2;
 }
 console.log(y(2,3)) 
 console.log(y(3,5)) // Respuesta imprime 5, 8

// Quinto ejercicio

function y(num1, num2){
    console.log(num1);   
    return num1+num2;
 }  
 console.log(y(2,3)) 
 console.log(y(3,5)) // Respuesta imprime 2, 3, 5, 8
 
 // Sexto ejercicio

 a = 15;
 console.log(a);
 function y(a){
    console.log(a);   
    return a;
 }
 b = y(10);
 console.log(b); // Respuesta imprime 15 ,15 ,10 , 10, 10 

 
 // Septimo ejercicio

 a = 15;
console.log(a);
function y(a){
   console.log(a);   
   return a*2;
}
b = y(10);
console.log(b); // Respuesta imprime 15 ,15 ,10 , 20, 20
