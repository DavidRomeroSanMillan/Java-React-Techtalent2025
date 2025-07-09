import React from "react";
import ReactDOM from "react-dom/client";
import Inicio from "./inicio";
import Header from "./Header";
import MapView from "./MapView";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <Header />
    <Inicio />
    <MapView />
  </React.StrictMode>
);
