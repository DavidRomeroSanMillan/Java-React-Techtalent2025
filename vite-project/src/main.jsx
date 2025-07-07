console.log("Hola Mundo");

// Template Strings

const nombre2 = "David";
const apellido = "Romero";

// const nombreCompleto = nombre + ' ' + apellido;
const nombreCompleto = `${nombre2} ${apellido}`;

console.log(nombreCompleto);

function getSaludo(nombre2) {
  return "Hola " + nombre2;
}

console.log(`Este es un texto: ${getSaludo(nombre2)}  `);

// Funciones en JS

//Función normal
function sumar(a, b) {
  return a + b;
}
console.log(sumar(3, 5));
// Función de flecha
const saludar1 = (nombre2) => {
  return `Hola, ${nombre2}`;
};
console.log(saludar1("David"));
// Función de flecha simplificada
const saludar2 = (nombre2, apellido) => `Hola, ${nombre2} ${apellido}`;
console.log(saludar2("David", "Romero"));
// Función de flecha sin parámetros con retorno implícito
const saludar3 = () => `Hola Mundo`;

// Función de flecha simplificada con un solo parámetro
// const saludar = nombre => `Hola, ${ nombre }`;

// console.log( saludar('Marc') )

console.log(saludar2("Pedro", "Jiménez"));
console.log(saludar3("Andreu"));

const getUser = () => ({
  uid: "ABC123",
  username: "David",
});

const user = getUser();
console.log(user);

//DESESTRUCTURACIÓN
const persona = {
  nombre: "Peter",
  edad: 18,
  clave: "Spiderman",
};

// Desestructuración del objeto persona
const { nombre, edad, clave } = persona;

console.log(nombre); // 'Peter'
console.log(edad); // 18
console.log(clave); // 'Spiderman'

const usarContexto = ({ clave, nombre, edad, rango = "Vecino amigable" }) => {
  // Aquí podrías hacer cualquier lógica adicional
  return {
    nombreClave: clave,
    anys: edad,
    latlng: {
      lat: 40.7128, // Coordenadas de Nueva York 🗽
      lng: -74.006,
    },
  };
};

// Desestructuración al llamar la función
const {
  nombreClave,
  anys,
  latlng: { lat, lng },
} = usarContexto(persona);

console.log(nombreClave, anys); // 'Spiderman', 18
console.log(lat, lng); // 40.7128, -74.0060

// DESETR. DE ARRAYS
// Lista de personajes de Spiderman
const personajes = ["Peter Parker", "Miles Morales", "Gwen Stacy"];

// Queremos el tercer personaje
const [personaje1] = personajes;
const [, personaje2] = personajes;
const [, , personaje3] = personajes;
//Equivalente a const[personaje1, personaje2, personaje3] = personajes;
console.log(personaje3); // Gwen Stacy
console.log(personaje1); // Peter Parker
console.log(personaje2); // Miles Morales

// Una función que retorna un array con información
const retornaSpideyInfo = () => {
  return ["Spidey", 2002];
};

const [alias, anyAparicion] = retornaSpideyInfo();
console.log(alias, anyAparicion); // Spidey 2002

//Un hook* en React es una función que permite usar el "estado"
// y otras características de React sin escribir una clase.

// Simulación de un hook* tipo useState (como en React)
const useSpiderState = (valor) => {
  return [
    valor,
    () => {
      console.log(`Lanzando telaraña desde ${valor}`);
    },
  ];
};

// Desestructuración del array retornado
const [spiderNombre, lanzarTelaraña] = useSpiderState("Peter Parker");

console.log(spiderNombre); // Peter Parker
lanzarTelaraña(); // Lanzando telaraña desde Peter Parker

const apiKey = "WMwSO8ODFND2mewaJR7jWiGWFJtDq1xw";
const peticion = fetch(`http://api.giphy.com/v1/gifs/random?api_key=${apiKey}`);

peticion
  .then((resp) => resp.json())
  .then(({ data }) => {
    // Desestructuramos el objeto data para obtener la información del GIF ya que es "data.data"
    const { url } = data.images.original;
    //Primero creo la imagen con la url de Giphy
    const img = document.createElement("img");
    img.src = url;
    // Luego la añado al body del documento
    document.body.append(img);
  })
  .catch(console.warn);

const getImagen = async () => {
  try {
    const apiKey = "WMwSO8ODFND2mewaJR7jWiGWFJtDq1xw";
    const resp = await fetch(
      `http://api.giphy.com/v1/gifs/random?api_key=${apiKey}`
    );
    const { data } = await resp.json();
    const { url } = data.images.original;
    const img = document.createElement("img");
    img.src = url;
    document.body.append(img);
  } catch (error) {
    console.error(error);
  }
};
getImagen();
