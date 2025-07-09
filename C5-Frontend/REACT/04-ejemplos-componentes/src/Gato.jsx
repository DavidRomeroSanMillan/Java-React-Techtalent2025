const Gato = {
  name: "Gato",
  imageUrl:
    "https://imgs.search.brave.com/Xd26-pGxzG5W_CdgpF4oZv69UIKArodOWtbzadZjh6E/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/ZWxnYXRvZmVsaXou/ZXMvd3AtY29udGVu/dC91cGxvYWRzLzIw/MjEvMTAvZmVyb21v/bmFzLXBhcmEtZ2F0/b3M0LmpwZw",
  imageSize: 90,
};

export default function gato() {
  return (
    <>
      <h1>{Gato.name}</h1>
      <img
        className="avatar"
        src={Gato.imageUrl}
        alt={"Foto de " + Gato.name}
        style={{
          width: Gato.imageSize,
          height: Gato.imageSize,
        }}
      />
    </>
  );
}
