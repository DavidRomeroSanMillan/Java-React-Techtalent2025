const Hedy = {
  name: "Hedy Lamarr",
  imageUrl: "https://i.imgur.com/yXOvdOSs.jpg",
  imageSize: 90,
};

export default function hedy() {
  return (
    <>
      <h1>{Hedy.name}</h1>
      <img
        className="avatar"
        src={Hedy.imageUrl}
        alt={"Foto de " + Hedy.name}
        style={{
          width: Hedy.imageSize,
          height: Hedy.imageSize,
        }}
      />
    </>
  );
}
