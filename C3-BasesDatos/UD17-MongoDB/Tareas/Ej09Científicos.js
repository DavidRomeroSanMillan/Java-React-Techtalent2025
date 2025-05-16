use cientificos

db.createCollection('cientificos')

db.cientificos.insertMany(
    [
        {
            DNI: '59968772',
            nom_apellidos: 'Pedro Lima Jazmín',
            proyecto: 5001
        },
        {
            DNI: '77489665',
            nom_apellidos: 'Laura González Farala',
            proyecto: 5002
        },
        {
            DNI: '54889751',
            nom_apellidos: 'Zacarías Lubov',
            proyecto: 5001
        },
        {
            DNI: '10039866',
            nom_apellidos: 'Arturo Cañizares Ibáñez',
            proyecto: 5002
        },
        {
            DNI: '24877956',
            nom_apellidos: 'Idoia Balanyà Turull',
            proyecto: 5003
        },
    ]
)

db.createCollection('proyectos')

db.proyectos.insertMany(
    [
        {
            _id: 5001,
            nombre: 'Proteínas',
            horas: 150,
            científicos: [59968772, 54889751]
        },
        {
            _id: 5002,
            nombre: 'Sharknado 12',
            horas: 300,
            científicos: [77489665, 10039866]
        },
        {
            _id: 5003,
            nombre: 'Armas químicas',
            horas: 200,
            científicos: 24877956
        }
    ]
)