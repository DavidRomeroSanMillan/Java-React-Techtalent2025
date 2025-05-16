use grandes_almacenes

db.createCollection('productos')

db.productos.insertMany(
    [
        {
            _id: 1001,
            nombre: 'Patatas',
            precio: 10
        },
        {
            _id: 1002,
            nombre: 'Zanahorias',
            precio: 5.5
        },
        {
            _id: 2001,
            nombre: 'Perfume',
            precio: 45
        },
        {
            _id: 2002,
            nombre: 'Colgante plata',
            precio: 155
        },
        {
            _id: 3001,
            nombre: 'Vestido playa',
            precio: 35
        },
        {
            _id: 3002,
            nombre: 'Pamela',
            precio: 23.95
        },
        {
            _id: 4021,
            nombre: 'Cuaderno dibujo A3',
            precio: 19.99
        },
        {
            _id: 4022,
            nombre: 'Portafolios negro',
            precio: 12.50
        },
    ]
)

db.createCollection('cajeros')

db.cajeros.insertMany(
    [
        {
            _id: 1011,
            nom_apellidos: 'Marcos Jiménez Corto'
        },
        {
            _id: 1012,
            nom_apellidos: 'Aitana Jiménez Corto'
        },
        {
            _id: 2011,
            nom_apellidos: 'Paula Jiménez Corto'
        },
        {
            _id: 3011,
            nom_apellidos: 'Livia Sanz Junio'
        },
        {
            _id: 4011,
            nom_apellidos: 'Marcos Jiménez Pedregol'
        }
    ]
)

db.createCollection('registradoras')

db.registradoras.insertMany(
    [
        {
            _id: 1,
            piso: 1
        },
        {
            _id: 2,
            piso: 1
        },
        {
            _id: 3,
            piso: 2
        },
        {
            _id: 4,
            piso: 3
        },
        {
            _id: 5,
            piso: 4
        },
        {
            _id: 6,
            piso: 4
        }
    ]
)

db.createCollection('venta')

db.venta.insertMany(
    [
        {
            cajero: 1011,
            registradora: 1,
            producto: 2001
        },
        {
            cajero: 1012,
            registradora: 2,
            producto: 3001
        },
        {
            cajero: 3011,
            registradora: 3,
            producto: 4022
        },
        {
            cajero: 3011,
            registradora: 3,
            producto: 4021
        },
        {
            cajero: 2011,
            registradora: 4,
            producto: 1001
        },
        {
            cajero: 1011,
            registradora: 1,
            producto: 1002
        },
        {
            cajero: 4011,
            registradora: 3,
            producto: 2001
        },
        {
            cajero: 2011,
            registradora: 5,
            producto: 3002
        },

    ]
)
