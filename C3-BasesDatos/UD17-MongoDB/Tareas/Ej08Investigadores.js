use investigadores

db.createCollection('facultad')

db.facultad.insertMany(
    [
        {
            _id: 101,
            nombre: 'Educación'
        },
        {
            _id: 102,
            nombre: 'Ingeniería'
        },
        {
            _id: 103,
            nombre: 'Traducción'
        },
        {
            _id: 104,
            nombre: 'Filología'
        },
        {
            _id: 105,
            nombre: 'Filosofía'
        },
        {
            _id: 106,
            nombre: 'Medicina'
        }

    ]
)

db.createCollection('investigadores')

db.investigadores.insertMany(
    [
        {
            DNI: '85947662',
            nom_apellidos: 'Marco Aurelio Castro Manzano',
            facultad: 101
        },
        {
            DNI: '45963758',
            nom_apellidos: 'Paola Schöll',
            facultad: 103
        },
        {
            DNI: '36657495',
            nom_apellidos: 'Tomoko Yoshinori',
            facultad: 102
        },
        {
            DNI: '76599844',
            nom_apellidos: 'Jaime Ruíz Ruíz',
            facultad: 106
        },
        {
            DNI: '22578996',
            nom_apellidos: 'Maribel Campohermoso Valadez',
            facultad: 103
        },
        {
            DNI: '11598774',
            nom_apellidos: 'Alitza Bukharets',
            facultad: 105
        }
    ]
)

db.createCollection('equipos')

db.equipos.insertMany(
    [
        {
            num_serie: 1001,
            nombre: 'Desarrollo Electromecánica',
            facultad: 102
        },
        {
            num_serie: 1002,
            nombre: 'Gnosticismo y sociedad',
            facultad: 105
        },
        {
            num_serie: 1003,
            nombre: 'Lingüística aplicada',
            facultad: 104
        },
        {
            num_serie: 1004,
            nombre: 'Simposio Toxoplasmosis',
            facultad: 106
        }
    ]
)

db.createCollection('reserva')

db.reserva.insertMany(
    [
        {
            DNI: '76599844',
            num_serie: 1004,
            comienzo: 2025-05-21,
            fin: 2025-05-25
        },
        {
            DNI: '11598774',
            num_serie: 1002,
            comienzo: 2025-05-22,
            fin: 2025-05-29
        },
        {
            DNI: '36657495',
            num_serie: 1001,
            comienzo: 2025-06-01,
            fin: 2025-06-08
        },
        {
            DNI: '22578996',
            num_serie: 1003,
            comienzo: 2025-06-10,
            fin: 2025-06-18
        }
        
    ]
)
