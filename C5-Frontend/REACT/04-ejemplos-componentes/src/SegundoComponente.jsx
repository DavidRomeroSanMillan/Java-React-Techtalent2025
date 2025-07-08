// import { Fragment } from "react";
const nombre = "David";
const nuevoMensaje = {
  mensaje: "Hola de nuevo",
  nombre: "Aaaa",
};
const booleano = true;

const SegundoComponente = () => {
  return (
    <>
      <div>Segundo componente</div>
      <p>Párrafo</p>
      <p>
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur
        officia, delectus qui labore cumque dolores. Fugiat deleniti et dolore
        iste, tempore eligendi, sed eum, culpa tenetur illo officiis quia!
        Provident.
      </p>
      <p>{1 + 2}</p>
      <p>{nombre}</p>
      <p>{nuevoMensaje.mensaje}</p>
      <p>{booleano}</p>
      <code>{JSON.stringify(nuevoMensaje)}</code>
      <br />
    </>
  );
};

export default SegundoComponente;
