use piezas

db.createCollection('piezas')

db.piezas.insertMany(
    [
        {
            _id: 1,
            nombre: 'Tuerca 2.5'
        },
        {
            _id: 2,
            nombre: 'Tornillo 3'
        },
        {
            _id: 3,
            nombre: 'Alcayata 2.5'
        },
        {
            _id: 4,
            nombre: 'Anilla 5'
        },
        {
            _id: 5,
            nombre: 'Llave allen 1.5'
        }
    ]
)

db.createCollection('proveedores')

db.proveedores.insertMany(
    [
        {
            _id: 3324,
            nombre: 'Floristería MariPili'
        },
        {
            _id: 1101,
            nombre: 'Ferretería Pepe'
        },
        {
            _id: 1002,
            nombre: 'Duma S.A.'
        },
        {
            _id: 3021,
            nombre: 'Herramientas Paco & Cia'
        }
    ]
)

db.createCollection('suministra')

db.suministra.insertMany(
    [
        {
            id_pieza: 1,
            id_proveedor: 3021,
            precio: 25
        },
        {
            id_pieza: 2,
            id_proveedor: 1101,
            precio: 4
        },        
        {
            id_pieza: 2,
            id_proveedor: 3021,
            precio: 4.5
        },        
        {
            id_pieza: 3,
            id_proveedor: 1002,
            precio: 14
        },        
        {
            id_pieza: 4,
            id_proveedor: 1101,
            precio: 22
        },        
        {
            id_pieza: 5,
            id_proveedor: 3021,
            precio: 2
        },
    ]
)
