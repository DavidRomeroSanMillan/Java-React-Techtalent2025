let str1 = "JavaScript es increíble";
function length() {
  console.log("Length: ", str1.length);
}

function slice() {
  let sliced = str1.slice(14, 23);
  console.log("Slice: ", sliced);
}

function sub() {
  let subs = str1.substring(0, 10);
  console.log("Substring: ", subs);
}

let str2 = " Bienvenido a la programación ";
function trim() {
    let trimmed = str2.trim();
    console.log("Trim: ", trimmed);
}

function upper(){
    let upperC = str2.toUpperCase();
    console.log("UpperCase: ", upperC);
}

function replace(){
    let replaced = str2.replace("la programación", "JavaScript");
    console.log("Replace: ", replaced);
}
function conc(){
    let replaced = str2.replace("la programación", "JavaScript");
    let concat = str2.concat(" en 2024!");
    console.log("Concatenate: ", concat);
}

let str3 = "Aprender JavaScript es divertido";
function char(){
    console.log("Char 8: ", str3.charAt(10));
}
function codeAt(){
    console.log("CodeAt: ", str3.charCodeAt(10));
}
function splits(){
    let split = str3.split(" ");
    console.log("Split: ", split);
}
function padding(){
    let pad = str3.padEnd(40, "!");
    console.log("Padding: ", pad);
}

length();
slice();
sub();
trim();
upper();
replace();
conc();
char();
codeAt();
splits();
padding();