use directores

db.createCollection('despachos')

db.despachos.insertMany(
    [
        {
            _id: 1,
            capacidad: 10
        },
     {
            _id: 2,
            capacidad: 12
        },
        {
            _id: 3,
            capacidad: 8
        },
        {
            _id: 4,
            capacidad: 3
        },
        {
            _id: 5,
            capacidad: 5
        },
        {
            _id: 6,
            capacidad: 10
        },
    ]
)

db.createCollection('directores')

db.directores.insertMany(
    [
        {
            DNI: '55120778',
            nom_apellido: 'Jacinto Gómez Sanz',
            despacho: 1
        },
        {
            DNI: '15598337',
            nom_apellido: 'Maite Aragón Pedrera',
            DNI_jefe:'5512778',
            despacho: 2
        },
        {
            DNI: '843259984',
            nom_apellido: 'Karen Gómez Sanz',
            DNI_jefe: '15598337',
            despacho: 3
        },
        {
            DNI: '65874221',
            nom_apellido: 'Fran Manzanedo Pozuelo',
            DNI_jefe: '15598337',
            despacho: 3
        },
        {
            DNI: '42159365',
            nom_apellido: 'Pasquale Matteo Leone',
            DNI_jefe: '65874221',
            despacho: 4
        },
        {
            DNI: '55120778',
            nom_apellido: 'Olga Mar Eivissa',
            DNI_jefe: '15598337',
            despacho: 6
        }
    ]
)
