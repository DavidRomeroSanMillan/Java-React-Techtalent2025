use peliculas

db.createCollection('peliculas')

db.peliculas.insertMany(
    [
        {
            _id: 1,
            nombre: 'Sharknado',
            cal_edad: 13
        },
        {
            _id: 2,
            nombre: 'Sharknado 2',
            cal_edad: 0
        },
        {
            _id: 3,
            nombre: 'Sharknado 3D',
            cal_edad: 13
        },
        {
            _id: 4,
            nombre: 'Sharknado 5',
            cal_edad: 3
        },
        {
            _id: 5,
            nombre: 'Sharknado 7',
            cal_edad: 18
        }
    ]
)

db.createCollection('salas')

db.salas.insertMany(
    [
        {
            _id: 1,
            nombre: '4D',
            pelicula: 5
        },
        {
            _id: 2,
            nombre: 'MegaHD',
            pelicula: 4
        },
        {
            _id: 3,
            nombre: 'Dolby',
            pelicula: 2
        },
        {
            _id: 4,
            nombre: 'Averiada'
        },
         {
            _id: 5,
            nombre: 'UltraHD',
            pelicula: 1
        }
    ]
)
