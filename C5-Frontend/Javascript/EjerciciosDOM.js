// let azulp = document.getElementsByTagName("p");
// for (let i = 0; i < azulp.length; i++) {
//   azulp[i].style.color = "blue";
// }

let imgcount = document.getElementsByTagName("img");
console.log("Número de img: ", imgcount.length);

// let cambiotxt = document.getElementsByTagName('button');
// for(let i= 0; i<cambiotxt.length; i++){
//     cambiotxt[i].textContent='¡Clic Aquí!';
// }

// let violetap = document.querySelectorAll("p");
// violetap.forEach((item) => {
//   item.style.color = "violet";
// });

let cuentaimg = document.querySelectorAll("img");
console.log("Número de imágenes SelectorAll: ", cuentaimg.length);

// let btntxt = document.querySelectorAll("button");
// btntxt.forEach((item) => {
//   item.textContent = "¡Clic aquí!";
// });

let classp = document.getElementsByClassName("destacado");
for (let i = 0; i < classp.length; i++) {
  classp[i].style.color = "green";
}

let tamh2 = document.getElementsByClassName("titulo");
for (let i = 0; i < tamh2.length; i++) {
  tamh2[i].style.fontSize = "55px";
}

let ocultdiv = document.getElementsByClassName("ocultar");
for (let i = 0; i < ocultdiv.length; i++) {
  ocultdiv[i].style.display = "none";
}

function mostrarGenero() {
  let radioname = document.getElementsByName("genero");
  for (let i = 0; i < radioname.length; i++) {
    if (radioname[i].checked) {
      document.getElementById("resultado1").innerHTML =
        "Has seleccionado el género: " + radioname[i].value;
    }
  }
}

function contarLenguajes() {
  let contador = 0;
  let lenguajes = document.getElementsByName("lenguajes");
  for (let i = 0; i < lenguajes.length; i++) {
    if (lenguajes[i].checked) {
      contador++;
    }
  }
  document.getElementById("resultado2").innerHTML =
    "Has seleccionado " + contador + " lenguajes.";
}

function sumarNotas() {
  let sumaTotal = 0;
  let sumar = document.getElementsByName("nota");
  for (let i = 0; i < sumar.length; i++) {
    sumaTotal += Number(sumar[i].value);
  }
  document.getElementById("resultado3").innerHTML =
  "La suma total es " + sumaTotal;

}
