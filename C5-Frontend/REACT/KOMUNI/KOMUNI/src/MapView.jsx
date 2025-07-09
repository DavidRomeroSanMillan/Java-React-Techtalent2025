import React, { useState } from "react";
import "leaflet/dist/leaflet.css";
import { MapContainer, TileLayer, Marker, Popup, useMapEvents } from "react-leaflet";

const AddMarker = ({ onAdd }) => {
  useMapEvents({
    click(e) {
      onAdd(e.latlng);
    },
  });
  return null;
};

const MapView = () => {
  const [markers, setMarkers] = useState([
  
  ]);
  const [selectedMarker, setSelectedMarker] = useState(null);

  // Handle adding a marker
  const handleAddMarker = (latlng) => {
    setSelectedMarker({ position: [latlng.lat, latlng.lng], image: null, text: "" });
  };

  // Handle image upload and marker creation
  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = (event) => {
      setMarkers((prev) => [
        ...prev,
        {
          ...selectedMarker,
          image: event.target.result,
          text: selectedMarker.text || "Nuevo marcador",
        },
      ]);
      setSelectedMarker(null);
    };
    reader.readAsDataURL(file);
  };

  // Handle text change for marker popup
  const handleTextChange = (e) => {
    setSelectedMarker((prev) => ({
      ...prev,
      text: e.target.value,
    }));
  };

  // Handle cancel
  const handleCancel = () => setSelectedMarker(null);

  return (
    <div style={{ position: "relative" }}>
              <div style={{ marginTop: "10px" }}>
        <p>Haz clic en el mapa para añadir un marcador con imagen.</p>
      </div>
      <MapContainer
        center={[41.11905, 1.24544]}
        zoom={13}
        style={{ height: "600px", width: "600px" }}
      >
        <TileLayer
          attribution='&copy; <a href="https://osm.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <AddMarker onAdd={handleAddMarker} />
        {markers.map((marker, idx) => (
          <Marker key={idx} position={marker.position}>
            <Popup>
              {marker.text && <div>{marker.text}</div>}
              {marker.image && (
<img src={marker.image} alt="marker" style={{ maxWidth: "100%", height: "auto", display: "block" }} />              )}
            </Popup>
          </Marker>
        ))}
        {selectedMarker && (
          <Marker position={selectedMarker.position}>
            <Popup>
              <div>
                <input
                  type="text"
                  placeholder="Descripción"
                  value={selectedMarker.text}
                  onChange={handleTextChange}
                  style={{ width: "90%" }}
                />
                <input type="file" accept="image/*" onChange={handleImageChange} />
                <button onClick={handleCancel}>Cancelar</button>
              </div>
            </Popup>
          </Marker>
        )}
      </MapContainer>

    </div>
  );
};

export default MapView;