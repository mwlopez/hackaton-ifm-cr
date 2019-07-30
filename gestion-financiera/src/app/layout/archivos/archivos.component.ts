import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { ArchivosService } from '../../../service/archivos.service';

var archivo = null;
var rq = null;

function prepJson() {
    rq = {
        CodigoEntidad: 'sample string 1',
        Pagos: csvToJson(archivo),
    };
    console.log(rq);
}

function csvToJson(csv) {
    var lines = csv.split('\n');

    var result = new Array<any>();

    var headers = [
        'Id',
        'FirstName',
        'LastName',
        'Email',
        'Program',
        'Date',
        'Value',
        'IBAN',
    ];

    for (var i = 1; i < lines.length; i++) {
        var obj = {};
        var currentline = lines[i].split(',');

        for (var j = 0; j < headers.length; j++) {
            if (headers[j] == 'Date') {
                var dvals = currentline[j].split('/');
                var d = new Date(
                    Date.UTC(20 + dvals[2], dvals[0], dvals[1], 0, 0, 0)
                );
                obj[headers[j]] = d.toISOString();
            } else {
                obj[headers[j]] = currentline[j];
            }
        }
        obj['Description'] = '';

        result.push(obj);
    }

    return result; //JavaScript object
    //return JSON.stringify(result); //JSON
}

@Component({
    selector: 'app-archivos',
    templateUrl: './archivos.component.html',
    styleUrls: ['./archivos.component.scss'],
    animations: [routerTransition()],
})
export class ArchivosComponent implements OnInit {
    fileToUpload: File = null;
    result: boolean;

    constructor(private archivossvc: ArchivosService) {}

    ngOnInit() {}

    handleFileInput(files: FileList) {
        this.fileToUpload = files.item(0);

        let fr = new FileReader();
        fr.onload = function(e) {
            archivo = fr.result;
            prepJson();

            var btn = document.getElementById('btnCargar');
            btn.removeAttribute('disabled');
        };
        fr.readAsText(this.fileToUpload);
    }

    cargar() {
        this.archivossvc
            .subirArchivo(rq)
            .toPromise()
            .then(r => {
                this.result = r.Resultado;
            })
            .catch(er => {
                this.result = false;
                console.log(er);
            });

        //this.router.navigate(['/dashboard']);
    }
}
