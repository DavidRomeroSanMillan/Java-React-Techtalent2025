import "./CSS/header.css";

const Header = () => {
  return (
    <>
      <h1 className="header">Esto es un header</h1>
      <nav className="navegacion">
        <a href="inicio.jsx" >
          Inicio
        </a>
        <a href="sobre.jsx">
          Sobre Komuni
        </a>

        <a href="inicio.jsx">
          Nuestra misión
        </a>
      </nav>
    </>
  );
};
export default Header;
