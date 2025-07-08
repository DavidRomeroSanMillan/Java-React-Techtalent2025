import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import SegundoComponente from "./SegundoComponente";
import Header from "./Header";
import Footer from "./Footer";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <Header />
    <App />
    <SegundoComponente />
    <Footer />
  </React.StrictMode>
);
