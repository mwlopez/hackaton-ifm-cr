# Hackaton CR

### Descripción APIs
A continuación se detallan las apis utilizadas en el sistema:

#### Login

Api utilizado para el ingresar al sistema.
* Verbo: POST
* Request
```
{
    "user": "usuario",
    "pass": "1234"
}
```
* Response
```
{
    "id": 1,
    "name": "Marcelo",
    "last_name": "Lopez",
    "area": "1",
    "user": "",
    "pass": ""
}
```

#### Validar Regla
Se utiliza para validar las reglas de negocio basados en los datos del beneficiario.
* Verbo: POST
* Request
```
{
	"numdocumento" : "12345",
	"cuentabanco"  : "kdkdkdkd",
	"programas" : [
		{
			"monto" : 7000,
			"fecha" : 1564541008000,
			"programa" : "AMIGO"
		},
		{
			"monto" : 12345,
			"fecha" : 1564541008000,
			"programa" : "OTRO"
		}
	]
}
```

* Response
  * HttpStatus: 406 Not Acceptable
    * Body:
  ```
  {
    "Message": "La regla ReglaMonto no fue cumplida en el campo Monto con el valor 10000",
    "Estado": "nok"
}
  ```
  * HttpStatus: 202 Acceptable
    * Body:
  ```
  {
    "Estado": "nok"
    }
  ```


#### beneficiario

Api que permite Obtener uno o mas beneficiarios, y los programas asociados a la persona
* Verbo: POST
* Request
```
{
	"num_documento" : "2345678"
}
```
* Response
  * HttpStatus: 202
  * Body

```{
    "nombre": "Pamela",
    "apellido": "Ramirez",
    "num_documento": "2345678",
    "hash": "",
    "beneficio": [
        {
            "nombre": "PANI",
            "estado": "Aceptado",
            "monto": 110000,
            "descripcion": ""
        },
        {
            "nombre": "IMAS",
            "estado": "Rechazada SINPE",
            "monto": 15000,
            "descripcion": ""
        },
        {
            "nombre": "PANI",
            "estado": "Aceptado",
            "monto": 110000,
            "descripcion": ""
        },
        {
            "nombre": "IMAS",
            "estado": "Aceptado",
            "monto": 15000,
            "descripcion": ""
        }
    ],
    "email": "jmelendez112qq025@gmail.com",
    "telefono": ""
}
```

* Verbo: GET
* Response
  * HttpStatus: 202
  * Body:
  ```[
    {
        "id": 0,
        "nombre": "Deanna",
        "apellido": "Gully",
        "num_documento": "2",
        "hash": "",
        "beneficio": [
            {
                "nombre": "CRECEMOS",
                "estado": "Aceptado",
                "monto": 118920,
                "descripcion": ""
            }
        ],
        "email": "dgully1@sourceforge.net",
        "telefono": ""
    },
    {
        "id": 0,
        "nombre": "Pris",
        "apellido": "Cawker",
        "num_documento": "18",
        "hash": "",
        "beneficio": [
            {
                "nombre": "CRECEMOS",
                "estado": "Aceptado",
                "monto": 18049,
                "descripcion": ""
            }
        ],
        "email": "pcawkerh@wunderground.com",
        "telefono": ""
    }
    ]
  ```


### Lista de tareas
- [x] Seguridad
- [x] Logging
- [ ] Trazabilidad
- [x] Integracion Grafana
- [x] Sistema de Cache
- [x] Throtelling
- [x] Black/white list
- [x] Integracion con sistemas externos
- [x] Mensajeria whastsapp.
- [x] Reportes de procesamiento
- [x] Estado de beneficio por ciudadano
- [x] Procesamiento Batch
- [ ] Pubicacion Registry Docker
- [ ] Generacion de Servicios-Deployments-Pods
- [ ] Escalabilidad
